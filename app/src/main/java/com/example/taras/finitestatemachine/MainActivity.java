package com.example.taras.finitestatemachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button btn_lock1;
    Button btn_lock2;
    Button btn_unlock1;
    Button btn_unlock2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.text_action_ID);

        btn_lock1 = (Button) findViewById(R.id.btn_lock1_ID);
        btn_lock1.setOnClickListener(this);
        btn_lock2 = (Button) findViewById(R.id.btn_lock2_ID);
        btn_lock2.setOnClickListener(this);
        btn_unlock1 = (Button) findViewById(R.id.btn_unlock1_ID);
        btn_unlock1.setOnClickListener(this);
        btn_unlock2 = (Button) findViewById(R.id.btn_unlock2_ID);
        btn_unlock2.setOnClickListener(this);

    }

    @Override
    public void onClick (View view){
        switch (view.getId()){
            case R.id.btn_lock1_ID:
                break;
            case R.id.btn_lock2_ID:
                break;
            case R.id.btn_unlock1_ID:
                break;
            case R.id.btn_unlock2_ID:
                break;
        }
    }
}
