package com.scinan.intelligentdesklamp.views.datashow.bean;

public class RightEyeDataBean {
    private String time;
    private String vision;

    public RightEyeDataBean() {
    }

    public RightEyeDataBean(String time, String vision) {
        this.time = time;
        this.vision = vision;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }
}
