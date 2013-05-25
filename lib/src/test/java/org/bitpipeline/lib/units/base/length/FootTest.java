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
package org.bitpipeline.lib.units.base.length;

import junit.framework.TestCase;

import org.bitpipeline.lib.units.PrecisionExpectations;
import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.length.Foot;
import org.bitpipeline.lib.units.base.length.LengthDimension;
import org.junit.Test;

public class FootTest extends TestCase {
	@Test
	public void testNameAndSymbol () {
		Unit foot = Foot.unit ();
		assertEquals ("foot", foot.getName ());
		assertEquals ("ft", foot.getSymbol ());
	}

	@Test
	public void testDimension () {
		Unit foot = Foot.unit ();
		assertTrue (foot.getDimension () instanceof LengthDimension);
	}

	@Test
	public void testIsUnique () {
		Unit foot = Foot.unit ();
		Unit foot2 = foot.getUnit ();
		assertTrue ("A unit must be a singleton, so only one instance should exist.", foot == foot2);
	}

	@Test
	public void testSIConvertion () {
		Unit foot = Foot.unit ();

		double dValue = Math.random ()*1000d;
		float fValue = (float) dValue;

		// Test the SI base unit
		assertEquals(dValue, 
				foot.convertFromSIBase (foot.convertToSIBase (dValue)),
				PrecisionExpectations.FOR_DOUBLES);
		assertEquals(fValue,
				foot.convertFromSIBase (foot.convertToSIBase (fValue)),
				PrecisionExpectations.FOR_FLOATS);

		assertEquals(dValue, 
				foot.convertToSIBase (foot.convertFromSIBase (dValue)),
				PrecisionExpectations.FOR_DOUBLES);
		assertEquals(fValue,
				foot.convertToSIBase (foot.convertFromSIBase (fValue)),
				PrecisionExpectations.FOR_FLOATS);

		// conversion from 1.0 foot to meter
		assertEquals (0.3048d, foot.convertToSIBase (1.0d), PrecisionExpectations.FOR_DOUBLES);
		assertEquals (0.3048f, foot.convertToSIBase (1.0f), PrecisionExpectations.FOR_FLOATS);

		// conversion from 1.0 meter to foot
		assertEquals (3.2808399d, foot.convertFromSIBase (1.0d), PrecisionExpectations.FOR_DOUBLES);
		assertEquals (3.2808399f, foot.convertFromSIBase (1.0f), PrecisionExpectations.FOR_FLOATS);
	}
}
