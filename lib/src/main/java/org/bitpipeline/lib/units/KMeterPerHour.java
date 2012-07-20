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

/** Kilometer per hour
 * @author mtavares */
public class KMeterPerHour extends AbstractUnit {
	static final private KMeterPerHour UNIT = new KMeterPerHour ();

	private KMeterPerHour () {
		super ("Kilometre per hour", "km/h", LengthDimension.dimension(), TimeDimension.dimension());
	}

	static public Unit unit () {
		return KMeterPerHour.UNIT;
	}

	/* @see org.bitpipeline.app.windsurfcalculator.units.Unit#getUnit() */
	public Unit getUnit () {
		return KMeterPerHour.unit ();
	}

	/* @see org.bitpipeline.app.windsurfcalculator.units.AbstractUnit#convertValueToSiBase(double) */
	@Override
	double convertValueToSiBase (double value) {
		return value / 3.6d;
	}

	/* @see org.bitpipeline.app.windsurfcalculator.units.AbstractUnit#convertValueFromSiBase(double) */
	@Override
	double convertValueFromSiBase (double value) {
		return value * 3.6d;
	}

}
