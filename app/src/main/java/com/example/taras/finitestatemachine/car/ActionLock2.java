package com.example.taras.finitestatemachine.car;

import com.example.taras.finitestatemachine.R;

/**
 * Created by Taras on 21.02.2018.
 */

public class ActionLock2 implements Action {
    @Override
    public boolean check_action(CarState carState) {
        return true;
    }

    @Override
    public CarState action(CarState carState) {
        carState.setCurrentState("Alarm armed, all locked");
        carState.setColorBackground(R.color.tvBackgroundG);
        return carState;
    }
}
