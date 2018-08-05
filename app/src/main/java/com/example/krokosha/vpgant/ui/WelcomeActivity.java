package com.example.krokosha.vpgant.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.motion.MotionLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.krokosha.vpgant.R;

public class WelcomeActivity extends AppCompatActivity
{
	private MotionLayout mMotionLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		mMotionLayout = findViewById(R.id.motionLayout);
		mMotionLayout.setShowPaths(false);
	}
	
	public void changeState(View view)
	{
		if (mMotionLayout.getProgress() > 0.5f)
		{
			mMotionLayout.transitionToStart();
		}
		else
		{
			mMotionLayout.transitionToEnd();
		}
	}
	
	public void doOnGotIt(View view)
	{
		startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
		overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
		finish();
	}
}
