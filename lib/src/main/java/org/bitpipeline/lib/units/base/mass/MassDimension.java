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
package org.bitpipeline.lib.units.base.mass;

import org.bitpipeline.lib.units.AbstractDimension;
import org.bitpipeline.lib.units.Dimension;
import org.bitpipeline.lib.units.Unit;

final public class MassDimension extends AbstractDimension {
	static private MassDimension DIM = new MassDimension();

	private MassDimension() {
		super ("mass", "M");
	}

	static public Dimension dimension() {
		return (Dimension) MassDimension.DIM;
	}

	@Override
	public Unit getSIUnit () {
		return Kilogram.unit ();
	}

	@Override
	public int getCardinality () {
		return 1;
	}

}
