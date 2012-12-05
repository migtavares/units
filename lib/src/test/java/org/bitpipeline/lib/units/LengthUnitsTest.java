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

import org.bitpipeline.lib.units.MeterUnit;
import org.bitpipeline.lib.units.NauticalMileUnit;
import org.bitpipeline.lib.units.Unit;

public class LengthUnitsTest extends TestCase {
	public void testLegthUnitConversion () {
		Unit mUnit = MeterUnit.unit();
		Unit nmiUnit = NauticalMileUnit.unit ();

		Double mValue = Double.valueOf(2.0d);
		Double nmiValue = Double.valueOf(1.0d);

		// conversion from meter to meter
		assertEquals(2.0d, mUnit.convertFromSIBase(mValue).doubleValue(), Double.MIN_VALUE);
		assertEquals(2.0d, mUnit.convertToSIBase(mValue).doubleValue(), Double.MIN_VALUE);

		// conversion from meter to nautical mile
		assertEquals(2.0d / 1852.0d, nmiUnit.convertFromSIBase(mValue).doubleValue(), Double.MIN_VALUE);

		// conversion from nautical mile to meter
		assertEquals(1.0d * 1852.0d, nmiUnit.convertToSIBase(nmiValue).doubleValue(), Double.MIN_VALUE);
	}

	public void footLenghtUnitTests () {
		Unit foot = FootUnit.unit ();

		// conversion from 1.0 foot to meter
		assertEquals (0.3048d, foot.convertToSIBase (1.0d));

		// conversion from 1.0 meter to foot
		assertEquals (3.2808399d, foot.convertFromSIBase (1.0d));
	}
}
