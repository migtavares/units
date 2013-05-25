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

import org.bitpipeline.lib.units.AbstractUnit;
import org.bitpipeline.lib.units.PrecisionExpectations;
import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.length.LengthDimension;
import org.bitpipeline.lib.units.base.time.Hour;
import org.bitpipeline.lib.units.deriv.velocity.BeaufortScale;
import org.bitpipeline.lib.units.deriv.velocity.VelocityUnitFactory;
import org.junit.Test;

public class VelocityUnitsTest extends TestCase {
	@Test
	public void testVelocityUnitConvertion () {
		Unit mpsUnit = VelocityUnitFactory.getMetrePerSecond ();
		Unit knotsUnit = VelocityUnitFactory.getKnots ();

		double value = 5.0d;

		// Test the SI base unit
		assertEquals(value, mpsUnit.convertFromSIBase(value), PrecisionExpectations.FOR_DOUBLES);
		assertEquals(value, mpsUnit.convertToSIBase(value), PrecisionExpectations.FOR_DOUBLES);

		// test the knots conversion
		assertEquals(
				value,
				knotsUnit.convertToSIBase(knotsUnit.convertFromSIBase(value)),
				PrecisionExpectations.FOR_DOUBLES);
		assertEquals(value*0.51444444d,
				knotsUnit.convertToSIBase(value),
				PrecisionExpectations.FOR_DOUBLES);
	}

	static class Mile extends AbstractUnit {
		final static private Unit UNIT = new Mile ();

		static public Unit unit () {
			return Mile.UNIT;
		}

		public Mile () {
			super ("mile", "mi", LengthDimension.dimension ());
		}

		@Override
		public Unit getUnit () {
			return Mile.UNIT;
		}

		@Override
		public float convertToSIBase (float value) {
			return value * 1609.344f;
		}

		@Override
		public double convertToSIBase (double value) {
			return value * 1609.344d;
		}

		@Override
		public float convertFromSIBase (float value) {
			return value / 1609.344f;
		}

		@Override
		public double convertFromSIBase (double value) {
			return value / 1609.344d;
		}
	}

	@Test
	public void testMPH () {
		Unit miphUnit = UnitFactory.getOrCreateQuotient (
				"miles per hour", "mi/h",
				Mile.unit (), Hour.unit (), new UnitConverter() {
					@Override
					public double convertToSIBase (double value) {
						return value * 0.44703805992635d;
					}

					@Override
					public float convertToSIBase (float value) {
						return value * 0.44703805992635f;
					}

					@Override
					public double convertFromSIBase (double value) {
						return value * 2.236946d;
					}

					@Override
					public float convertFromSIBase (float value) {
						return value * 2.236946f;
					}
				});
		
		double mps = miphUnit.convertToSIBase(1.0d);
		double miph = miphUnit.convertFromSIBase(mps);

		assertEquals (0.447038d, mps, PrecisionExpectations.FOR_DOUBLES);
		assertEquals (1.0d, miph, PrecisionExpectations.FOR_DOUBLES);
	}

	@Test
	public void testFtPS () {
		Unit ftpsUnit = VelocityUnitFactory.getFootPerSecond ();
		
		double mps = ftpsUnit.convertToSIBase(1.0d);
		double ftps = ftpsUnit.convertFromSIBase(mps);
		assertEquals (0.3048d, mps, PrecisionExpectations.FOR_DOUBLES);
		assertEquals (1.0d, ftps, PrecisionExpectations.FOR_DOUBLES);
	}

	@Test
	public void testBeaufortConversion () {
		Unit bfUnit = VelocityUnitFactory.getBeaufortScale ();
		double value;
		for (value = 0.0d; value < 40.0d; value = value +0.0001d) {
			double bf = bfUnit.convertFromSIBase(value);
			double ms = bfUnit.convertToSIBase(bf);
			assertEquals (value, ms, PrecisionExpectations.FOR_DOUBLES);

			int bsScale = (int) Math.floor (bf);
			if (bsScale > 12) bsScale = 12;
			BeaufortScale.BeaufortScaleType scale = BeaufortScale.getScale(bf);
			assertEquals (bsScale, scale.ordinal ());
		}
	}
}
