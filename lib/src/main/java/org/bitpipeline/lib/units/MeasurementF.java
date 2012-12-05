/**
 * Copyright 2012 J. Miguel P. Tavares
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ***************************************************************************/
package org.bitpipeline.lib.units;

/** A measurement is a tuple of value and a unit that can propagate changes
 * to registered listeners.
 * <p>{@link MeasurementF} is the supporting class for measurements with values
 * of type <code>float</code>.</p>
 * <p>If you want to use <code>double</code> values then use
 * {@link MeasurementD}.</p>*/
public class MeasurementF extends AbstractMeasurement<MeasurementFListener>{
	private float value;

	/** Construct a measurement with the specified value and unit.
	 * @param value the initial value of the measurement
	 * @param unit the measurement unit*/
	public MeasurementF(float value, Unit unit) {
		super (unit);
		this.value = value;
	}

	/** Gets the value of this measurement in the measurement unit.
	 * @return the value of this measurement. */
	public float getValue () {
		return this.value;
	}

	/** Sets the value of this measurement in the measurement unit.
	 * @param newValue is the new value of this measurement. */
	public void setValue (float newValue) {
		this.value = newValue;
		propagateChange (MeasurementChangeType.VALUE);
	}

	/** Sets the value of this measurement using a different unit.
	 * <p>The <code>otherUnit</code> is used to convert the value to the SI
	 * unit, and then the measurement unit converts that result into a 
	 * new measurement value.
	 * @param newValue is the value of the measurement in <code>otherUnit</code>
	 * @param otherUnit is the unit of the newValue */
	public void setValue (float newValue, Unit otherUnit) {
		float siValue = otherUnit.convertToSIBase (newValue);
		setValue (getUnit ().convertFromSIBase (siValue));
	}

	/** Gets the value of this measurement in a different unit
	 * @param otherUnit the unit to use as the return value
	 * @return the value of this measurement in <code>otherUnit</code> */
	public float getValueAs (Unit otherUnit) {
		return otherUnit.convertFromSIBase(getUnit ().convertToSIBase(this.value));
	}

	/** Gets the value of this measurement in SI unit.
	 * @return the value of this measurement in <code>otherUnit</code> */
	public float getValueSIBase () {
		return getUnit ().convertToSIBase(this.value);
	}

	/** Converts this measurement to a different unit.
	 * <p>The current unit of this measurement is used to convert the current
	 * value to SI unit, then the new unit is used to convert that result. The
	 * measurement unit is that changed to the <code>otherUnit</code></p>
	 * @param otherUnit is the new unit*/
	public void convertToUnit (Unit otherUnit) {
		this.value = getValueAs (otherUnit);
		setUnit (otherUnit);
		propagateChange (MeasurementChangeType.BOTH);
	}
}
