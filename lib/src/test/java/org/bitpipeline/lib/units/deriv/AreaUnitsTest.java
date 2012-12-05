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

import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.deriv.area.AreaUnitFactory;
import org.junit.Test;

public class AreaUnitsTest extends TestCase {
	@Test
	public void testSquareFootUnit () {
		Unit sFoot = AreaUnitFactory.getSquareFoot ();

		// conversion from 1.0 square foot to square meter
		assertEquals (0.09290304d, sFoot.convertToSIBase (1.0d), Double.MIN_NORMAL);
		assertEquals (0.09290304f, sFoot.convertToSIBase (1.0f), Float.MIN_NORMAL);

		// conversion from 1.0 square meter to square foot
		assertEquals (10.76391041671d, sFoot.convertFromSIBase (1.0d), Double.MIN_NORMAL);
		assertEquals (10.76391041671f, sFoot.convertFromSIBase (1.0f), Float.MIN_NORMAL);
	}
}
