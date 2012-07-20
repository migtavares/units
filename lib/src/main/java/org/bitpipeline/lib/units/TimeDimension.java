package org.bitpipeline.lib.units;

final public class TimeDimension extends AbstractDimension {
	static private TimeDimension dimension = new TimeDimension ();
	
	private TimeDimension () {
		// empty on purpose
	}
	
	static public Dimension dimension() {
		return (Dimension) TimeDimension.dimension;
	}
}
