package com.hhy.camera.color.teller;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.WindowManager;

public class MainPermissionActivity extends Activity {
    // android 6 ve sonrasında izin isteme
    private final int PERMISSIONS_REQUEST_CAMERA = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // fullscreen yapmak için
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        // android 6 ve sonrası için izin isteme olayı
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermission();
        } else {
            // android 2.3 - 5 arası direk uygulamaya geç
            Intent intent = new Intent(this, CameraActivity.class);
            startActivity(intent);
        }

        // telefonu uyanık tutmak için = ekran kararmasın diye
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
    @Override
    // uygulama devam ettiğinde
    public void onResume() {
        super.onResume();
        // izinleri tekrar kontrol et
        requestPermission();
    }
    @Override
    // android 6 ve sonrası için izin isteme
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_CAMERA:
                // izin verdiyse
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // direk kameraya geç
                    Intent intent = new Intent(this, CameraActivity.class);
                    startActivity(intent);
                } else {
                    // kabul etmesi için dialog fonksiyonuna git
                    requestPermissionFromSettings();
                }
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    // izin iste
    private void requestPermission() {
        // camera izni için
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            // daha önce soruldu ve izin vermediyse
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                // kabul etmesi için dialog fonksiyonuna git
                requestPermissionFromSettings();
            } else {
                // ilk istemede soruyor sadece
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA}, PERMISSIONS_REQUEST_CAMERA);
            }
        } else {
            // daha önce izin verildiyse direk uygulamaya geç
            Intent intent = new Intent(this, CameraActivity.class);
            startActivity(intent);
        }
    }
    // dialog oluştur izin için
    private void requestPermissionFromSettings() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.camera_permission)
                .setMessage(R.string.camera_permission_text)
                .setPositiveButton(R.string.go_settings, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // izin vermesi için ayarlara götür
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                        intent.setData(uri);
                        startActivityForResult(intent, PERMISSIONS_REQUEST_CAMERA);
                    }
                })
                .setNegativeButton(R.string.exit, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // uygulmadan çık
                        finish();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}