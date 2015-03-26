package com.yqritc.recyclerviewmultipleviewtypesadapter.sample.adapter;


import com.yqritc.recyclerviewmultipleviewtypesadapter.DataBinder;
import com.yqritc.recyclerviewmultipleviewtypesadapter.EnumMapBindAdapter;
import com.yqritc.recyclerviewmultipleviewtypesadapter.sample.SampleData;
import com.yqritc.recyclerviewmultipleviewtypesadapter.sample.binder.Sample1Binder;
import com.yqritc.recyclerviewmultipleviewtypesadapter.sample.binder.Sample2Binder;
import com.yqritc.recyclerviewmultipleviewtypesadapter.sample.binder.Sample3Binder;

import java.util.List;

/**
 * Created by yqritc on 2015/03/20.
 */
public class EnumMapAdapter extends EnumMapBindAdapter<EnumMapAdapter.SampleViewType> {

    enum SampleViewType {
        SAMPLE1, SAMPLE2, SAMPLE3
    }

    public EnumMapAdapter() {
        put(SampleViewType.SAMPLE1, new Sample1Binder(this));
        put(SampleViewType.SAMPLE2, new Sample2Binder(this));
        put(SampleViewType.SAMPLE3, new Sample3Binder(this));
    }

    public void setSample2Data(List<SampleData> dataSet) {
        ((Sample2Binder) getDataBinder(SampleViewType.SAMPLE2)).addAll(dataSet);
    }

    @Override
    public SampleViewType getEnumItemViewType(int position) {
        if (position == 1) {
            return SampleViewType.SAMPLE1;
        } else if (position == 3) {
            return SampleViewType.SAMPLE3;
        } else {
            return SampleViewType.SAMPLE2;
        }
    }

    @Override
    public int getPosition(DataBinder binder, int binderPosition) {
        switch (getEnum(binder)) {
            case SAMPLE1:
                return 1;
            case SAMPLE2:
                if (binderPosition == 0) {
                    return 0;
                } else if (binderPosition == 1) {
                    return 2;
                } else {
                    return 2 + binderPosition;
                }
            case SAMPLE3:
                return 3;
        }
        throw new IllegalArgumentException("Invalid Arguments");
    }

    @Override
    public int getBinderPosition(int position) {
        switch (getEnumItemViewType(position)) {
            case SAMPLE1:
            case SAMPLE3:
                return 0;
            case SAMPLE2:
                if (position == 0) {
                    return 0;
                } else if (position == 2) {
                    return 1;
                } else {
                    return position - 2;
                }
        }
        throw new IllegalArgumentException("Invalid Argument");
    }

    @Override
    public SampleViewType getEnum(int ordinal) {
        return SampleViewType.values()[ordinal];
    }
}
