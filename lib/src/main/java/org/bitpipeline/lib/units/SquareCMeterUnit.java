package org.bitpipeline.lib.units;

public class SquareCMeterUnit extends AbstractUnit {
	static final private SquareCMeterUnit UNIT = new SquareCMeterUnit ();
	
	private SquareCMeterUnit() {
		super("cm\u00b2", LengthDimension.dimension(), LengthDimension.dimension());
	}

	static public Unit unit () {
		return SquareCMeterUnit.UNIT;
	}
	
	public Unit getUnit() {
		return SquareCMeterUnit.unit ();
	}

	@Override
	protected double convertValueToSiBase (final double value) {
		return value / 10000.0d;
	}

	@Override
	protected double convertValueFromSiBase (final double value) {
		return value * 10000.0d;
	}
}
