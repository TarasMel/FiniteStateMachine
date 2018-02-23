package com.example.taras.finitestatemachine;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import com.example.taras.finitestatemachine.car.ActionLock1;
import com.example.taras.finitestatemachine.car.ActionLock2;
import com.example.taras.finitestatemachine.car.ActionUnlock1;
import com.example.taras.finitestatemachine.car.ActionUnlock2;
import com.example.taras.finitestatemachine.car.CarState;

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

    private Activity mActivity;
    private Button mButton_lock1;
    private Button mButton_lock2;
    private Button mButton_unlock1;
    private Button mButton_unlock2;
    private TextView mTextView;

    private ActionLock1 actionLock1 = new ActionLock1();
    private ActionLock2 actionLock2 = new ActionLock2();
    private ActionUnlock1 actionUnlock1 = new ActionUnlock1();
    private ActionUnlock2 actionUnlock2 =new ActionUnlock2();


    @Before
    public void setup() throws Exception{
        mActivity = Robolectric.buildActivity(MainActivity.class).create().get();
        mButton_lock1 = (Button) mActivity.findViewById(R.id.btn_lock1_ID);
        mButton_lock2 = (Button) mActivity.findViewById(R.id.btn_lock2_ID);
        mButton_unlock1 = (Button) mActivity.findViewById(R.id.btn_unlock1_ID);
        mButton_unlock2 = (Button) mActivity.findViewById(R.id.btn_unlock2_ID);
        mTextView = (TextView) mActivity.findViewById(R.id.text_action_ID);
    }
    //checking start state after clicking button Lock
    @Test
    public void testForTextViewToBeChangedAfterClickButtonLock1StartState() throws Exception {
        //create start state
        CarState carState_start = new CarState();
        carState_start.setCurrentState(mTextView.toString());
        carState_start.setColorBackground(R.color.tvBackgroundR);
        //user click
        mButton_lock1.performClick();
        //get result from action method
        actionLock1.action(carState_start);
        //get result from change TextView
        String resultText = mTextView.getText().toString();
        //Creating correct item
        CarState carState_res = new CarState();
        carState_res.setCurrentState("Alarm disarmed, all locked");
        carState_res.setColorBackground(R.color.tvBackgroundG);
        carState_res.equals(actionLock1.action(carState_start));
        assertEquals(resultText, carState_res.getCurrentState());
    }

    //checking another state after clicking button Unlock
    @Test
    public void testForTextViewToBeChangedAfterClickButtonLock1ElseState() throws Exception {
        //changing start state
        mButton_lock2.performClick();
        CarState carState_start = new CarState();
        carState_start.setCurrentState(mTextView.toString());
        carState_start.setColorBackground(R.color.tvBackgroundR);
        //user click
        mButton_lock1.performClick();
        //get result from action method
        actionLock1.action(carState_start);
        //get result from change TextView
        String resultText = mTextView.getText().toString();
        //Creating correct item
        CarState carState_res = new CarState();
        carState_res.setCurrentState("Alarm armed, all locked");
        carState_res.setColorBackground(R.color.tvBackgroundG);
        carState_res.equals(actionLock1.action(carState_start));
        assertEquals(resultText, carState_res.getCurrentState());
    }

    //checking start state after clicking button Lock2
    @Test
    public void testForTextViewToBeChangedAfterClickButtonLock2StartState() throws Exception {
        //create start state
        CarState carState_start = new CarState();
        carState_start.setCurrentState(mTextView.toString());
        carState_start.setColorBackground(R.color.tvBackgroundR);
        //user click
        mButton_lock2.performClick();
        //get result from action method
        actionLock2.action(carState_start);
        //get result from change TextView
        String resultText = mTextView.getText().toString();
        //Creating correct item
        CarState carState_res = new CarState();
        carState_res.setCurrentState("Alarm armed, all locked");
        carState_res.setColorBackground(R.color.tvBackgroundG);
        carState_res.equals(actionLock2.action(carState_start));
        assertEquals(resultText, carState_res.getCurrentState());
    }

    //checking another state after clicking button Unlock
    @Test
    public void testForTextViewToBeChangedAfterClickButtonLock2ElseState() throws Exception {
        //create another state
        mButton_unlock2.performClick();
        CarState carState_start = new CarState();
        carState_start.setCurrentState(mTextView.toString());
        carState_start.setColorBackground(R.color.tvBackgroundR);
        //user click
        mButton_lock2.performClick();
        //get result from action method
        actionLock2.action(carState_start);
        //get result from change TextView
        String resultText = mTextView.getText().toString();
        //Creating correct item
        CarState carState_res = new CarState();
        carState_res.setCurrentState("Alarm armed, all locked");
        carState_res.setColorBackground(R.color.tvBackgroundG);
        carState_res.equals(actionLock2.action(carState_start));
        assertEquals(resultText, carState_res.getCurrentState());
    }

    //checking start state after clicking button Unlock
    @Test
    public void testForTextViewToBeChangedAfterClickButtonUnlock1StartState() throws Exception {
        //change start state
        CarState carState_start = new CarState();
        carState_start.setCurrentState(mTextView.toString());
        carState_start.setColorBackground(R.color.tvBackgroundR);
        //user click
        mButton_unlock1.performClick();
        //get result from action method
        actionUnlock1.action(carState_start);
        //get result from change TextView
        String resultText = mTextView.getText().toString();
        //Creating correct item
        CarState carState_res = new CarState();
        carState_res.setCurrentState("Alarm disarmed, all unlocked");
        carState_res.setColorBackground(R.color.tvBackgroundG);
        carState_res.equals(actionUnlock1.action(carState_start));
        assertEquals(resultText, carState_res.getCurrentState());
    }

    //checking another state after clicking button Unlock
    @Test
    public void testForTextViewToBeChangedAfterClickButtonUnlock1ElseState() throws Exception {
        //change start state on Alarm disarmed, all locked
        mButton_lock1.performClick();
        CarState carState_start = new CarState();
        carState_start.setCurrentState(mTextView.toString());
        carState_start.setColorBackground(R.color.tvBackgroundR);
        //user click
        mButton_unlock1.performClick();
        //get result from action method
        actionUnlock1.action(carState_start);
        //get result from change TextView
        String resultText = mTextView.getText().toString();
        //Creating correct item
        CarState carState_res = new CarState();
        carState_res.setCurrentState("Alarm disarmed, driver unlocked");
        carState_res.setColorBackground(R.color.tvBackgroundG);
        carState_res.equals(actionUnlock1.action(carState_start));
        assertEquals(resultText, carState_res.getCurrentState());
    }

    //checking start state after clicking button Unlock
    @Test
    public void testForTextViewToBeChangedAfterClickButtonUnlock2StartState() throws Exception {
        //create start state
        CarState carState_start = new CarState();
        carState_start.setCurrentState(mTextView.toString());
        carState_start.setColorBackground(R.color.tvBackgroundR);
        //user click
        mButton_unlock2.performClick();
        //get result from action method
        actionUnlock1.action(carState_start);
        //get result from change TextView
        String resultText = mTextView.getText().toString();
        //Creating correct item
        CarState carState_res = new CarState();
        carState_res.setCurrentState("Alarm disarmed, all unlocked");
        carState_res.setColorBackground(R.color.tvBackgroundG);
        carState_res.equals(actionUnlock2.action(carState_start));
        assertEquals(resultText, carState_res.getCurrentState());
    }

    //checking another state after clicking button Unlock
    @Test
    public void testForTextViewToBeChangedAfterClickButtonUnlock2ElseState() throws Exception {
        //change start state on Alarm disarmed, all locked
        mButton_lock1.performClick();
        CarState carState_start = new CarState();
        carState_start.setCurrentState(mTextView.toString());
        carState_start.setColorBackground(R.color.tvBackgroundR);
        //user click
        mButton_unlock2.performClick();
        //get result from action method
        actionUnlock1.action(carState_start);
        //get result from change TextView
        String resultText = mTextView.getText().toString();
        //Creating correct item
        CarState carState_res = new CarState();
        carState_res.setCurrentState("Alarm disarmed, all unlocked");
        carState_res.setColorBackground(R.color.tvBackgroundG);
        carState_res.equals(actionUnlock2.action(carState_start));
        assertEquals(resultText, carState_res.getCurrentState());
    }
}
