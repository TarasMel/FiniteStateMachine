package com.example.taras.finitestatemachine;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;


import static org.junit.Assert.assertEquals;



@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class,  manifest = Config.DEFAULT_MANIFEST_NAME)

public class MainActivityTest {


    private Button mButton_lock1;
    private Button mButton_lock2;
    private Button mButton_unlock1;
    private Button mButton_unlock2;
    private TextView mTextView;

//    private final ActionState START_STATE = ActionState.AlarmDisarmed_AllUnlocked;
//    private ActionState CURRENT_STATE = START_STATE;



    @Before
    public void setup() throws Exception{
        Activity mActivity = Robolectric.buildActivity(MainActivity.class).create().get();
        mButton_lock1 = (Button) mActivity.findViewById(R.id.btn_lock1_ID);
        mButton_lock2 = (Button) mActivity.findViewById(R.id.btn_lock2_ID);
        mButton_unlock1 = (Button) mActivity.findViewById(R.id.btn_unlock1_ID);
        mButton_unlock2 = (Button) mActivity.findViewById(R.id.btn_unlock2_ID);
        mTextView = (TextView) mActivity.findViewById(R.id.textView_actionTitle_ID);
    }

    @Test
    public void testForTextViewToBeChangedAfterClickButtonLock1AnyState() throws Exception{
        //Start TextView equals Alarm_Disarmed_All_Unlock
        mButton_lock1.performClick();
        String result = mTextView.getText().toString();
        assertEquals(result, "Alarm disarmed, all locked");
        //Another State
        mButton_lock2.performClick();
        mButton_lock1.performClick();
        String result2 = mTextView.getText().toString();
        assertEquals(result2, "Alarm armed, all locked");
    }

    @Test
    public void testForTextViewToBeChangedAfterClickButtonLock2AnyState() throws Exception {
        mButton_lock1.performClick();
        mButton_unlock1.performClick();
        mButton_unlock2.performClick();
        mButton_lock2.performClick();
        String result = mTextView.getText().toString();
        assertEquals(result, "Alarm armed, all locked");
    }

    @Test
    public void testForTextViewToBeChangedAfterClickButtonUnLock1AnyState() throws Exception{
        //Start TextView equals Alarm_Disarmed_All_Unlock
        mButton_unlock1.performClick();
        String result = mTextView.getText().toString();
        assertEquals(result, "Alarm disarmed, all unlocked");
        //Another State
        mButton_lock2.performClick();
        mButton_unlock1.performClick();
        String result2 = mTextView.getText().toString();
        assertEquals(result2, "Alarm disarmed, driver unlocked");
    }

    @Test
    public void testForTextViewToBeChangedAfterClickButtonUnLock2AnyState() throws Exception{
        //Start TextView equals Alarm_Disarmed_All_Unlock
        mButton_unlock2.performClick();
        String result = mTextView.getText().toString();
        assertEquals(result, "Alarm disarmed, all unlocked");
        //Another State
        mButton_lock2.performClick();
        mButton_unlock1.performClick();
        String result2 = mTextView.getText().toString();
        assertEquals(result2, "Alarm disarmed, driver unlocked");
    }
}
