package org.bitpipeline.lib.units;

final public class SquareMeterUnit extends AbstractUnit {
	static final private SquareMeterUnit UNIT = new SquareMeterUnit ();
	
	private SquareMeterUnit() {
		super("m\u00b2", LengthDimension.dimension(), LengthDimension.dimension());
	}

	static public Unit unit () {
		return SquareMeterUnit.UNIT;
	}
	
	public Unit getUnit() {
		return SquareMeterUnit.unit ();
	}

	@Override
	protected double convertValueToSiBase (final double value) {
		return value;
	}

	@Override
	protected double convertValueFromSiBase (final double value) {
		return value;
	}
}
