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
package org.bitpipeline.lib.units.base.substance;

import junit.framework.TestCase;

import org.bitpipeline.lib.units.PrecisionExpectations;
import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.substance.Mole;
import org.bitpipeline.lib.units.base.substance.SubstanceDimension;
import org.junit.Test;

public class MoleUnitTest extends TestCase {
	@Test
	public void testMoleNameAndSymbol () {
		Unit mol = Mole.unit ();
		assertEquals ("mole", mol.getName ());
		assertEquals ("mol", mol.getSymbol ());
	}

	@Test
	public void testMoleDimension () {
		Unit mol = Mole.unit ();
		assertTrue (mol.getDimension () instanceof SubstanceDimension);
	}

	@Test
	public void testIsUnique () {
		Unit mol = Mole.unit ();
		Unit mol2 = mol.getUnit ();
		assertTrue ("A unit must be a singleton, so only one instance should exist.", mol == mol2);
	}

	@Test
	public void testMoleSIConvertion () {
		Unit mol = Mole.unit ();

		double dValue = Math.random ()*1000d;
		float fValue = (float) dValue;

		// Test the SI base unit
		assertEquals(dValue, mol.convertToSIBase (dValue), PrecisionExpectations.FOR_DOUBLES);
		assertEquals(fValue, mol.convertToSIBase (fValue), PrecisionExpectations.FOR_FLOATS);

		assertEquals(dValue, mol.convertFromSIBase (dValue), PrecisionExpectations.FOR_DOUBLES);
		assertEquals(fValue, mol.convertFromSIBase (fValue), PrecisionExpectations.FOR_FLOATS);
	}
}
