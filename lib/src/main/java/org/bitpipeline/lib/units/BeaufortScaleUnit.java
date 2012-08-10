/**
 * Copyright 2012 
 *         J. Miguel P. Tavares <mtavares@bitpipeline.eu>
 *         BitPipeline
 */
package org.bitpipeline.lib.units;

/** Beaufort scale is not a proper "unit". 10 is not 2 times 5 with this "scale".
 * Nevertheless it's usefull for sailor to be able to use it so we use a
 * bijective function to convert from one to another.
 * There's a mith that the formula 0.876 * bf^3/2 can be used to convert from
 * beaufort to m/s. It doesn't work for small values.
 * 
 * Additional to using it as a unit you have a enumeration of the official scale
 * and you can use the method <code>getScale (double)</code> to get the proper
 * designation for a certain beufort "value".
 * @author mtavares */
public class BeaufortScaleUnit extends AbstractUnit {
	static final private BeaufortScaleUnit UNIT = new BeaufortScaleUnit ();

	public static enum BeaufortScale {
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

	static final private double[][] CONVERSION_TABLE = {
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

	private BeaufortScaleUnit () {
		super ("bf", LengthDimension.dimension(), TimeDimension.dimension());
	}

	static public Unit unit () {
		return BeaufortScaleUnit.UNIT;
	}

	/* (non-Javadoc)
	 * @see org.bitpipeline.lib.units.Unit#getUnit() */
	@Override
	public Unit getUnit () {
		return BeaufortScaleUnit.UNIT;
	}

	/* (non-Javadoc)
	 * @see org.bitpipeline.lib.units.AbstractUnit#convertValueToSiBase(double) */
	@Override
	double convertValueToSiBase (double value) {
		double absValue = Math.abs(value);

		int i;
		for (i=0; i < BeaufortScaleUnit.CONVERSION_TABLE.length-2; i++) {
			if (absValue < BeaufortScaleUnit.CONVERSION_TABLE[i+1][0])
				break;
		}
		double fracPart = 0.0;
		double base = BeaufortScaleUnit.CONVERSION_TABLE[i-1][1];
		double d = BeaufortScaleUnit.CONVERSION_TABLE[i][3];
		fracPart = (absValue - BeaufortScaleUnit.CONVERSION_TABLE[i][0])*d;
		return base + fracPart;
	}

	/* (non-Javadoc)
	 * @see org.bitpipeline.lib.units.AbstractUnit#convertValueFromSiBase(double) */
	@Override
	double convertValueFromSiBase (double value) {
		double absValue = Math.abs(value);
		int i;
		for (i=0; i < BeaufortScaleUnit.CONVERSION_TABLE.length-1; i++) {
			if (absValue < BeaufortScaleUnit.CONVERSION_TABLE[i][1])
				break;
		}
		double fracPart;
		double d = BeaufortScaleUnit.CONVERSION_TABLE[i][2];
		fracPart = (value - BeaufortScaleUnit.CONVERSION_TABLE[i-1][1]) * d;
		return BeaufortScaleUnit.CONVERSION_TABLE[i][0] + fracPart;
	}

	/**
	 * @param bfValue is the speed in beaufort units. 
	 * @return the corresponding scale enumeration entry. */
	public BeaufortScale getScale (double bfValue) {
		int index = (int) Math.floor (bfValue);
		if (index < 0) index = 0;
		else if (index > 12) index = 12;
		return BeaufortScale.values ()[index];
	}
}
