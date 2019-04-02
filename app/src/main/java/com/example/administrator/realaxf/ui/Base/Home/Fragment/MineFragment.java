package com.example.administrator.realaxf.ui.Base.Home.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.realaxf.R;

import com.example.administrator.realaxf.ui.Base.Base.BaseFragment;
import com.example.administrator.realaxf.ui.Base.Home.order.OrderActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MineFragment extends BaseFragment {
    @BindView(R.id.tv_mine_checkList)
    TextView tvMineCheckList;
    @BindView(R.id.re_mine_pay)
    RelativeLayout reMinePay;
    @BindView(R.id.re_mine_recycive)
    RelativeLayout reMineRecycive;
    @BindView(R.id.re_mine_talk)
    RelativeLayout reMineTalk;
    @BindView(R.id.re_mine_saleAfter)
    RelativeLayout reMineSaleAfter;
    //用户头像
    @BindView(R.id.girl)
    ImageView imagHead;
    @BindView(R.id.tv_mine_userName)
    TextView tvMineUserName;
    @Override
    public void init() {
        SharedPreferences sp=getContext().getSharedPreferences("Data",Context.MODE_PRIVATE);
        String imgHead=sp.getString("userIcon","1");
        String userName=sp.getString("userName","1");
        Log.e("手机号",userName );
        Glide.with(getActivity()).load(imgHead).into(imagHead);
        tvMineUserName.setText(userName);

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @OnClick({R.id.tv_mine_checkList, R.id.re_mine_pay, R.id.re_mine_recycive, R.id.re_mine_talk, R.id.re_mine_saleAfter})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_mine_checkList:
                setIntent("all");
                break;
            case R.id.re_mine_pay:
                setIntent("pay");
                break;
            case R.id.re_mine_recycive:
                setIntent("recycive");
                break;
            case R.id.re_mine_talk:
                setIntent("talk");
                break;
            case R.id.re_mine_saleAfter:
                setIntent("saleAfter");
                break;

        }
    }

    private void setIntent(String str) {
        Intent intent = new Intent(getActivity(), OrderActivity.class);
        intent.putExtra("type", str);
        startActivity(intent);
    }
}
