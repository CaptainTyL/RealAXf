package com.example.administrator.realaxf.ui.Base.Home.search;

import android.content.Context;

import com.example.administrator.realaxf.R;
import com.github.library.BaseRecyclerAdapter;
import com.github.library.BaseViewHolder;

import java.util.List;

public class ShopAdpater extends BaseRecyclerAdapter<ShopListBean> {
    public ShopAdpater(Context context, List data, int layoutResId) {
        super(context, data, layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopListBean item) {
        helper.setText(R.id.item_tv_search,item.getShopName());
    }
}
