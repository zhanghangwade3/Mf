package com.example.mf;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import adapter.GridAdapter;
import utils.XGridView;

public class MainActivity extends AppCompatActivity {
    XGridView gview;
    ListView list;
    GridAdapter gridAdapter;
    List<String> mDatas = new ArrayList<String>(Arrays.asList("Hello",
            "World", "Welcome","Hello",
            "World", "Welcome"));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list= (ListView) findViewById(R.id.list);
        list.setAdapter(gridAdapter = new GridAdapter(this, mDatas));
        setListViewHeightBasedOnChildren(list);
        gview= (XGridView) findViewById(R.id.gview);
        gridAdapter = new GridAdapter(this,mDatas);
        gview.setAdapter(gridAdapter );
    }

    private void setListViewHeightBasedOnChildren(ListView list) {
        ListAdapter listAdapter = list.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;

        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, list);
            if(listItem != null){
                listItem.measure(0, 0);
                totalHeight += listItem.getMeasuredHeight();
            }
        }
        ViewGroup.LayoutParams params = list.getLayoutParams();
        params.height = totalHeight + (list.getDividerHeight() * (listAdapter.getCount() - 1));
        list.setLayoutParams(params);
    }


}
