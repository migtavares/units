package org.bitpipeline.lib.units;

final public class HourUnit extends AbstractUnit {
	static final private HourUnit UNIT = new HourUnit ();
	
	private HourUnit() {
		super("H", TimeDimension.dimension());
	}

	static public Unit unit () {
		return HourUnit.UNIT;
	}
	
	public Unit getUnit() {
		return HourUnit.unit ();
	}

	@Override
	protected double convertValueToSiBase(final double value) {
		return value * 3600.0d;
	}

	@Override
	protected double convertValueFromSiBase(final double value) {
		return value / 3600.0d;
	}

}
