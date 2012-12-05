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
package org.bitpipeline.lib.units.base.temperature;

import junit.framework.TestCase;

import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.temperature.Celsius;
import org.bitpipeline.lib.units.base.temperature.TemperatureDimension;
import org.junit.Test;

public class CelciusTest extends TestCase {
	@Test
	public void testNameAndSymbol () {
		Unit celsius = Celsius.unit ();
		assertEquals ("celsius", celsius.getName ());
		assertEquals ("\u00B0C", celsius.getSymbol ());
	}

	@Test
	public void testDimension () {
		Unit celsius = Celsius.unit ();
		assertTrue (celsius.getDimension () instanceof TemperatureDimension);
	}

	@Test
	public void testIsUnique () {
		Unit celsius = Celsius.unit ();
		Unit celsius2 = celsius.getUnit ();
		assertTrue ("A unit must be a singleton, so only one instance should exist.", celsius == celsius2);
	}

	@Test
	public void testSIConvertion () {
		Unit celsius = Celsius.unit ();

		double dValue = Math.random ()*1000d;
		float fValue = (float) dValue;

		// Test the SI base unit
		assertEquals(dValue, 
				celsius.convertFromSIBase (celsius.convertToSIBase (dValue)),
				0.0000000001d);
		assertEquals(fValue,
				celsius.convertFromSIBase (celsius.convertToSIBase (fValue)),
				0.0001f);

		assertEquals(dValue, 
				celsius.convertToSIBase (celsius.convertFromSIBase (dValue)),
				0.0000000001d);
		assertEquals(fValue,
				celsius.convertToSIBase (celsius.convertFromSIBase (fValue)),
				0.0001f);
	}
}
