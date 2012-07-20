package org.bitpipeline.lib.units;

public class CMeterUnit extends AbstractUnit {
	static final private CMeterUnit UNIT = new CMeterUnit ();
	
	public CMeterUnit() {
		super("cm", LengthDimension.dimension ());
	}

	static public Unit unit() {
		return CMeterUnit.UNIT;
	}

	public Unit getUnit() {
		return MeterUnit.unit ();
	}

	@Override
	protected double convertValueToSiBase(final double value) {
		return value * 0.01;
	}

	@Override
	protected double convertValueFromSiBase(final double value) {
		return value * 100;
	}
}
