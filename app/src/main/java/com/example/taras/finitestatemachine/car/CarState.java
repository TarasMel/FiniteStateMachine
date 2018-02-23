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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarState carState = (CarState) o;

        if (colorBackground != carState.colorBackground) return false;
        return currentState.equals(carState.currentState);

    }

    @Override
    public int hashCode() {
        int result = currentState.hashCode();
        result = 31 * result + colorBackground;
        return result;
    }
}
