package org.bitpipeline.lib.units;

import java.util.List;

public interface Unit {
	Unit getUnit ();

	boolean isEquivalent (Unit unit);
	
	List<Dimension> getDimensions ();
	
	String getSymbol ();
	
	Number convertToSIBase (Number value);
	Number convertFromSIBase (Number value);
}
