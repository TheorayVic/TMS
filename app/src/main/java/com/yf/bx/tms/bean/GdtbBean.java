package com.yf.bx.tms.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**工单提报实体类
 * Created by 123 on 2016/10/26.
 */

public class GdtbBean implements Parcelable {

    private String wtbt;
    private String lxr;
    private String lxdh;
    private String fsdd;
    private String gdzt;
    private String jjcd;

    protected GdtbBean(Parcel in) {
        wtbt = in.readString();
        lxr = in.readString();
        lxdh = in.readString();
        fsdd = in.readString();
        gdzt = in.readString();
        jjcd = in.readString();
    }

    public static final Creator<GdtbBean> CREATOR = new Creator<GdtbBean>() {
        @Override
        public GdtbBean createFromParcel(Parcel in) {
            return new GdtbBean(in);
        }

        @Override
        public GdtbBean[] newArray(int size) {
            return new GdtbBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(wtbt);
        dest.writeString(lxr);
        dest.writeString(lxdh);
        dest.writeString(fsdd);
        dest.writeString(gdzt);
        dest.writeString(jjcd);
    }

    public String getWtbt() {
        return wtbt;
    }

    public void setWtbt(String wtbt) {
        this.wtbt = wtbt;
    }

    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getFsdd() {
        return fsdd;
    }

    public void setFsdd(String fsdd) {
        this.fsdd = fsdd;
    }

    public String getGdzt() {
        return gdzt;
    }

    public void setGdzt(String gdzt) {
        this.gdzt = gdzt;
    }

    public String getJjcd() {
        return jjcd;
    }

    public void setJjcd(String jjcd) {
        this.jjcd = jjcd;
    }

    public static Creator<GdtbBean> getCREATOR() {
        return CREATOR;
    }

    @Override
    public String toString() {
        return "GdtbBean{" +
                "wtbt='" + wtbt + '\'' +
                ", lxr='" + lxr + '\'' +
                ", lxdh='" + lxdh + '\'' +
                ", fsdd='" + fsdd + '\'' +
                ", gdzt='" + gdzt + '\'' +
                ", jjcd='" + jjcd + '\'' +
                '}';
    }
}
