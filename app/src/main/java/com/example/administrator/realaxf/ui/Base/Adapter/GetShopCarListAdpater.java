package com.example.administrator.realaxf.ui.Base.Adapter;


import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;

import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.realaxf.R;
import com.example.administrator.realaxf.ui.Base.Home.Bean.GetShopCarListBean;

import java.util.List;

public class GetShopCarListAdpater extends BaseQuickAdapter<GetShopCarListBean.DataBean, BaseViewHolder> {
    private setCheckBox listener;
    private DeleteOnClick deleteOnClick;
    private setAddIcon setAddIcon;
    private setJianIcon setJianIcon;

    public GetShopCarListAdpater(@Nullable List<GetShopCarListBean.DataBean> data) {
        super(R.layout.item_shop, data);
    }


    @Override
    protected void convert(final BaseViewHolder helper, final GetShopCarListBean.DataBean item) {
        Glide.with(mContext).load(item.getSmallcommodityimage()).into((ImageView) helper.getView(R.id.img_shop));
        helper.setChecked(R.id.checkbox_shop, item.isCheck());
        helper.setText(R.id.tv_item_shop_name, item.getCommoditytitle());
        helper.setText(R.id.tv_item_shop_number, item.getCommoditynumber() + "");
        helper.setText(R.id.tv_item_shop_price, item.getVipprice());

        //单选
        helper.setOnClickListener(R.id.checkbox_shop, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCheckClick(helper.getPosition());
            }
        });
        //删除按钮
        helper.setOnClickListener(R.id.right_menu, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteOnClick.onDeleteClick(helper.getPosition());
            }
        });
        //加号
        helper.setOnClickListener(R.id.tv_jia, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAddIcon.setAddOnClick(helper.getPosition());
            }
        });
        //减号
        helper.setOnClickListener(R.id.tv_jian, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setJianIcon.setJianOnClick(helper.getPosition());
            }
        });
    }


    //单选回调函数
    public interface setCheckBox {
        void onCheckClick(int i);
    }

    public void setOnCheck(setCheckBox listener) {
        this.listener = listener;
    }

    //删除回调
    public interface DeleteOnClick {
        void onDeleteClick(int i);
    }

    public void setDelete(DeleteOnClick deleteOnClick) {
        this.deleteOnClick = deleteOnClick;
    }

    //加的回调函数
    public interface setAddIcon {
        void setAddOnClick(int i);
    }

    public void setAdd(setAddIcon setAddIcon) {
        this.setAddIcon = setAddIcon;
    }

    //减的回调函数
    public interface setJianIcon {
        void setJianOnClick(int i);
    }

    public void setJian(GetShopCarListAdpater.setJianIcon setJianIcon) {
        this.setJianIcon = setJianIcon;
    }
}
