package com.example.nguyenductuan.myapplication.Model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Video implements Serializable
{

    @SerializedName("idVideo")
    @Expose
    private String idVideo;
    @SerializedName("TenVideo")
    @Expose
    private String tenVideo;
    @SerializedName("CasiVideo")
    @Expose
    private String casiVideo;
    @SerializedName("HinhVideo")
    @Expose
    private String hinhVideo;
    @SerializedName("LinkVideo")
    @Expose
    private String linkVideo;
    private final static long serialVersionUID = -6684654771244806285L;

    public String getIdVideo() {
    return idVideo;
    }

    public void setIdVideo(String idVideo) {
    this.idVideo = idVideo;
    }

    public String getTenVideo() {
    return tenVideo;
    }

    public void setTenVideo(String tenVideo) {
    this.tenVideo = tenVideo;
    }

    public String getCasiVideo() {
    return casiVideo;
    }

    public void setCasiVideo(String casiVideo) {
    this.casiVideo = casiVideo;
    }

    public String getHinhVideo() {
    return hinhVideo;
    }

    public void setHinhVideo(String hinhVideo) {
    this.hinhVideo = hinhVideo;
    }

    public String getLinkVideo() {
    return linkVideo;
    }

    public void setLinkVideo(String linkVideo) {
    this.linkVideo = linkVideo;
    }

}