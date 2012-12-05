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

/** Interface that need to be implemented by classes that want
 * to be notified of changes in the measurement value, unit or both.*/
@SuppressWarnings ("rawtypes")
interface MeasurementListener<M extends AbstractMeasurement> {
	/** Method called in a measurement listener when some change takes place.
	 * @param measurement is the measure that changed
	 * @param type is the type of change*/
	void measurementChange (M measurement, MeasurementChangeType type);
}
