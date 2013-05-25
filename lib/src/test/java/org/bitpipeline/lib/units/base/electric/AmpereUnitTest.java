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
package org.bitpipeline.lib.units.base.electric;

import junit.framework.TestCase;

import org.bitpipeline.lib.units.PrecisionExpectations;
import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.electric.Ampere;
import org.bitpipeline.lib.units.base.electric.ElectricCurrentDimension;
import org.junit.Test;

public class AmpereUnitTest extends TestCase {
	@Test
	public void testMoleNameAndSymbol () {
		Unit ampere = Ampere.unit ();
		assertEquals ("ampere", ampere.getName ());
		assertEquals ("A", ampere.getSymbol ());
	}

	@Test
	public void testMoleDimension () {
		Unit ampere = Ampere.unit ();
		assertTrue (ampere.getDimension () instanceof ElectricCurrentDimension);
	}

	@Test
	public void testIsUnique () {
		Unit ampere = Ampere.unit ();
		Unit ampere2 = ampere.getUnit ();
		assertTrue ("A unit must be a singleton, so only one instance should exist.", ampere == ampere2);
	}

	@Test
	public void testMoleSIConvertion () {
		Unit ampere = Ampere.unit ();

		double dValue = Math.random ()*1000d;
		float fValue = (float) dValue;

		// Test the SI base unit
		assertEquals(dValue, ampere.convertToSIBase (dValue), PrecisionExpectations.FOR_DOUBLES);
		assertEquals(fValue, ampere.convertToSIBase (fValue), PrecisionExpectations.FOR_FLOATS);

		assertEquals(dValue, ampere.convertFromSIBase (dValue), PrecisionExpectations.FOR_DOUBLES);
		assertEquals(fValue, ampere.convertFromSIBase (fValue), PrecisionExpectations.FOR_FLOATS);
	}
}
