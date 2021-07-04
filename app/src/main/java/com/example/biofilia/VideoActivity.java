package com.example.biofilia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        //Crear menú
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        myToolbar.setTitle("Proyecto biofilia");
        myToolbar.inflateMenu(R.menu.toolbar);
        myToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()==R.id.item_volver){
                    Intent home = new Intent(VideoActivity.this, MainActivity.class);
                    startActivity(home);
                }
                return false;
            }
        });

        //Declarar botones e invisibilizarlos
        ImageButton img_happyness = (ImageButton) findViewById(R.id.img_happyness);
        ImageButton img_sadness = (ImageButton) findViewById(R.id.img_sadness);
        ImageButton img_scared = (ImageButton) findViewById(R.id.img_scared);
        img_happyness.setVisibility(View.INVISIBLE);
        img_sadness.setVisibility(View.INVISIBLE);
        img_scared.setVisibility(View.INVISIBLE);
        img_happyness.setOnClickListener(this);
        img_sadness.setOnClickListener(this);
        img_scared.setOnClickListener(this);

        //Crear video e insertar controles
        VideoView videoView = (VideoView) findViewById(R.id.videoView);  //casting to VideoView is not Strictly required above API level 26
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video1); //set the path of the video that we need to use in our VideoView
        MediaController mediaController = new MediaController(this); //link mediaController to videoView
        mediaController.setAnchorView(videoView); //allow mediaController to control our videoView
        videoView.setMediaController(mediaController);
        videoView.start();  //start() method of the VideoView class will start the video to play
        //Mostrar botones cuando finalice el vídeo
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                img_happyness.setVisibility(View.VISIBLE);
                img_sadness.setVisibility(View.VISIBLE);
                img_scared.setVisibility(View.VISIBLE);

            }
        });
    }

    private void onMenuItemSelected(Toolbar.OnMenuItemClickListener onMenuItemClickListener) {
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_happyness:
                Toast t_happyness = Toast.makeText(getApplicationContext(),"Felicidad",Toast.LENGTH_SHORT);
                t_happyness.show();
                break;
            case R.id.img_sadness:
                Toast t_sadness = Toast.makeText(getApplicationContext(),"Tristeza",Toast.LENGTH_SHORT);
                t_sadness.show();
                break;
            case R.id.img_scared:
                Toast t_scared = Toast.makeText(getApplicationContext(),"Miedo",Toast.LENGTH_SHORT);
                t_scared.show();
                break;
        }
    }
}