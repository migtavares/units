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
package org.bitpipeline.lib.units.deriv.volume;

import org.bitpipeline.lib.units.Dimension;
import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.length.Metre;
import org.bitpipeline.lib.units.deriv.Prefix;
import org.bitpipeline.lib.units.deriv.UnitConverter;
import org.bitpipeline.lib.units.deriv.UnitFactory;

/** This is a class provides some pre defined Volume units.
 * @author mtavares */
public class VolumeUnitFactory {
	static final Dimension SI_DIMENSION = VolumeDimension.dimension ();

	/** Cubic Metre - the SI unit for volumes measurements. */
	static public Unit getCubicMetre () {
		return VolumeUnitFactory.SI_DIMENSION.getSIUnit ();
	}

	static final private UnitConverter LITRE_CONVERTER = new UnitConverter () {
		@Override
		public float convertToSIBase (float value) {
			return value * 0.001f;
		}

		@Override
		public double convertToSIBase (double value) {
			return value * 0.001d;
		}

		@Override
		public float convertFromSIBase (float value) {
			return value * 1000.0f;
		}

		@Override
		public double convertFromSIBase (double value) {
			return value * 1000.0d;
		}
	}; 

	/** Litre */
	static public Unit getLitre () {
		final Unit decimetre = UnitFactory.getOrCreatePrefixedUnit (Prefix.DECI, Metre.unit ());
		return UnitFactory.getOrCreateProduct (
				"litre", "l",
				VolumeUnitFactory.LITRE_CONVERTER,
				decimetre, decimetre, decimetre);
	}
}
