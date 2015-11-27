package com.example.android.buktogo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by jan on 11/10/15.
 */
public class MapFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // inflate and return the layout
        View v = inflater.inflate(R.layout.activity_map_fragment, container, false);
        return v;
    }
}
