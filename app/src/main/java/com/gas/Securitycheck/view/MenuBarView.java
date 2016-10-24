package com.gas.Securitycheck.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class MenuBarView extends LinearLayout {

	private OnMenuBarListener menuBarListener = null;

	public MenuBarView(Context context) {
		super(context);
	}
	
	/****************** 这是构造器******************************/
	public MenuBarView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
    /*************************************************************/
	

	//当从XML布局加载文件并用它来构建视图时，回调这个方法
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		init();
	}

	private void init() {
		OnClickListener listener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				setSelectedView(v);
			}
		};
		int count = this.getChildCount();
		for (int i = 0; i < count; i++) {
			View child = this.getChildAt(i);
			child.setOnClickListener(listener);
		}
	}

	public boolean isSelectedByIndex(int index) {
		boolean isSelected = false;
		if (index >= 0) {
			View child = this.getChildAt(index);
			isSelected = child.isSelected(); //这个应用的是View中的方法 TextView是View的子类
		}
		return isSelected;
	}

	public void setSelectedIndex(int index) {
		if (index >= 0 && index < this.getChildCount()) //这个是ViewGroup中的方法  得到子控件的个数
			setSelectedView(this.getChildAt(index));
	}

	private void setSelectedView(View view) {

		if (view.isSelected())
			return;

		int count = this.getChildCount();
		int menuIndex = 0;
		for (int i = 0; i < count; i++) {
			View child = this.getChildAt(i);
			if (child == view) {
				child.setSelected(true);
				menuIndex = i;
			} else
				child.setSelected(false);   //View中的方法  表明该控件被选中
		}
		if (menuBarListener != null)
			menuBarListener.onMenuBarItemSelected(menuIndex);
	}

	/**
	 * 设置菜单页面的监听事件   外部设置的接口
	 */
	public void setOnMenuBarListener(OnMenuBarListener listener) {
		menuBarListener = listener;//让外部的接口注册进来
	}
	public interface OnMenuBarListener {      //接口
		public void onMenuBarItemSelected(int menuIndex);
	}
}
