package com.gas.Securitycheck.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.gas.Securitycheck.R;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

@ContentView(R.layout.activity_data_input)
public class DataInput extends TitleBarActivity {
    @ViewInject(R.id.tan)
    private Button tan;

    @OnClick(R.id.tan)
    void JumpPage(View v){
        startActivityByClass(HiddenDanger.class);
    }
    @Override
    void setListeners() {

    }

    @Override
    void initDatas() {
        setButtonLeft("返回");
        setTitle("数据录入");
        setButtonRight("退出");
    }
    @Override
    void RightButtonClicked() {

    }

    @Override
    void LeftButtonClicked() {
finish();
    }


}
