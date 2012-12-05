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
import org.bitpipeline.lib.units.base.temperature.Fahrenheit;
import org.junit.Test;

public class TemperatureConversionTest extends TestCase {
	static final private float fDELTA = 0.001f;
	static final private double dDELTA = 0.001d;

	@Test
	public void testCelciusKelvinConvertion () {
		Unit celcius = Celsius.unit ();

		double dValue = Math.random ()*1000d;
		float fValue = (float) dValue;

		// Test the SI base unit
		assertEquals(dValue, celcius.convertToSIBase (celcius.convertFromSIBase(dValue)), TemperatureConversionTest.dDELTA);
		assertEquals(fValue, celcius.convertToSIBase (celcius.convertFromSIBase(fValue)), TemperatureConversionTest.fDELTA);

		assertEquals(0.00d, celcius.convertFromSIBase (273.15d), TemperatureConversionTest.dDELTA);
		assertEquals(0.00f, celcius.convertFromSIBase (273.15f), TemperatureConversionTest.fDELTA);

		assertEquals(0.00d, celcius.convertToSIBase (-273.15d), TemperatureConversionTest.dDELTA);
		assertEquals(0.00f, celcius.convertToSIBase (-273.15f), TemperatureConversionTest.fDELTA);

		assertEquals(273.15d, celcius.convertToSIBase (0.00d), TemperatureConversionTest.dDELTA);
		assertEquals(273.15f, celcius.convertToSIBase (0.00f), TemperatureConversionTest.fDELTA);
	}

	@Test
	public void testFahrenheitKelvinConvertion () {
		Unit fahrenheit = Fahrenheit.unit ();

		double dValue = Math.random ()*1000.00d;
		float fValue = (float) dValue;

		assertEquals(dValue, fahrenheit.convertToSIBase (fahrenheit.convertFromSIBase(dValue)), TemperatureConversionTest.dDELTA);
		assertEquals(fValue, fahrenheit.convertToSIBase (fahrenheit.convertFromSIBase(fValue)), TemperatureConversionTest.fDELTA);

		assertEquals(255.37222222d, fahrenheit.convertToSIBase (0d), TemperatureConversionTest.dDELTA);
		assertEquals(255.37222222f, fahrenheit.convertToSIBase (0f), TemperatureConversionTest.fDELTA);

		assertEquals(-459.67d, fahrenheit.convertFromSIBase (0d), TemperatureConversionTest.dDELTA);
		assertEquals(-459.67f, fahrenheit.convertFromSIBase (0f), TemperatureConversionTest.fDELTA);

		assertEquals(0d, fahrenheit.convertToSIBase (-459.67d), TemperatureConversionTest.dDELTA);
		assertEquals(0f, fahrenheit.convertToSIBase (-459.67f), TemperatureConversionTest.fDELTA);

		assertEquals(255.37222d, fahrenheit.convertToSIBase (0d), TemperatureConversionTest.dDELTA);
		assertEquals(255.37222f, fahrenheit.convertToSIBase (0f), TemperatureConversionTest.fDELTA);
	}

}
