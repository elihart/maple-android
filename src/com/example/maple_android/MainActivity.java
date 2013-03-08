package com.example.maple_android;

import java.io.ByteArrayOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	
	private static final int CAMERA_REQUEST = 1888;
    
    private ImageView imageView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
    	Log.d("MapleSyrup", "Receiving image");
    	
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {  
        	
        	// Load bitmap into byteArray so that we can pass the data to the new Activity
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            
            photo.compress(Bitmap.CompressFormat.JPEG, 90, stream);
            byte[] photoByteArray = stream.toByteArray();
            
           
            
            Intent intent = new Intent(this, EditorActivity.class);
            
            intent.putExtra("photoByteArray", photoByteArray);
            startActivity(intent);
            
        }
    } 
    
    public void openCamera(View view) {
    	Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
     
        startActivityForResult(intent, CAMERA_REQUEST);
    	
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
