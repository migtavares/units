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

import org.bitpipeline.lib.units.Dimension;
import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.substance.SubstanceDimension;
import org.junit.Test;

public class SubstanceDimensionTest extends TestCase {
	@Test
	public void testNameAndSymbol () {
		Dimension substance = SubstanceDimension.dimension ();
		assertEquals ("substance", substance.getName ());
		assertEquals ("N", substance.getSymbol ());
	}

	@Test
	public void testSIUnit () {
		Dimension substance = SubstanceDimension.dimension ();
		Unit unit = substance.getSIUnit ();
		assertNotNull ("Substance dimension must have a SI unit.", unit);
	}

	@Test
	public void testCardinality () {
		Dimension substance = SubstanceDimension.dimension ();
		assertTrue ("Substance dimension has cardinality of 1", substance.getCardinality () == 1);
	}
}
