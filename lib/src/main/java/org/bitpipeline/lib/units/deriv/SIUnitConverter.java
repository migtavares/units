package org.bitpipeline.lib.units.deriv;


/** A converter of SI units (meaning that it's a identity converter).
 * No ceonversion takes place. */
class SIUnitConverter implements UnitConverter {
	static private SIUnitConverter INSTANCE = new SIUnitConverter ();

	/** Return a "identity" converter. The values that go in come out unchanged. */
	static UnitConverter getInstance () {
		return SIUnitConverter.INSTANCE;
	}

	private SIUnitConverter () {
	}

	@Override
	public float convertToSIBase (float value) {
		return value;
	}

	@Override
	public double convertToSIBase (double value) {
		return value;
	}

	@Override
	public float convertFromSIBase (float value) {
		return value;
	}

	@Override
	public double convertFromSIBase (double value) {
		return value;
	}
}