package com.gas.Securitycheck.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gas.Securitycheck.R;
import com.gas.Securitycheck.activity.Task;
import com.gas.Securitycheck.entity.TaskListEntity;
import com.gas.Securitycheck.utils.MyLog;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by Administrator on 2016/10/17 0017.
 */
public class TaskListAdapter extends AdapterBase{
    private static Context context;
    public TaskListAdapter(Context baseContext) {
        super(baseContext);
        context = baseContext;
    }

    @Override
    protected View getExView(int position, View convertView, ViewGroup parent) {
        TaskListEntity mGoods = (TaskListEntity) getItem(position);
        ViewHolder holder;
        if(convertView == null)
        {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.task_list_item, parent, false);
            ViewUtils.inject(holder, convertView);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.update(mGoods);
        return convertView;
    }
    private static class ViewHolder{
        @ViewInject(R.id.textSerialNumber)
        private TextView textSerialNumber;
        @ViewInject(R.id.textname)
        private TextView textname;
        @ViewInject(R.id.textCompletionStatus)
        private TextView textCompletionStatus;
        @ViewInject(R.id.textstate)
        private TextView textstate;
        @ViewInject(R.id.textoperation)
        private TextView textoperation;
        @ViewInject(R.id.textTime)
        private TextView textTime;

        TaskListEntity goods;
        void update(TaskListEntity goods)
        {
            this.goods = goods;

            textSerialNumber.setText(goods.getSerialNumber());
            textname.setText(goods.getName());
            textCompletionStatus.setText(goods.getCompletionStatus());
            textstate.setText(goods.getState());
            textoperation.setText(goods.getOperation());
            textTime.setText(goods.getTime());
        }
        @OnClick(R.id.textoperation)
        void buttonOperationClick(View v){
           // MyLog.ShowLog("点击成功");
            Intent intent;
            if(goods.getOperation().equals("执行")){
                intent=new Intent(context, Task.class);
                context.startActivity(intent);
            }
        }

    }
}
