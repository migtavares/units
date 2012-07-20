package org.bitpipeline.lib.units;

/** meters per second */
final public class MpSUnit extends AbstractUnit {
	static final private MpSUnit UNIT = new MpSUnit ();

	private MpSUnit() {
		super("m/s", LengthDimension.dimension(), TimeDimension.dimension());
	}

	static public Unit unit () {
		return MpSUnit.UNIT;
	}
	
	public Unit getUnit() {
		return MpSUnit.unit ();
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
