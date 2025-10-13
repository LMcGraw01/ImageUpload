package com.example.imageupload;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

// User flow
// 1. user opens app
// 2. user clicks "select image"
// 3. gallery opens
// 4. users picks an image
// 5. image shows up on screen

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button selectImageButton;

    // launches the "image upload"
    private final ActivityResultLauncher<String> pickImage =
            registerForActivityResult(new ActivityResultContracts.GetContent(), uri -> {
                if (uri != null) {
                    // show image in the ImageView
                    imageView.setImageURI(uri);
                } else {
                    // small popup message that appears on screen briefly to show feedback to user
                    // msg: "no image selected"
                    Toast.makeText(this, "No image selected", Toast.LENGTH_SHORT).show();
                }
            });
    // override - when the activity starts, run the code to set up the screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // super (oop) (inherit from parent class)
        // run OnCreate() version from AppCompatActivity before running new code
        super.onCreate(savedInstanceState);
        // links Java to your XML layout
        setContentView(R.layout.activity_main);

        // connect the variables to the views in XML
//        imageView = findViewById(R.id.imageView);
//        selectImageButton = findViewById(R.id.selectImageButton);
        // text view goes here

        // when the button is clicked, open the gallery
        selectImageButton.setOnClickListener(v -> pickImage.launch("image/*"));
    }
}