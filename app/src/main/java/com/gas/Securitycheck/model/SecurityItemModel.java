package com.gas.Securitycheck.model;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ListAdapter;

import com.gas.Securitycheck.R;
import com.gas.Securitycheck.adapter.DialogItemAdapter;
import com.gas.Securitycheck.adapter.SecurityItemAdapter;
import com.gas.Securitycheck.adapter.TaskListAdapter;
import com.gas.Securitycheck.entity.SecurityItemEntity;
import com.gas.Securitycheck.entity.TaskListEntity;
import com.gas.Securitycheck.utils.MyDialog;
import com.gas.Securitycheck.utils.MyLog;
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
public class SecurityItemModel<T> extends BaseModel{
    private  SecurityItemAdapter mSecurityItemAdapter;
    private static DialogItemAdapter mDialogItemAdapter;
    private static Context context;

    public SecurityItemModel(Context mContext) {
        super(mContext);
        mSecurityItemAdapter = new SecurityItemAdapter(mContext);
        this.context=mContext;
    }

    public SecurityItemAdapter getGoodsAdapter() {
        JSONObject jsonObject;
        List<SecurityItemEntity> list=new ArrayList<>();
        Type type = new TypeToken<List<SecurityItemEntity>>() {
        }.getType();
        try {
            jsonObject = new JSONObject(dataAppUtil.SecurityItemData);//把字符串转化成一个json对象
            if ("true".equals(jsonObject.getString("success"))) {
                Gson gson = new Gson();
                T obj = gson.fromJson(jsonObject.getString("data"), type);
                list =(List<SecurityItemEntity>)obj;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mSecurityItemAdapter.appendToListAndClear(list);
        return mSecurityItemAdapter;
    }
    //显示安检等级的dialgo
    public  void showDialog() {
        mDialogItemAdapter=new DialogItemAdapter(context);

        JSONObject jsonObject;
        List<SecurityItemEntity> list=new ArrayList<>();
        Type type = new TypeToken<List<SecurityItemEntity>>() {
        }.getType();
        try {
            jsonObject = new JSONObject(dataAppUtil.HiddenDangerItemData);//把字符串转化成一个json对象
            if ("true".equals(jsonObject.getString("success"))) {
                Gson gson = new Gson();
                T obj = gson.fromJson(jsonObject.getString("data"), type);
                list =(List<SecurityItemEntity>)obj;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mDialogItemAdapter.appendToListAndClear(list);

        MyDialog dialog = new MyDialog(context);
        dialog.setTitle("隐患等级");
        dialog.setListView(mDialogItemAdapter,new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
               // MyLog.ShowLog(String.valueOf(which));
               
            }
        });
        dialog.setPositiveButton(R.string.tijiao, new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //MyLog.ShowLog("提交");
            }
        });
        dialog.setNegativeButton(R.string.cancel, new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
               // MyLog.ShowLog("取消");
            }
        });
        dialog.create(null).show();

    }
}
