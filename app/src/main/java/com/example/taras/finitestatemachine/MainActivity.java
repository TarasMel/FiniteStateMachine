package com.example.taras.finitestatemachine;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.taras.finitestatemachine.car.ActionState;


import butterknife.ButterKnife;
import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    private final ActionState START_STATE = ActionState.AlarmDisarmed_AllUnlocked;
    private ActionState CURRENT_STATE = START_STATE;

    @BindView(R.id.textView_actionTitle_ID)
    TextView textView;

    @BindView(R.id.btn_lock1_ID)
    Button btn_lock1;
    @BindView(R.id.btn_lock2_ID)
    Button btn_lock2;
    @BindView(R.id.btn_unlock1_ID)
    Button btn_unlock1;
    @BindView(R.id.btn_unlock2_ID)
    Button btn_unlock2;

    @OnClick({R.id.btn_lock1_ID, R.id.btn_lock2_ID, R.id.btn_unlock1_ID, R.id.btn_unlock2_ID})
    void onClick (View view){
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    public ActionState updateUI (ActionState currentState){
        textView.setText(getResources().getString(currentState.getResString()));
        textView.setBackgroundResource(currentState.getResColor());
        return currentState;
    }
}


