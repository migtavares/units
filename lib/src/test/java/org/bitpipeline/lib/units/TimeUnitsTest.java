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

import junit.framework.TestCase;

import org.bitpipeline.lib.units.HourUnit;
import org.bitpipeline.lib.units.SecondUnit;
import org.bitpipeline.lib.units.Unit;

public class TimeUnitsTest extends TestCase {
	public void testTimeUnitsConvertion () {
		Unit sUnit = SecondUnit.unit();
		Unit hUnit = HourUnit.unit ();

		double sValue = 1800.0d;
		double hValue = 2.0d;

		// convert from seconds to seconds
		assertEquals(sValue, sUnit.convertFromSIBase(Double.valueOf(sValue)).doubleValue(), Double.MIN_VALUE);
		assertEquals(sValue, sUnit.convertToSIBase(Double.valueOf(sValue)).doubleValue(), Double.MIN_VALUE);
		// Convert from seconds to hours
		assertEquals(0.5d, hUnit.convertFromSIBase(Double.valueOf(sValue)).doubleValue(), Double.MIN_VALUE);

		// convert from hours to seconds
		assertEquals(7200.0d, hUnit.convertToSIBase(Double.valueOf(hValue)).doubleValue(), Double.MIN_VALUE);

	}
}
