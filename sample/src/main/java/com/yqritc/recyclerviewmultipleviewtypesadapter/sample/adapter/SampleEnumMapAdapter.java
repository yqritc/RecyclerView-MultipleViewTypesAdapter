package com.yqritc.recyclerviewmultipleviewtypesadapter.sample.adapter;


import com.yqritc.recyclerviewmultipleviewtypesadapter.EnumMapBindAdapter;
import com.yqritc.recyclerviewmultipleviewtypesadapter.sample.SampleData;
import com.yqritc.recyclerviewmultipleviewtypesadapter.sample.binder.Sample1Binder;
import com.yqritc.recyclerviewmultipleviewtypesadapter.sample.binder.Sample2Binder;
import com.yqritc.recyclerviewmultipleviewtypesadapter.sample.binder.Sample3Binder;

import java.util.List;

/**
 * Created by yqritc on 2015/03/20.
 */
public class SampleEnumMapAdapter extends EnumMapBindAdapter<SampleEnumMapAdapter.SampleViewType> {

    enum SampleViewType {
        SAMPLE1, SAMPLE2, SAMPLE3
    }

    public SampleEnumMapAdapter() {
        putBinder(SampleViewType.SAMPLE1, new Sample1Binder(this));
        putBinder(SampleViewType.SAMPLE2, new Sample2Binder(this));
        putBinder(SampleViewType.SAMPLE3, new Sample3Binder(this));
    }

    public void setSample2Data(List<SampleData> dataSet) {
        ((Sample2Binder) getDataBinder(SampleViewType.SAMPLE2)).addAll(dataSet);
    }

    @Override
    public SampleViewType getEnumFromPosition(int position) {
        if (position == 1) {
            return SampleViewType.SAMPLE1;
        } else if (position == 3) {
            return SampleViewType.SAMPLE3;
        } else {
            return SampleViewType.SAMPLE2;
        }
    }

    @Override
    public SampleViewType getEnumFromOrdinal(int ordinal) {
        return SampleViewType.values()[ordinal];
    }
}
