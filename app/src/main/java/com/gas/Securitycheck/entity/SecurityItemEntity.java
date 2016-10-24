package com.gas.Securitycheck.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/17 0017.
 */
public class SecurityItemEntity implements Serializable {
    private static final long serialVersionUID = 4L;
    private String isTrue; //是否合格
    private String content; //安检内容
    private String edit; //编辑
    private String Photograph; //照片是否有或路径

    @Override
    public String toString() {
        return "SecurityItemEntity{" +
                "isTrue=" + isTrue +
                ", content='" + content + '\'' +
                ", edit='" + edit + '\'' +
                ", Photograph='" + Photograph + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(String isTrue) {
        this.isTrue = isTrue;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

    public String getPhotograph() {
        return Photograph;
    }

    public void setPhotograph(String photograph) {
        Photograph = photograph;
    }
}
