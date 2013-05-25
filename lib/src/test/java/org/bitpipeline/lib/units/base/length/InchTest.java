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
package org.bitpipeline.lib.units.base.length;

import junit.framework.TestCase;

import org.bitpipeline.lib.units.PrecisionExpectations;
import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.length.Inch;
import org.bitpipeline.lib.units.base.length.LengthDimension;
import org.junit.Test;

public class InchTest extends TestCase {
	@Test
	public void testNameAndSymbol () {
		Unit inch = Inch.unit ();
		assertEquals ("inch", inch.getName ());
		assertEquals ("in", inch.getSymbol ());
	}

	@Test
	public void testDimension () {
		Unit inch = Inch.unit ();
		assertTrue (inch.getDimension () instanceof LengthDimension);
	}

	@Test
	public void testIsUnique () {
		Unit inch = Inch.unit ();
		Unit inch2 = inch.getUnit ();
		assertTrue ("A unit must be a singleton, so only one instance should exist.", inch == inch2);
	}

	@Test
	public void testSIConvertion () {
		Unit inch = Inch.unit ();

		double dValue = Math.random ()*1000d;
		float fValue = (float) dValue;

		// Test the SI base unit
		assertEquals(dValue, 
				inch.convertFromSIBase (inch.convertToSIBase (dValue)),
				PrecisionExpectations.FOR_DOUBLES);
		assertEquals(fValue,
				inch.convertFromSIBase (inch.convertToSIBase (fValue)),
				PrecisionExpectations.FOR_FLOATS);

		assertEquals(dValue, 
				inch.convertToSIBase (inch.convertFromSIBase (dValue)),
				PrecisionExpectations.FOR_DOUBLES);
		assertEquals(fValue,
				inch.convertToSIBase (inch.convertFromSIBase (fValue)),
				PrecisionExpectations.FOR_FLOATS);

		// conversion from 1.0 inch to meter
		assertEquals (0.0254d, inch.convertToSIBase (1.0d), PrecisionExpectations.FOR_DOUBLES);
		assertEquals (0.0254f, inch.convertToSIBase (1.0f), PrecisionExpectations.FOR_FLOATS);
		
		// conversion from 1.0 meter to inch
		assertEquals (39.370079d, inch.convertFromSIBase (1.0d), PrecisionExpectations.FOR_DOUBLES);
		assertEquals (39.370079f, inch.convertFromSIBase (1.0f), PrecisionExpectations.FOR_FLOATS);
	}
}
