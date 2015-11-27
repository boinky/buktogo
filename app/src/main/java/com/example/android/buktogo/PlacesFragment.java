package com.example.android.buktogo;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.mapswithme.maps.api.MWMPoint;

/**
 * Created by jan on 11/3/15.
 */
public class PlacesFragment extends ListFragment implements AdapterView.OnItemClickListener {
    LstAdapter mLstAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment, null, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mLstAdapter = new LstAdapter(getActivity(), List.ITEMS);
        setListAdapter(mLstAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        showCityOnMWMMap(mLstAdapter.getItem(position));
    }

    private void showCityOnMWMMap(List... items) {
        MWMPoint[] points = new MWMPoint[items.length];
        for (int i = 0; i < items.length; i++)
            points[i] = items[i].toMWMPoint();

        final String title = items.length == 1 ? items[0].getName() : "Capitals of the World";
        //MapsWithMeApi.showPointsOnMap(getActivity(), title, points);
        Toast.makeText(getActivity(), "value : " + items.length, Toast.LENGTH_SHORT).show();
    }

    private static class LstAdapter extends ArrayAdapter<List> {
        //private final List[] data;

        LstAdapter(Context context, List[] items) {
            super(context, R.layout.list_item, R.id.title, items);
            //data = items;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final View view = super.getView(position, convertView, parent);
            //final List item = data[position];
            return view;
        }
    }


}
