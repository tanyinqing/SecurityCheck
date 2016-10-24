package com.gas.Securitycheck.activity;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.gas.Securitycheck.Constant;
import com.gas.Securitycheck.R;
import com.gas.Securitycheck.adapter.ViewPagerAdapter;
import com.gas.Securitycheck.view.MenuBarView;
import com.gas.Securitycheck.view.ZiXunInfoView;
import com.lidroid.xutils.view.annotation.ContentView;

import java.util.ArrayList;

@ContentView(R.layout.activity_task)
public class Task extends TitleBarActivity implements MenuBarView.OnMenuBarListener {
    private final static Integer DEFAULT_INDEX = 2;
    private static Task instance;
    private ViewPager zixunViewPager;  //这个是伴随导航条变化的界面
    private MenuBarView zixunMenuBarView = null;//这个是导航条

    @Override
    void setListeners() {

    }

    @Override
    void initDatas() {
        setButtonLeft("返回");
        setTitle("朝阳区甘露园1区");
        setButtonRight("下一页");
        initView(); //加载底部导航栏
        instance = this;

        zixunViewPager = (ViewPager) findViewById(R.id.zixunViewPager);
        ArrayList<View> views = new ArrayList<View>();

        views.add(new ZiXunInfoView(instance));//这个是全部任务
        views.add(new ZiXunInfoView(instance));//这个是全部任务
        views.add(new ZiXunInfoView(instance));//这个是全部任务
       // views.add(new ZiXunExpertView(instance));
       // views.add(new ZiXunSportView(instance));

        //ViewPager 加入监听变化
        zixunViewPager.setAdapter(new ViewPagerAdapter(views));
        zixunViewPager.setOnPageChangeListener(new MyPageChangeListener());

        //顶上的选项卡 加入监听 并做好默认选项
        zixunMenuBarView = (MenuBarView) findViewById(R.id.zixunMenuBar);
        // 选项卡把自己注册进监听器中  setOnMenuBarListener
        zixunMenuBarView.setOnMenuBarListener(instance);
        zixunMenuBarView.setSelectedIndex(0);
    }

    // viewPager监听
    class MyPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int arg0) {
            if (arg0 == 0) {

            }
            zixunMenuBarView.setSelectedIndex(arg0);
        }
    }

    public static Task getInstance(){
        return instance;
    }
    //加载底部导航栏
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
        selectedBottomTab(Constant.CLASSIFY);
    }
    @Override
    void RightButtonClicked() {
        startActivityByClass(TaskList.class);
    }

    @Override
    void LeftButtonClicked() {
        finish();
    }


    @Override
    public void onMenuBarItemSelected(int menuIndex) {
        zixunViewPager.setCurrentItem(menuIndex);
    }
}
