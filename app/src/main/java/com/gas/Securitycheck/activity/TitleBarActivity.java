package com.gas.Securitycheck.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.gas.Securitycheck.R;
import com.gas.Securitycheck.utils.DensityUtil;
import com.gas.Securitycheck.utils.PublicUtil;

public abstract class TitleBarActivity extends BaseActivity{

	private LinearLayout mLinearTitle; //这个是标题 是线下布局
	private LinearLayout mLinearTitleContent; //这个是标题的内容 也是线性布局
	private LinearLayout mLinearDivider;
	private Button mButtonLeft;
	private TextView mImgeTitle;
	public Button mButtonRight;
	private LinearLayout mMainView;
	private FrameLayout mContentView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		ViewUtils.inject(this);
//		initView();
//		setListeners();
//		initDatas();
	}

//	abstract void setListeners();
//	
//	abstract void initDatas();
	
	void createView()
	{
		System.out.println( " -----> initView");
		mMainView = new LinearLayout(this);
		mMainView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT) );
		mMainView.setOrientation(LinearLayout.VERTICAL);
		initTitleView();                                                                                                                                          
		mMainView.addView(mLinearTitle);
		
		mContentView = (FrameLayout) getWindow().getDecorView().findViewById(android.R.id.content);
		View v = null;
		if(mContentView.getChildCount()>0)
		{
			v = mContentView.getChildAt(0);
			// 缓存的rootView需要判断是否已经被加过parent，
	        // 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
	        ViewGroup parent = (ViewGroup) v.getParent();
	        if (parent != null)
	        {
	            parent.removeView(v);
	        }
	        mMainView.addView(v);	
		}
		
		setContentView(mMainView, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

	}

	/**
	 * 设置title  这个是设置图片作为标题
	 */
	/*public void setTitle(int resid)
	{
		mImgeTitle.setImageResource(resid);
	}*/

	/**
	 * 设置title  这个方法是用文字来作为标题
	 */
	public void setTitle(String title)
	{
		mImgeTitle.setTextColor(PublicUtil.getResColor(R.color.title_word_color));
		mImgeTitle.setGravity(Gravity.CENTER);
		mImgeTitle.setTextSize(18);
		mImgeTitle.setText(title);
	}

	/**
	 * 设置左侧按钮
	 * @param content
	 * @param resid
	 * @param listener
	 */
	public void setButtonLeft(String content,int resid,OnClickListener listener)
	{
		mButtonLeft.setText(content);
		mButtonLeft.setBackgroundResource(resid);
		mButtonLeft.setOnClickListener(listener);
	}
	/**
	 * 设置通用左侧按钮
	 * @param content
	 * @param
	 */
	public void setButtonLeft(String content)
	{
		mButtonLeft.setBackgroundResource(R.drawable.back_selector);
		mButtonLeft.setText(content);
	}
	/**
	 * 设置主页面左侧按钮
	 * @param content
	 * @param
	 */
	public void setMainButtonLeft(String content)
	{
		mButtonLeft.setBackgroundColor(PublicUtil.getResColor(R.color.title_color));
		mButtonLeft.setText(content);
	}

	/**
	 * 设置右侧按钮
	 * @param content
	 * @param resid
	 */
	public void setButtonRight(String content,int resid)
	{
		mButtonRight.setText(content);
		mButtonRight.setBackgroundResource(resid);
		mButtonRight.setVisibility(View.VISIBLE);
	}

	/**
	 * 设置右侧按钮
	 * @param content
	 * @param
	 */
	public void setButtonRight(String content)
	{
		mButtonRight.setText(content);
		mButtonRight.setBackgroundResource(R.color.title_color);
		mButtonRight.setVisibility(View.VISIBLE);
	}

	void initTitleView()
	{
		/* title */
		mLinearTitle = new LinearLayout(this);
		LayoutParams mTitleLayoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, DensityUtil.dip2px(this, 49));
		mLinearTitle.setLayoutParams(mTitleLayoutParams);
		mLinearTitle.setOrientation(LinearLayout.VERTICAL);
		/* start title divider*/
		mLinearDivider = new LinearLayout(this);
		LayoutParams mTitleDividerParams = new LayoutParams(LayoutParams.MATCH_PARENT,DensityUtil.dip2px(this, 1));
		mLinearDivider.setLayoutParams(mTitleDividerParams);
		mLinearDivider.setBackgroundColor(Color.LTGRAY);
		/* end title divider*/

		/* start title content*/
		mLinearTitleContent = new LinearLayout(this);
		LayoutParams mTitleContentLayoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,DensityUtil.dip2px(this, 48));
		mTitleContentLayoutParams.gravity = Gravity.CLIP_VERTICAL;
		mLinearTitleContent.setOrientation(LinearLayout.HORIZONTAL);
		mLinearTitleContent.setLayoutParams(mTitleContentLayoutParams);
		//mLinearTitleContent.setBackgroundColor(Color.DKGRAY);
		mLinearTitleContent.setBackgroundColor(PublicUtil.getResColor(R.color.title_color));
		mLinearTitleContent.setGravity(Gravity.CENTER_VERTICAL);

		LayoutParams buttonParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);

		mButtonLeft = new Button(this);
		mButtonLeft.setLayoutParams(buttonParams);
		mButtonLeft.setText("左侧按钮");
		mButtonLeft.setTextColor(PublicUtil.getResColor(R.color.title_word_color));
		mButtonLeft.setGravity(Gravity.CENTER_VERTICAL);
		//mButtonLeft.setBackgroundResource(R.drawable.back_selector);
		mButtonLeft.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				LeftButtonClicked();
			}
		});

		mImgeTitle = new TextView(this);
		LayoutParams params = new LayoutParams(0, LayoutParams.MATCH_PARENT,1);
		params.gravity = Gravity.CENTER;
		mImgeTitle.setLayoutParams(params);


		mButtonRight = new Button(this);
		mButtonRight.setLayoutParams(buttonParams);
		mButtonRight.setText("右侧按钮");
		mButtonRight.setTextColor(PublicUtil.getResColor(R.color.title_word_color));
		mButtonRight.setGravity(Gravity.CENTER_VERTICAL);
		mButtonRight.setVisibility(View.INVISIBLE);
		mButtonRight.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				RightButtonClicked();
			}
		});
		
		mLinearTitleContent.addView(mButtonLeft);
		mLinearTitleContent.addView(mImgeTitle);
		mLinearTitleContent.addView(mButtonRight);

		//mLinearTitleContent.setBackgroundColor(Color.WHITE);
		mLinearTitleContent.setBackgroundColor(PublicUtil.getResColor(R.color.title_color));
		/* end title content*/
		
		mLinearTitle.addView(mLinearTitleContent);
		mLinearTitle.addView(mLinearDivider);
	}
	/**
	 * 左侧按钮事件
	 */
	abstract void RightButtonClicked();
	/**
	 * 右侧按钮事件
	 */
	abstract void LeftButtonClicked();
}
