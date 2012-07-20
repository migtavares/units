package org.bitpipeline.lib.units;

final public class MeterUnit extends AbstractUnit {
	static final private MeterUnit UNIT = new MeterUnit ();
	
	public MeterUnit() {
		super("m", LengthDimension.dimension ());
	}

	static public Unit unit() {
		return MeterUnit.UNIT;
	}

	public Unit getUnit() {
		return MeterUnit.UNIT;
	}

	@Override
	protected double convertValueToSiBase(final double value) {
		return value;
	}

	@Override
	protected double convertValueFromSiBase(final double value) {
		return value;
	}
}
