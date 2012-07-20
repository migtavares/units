package org.bitpipeline.lib.units;

final public class LengthDimension extends AbstractDimension {
	static private LengthDimension dimension = new LengthDimension ();
	
	private LengthDimension() {
		// empty on purpose
	}

	static public Dimension dimension() {
		return (Dimension) LengthDimension.dimension;
	}
}
