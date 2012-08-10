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

import org.bitpipeline.lib.units.BeaufortScaleUnit.BeaufortScale;
import org.junit.Test;

public class VelocityUnitsTest extends TestCase {
	@Test
	public void testVelocityUnitConvertion () {
		Unit mpsUnit = MpSUnit.unit ();
		Unit knotsUnit = KnotsUnit.unit ();

		double value = 5.0d;

		// Test the SI base unit
		assertEquals(value, mpsUnit.convertFromSIBase(Double.valueOf(value)).doubleValue(), Double.MIN_VALUE);
		assertEquals(value, mpsUnit.convertToSIBase(Double.valueOf(value)).doubleValue(), Double.MIN_VALUE);

		// test the knots conversion
		assertEquals(value,
				knotsUnit.convertToSIBase(
						knotsUnit.convertFromSIBase(Double.valueOf(value))).doubleValue(), Double.MIN_VALUE);
		assertEquals(value*0.51444444, knotsUnit.convertToSIBase(Double.valueOf(value)).doubleValue(), 0.0000001);
	}

	@Test
	public void testBeaufortConversion () {
		BeaufortScaleUnit beu = (BeaufortScaleUnit) BeaufortScaleUnit.unit ();
		double value;
		for (value = 0.0; value < 40.0;) {
			double bf = beu.convertFromSIBase (value).doubleValue ();
			double ms = beu.convertToSIBase (bf).doubleValue ();
			assertEquals (value, ms, 0.0000000000001);

			int bsScale = (int) Math.floor (bf);
			if (bsScale > 12) bsScale = 12;
			BeaufortScale scale = beu.getScale (bf);
			assertEquals (bsScale, scale.ordinal ());
			value = value + 0.0001;
		}
	}
}
