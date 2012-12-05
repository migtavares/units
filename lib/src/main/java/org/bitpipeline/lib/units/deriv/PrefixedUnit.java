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

import org.bitpipeline.lib.units.Dimension;
import org.bitpipeline.lib.units.Unit;
import org.bitpipeline.lib.units.base.mass.Gram;
import org.bitpipeline.lib.units.base.mass.Kilogram;

/** A {@link Unit} decorator.
 * 
 * <p>It serves the purpose of using unit prefixes such as "tera" or "mega".</p>
 * <p>
 * Example for using kilometre:
 * <code>
 * Unit km = new PrefixedUnit (Prefix.KILO, Metre.unit ());
 * </code>
 * </p>
 * <p>One very specific case takes place with the Kilogram unit, that is
 * prefixed with "Kilo" despite being the base SI unit for mass.</p> */
class PrefixedUnit implements Unit {
	final private Unit baseUnit;
	final private Prefix prefix;
	final float fCardinality;
	final double dCardinality;

	/** Creates a prefixed unit using the provided prefix and unit.
	 * @param prefix is the prefix to use 
	 * @param baseUnit is the base unit to use*/
	PrefixedUnit (final Prefix prefix, final Unit baseUnit) {
		if (baseUnit == Kilogram.unit ())
			this.baseUnit = Gram.unit ();
		else
			this.baseUnit = baseUnit;
		this.prefix = prefix;
		int cardinality = baseUnit.getDimension ().getCardinality ();
		this.dCardinality = (double) cardinality;
		this.fCardinality = (float) cardinality;
	}

	/** Creates a prefixed unit using the provided prefix and unit.
	 * @param prefix is the prefix to use 
	 * @param baseUnit is the base unit to use
	 * @param name the name to use with this prefixed unit
	 * @param symbol the symbol to use for this prefixed unit */
	public PrefixedUnit (final Prefix prefix, final Unit baseUnit, String name, String symbol) {
		this (prefix, baseUnit);
		this.name = name;
		this.symbol = symbol;
	}

	public Prefix getPrefix () {
		return this.prefix;
	}

	public Unit getBaseUnit () {
		return this.baseUnit;
	}

	@Override
	public Unit getUnit () {
		return this;
	}

	@Override
	public boolean isEquivalent (Unit unit) {
		return this.baseUnit.isEquivalent (unit);
	}

	@Override
	public Dimension getDimension () {
		return this.baseUnit.getDimension ();
	}

	private String name = null;
	private String symbol = null;

	@Override
	public String getName () {
		if (this.name == null)
			this.name = PrefixedUnit.defaultName (this.prefix, this.baseUnit);
		return this.name;
	}

	static public String defaultName (Prefix prefix, Unit baseUnit) {
		return prefix.getPrefix () + baseUnit.getName ();
	}
	
	@Override
	public String getSymbol () {
		if (this.symbol == null)
			this.symbol = PrefixedUnit.defaultSymbol (this.prefix, this.baseUnit); 
		return this.symbol;
	}

	static public String defaultSymbol (Prefix prefix, Unit baseUnit) {
		return prefix.getSymbol () + baseUnit.getSymbol ();
	}

	@Override
	public float convertToSIBase (float value) {
		return this.baseUnit.convertToSIBase (value) * this.prefix.getFloatMult (this.fCardinality);
	}

	@Override
	public double convertToSIBase (double value) {
		return this.baseUnit.convertToSIBase (value) * this.prefix.getDoubleMult (this.dCardinality);
	}

	@Override
	public float convertFromSIBase (float value) {
		return this.baseUnit.convertFromSIBase (value) / this.prefix.getFloatMult (this.fCardinality) ;
	}

	@Override
	public double convertFromSIBase (double value) {
		return this.baseUnit.convertFromSIBase (value) / this.prefix.getDoubleMult (this.dCardinality);
	}
}
