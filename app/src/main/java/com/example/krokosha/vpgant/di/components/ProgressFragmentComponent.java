package com.example.krokosha.vpgant.di.components;

import com.example.krokosha.vpgant.di.moduls.ProgressFragmentModule;
import com.example.krokosha.vpgant.di.scopes.ProgressProjectsScope;
import com.example.krokosha.vpgant.ui.diagramsModule.progressProjectsFrag.ProgressProjectsFragment;

import dagger.Subcomponent;

/**
 * Created with care by Alexey.T on 04/08/2018.
 * <p>
 * TODO: Add a class header comment!
 */
@ProgressProjectsScope
@Subcomponent(modules = {ProgressFragmentModule.class})
public interface ProgressFragmentComponent extends ActivityComponent<ProgressProjectsFragment>
{
	@Subcomponent.Builder
	interface Builder extends ActivityComponentBuilder<ProgressFragmentComponent, ProgressFragmentModule>
	{
	
	}
}
