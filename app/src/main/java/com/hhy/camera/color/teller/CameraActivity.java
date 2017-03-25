package com.hhy.camera.color.teller;

import com.hhy.camera.color.teller.Preview.PreviewListener;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

// kamera aktivite sınıfı
public class CameraActivity extends MenuActivity implements PreviewListener {
    // kamera preview classı
    private Preview mPreview;
    // durduruldu mu?
    private boolean isPaused = false;
    // renkleri yazan yerler
    private TextView colorView1;
    private TextView colorView2;
    // menü için
    private Menu menu;
    // renklerin dosyadan alındığı sınıf için
    private ColorData cdata;
    // kamera kısmı ve radius tanımlaması
    private int radius = 5;
    private OutlineDrawableView centerView;
    private int cX;
    private int cY;
    // durdurulduğundaki piksel
    private int[] pausedPixels = null;
    // durdurulduğundaki yükseklik ve genişlik
    private int pausedWidth;
    private int pausedHeight;

    // renk aralığı için sensivity tanımla
    private int sensitivity = 5;

    // sesleri çalmak için mediaplayer oluştur
    MediaPlayer mediaPlayer = new MediaPlayer();

    // şuanki renk ve en yakın renk kodları
    String currentColor;
    String currentNamedColor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        // renk sınıfını al
        cdata = new ColorData(this);

        // renklerin yazıldığı yerler
        colorView1 = (TextView) findViewById(R.id.camera_result1_textview);
        colorView2 = (TextView) findViewById(R.id.camera_result2_textview);
        
        // kamera preview için
        mPreview = new Preview(this);
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(mPreview);

        // orta kamera alanı
        LinearLayout centerLayout = (LinearLayout) findViewById(R.id.camera_activity_center);
        centerView = new OutlineDrawableView(this, radius);
        centerLayout.addView(centerView);

