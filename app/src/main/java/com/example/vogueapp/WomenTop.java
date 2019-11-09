package com.example.vogueapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class WomenTop extends AppCompatActivity {
private Button cam;
   // MediaController mediaController;
//    VideoView videoView;
//    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_top);
//
//        play = (Button) findViewById(R.id.play);
//        videoView = (VideoView) findViewById(R.id.videocover);
//        //mediaController = new MediaController(this);
//
//         uri= Uri.parse("android.resource://"+ getCallingPackage() + "/" + R.raw.fashion_men);
//        videoView.setVideoURI(uri);
//playing video with the media controller
        VideoView videoView =findViewById(R.id.videocover);
        String path ="android.resource://" + getPackageName() +"/"+ R.raw.video;
        Uri uri = Uri.parse(path);
        videoView.setVideoURI(uri);//sets the path for the video

        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);
        mc.setAnchorView(videoView);
         cam = (Button) findViewById(R.id.accesscam);
         cam.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(WomenTop.this, UseCam.class);
                 startActivity(intent);

             }
         });


    }


}
