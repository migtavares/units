/**
 * Copyright 2012 
 *         J. Miguel P. Tavares <mtavares@bitpipeline.eu>
 *         BitPipeline
 */
package org.bitpipeline.lib.units.deriv.velocity;

import org.bitpipeline.lib.units.AbstractUnit;
import org.bitpipeline.lib.units.Unit;

/** Beaufort Scale (wind speed) - it's not a proper "unit". 10 is not 2 times 5 with this "scale".
 * <p>Nevertheless it's useful for sailor to be able to use it so we use a
 * bijective function to convert from one to another.</p>
 * <p><i>There's a myth that the formula 0.876 * bf^3/2 can be used to convert from
 * beaufort to m/s. It doesn't work for small values.</i></p>
 * 
 * <p>Additional to using it as a unit you have a enumeration of the official scale
 * and you can use the method {@link BeaufortScale#getScale(double)} to get the proper
 * designation for a certain beaufort "value".</p>
 * @author mtavares */
public class BeaufortScale extends AbstractUnit {
	static final private BeaufortScale UNIT = new BeaufortScale ();

	/** A enumeration of the Beaufort types of wind.*/
	public static enum BeaufortScaleType {
		CALM,
		LIGHT_AIR,
		LIGHT_BREEZE,
		GENTLE_BREEZE,
		MODERATE_BREEZE,
		FRESH_BREEZE,
		STRONG_BREEZE,
		HIGH_WIND,
		GALE,
		STRONG_GALE,
		STORM,
		VIOLENT_STORM,
		HURRICANE
	}

	static final private double[][] CONVERSION_TABLE_D = {
		// m/s, bf, A, B; A used for m/s to bf, B used for bf to m/s
		{ 0.0,  0.0, 1.0/( 0.3 -  0.0), ( 0.3 -  0.0)},
		{ 0.0,  0.3, 1.0/( 0.3 -  0.0), ( 0.3 -  0.0)},
		{ 1.0,  1.6, 1.0/( 1.6 -  0.3), ( 1.6 -  0.3)},
		{ 2.0,  3.4, 1.0/( 3.4 -  1.6), ( 3.4 -  1.6)},
		{ 3.0,  5.5, 1.0/( 5.5 -  3.4), ( 5.5 -  3.4)},
		{ 4.0,  8.0, 1.0/( 8.0 -  5.5), ( 8.0 -  5.5)},
		{ 5.0, 10.8, 1.0/(10.8 -  8.0), (10.8 -  8.0)},
		{ 6.0, 13.9, 1.0/(13.9 - 10.8), (13.9 - 10.8)},
		{ 7.0, 17.2, 1.0/(17.2 - 13.9), (17.2 - 13.9)},
		{ 8.0, 20.8, 1.0/(20.8 - 17.2), (20.8 - 17.2)},
		{ 9.0, 24.5, 1.0/(24.5 - 20.8), (24.5 - 20.8)},
		{10.0, 28.5, 1.0/(28.5 - 24.5), (28.5 - 24.5)},
		{11.0, 32.7, 1.0/(32.7 - 28.5), (32.7 - 28.5)},
		{12.0, Double.MAX_VALUE, 1.0/(32.7 - 28.5),(32.7 - 28.5)}
	};

	static final private float[][] CONVERSION_TABLE_F = {
		// m/s, bf, A, B; A used for m/s to bf, B used for bf to m/s
		{ 0.0f,  0.0f, 1.0f/( 0.3f -  0.0f), ( 0.3f -  0.0f)},
		{ 0.0f,  0.3f, 1.0f/( 0.3f -  0.0f), ( 0.3f -  0.0f)},
		{ 1.0f,  1.6f, 1.0f/( 1.6f -  0.3f), ( 1.6f -  0.3f)},
		{ 2.0f,  3.4f, 1.0f/( 3.4f -  1.6f), ( 3.4f -  1.6f)},
		{ 3.0f,  5.5f, 1.0f/( 5.5f -  3.4f), ( 5.5f -  3.4f)},
		{ 4.0f,  8.0f, 1.0f/( 8.0f -  5.5f), ( 8.0f -  5.5f)},
		{ 5.0f, 10.8f, 1.0f/(10.8f -  8.0f), (10.8f -  8.0f)},
		{ 6.0f, 13.9f, 1.0f/(13.9f - 10.8f), (13.9f - 10.8f)},
		{ 7.0f, 17.2f, 1.0f/(17.2f - 13.9f), (17.2f - 13.9f)},
		{ 8.0f, 20.8f, 1.0f/(20.8f - 17.2f), (20.8f - 17.2f)},
		{ 9.0f, 24.5f, 1.0f/(24.5f - 20.8f), (24.5f - 20.8f)},
		{10.0f, 28.5f, 1.0f/(28.5f - 24.5f), (28.5f - 24.5f)},
		{11.0f, 32.7f, 1.0f/(32.7f - 28.5f), (32.7f - 28.5f)},
		{12.0f, Float.MAX_VALUE, 1.0f/(32.7f - 28.5f),(32.7f - 28.5f)}
	};

