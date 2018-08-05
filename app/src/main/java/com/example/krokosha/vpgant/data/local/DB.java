package com.example.krokosha.vpgant.data.local;

import com.example.krokosha.vpgant.data.objects.ProjectObj;
import com.example.krokosha.vpgant.data.repo.Repo;
import com.example.krokosha.vpgant.utils.Naming;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

import static com.example.krokosha.vpgant.data.repo.Repo.ALL;
import static com.example.krokosha.vpgant.data.repo.Repo.FINISHED;
import static com.example.krokosha.vpgant.data.repo.Repo.IN_PROGRESS;

/**
 * Created with care by Alexey.T on 04/08/2018.
 * <p>
 * TODO: Add a class header comment!
 */
public class DB
{
	private List<ProjectObj> mProjectsList = new ArrayList<>();
	
	public DB()
	{
		defineMockData();
	}
	
	/**
	 * {@link DB#defineMockData()} method that we use in debug mode to define mock data
	 */
	private void defineMockData()
	{
		mProjectsList = new ArrayList<ProjectObj>()
		{{
			add(new ProjectObj(1, Naming.getHumanResourceShareApplicationName(), ProjectObj.IN_PROGRESS, new ArrayList<PieEntry>()
			{{
				add(new PieEntry(15, "Dev"));
				add(new PieEntry(16, "Sales"));
				add(new PieEntry(26, "QA"));
				add(new PieEntry(32, "Design"));
			}}));
			
			add(new ProjectObj(2, Naming.getDigitalCurrencyTradePlatformName(), ProjectObj.IN_PROGRESS, new ArrayList<PieEntry>()
			{{
				add(new PieEntry(34, "Dev"));
				add(new PieEntry(23, "Sales"));
				add(new PieEntry(45, "QA"));
				add(new PieEntry(13, "Design"));
			}}));
			
			add(new ProjectObj(3, Naming.getWorkHoursMobileAppName(), ProjectObj.IN_PROGRESS, new ArrayList<PieEntry>()
			{{
				add(new PieEntry(12, "Dev"));
				add(new PieEntry(14, "Sales"));
				add(new PieEntry(35, "QA"));
				add(new PieEntry(26, "Design"));
			}}));
			
			add(new ProjectObj(4, Naming.getOrganizationAtmosphereCheckSystemName(), ProjectObj.IN_PROGRESS, new ArrayList<PieEntry>()
			{{
				add(new PieEntry(17, "Dev"));
				add(new PieEntry(15, "Sales"));
				add(new PieEntry(26, "QA"));
				add(new PieEntry(34, "Design"));
			}}));
			
			add(new ProjectObj(5, Naming.getHumanResourceShareApplicationName(), ProjectObj.IN_PROGRESS, new ArrayList<PieEntry>()
			{{
				add(new PieEntry(15, "Dev"));
				add(new PieEntry(16, "Sales"));
				add(new PieEntry(26, "QA"));
				add(new PieEntry(32, "Design"));
			}}));
			
			add(new ProjectObj(6, Naming.getDigitalCurrencyTradePlatformName(), ProjectObj.IN_PROGRESS, new ArrayList<PieEntry>()
			{{
				add(new PieEntry(34, "Dev"));
				add(new PieEntry(23, "Sales"));
				add(new PieEntry(45, "QA"));
				add(new PieEntry(13, "Design"));
			}}));
			
			add(new ProjectObj(7, Naming.getWorkHoursMobileAppName(), ProjectObj.IN_PROGRESS, new ArrayList<PieEntry>()
			{{
				add(new PieEntry(12, "Dev"));
				add(new PieEntry(14, "Sales"));
				add(new PieEntry(35, "QA"));
				add(new PieEntry(26, "Design"));
			}}));
			
			add(new ProjectObj(8, Naming.getOrganizationAtmosphereCheckSystemName(), ProjectObj.IN_PROGRESS, new ArrayList<PieEntry>()
			{{
				add(new PieEntry(17, "Dev"));
				add(new PieEntry(15, "Sales"));
				add(new PieEntry(26, "QA"));
				add(new PieEntry(34, "Design"));
			}}));
			
			add(new ProjectObj(9, Naming.getVisualProjectDashboardName(), ProjectObj.FINISHED, new ArrayList<PieEntry>()
			{{
				add(new PieEntry(100, "Dev"));
				add(new PieEntry(100, "Sales"));
				add(new PieEntry(100, "QA"));
				add(new PieEntry(100, "Design"));
			}}));
		}};
	}
	
	public List<ProjectObj> getProjectsList(@Repo.Sort int iState)
	{
		List<ProjectObj> result;
		
		switch (iState)
		{
			case ALL:
			{
				result = mProjectsList;
				break;
			}
			case IN_PROGRESS:
			{
				result = Observable.fromIterable(mProjectsList).filter(ProjectObj::isInProgress).toList().blockingGet();
				break;
			}
			case FINISHED:
			{
				result = Observable.fromIterable(mProjectsList).filter(iProjectObj -> !iProjectObj.isInProgress()).toList().blockingGet();
				break;
			}
			default:
			{
				result = mProjectsList;
				break;
			}
		}
		
		return result;
	}
	
	public ProjectObj getProjectByPosition(int iPosition)
	{
		if (iPosition < 0 || mProjectsList.isEmpty())
		{
			return new ProjectObj();
		}
		
		return mProjectsList.get(iPosition - 1);
	}
}

