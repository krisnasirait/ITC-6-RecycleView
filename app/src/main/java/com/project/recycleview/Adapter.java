package com.project.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<Crypto> arrayList;

    private onRecycleViewClickListener listener;

    public interface onRecycleViewClickListener{
        void onItemClick(int position);
    }

    public void onRecycleViewClickListener(onRecycleViewClickListener listener){
        this.listener = listener;
    }

    public Adapter(Context context, ArrayList<Crypto> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        return new ViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        Crypto crypto = arrayList.get(position);
        holder.tvname.setText(crypto.cryptoname);
        holder.logo.setImageResource(crypto.cryptologo);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvname;
        ImageView logo;

        public ViewHolder(@NonNull View itemView, onRecycleViewClickListener listener) {
            super(itemView);
            tvname = itemView.findViewById(R.id.name);
            logo = itemView.findViewById(R.id.logo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null && getAdapterPosition() != RecyclerView.NO_POSITION){
                        listener.onItemClick(getAdapterPosition());
                    }
                }
            });
        }
    }
}
