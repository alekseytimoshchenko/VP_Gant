package com.example.krokosha.vpgant.di.moduls;

import android.content.Context;

import com.example.krokosha.vpgant.data.local.DB;
import com.example.krokosha.vpgant.data.repo.Repo;
import com.example.krokosha.vpgant.di.components.ActivityComponentBuilder;
import com.example.krokosha.vpgant.di.components.DescriptionActComponent;
import com.example.krokosha.vpgant.di.components.FinishedFragmentComponent;
import com.example.krokosha.vpgant.di.components.ProgressFragmentComponent;
import com.example.krokosha.vpgant.di.scopes.AppScope;
import com.example.krokosha.vpgant.ui.descriptionModule.DescriptionActivity;
import com.example.krokosha.vpgant.ui.diagramsModule.finishProjectFrag.FinishedProjectsFragment;
import com.example.krokosha.vpgant.ui.diagramsModule.progressProjectsFrag.ProgressProjectsFragment;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

/**
 * Created with care by Alexey.T on 04/08/2018.
 * <p>
 * TODO: Add a class header comment!
 */
@Module(subcomponents = {ProgressFragmentComponent.class, FinishedFragmentComponent.class, DescriptionActComponent.class})
public class AppModule
{
	private final Context context;
	
	public AppModule(Context context)
	{
		this.context = context;
	}
	
	@AppScope
	@Provides
	Context provideContext()
	{
		return context;
	}
	
	@AppScope
	@Provides
	Repo getRepo(DB iDB)
	{
		return new Repo(iDB);
	}
	
	@AppScope
	@Provides
	DB getDB()
	{
		return new DB();
	}
	
	@Provides
	@IntoMap
	@ClassKey(ProgressProjectsFragment.class)
	ActivityComponentBuilder provideProgressProjectsFragmentBuilder(ProgressFragmentComponent.Builder iBuilder)
	{
		return iBuilder;
	}
	
	@Provides
	@IntoMap
	@ClassKey(FinishedProjectsFragment.class)
	ActivityComponentBuilder provideFinishedProjectsFragmentBuilder(FinishedFragmentComponent.Builder iBuilder)
	{
		return iBuilder;
	}
	
	@Provides
	@IntoMap
	@ClassKey(DescriptionActivity.class)
	ActivityComponentBuilder provideDescriptionActBuilder(DescriptionActComponent.Builder iBuilder)
	{
		return iBuilder;
	}
}
