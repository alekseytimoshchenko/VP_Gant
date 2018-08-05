package com.example.krokosha.vpgant.ui.descriptionModule;

import android.animation.Animator;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.krokosha.vpgant.App;
import com.example.krokosha.vpgant.R;
import com.example.krokosha.vpgant.data.objects.ProjectObj;
import com.example.krokosha.vpgant.utils.Constants;
import com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class DescriptionActivity extends AppCompatActivity
{
	@BindView(R.id.tb_dashboard)
	Toolbar mToolbar;
	
	@BindView(R.id.pb_description_act)
	RoundedHorizontalProgressBar mPB;
	
	@BindView(R.id.tv_description_act_percentage)
	TextView mPers;
	
	@BindView(R.id.first_name)
	TextView mFirstName;
	
	@BindView(R.id.second_name)
	TextView mSecondName;
	
	@BindView(R.id.thirdName)
	TextView mThirdName;
	
	@BindView(R.id.iv_cool)
	ImageView mImageView;
	
	@Inject
	DescriptionActModelFactory mFactory;
	
	private ProjectObj mProjectObj;
	
	private DescriptionViewModel mModel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_description);
		ButterKnife.bind(this);
		App.getApp(this).getComponentsHolder().getActivityComponent(getClass()).inject(this);
		
		setSupportActionBar(mToolbar);
		getSupportActionBar().setIcon(R.mipmap.ic_launcher);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		
		obtainViewModel();
		subscribeToModel();
		requestProject();
		
		
		//		animatePB();
	}
	
	private void requestProject()
	{
		mModel.getProjectByPosition(getIntent().getIntExtra(Constants.ITEM_POSITION, 0));
	}
	
	private void subscribeToModel()
	{
		mModel.projectLiveData.observe(this, iProjectObj -> {
			mProjectObj = iProjectObj;
			animatePB();
		});
	}
	
	private void obtainViewModel()
	{
		mModel = ViewModelProviders.of(this, mFactory).get(DescriptionViewModel.class);
	}
	
	private void animatePB()
	{
		int to = 30;
		
		if (!mProjectObj.isInProgress())
		{
			to = 100;
			mFirstName.setText("Aleksey");
			mSecondName.setText("Sergey");
			mThirdName.setText("Elena");
			
			Observable.just("")//
			          .delay(1500, TimeUnit.MILLISECONDS)//
			          .observeOn(AndroidSchedulers.mainThread())//
			          .doOnNext(iS -> openCoolImage())//
			          .subscribe();
		}
		
		mPers.setText(String.valueOf(to) + "%");
		mPB.animateProgress(1000, 0, to);
	}
	
	private void openCoolImage()
	{
		// get the center for the clipping circle
		int cx = mImageView.getWidth() / 2;
		int cy = mImageView.getHeight() / 2;
		
		// get the final radius for the clipping circle
		float finalRadius = (float) Math.hypot(cx, cy);
		
		// create the animator for this view (the start radius is zero)
		Animator anim = ViewAnimationUtils.createCircularReveal(mImageView, cx, cy, 0, finalRadius);
		
		// make the view visible and start the animation
		mImageView.setVisibility(View.VISIBLE);
		anim.start();
	}
	
	@Override
	public void onBackPressed()
	{
		super.onBackPressed();
		overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
	}
	
	@Override
	public boolean onSupportNavigateUp()
	{
		onBackPressed();
		return true;
	}
}
