package com.example.administrator.realaxf.ui.Base.Home.Fragment;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.aitsuki.swipe.SwipeMenuRecyclerView;
import com.example.administrator.realaxf.R;

import com.example.administrator.realaxf.ui.Base.Adapter.GetShopCarListAdpater;
import com.example.administrator.realaxf.ui.Base.Base.BaseFragment;
import com.example.administrator.realaxf.ui.Base.Home.Bean.DeleteShopBean;
import com.example.administrator.realaxf.ui.Base.Home.Bean.GetShopCarListBean;
import com.example.administrator.realaxf.ui.Base.Home.GoodsOrder.GoodsOrderActivity;
import com.example.administrator.realaxf.ui.Base.okhttputils.OkHttpHelper;
import com.example.administrator.realaxf.ui.Base.okhttputils.SpotsCallBack;
import com.google.gson.Gson;
import com.squareup.okhttp.Response;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;


public class ShopCarFragment extends BaseFragment implements GetShopCarListAdpater.setCheckBox, GetShopCarListAdpater.DeleteOnClick, GetShopCarListAdpater.setAddIcon, GetShopCarListAdpater.setJianIcon {
    /**
     * 在前面商品添加成功后，
     * 通过接口请求，获得购物车商品列表
     * 将获得的数据与SwipeItemLayout相适配
     */
    //得到Okhttp
    OkHttpHelper okHttpHelper = OkHttpHelper.getInstance();
    //得到购物车商品列表控件
    @BindView(R.id.swip_car_shoplist)
    SwipeMenuRecyclerView swipCarShoplist;
    //得到全选框
    @BindView(R.id.check_car_all)
    CheckBox checkCarAll;
    //商品总价
    @BindView(R.id.tv_car_totalPrice)
    TextView tvCarTotalPrice;
    //得到选好了按钮
    @BindView(R.id.tv_car_selectOk)
    TextView tvCarSelectOk;
    //使用List存放购物车商品信息
    List<GetShopCarListBean.DataBean> list = new ArrayList<>();
    //声明列表布局管理
    LinearLayoutManager linearLayoutManager1;
    //适配器
    private GetShopCarListAdpater getShopCarListAdpater;
    //全选是否选中的标识
    boolean isAllchack = false;
    //获取商品的数量
    int goodsNumber;
    //单个商品的总价
    int oneTotalPrice = 0;
    //多个商品的总价
    int manyTotalPrice = 0;
    //定义存放一个商品信息的Map
    Map map;
    //定义存放多个商品信息（map）的list
    List shopMapList;
    //定义Gson
    Gson gson;
    //商品的json字符串
    String  jsonStringData;
    @Override
    public void init() {


        linearLayoutManager1 = new LinearLayoutManager(getActivity());
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        getShopCarListAdpater = new GetShopCarListAdpater(list);
        getShopCarListData(true);
        getShopCarListAdpater.setOnCheck(this);
        getShopCarListAdpater.setDelete(this);
        getShopCarListAdpater.setAdd(this);
        getShopCarListAdpater.setJian(this);
    }

