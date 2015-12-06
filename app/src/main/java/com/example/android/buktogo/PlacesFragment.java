package com.example.android.buktogo;

import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
        sendToIntent(mLstAdapter.getItem(position));
    }

    private void sendToIntent(List... items) {
        Intent intent = new Intent(getActivity(), SampleNextPage.class);
        intent.putExtra("passId", items[0].getId());
//        intent.putExtra("passDescription", items[0].getDescription());
        startActivity(intent);
//        Toast.makeText(getActivity(), "value : " + items[0], Toast.LENGTH_SHORT).show();
    }

    private static class LstAdapter extends ArrayAdapter<List> {
        private final List[] data;

        LstAdapter(Context context, List[] items) {
            super(context, R.layout.list_item, R.id.title, items);
            data = items;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final View view = super.getView(position, convertView, parent);
            final TextView subText = (TextView) view.findViewById(R.id.description);
            final ImageView icon = (ImageView) view.findViewById(R.id.icon);
            final List list = data[position];
            subText.setText(list.getDescription());
            icon.setImageResource(R.drawable.places);
            return view;
        }
    }
}
