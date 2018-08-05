package com.example.krokosha.vpgant.utils;

import com.github.mikephil.charting.animation.EasingFunction;

/**
 * Created with care by Alexey.T on 04/08/2018.
 * <p>
 * TODO: Add a class header comment!
 */
public class Easing
{
	@SuppressWarnings("unused")
	public static final EasingFunction EaseInOutQuad = input -> {
		input *= 2f;
		
		if (input < 1f) {
			return 0.5f * input * input;
		}
		
		return -0.5f * ((--input) * (input - 2f) - 1f);
	};
}
