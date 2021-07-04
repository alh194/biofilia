package com.example.biofilia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etxt_nombre = (EditText) findViewById(R.id.etxt_nombre);
        Button btn_video = (Button) findViewById(R.id.btn_video);
        String name = etxt_nombre.getText().toString();

        //Activar botón de "Ir al vídeo" sólo cuando se inserte nombre
        /*if(name.trim().equals("")){
            btn_video.setEnabled(false);
            Toast.makeText(this, "Introduce nombre", Toast.LENGTH_SHORT).show();
            return;
        }else{
            btn_video.setEnabled(true);
        }*/


        //Crear Toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        myToolbar.setTitle("Proyecto biofilia");
        myToolbar.inflateMenu(R.menu.toolbar);
        myToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()==R.id.item_volver){
                    Intent home = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(home);
                }
                return false;
            }
        });
    }




    public void int_VideoActivity(View view) {
        Intent intent = new Intent(MainActivity.this, VideoActivity.class);
        startActivity(intent);
    }
}