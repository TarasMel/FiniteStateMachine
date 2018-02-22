package com.example.taras.finitestatemachine;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.taras.finitestatemachine.car.ActionLock1;
import com.example.taras.finitestatemachine.car.ActionLock2;
import com.example.taras.finitestatemachine.car.ActionUnlock1;
import com.example.taras.finitestatemachine.car.ActionUnlock2;
import com.example.taras.finitestatemachine.car.CarState;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textView;
    private Button btn_lock1;
    private Button btn_lock2;
    private Button btn_unlock1;
    private Button btn_unlock2;
    CarState carState = new CarState();
    private ActionLock1 actionLock1 = new ActionLock1();
    private ActionLock2 actionLock2 = new ActionLock2();
    private ActionUnlock1 actionUnlock1 = new ActionUnlock1();
    private ActionUnlock2 actionUnlock2 = new ActionUnlock2();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        carState.setCurrentState(res.getString(R.string.alarm_disarmed_all_unlocked));
        carState.setColorBackground(R.color.tvBackgroundR);

        textView = (TextView)findViewById(R.id.text_action_ID);
        btn_lock1 = (Button) findViewById(R.id.btn_lock1_ID);
        btn_lock2 = (Button) findViewById(R.id.btn_lock2_ID);
        btn_unlock1 = (Button) findViewById(R.id.btn_unlock1_ID);
        btn_unlock2 = (Button) findViewById(R.id.btn_unlock2_ID);
        btn_lock1.setOnClickListener(this);
        btn_lock2.setOnClickListener(this);
        btn_unlock1.setOnClickListener(this);
        btn_unlock2.setOnClickListener(this);
    }


   @Override
    public void onClick (View view){
        switch (view.getId()){
            case R.id.btn_lock1_ID:
                if (actionLock1.check_action(carState)){}
                else {
                    textView.setText(actionLock1.action(carState).getCurrentState());
                    textView.setBackgroundResource(actionLock1.action(carState).getColorBackground());
                }
                break;
            case R.id.btn_lock2_ID:
                textView.setText(actionLock2.action(carState).getCurrentState());
                textView.setBackgroundResource(actionLock2.action(carState).getColorBackground());
                break;
            case R.id.btn_unlock1_ID:
                if (actionUnlock1.check_action(carState)){}
                else {
                    textView.setText(actionUnlock1.action(carState).getCurrentState());
                    textView.setBackgroundResource(actionUnlock1.action(carState).getColorBackground());
                }
                break;
            case R.id.btn_unlock2_ID:
                if (actionUnlock2.check_action(carState)){}
                else {
                    textView.setText(actionUnlock2.action(carState).getCurrentState());
                    textView.setBackgroundResource(actionUnlock2.action(carState).getColorBackground());
                }
                break;
        }
    }
}


