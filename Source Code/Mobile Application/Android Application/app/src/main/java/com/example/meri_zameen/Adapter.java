package com.example.meri_zameen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    ArrayList<SavedValuesModel> arrayList;
    Context context;

    public Adapter(ArrayList<SavedValuesModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.saved_sensor_values_layout, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SavedValuesModel model = arrayList.get(position);
        holder.phValue.setText(model.getpH());
        holder.ecValue.setText(model.getEC());
        holder.hValue.setText(model.getHumidity());
        holder.tValue.setText(model.getTemperature());
        holder.kValue.setText(model.getK());
        holder.nValue.setText(model.getN());
        holder.pValue.setText(model.getP());
        holder.time.setText(model.getTime());
        holder.id.setText(model.getSampleID());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView pValue, phValue, ecValue, nValue, kValue, hValue, tValue, time, id;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            phValue = itemView.findViewById(R.id.phValue);
            pValue = itemView.findViewById(R.id.pValue);
            ecValue = itemView.findViewById(R.id.ecValue);
            kValue = itemView.findViewById(R.id.kValue);
            hValue = itemView.findViewById(R.id.hValue);
            tValue = itemView.findViewById(R.id.tValue);
            nValue = itemView.findViewById(R.id.nValue);
            time = itemView.findViewById(R.id.time);
            id = itemView.findViewById(R.id.sampleID);

        }
    }
}
