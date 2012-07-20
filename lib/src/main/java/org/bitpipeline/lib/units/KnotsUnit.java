package org.bitpipeline.lib.units;

final public class KnotsUnit extends AbstractUnit {
	static final private KnotsUnit UNIT = new KnotsUnit (); 
	
	private KnotsUnit() {
		super("knots", LengthDimension.dimension(), TimeDimension.dimension());
	}

	static public Unit unit () {
		return KnotsUnit.UNIT;
	}
	
	public Unit getUnit() {
		return KnotsUnit.unit ();
	}

	@Override
	protected double convertValueToSiBase(final double value) {
		return value * 0.514444444444444d;
	}

	@Override
	protected double convertValueFromSiBase(final double value) {
		return value / 0.514444444444444d;
	}

}
