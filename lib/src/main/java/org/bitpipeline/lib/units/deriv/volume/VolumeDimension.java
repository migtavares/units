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
package org.bitpipeline.lib.units.deriv.volume;

import org.bitpipeline.lib.units.Dimension;
import org.bitpipeline.lib.units.base.length.LengthDimension;
import org.bitpipeline.lib.units.deriv.DimensionFactory;
import org.bitpipeline.lib.units.deriv.NamingProvider;

/** Volume is the amount of space within a three dimensional enclosed by some boundary. */
final public class VolumeDimension {
	static private Dimension DIM = DimensionFactory.getOrCreateProduct (
			"volume", "V",
			new NamingProvider () {
				@Override
				public String getName () {
					return "cubic metre";
				}

				@Override
				public String getSymbol () {
					return "m\u00b3";
				}},
			LengthDimension.dimension (), LengthDimension.dimension (), LengthDimension.dimension ());

	static public Dimension dimension() {
		return VolumeDimension.DIM;
	}
}
