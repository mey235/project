package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.BaseAdapter;

public class customadapter extends BaseAdapter {
    Context context;
    int flags[];
    String[] countryNames;
    String[] country;
    LayoutInflater inflter;


    public customadapter(Context applicationContext, int[] flags, String[] countryNames,String[] country) {

        this.context = applicationContext;
        this.flags = flags;
        this.countryNames = countryNames;
        this.country = country;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return flags.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.spinner_custom, null);
        ImageView icon = (ImageView) view.findViewById(R.id.imageView);
        TextView names = (TextView) view.findViewById(R.id.textView);
        TextView countrys = (TextView) view.findViewById(R.id.textView2);
        icon.setImageResource(flags[i]);

        names.setText(countryNames[i]);
        countrys.setText(country[i]);


        return view;
    }
}

