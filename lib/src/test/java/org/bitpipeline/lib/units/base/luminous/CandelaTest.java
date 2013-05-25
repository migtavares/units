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
package org.bitpipeline.lib.units.base.luminous;

import junit.framework.TestCase;

import org.bitpipeline.lib.units.PrecisionExpectations;
import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.luminous.Candela;
import org.bitpipeline.lib.units.base.luminous.LuminousIntensityDimension;
import org.junit.Test;

public class CandelaTest extends TestCase {
	@Test
	public void testNameAndSymbol () {
		Unit candela = Candela.unit ();
		assertEquals ("candela", candela.getName ());
		assertEquals ("cd", candela.getSymbol ());
	}

	@Test
	public void testDimension () {
		Unit candela = Candela.unit ();
		assertTrue (candela.getDimension () instanceof LuminousIntensityDimension);
	}

	@Test
	public void testIsUnique () {
		Unit candela = Candela.unit ();
		Unit candela2 = candela.getUnit ();
		assertTrue ("A unit must be a singleton, so only one instance should exist.", candela == candela2);
	}

	@Test
	public void testMoleSIConvertion () {
		Unit candela = Candela.unit ();

		double dValue = Math.random ()*1000d;
		float fValue = (float) dValue;

		// Test the SI base unit
		assertEquals(dValue, candela.convertToSIBase (dValue), PrecisionExpectations.FOR_DOUBLES);
		assertEquals(fValue, candela.convertToSIBase (fValue), PrecisionExpectations.FOR_FLOATS);

		assertEquals(dValue, candela.convertFromSIBase (dValue), PrecisionExpectations.FOR_DOUBLES);
		assertEquals(fValue, candela.convertFromSIBase (fValue), PrecisionExpectations.FOR_FLOATS);
	}
}
