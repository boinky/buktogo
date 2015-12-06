package com.example.android.buktogo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jan on 12/3/15.
 */
public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder> {
    private static ArrayList<ItemProperties> dataSet;

    public CardViewAdapter(ArrayList<ItemProperties> items) {
        dataSet = items;
    }

    @Override
    public CardViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, null);

        // create ViewHolder
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewAdapter.ViewHolder viewHolder, int i) {
        ItemProperties ip = dataSet.get(i);

        viewHolder.tvVersionName.setText(ip.getTitle());
        viewHolder.iconView.setImageResource(ip.getThumbnail());
        viewHolder.Item = ip;
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvVersionName;
        public ImageView iconView;

        public ItemProperties Item;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            tvVersionName = (TextView) itemLayoutView.findViewById(R.id.title);
            iconView = (ImageView) itemLayoutView.findViewById(R.id.icon);

            itemLayoutView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent = new Intent(v.getContext(), SecondPage.class);
//                    v.getContext().startActivity(intent);
                    Toast.makeText(v.getContext(), "os version is: " + Item.getId(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