        // kamera alanına tek tap ve çift tap tanımlamaları
        centerLayout.setOnTouchListener(new View.OnTouchListener() {
            private GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
                @Override
                // tek tap da rengi söyle
                public boolean onSingleTapConfirmed(MotionEvent event) {
                    // rengi söyle
                    playSound(cdata.getColorName(currentNamedColor));
                    return true;
                }
                @Override
                // çift tapda flashı aç kapa
                public boolean onDoubleTap(MotionEvent event) {
                    flash();
                    return true;
                }
            });
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });

        // dp ye çevirme işlemi ve (x,y) tanımlaması
        radius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, radius, getResources().getDisplayMetrics());
        cX = 2 * radius;
        cY = 2 * radius;

        // telefonu uyanık tutmak için = ekran kararmasın diye
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
    
    @Override
    // ortadaki rengi alan kareyi yapmak için
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        cX = centerView.getWidth() / 2;
        cY = centerView.getHeight() / 2;
        centerView.move(cX, cY);
        centerView.invalidate();
    }

    // renk seslerini çalması için
    public void playSound(String colorName) {
        if (colorName != null) {
            try {
                // mediaplayeri durdur kaldır ve yeniden oluştur
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = new MediaPlayer();

                // gelen dosya ismine göre ses dosyasını çal
                String fileName = cdata.changeFileName(colorName);
                AssetFileDescriptor descriptor = getResources().openRawResourceFd(getResources().getIdentifier(fileName, "raw", getPackageName()));
                mediaPlayer.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
                descriptor.close();
                // sesi çalması için hazırla
                mediaPlayer.prepare();
                // sesi çal
                mediaPlayer.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    // flash destekleyen telefonlarda flashı açıp kapama
    protected void flash() {
        // flash destegi var mı?
        if (mPreview.supportsFlash()) {
            mPreview.resetBuffer();
            mPreview.flash();

            // flash simgesini ve yazısını değiştir
            if (mPreview.lightOn) {
                //menu.getItem(0).setIcon(getResources().getDrawable(R.mipmap.hhy_flash_off));
                menu.getItem(0).setIcon(R.mipmap.hhy_flash_off);
                menu.getItem(0).setTitle(R.string.menu_flash_off);
            } else {
                //menu.getItem(0).setIcon(getResources().getDrawable(R.mipmap.hhy_flash_on));
                menu.getItem(0).setIcon(R.mipmap.hhy_flash_on);
                menu.getItem(0).setTitle(R.string.menu_flash_on);
            }
        }
    }

    @Override
    // uygulama devam ettiğinde
    public void onResume() {
        super.onResume();
        // durdurulduysa devam ettir
        if (isPaused) pause();
    }

    @Override
    // geri tuşuna bastığında uygulamadan çık
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    // uygulama kapatıldığında
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    // menü oluşturma sınıfı
    public boolean onCreateOptionsMenu(Menu menu) {
        // menu xml ini tanımla
        getMenuInflater().inflate(R.menu.activity_camera, menu);
        // menuyu ata
        this.menu = menu;
        // flash destegi yoksa flash butonunu kaldır
        if (!mPreview.supportsFlash()) {
            menu.removeItem(R.id.menu_flash);
        }
        return true;
    }

    // rengi değiştir
    private void updateColors() {
        int red = 0;
        int green = 0;
        int blue = 0;
        int scaleX = pausedHeight / 2;
        int scaleY = pausedWidth / 2;

        for (int i = scaleX - sensitivity; i < scaleX + sensitivity; i++) {
            for (int j = scaleY - sensitivity; j < scaleY + sensitivity; j++) {
                int index = (i * pausedWidth) + j;
                int pixel = pausedPixels[index];
                red += Color.red(pixel);
                green += Color.green(pixel);
                blue += Color.blue(pixel);
            }
        }
        int color = Color.rgb((int) (red / (1.0 * (2 * sensitivity) * (2 * sensitivity))), (int) (green / (1.0 * (2 * sensitivity) * (2 * sensitivity))), (int) (blue / (1.0 * (2 * sensitivity) * (2 * sensitivity))));
        int[] col = {Color.red(color), Color.green(color), Color.blue(color)};

        // rengi bul
        currentColor = cdata.ColorToString(col);
        currentNamedColor = cdata.closestColor(col);
        boolean isDarkColor = cdata.isDarkColor(col);
        // rengi yazdır
        colorView1.setBackgroundColor(color);
        colorView1.setText(getText(R.string.you_chose) + " " + currentColor);
        // 2. alana rengin adını yazdır
        colorView2.setBackgroundColor(Color.parseColor(currentNamedColor));
        if (colorView2.getTag().equals("layout") || colorView2.getTag().equals("layout-small"))
            colorView2.setText(("" + cdata.getColorName(currentNamedColor) + "    " + "(" + currentNamedColor + ")"));
        else
            colorView2.setText("" + cdata.getColorName(currentNamedColor) + '\n' + "(" + currentNamedColor + ")");

        // yazı rengini arkaplan rengine göre beyaz ya da siyah yap
        if (isDarkColor) {
            colorView1.setTextColor(Color.WHITE);
            colorView2.setTextColor(Color.WHITE);
        } else {
            colorView1.setTextColor(Color.BLACK);
            colorView2.setTextColor(Color.BLACK);
        }
    }
    
    @Override
    // uygulama tekrar açıldığında güncelle
    public void OnPreviewUpdated(int[] pixels, int width, int height) {
        if (pixels != null) {
            this.pausedPixels = pixels;
            this.pausedWidth = width;
            this.pausedHeight = height;
            
            // rengi gündelle
            updateColors();

            // durdurulmadıysa
            if (!isPaused) {
                // bufferı temizle
                mPreview.resetBuffer();
            }
        }
    }

    // durdurup tekrar calıstırma
    public void pause() {
        isPaused = !isPaused;
        mPreview.pause(isPaused);
        // rengi güncelle
        updateColors();
        // durdurulmadıysa
        if (!isPaused) {
            // bufferı temizle
            mPreview.resetBuffer();
        }
    }

}
