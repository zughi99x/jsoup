package com.example.jsoup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapterListview extends BaseAdapter {
    ArrayList<TiengAnh> arrayListTiengAnh;
    Context context;

    public CustomAdapterListview(ArrayList<TiengAnh> arrayListTiengAnh, Context context) {
        this.arrayListTiengAnh = arrayListTiengAnh;
        this.context = context;
    }

    @Override

    public int getCount() {
        return arrayListTiengAnh.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListTiengAnh.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.dong_listview,null);
        TextView txtTenkhoahoc=(TextView)convertView.findViewById(R.id.txtTenKhoahoc);
        ImageView imgHinhanh=(ImageView)convertView.findViewById(R.id.imgHinhanh);

        TiengAnh tiengAnh=(TiengAnh)getItem(position);
        txtTenkhoahoc.setText(tiengAnh.Tenkhoahoc);
        Picasso.with(context).load(tiengAnh.HinhAnh).into(imgHinhanh);
        return convertView;


    }
}
