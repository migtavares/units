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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.length.LengthDimension;
import org.bitpipeline.lib.units.base.length.Metre;
import org.bitpipeline.lib.units.base.time.Second;
import org.bitpipeline.lib.units.base.time.TimeDimension;
import org.bitpipeline.lib.units.deriv.SIUnitConverter;
import org.bitpipeline.lib.units.deriv.UnitFactory;
import org.junit.Test;

/**
 * @author mtavares */
public class UnitFactoryTest {

	@Test
	public void testUniquenessOfQuotientUnits () {
		Unit mps = UnitFactory.getOrCreateSIQuotient (
				"metre per second", "m/s",
				LengthDimension.dimension (), TimeDimension.dimension ());
		Unit metrePerSecond = UnitFactory.getOrCreateQuotient (
				"m/s", "m s^(-1)",
				Metre.unit (), Second.unit (), SIUnitConverter.getInstance ());

		assertEquals ("There's only one length/time unit.", mps, metrePerSecond);
		assertEquals ("The first time a unit is created set the name.", mps.getName (), metrePerSecond.getName ());
		assertEquals ("The first time a unit is created set the symbol.", mps.getSymbol (), metrePerSecond.getSymbol ());
		assertEquals ("The first time a unit is created set the dimension.", mps.getDimension (), metrePerSecond.getDimension ());
	}

	@Test
	public void testSIQuotientUnit () {
		Unit mps = UnitFactory.getOrCreateQuotient (
				Metre.unit (), Second.unit (), null);

		double dValue = Math.random () * Double.MAX_VALUE;
		double fValue = (float) Math.random () * ((double) Float.MAX_VALUE);
		
		assertTrue ("SI Unit should not change it's values on conversion", dValue == mps.convertFromSIBase (dValue));
		assertTrue ("SI Unit should not change it's values on conversion", fValue == mps.convertFromSIBase (fValue));
		
		assertTrue ("SI Unit should not change it's values on conversion", dValue == mps.convertToSIBase (dValue));
		assertTrue ("SI Unit should not change it's values on conversion", fValue == mps.convertToSIBase (fValue));
	}

	@Test
	public void testPrefixedUnits () {
		Unit kilometre = UnitFactory.getOrCreatePrefixedUnit (Prefix.KILO, Metre.unit ());
		assertEquals ("kilometre", kilometre.getName ());
		assertEquals ("Km", kilometre.getSymbol ());

		Unit km2 = UnitFactory.getOrCreatePrefixedUnit (Prefix.KILO, Metre.unit ());
		assertTrue (kilometre == km2);
	}
}
