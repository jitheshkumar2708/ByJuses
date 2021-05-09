package com.example.byjuses.UI;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.byjuses.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class MainActivityTest {

  @Rule
  public ActivityTestRule<MainActivity> mainActivityActivityTestRule=new ActivityTestRule<MainActivity>(MainActivity.class);
  private MainActivity mainActivity=null;

    @Before
    public void setUp() throws Exception {
      mainActivity=mainActivityActivityTestRule.getActivity();
    }
    @Test
    public void testLaunch()
    {

      View view=mainActivity.findViewById(R.id.toolbar_title);
      assertNotNull(view);
    }


    @After
    public void tearDown() throws Exception {
      mainActivity=null;
    }
}