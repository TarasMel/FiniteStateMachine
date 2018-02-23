package com.example.taras.finitestatemachine;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.taras.finitestatemachine.car.ActionState;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textView;
    private final ActionState START_STATE = ActionState.AlarmDisarmed_AllUnlocked;
    private ActionState CURRENT_STATE = START_STATE;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.text_action_ID);
        Button btn_lock1 = (Button) findViewById(R.id.btn_lock1_ID);
        Button btn_lock2 = (Button) findViewById(R.id.btn_lock2_ID);
        Button btn_unlock1 = (Button) findViewById(R.id.btn_unlock1_ID);
        Button btn_unlock2 = (Button) findViewById(R.id.btn_unlock2_ID);
        btn_lock1.setOnClickListener(this);
        btn_lock2.setOnClickListener(this);
        btn_unlock1.setOnClickListener(this);
        btn_unlock2.setOnClickListener(this);
    }

    public ActionState updateUI (ActionState currentState){
        textView.setText(getResources().getString(currentState.getResString()));
        textView.setBackgroundResource(currentState.getResColor());
        return currentState;
    }

   @Override
    public void onClick (View view){
        switch (view.getId()){
            case R.id.btn_lock1_ID:
                if (CURRENT_STATE.getResString() != ActionState.AlarmArmed_AllLocked.getResString()) {
                    CURRENT_STATE = updateUI(ActionState.AlarmDisarmed_AllLocked);
                }
                break;
            case R.id.btn_lock2_ID:
                CURRENT_STATE = updateUI(ActionState.AlarmArmed_AllLocked);
                break;
            case R.id.btn_unlock1_ID:
                if (CURRENT_STATE.getResString() != ActionState.AlarmDisarmed_AllUnlocked.getResString()) {
                    CURRENT_STATE = updateUI(ActionState.AlarmDisarmed_DriverUnlocked);
                }
                break;
            case R.id.btn_unlock2_ID:
                if (CURRENT_STATE.getResString() != ActionState.AlarmDisarmed_DriverUnlocked.getResString()){
                    CURRENT_STATE = updateUI(ActionState.AlarmDisarmed_AllUnlocked);
                }
                break;
        }
    }
}


