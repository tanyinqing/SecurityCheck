package com.gas.Securitycheck.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.gas.Securitycheck.R;
import com.gas.Securitycheck.entity.SecurityItemEntity;
import com.gas.Securitycheck.entity.TaskListEntity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * Created by Administrator on 2016/10/17 0017.
 */
public class SecurityItemAdapter extends AdapterBase{
    private static Context context;
    public SecurityItemAdapter(Context baseContext) {
        super(baseContext);
        context = baseContext;
    }

    @Override
    protected View getExView(int position, View convertView, ViewGroup parent) {
        SecurityItemEntity mGoods = (SecurityItemEntity) getItem(position);
        ViewHolder holder;
        if(convertView == null)
        {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.security_item_item, parent, false);
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
        @ViewInject(R.id.cb_yes)
        private CheckBox cb_yes;
        @ViewInject(R.id.tv_name)
        private TextView tv_name;
        @ViewInject(R.id.bn_edit)
        private ImageButton bn_lookPhoto;
        @ViewInject(R.id.bn_photo)
        private ImageButton bn_photo;

        SecurityItemEntity goods;
        void update(SecurityItemEntity goods)
        {
            this.goods = goods;
            if ("true".equals(goods.getIsTrue())){
                cb_yes.setChecked(true);
            }else {
                cb_yes.setChecked(false);
            }
            tv_name.setText(goods.getContent());



        }

    }
}
