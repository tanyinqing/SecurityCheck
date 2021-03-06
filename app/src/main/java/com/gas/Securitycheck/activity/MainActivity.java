package com.gas.Securitycheck.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.gas.Securitycheck.Constant;
import com.gas.Securitycheck.R;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

@ContentView(R.layout.activity_main)
public class MainActivity extends TitleBarActivity implements View.OnClickListener {
    private final static Integer DEFAULT_INDEX = 1;
   /* @ViewInject(R.id.tv_ele)
    private Button tv_ele;

    @OnClick(R.id.tv_ele)
    void JumpPage(View v) {
        startActivityByClass(Task.class);
    }*/

    @Override
    void initDatas() {
        setMainButtonLeft("登录");
        setTitle("唐山市燃气集团有限公司");
        setButtonRight("退出");

         /*
         * 调用超类的方法,查找BottomTab中的各图片按钮,并添加事件
         * 然后依次调用loadViewLayout()、findViewById()、processLogic()、setListener()
         */
        initView();
        //对5个按钮的点击事件进行对应
        findViewById(R.id.tv_ele).setOnClickListener(this);
        findViewById(R.id.tv_clube).setOnClickListener(this);
        findViewById(R.id.tv_pic).setOnClickListener(this);
        findViewById(R.id.tv_med).setOnClickListener(this);
        findViewById(R.id.tv_sp).setOnClickListener(this);
    }

    @Override
    void setListeners() {

    }

    @Override
    void RightButtonClicked() {

    }

    @Override
    void LeftButtonClicked() {
        //finish();
    }


    private void initView() {
        if (isLoadBottomTab()) {
            View currentView = getWindow().getDecorView();
            loadBottomTab(currentView);    // 加载BottomTab,为BottomTab上的ImageView添加监听器
            selectedBottomTab(DEFAULT_INDEX);   // 默认选中第一个选项
        }
        loadViewLayout();   //

    }

    private void loadViewLayout() {
        // 设置BottomTab中被选中按钮的背景为HOME
        selectedBottomTab(Constant.HOME);
    }

    @Override
    public void onClick(View view) {
        // TODO Auto-generated method stub
        switch (view.getId()) {
            case R.id.tv_ele:
                startActivity(new Intent(this, TaskList.class));
                break;
            case R.id.tv_sp:

                break;
            case R.id.tv_med:

                break;
            case R.id.tv_clube:

                break;
            case R.id.tv_pic:

                break;
        }
    }
}
