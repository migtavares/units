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
package org.bitpipeline.lib.units.deriv.velocity;

import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.length.Foot;
import org.bitpipeline.lib.units.base.length.LengthDimension;
import org.bitpipeline.lib.units.base.length.NauticalMile;
import org.bitpipeline.lib.units.base.time.Hour;
import org.bitpipeline.lib.units.base.time.Second;
import org.bitpipeline.lib.units.base.time.TimeDimension;
import org.bitpipeline.lib.units.deriv.UnitConverter;
import org.bitpipeline.lib.units.deriv.UnitFactory;

/** This is a class provides some pre defined Velocity units.
 * @author mtavares */
public class VelocityUnitFactory {
	/** Metre per second - the SI unit for velocity
	 * @return a quotient unit with Metre as the dividend and Second as the divisor. */
	static public Unit getMetrePerSecond () {
		return UnitFactory.getOrCreateSIQuotient (
				"metre per second", "m/s",
				LengthDimension.dimension (), TimeDimension.dimension ());
	}

	static final private UnitConverter KNOTS_UNIT_CONVERTER = new UnitConverter () {
		@Override
		public float convertToSIBase (float value) {
			return value * 0.514444444444444f;
		}

		@Override
		public double convertToSIBase (double value) {
			return value * 0.514444444444444d;
		}

		@Override
		public float convertFromSIBase (float value) {
			return value / 0.514444444444444f;
		}

		@Override
		public double convertFromSIBase (double value) {
			return value / 0.514444444444444d;
		}
	};

	/** Knot - a nautical velocity unit
	 * @return a quotient unit with Nautical Mile as the dividend and Hour as the divisor. */
	static public Unit getKnots () {
		return UnitFactory.getOrCreateQuotient (
				"knots", "kt",
				NauticalMile.unit (), Hour.unit (),
				VelocityUnitFactory.KNOTS_UNIT_CONVERTER);
	}

	static final private UnitConverter FOOT_PER_SECOND_CONVERTER = new UnitConverter () {
		@Override
		public float convertToSIBase (float value) {
			return value * 0.3048f;
		}

		@Override
		public double convertToSIBase (double value) {
			return value * 0.3048d;
		}

		@Override
		public float convertFromSIBase (float value) {
			return value / 0.3048f;
		}

		@Override
		public double convertFromSIBase (double value) {
			return value / 0.3048d;
		}
	};

	/** Foot per second.
	 * @return quotient unit with Foot as the dividend and Second as the divisor.*/
	static public Unit getFootPerSecond () {
		return UnitFactory.getOrCreateQuotient (
				"foot per second", "ft/s",
				Foot.unit (), Second.unit (), VelocityUnitFactory.FOOT_PER_SECOND_CONVERTER);
	}

	/** Beaufort scale - a wind scale based on observed conditions.
	 * @return special implementation of a unit*/
	static public Unit getBeaufortScale () {
		return BeaufortScale.unit ();
	}

}
