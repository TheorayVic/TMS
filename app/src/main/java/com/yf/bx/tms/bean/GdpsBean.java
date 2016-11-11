package com.yf.bx.tms.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 123 on 2016/11/1....
 */

public class GdpsBean implements Parcelable {

    private boolean isPs;//标记是否已经派送
    private boolean isLq;//标记是否已经领取
    private String gdbh;
    private String jjcd;
    private String wtlx;
    private String wtms;
    private String fsdd;
    private String lxr;


    protected GdpsBean(Parcel in) {
        isPs = in.readByte() != 0;
        isLq = in.readByte() != 0;
        gdbh = in.readString();
        jjcd = in.readString();
        wtlx = in.readString();
        wtms = in.readString();
        fsdd = in.readString();
        lxr = in.readString();
    }

    public static final Creator<GdpsBean> CREATOR = new Creator<GdpsBean>() {
        @Override
        public GdpsBean createFromParcel(Parcel in) {
            return new GdpsBean(in);
        }

        @Override
        public GdpsBean[] newArray(int size) {
            return new GdpsBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (isPs ? 1 : 0));
        dest.writeByte((byte) (isLq ? 1 : 0));
        dest.writeString(gdbh);
        dest.writeString(jjcd);
        dest.writeString(wtlx);
        dest.writeString(wtms);
        dest.writeString(fsdd);
        dest.writeString(lxr);
    }

    public boolean isPs() {
        return isPs;
    }

    public void setPs(boolean ps) {
        isPs = ps;
    }

    public boolean isLq() {
        return isLq;
    }

    public void setLq(boolean lq) {
        isLq = lq;
    }

    public String getGdbh() {
        return gdbh;
    }

    public void setGdbh(String gdbh) {
        this.gdbh = gdbh;
    }

    public String getJjcd() {
        return jjcd;
    }

    public void setJjcd(String jjcd) {
        this.jjcd = jjcd;
    }

    public String getWtlx() {
        return wtlx;
    }

    public void setWtlx(String wtlx) {
        this.wtlx = wtlx;
    }

    public String getWtms() {
        return wtms;
    }

    public void setWtms(String wtms) {
        this.wtms = wtms;
    }

    public String getFsdd() {
        return fsdd;
    }

    public void setFsdd(String fsdd) {
        this.fsdd = fsdd;
    }

    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }

    public static Creator<GdpsBean> getCREATOR() {
        return CREATOR;
    }

    @Override
    public String toString() {
        return "GdpsBean{" +
                "isPs=" + isPs +
                ", isLq=" + isLq +
                ", gdbh='" + gdbh + '\'' +
                ", jjcd='" + jjcd + '\'' +
                ", wtlx='" + wtlx + '\'' +
                ", wtms='" + wtms + '\'' +
                ", fsdd='" + fsdd + '\'' +
                ", lxr='" + lxr + '\'' +
                '}';
    }
}
