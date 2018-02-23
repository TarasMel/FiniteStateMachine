package com.example.taras.finitestatemachine;

import android.app.Activity;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;


@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 25, manifest = "android\\build\\intermediates\\manifests\\full\\debug\\src\\main\\AndroidManifest.xml",
        packageName = "com.example.taras.finitestatemachine")
public class MainActivityTest {

    private Activity mActivity;
    private Button mButton;
    private TextView mTextView;

    @Before
    public void setup() throws Exception{
//        mActivity = Robolectric.buildActivity(MainActivity.class).create().get();
//        mButton = (Button) mActivity.findViewById(R.id.btn_lock1_ID);
//        mTextView = (TextView) mActivity.findViewById(R.id.text_action_ID);
    }

    @Test
    public void testForTextViewToBeChangedAfterClick() throws Exception{
//        mButton.performClick();
 //       String resultText = mTextView.getText().toString();
 //       assertEquals("Alarm disarmed, all locked",resultText);
    }
}
