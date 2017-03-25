package com.hhy.camera.color.teller;

import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

// menü sınıfı
public class MenuActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    // menüyü oluştur
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_camera, menu);

        return true;
    }

    @Override
    // menüde tıklanan seye göre ne calısacak
    public boolean onOptionsItemSelected(MenuItem item) {
        // aktivite değiştirmek için intent tanımla
        Intent intent;
        // tıklanan id ye göre bak
        switch (item.getItemId()) {
            case R.id.menu_info:
                // bilgiler aktivitesine geç
                intent = new Intent(this, InfoActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_settings:
                return true;
            case android.R.id.home:
                // kamera aktivitesine geç
                intent = new Intent(this, CameraActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            case R.id.menu_flash:
                // flash aç kapa
                flash();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void flash() {
    }
}
