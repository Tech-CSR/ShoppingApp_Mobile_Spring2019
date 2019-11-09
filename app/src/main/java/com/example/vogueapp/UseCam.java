package com.example.vogueapp;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static android.os.Environment.getExternalStoragePublicDirectory;


public class UseCam extends AppCompatActivity {
    Button btn;
    public static final int STORAGE_PERMISSION=102;
    private final int TAKE_PICTURE= 104;
    ImageView  iv;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(Build.VERSION.SDK_INT >=23){
            requestPermissions(new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE},2);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_cam                                                                                                    );
        startUI();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(intent.resolveActivity(getPackageManager()) != null){
                    File file = null;
                    file = sathwik();
                    if(file != null){
                        path = file.getAbsolutePath();
                        Uri uri = FileProvider.getUriForFile(UseCam.this,"com.example.vogueapp.fileprovider",file);
                        intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
                        startActivityForResult(intent,1);
                    }
                }

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent returnIntent){

        super.onActivityResult(requestCode, resultCode, returnIntent);
        if(resultCode == RESULT_OK){
            if(requestCode == 1){
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                iv.setImageBitmap(bitmap);
            }
        }

    }
    public void startUI(){
        btn = findViewById(R.id.cambtn);
        iv=findViewById(R.id.iv);
    }
    public void clickPic(){
//intent to access the available camaras
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, TAKE_PICTURE);

    }


    private void saveImage(Bitmap finalBitmap){
        // creates the path to store the images externally
        String root = Environment.getExternalStorageState().toString();
        File myDir = new File(root+"//saveImage");
        myDir.mkdir();
        Random generator = new Random();
        int n=10000;
        n= generator.nextInt(n);
        String imageName ="Image  "+n+".jpg";
        File file = new File(myDir, imageName);
        if (file.exists())file.delete();
        try
        {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90,out);
            String resizeCoolerImagePath= file.getAbsolutePath();
            out.flush();
            out.close();
            Toast.makeText(UseCam.this,"Picture is saved", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(UseCam.this,"fail", Toast.LENGTH_SHORT).show();

        }
    }
    public File sathwik(){
        //creating the date formate to store the images details
        String name = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File storageDir = getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = null;
        try{
            image = File.createTempFile(name,".jpg",storageDir);
        }catch (IOException e){

        }
        return image;
    }
}