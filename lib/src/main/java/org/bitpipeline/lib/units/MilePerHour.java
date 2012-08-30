package org.bitpipeline.lib.units;

public final class MilePerHour extends AbstractUnit {
	static final private MilePerHour UNIT = new MilePerHour ();

	public MilePerHour () {
		super ("Miles per hour", "mph", LengthDimension.dimension(), TimeDimension.dimension());
	}

	static public Unit unit () {
		return MilePerHour.UNIT;
	}

	@Override
	public Unit getUnit () {
		return MilePerHour.UNIT;
	}

	@Override
	double convertValueToSiBase (double value) {
		return value * 0.44704;
	}

	@Override
	double convertValueFromSiBase (double value) {
		return value / 0.44704;
	}

}
