package com.yqritc.recyclerviewmultipleviewtypesadapter.sample;

import com.yqritc.recyclerviewmultipleviewtypesadapter.sample.adapter.EnumMapAdapter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_main);
        EnumMapAdapter adapter = new EnumMapAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setSample2Data(getSampleData());
    }

    private List<SampleData> getSampleData() {
        List<SampleData> dataSet = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            SampleData data = new SampleData();
            data.mTitle = "View Type 2";
            data.mDrawableResId =
                    getResources().getIdentifier("animal" + i, "drawable", getPackageName());
            data.mContent = "This is sample data for view type 2 - " + i;
            dataSet.add(data);
        }
        return dataSet;
    }
}
