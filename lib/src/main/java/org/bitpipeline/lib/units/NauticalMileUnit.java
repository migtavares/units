package org.bitpipeline.lib.units;

final public class NauticalMileUnit extends AbstractUnit {
	static final private NauticalMileUnit UNIT = new NauticalMileUnit();

	public NauticalMileUnit() {
		super("nmi", LengthDimension.dimension());
	}

	static public Unit unit () {
		return NauticalMileUnit.UNIT;
	}
	
	public Unit getUnit() {
		return NauticalMileUnit.unit ();
	}

	@Override
	protected double convertValueToSiBase(final double value) {
		return value * 1852d;
	}

	@Override
	protected double convertValueFromSiBase(final double value) {
		return value / 1852d;
	}
}
