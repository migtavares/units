/**
 * Copyright 2013 J. Miguel P. Tavares
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

import org.bitpipeline.lib.units.PrecisionExpectations;
import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.length.Metre;
import org.bitpipeline.lib.units.base.mass.Gram;
import org.bitpipeline.lib.units.deriv.area.AreaUnitFactory;
import org.junit.Test;

public class PrefixedUnitsTest extends TestCase {
	@Test
	public void testKNaming () {
		Unit km = new PrefixedUnit (Prefix.KILO, Metre.unit ());
		assertEquals ("kilometre", km.getName ());
		assertEquals ("Km", km.getSymbol ());
	}

	@Test
	public void testRoundTripConversionsCm () {
		Unit cm = new PrefixedUnit (Prefix.CENTI, Metre.unit ());
		float value = 100.000f;

		float m = cm.convertToSIBase (value);
		assertEquals (1.0f, m, PrecisionExpectations.FOR_FLOATS);
		assertEquals (100.0f, cm.convertFromSIBase (m), PrecisionExpectations.FOR_FLOATS);
	}

	@Test
	public void testDualDimensionRoundTripConversionsKm2 () {
		Unit km2 = new PrefixedUnit (
				Prefix.KILO,
				AreaUnitFactory.getSquareMetre ());
		/* 1 km^2 = 1_000_000 m^2 */
		assertEquals (1000000.0d, km2.convertToSIBase (1.0d), PrecisionExpectations.FOR_DOUBLES);
		assertEquals (1000000.0f, km2.convertToSIBase (1.0f), PrecisionExpectations.FOR_FLOATS);
	}

	@Test
	public void testMassSIPrefixed () {
		PrefixedUnit kg = new PrefixedUnit (Prefix.KILO, Gram.unit ());
		assertEquals ("kilogram", kg.getName ());
		assertEquals ("Kg", kg.getSymbol ());
		assertEquals (Gram.unit (), kg.getBaseUnit ());

		assertEquals (1.0d, kg.convertFromSIBase (1.0d), PrecisionExpectations.FOR_DOUBLES);
		assertEquals (1.0f, kg.convertFromSIBase (1.0f), PrecisionExpectations.FOR_FLOATS);

		assertEquals (1d, kg.convertToSIBase (1d), PrecisionExpectations.FOR_DOUBLES);
		assertEquals (1f, kg.convertToSIBase (1f), PrecisionExpectations.FOR_FLOATS);

		PrefixedUnit g = new PrefixedUnit (Prefix.IDENT, Gram.unit ());
		assertEquals ("gram", g.getName ());
		assertEquals ("g", g.getSymbol ());
		assertEquals (Gram.unit (), g.getBaseUnit ());
	}
}
