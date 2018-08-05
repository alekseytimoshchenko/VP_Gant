package com.example.krokosha.vpgant.ui.diagramsModule.progressProjectsFrag;

import android.arch.lifecycle.ViewModel;

import com.example.krokosha.vpgant.data.objects.ProjectObj;
import com.example.krokosha.vpgant.data.repo.Repo;
import com.example.krokosha.vpgant.utils.liveData.SingleLiveEvent;

import java.util.List;

/**
 * Created with care by Alexey.T on 04/08/2018.
 * <p>
 * TODO: Add a class header comment!
 */
class ProgressViewModel extends ViewModel
{
	private Repo mRepo;
	
	SingleLiveEvent<List<ProjectObj>> entitySingleLiveData = new SingleLiveEvent<>();
	
	SingleLiveEvent<Integer> itemClicked = new SingleLiveEvent<>();
	
	ProgressViewModel(final Repo iRepo)
	{
		mRepo = iRepo;
	}
	
	void getEntities()
	{
		entitySingleLiveData.setValue(mRepo.getProjectsList(Repo.IN_PROGRESS));
	}
	
	void itemClicked(int iPosition)
	{
		itemClicked.setValue(iPosition);
	}
}
