package com.example.administrator.realaxf.ui.Base.Home.GoodsOrder;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.realaxf.R;
import com.github.library.BaseRecyclerAdapter;
import com.github.library.BaseViewHolder;

import java.util.List;

public class GoodsOrderAdpater extends BaseRecyclerAdapter<GoodsOrderDataBean.DataBean> {

    public GoodsOrderAdpater(Context context, List data) {
        super(context, data, R.layout.item_verifyorder);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsOrderDataBean.DataBean item) {
        Glide.with(mContext).load(item.getGoodsSmallImg()).into((ImageView)helper.getView(R.id.verify_order));
        helper.setText(R.id.verift_tv,item.getGoodsName()+"" );
    }
}
