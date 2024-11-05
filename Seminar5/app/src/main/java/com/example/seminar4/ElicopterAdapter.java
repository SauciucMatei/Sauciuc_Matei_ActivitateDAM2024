package com.example.seminar4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ElicopterAdapter extends BaseAdapter {
    private List<Elicopter> elicoptere;
    private Context ctx;
    private int resursaLayout;

    public ElicopterAdapter(List<Elicopter> elicoptere, Context ctx, int resursaLayout) {
        this.elicoptere = elicoptere;
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return elicoptere.size();
    }

    @Override
    public Object getItem(int position) {
        return elicoptere.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(resursaLayout, parent, false);

        TextView producator = v.findViewById(R.id.numeProducator);
        TextView pret = v.findViewById(R.id.pret);
        TextView autonomie = v.findViewById(R.id.autonomie);
        TextView nrLocuri = v.findViewById(R.id.numarLocuri);
        TextView dataFabricatie = v.findViewById(R.id.data);
        TextView nou = v.findViewById(R.id.tip);

        Elicopter elicopter = (Elicopter)getItem(position);

        producator.setText(elicopter.getProducator());
        pret.setText(String.valueOf(elicopter.getPret()));
        autonomie.setText(String.valueOf(elicopter.getAutonomie_Mile()));
        nrLocuri.setText(String.valueOf(elicopter.getNumarLocuri()));

        return v;




    }
}