	private BeaufortScale () {
		super ("beaufort scale", "bf", VelocityDimension.dimension());
	}

	static public Unit unit () {
		return BeaufortScale.UNIT;
	}

	/* (non-Javadoc)
	 * @see org.bitpipeline.lib.units.Unit#getUnit() */
	@Override
	public Unit getUnit () {
		return BeaufortScale.UNIT;
	}

	/** Convert a BeaufortValue into it's corresponding entry in the scale.
	 * @param bfValue is the speed in beaufort units. 
	 * @return the corresponding scale enumeration entry. */
	static public BeaufortScaleType getScale (double bfValue) {
		int index = (int) Math.floor (bfValue);
		if (index < 0)
			index = 0;
		else if (index >= BeaufortScaleType.values ().length)
			index = BeaufortScaleType.values ().length-1;
		return BeaufortScaleType.values ()[index];
	}

	@Override
	public float convertToSIBase (float value) {
		float absValue = Math.abs(value);
		int i;
		for (i=0; i < BeaufortScale.CONVERSION_TABLE_F.length-2; i++) {
			if (absValue < BeaufortScale.CONVERSION_TABLE_F[i+1][0])
				break;
		}
		float fracPart = 0.0f;
		float base = BeaufortScale.CONVERSION_TABLE_F[i-1][1];
		float d = BeaufortScale.CONVERSION_TABLE_F[i][3];
		fracPart = (absValue - BeaufortScale.CONVERSION_TABLE_F[i][0])*d;
		return base + fracPart;
	}

	@Override
	public double convertToSIBase (double value) {
		double absValue = Math.abs(value);

		int i;
		for (i=0; i < BeaufortScale.CONVERSION_TABLE_D.length-2; i++) {
			if (absValue < BeaufortScale.CONVERSION_TABLE_D[i+1][0])
				break;
		}
		double fracPart = 0.0;
		double base = BeaufortScale.CONVERSION_TABLE_D[i-1][1];
		double d = BeaufortScale.CONVERSION_TABLE_D[i][3];
		fracPart = (absValue - BeaufortScale.CONVERSION_TABLE_D[i][0])*d;
		return base + fracPart;
	}

	@Override
	public float convertFromSIBase (float value) {
		float absValue = Math.abs(value);
		int i;
		for (i=0; i < BeaufortScale.CONVERSION_TABLE_F.length-1; i++) {
			if (absValue < BeaufortScale.CONVERSION_TABLE_F[i][1])
				break;
		}
		float fracPart;
		float d = BeaufortScale.CONVERSION_TABLE_F[i][2];
		fracPart = (value - BeaufortScale.CONVERSION_TABLE_F[i-1][1]) * d;
		return BeaufortScale.CONVERSION_TABLE_F[i][0] + fracPart;
	}

	@Override
	public double convertFromSIBase (double value) {
		double absValue = Math.abs(value);
		int i;
		for (i=0; i < BeaufortScale.CONVERSION_TABLE_D.length-1; i++) {
			if (absValue < BeaufortScale.CONVERSION_TABLE_D[i][1])
				break;
		}
		double fracPart;
		double d = BeaufortScale.CONVERSION_TABLE_D[i][2];
		fracPart = (value - BeaufortScale.CONVERSION_TABLE_D[i-1][1]) * d;
		return BeaufortScale.CONVERSION_TABLE_D[i][0] + fracPart;

	}
}
