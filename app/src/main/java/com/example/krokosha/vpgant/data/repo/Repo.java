package com.example.krokosha.vpgant.data.repo;

import android.support.annotation.IntDef;

import com.example.krokosha.vpgant.data.local.DB;
import com.example.krokosha.vpgant.data.objects.ProjectObj;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/**
 * Created with care by Alexey.T on 04/08/2018.
 * <p>
 * TODO: Add a class header comment!
 */
public class Repo
{
	public static final int ALL = 0;
	public static final int IN_PROGRESS = 1;
	public static final int FINISHED = 2;
	
	@IntDef(value = {ALL, IN_PROGRESS, FINISHED})
	@Retention(RetentionPolicy.SOURCE)
	public @interface Sort
	{
	}
	
	private DB mDB;
	
	public Repo(final DB iDB)
	{
		mDB = iDB;
	}
	
	public List<ProjectObj> getProjectsList(@Repo.Sort int iState)
	{
		return mDB.getProjectsList(iState);
	}
	
	public ProjectObj getProjectByPosition(int iPosition)
	{
		return mDB.getProjectByPosition(iPosition);
	}
}
