package com.example.taras.finitestatemachine.car;


import com.example.taras.finitestatemachine.R;

public enum ActionState {
    AlarmArmed_AllLocked(R.string.alarm_armed_all_locked, R.color.tvBackgroundG),
    AlarmDisarmed_AllLocked(R.string.alarm_disarmed_all_locked, R.color.tvBackgroundR),
    AlarmDisarmed_DriverUnlocked(R.string.alarm_disarmed_driver_unlocked, R.color.tvBackgroundR),
    AlarmDisarmed_AllUnlocked(R.string.alarm_disarmed_all_unlocked, R.color.tvBackgroundR);

    private int resString;
    private int resColor;

    ActionState (int resString, int resColor){
        this.resString = resString;
        this.resColor = resColor;
    }

    public int getResString() {
        return resString;
    }

    public int getResColor() {
        return resColor;
    }
}
