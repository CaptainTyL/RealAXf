package com.example.administrator.realaxf.ui.Base.Home.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.realaxf.R;

import com.example.administrator.realaxf.ui.Base.Adapter.ClassShopListAdpater;
import com.example.administrator.realaxf.ui.Base.Adapter.TypeNameListAdapter;
import com.example.administrator.realaxf.ui.Base.Base.BaseFragment;
import com.example.administrator.realaxf.ui.Base.Home.Bean.TejiaShopListBean;
import com.example.administrator.realaxf.ui.Base.Home.adress.AdressActivty;
import com.example.administrator.realaxf.ui.Base.Home.commodityDetails.GoodsDetailsActivity;
import com.example.administrator.realaxf.ui.Base.Home.search.SearchActivity;
import com.example.administrator.realaxf.ui.Base.okhttputils.OkHttpHelper;
import com.example.administrator.realaxf.ui.Base.okhttputils.SpotsCallBack;
import com.github.library.listener.OnRecyclerItemClickListener;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ClassifyFragment extends BaseFragment {
    private OkHttpHelper okHttpHelper = OkHttpHelper.getInstance();
    @BindView(R.id.tv_classify_address)
    TextView tvClassifyAddress;
    @BindView(R.id.img_classify_sousuo)
    ImageView imgClassifySousuo;
    //左侧RecycleView控件
    @BindView(R.id.rely_class_shopTypeName)
    RecyclerView relyClassShopTypeName;
    //右侧recycleView控件
    @BindView(R.id.rely_class_shopList)
    RecyclerView relyClassShopList;
    @BindView(R.id.tv_class_sort_zonghe)
    TextView tvClassSortZonghe;
    @BindView(R.id.tv_class_sort_sale)
    TextView tvClassSortSale;
    @BindView(R.id.tv_class_sort_price)
    TextView tvClassSortPrice;
    @BindView(R.id.swip_class_right)
    SwipeRefreshLayout swipClassRight;
    //左侧商品类型的适配器
    private TypeNameListAdapter typeNameListAdapter;
    private LinearLayoutManager linearLayoutManager;
    //右侧商品适配器
    private ClassShopListAdpater classShopListAdpater;
    private LinearLayoutManager linearLayoutManagerRight;
    //将实体类存放在列表中
    List<TejiaShopListBean.GoodstypeBean> shopTypeList = new ArrayList<>();
    //将右侧商品存放在列表中
    List<TejiaShopListBean.DataBean> classShopList = new ArrayList<>();
    String sortingType1="1";
    String typeid="1";
    @Override
    public void init() {
        //左侧商品类型管理
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //右侧商品列表
        linearLayoutManagerRight = new LinearLayoutManager(getActivity());
        linearLayoutManagerRight.setOrientation(LinearLayoutManager.VERTICAL);
        getHttpShopTypeListData("0", "3");
        getHttpClassShopListData(sortingType1, typeid);
        swipClassRight.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getHttpClassShopListData(sortingType1,typeid);
            }
        });

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_classify;
    }

    //点击事件
    @OnClick({R.id.tv_classify_address, R.id.img_classify_sousuo, R.id.tv_class_sort_zonghe, R.id.tv_class_sort_price, R.id.tv_class_sort_sale})
    void onclik(View v) {
        switch (v.getId()) {
            case R.id.tv_classify_address:
                Intent intent = new Intent(getActivity(), AdressActivty.class);
                startActivityForResult(intent, 3);
                break;
            case R.id.img_classify_sousuo:
                Intent intent1 = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent1);
                break;
            case R.id.tv_class_sort_zonghe:
                setTextColor(tvClassSortZonghe, tvClassSortSale, tvClassSortPrice);
                sortingType1="1";
                getHttpClassShopListData(sortingType1,typeid);
                break;
            case R.id.tv_class_sort_price:
                setTextColor(tvClassSortPrice,tvClassSortZonghe,tvClassSortSale);
                sortingType1="2";
                getHttpClassShopListData(sortingType1,typeid);
                break;
            case R.id.tv_class_sort_sale:
                setTextColor( tvClassSortSale,tvClassSortZonghe, tvClassSortPrice);
                sortingType1="3";
                getHttpClassShopListData(sortingType1,typeid);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 3:
                if (resultCode == 1)
                    tvClassifyAddress.setText(data.getStringExtra("cityName"));
                break;
        }
    }

    //请求分类左侧商品类型列表数据
    private void getHttpShopTypeListData(final String sortingType, final String listType) {
        SharedPreferences sp=getContext().getSharedPreferences("Data",Context.MODE_PRIVATE);
        String userName=sp.getString("userName","1");
        String userId=sp.getString("userId","1");
        String url = "http://questionnaire.dzqcedu.com:81/Shop/category";
        Map<String, String> map = new HashMap<>();
        map.put("userId", userId);
        map.put("sortingType", sortingType);
        map.put("listType", listType);
        map.put("mark", userName);
        okHttpHelper.post(url, map, new SpotsCallBack<TejiaShopListBean>(getActivity(),true) {
            @Override
            public void onSuccess(com.squareup.okhttp.Response response, TejiaShopListBean tejiaShopListBean) throws ParseException {
                if (tejiaShopListBean.getData() != null) {
                    shopTypeList = tejiaShopListBean.getGoodstype();
                    relyClassShopTypeName.setLayoutManager(linearLayoutManager);
                    typeNameListAdapter = new TypeNameListAdapter(getActivity(), shopTypeList);
                    relyClassShopTypeName.setAdapter(typeNameListAdapter);
                    typeNameListAdapter.setOnRecyclerItemClickListener(new OnRecyclerItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            typeNameListAdapter.setSelectPosition(position);
                            typeid=shopTypeList.get(position).getTypeid();
                            getHttpClassShopListData(sortingType1, typeid);
                        }
                    });
                }
            }
            @Override
            public void onError(com.squareup.okhttp.Response response, int code, Exception e) {
            }
        });
    }

    //获取右侧分类商品
    private void getHttpClassShopListData(String sortingType, String typeid) {
        SharedPreferences sp=getContext().getSharedPreferences("Data",Context.MODE_PRIVATE);
        String userName=sp.getString("userName","1");
        String userId=sp.getString("userId","1");
        String url = "http://questionnaire.dzqcedu.com:81/Shop/category";
        Map<String, String> map = new HashMap<>();
        map.put("userId", userId);
        map.put("sortingType", sortingType);
        map.put("mark", userName);
        map.put("typeid", typeid);
        okHttpHelper.post(url, map, new SpotsCallBack<TejiaShopListBean>(getActivity(),true) {
            @Override
            public void onSuccess(com.squareup.okhttp.Response response, TejiaShopListBean tejiaShopListBean) throws ParseException {
                if (tejiaShopListBean.getData() != null) {
                    swipClassRight.setRefreshing(false);
                    classShopList = tejiaShopListBean.getData();
                    relyClassShopList.setLayoutManager(linearLayoutManagerRight);
                    classShopListAdpater = new ClassShopListAdpater(getActivity(), classShopList);
                    relyClassShopList.setAdapter(classShopListAdpater);
                    classShopListAdpater.setOnRecyclerItemClickListener(new OnRecyclerItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            goToGoodsDetails(getActivity(),position,classShopList);
                        }
                    });
                }

            }

            @Override
            public void onError(com.squareup.okhttp.Response response, int code, Exception e) {

            }
        });
    }

    private void setTextColor(TextView tv1, TextView tv2, TextView tv3) {
        tv1.setTextColor(getActivity().getResources().getColor(R.color.store_color));
        tv2.setTextColor(getActivity().getResources().getColor(R.color.color_3));
        tv3.setTextColor(getActivity().getResources().getColor(R.color.color_3));
    }
    //跳转到详情页面
    public void goToGoodsDetails(Context context,int i,List<TejiaShopListBean.DataBean> mList){
        Intent intent=new Intent(context,GoodsDetailsActivity.class);
        intent.putExtra("shopImage",mList.get(i).getGoodsbigurl());
        intent.putExtra("shopName",mList.get(i).getGoodsname());
        intent.putExtra("shopVip",mList.get(i).getGoodsvipprice());
        intent.putExtra("shopNormal",mList.get(i).getGoodsprice());
        startActivity(intent);
    }
}
