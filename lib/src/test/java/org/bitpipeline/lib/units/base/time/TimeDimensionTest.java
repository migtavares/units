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
package org.bitpipeline.lib.units.base.time;

import junit.framework.TestCase;

import org.bitpipeline.lib.units.Dimension;
import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.time.Second;
import org.bitpipeline.lib.units.base.time.TimeDimension;
import org.junit.Test;

public class TimeDimensionTest extends TestCase {
	@Test
	public void testNameAndSymbol () {
		Dimension time = TimeDimension.dimension ();
		assertEquals ("time", time.getName ());
		assertEquals ("T", time.getSymbol ());
	}

	@Test
	public void testSIUnit () {
		Dimension time = TimeDimension.dimension ();
		Unit unit = time.getSIUnit ();
		assertNotNull ("Time dimension must have a SI unit.", unit);
		assertTrue ("Time SI unit is Second", unit instanceof Second);
	}

	@Test
	public void testCardinality () {
		Dimension time = TimeDimension.dimension ();
		assertTrue ("Time dimension has cardinality of 1", time.getCardinality () == 1);
	}
}
