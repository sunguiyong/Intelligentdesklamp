package com.scinan.intelligentdesklamp.views.clock.bean;

public class ClockBean {
    private String time;
    private String day;
    private boolean isOpen;

    public ClockBean() {
    }

    public ClockBean(String time, String day, boolean isOpen) {
        this.time = time;
        this.day = day;
        this.isOpen = isOpen;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
