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
package org.bitpipeline.lib.units.base.luminous;

import junit.framework.TestCase;

import org.bitpipeline.lib.units.Dimension;
import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.luminous.LuminousIntensityDimension;
import org.junit.Test;

public class LuminousIntensityDimensionTest extends TestCase {
	@Test
	public void testNameAndSymbol () {
		Dimension luminous = LuminousIntensityDimension.dimension ();
		assertEquals ("luminous intensity", luminous.getName ());
		assertEquals ("J", luminous.getSymbol ());
	}

	@Test
	public void testSIUnit () {
		Dimension luminous = LuminousIntensityDimension.dimension ();
		Unit unit = luminous.getSIUnit ();
		assertNotNull ("Luminous intensity dimension must have a SI unit.", unit);
	}

	@Test
	public void testCardinality () {
		Dimension current = LuminousIntensityDimension.dimension ();
		assertTrue ("Luminous intensity dimension has cardinality of 1", current.getCardinality () == 1);
	}
}
