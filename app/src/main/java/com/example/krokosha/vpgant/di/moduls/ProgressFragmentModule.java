package com.example.krokosha.vpgant.di.moduls;

import com.example.krokosha.vpgant.data.repo.Repo;
import com.example.krokosha.vpgant.di.scopes.ProgressProjectsScope;
import com.example.krokosha.vpgant.ui.diagramsModule.progressProjectsFrag.ProgressFragModelFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Created with care by Alexey.T on 04/08/2018.
 * <p>
 * TODO: Add a class header comment!
 */
@Module
public class ProgressFragmentModule implements ActivityModule
{
	@ProgressProjectsScope
	@Provides
	ProgressFragModelFactory getProgressFragModel(Repo iRepo)
	{
		return new ProgressFragModelFactory(iRepo);
	}
}
