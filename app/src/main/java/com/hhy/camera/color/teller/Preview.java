package com.hhy.camera.color.teller;

import java.io.IOException;
import java.util.List;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.*;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/*
 * http://www.41post.com/3470/programming/android-retrieving-the-camera-preview-as-a-pixel-array
 * adresinden Dimitri den alınmıştır.
 */
@SuppressWarnings("deprecation")
class Preview extends SurfaceView implements SurfaceHolder.Callback, PreviewCallback {

    public interface PreviewListener {
        void OnPreviewUpdated(int[] pixels, int width, int height);
    }

    PreviewListener listener;
    SurfaceHolder mHolder;
    Camera mCamera = null;
    byte[] buffer;
    int bufferSize;
    int cameraBackId;
    boolean lightOn = false;

    private boolean isPaused = false;

    // this variable is responsible for getting and setting the camera settings
    private Parameters parameters;
    // this variable stores the camera preview size
    private Size previewSize;
    // this array stores the pixels as hexadecimal pairs
    private int[] pixels;

    Preview(Context context) {
        super(context);

        // install a SurfaceHolder.Callback so we get notified when the
        // underlying surface is created and destroyed.
        mHolder = getHolder();
        mHolder.addCallback(this);
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        try {
            // instantiate the EnterColorListener so we can send events to the host
            listener = (PreviewListener) context;
        } catch (ClassCastException e) {
            // the activity doesn't implement the interface, throw exception
            throw new ClassCastException(context.toString() + " must implement PreviewListener");
        }
    }

    public void surfaceCreated(SurfaceHolder holder) {
        // the Surface has been created, acquire the camera and tell it where to draw.
        try {
            cameraBackId = Camera.CameraInfo.CAMERA_FACING_BACK;

            // attempt to get a Camera instance. Use the index b/c front cameras are ok too.
            if (mCamera == null)
                mCamera = Camera.open(cameraBackId);

        }
        catch (Exception e){
            // camera is not available (in use or does not exist)
            //Log.e("camera error", "could not open camera");
            return;
        }
        try {
            mCamera.setDisplayOrientation(90);
            mCamera.setPreviewDisplay(holder);
        } catch (IOException exception) {
            mCamera.release();
            mCamera = null;
        }
    }

    // cheatcoder@github dan alınmıştır.
    // flash açma ve kapama fonksiyonu
    public void flash() {
        if (supportsFlash()) {
            if (!lightOn) {
                lightOn = true;
                mCamera.stopPreview();
                mCamera.setPreviewCallbackWithBuffer(this);
                parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
                mCamera.setParameters(parameters);
                mCamera.startPreview();
            } else {
                lightOn = false;
                mCamera.stopPreview();
                mCamera.setPreviewCallbackWithBuffer(this);
                parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
                mCamera.setParameters(parameters);
                mCamera.startPreview();
            }
        }
    }

