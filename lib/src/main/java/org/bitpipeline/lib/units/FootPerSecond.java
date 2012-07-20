package org.bitpipeline.lib.units;

public final class FootPerSecond extends AbstractUnit {
	static final private FootPerSecond UNIT = new FootPerSecond ();

	public FootPerSecond () {
		super ("Foot per second", "ft/s", LengthDimension.dimension(), TimeDimension.dimension());
	}

	static public Unit unit () {
		return FootPerSecond.UNIT;
	}

	@Override
	public Unit getUnit () {
		return FootPerSecond.UNIT;
	}

	@Override
	double convertValueToSiBase (double value) {
		return value * 0.3048;
	}

	@Override
	double convertValueFromSiBase (double value) {
		return value / 0.3048;
	}

}
