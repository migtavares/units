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
package org.bitpipeline.lib.units.base.mass;

import junit.framework.TestCase;

import org.bitpipeline.lib.units.PrecisionExpectations;
import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.mass.Kilogram;
import org.bitpipeline.lib.units.base.mass.MassDimension;
import org.junit.Test;

public class KilogramTest extends TestCase {
	@Test
	public void testNameAndSymbol () {
		Unit kg = Kilogram.unit ();
		assertEquals ("kilogram", kg.getName ());
		assertEquals ("kg", kg.getSymbol ());
	}

	@Test
	public void testDimension () {
		Unit kg = Kilogram.unit ();
		assertTrue (kg.getDimension () instanceof MassDimension);
	}

	@Test
	public void testIsUnique () {
		Unit kg = Kilogram.unit ();
		Unit kg2 = kg.getUnit ();
		assertTrue ("A unit must be a singleton, so only one instance should exist.", kg == kg2);
	}

	@Test
	public void testSIConvertion () {
		Unit kg = Kilogram.unit ();

		double dValue = Math.random ()*1000d;
		float fValue = (float) dValue;

		// Test the SI base unit
		assertEquals("convertToSIBase(double) should keep the value", dValue, kg.convertToSIBase (dValue), PrecisionExpectations.FOR_DOUBLES);
		assertEquals("convertToSIBase(float) should keep the value", fValue, kg.convertToSIBase (fValue), PrecisionExpectations.FOR_FLOATS);

		assertEquals("convertFomSIBase(double) should keep the value", dValue, kg.convertFromSIBase (dValue), PrecisionExpectations.FOR_DOUBLES);
		assertEquals("convertFomSIBase(float) should keep the value", fValue, kg.convertFromSIBase (fValue), PrecisionExpectations.FOR_FLOATS);
	}
}
