package org.bitpipeline.lib.units;

import java.util.List;

public interface Dimension {
	boolean addUnit (Unit newUnit);
	List<Unit> getUnits ();
}
