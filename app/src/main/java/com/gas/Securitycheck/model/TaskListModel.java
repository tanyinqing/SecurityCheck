package com.gas.Securitycheck.model;

import android.content.Context;
import android.widget.ListAdapter;

import com.gas.Securitycheck.activity.TaskList;
import com.gas.Securitycheck.adapter.TaskListAdapter;
import com.gas.Securitycheck.entity.TaskListEntity;
import com.gas.Securitycheck.entity.Task_entity;
import com.gas.Securitycheck.utils.dataAppUtil;
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
public class TaskListModel<T> extends BaseModel{
    private TaskListAdapter mGoodsAdapter;
    private Context context;

    public TaskListModel(Context mContext) {
        super(mContext);
        mGoodsAdapter = new TaskListAdapter(mContext);
        this.context=mContext;
    }

    public TaskListAdapter getGoodsAdapter() {
        JSONObject jsonObject;
        List<TaskListEntity> list=new ArrayList<>();
        Type type = new TypeToken<List<TaskListEntity>>() {
        }.getType();
        try {
            jsonObject = new JSONObject(dataAppUtil.TaskListData);
            if ("true".equals(jsonObject.getString("success"))) {
                Gson gson = new Gson();
                T obj = gson.fromJson(jsonObject.getString("data"), type);
                list =(List<TaskListEntity>)obj;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
         mGoodsAdapter.appendToListAndClear(list);
        return mGoodsAdapter;
    }
}
