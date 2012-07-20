package org.bitpipeline.lib.units;

final public class MassDimension extends AbstractDimension {
	static private MassDimension dim = new MassDimension();
	
	private MassDimension() {
		// Empty on purpose
	}
	
	static public Dimension dimension() {
		return (Dimension) dim;
	}

}
