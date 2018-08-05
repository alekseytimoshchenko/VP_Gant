package com.example.krokosha.vpgant.di.components;

import com.example.krokosha.vpgant.di.moduls.DescriptionActModule;
import com.example.krokosha.vpgant.di.scopes.DescriptionActScope;
import com.example.krokosha.vpgant.ui.descriptionModule.DescriptionActivity;

import dagger.Subcomponent;

@DescriptionActScope
@Subcomponent(modules = DescriptionActModule.class)
public interface DescriptionActComponent extends ActivityComponent<DescriptionActivity>
{
	@Subcomponent.Builder
	interface Builder extends ActivityComponentBuilder<DescriptionActComponent, DescriptionActModule>
	{
	
	}
}
