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

import org.bitpipeline.lib.units.Dimension;
import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.temperature.Kelvin;
import org.bitpipeline.lib.units.base.temperature.TemperatureDimension;
import org.junit.Test;

public class TemperatureDimensionTest extends TestCase {
	@Test
	public void testNameAndSymbol () {
		Dimension temperature = TemperatureDimension.dimension ();
		assertEquals ("temperature", temperature.getName ());
		assertEquals ("\u0398", temperature.getSymbol ());
	}

	@Test
	public void testSIUnit () {
		Dimension temperature = TemperatureDimension.dimension ();
		Unit unit = temperature.getSIUnit ();
		assertNotNull ("Temperature dimension must have a SI unit.", unit);
		assertTrue ("Temperature SI unit is Kelvin", unit instanceof Kelvin);
	}

	@Test
	public void testCardinality () {
		Dimension temperature = TemperatureDimension.dimension ();
		assertTrue ("Temperature dimension has cardinality of 1", temperature.getCardinality () == 1);
	}
}
