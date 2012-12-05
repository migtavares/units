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
class QuotientUnit extends AbstractDerivedUnit {
	final static private String NAME_PATTERN = "%s per %s";
	final static private String SYMBOL_PATTERN = "%s/%s";

	final private Unit dividend;
	final private Unit divisor;

	static String getDefaultName (Unit dividend, Unit divisor) {
		return String.format (QuotientUnit.NAME_PATTERN, dividend.getName (), divisor.getName ());
	}

	static String getDefaultSymbol (Unit dividend, Unit divisor) {
		return String.format (QuotientUnit.SYMBOL_PATTERN, dividend.getSymbol (), divisor.getSymbol ());
	}

	/**
	 *  */
	QuotientUnit (Dimension dimension, UnitConverter converter, Unit dividend, Unit divisor) {
		this (
				QuotientUnit.getDefaultName (dividend, divisor),
				QuotientUnit.getDefaultSymbol (dividend, divisor),
				dimension, converter,
				dividend, divisor);
	}

	QuotientUnit (String name, String symbol, Dimension dimension, UnitConverter converter, Unit dividend, Unit divisor) {
		super (name, symbol, dimension, converter, dividend, divisor);
		this.dividend = dividend;
		this.divisor = divisor;
	}

	Unit getDividend () {
		return this.dividend;
	}

	Unit getDivisor () {
		return this.divisor;
	}
}
