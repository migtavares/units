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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.bitpipeline.lib.units.base.length.LengthDimension;
import org.bitpipeline.lib.units.base.time.TimeDimension;
import org.bitpipeline.lib.units.deriv.DimensionFactory;
import org.junit.Test;

/**
 * @author mtavares */
public class DimensionFactoryTest {

	@Test
	public void testUniquenessOfQuotientDimension () {
		Dimension velocityDimension = DimensionFactory.getOrCreateQuotient (
				 "velocity", "v",
				LengthDimension.dimension (), TimeDimension.dimension ());
		Dimension speedDimension = DimensionFactory.getOrCreateQuotient (
				"speed", "s",
				LengthDimension.dimension (), TimeDimension.dimension ());

		assertEquals ("There's only one length/time dimension.", velocityDimension, speedDimension);
		assertEquals ("The first time a dimension is created set the name.", velocityDimension.getName (), speedDimension.getName ());
		assertEquals ("The first time a dimension is created set the symbol.", velocityDimension.getSymbol (), speedDimension.getSymbol ());
		assertEquals ("The first time a dimension is created set the cardinality.", velocityDimension.getCardinality (), speedDimension.getCardinality ());
	}

	@Test
	public void testUniquenessOfProductDimension () {
		Dimension volume1 = DimensionFactory.getOrCreateProduct ("volume", "V",
				LengthDimension.dimension (), LengthDimension.dimension (), LengthDimension.dimension ());
		Dimension volume2 = DimensionFactory.getOrCreateProduct ("volume2", "V2",
				LengthDimension.dimension (), LengthDimension.dimension (), LengthDimension.dimension ());
		
		assertNotNull (volume1);
		assertNotNull (volume2);
		assertEquals (volume1, volume2);
		assertEquals ("volume", volume2.getName ());
		assertEquals ("V", volume2.getSymbol ());
	}

}
