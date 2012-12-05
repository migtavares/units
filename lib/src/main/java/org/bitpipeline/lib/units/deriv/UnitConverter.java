package org.bitpipeline.lib.units.deriv;

/** The interface that every unit must implement to convert to and from the SI unit. */
public interface UnitConverter {
	/** Convert a value from the provided unit to the corresponding one in the standard SI unit of the same dimension.
	 * @param value the value using <code>this</code> unit
	 * @return the value converted to the SI unit */
	float convertToSIBase (float value);

	/** Convert a value from the provided unit to the corresponding one in the standard SI unit of the same dimension.
	 * @param value the value using <code>this</code> unit
	 * @return the value converted to the SI unit */
	double convertToSIBase (double value);

	/** Convert a value from the SI standard unit to <code>this</code> unit
	 * @param value the value using the SI unit
	 * @return the value converted to the <code>this</code> unit */
	float convertFromSIBase (float value);

	/** Convert a value from the SI standard unit to <code>this</code> unit
	 * @param value the value using the SI unit
	 * @return the value converted to the <code>this</code> unit */
	double convertFromSIBase (double value);
}