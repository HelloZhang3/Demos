package com.zyd.demos.test;

import com.zyd.demos.MainActivity;
import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


public class dsd extends ActivityInstrumentationTestCase2<MainActivity> {
  	private Solo solo;
  	
  	public dsd() {
		super(MainActivity.class);
  	}

  	public void setUp() throws Exception {
        super.setUp();
		solo = new Solo(getInstrumentation());
		getActivity();
  	}
  
   	@Override
   	public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
  	}
  
	public void testRun() {
        //Wait for activity: 'com.zyd.demos.MainActivity'
		solo.waitForActivity(com.zyd.demos.MainActivity.class, 2000);
        //Set default small timeout to 27979 milliseconds
		Timeout.setSmallTimeout(27979);
        //Click on recycleView
		solo.clickOnView(solo.getView(com.zyd.demos.R.id.btn_recycle_view));
	}
}
