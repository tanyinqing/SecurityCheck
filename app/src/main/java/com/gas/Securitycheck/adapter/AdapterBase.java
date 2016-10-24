package com.gas.Securitycheck.adapter;

import java.util.ArrayList;
import java.util.List;

import com.nostra13.universalimageloader.core.ImageLoader;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class AdapterBase<T> extends BaseAdapter
{
    /*
      但对于一些容器类型（比如，ArrayList、HashMap）的实例变量，
    不可以改变容器变量本身，但可以修改容器中存放的对象，这一点在编程中用到很多
     */
    //运用List<T>这个对象集合存放多种形式的对象，运用了泛型替代
    public final List<T> mList = new ArrayList<T>();
    public Context context;
    //布局适配器  将布局转化成对象 从而和数据一一对应
    public LayoutInflater mInflater;
    
    public AdapterBase(Context baseContext)
    {
        this.context = baseContext;
        mInflater = LayoutInflater.from(baseContext);
        
    }
    
    public List<T> getList()
    {
        return mList;
    }

    //将一个对象添加到集合中
    public void appendToList(T t)
    {
        if (t == null)
        {
            return;
        }
        mList.add(t);
        notifyDataSetChanged();
    }

    //将一个对象集合添加到集合中
    public void appendToList(List<T> list)
    {
        if (list == null)
        {
            return;
        }
        mList.addAll(list);
        notifyDataSetChanged();
    }
    //先清空结合  在把一个新的集合添加到集合中
    public void appendToListAndClear(List<T> list)
    {
        mList.clear();
        this.appendToList(list);
    }

    //在把一个新的集合添加到集合的最上层
    public void appendToTopList(List<T> list)
    {
        if (list == null)
        {
            return;
        }
        mList.addAll(0, list);
        notifyDataSetChanged();
    }

    //请空集合
    public void clear()
    {
        mList.clear();
        notifyDataSetChanged();
    }
    
    @Override  //返回集合个个数
    public int getCount()
    {
        return mList.size();
    }
    
    @Override //返回集合中的某个元素
    public Object getItem(int position)
    {
        if (position > mList.size() - 1)
        {
            return null;
        }
        return mList.get(position);
    }
    //移除集合中的某个位置的元素
    public void removeItem(int position)
    {
        if (position >= 0 && position < mList.size())
        {
            mList.remove(position);
            notifyDataSetChanged();
        }
    }
    //移除集合中的某个指定元素
    public void removeItem(T item)
    {
        if (mList.contains(item))
        {
            mList.remove(item);
            notifyDataSetChanged();
        }
    }
    
    @Override
    public long getItemId(int position)
    {
        return position;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        return getExView(position, convertView, parent);
    }
    //abstract加入这个关键词表示是抽象的方法，子类中必须进行重写这个方法

    protected abstract View getExView(int position, View convertView, ViewGroup parent);
    
}
