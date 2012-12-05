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
package org.bitpipeline.lib.units.deriv;

import junit.framework.TestCase;

import org.bitpipeline.lib.units.Dimension;
import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.length.LengthDimension;
import org.bitpipeline.lib.units.base.length.Metre;
import org.junit.Test;

public class ProductUnitTest extends TestCase {
	public void setUp () {
		UnitFactory.reset ();
		DimensionFactory.reset ();
	}

	@Test
	public void testAreaUnits () {
		Dimension area = DimensionFactory.getOrCreateProduct (
				"area", "A",
				new NamingProvider () {
					@Override
					public String getName () {
						return "square metre";
					}
	
					@Override
					public String getSymbol () {
						return "m\u00b2";
					}
			
				},
				LengthDimension.dimension (), LengthDimension.dimension ());

		Unit squareMetre = UnitFactory.getOrCreateProduct (
				"m power 2", "m^2", // this will be ignored.
				SIUnitConverter.getInstance (),
				Metre.unit (), Metre.unit());

		assertNotNull (squareMetre);
		assertEquals ("area", area.getName ());
		assertEquals ("A", area.getSymbol ());

		// Check the SI unit naming
		Unit siUnit = area.getSIUnit ();
		assertNotNull (siUnit);

		assertEquals ("square metre", siUnit.getName ());
		assertEquals ("m\u00b2", siUnit.getSymbol ());
		assertTrue (squareMetre == siUnit);
	}
}
