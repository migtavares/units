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


public abstract class AbstractUnit implements Unit {
	protected final transient String symbol;
	protected final transient String name;
	protected final Dimension dimension;

	public AbstractUnit (final String name, final String symbol, final Dimension dimension) {
		this.name = name;
		this.symbol = symbol;
		this.dimension = dimension;
	}

	@Override
	public Dimension getDimension () {
		return this.dimension;
	}

	@Override
	public String getSymbol () {
		return this.symbol;
	}

	@Override
	public String getName () {
		return this.name;
	}
	
	@Override
	public String toString () {
		return getSymbol();
	}

	public boolean isEquivalent(final Unit unit) {
		return this.dimension == unit.getDimension();
	}
}
