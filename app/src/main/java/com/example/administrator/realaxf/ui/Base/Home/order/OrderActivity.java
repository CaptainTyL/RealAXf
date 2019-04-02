package com.example.administrator.realaxf.ui.Base.Home.order;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.administrator.realaxf.R;
import com.example.administrator.realaxf.ui.Base.Base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class OrderActivity extends BaseActivity {
    //得到按钮布局
    @BindView(R.id.re_order_all)
    RelativeLayout reOrderAll;
    @BindView(R.id.re_order_pay)
    RelativeLayout reOrderPay;
    @BindView(R.id.re_order_reycive)
    RelativeLayout reOrderReycive;
    @BindView(R.id.re_order_talk)
    RelativeLayout reOrderTalk;
    @BindView(R.id.re_order_saleAfter)
    RelativeLayout reOrderSaleAfter;
    //得到下划线 进行颜色控制
    @BindView(R.id.view_order_line_all)
    View viewOrderLineAll;
    @BindView(R.id.view_order_line_pay)
    View viewOrderLinePay;
    @BindView(R.id.view_order_line_reycive)
    View viewOrderLineReycive;
    @BindView(R.id.view_order_line_talk)
    View viewOrderLineTalk;
    @BindView(R.id.view_order_line_sale)
    View viewOrderLineSale;
    //找到返回的按钮
    @BindView(R.id.img_order_back)
    ImageView imgOrderBack;
    @Override
    public void init() {
        setFinsh(imgOrderBack);
        Intent intent = getIntent();
        String str = intent.getStringExtra("type");
        if (str.equals("all")) {
            setLine(viewOrderLineAll, viewOrderLinePay, viewOrderLineReycive, viewOrderLineTalk, viewOrderLineSale);
        }else if (str.equals("pay")){
            setLine(viewOrderLinePay, viewOrderLineAll, viewOrderLineReycive, viewOrderLineTalk, viewOrderLineSale);
        }else if (str.equals("recycive")){
            setLine(viewOrderLineReycive, viewOrderLineAll, viewOrderLinePay, viewOrderLineTalk, viewOrderLineSale);
        }else if(str.equals("talk")){
            setLine(viewOrderLineTalk, viewOrderLineAll, viewOrderLineReycive, viewOrderLinePay, viewOrderLineSale);
        }else if (str.equals("saleAfter")){
            setLine(viewOrderLineSale, viewOrderLineAll, viewOrderLineReycive, viewOrderLineTalk, viewOrderLinePay);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_order;
    }

    @OnClick({R.id.re_order_all, R.id.re_order_pay, R.id.re_order_reycive, R.id.re_order_talk, R.id.re_order_saleAfter})
    void onclick(View v) {
        switch (v.getId()) {
            case R.id.re_order_all:
                setLine(viewOrderLineAll, viewOrderLinePay, viewOrderLineReycive, viewOrderLineTalk, viewOrderLineSale);
                break;
            case R.id.re_order_pay:
                setLine(viewOrderLinePay, viewOrderLineAll, viewOrderLineReycive, viewOrderLineTalk, viewOrderLineSale);
                break;
            case R.id.re_order_reycive:
                setLine(viewOrderLineReycive, viewOrderLineAll, viewOrderLinePay, viewOrderLineTalk, viewOrderLineSale);
                break;
            case R.id.re_order_talk:
                setLine(viewOrderLineTalk, viewOrderLineAll, viewOrderLineReycive, viewOrderLinePay, viewOrderLineSale);
                break;
            case R.id.re_order_saleAfter:
                setLine(viewOrderLineSale, viewOrderLineAll, viewOrderLineReycive, viewOrderLineTalk, viewOrderLinePay);
                break;
        }
    }

    private void setLine(View view, View view1, View view2, View view3, View view4) {
        view.setVisibility(View.VISIBLE);
        view1.setVisibility(View.GONE);
        view2.setVisibility(View.GONE);
        view3.setVisibility(View.GONE);
        view4.setVisibility(View.GONE);
    }
}
