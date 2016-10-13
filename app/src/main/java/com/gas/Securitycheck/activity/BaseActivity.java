package com.gas.Securitycheck.activity;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.gas.Securitycheck.Constant;
import com.gas.Securitycheck.R;
import com.gas.Securitycheck.ServiceApplication;
import com.lidroid.xutils.ViewUtils;

public abstract class BaseActivity extends FragmentActivity
{
    
	protected static Context context;
    protected ServiceApplication application = null;

    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        application = ServiceApplication.getInstance();
        application.register(this);
        context = this;
        //这是进行注解绑定的初始化
        ViewUtils.inject(this);
        
        createView();
        
        setListeners();
        
        initDatas();
        //底部导航栏的初始化
        buttonClickListener = new ButtonClickListener();

    }
    
    /**
     * 通过Class启动Activity
     * 
     * @param cls
     */
    protected void startActivityByClass(Class cls)
    {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
    }
    
    /**
     * 设置事件监听
     */
    abstract void setListeners();
    
    /**
     * 初始化设置
     */
    abstract void initDatas();
    
    /**
     * 初始化
     */
    abstract void createView();
    
    @Override
    protected void onStart()
    {
        // TODO Auto-generated method stub
        super.onStart();
    }
    
    @Override
    protected void onResume()
    {
        // TODO Auto-generated method stub
        super.onResume();
    }
    
    @Override
    protected void onPause()
    {
        // TODO Auto-generated method stub
        super.onPause();
    }
    
    @Override
    protected void onStop()
    {
        // TODO Auto-generated method stub
        super.onStop();
    }

    public void p(String msg) {
        if (true) {
            new AlertDialog.Builder(BaseActivity.this).setTitle("测试数据").setMessage(msg).show();
        }
    }

    public  void tt(String msg) {
        if (true) {
            Toast.makeText(BaseActivity.this, msg, Toast.LENGTH_LONG).show();
        }
    }

    /*******************************底部导航栏的封装********************************/
    // 底部栏公共组件
    protected ImageView home;
    protected ImageView classify;
    protected ImageView search;
    protected ImageView shopCar;


    // 自定义的按钮单击事件监听器
    protected ButtonClickListener buttonClickListener;
   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        buttonClickListener = new ButtonClickListener();
    }*/

    /**
     * 是否加载底部tab
     *
     * @return
     */
    protected Boolean isLoadBottomTab() {
        return true;
    }

    /**
     * 加载底部导航栏
     */
    protected void loadBottomTab(View view) {
        this.home = (ImageView)view.findViewById(R.id.imgHome);
        this.classify = (ImageView)view.findViewById(R.id.imgClassify);
        this.search = (ImageView)view.findViewById(R.id.imgSearch);
        this.shopCar = (ImageView)view.findViewById(R.id.imgShoppingCar);

        this.buttonClickListener = new ButtonClickListener();

        this.home.setOnClickListener(buttonClickListener);
        this.classify.setOnClickListener(buttonClickListener);
        this.search.setOnClickListener(buttonClickListener);
        this.shopCar.setOnClickListener(buttonClickListener);

    }

    /**
     * 设置底部导航栏切换
     *
     * @param paramViewId
     */
    protected void selectedBottomTab(int paramViewId) {
        // 重新初始化所有的底部按钮为初始状态
        this.home.setBackgroundResource(R.drawable.bar_home_normal);
        this.classify.setBackgroundResource(R.drawable.bar_class_normal);
        this.search.setBackgroundResource(R.drawable.bar_search_normal);
        this.shopCar.setBackgroundResource(R.drawable.bar_shopping_normal);

        // 修改底部选中按钮的状态
        switch (paramViewId) {
            case Constant.HOME:
                Constant.defaultIndex = Constant.HOME;
                this.home.setBackgroundResource(R.drawable.bar_home_selected);
                break;
            case Constant.CLASSIFY:
                this.classify.setBackgroundResource(R.drawable.bar_class_selected);
                Constant.defaultIndex = Constant.CLASSIFY;
                break;
            case Constant.SEARCH:
                this.search.setBackgroundResource(R.drawable.bar_search_selected);
                Constant.defaultIndex = Constant.SEARCH;
                break;
            case Constant.SHOPCAR:
                this.shopCar.setBackgroundResource(R.drawable.bar_shopping_selected);
                Constant.defaultIndex = Constant.SHOPCAR;
                break;

        }
    }

    // 自定义的按钮单击事件监听器
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imgHome:
                    startActivity(new Intent(BaseActivity.this, MainActivity.class));
                    break;
                case R.id.imgClassify:  // 单击了"分类"按钮
                    startActivity(new Intent(BaseActivity.this, Task.class));
                    break;
                case R.id.imgSearch:
                     startActivity(new Intent(BaseActivity.this, State.class));
                    break;
                case R.id.imgShoppingCar:
                     startActivity(new Intent(BaseActivity.this, enterRegister.class));
                    break;
            }
        }
    }
    /*******************************************************************************/
}
