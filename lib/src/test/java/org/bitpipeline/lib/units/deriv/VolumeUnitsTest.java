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
import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.deriv.volume.VolumeUnitFactory;
import org.junit.Test;

public class VolumeUnitsTest extends TestCase {
	@Test
	public void testCubicMetreUnitHasProperNamesAndSymbols () {
		VolumeUnitFactory.getLitre (); // force the creation of a non SI unit.
		Unit cubicMetre = VolumeUnitFactory.getCubicMetre ();

		assertEquals ("cubic metre", cubicMetre.getName ());
		assertEquals ("m\u00b3", cubicMetre.getSymbol ());
		
		Dimension dimension = cubicMetre.getDimension ();
		assertEquals ("volume", dimension.getName ());
		assertEquals ("V", dimension.getSymbol ());
	}
}
