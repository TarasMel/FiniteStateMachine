package com.example.taras.finitestatemachine.car;

/**
 * Created by Taras on 21.02.2018.
 */

public interface Action {

    boolean check_action (CarState carState);

    CarState action (CarState carState);
}
