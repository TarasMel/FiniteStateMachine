package com.example.taras.finitestatemachine;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import com.example.taras.finitestatemachine.car.ActionState;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;



@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 25, manifest = Config.DEFAULT_MANIFEST_NAME,
        packageName = "com.example.taras.finitestatemachine", resourceDir = Config.DEFAULT_RES_FOLDER)

public class MainActivityTest {


    private Button mButton_lock1;
    private Button mButton_lock2;
    private Button mButton_unlock1;
    private Button mButton_unlock2;
    private TextView mTextView;
    private final ActionState START_STATE = ActionState.AlarmDisarmed_AllUnlocked;
    private ActionState CURRENT_STATE = START_STATE;



    @Before
    public void setup() throws Exception{
        Activity mActivity = Robolectric.buildActivity(MainActivity.class).create().get();
        mButton_lock1 = (Button) mActivity.findViewById(R.id.btn_lock1_ID);
        mButton_lock2 = (Button) mActivity.findViewById(R.id.btn_lock2_ID);
        mButton_unlock1 = (Button) mActivity.findViewById(R.id.btn_unlock1_ID);
        mButton_unlock2 = (Button) mActivity.findViewById(R.id.btn_unlock2_ID);
        mTextView = (TextView) mActivity.findViewById(R.id.text_action_ID);
    }

    @Test
    public void ClockOnUnlock1() throws Exception{
        System.out.println(mTextView.getText().toString());
        mButton_unlock2.performClick();
        String str = mTextView.getText().toString();
        System.out.println("-------------");
        System.out.println(str);
        mButton_lock2.performClick();
        String str2 = mTextView.getText().toString();
        System.out.println("-------------");
        System.out.println(str2);
        mButton_unlock1.performClick();
        String str3 = mTextView.getText().toString();
        System.out.println("-------------");
        System.out.println(str3);
    }
}
