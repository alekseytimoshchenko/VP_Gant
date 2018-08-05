package com.example.krokosha.vpgant.di.moduls;

import com.example.krokosha.vpgant.data.repo.Repo;
import com.example.krokosha.vpgant.di.scopes.DescriptionActScope;
import com.example.krokosha.vpgant.ui.descriptionModule.DescriptionActModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class DescriptionActModule implements ActivityModule
{
	@DescriptionActScope
	@Provides
	DescriptionActModelFactory getFactory(Repo iRepo)
	{
		return new DescriptionActModelFactory(iRepo);
	}
}
