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

import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.length.LengthDimension;
import org.bitpipeline.lib.units.base.length.Metre;
import org.junit.Test;

public class MetreTest extends TestCase {
	@Test
	public void testNameAndSymbol () {
		Unit metre = Metre.unit ();
		assertEquals ("metre", metre.getName ());
		assertEquals ("m", metre.getSymbol ());
	}

	@Test
	public void testDimension () {
		Unit metre = Metre.unit ();
		assertTrue (metre.getDimension () instanceof LengthDimension);
	}

	@Test
	public void testIsUnique () {
		Unit ampere = Metre.unit ();
		Unit ampere2 = ampere.getUnit ();
		assertTrue ("A unit must be a singleton, so only one instance should exist.", ampere == ampere2);
	}

	@Test
	public void testSIConvertion () {
		Unit metre = Metre.unit ();

		double dValue = Math.random ()*1000d;
		float fValue = (float) dValue;

		// Test the SI base unit
		assertEquals(dValue, metre.convertToSIBase (dValue), Double.MIN_NORMAL);
		assertEquals(fValue, metre.convertToSIBase (fValue), Float.MIN_NORMAL);

		assertEquals(dValue, metre.convertFromSIBase (dValue), Double.MIN_NORMAL);
		assertEquals(fValue, metre.convertFromSIBase (fValue), Float.MIN_NORMAL);
	}
}
