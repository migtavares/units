/**
 * 
 */
package org.bitpipeline.lib.units;

/** Kilometer per hour
 * @author mtavares */
public class KMeterPerHour extends AbstractUnit {
	static final private KMeterPerHour UNIT = new KMeterPerHour ();

	private KMeterPerHour () {
		super ("km/h", LengthDimension.dimension(), TimeDimension.dimension());
	}

	static public Unit unit () {
		return KMeterPerHour.UNIT;
	}

	/* @see org.bitpipeline.app.windsurfcalculator.units.Unit#getUnit() */
	public Unit getUnit () {
		return KMeterPerHour.unit ();
	}

	/* @see org.bitpipeline.app.windsurfcalculator.units.AbstractUnit#convertValueToSiBase(double) */
	@Override
	double convertValueToSiBase (double value) {
		return value / 3.6d;
	}

	/* @see org.bitpipeline.app.windsurfcalculator.units.AbstractUnit#convertValueFromSiBase(double) */
	@Override
	double convertValueFromSiBase (double value) {
		return value * 3.6d;
	}

}
