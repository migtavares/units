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
package org.bitpipeline.lib.units.base.electric;

import junit.framework.TestCase;

import org.bitpipeline.lib.units.Dimension;
import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.electric.ElectricCurrentDimension;
import org.junit.Test;

public class ElectricCurrentDimensionTest extends TestCase {
	@Test
	public void testNameAndSymbol () {
		Dimension current = ElectricCurrentDimension.dimension ();
		assertEquals ("electric current", current.getName ());
		assertEquals ("I", current.getSymbol ());
	}

	@Test
	public void testSIUnit () {
		Dimension current = ElectricCurrentDimension.dimension ();
		Unit unit = current.getSIUnit ();
		assertNotNull ("Electric current dimension must have a SI unit.", unit);
	}

	@Test
	public void testCardinality () {
		Dimension current = ElectricCurrentDimension.dimension ();
		assertTrue ("Electric current dimension has cardinality of 1", current.getCardinality () == 1);
	}
}
