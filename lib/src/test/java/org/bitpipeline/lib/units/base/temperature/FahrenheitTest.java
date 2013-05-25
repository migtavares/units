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

import org.bitpipeline.lib.units.PrecisionExpectations;
import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.temperature.Fahrenheit;
import org.bitpipeline.lib.units.base.temperature.TemperatureDimension;
import org.junit.Test;

public class FahrenheitTest extends TestCase {
	@Test
	public void testNameAndSymbol () {
		Unit fahrenheit = Fahrenheit.unit ();
		assertEquals ("fahrenheit", fahrenheit.getName ());
		assertEquals ("\u00B0F", fahrenheit.getSymbol ());
	}

	@Test
	public void testDimension () {
		Unit fahrenheit = Fahrenheit.unit ();
		assertTrue (fahrenheit.getDimension () instanceof TemperatureDimension);
	}

	@Test
	public void testIsUnique () {
		Unit fahrenheit = Fahrenheit.unit ();
		Unit fahrenheit2 = fahrenheit.getUnit ();
		assertTrue ("A unit must be a singleton, so only one instance should exist.", fahrenheit == fahrenheit2);
	}

	@Test
	public void testSIConvertion () {
		Unit fahrenheit = Fahrenheit.unit ();

		double dValue = Math.random ()*1000d;
		float fValue = (float) dValue;

		// Test the SI base unit
		assertEquals(dValue, 
				fahrenheit.convertFromSIBase (fahrenheit.convertToSIBase (dValue)),
				PrecisionExpectations.FOR_DOUBLES);
		assertEquals(fValue,
				fahrenheit.convertFromSIBase (fahrenheit.convertToSIBase (fValue)),
				PrecisionExpectations.FOR_FLOATS);

		assertEquals(dValue, 
				fahrenheit.convertToSIBase (fahrenheit.convertFromSIBase (dValue)),
				PrecisionExpectations.FOR_DOUBLES);
		assertEquals(fValue,
				fahrenheit.convertToSIBase (fahrenheit.convertFromSIBase (fValue)),
				PrecisionExpectations.FOR_FLOATS);
	}
}
