package com.example.krokosha.vpgant.di.components;

import com.example.krokosha.vpgant.di.moduls.FinishedFragmentModule;
import com.example.krokosha.vpgant.di.scopes.FinishedFragmentScope;
import com.example.krokosha.vpgant.ui.diagramsModule.finishProjectFrag.FinishedProjectsFragment;

import dagger.Subcomponent;

/**
 * Created with care by Alexey.T on 04/08/2018.
 * <p>
 * TODO: Add a class header comment!
 */
@FinishedFragmentScope
@Subcomponent(modules = {FinishedFragmentModule.class})
public interface FinishedFragmentComponent extends ActivityComponent<FinishedProjectsFragment>
{
	@Subcomponent.Builder
	interface Builder extends ActivityComponentBuilder<FinishedFragmentComponent, FinishedFragmentModule>
	{
	
	}
}