    //控制Fragment使他再打开时走这个方法
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        getShopCarListData(false);
        manyTotalPrice = 0;
        tvCarTotalPrice.setText(manyTotalPrice + "");
        //全选不选中
        isAllchack = false;
        checkCarAll.setChecked(false);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_car;
    }

    //请求购物车数据
    private void getShopCarListData(boolean b) {
        SharedPreferences sp = getActivity().getSharedPreferences("Data", Context.MODE_PRIVATE);
        String userId = sp.getString("userId", "1");
        String url = "http://questionnaire.dzqcedu.com:81/Shop/cartlist";
        Map<String, String> map = new HashMap<>();
        map.put("userId", userId);
        okHttpHelper.post(url, map, new SpotsCallBack<GetShopCarListBean>(getActivity(), b) {
            @Override
            public void onSuccess(Response response, GetShopCarListBean getShopCarListBean) throws ParseException {
                if (getShopCarListBean.getData() != null) {
                    list.clear();
                    list.addAll(getShopCarListBean.getData());
                    getShopCarListAdpater.notifyDataSetChanged();
                    swipCarShoplist.setLayoutManager(linearLayoutManager1);
                    //禁止滑动
                    swipCarShoplist.setNestedScrollingEnabled(false);
                    //绑定适配器
                    swipCarShoplist.setAdapter(getShopCarListAdpater);
                }
            }

            @Override
            public void onError(Response response, int code, Exception e) {

            }
        });
    }

    //全选点击事件
    @OnClick({R.id.check_car_all,R.id.tv_car_selectOk})
    void onclick(View view) {
        switch (view.getId()) {
            case R.id.check_car_all:
                isAllchack = !isAllchack;
                setCheckCarAll();
                break;
            case R.id.tv_car_selectOk:
                becomeJsonData();
                if (shopMapList.size()>0){
                    Intent intent=new Intent(getActivity(),GoodsOrderActivity.class);
                    intent.putExtra("jsonStr",jsonStringData);
                    startActivity(intent);
                }

                break;
        }
    }

    //单击复选框回调事件
    @Override
    public void onCheckClick(int i) {
        list.get(i).setCheck(!list.get(i).isCheck());
        isAllSeleclt();
        //点击单选框时候计算价格，选中的时候把总价给下面
        if (list.get(i).isCheck()) {
            //单个商品的价格
            int goodsPrice = Integer.parseInt(list.get(i).getVipprice());
            //单个商品的数量
            goodsNumber = Integer.parseInt(list.get(i).getCommoditynumber());
            //计算单个商品的总价
            oneTotalPrice = goodsPrice * goodsNumber;
            //累加勾选中的每一个商品的总价
            manyTotalPrice = manyTotalPrice + oneTotalPrice;
            tvCarTotalPrice.setText(manyTotalPrice + "");
        } else if (list.get(i).isCheck() == false) {
            //单个商品的价格
            int goodsPrice = Integer.parseInt(list.get(i).getVipprice());
            //单个商品的数量
            goodsNumber = Integer.parseInt(list.get(i).getCommoditynumber());
            //计算单个商品的总价
            oneTotalPrice = goodsPrice * goodsNumber;
            manyTotalPrice = manyTotalPrice - oneTotalPrice;
            tvCarTotalPrice.setText(manyTotalPrice + "");
        }
        getShopCarListAdpater.notifyDataSetChanged();


    }

    //判断是否全选
    private void isAllSeleclt() {
        for (int i = 0; i < list.size(); i++) {
            //遍历判断是否被选中
            if (!list.get(i).isCheck()) {
                isAllchack = false;
                checkCarAll.setChecked(false);
                return;
            }
        }
        isAllchack = true;
        checkCarAll.setChecked(true);
    }

    //点击全选商品全选
    private void setCheckCarAll() {
        manyTotalPrice = 0;
        for (int i = 0; i < list.size(); i++) {
            if (isAllchack) {
                list.get(i).setCheck(true);
                //点击全选时计算总价
                //找到单价
                int oncePrice = Integer.parseInt(list.get(i).getVipprice());
                //得到数量
                int goodsNumber = Integer.parseInt(list.get(i).getCommoditynumber());
                //得到总价
                int totalPrice = oncePrice * goodsNumber;
                manyTotalPrice = totalPrice + manyTotalPrice;
                tvCarTotalPrice.setText(manyTotalPrice + "");
            } else {
                list.get(i).setCheck(false);
                manyTotalPrice = 0;
                tvCarTotalPrice.setText(manyTotalPrice + "");
            }
        }
        getShopCarListAdpater.notifyDataSetChanged();

    }


    //点击删除按钮
    @Override
    public void onDeleteClick(int i) {
        setDialog(i);

    }

    //调用接口请求删除
    private void getDeleteShopListData(String commodityId) {
        SharedPreferences sp = getActivity().getSharedPreferences("Data", Context.MODE_PRIVATE);
        String userId = sp.getString("userId", "1");
        String url = "http://questionnaire.dzqcedu.com:81/Shop/delcart";
        Map<String, String> map = new HashMap<>();
        map.put("userId", userId);
        map.put("commodityId", commodityId);
        okHttpHelper.post(url, map, new SpotsCallBack<DeleteShopBean>(getActivity(), false) {
            @Override
            public void onSuccess(Response response, DeleteShopBean deleteShopBean) throws ParseException {
                if (deleteShopBean.getResult() == 1) {
                    getShopCarListData(true);
                    manyTotalPrice = 0;
                    tvCarTotalPrice.setText(manyTotalPrice + "");
                    isAllchack = false;
                    checkCarAll.setChecked(false);
                    getShopCarListAdpater.notifyDataSetChanged();
                } else {
                    getShopCarListData(true);
                }
            }

            @Override
            public void onError(Response response, int code, Exception e) {

            }
        });
    }

    //删除时提示弹框
    private void setDialog(final int j) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("提示");
        dialog.setMessage("确定删除所选的商品？");
        dialog.setCancelable(false);
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getShopCarListData(true);
            }
        });
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getDeleteShopListData(list.get(j).getCommodityid());
            }
        });
        dialog.show();
    }

    //加号的回调函数
    @Override
    public void setAddOnClick(int i) {
        goodsNumber = Integer.parseInt(list.get(i).getCommoditynumber());
        goodsNumber++;
        list.get(i).setCommoditynumber(goodsNumber + "");
        getShopCarListAdpater.notifyDataSetChanged();
        setPrice(i);
    }
    //加减改变价格

    private void setPrice(int i) {
        //获得单价
        int goodsVipPrice = Integer.parseInt(list.get(i).getVipprice());
        //进行计算
        //选中的时候把总价给下面
        if (list.get(i).isCheck()) {
            int onePrice = goodsVipPrice;
            manyTotalPrice = manyTotalPrice + onePrice;
            tvCarTotalPrice.setText(manyTotalPrice + "");
        }
        getShopCarListAdpater.notifyDataSetChanged();
    }

    //减号点击
    @Override
    public void setJianOnClick(int i) {
        goodsNumber = Integer.parseInt(list.get(i).getCommoditynumber());
        if (goodsNumber == 1) {
            list.get(i).setCommoditynumber("1");
            Toast.makeText(getActivity(), "商品不能在减少了", Toast.LENGTH_SHORT).show();
        } else {
            goodsNumber--;
            list.get(i).setCommoditynumber(goodsNumber + "");
            setJianPrice(i);
        }
        getShopCarListAdpater.notifyDataSetChanged();
    }

    //点击减号时选中的价格改变
    private void setJianPrice(int i) {
        //获得当前商品的单价
        int goodsPrice = Integer.parseInt(list.get(i).getVipprice());
        if (list.get(i).isCheck()) {
            manyTotalPrice = manyTotalPrice - goodsPrice;
            tvCarTotalPrice.setText(manyTotalPrice + "");
        }
        getShopCarListAdpater.notifyDataSetChanged();
    }
    //将选中的商品信息变成json数据
    private void becomeJsonData(){
        shopMapList=new ArrayList();
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i).isCheck()){
                //如果被选中的商品
                //将商品的基本信息放在Map集合中
                map=new HashMap();
                map.put("goodsSmallImg",list.get(i).getSmallcommodityimage());
                map.put("goodsName",list.get(i).getCommoditytitle());
                map.put("goodsId", list.get(i).getCommodityid());
                map.put("goodsPrice", list.get(i).getVipprice());
                map.put("goodsNumber", list.get(i).getCommoditynumber());
                shopMapList.add(map);
                gson=new Gson();
                //使用Gson自带方法把List集合变成json字符串
                jsonStringData=gson.toJson(shopMapList);
            }else{
//                //如果选中被取消选中，则把未选中的map从list集合中删除
//                map=new HashMap();
//                map.put("goodsSmallImg",list.get(i).getSmallcommodityimage());
//                map.put("goodsName",list.get(i).getCommoditytitle());
//                map.put("goodsId", list.get(i).getCommodityid());
//                map.put("goodsPrice", list.get(i).getVipprice());
//                map.put("goodsNumber", list.get(i).getCommoditynumber());
//                shopMapList.remove(map);

            }
        }
    }
}
