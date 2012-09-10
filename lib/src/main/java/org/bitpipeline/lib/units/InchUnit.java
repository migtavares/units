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

public class InchUnit extends AbstractUnit {
	static final private InchUnit UNIT = new InchUnit ();

	public InchUnit() {
		super("Inch", "in", LengthDimension.dimension ());
	}

	static public Unit unit() {
		return InchUnit.UNIT;
	}

	public Unit getUnit() {
		return InchUnit.unit ();
	}

	@Override
	protected double convertValueToSiBase(final double value) {
		return value * 0.0254;
	}

	@Override
	protected double convertValueFromSiBase(final double value) {
		return value / 0.0254;
	}
}
