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

import org.bitpipeline.lib.units.Dimension;
import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.mass.MassDimension;
import org.junit.Test;

public class MassDimensionTest extends TestCase {
	@Test
	public void testNameAndSymbol () {
		Dimension mass = MassDimension.dimension ();
		assertEquals ("mass", mass.getName ());
		assertEquals ("M", mass.getSymbol ());
	}

	@Test
	public void testSIUnit () {
		Dimension mass = MassDimension.dimension ();
		Unit unit = mass.getSIUnit ();
		assertNotNull ("Dimension must have a SI unit.", unit);
	}

	@Test
	public void testCardinality () {
		Dimension mass = MassDimension.dimension ();
		assertTrue ("Dimension has cardinality of 1", mass.getCardinality () == 1);
	}
}
