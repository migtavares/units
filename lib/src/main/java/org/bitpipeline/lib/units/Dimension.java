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

import java.util.List;

/** Defines a measurable dimension. */
public interface Dimension {
	/** Get the name of the dimension */
	String getName ();
	/** Get the symbol of the dimension */
	String getSymbol ();
	/** Gets a list of loaded units that are applicable to this dimension.
	 * @return a list of units */
	List<Unit> getUnits ();
	/** Gets the SI unit for this dimension
	 * @return a unit */
	Unit getSIUnit ();
	/** The cardinality of a dimensions relates to how many "sub" dimensions compose it.
	 * 
	 * <p>Better explained by examples:</p>
	 * <dl>
	 * 	</dt>AreaDimension</dt><dd>has a cardinality of 2 as its composed by
	 * 		the multiplication of two base dimensions (length x length)</dd>
	 * 	</dt>VolumeDimension</dt><dd>has a cardinality of 3 as its composed
	 * 		by the multiplication of three base dimensions (length x length
	 * 		x length)</dd>
	 * 	</dt>VelocityDimension</dt><dd>has a cardinality of 1 as its composed
	 * 		by the division of two base dimensions (length / time)</dd>
	 * </dl>
	 * <p>Cardinality is specially relevant when using prefix unit as
	 * it's used to calculate how a prefix affects the value of a unit.</p>*/
	int getCardinality ();
}
