package org.bitpipeline.lib.units;

final public class SecondUnit extends AbstractUnit {
	static final private SecondUnit UNIT = new SecondUnit (); 

	public SecondUnit() {
		super("s", TimeDimension.dimension());
	}

	static public Unit unit () {
		return SecondUnit.UNIT;
	}
	
	public Unit getUnit() {
		return SecondUnit.unit ();
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
