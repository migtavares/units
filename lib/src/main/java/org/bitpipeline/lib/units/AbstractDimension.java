package org.bitpipeline.lib.units;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDimension implements Dimension {
	final private transient List<Unit> units = new ArrayList<Unit> ();
	
	public boolean addUnit (final Unit newUnit) {
		for (Unit unit : this.units) {
			if (unit == newUnit)
				return true;
		}
		return this.units.add(newUnit);
	}
	
	public List<Unit> getUnits () {
		return new ArrayList<Unit> (this.units);
	}
}
