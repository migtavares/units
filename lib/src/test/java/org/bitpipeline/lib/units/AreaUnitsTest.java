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
package org.bitpipeline.lib.units;

import org.junit.Test;

import junit.framework.TestCase;

public class AreaUnitsTest extends TestCase {
	@Test
	public void testSquareFootUnit () {
		Unit sFoot = SquareFootUnit.unit ();

		// conversion from 1.0 square foot to square meter
		assertTrue (Math.abs (sFoot.convertToSIBase (1.0d).doubleValue () - 0.09290304d) <= Double.MIN_VALUE * 10.0d);

		// conversion from 1.0 square meter to square foot
		assertTrue (Math.abs (sFoot.convertFromSIBase (1.0d).doubleValue () - 10.763910416709722d) <= Double.MIN_VALUE*10.0d);
	}
}
