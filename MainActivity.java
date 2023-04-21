package com.example.mediaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button play;
    private Button pause;
    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=findViewById(R.id.play);
        pause=findViewById(R.id.pause);
        seekBar=findViewById(R.id.seekBar);
     // mediaplayer creat a local source
      MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.odhani);
        // mediaplayer using Remote source
//        try {
//            mediaPlayer.setDataSource("http://penguinradio.dominican.edu/Sound%20FX%20Collection/Cat%20meow%201.mp3");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

          seekBar.setMax(mediaPlayer.getDuration());
          seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
              @Override
              public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                  if(fromUser) {
                      mediaPlayer.seekTo(progress);
                  }
              }

              @Override
              public void onStartTrackingTouch(SeekBar seekBar) {

              }

              @Override
              public void onStopTrackingTouch(SeekBar seekBar) {

              }
          });
        mediaPlayer.start();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mediaPlayer.start();

           }
       });
       pause.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                mediaPlayer.pause();

           }
       });

    }
}