package com.example.finalyearproject;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Callback;


public class ListViewAdapter extends ArrayAdapter<Activities> {

    Context context;
    int resource;
    List<Activities> activity_list;

    public ListViewAdapter(Context context, int resource, List<Activities> activity_list) {
        super(context, resource, activity_list);
        this.context=context;
        this.resource=resource;
        this.activity_list=activity_list;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource,null);
        TextView name = view.findViewById(R.id.activity_name);
        TextView area = view.findViewById(R.id.activity_area);
        TextView desc = view.findViewById(R.id.activity_desc);
        ImageView image = view.findViewById(R.id.activity_image);

        Activities activities = activity_list.get(position);
        name.setText(activities.getName());
        area.setText(activities.getArea());
        desc.setText(activities.getDescription());
        image.setImageDrawable(context.getResources().getDrawable(activities.getImage()));

        return view;

    }
}
