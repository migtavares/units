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
package org.bitpipeline.lib.units.base.temperature;

import org.bitpipeline.lib.units.AbstractUnit;
import org.bitpipeline.lib.units.Unit;

final public class Fahrenheit extends AbstractUnit {
	static final private Fahrenheit UNIT = new Fahrenheit ();

	private Fahrenheit() {
		super("fahrenheit", "\u00B0F", TemperatureDimension.dimension ());
	}

	static public Unit unit () {
		return Fahrenheit.UNIT;
	}

	public Unit getUnit() {
		return Fahrenheit.unit ();
	}

	@Override
	public float convertToSIBase (float value) {
		return (value + 459.6700000000f) * 5.0000000000f/9.0000000000f;
	}

	@Override
	public double convertToSIBase (double value) {
		return (value + 459.6700000000d) * 5.0000000000d/9.0000000000d;
	}

	@Override
	public float convertFromSIBase (float value) {
		return value * 9.0000000000f/5.0000000000f - 459.6700000000f;
	}

	@Override
	public double convertFromSIBase (double value) {
		return value * 9.0000000000d/5.0000000000d - 459.6700000000d;
	}
}
