package com.gas.Securitycheck.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.gas.Securitycheck.R;

import com.gas.Securitycheck.adapter.TaskAdapter;
import com.gas.Securitycheck.entity.Task_entity;
import com.gas.Securitycheck.utils.dataAppUtil;
import com.gas.Securitycheck.view.DynamicListView.DynamicListViewListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/17 0017.
 */
public class ZiXunInfoView<T> extends LinearLayout implements
        DynamicListViewListener{
    private Context context;
    private DynamicListView zixunListView;
    private TaskAdapter zixunAdapter;
    //
    private ArrayList<Task_entity> infoList = new ArrayList<Task_entity>();
    public ZiXunInfoView(Context context) {
        super(context);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.zixun_info_view, this, true);
        init();
    }

    public ZiXunInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.zixun_info_view, this,true);
        init();
    }

    private void init() {
        zixunListView = (DynamicListView) findViewById(R.id.zixun_info_listview);
        zixunListView.setOnItemClickListener(itemClickListener);
        newSucessCallBack(dataAppUtil.TaskInfo);
    }

    private void newSucessCallBack(String data) {
        zixunListView.doneRefresh();
        JSONObject jsonObject;
        List<Task_entity> list;
        Type type = new TypeToken<List<Task_entity>>() {
        }.getType();
        try {
            jsonObject = new JSONObject(data);//
            if ("true".equals(jsonObject.getString("success"))) {
                Gson gson = new Gson();
                T obj = gson.fromJson(jsonObject.getString("data"), type);
                list =(List<Task_entity>)obj;
                infoList.clear();
                infoList.addAll(list);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zixunAdapter = new TaskAdapter(context, infoList);
        zixunListView.setAdapter(zixunAdapter);
    }

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            Task_entity zixun = infoList.get(position);
            //����ǵ���Ĳ�����������������ҳ��
			/*Intent detailIntent = new Intent(context, ZiXunDetailActivity.class);
			Bundle bundle = new Bundle();
			bundle.putSerializable("newItem", zixun);
			detailIntent.putExtras(bundle);
			context.startActivity(detailIntent);*/
        }
    };

    @Override
    public boolean onRefreshOrMore(DynamicListView dynamicListView, boolean isRefresh) {
        return false;
    }
}
