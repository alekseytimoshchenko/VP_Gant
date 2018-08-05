package com.example.krokosha.vpgant.di.moduls;

import com.example.krokosha.vpgant.data.repo.Repo;
import com.example.krokosha.vpgant.di.scopes.FinishedFragmentScope;
import com.example.krokosha.vpgant.ui.diagramsModule.finishProjectFrag.FinishedFragModelFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Created with care by Alexey.T on 04/08/2018.
 * <p>
 * TODO: Add a class header comment!
 */
@Module
public class FinishedFragmentModule implements ActivityModule
{
	@FinishedFragmentScope
	@Provides
	FinishedFragModelFactory getFinishedFragmentFactory(Repo iRepo)
	{
		return new FinishedFragModelFactory(iRepo);
	}
}
