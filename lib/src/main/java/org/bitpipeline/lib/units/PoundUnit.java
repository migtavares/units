package org.bitpipeline.lib.units;

final public class PoundUnit extends AbstractUnit {
	static final private PoundUnit UNIT = new PoundUnit ();
	
	private PoundUnit() {
		super("lb", MassDimension.dimension());
	}

	static public Unit unit () {
		return PoundUnit.UNIT;
	}
	
	public Unit getUnit() {
		return PoundUnit.unit ();
	}

	@Override
	protected double convertValueToSiBase (final double value) {
		return value * 0.45359237d;
	}

	@Override
	protected double convertValueFromSiBase (final double value) {
		return value / 0.45359237d;
	}
}
