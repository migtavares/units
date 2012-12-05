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

import org.bitpipeline.lib.units.Dimension;
import org.bitpipeline.lib.units.base.length.LengthDimension;
import org.junit.Test;

public class ProductDimensionTest extends TestCase {
	public void setUp () {
		UnitFactory.reset ();
		DimensionFactory.reset ();
	}

	@Test
	public void testAreaDimension () {
		Dimension area = new ProductDimension (
				"area", "A",
				LengthDimension.dimension (), LengthDimension.dimension ());

		assertNotNull (area);
		assertEquals ("area", area.getName ());
		assertEquals ("A", area.getSymbol ());
		assertEquals (2, area.getCardinality ());
	}

	@Test
	public void testVolumeDimension () {
		Dimension area = new ProductDimension ("volume", "V",
				LengthDimension.dimension (), LengthDimension.dimension (), LengthDimension.dimension ());

		assertNotNull (area);
		assertEquals ("volume", area.getName ());
		assertEquals ("V", area.getSymbol ());
		assertEquals (3, area.getCardinality ());
	}
}
