package com.example.imageupload;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.imageupload.ui.ItemAdapter;
import com.example.imageupload.ui.Item;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

// User flow
// 1. user opens app
// 2. user clicks "select image"
// 3. gallery opens
// 4. users picks an image
// 5. image shows up on screen



public class MainActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    Button deleteButton;
    Button addButton;
    ItemAdapter adapter;
    List<Item> checklist;

    // override - when the activity starts, run the code to set up the screen
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // super (oop) (inherit from parent class)
        // run OnCreate() version from AppCompatActivity before running new code
        super.onCreate(savedInstanceState);
        // links Java to your XML layout
        setContentView(R.layout.activity_main);

        // connect the variables to the views in XML
//        imageView = findViewById(R.id.imageView);
//        selectImageButton = findViewById(R.id.selectImageButton);
        // text view goes here

        // recycler view
        recyclerView = findViewById(R.id.recyclerViewChecklist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // dynamic list of items with assigned text fields
        checklist = new ArrayList<>();
        checklist.add(new Item("Headset", false));
        checklist.add(new Item("Push to talk dongle (PTT)", false));
        checklist.add(new Item("TAK server running", false));
        checklist.add(new Item("USB-C adapter", false));
        checklist.add(new Item("Bump helmet", false));
        checklist.add(new Item("Ice Cream", false));
        checklist.add(new Item("Morty", false));
        checklist.add(new Item("Morty joystick", false));
        checklist.add(new Item("Orb", false));
        checklist.add(new Item("ASN", false));
        checklist.add(new Item("Parrot", false));
        checklist.add(new Item("Headset", false));
        checklist.add(new Item("Push to talk dongle (PTT)", false));
        checklist.add(new Item("TAK server running", false));
        checklist.add(new Item("USB-C adapter", false));
        checklist.add(new Item("Bump helmet", false));
        checklist.add(new Item("Ice Cream", false));
        checklist.add(new Item("Morty", false));
        checklist.add(new Item("Morty joystick", false));
        checklist.add(new Item("Orb", false));
        checklist.add(new Item("ASN", false));
        checklist.add(new Item("Parrot", false));

        // adapter being set to recycler view
        adapter = new ItemAdapter(checklist);
        recyclerView.setAdapter(adapter);

        // delete button included in activity layout
        Button deleteButton = findViewById(R.id.action_delete);
        deleteButton.setOnClickListener(v -> {
            // Remove all checked items
            for (int i = checklist.size() - 1; i >= 0; i--) { // iterate backwards
                if (checklist.get(i).isChecked()) {
                    checklist.remove(i);
                    adapter.notifyItemRemoved(i);
                }
            }
        });

        // add button included in activity layout
        Button addButton = findViewById(R.id.action_add);
        addButton.setOnClickListener(v -> {
            // Create a new item with default text
            Item newItem = new Item("New Item", false);

            // Add it to the checklist
            checklist.add(newItem);

            // Notify adapter
            adapter.notifyItemInserted(checklist.size() - 1);

            // Scroll to the new item
            recyclerView.scrollToPosition(checklist.size() - 1);
        });
    }
}
