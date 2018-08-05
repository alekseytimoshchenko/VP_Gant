package com.example.krokosha.vpgant.ui.descriptionModule;

import android.arch.lifecycle.ViewModel;

import com.example.krokosha.vpgant.data.objects.ProjectObj;
import com.example.krokosha.vpgant.data.repo.Repo;
import com.example.krokosha.vpgant.utils.liveData.SingleLiveEvent;

public class DescriptionViewModel extends ViewModel
{
	private Repo mRepo;
	
	SingleLiveEvent<ProjectObj> projectLiveData = new SingleLiveEvent<>();
	
	DescriptionViewModel(final Repo iRepo)
	{
		mRepo = iRepo;
	}
	
	public void getProjectByPosition(int iPosition)
	{
		projectLiveData.setValue(mRepo.getProjectByPosition(iPosition));
	}
}
