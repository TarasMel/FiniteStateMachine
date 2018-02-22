package com.example.taras.finitestatemachine.car;



public class CarState {
    private String currentState;
    private int colorBackground;

    public CarState(){}

    public CarState(String currentState, int colorBackground) {
        this.currentState = currentState;
        this.colorBackground = colorBackground;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public int getColorBackground() {
        return colorBackground;
    }

    public void setColorBackground(int colorBackround) {
        this.colorBackground = colorBackround;
    }

    @Override
    public String toString() {
        return currentState;
    }
}
