package com.example.android.buktogo;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * Created by jan on 11/3/15.
 */
public class AdventureFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<ItemProperties> item;
    private RecyclerView.Adapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_view, null, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        final String[] title = {"Baungon", "Cabanglasan", "Damulog", "Dangcagan",
                "Don Carlos", "Impasug-ong", "Kadingilan", "Kalilangan",
                "Kibawe", "Lantapan", "Libona", "Malaybalay", "Maramag", "Malitbog",
                "Manolo Fortich", "Pangantucan", "Quezon", "San Fernando", "Sumilao",
                "Talakag", "Valencia"};

        final int[] id = {2116650, 2116651, 2116652, 2116653,
                2116654, 2116655, 2116656, 2116657, 2116658,
                2116659, 2116660, 2116661, 2116662, 2116663,
                2116664, 2116665, 2116666, 2116667, 2116668,
                2116669, 2116670
        };

        final int icons = R.drawable.adventure;

        item = new ArrayList<>();

        for (int i = 0; i < title.length; i++) {
            ItemProperties Item = new ItemProperties();

            Item.setTitle(title[i]);
            Item.setId(id[i]);
            Item.setThumbnail(icons);
            item.add(Item);
        }

        recyclerView.setHasFixedSize(true);

        // ListView
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // create an Object for Adapter
        mAdapter = new CardViewAdapter(item);

        // set the adapter object to the Recyclerview
        recyclerView.setAdapter(mAdapter);
    }

}