    // http://ikravchenko.blogspot.com/2013/09/nexus-7-2013-torch-issue.html
    // adresinden alınmıştır. telefonun flash desteğinin olup olmadığını belirtiyor
    public boolean supportsFlash() {
        if (getContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
            if (mCamera != null) {
                parameters = mCamera.getParameters();
                if (parameters.getFlashMode() != null) {
                    List<String> supportedFlashModes = parameters.getSupportedFlashModes();
                    return !(supportedFlashModes == null || supportedFlashModes.isEmpty() ||
                            supportedFlashModes.size() == 1 && supportedFlashModes.get(0).equals(Parameters.FLASH_MODE_OFF));
                }
            }
        }
        return false;
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        // Surface will be destroyed when we return, so stop the preview.
        // Because the CameraDevice object is not a shared resource, it's very
        // important to release it when the activity is paused.
        if (mCamera != null) {
            mCamera.stopPreview();
            mCamera.setPreviewCallback(null);
            mCamera.release();
            mCamera = null;
        }
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        // Now that the size is known, set up the camera parameters and begin
        // the preview.
        if (mCamera != null) {
            parameters = mCamera.getParameters();

            // http://stackoverflow.com/questions/11623266/camera-parameters-setfocusmode-is-not-working
            // adresindeki kodlardan alınmıştır. autofocus için gerekli parametreleri veriyor.
            List<String> focusModes = parameters.getSupportedFocusModes();
            if (focusModes != null) {
                if (focusModes.contains(Parameters.FOCUS_MODE_CONTINUOUS_PICTURE))
                    parameters.setFocusMode(Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
                else if (focusModes.contains(Parameters.FOCUS_MODE_CONTINUOUS_VIDEO))
                    parameters.setFocusMode(Parameters.FOCUS_MODE_CONTINUOUS_VIDEO);
                else if (focusModes.contains(Parameters.FOCUS_MODE_AUTO))
                    parameters.setFocusMode(Parameters.FOCUS_MODE_AUTO);
            }

            // http://stackoverflow.com/questions/21668394/camera-in-android-how-to-get-best-size-preview-size-picture-size-view-size
            // adresindeki kodlardan alınmıştır. tüm telefonlara uyarlayabilmek için eklenmiştir
            int width = this.getWidth();
            int height = this.getHeight();
            Size best = null;
            List<Camera.Size> previewSizes = parameters.getSupportedPreviewSizes();

            // telefona göre en iyi ayarları bul
            for (int i = 0; i < previewSizes.size(); i++) {
                Size size = previewSizes.get(i);
                if ((size.width <= width && size.height <= height) ||
                        (size.height <= width && size.width <= height))  {
                    if (best == null) {
                        best = size;
                    } else {
                        int resultArea = best.width * best.height;
                        int newArea = size.width * size.height;

                        if (newArea > resultArea) {
                            best = size;
                        }
                    }
                }
            }

            // bir değer seçildiğinden emin ol
            if (best != null) {
                previewSize = best;
            } else {
                previewSize = previewSizes.get(0);
            }

            parameters.setPreviewSize(previewSize.width, previewSize.height);
            pixels = new int[previewSize.width * previewSize.height];
            mCamera.setParameters(parameters);

            // sets the camera callback to be the one defined in this class
            mCamera.setPreviewCallbackWithBuffer(this);
            bufferSize = previewSize.width*previewSize.height*ImageFormat.getBitsPerPixel(
                    parameters.getPreviewFormat())/8;
            buffer = new byte[bufferSize];
            resetBuffer();

            if (!isPaused) mCamera.startPreview();

        }
    }

    // durdurulup devam ettirildiğinde
    public void pause(boolean isPaused) {
        this.isPaused = isPaused;
        if (isPaused) {
            parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
            mCamera.setParameters(parameters);
            mCamera.stopPreview();
        } else {
            if (mCamera != null) {
                mCamera.setPreviewCallbackWithBuffer(this);

                if (lightOn)
                    parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);

                mCamera.setParameters(parameters);
                mCamera.startPreview();
            }
        }
    }

    public void resetBuffer() {
        if (mCamera != null) {
            mCamera.addCallbackBuffer(buffer);
        }
    }


    @Override
    public void onPreviewFrame(byte[] data, Camera camera) {
        // transforms NV21 pixel data into RGB pixels
        decodeYUV420SP(pixels, data, previewSize.width,  previewSize.height);
        listener.OnPreviewUpdated(pixels, previewSize.width, previewSize.height);
    }

    // method from Ketai project! Not mine! See below...
    void decodeYUV420SP(int[] rgb, byte[] yuv420sp, int width, int height) {
        final int frameSize = width * height;

        for (int j = 0, yp = 0; j < height; j++) {
            int uvp = frameSize + (j >> 1) * width, u = 0, v = 0;
            for (int i = 0; i < width; i++, yp++) {
                int y = (0xff & ((int) yuv420sp[yp])) - 16;
                if (y < 0)
                    y = 0;
                if ((i & 1) == 0) {
                    v = (0xff & yuv420sp[uvp++]) - 128;
                    u = (0xff & yuv420sp[uvp++]) - 128;
                }

                int y1192 = 1192 * y;
                int r = (y1192 + 1634 * v);
                int g = (y1192 - 833 * v - 400 * u);
                int b = (y1192 + 2066 * u);

                if (r < 0) r = 0;   else if (r > 262143) r = 262143;
                if (g < 0) g = 0;   else if (g > 262143) g = 262143;
                if (b < 0) b = 0;   else if (b > 262143) b = 262143;

                rgb[yp] = 0xff000000 | ((r << 6) & 0xff0000) | ((g >> 2) & 0xff00) | ((b >> 10) & 0xff);
            }
        }
    }

}  
