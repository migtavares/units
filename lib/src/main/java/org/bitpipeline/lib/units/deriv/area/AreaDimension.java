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
package org.bitpipeline.lib.units.deriv.area;

import org.bitpipeline.lib.units.Dimension;
import org.bitpipeline.lib.units.base.length.LengthDimension;
import org.bitpipeline.lib.units.deriv.DimensionFactory;
import org.bitpipeline.lib.units.deriv.NamingProvider;

/** Area express the surface of a two dimensional surface. */
final public class AreaDimension {
	static private Dimension DIM = DimensionFactory.getOrCreateProduct (
			"area", "A",
			new NamingProvider () {
				@Override
				public String getName () {
					return "square metre";
				}

				@Override
				public String getSymbol () {
					return "m\u00b2";
				}},
			LengthDimension.dimension (), LengthDimension.dimension ());

	static public Dimension dimension() {
		return AreaDimension.DIM;
	}
}
