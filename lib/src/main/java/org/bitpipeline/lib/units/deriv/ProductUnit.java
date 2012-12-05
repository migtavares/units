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


/**
 * 
 * @author mtavares */
class ProductUnit extends AbstractDerivedUnit {
	final static private String NAME_SEPARATOR = " by ";
	final static private String SYMBOL_SEPARATOR = "·";

	static class ProductUnitDefaultNamingProvider implements NamingProvider {
		final String name;
		final String symbol;

		public ProductUnitDefaultNamingProvider (Dimension ... dimensions) {
			StringBuilder nameBuilder = new StringBuilder ();
			StringBuilder symbolBuilder = new StringBuilder ();
			for (Dimension dim: dimensions) {
				Unit siUnit = dim.getSIUnit ();
				nameBuilder.append (siUnit.getName ());
				nameBuilder.append (ProductUnit.NAME_SEPARATOR);
				symbolBuilder.append (siUnit.getSymbol ());
				symbolBuilder.append (ProductUnit.SYMBOL_SEPARATOR);
			}
			this.name = nameBuilder.substring (0, nameBuilder.length () - ProductUnit.NAME_SEPARATOR.length ());
			this.symbol = symbolBuilder.substring (0, symbolBuilder.length () - ProductUnit.SYMBOL_SEPARATOR.length ());
		}

		@Override
		public String getName () {
			return name;
		}

		@Override
		public String getSymbol () {
			return symbol;
		}
		
	}

	static String getDefaultName (Unit ... units) {
		StringBuilder builder = new StringBuilder ();
		for (Unit u : units) {
			builder.append (u.getName ());
			builder.append (ProductUnit.NAME_SEPARATOR);
		}
		return builder.substring (0, builder.length () - ProductUnit.NAME_SEPARATOR.length ());
	}

	static String getDefaultSymbol (Unit ... units) {
		StringBuilder builder = new StringBuilder ();
		for (Unit u : units) {
			builder.append (u.getName ());
			builder.append (ProductUnit.SYMBOL_SEPARATOR);
		}
		return builder.substring (0, builder.length () - ProductUnit.SYMBOL_SEPARATOR.length ());
	}

	final private Unit[] componentUnits;

	/**
	 *  */
	ProductUnit (Dimension dimension, UnitConverter converter, Unit ... units) {
		this (
				ProductUnit.getDefaultName (units),
				ProductUnit.getDefaultSymbol (units),
				dimension, converter,
				units);
	}

	ProductUnit (String name, String symbol, Dimension dimension, UnitConverter converter, Unit ... units) {
		super (name, symbol, dimension, converter, units);
		this.componentUnits = units;
	}


	public Unit[] getComponentunits () {
		return this.componentUnits;
	}
}
