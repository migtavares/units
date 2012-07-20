package org.bitpipeline.lib.units;

final public class CubicMeterUnit extends AbstractUnit {
	static final private CubicMeterUnit UNIT = new CubicMeterUnit ();
	
	private CubicMeterUnit() {
		super("m\u00b3", LengthDimension.dimension(), LengthDimension.dimension(), LengthDimension.dimension());
	}

	static public Unit unit () {
		return CubicMeterUnit.UNIT;
	}
	
	public Unit getUnit() {
		return CubicMeterUnit.unit ();
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
