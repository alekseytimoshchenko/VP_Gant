package com.example.krokosha.vpgant.ui;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;

import com.example.krokosha.vpgant.R;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class SplashActivity extends AppCompatActivity
{
	@BindView(R.id.av_splash_android)
	View mAndroidView;
	
	public static final int ANIMATION_TIME = 2500;
	public static final int SEC = 1000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		ButterKnife.bind(this);
		
		Observable.just("")//
		          .delay(ANIMATION_TIME, TimeUnit.MILLISECONDS)//
		          .observeOn(AndroidSchedulers.mainThread())//
		          .doOnNext(iS -> openAndroidView())//
		          .delay(SEC, TimeUnit.MILLISECONDS)
		          .observeOn(AndroidSchedulers.mainThread())//
		          .doOnNext(iS -> goToWelcomeActivity())//
		          .subscribe();
	}
	
	private void openAndroidView()
	{
		// get the center for the clipping circle
		int cx = mAndroidView.getWidth() / 2;
		int cy = mAndroidView.getHeight() / 2;
		
		// get the final radius for the clipping circle
		float finalRadius = (float) Math.hypot(cx, cy);
		
		// create the animator for this view (the start radius is zero)
		Animator anim = ViewAnimationUtils.createCircularReveal(mAndroidView, cx, cy, 0, finalRadius);
		
		// make the view visible and start the animation
		mAndroidView.setVisibility(View.VISIBLE);
		anim.start();
	}
	
	public void goToWelcomeActivity()
	{
		startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));
		overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
		finish();
	}
}
