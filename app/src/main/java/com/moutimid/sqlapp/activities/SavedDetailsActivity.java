package com.moutimid.sqlapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.moutimid.sqlapp.MainActivity;
import com.moutimid.sqlapp.R;
import com.moutimid.sqlapp.helper.DatabaseHelper;

public class SavedDetailsActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    String name, address, details;
    int imageResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        dbHelper = new DatabaseHelper(this);
        Intent intent = getIntent();

        if (intent != null) {
             name = intent.getStringExtra("name");
            address = intent.getStringExtra("address");
             details = intent.getStringExtra("details");
             imageResource = intent.getIntExtra("image", 0);

            TextView textView = findViewById(R.id.text);
            TextView title = findViewById(R.id.title);
            ImageView imageView = findViewById(R.id.img);

            textView.setText(details);
            title.setText(name);
            imageView.setImageResource(imageResource);
        }
    }
    public void BackPress(View view) {
        onBackPressed();
    }

    public void menu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());

        // Optional: Set a listener to respond to menu item clicks
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if ((item.getItemId() == R.id.menu_item_1)) {
                    startActivity(new Intent(SavedDetailsActivity.this, MainActivity.class));
                    finishAffinity();
                }
                return true;
            }
        });

        popupMenu.show();

    }

}