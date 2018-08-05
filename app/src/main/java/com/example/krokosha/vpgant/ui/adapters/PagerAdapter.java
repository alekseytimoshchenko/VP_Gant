package com.example.krokosha.vpgant.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.krokosha.vpgant.ui.diagramsModule.finishProjectFrag.FinishedProjectsFragment;
import com.example.krokosha.vpgant.ui.diagramsModule.progressProjectsFrag.ProgressProjectsFragment;

/**
 * Created with care by Alexey.T on 02/08/2018.
 */
public class PagerAdapter extends FragmentStatePagerAdapter
{
	private int mNumOfTabs;
	
	public PagerAdapter(FragmentManager fm, int NumOfTabs)
	{
		super(fm);
		this.mNumOfTabs = NumOfTabs;
	}
	
	@Override
	public Fragment getItem(int position)
	{
		switch (position)
		{
			case 0:
				return new FinishedProjectsFragment();
			case 1:
				return new ProgressProjectsFragment();
			default:
				return null;
		}
	}
	
	@Override
	public int getCount()
	{
		return mNumOfTabs;
	}
}
