package com.example.lesson6;

import android.content.Context;
import android.icu.text.Transliterator;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>
{
    private List<String> localData;
    private final LayoutInflater layoutInflater;
    public Adapter(Context context, List<String> data) {
        this.localData = data;
        this.layoutInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    //преобразование разметки
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
        layoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String s = localData.get(position);
    holder.description.setText(s);
    }


    @Override
    public int getItemCount() {
        return localData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            description = itemView.findViewById(R.id.textViewDescription);
        }
    }
}
