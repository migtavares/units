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
import org.bitpipeline.lib.units.base.length.LengthDimension;
import org.bitpipeline.lib.units.base.length.NauticalMile;
import org.junit.Test;

public class NauticalMileTest extends TestCase {
	@Test
	public void testNameAndSymbol () {
		Unit nmile = NauticalMile.unit ();
		assertEquals ("nautical mile", nmile.getName ());
		assertEquals ("nmi", nmile.getSymbol ());
	}

	@Test
	public void testDimension () {
		Unit nmile = NauticalMile.unit ();
		assertTrue (nmile.getDimension () instanceof LengthDimension);
	}

	@Test
	public void testIsUnique () {
		Unit nmile = NauticalMile.unit ();
		Unit nmile2 = nmile.getUnit ();
		assertTrue ("A unit must be a singleton, so only one instance should exist.", nmile == nmile2);
	}

	@Test
	public void testSIConvertion () {
		Unit nmile = NauticalMile.unit ();

		double dValue = Math.random ()*1000d;
		float fValue = (float) dValue;

		// Test the SI base unit
		assertEquals(dValue, 
				nmile.convertFromSIBase (nmile.convertToSIBase (dValue)),
				PrecisionExpectations.FOR_DOUBLES);
		assertEquals(fValue,
				nmile.convertFromSIBase (nmile.convertToSIBase (fValue)),
				PrecisionExpectations.FOR_FLOATS);

		assertEquals(dValue, 
				nmile.convertToSIBase (nmile.convertFromSIBase (dValue)),
				PrecisionExpectations.FOR_DOUBLES);
		assertEquals(fValue,
				nmile.convertToSIBase (nmile.convertFromSIBase (fValue)),
				PrecisionExpectations.FOR_FLOATS);

		assertEquals(2.0d / 1852.0d, nmile.convertFromSIBase(2.0d), PrecisionExpectations.FOR_DOUBLES);
		assertEquals(2.0f / 1852.0f, nmile.convertFromSIBase(2.0f), PrecisionExpectations.FOR_FLOATS);

		assertEquals(2.0d * 1852.0d, nmile.convertToSIBase(2.0d), PrecisionExpectations.FOR_DOUBLES);
		assertEquals(2.0d * 1852.0d, nmile.convertToSIBase(2.0f), PrecisionExpectations.FOR_FLOATS);
	}
}
