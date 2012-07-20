package org.bitpipeline.lib.units;

public class LiterUnit extends AbstractUnit {
	static final private LiterUnit UNIT = new LiterUnit ();
	
	private LiterUnit() {
		super("l", LengthDimension.dimension(), LengthDimension.dimension(), LengthDimension.dimension());
	}

	static public Unit unit () {
		return LiterUnit.UNIT;
	}
	
	public Unit getUnit() {
		return LiterUnit.unit ();
	}

	@Override
	protected double convertValueToSiBase(final double value) {
		return value * 0.001d;
	}

	@Override
	protected double convertValueFromSiBase(final double value) {
		return value / 0.001d;
	}
}
