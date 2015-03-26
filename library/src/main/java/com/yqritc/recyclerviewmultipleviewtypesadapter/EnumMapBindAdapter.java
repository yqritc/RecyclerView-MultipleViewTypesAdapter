package com.yqritc.recyclerviewmultipleviewtypesadapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Adapter class for managing data binders by mapping enum view type and data binder
 *
 * Created by yqritc on 2015/03/25.
 */
public abstract class EnumMapBindAdapter<E extends Enum<E>> extends DataBindAdapter {

    private Map<E, DataBinder> mBinderMap = new HashMap<>();

    @Override
    public int getItemCount() {
        int itemCount = 0;
        for (DataBinder binder : mBinderMap.values()) {
            itemCount += binder.getItemCount();
        }
        return itemCount;
    }

    @Override
    public int getItemViewType(int position) {
        return getEnumItemViewType(position).ordinal();
    }

    @Override
    public <T extends DataBinder> T getDataBinder(int viewType) {
        return getDataBinder(getEnum(viewType));
    }

    @Override
    public abstract int getPosition(DataBinder binder, int binderPosition);

    @Override
    public abstract int getBinderPosition(int position);

    public abstract E getEnumItemViewType(int position);

    public abstract E getEnum(int ordinal);

    public <T extends DataBinder> T getDataBinder(E e) {
        return (T) mBinderMap.get(e);
    }

    public E getEnum(DataBinder binder) {
        for (Map.Entry<E, DataBinder> entry : mBinderMap.entrySet()) {
            if (entry.getValue().equals(binder)) {
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException("Invalid Data Binder");
    }

    public Map<E, DataBinder> getBinderMap() {
        return mBinderMap;
    }

    public void put(E e, DataBinder binder) {
        mBinderMap.put(e, binder);
    }

    public void remove(E e) {
        mBinderMap.remove(e);
    }

    public void clear() {
        mBinderMap.clear();
    }
}
