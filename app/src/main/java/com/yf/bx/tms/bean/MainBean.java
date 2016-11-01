package com.yf.bx.tms.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**主界面实体类
 * Created by 123 on 2016/11/1.
 */

public class MainBean implements Parcelable {

    private String type;
    private String date;
    private String title;


    protected MainBean(Parcel in) {
        type = in.readString();
        date = in.readString();
        title = in.readString();
    }

    public static final Creator<MainBean> CREATOR = new Creator<MainBean>() {
        @Override
        public MainBean createFromParcel(Parcel in) {
            return new MainBean(in);
        }

        @Override
        public MainBean[] newArray(int size) {
            return new MainBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(date);
        dest.writeString(title);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static Creator<MainBean> getCREATOR() {
        return CREATOR;
    }

    @Override
    public String toString() {
        return "MainBean{" +
                "type='" + type + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
