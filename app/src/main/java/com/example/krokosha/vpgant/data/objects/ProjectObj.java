package com.example.krokosha.vpgant.data.objects;

import android.support.annotation.IntDef;
import android.text.SpannableString;

import com.github.mikephil.charting.data.PieEntry;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with care by Alexey.T on 04/08/2018.
 * <p>
 * TODO: Add a class header comment!
 */
public class ProjectObj
{
	private int mId = -1;
	private SpannableString mName;
	private int mIsInProgress = NOT_DEFINED;
	private List<PieEntry> mEntries = new ArrayList<>();
	
	public static final int IN_PROGRESS = 1;
	public static final int FINISHED = 2;
	public static final int NOT_DEFINED = 3;
	
	@IntDef(value = {IN_PROGRESS, FINISHED, NOT_DEFINED})
	@Retention(RetentionPolicy.SOURCE)
	@interface ProjectState
	{
	}
	
	public ProjectObj()
	{
	}
	
	public ProjectObj(int iId, final SpannableString iName, @ProjectState int iIsInProgress, final List<PieEntry> iEntries)
	{
		mId = iId;
		mName = iName;
		mIsInProgress = iIsInProgress;
		mEntries = iEntries;
	}
	
	public SpannableString getProjName()
	{
		return mName;
	}
	
	public boolean isInProgress()
	{
		return mIsInProgress == IN_PROGRESS;
	}
	
	public List<PieEntry> getEntries()
	{
		return mEntries;
	}
	
	public int getId()
	{
		return mId;
	}
}
