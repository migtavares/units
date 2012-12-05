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
package org.bitpipeline.lib.units;

import org.bitpipeline.lib.units.base.length.Inch;
import org.bitpipeline.lib.units.base.length.LengthDimension;
import org.bitpipeline.lib.units.base.length.Metre;
import org.bitpipeline.lib.units.base.length.NauticalMile;
import org.bitpipeline.lib.units.deriv.UnitConverter;

/** The basic interface that all units must implements.
 * </br><b>Important note</b>: as of Java 7 there's no language support for interfaces
 * defining static methods. It's never the less mandatory that all Unit
 * implementations are singletons and implement the method:</br>
 * <code>public static Unit unit ()</code>.</br>
 * */
public interface Unit extends UnitConverter {
	/** Return the Unit implementation.
	 * @return this Unit implementation */
	Unit getUnit ();

	/** Checks if this unit is of the same dimension as another unit.
	 * @param unit another unit to check for compliance
	 * @return <code>true</true> if both units belong to the same dimension */
	boolean isEquivalent (Unit unit);

	/** Get the dimension of this unit.
	 * </br>Example: {@link Metre} and{@link Inch} have a length dimension:
	 * </br><code></br>
	 * Dimension dim = Metre.unit ().getDimension ();
	 * </br></code></br>
	 * <code>dim</code> would be a instance of {@link LengthDimension}
	 * @return the dimension implementation of this unit. */
	Dimension getDimension ();

	/** Gets the name of the unit.
	 * The name is always all lower case, but might contain spaced
	 * (example: "nautical mile" for {@link NauticalMile})
	 * @return the long name of the unit (such as "metre" for the unit {@link Metre})*/
	String getName ();
	/** @return the symbol of the unit (such as "m" for the unit {@link Metre} )*/
	String getSymbol ();
}
