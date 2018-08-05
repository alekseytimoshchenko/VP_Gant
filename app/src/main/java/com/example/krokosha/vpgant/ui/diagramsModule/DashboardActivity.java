package com.example.krokosha.vpgant.ui.diagramsModule;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.krokosha.vpgant.R;
import com.example.krokosha.vpgant.ui.adapters.PagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity
{
	@BindView(R.id.tb_dashboard)
	Toolbar mToolbar;
	
	@BindView(R.id.tl_dashboard)
	TabLayout mTabLayout;
	
	@BindView(R.id.vp_dashboard)
	ViewPager mViewPager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		ButterKnife.bind(this);
		
		setSupportActionBar(mToolbar);
		getSupportActionBar().setIcon(R.mipmap.ic_launcher);
		
		mTabLayout.addTab(mTabLayout.newTab().setText("Finished"));
		mTabLayout.addTab(mTabLayout.newTab().setText("In Progress"));
		mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
		
		final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
		mViewPager.setAdapter(adapter);
		mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
		
		mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
		{
			@Override
			public void onTabSelected(TabLayout.Tab tab)
			{
				mViewPager.setCurrentItem(tab.getPosition());
			}
			
			@Override
			public void onTabUnselected(TabLayout.Tab tab)
			{
			
			}
			
			@Override
			public void onTabReselected(TabLayout.Tab tab)
			{
			
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
}
