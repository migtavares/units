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
import org.junit.Test;

public class USMileTest extends TestCase {
	@Test
	public void testNameAndSymbol () {
		Unit nmile = USMile.unit ();
		assertEquals ("US land mile", nmile.getName ());
		assertEquals ("mi", nmile.getSymbol ());
	}

	@Test
	public void testDimension () {
		Unit nmile = USMile.unit ();
		assertTrue (nmile.getDimension () instanceof LengthDimension);
	}

	@Test
	public void testIsUnique () {
		Unit nmile = USMile.unit ();
		Unit nmile2 = nmile.getUnit ();
		assertTrue ("A unit must be a singleton, so only one instance should exist.", nmile == nmile2);
	}

	@Test
	public void testSIConvertion () {
		Unit usmile = USMile.unit ();

		double dValue = Math.random ()*1000d;
		float fValue = (float) dValue;

		// Test the SI base unit
		assertEquals(dValue, 
				usmile.convertFromSIBase (usmile.convertToSIBase (dValue)),
				0.0000000001d);
		assertEquals(fValue,
				usmile.convertFromSIBase (usmile.convertToSIBase (fValue)),
				0.0001f);

		assertEquals(dValue, 
				usmile.convertToSIBase (usmile.convertFromSIBase (dValue)),
				0.0000000001d);
		assertEquals(fValue,
				usmile.convertToSIBase (usmile.convertFromSIBase (fValue)),
				0.0001f);

		assertEquals(2.0d / 1609.347219d, usmile.convertFromSIBase(2.0d), 0.000001d);
		assertEquals(2.0f / 1609.347219f, usmile.convertFromSIBase(2.0f), 0.000001f);

		assertEquals(2.0d * 1609.347219d, usmile.convertToSIBase(2.0d), 0.000001d);
		assertEquals(2.0f * 1609.347219f, usmile.convertToSIBase(2.0f), 0.000001f);
	}
}
