package com.scinan.intelligentdesklamp.views.clock.setting;

public class DateAndTimeEvent {
    private boolean hour24;
    private boolean autoDateAndTime;
    private boolean autoTimeZoon;

    public DateAndTimeEvent() {
    }

    public DateAndTimeEvent(boolean hour24, boolean autoDateAndTime, boolean autoTimeZoon) {
        this.hour24 = hour24;
        this.autoDateAndTime = autoDateAndTime;
        this.autoTimeZoon = autoTimeZoon;
    }

    public boolean isHour24() {
        return hour24;
    }

    public void setHour24(boolean hour24) {
        this.hour24 = hour24;
    }

    public boolean isAutoDateAndTime() {
        return autoDateAndTime;
    }

    public void setAutoDateAndTime(boolean autoDateAndTime) {
        this.autoDateAndTime = autoDateAndTime;
    }

    public boolean isAutoTimeZoon() {
        return autoTimeZoon;
    }

    public void setAutoTimeZoon(boolean autoTimeZoon) {
        this.autoTimeZoon = autoTimeZoon;
    }
}
