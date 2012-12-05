/**
 * Copyright 2013 J. Miguel P. Tavares
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.bitpipeline.lib.units.base.length.LengthDimension;
import org.bitpipeline.lib.units.base.time.TimeDimension;
import org.bitpipeline.lib.units.deriv.QuotientDimension;
import org.junit.Test;

/**
 * 
 * @author mtavares */
public class QuotientDimensionTest {
	@Test
	public void testVelocityNameAndSymbol () {
		QuotientDimension dim = new QuotientDimension ("velocity",
				LengthDimension.dimension (), TimeDimension.dimension ());
		assertEquals ("velocity", dim.getName ());
		assertEquals ("L/T", dim.getSymbol ());
		assertNotNull (dim.getSIUnit ());
		assertEquals ("metre per second", dim.getSIUnit ().getName ());
		assertEquals ("m/s", dim.getSIUnit ().getSymbol ());
		assertTrue ("Cardinality of velocity is 1", dim.getCardinality () == 1);
	}

}
