package com.example.krokosha.vpgant.ui.descriptionModule;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.krokosha.vpgant.data.repo.Repo;

public class DescriptionActModelFactory extends ViewModelProvider.NewInstanceFactory
{
	private Repo mRepo;

	public DescriptionActModelFactory(final Repo iRepo)
	{
		mRepo = iRepo;
	}

	@NonNull
	@Override
	public <T extends ViewModel> T create(@NonNull final Class<T> modelClass)
	{
		if (modelClass == DescriptionViewModel.class)
		{
			return (T) new DescriptionViewModel(mRepo);
		}

		return null;
	}
}
