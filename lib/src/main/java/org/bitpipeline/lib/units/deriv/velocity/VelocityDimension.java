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
package org.bitpipeline.lib.units.deriv.velocity;

import org.bitpipeline.lib.units.Dimension;
import org.bitpipeline.lib.units.base.length.LengthDimension;
import org.bitpipeline.lib.units.base.time.TimeDimension;
import org.bitpipeline.lib.units.deriv.DimensionFactory;
import org.bitpipeline.lib.units.deriv.NamingProvider;

/** Velocity is the quotient (ratio) between length and time.
 * <p>SI defines the Metre per Second as the unit for measures of velocity.</p>*/
final public class VelocityDimension {
	static private Dimension DIM = DimensionFactory.getOrCreateQuotient (
			"velocity", "V",
			new NamingProvider() {
				@Override
				public String getSymbol () {
					return "m/s";
				}

				@Override
				public String getName () {
					return "metre per second";
				}
			},
			LengthDimension.dimension (), TimeDimension.dimension ());

	static public Dimension dimension() {
		return VelocityDimension.DIM;
	}
}
