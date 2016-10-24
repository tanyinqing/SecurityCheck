package com.gas.Securitycheck.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.gas.Securitycheck.Constant;
import com.gas.Securitycheck.R;
import com.gas.Securitycheck.model.TaskListModel;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

@ContentView(R.layout.activity_state)
public class TaskList extends TitleBarActivity {
    private final static Integer DEFAULT_INDEX = 3;
    private TaskListModel mTaskListModel;
   /* @ViewInject(R.id.tan)
    private Button tan;
    @OnClick(R.id.tan)
    void JumpPage(View v){
        startActivityByClass(enterRegister.class);
    }*/

    @ViewInject(R.id.lv_details)//商品列表的显示
    private ListView listProducts;



    @Override
    void setListeners() {

    }

    @Override
    void initDatas() {
        setButtonLeft("返回");
        setTitle("任务列表");
        setButtonRight("退出");

         /*
         * 调用超类的方法,查找BottomTab中的各图片按钮,并添加事件
         * 然后依次调用loadViewLayout()、findViewById()、processLogic()、setListener()
         */
        initView();
        mTaskListModel = new TaskListModel(this);
        //这个是商品的控件
        listProducts.setAdapter(mTaskListModel.getGoodsAdapter());
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
        selectedBottomTab(Constant.SEARCH);
    }

    @Override
    void RightButtonClicked() {

    }

    @Override
    void LeftButtonClicked() {
finish();
    }


}
