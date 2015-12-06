package com.example.android.buktogo;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by jan on 12/1/15.
 */
public class SampleNextPage extends ListActivity {
    LstAdapter mLstAdapter;
    String result, intentValue;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.list_fragment);

        mLstAdapter = new LstAdapter(this, List.baungon);
        setListAdapter(mLstAdapter);
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
            final List list = data[position];
            subText.setText(list.getDescription());
            return view;
        }
    }
}
