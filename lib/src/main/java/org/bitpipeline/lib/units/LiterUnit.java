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

public class LiterUnit extends AbstractUnit {
	static final private LiterUnit UNIT = new LiterUnit ();

	private LiterUnit() {
		super("Litre", "l", LengthDimension.dimension(), LengthDimension.dimension(), LengthDimension.dimension());
	}

	static public Unit unit () {
		return LiterUnit.UNIT;
	}

	public Unit getUnit() {
		return LiterUnit.unit ();
	}

	@Override
	protected double convertValueToSiBase(final double value) {
		return value * 0.001d;
	}

	@Override
	protected double convertValueFromSiBase(final double value) {
		return value / 0.001d;
	}
}
