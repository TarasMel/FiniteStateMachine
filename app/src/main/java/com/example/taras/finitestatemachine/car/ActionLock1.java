package com.example.taras.finitestatemachine.car;

import com.example.taras.finitestatemachine.R;

/**
 * Created by Taras on 21.02.2018.
 */

public class ActionLock1 implements Action {
    @Override
    public boolean check_action(CarState carState) {
        if (carState.getCurrentState().equalsIgnoreCase("Alarm armed, all locked")) return true;
        return false;
    }

    @Override
    public CarState action (CarState carState) {
        if (check_action(carState));
        else {
            carState.setCurrentState("Alarm disarmed, all locked");
            carState.setColorBackground(R.color.tvBackgroundG);
        }
        return carState;
    }
}
