package com.gas.Securitycheck.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.gas.Securitycheck.R;
import com.gas.Securitycheck.model.SecurityItemModel;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

@ContentView(R.layout.activity_data_input)
public class SecurityItem extends TitleBarActivity {
    private SecurityItemModel mSecurityItemModel;
    @ViewInject(R.id.lv_details)//商品列表的显示
    private ListView listProducts;
    @ViewInject(R.id.btn_next)
    private Button btn_next;
    @OnClick(R.id.btn_next)
    void JumpPage(View v){
        mSecurityItemModel.showDialog();
    }
    @Override
    void setListeners() {

    }

    @Override
    void initDatas() {
        setButtonLeft("返回");
        setTitle("安检项");
        setButtonRight("退出");

        mSecurityItemModel = new SecurityItemModel(this);
        //这个是商品的控件
        listProducts.setAdapter(mSecurityItemModel.getGoodsAdapter());
    }
    @Override
    void RightButtonClicked() {

    }

    @Override
    void LeftButtonClicked() {
finish();
    }


}
