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

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractUnit implements Unit {
	protected final transient List<Dimension> dimensions = new ArrayList<Dimension> ();
	protected final transient String symbol;
	protected final transient String name;

	public AbstractUnit (final String name, final String symbol, final Dimension...dimensions) {
		this.name = name;
		this.symbol = symbol;

		for (Dimension dim : dimensions) {
			this.dimensions.add(dim);
			dim.addUnit(this);
		}
	}

	public List<Dimension> getDimensions () {
		return this.dimensions;
	}

	public String getSymbol () {
		return this.symbol;
	}

	public String getName () {
		return this.name;
	}

	public boolean isEquivalent(final Unit unit) {
		return this.dimensions.equals(unit.getDimensions());
	}

	abstract double convertValueToSiBase (final double value);
	abstract double convertValueFromSiBase (final double value);

	public Number convertToSIBase(final Number value) {
		double val = value.doubleValue();
		final double result;
		if (Double.isNaN(val) || Double.isInfinite(val))
			result = val;
		else
			result = convertValueToSiBase(value.doubleValue());
		if (value instanceof Byte)
			return Byte.valueOf ((byte) result);
		if (value instanceof Double)
			return Double.valueOf (result);
		if (value instanceof Float)
			return Float.valueOf ((float) result);
		if (value instanceof Integer)
			return Integer.valueOf ((int) result);
		if (value instanceof Long)
			return Long.valueOf ((long) result);
		if (value instanceof Short)
			return Short.valueOf ((short) result);
		return null;
	}

	public Number convertFromSIBase(final Number value) {
		double val = value.doubleValue();
		final double result;
		if (Double.isNaN(val) || Double.isInfinite(val))
			result = val;
		else
			result = convertValueFromSiBase(value.doubleValue());
		if (value instanceof Byte)
			return Byte.valueOf ((byte) result);
		if (value instanceof Double)
			return Double.valueOf (result);
		if (value instanceof Float)
			return Float.valueOf ((float) result);
		if (value instanceof Integer)
			return Integer.valueOf ((int) result);
		if (value instanceof Long)
			return Long.valueOf ((long) result);
		if (value instanceof Short)
			return Short.valueOf ((short) result);
		return null;
	}

	public String toString () {
		return getSymbol();
	}
}
