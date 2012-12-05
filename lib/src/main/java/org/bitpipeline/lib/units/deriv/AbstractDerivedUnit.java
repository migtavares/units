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
package org.bitpipeline.lib.units.deriv;

import org.bitpipeline.lib.units.AbstractUnit;
import org.bitpipeline.lib.units.Dimension;
import org.bitpipeline.lib.units.Unit;

/**
 * 
 * @author mtavares */
abstract class AbstractDerivedUnit extends AbstractUnit {
	final protected UnitConverter converter;
	final protected Dimension dim;

	public AbstractDerivedUnit (String name, String symbol, Dimension dimension, UnitConverter converter, Unit ... units) {
		super (name, symbol, dimension);
		if (converter == SIUnitConverter.getInstance () || converter == null) {
			for (Unit unit : units) {
				if (unit.getDimension ().getSIUnit () != unit)
					throw new IllegalArgumentException ("Can't create a product unit with the default identity converter for non SI units");
			}
			this.converter = SIUnitConverter.getInstance ();
		} else {
			this.converter = converter;
		}
		this.dim = dimension;
	}

	
	@Override
	public Unit getUnit () {
		return this;
	}

	@Override
	public boolean isEquivalent (Unit unit) {
		return this.getDimension () == unit.getDimension ();
	}

	@Override
	public Dimension getDimension () {
		return this.dim;
	}

	@Override
	public float convertToSIBase (float value) {
		return this.converter.convertToSIBase (value);
	}

	@Override
	public double convertToSIBase (double value) {
		return this.converter.convertToSIBase (value);
	}

	@Override
	public float convertFromSIBase (float value) {
		return this.converter.convertFromSIBase (value);
	}

	@Override
	public double convertFromSIBase (double value) {
		return this.converter.convertFromSIBase (value);
	}
}
