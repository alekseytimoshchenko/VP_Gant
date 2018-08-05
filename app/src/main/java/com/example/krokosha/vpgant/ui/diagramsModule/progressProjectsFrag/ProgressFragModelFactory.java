package com.example.krokosha.vpgant.ui.diagramsModule.progressProjectsFrag;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.krokosha.vpgant.data.repo.Repo;

/**
 * Created with care by Alexey.T on 04/08/2018.
 * <p>
 * TODO: Add a class header comment!
 */
public class ProgressFragModelFactory extends ViewModelProvider.NewInstanceFactory
{
	private Repo mRepo;
	
	public ProgressFragModelFactory(final Repo iRepo)
	{
		mRepo = iRepo;
	}
	
	@NonNull
	@Override
	public <T extends ViewModel> T create(@NonNull final Class<T> modelClass)
	{
		if (modelClass == ProgressViewModel.class)
		{
			return (T) new ProgressViewModel(mRepo);
		}
		
		return null;
	}
}
