package org.bitpipeline.lib.units.base.mass;

import org.bitpipeline.lib.units.AbstractUnit;
import org.bitpipeline.lib.units.Unit;

public class Gram extends AbstractUnit {
	static final private Gram UNIT = new Gram ();

	private Gram () {
		super("gram", "g", MassDimension.dimension ());
	}

	static public Unit unit () {
		return Gram.UNIT;
	}

	@Override
	public Unit getUnit () {
		return Gram.unit ();
	}

	@Override
	public float convertToSIBase (float value) {
		return value / 1000f;
	}

	@Override
	public double convertToSIBase (double value) {
		return value / 1000d;
	}

	@Override
	public float convertFromSIBase (float value) {
		return value * 1000f;
	}

	@Override
	public double convertFromSIBase (double value) {
		return value * 1000d;
	}
	
}