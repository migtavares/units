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

import java.util.LinkedList;


public class Measurement<T extends Number> {
	T value;
	Unit unit;

	private LinkedList<MeasurementChangeListener<T>> listeners = new LinkedList<MeasurementChangeListener<T>> ();


	public Measurement(T initialValue, Unit unit) {
		this.value = initialValue;
		this.unit = unit;
	}

	public T getValue () {
		return this.value;
	}

	public void setValue (T newValue) {
		this.value = newValue;
		for (MeasurementChangeListener<T> listener : this.listeners)
			listener.measurementChange(this);
	}

	@SuppressWarnings("unchecked")
	public void setValue (T newValue, Unit otherUnit) {
		Number siValue = otherUnit.convertToSIBase(newValue);
		setValue ((T) this.unit.convertFromSIBase(siValue));
	}

	@SuppressWarnings("unchecked")
	public T getValueAs (Unit otherUnit) {
		return (T) otherUnit.convertFromSIBase(this.unit.convertToSIBase(this.value));
	}

	@SuppressWarnings("unchecked")
	public T getValueSIBase () {
		return (T) this.unit.convertToSIBase(this.value);
	}

	public void setUnit (Unit otherUnit) {
		this.unit = otherUnit;
		trigger ();
	}

	public void convertToUnit (Unit otherUnit) {
		this.value = getValueAs (otherUnit);
		this.unit = otherUnit;
		trigger ();
	}

	public Unit getUnit () {
		return this.unit;
	}

	public boolean addListener (MeasurementChangeListener<T> listener) {
		return this.listeners.add(listener);
	}

	public boolean removeListener (MeasurementChangeListener<T> listener) {
		return this.listeners.remove(listener);
	}

	/** Spreads the value of the measurement to all listeners */
	public void trigger () {
		for (MeasurementChangeListener<T> listener : this.listeners)
			listener.measurementChange(this);
	}
}
