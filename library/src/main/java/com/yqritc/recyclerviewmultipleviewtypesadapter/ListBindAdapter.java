package com.yqritc.recyclerviewmultipleviewtypesadapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Adapter class for managing data binders when the order of binder is in sequence
 *
 * Created by yqritc on 2015/03/19.
 */
public class ListBindAdapter extends DataBindAdapter {

    private List<DataBinder> mBinderList = new ArrayList<>();

    @Override
    public int getItemCount() {
        int itemCount = 0;
        for (int i = 0, size = mBinderList.size(); i < size; i++) {
            DataBinder binder = mBinderList.get(i);
            itemCount += binder.getItemCount();
        }
        return itemCount;
    }

    @Override
    public int getItemViewType(int position) {
        int itemCount = 0;
        for (int viewType = 0, size = mBinderList.size(); viewType < size; viewType++) {
            itemCount += mBinderList.get(viewType).getItemCount();
            if (position < itemCount) {
                return viewType;
            }
        }
        throw new IllegalArgumentException("arg position is invalid");
    }

    @Override
    public <T extends DataBinder> T getDataBinder(int viewType) {
        return (T) mBinderList.get(viewType);
    }

    @Override
    public int getPosition(DataBinder binder, int binderPosition) {
        int viewType = mBinderList.indexOf(binder);
        if (viewType < 0) {
            throw new IllegalStateException("binder does not exist in adapter");
        }

        int position = binderPosition;
        for (int i = 0; i < viewType; i++) {
            position += mBinderList.get(i).getItemCount();
        }

        return position;
    }

    @Override
    public int getBinderPosition(int position) {
        int binderItemCount;
        for (int i = 0, size = mBinderList.size(); i < size; i++) {
            binderItemCount = mBinderList.get(i).getItemCount();
            if (position - binderItemCount < 0) {
                break;
            }
            position -= binderItemCount;
        }
        return position;
    }

    @Override
    public void notifyBinderItemRangeChanged(DataBinder binder, int positionStart, int itemCount) {
        notifyItemRangeChanged(getPosition(binder, positionStart), itemCount);
    }

    @Override
    public void notifyBinderItemRangeInserted(DataBinder binder, int positionStart, int itemCount) {
        notifyItemRangeInserted(getPosition(binder, positionStart), itemCount);
    }

    @Override
    public void notifyBinderItemRangeRemoved(DataBinder binder, int positionStart, int itemCount) {
        notifyItemRangeRemoved(getPosition(binder, positionStart), itemCount);
    }

    public List<DataBinder> getBinderList() {
        return mBinderList;
    }

    public void addBinder(DataBinder binder) {
        mBinderList.add(binder);
    }

    public void addAllBinder(List<DataBinder> dataSet) {
        mBinderList.addAll(dataSet);
    }

    public void addAllBinder(DataBinder... dataSet) {
        mBinderList.addAll(Arrays.asList(dataSet));
    }
}
