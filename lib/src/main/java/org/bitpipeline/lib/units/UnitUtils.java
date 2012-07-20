package org.bitpipeline.lib.units;

import java.util.ArrayList;
import java.util.List;

public class UnitUtils {
	static public List<Unit> getEquivalentUnits (Unit unit) {
		ArrayList<Unit> unitList = new ArrayList<Unit> ();
		
		if (unit.getDimensions().size() == 0)
			return unitList;
		
		Dimension dim = unit.getDimensions().get(0);
		for (Unit otherUnit : dim.getUnits()) {
			if (unit.isEquivalent(otherUnit)) {
				unitList.add(otherUnit);
			}
		}
		return unitList;
	}
}
