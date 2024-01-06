package com.moutimid.sqlapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.moutimid.sqlapp.R;
import com.moutimid.sqlapp.adapter.CustomListAdapter;
import com.moutimid.sqlapp.helper.DataModel;
import com.moutimid.sqlapp.helper.DatabaseHelper;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class SavedDataActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    ArrayList<DataModel> dataList;
    CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_data);

        dbHelper = new DatabaseHelper(this);
        dataList = dbHelper.getAllData();

        ListView listView = findViewById(R.id.listView);
        adapter = new CustomListAdapter(this, dataList);
        listView.setAdapter(adapter);
    }
    public void BackPress(View view) {
        onBackPressed();
    }
}
