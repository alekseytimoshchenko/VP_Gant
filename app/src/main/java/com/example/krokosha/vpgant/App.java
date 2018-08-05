package com.example.krokosha.vpgant;

import android.app.Application;
import android.content.Context;

import com.example.krokosha.vpgant.di.ComponentsHolder;

/**
 * Created with care by Alexey.T on 01/08/2018.
 * <p>
 * TODO: Add a class header comment!
 */
public class App extends Application
{
	private ComponentsHolder componentsHolder;
	
	public static App getApp(Context context)
	{
		return (App) context.getApplicationContext();
	}
	
	@Override
	public void onCreate()
	{
		super.onCreate();
		
		componentsHolder = new ComponentsHolder(this);
		componentsHolder.init();
	}
	
	public ComponentsHolder getComponentsHolder()
	{
		return componentsHolder;
	}
}
