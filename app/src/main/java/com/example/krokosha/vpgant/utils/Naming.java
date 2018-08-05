package com.example.krokosha.vpgant.utils;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

import com.github.mikephil.charting.utils.ColorTemplate;

/**
 * Created with care by Alexey.T on 04/08/2018.
 * <p>
 * TODO: Add a class header comment!
 */
public class Naming
{
	public static SpannableString getHumanResourceShareApplicationName()
	{
		SpannableString s = new SpannableString("Human resource share application\ndeveloped by Someone");
		s.setSpan(new RelativeSizeSpan(.8f), 0, 32, 0);
		s.setSpan(new StyleSpan(Typeface.NORMAL), 32, s.length() - 8, 0);
		s.setSpan(new ForegroundColorSpan(Color.GRAY), 32, s.length() - 8, 0);
		s.setSpan(new RelativeSizeSpan(.6f), 32, s.length() - 8, 0);
		s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 8, s.length(), 0);
		s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 8, s.length(), 0);
		
		return s;
	}
	
	public static SpannableString getDigitalCurrencyTradePlatformName()
	{
		SpannableString s = new SpannableString("Digital currency trade platform\ndeveloped by Someone");
		s.setSpan(new RelativeSizeSpan(.8f), 0, 31, 0);
		s.setSpan(new StyleSpan(Typeface.NORMAL), 31, s.length() - 8, 0);
		s.setSpan(new ForegroundColorSpan(Color.GRAY), 31, s.length() - 8, 0);
		s.setSpan(new RelativeSizeSpan(.6f), 31, s.length() - 8, 0);
		s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 8, s.length(), 0);
		s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 8, s.length(), 0);
		
		return s;
	}
	
	public static SpannableString getWorkHoursMobileAppName()
	{
		SpannableString s = new SpannableString("Work hours mobile app\ndeveloped by Someone");
		s.setSpan(new RelativeSizeSpan(.8f), 0, 21, 0);
		s.setSpan(new StyleSpan(Typeface.NORMAL), 21, s.length() - 8, 0);
		s.setSpan(new ForegroundColorSpan(Color.GRAY), 21, s.length() - 8, 0);
		s.setSpan(new RelativeSizeSpan(.6f), 21, s.length() - 8, 0);
		s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 8, s.length(), 0);
		s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 8, s.length(), 0);
		
		return s;
	}
	
	public static SpannableString getOrganizationAtmosphereCheckSystemName()
	{
		SpannableString s = new SpannableString("Organization atmosphere check system\ndeveloped by Someone");
		s.setSpan(new RelativeSizeSpan(.8f), 0, 36, 0);
		s.setSpan(new StyleSpan(Typeface.NORMAL), 36, s.length() - 8, 0);
		s.setSpan(new ForegroundColorSpan(Color.GRAY), 36, s.length() - 8, 0);
		s.setSpan(new RelativeSizeSpan(.6f), 36, s.length() - 8, 0);
		s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 8, s.length(), 0);
		s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 8, s.length(), 0);
		
		return s;
	}
	
	public static SpannableString getVisualProjectDashboardName()
	{
		SpannableString s = new SpannableString("Visual Project Dashboard\ndeveloped by WINNER TEAM");
		s.setSpan(new RelativeSizeSpan(.8f), 0, 24, 0);
		s.setSpan(new StyleSpan(Typeface.NORMAL), 24, s.length() - 12, 0);
		s.setSpan(new ForegroundColorSpan(Color.GRAY), 24, s.length() - 12, 0);
		s.setSpan(new RelativeSizeSpan(.6f), 24, s.length() - 12, 0);
		s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 12, s.length(), 0);
		s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 12, s.length(), 0);
		
		return s;
	}
}
