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
package org.bitpipeline.lib.units.base.mass;

import junit.framework.TestCase;

import org.bitpipeline.lib.units.PrecisionExpectations;
import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.mass.MassDimension;
import org.bitpipeline.lib.units.base.mass.Pound;
import org.junit.Test;

public class PoundTest extends TestCase {
	@Test
	public void testNameAndSymbol () {
		Unit pound = Pound.unit ();
		assertEquals ("imperial standard pound", pound.getName ());
		assertEquals ("lb", pound.getSymbol ());
	}

	@Test
	public void testDimension () {
		Unit pound = Pound.unit ();
		assertTrue (pound.getDimension () instanceof MassDimension);
	}

	@Test
	public void testIsUnique () {
		Unit pound = Pound.unit ();
		Unit pound2 = pound.getUnit ();
		assertTrue ("A unit must be a singleton, so only one instance should exist.", pound == pound2);
	}

	@Test
	public void testSIConvertion () {
		Unit pound = Pound.unit ();

		double dValue = Math.random ()*1000d;
		float fValue = (float) dValue;

		// Test the SI base unit
		assertEquals(dValue, 
				pound.convertFromSIBase (pound.convertToSIBase (dValue)),
				PrecisionExpectations.FOR_DOUBLES);
		assertEquals(fValue,
				pound.convertFromSIBase (pound.convertToSIBase (fValue)),
				PrecisionExpectations.FOR_FLOATS);

		assertEquals(dValue, 
				pound.convertToSIBase (pound.convertFromSIBase (dValue)),
				PrecisionExpectations.FOR_DOUBLES);
		assertEquals(fValue,
				pound.convertToSIBase (pound.convertFromSIBase (fValue)),
				PrecisionExpectations.FOR_FLOATS);
	}
}
