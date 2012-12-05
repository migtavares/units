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

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings ("rawtypes")
abstract class AbstractMeasurement<L extends MeasurementListener> {
	private Unit unit;

	private List<L> listeners = new ArrayList<L> ();

	@SuppressWarnings ("unchecked")
	void propagateChange (MeasurementChangeType type) {
		for (L listener : this.listeners)
			listener.measurementChange(this, type);
	}

	public AbstractMeasurement(Unit unit) {
		this.unit = unit;
	}

	/** Set the unit of this measurement <b>without</b> changing the
	 * measurement value.
	 * This change will be propagated to the listeners with a {@link MeasurementChangeType#UNIT}.
	 * @param otherUnit the new unit to use in this measurement */
	public void setUnit (Unit otherUnit) {
		this.unit = otherUnit;
		propagateChange (MeasurementChangeType.UNIT);
	}

	/** Returns the measurement unit. */
	public Unit getUnit () {
		return this.unit;
	}

	/** Convert this measurement to a different unit.
	 * The value of this measurement is changed according to the otherUnit.
	 * This change will be propagated to the listeners with a {@link MeasurementChangeType#BOTH}.
	 * @param otherUnit is the new unit to use for this measurement. */
	abstract public void convertToUnit (Unit otherUnit);

	/** Added a listener to changes in the measurement.
	 * The listener will be called with the current measure and will
	 * be notified of changes in the measurement.
	 * @param listener is the measurement list implementation to
	 * add to the listener list of this measurement.
	 * @return <code>true</code> */
	@SuppressWarnings ("unchecked")
	public boolean addListener (L listener) {
		if (this.listeners.add(listener)) {
			listener.measurementChange (this, MeasurementChangeType.BOTH);
			return true;
		}
		return false;
	}

	/** Remove a specific listener from the list of measurement listeners.
	 * @param listener is the measurement list implementation to remove
	 * @return <code>true</code> if this list contained the specified listener
	 * <code>false</code> otherwise */
	public boolean removeListener (L listener) {
		return this.listeners.remove(listener);
	}

	/** Removes all of the change listeners of this measurement. */
	public void clearListeners () {
		this.listeners.clear ();
	}
}
