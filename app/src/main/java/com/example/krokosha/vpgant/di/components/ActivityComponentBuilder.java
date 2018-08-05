package com.example.krokosha.vpgant.di.components;

import com.example.krokosha.vpgant.di.moduls.ActivityModule;

/**
 * Created with care by Alexey.T on 04/08/2018.
 * <p>
 * TODO: Add a class header comment!
 */
public interface ActivityComponentBuilder<C extends ActivityComponent, M extends ActivityModule>
{
	C build();
	
	ActivityComponentBuilder<C, M> module(M module);
}
