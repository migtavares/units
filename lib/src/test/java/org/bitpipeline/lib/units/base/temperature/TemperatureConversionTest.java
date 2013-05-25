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
import org.bitpipeline.lib.units.base.temperature.Celsius;
import org.bitpipeline.lib.units.base.temperature.Fahrenheit;
import org.junit.Test;

public class TemperatureConversionTest extends TestCase {
	@Test
	public void testCelciusKelvinConvertion () {
		Unit celcius = Celsius.unit ();

		double dValue = Math.random ()*1000d;
		float fValue = (float) dValue;

		// Test the SI base unit
		assertEquals(dValue, celcius.convertToSIBase (celcius.convertFromSIBase(dValue)), PrecisionExpectations.FOR_DOUBLES);
		assertEquals(fValue, celcius.convertToSIBase (celcius.convertFromSIBase(fValue)), PrecisionExpectations.FOR_FLOATS);

		assertEquals(0.00d, celcius.convertFromSIBase (273.15d), PrecisionExpectations.FOR_DOUBLES);
		assertEquals(0.00f, celcius.convertFromSIBase (273.15f), PrecisionExpectations.FOR_FLOATS);

		assertEquals(0.00d, celcius.convertToSIBase (-273.15d), PrecisionExpectations.FOR_DOUBLES);
		assertEquals(0.00f, celcius.convertToSIBase (-273.15f), PrecisionExpectations.FOR_FLOATS);

		assertEquals(273.15d, celcius.convertToSIBase (0.00d), PrecisionExpectations.FOR_DOUBLES);
		assertEquals(273.15f, celcius.convertToSIBase (0.00f), PrecisionExpectations.FOR_FLOATS);
	}

	@Test
	public void testFahrenheitKelvinConvertion () {
		Unit fahrenheit = Fahrenheit.unit ();

		double dValue = Math.random () * 1000.000000d;
		float fValue = (float) dValue;

		assertEquals(dValue,
				fahrenheit.convertToSIBase (fahrenheit.convertFromSIBase(dValue)),
				PrecisionExpectations.FOR_DOUBLES);
		assertEquals(fValue,
				fahrenheit.convertToSIBase (fahrenheit.convertFromSIBase(fValue)),
				PrecisionExpectations.FOR_FLOATS);

		assertEquals(255.372222d, fahrenheit.convertToSIBase (0d), PrecisionExpectations.FOR_DOUBLES);
		assertEquals(255.372f, fahrenheit.convertToSIBase (0f), PrecisionExpectations.FOR_FLOATS);

		assertEquals(-459.670000d, fahrenheit.convertFromSIBase (0d), PrecisionExpectations.FOR_DOUBLES);
		assertEquals(-459.670f, fahrenheit.convertFromSIBase (0f), PrecisionExpectations.FOR_FLOATS);

		assertEquals(0d, fahrenheit.convertToSIBase (-459.670000d), PrecisionExpectations.FOR_DOUBLES);
		assertEquals(0f, fahrenheit.convertToSIBase (-459.670f), PrecisionExpectations.FOR_FLOATS);

		assertEquals(255.372222d, fahrenheit.convertToSIBase (0d), PrecisionExpectations.FOR_DOUBLES);
		assertEquals(255.37222f, fahrenheit.convertToSIBase (0f), PrecisionExpectations.FOR_FLOATS);
	}

}
