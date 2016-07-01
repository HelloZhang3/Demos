package com.zyd.demos.test;

import com.zyd.demos.MainActivity;
import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


public class sss extends ActivityInstrumentationTestCase2<MainActivity> {
  	private Solo solo;
  	
  	public sss() {
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
        //Take screenshot
        solo.takeScreenshot();
        //Take screenshot
        solo.takeScreenshot();
        //Wait for activity: 'com.zyd.demos.MainActivity'
		solo.waitForActivity(com.zyd.demos.MainActivity.class, 2000);
        //Click on recycleView
		solo.clickOnView(solo.getView(com.zyd.demos.R.id.btn_recycle_view));
        //Wait for activity: 'com.zyd.demos.RecycleViewActivity'
		assertTrue("com.zyd.demos.RecycleViewActivity is not found!", solo.waitForActivity(com.zyd.demos.RecycleViewActivity.class));
        //Click on ImageView
		solo.clickOnView(solo.getView(android.widget.ImageView.class, 4));
        //Click on add
		solo.clickInList(1, 0);
        //Click on ImageView
		solo.clickOnView(solo.getView(android.widget.ImageView.class, 4));
        //Click on delete
		solo.clickInList(2, 0);
        //Click on ImageView
		solo.clickOnView(solo.getView(android.widget.ImageView.class, 4));
        //Click on add
		solo.clickInList(1, 0);
        //Press menu back key
		solo.goBack();
        //Click on swipeRefreshLayout
		solo.clickOnView(solo.getView(com.zyd.demos.R.id.btn_swipe_refresh_layout));
        //Wait for activity: 'com.zyd.demos.SwipeRefreshLayoutActivity'
		assertTrue("com.zyd.demos.SwipeRefreshLayoutActivity is not found!", solo.waitForActivity(com.zyd.demos.SwipeRefreshLayoutActivity.class));
        //Set default small timeout to 39290 milliseconds
		Timeout.setSmallTimeout(39290);
        //Press menu back key
		solo.goBack();
        //Click on recycleView
		solo.clickOnView(solo.getView(com.zyd.demos.R.id.btn_recycle_view));
        //Wait for activity: 'com.zyd.demos.RecycleViewActivity'
		assertTrue("com.zyd.demos.RecycleViewActivity is not found!", solo.waitForActivity(com.zyd.demos.RecycleViewActivity.class));
	}
}
