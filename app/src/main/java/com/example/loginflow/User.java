package com.example.loginflow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class User extends AppCompatActivity {

    private static ImageView imgView;
    private static Button image_btn;

    private int current_image_index;

    int[] images = {R.mipmap.image_demo , R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        buttonClick();

    }

    public void buttonClick(){
        imgView = (ImageView)findViewById(R.id.imageView);
        image_btn = (Button)findViewById(R.id.image_btn);
        image_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        current_image_index++;
                        current_image_index = current_image_index % images.length;
                        imgView.setImageResource(images[current_image_index]);

                    }
                }
        );
    }
}
