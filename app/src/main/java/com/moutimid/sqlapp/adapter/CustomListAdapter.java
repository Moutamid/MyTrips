package com.moutimid.sqlapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.moutimid.sqlapp.R;
import com.moutimid.sqlapp.activities.DetailsActivity;
import com.moutimid.sqlapp.activities.SavedDataActivity;
import com.moutimid.sqlapp.activities.SavedDetailsActivity;
import com.moutimid.sqlapp.helper.DataModel;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<DataModel> dataList;

    public CustomListAdapter(Context context, ArrayList<DataModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.list_item_layout, parent, false);

        ImageView imageView = itemView.findViewById(R.id.imageView);
        TextView textView = itemView.findViewById(R.id.textView);
        TextView textView1 = itemView.findViewById(R.id.textView1);

        DataModel data = dataList.get(position);
        imageView.setImageResource(data.getImage());
        textView.setText(data.getName());
        textView1.setText(data.getAddress());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SavedDetailsActivity.class);
                intent.putExtra("name", data.getName());
                intent.putExtra("address", data.getAddress());
                intent.putExtra("details", data.getDetails());
                intent.putExtra("image", data.getImage());
                context.startActivity(intent);
            }
        });
        return itemView;
    }
}


