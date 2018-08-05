package com.example.krokosha.vpgant.ui.diagramsModule.finishProjectFrag;

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
class FinishedFragViewModel extends ViewModel
{
	private Repo mRepo;
	
	SingleLiveEvent<List<ProjectObj>> entitySingleLiveData = new SingleLiveEvent<>();
	
	SingleLiveEvent<Integer> itemClicked = new SingleLiveEvent<>();
	
	FinishedFragViewModel(final Repo iRepo)
	{
		mRepo = iRepo;
	}
	
	void getEntities()
	{
		entitySingleLiveData.setValue(mRepo.getProjectsList(Repo.FINISHED));
	}
	
	void itemClicked(int iPosition)
	{
		itemClicked.setValue(iPosition);
	}
}
