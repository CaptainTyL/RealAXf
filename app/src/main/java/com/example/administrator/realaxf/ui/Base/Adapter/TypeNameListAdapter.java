package com.example.administrator.realaxf.ui.Base.Adapter;

import android.content.Context;

import com.example.administrator.realaxf.R;
import com.example.administrator.realaxf.ui.Base.Home.Bean.TejiaShopListBean;
import com.github.library.BaseRecyclerAdapter;
import com.github.library.BaseViewHolder;

import java.util.List;


public class TypeNameListAdapter extends BaseRecyclerAdapter<TejiaShopListBean.GoodstypeBean> {
    //设置为零显示第一个
    private int defaultSelection = 0;
    private List<TejiaShopListBean.GoodstypeBean> list;

    public TypeNameListAdapter(Context context, List<TejiaShopListBean.GoodstypeBean> data) {
        super(context, data, R.layout.item_shoptypelist);
        list=data;
    }

    @Override
    protected void convert(BaseViewHolder helper, TejiaShopListBean.GoodstypeBean item) {
            helper.setText(R.id.tv_class_typeName,item.getTypename());
            if (helper.getPosition()==defaultSelection){//选中时候
                helper.setVisible(R.id.view_line,true);
                helper.setBackgroundColor(R.id.re_shoptype_name,mContext.getResources().getColor(R.color.color_background));

            }else{
                helper.setVisible(R.id.view_line,false);
                helper.setBackgroundColor(R.id.re_shoptype_name,mContext.getResources().getColor(R.color.white));
            }
    }
    public void setSelectPosition(int i) {
        if (!(i < 0 || i > list.size())) {
            defaultSelection = i;
            notifyDataSetChanged();
        }
    }
}
