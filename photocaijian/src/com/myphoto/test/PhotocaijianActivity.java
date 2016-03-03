package com.myphoto.test;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PhotocaijianActivity extends Activity {
    /** Called when the activity is first created. */
    
    private Button mbutton;
    private ImageView mimage;
    private final int DATE=1;
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mbutton=(Button) findViewById(R.id.photobutton1);
        mbutton.setOnClickListener(new Button.OnClickListener(){

			
			public void onClick(View v) {
				Intent intent=new Intent(Intent.ACTION_GET_CONTENT,null);
				intent.setType("image/*");
				intent.putExtra("crop", "true");
				intent.putExtra("aspectX", 1);
				intent.putExtra("aspectY", 1);
				intent.putExtra("outputX", 80);
				intent.putExtra("outoutY", 80);
				intent.putExtra("return-data", true);
				startActivityForResult(intent, 1);
				
				
			
				
			}
        	
        });
        mimage=(ImageView) findViewById(R.id.photoimage1);
        
        mimage.setOnClickListener(new ImageView.OnClickListener(){

			public void onClick(View v) {
			
			}
		
        	
        } ); 
        
        
    }

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==RESULT_OK)
		{
			if(requestCode==1)
			{
				Bitmap mbitmap=data.getParcelableExtra("data");
				mimage.setImageBitmap(mbitmap);
			}
		}
	}
    
    
    
    
}