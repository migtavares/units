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
package org.bitpipeline.lib.units.deriv.area;

import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.length.Foot;
import org.bitpipeline.lib.units.base.length.Metre;
import org.bitpipeline.lib.units.deriv.UnitConverter;
import org.bitpipeline.lib.units.deriv.UnitFactory;

/** This is a class provides some pre defined Area units.
 * @author mtavares */
public class AreaUnitFactory {
	/** Square Metre - the SI unit for Area. */
	static public Unit getSquareMetre () {
		return UnitFactory.getOrCreateSIProduct (
				"square metre", "m\u00b2",
				Metre.unit (), Metre.unit ());
	}

	static final private UnitConverter SQUARE_FOOT_CONVERTER = new UnitConverter () {
		@Override
		public float convertToSIBase (float value) {
			return value * 0.09290304f;
		}

		@Override
		public double convertToSIBase (double value) {
			return value * 0.09290304d;
		}

		@Override
		public float convertFromSIBase (float value) {
			return value * 10.76391041671f;
		}

		@Override
		public double convertFromSIBase (double value) {
			return value * 10.76391041671d;
		}
	};
		
	/** Square foot */
	static public Unit getSquareFoot () {
		return UnitFactory.getOrCreateProduct (
				"square foot", "ft\u00b2",
				AreaUnitFactory.SQUARE_FOOT_CONVERTER,
				Foot.unit (), Foot.unit ());
	}
}
