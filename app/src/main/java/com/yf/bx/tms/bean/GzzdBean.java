package com.yf.bx.tms.bean;

/**规章制度实体类
 * Created by bai on 2016/11/23.
 */

public class GzzdBean {

    private String isGzzd;
    private String fileName;//需要后缀
    private String data;
    private String fileUrl;

    public GzzdBean() {
    }

    public String getIsGzzd() {
        return isGzzd;
    }

    public void setIsGzzd(String isGzzd) {
        this.isGzzd = isGzzd;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
