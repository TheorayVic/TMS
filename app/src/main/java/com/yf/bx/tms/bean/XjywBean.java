package com.yf.bx.tms.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 123 on 2016/11/7.
 */

public class XjywBean implements Parcelable {

    private String xjdw;
    private String txz;
    private String jcsj;
    private String jcfzr;
    private String zt;
    private String xjlx;
    private boolean flag;//凑够七列，表格

    protected XjywBean(Parcel in) {
        xjdw = in.readString();
        txz = in.readString();
        jcsj = in.readString();
        jcfzr = in.readString();
        zt = in.readString();
        xjlx = in.readString();
        flag = in.readByte() != 0;
    }

    public static final Creator<XjywBean> CREATOR = new Creator<XjywBean>() {
        @Override
        public XjywBean createFromParcel(Parcel in) {
            return new XjywBean(in);
        }

        @Override
        public XjywBean[] newArray(int size) {
            return new XjywBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(xjdw);
        dest.writeString(txz);
        dest.writeString(jcsj);
        dest.writeString(jcfzr);
        dest.writeString(zt);
        dest.writeString(xjlx);
        dest.writeByte((byte) (flag ? 1 : 0));
    }

    public String getXjdw() {
        return xjdw;
    }

    public void setXjdw(String xjdw) {
        this.xjdw = xjdw;
    }

    public String getTxz() {
        return txz;
    }

    public void setTxz(String txz) {
        this.txz = txz;
    }

    public String getJcsj() {
        return jcsj;
    }

    public void setJcsj(String jcsj) {
        this.jcsj = jcsj;
    }

    public String getJcfzr() {
        return jcfzr;
    }

    public void setJcfzr(String jcfzr) {
        this.jcfzr = jcfzr;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getXjlx() {
        return xjlx;
    }

    public void setXjlx(String xjlx) {
        this.xjlx = xjlx;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public static Creator<XjywBean> getCREATOR() {
        return CREATOR;
    }

    @Override
    public String toString() {
        return "XjywBean{" +
                "xjdw='" + xjdw + '\'' +
                ", txz='" + txz + '\'' +
                ", jcsj='" + jcsj + '\'' +
                ", jcfzr='" + jcfzr + '\'' +
                ", zt='" + zt + '\'' +
                ", xjlx='" + xjlx + '\'' +
                ", flag=" + flag +
                '}';
    }
}
