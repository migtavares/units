/**
 * Copyright 2013 J. Miguel P. Tavares
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

/** Enumerate the types of change a measurement can have. */
public enum MeasurementChangeType {
	/** Only the value of the measurement changed, the unit is still the same. */
	VALUE,
	/** Only the unit of the measurement changed, the value is still the same (not converted to the new unit). */
	UNIT,
	/** Both the unit and the value have changed. For example: the measurement was converted to a new unit. */
	BOTH
}