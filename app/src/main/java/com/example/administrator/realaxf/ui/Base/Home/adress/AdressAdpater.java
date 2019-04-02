package com.example.administrator.realaxf.ui.Base.Home.adress;

import android.content.Context;

import com.example.administrator.realaxf.R;
import com.github.library.BaseRecyclerAdapter;
import com.github.library.BaseViewHolder;

import java.util.List;

public class AdressAdpater extends BaseRecyclerAdapter<CityBean> {


    public AdressAdpater(Context context, List data, int layoutResId) {
        super(context, data, layoutResId);
    }

    /**
     * 设置布局
     * @param helper
     * @param item
     */
    @Override
    protected void convert(BaseViewHolder helper, CityBean item) {
        helper.setText(R.id.item_tv_cityName,item.getCityName());
    }
}
