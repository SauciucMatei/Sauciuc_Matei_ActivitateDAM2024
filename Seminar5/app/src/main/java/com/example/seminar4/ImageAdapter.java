package com.example.seminar4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private List<ImaginiDomeniu> imagini;
    private Context ctx;
    private int resursaLayout;

    public ImageAdapter(Context ctx, int layoutRes, List<ImaginiDomeniu> imaginiItems) {
        this.ctx = ctx;
        this.resursaLayout = layoutRes;
        this.imagini = imaginiItems;
    }

    @Override
    public int getCount() {
        return imagini.size();
    }

    @Override
    public Object getItem(int position) {
        return imagini.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(resursaLayout, parent, false);

        ImaginiDomeniu item = imagini.get(position);

        ImageView img = v.findViewById(R.id.imagineIV);
        img.setImageBitmap(item.getImagine());

        return v;


    }
}
