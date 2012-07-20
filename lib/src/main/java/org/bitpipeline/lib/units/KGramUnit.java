package org.bitpipeline.lib.units;

final public class KGramUnit extends AbstractUnit {
	static final private KGramUnit UNIT = new KGramUnit ();
	
	private KGramUnit() {
		super("Kg", MassDimension.dimension ());
	}

	static public Unit unit () {
		return KGramUnit.UNIT;
	}
	
	public Unit getUnit() {
		return KGramUnit.unit ();
	}

	@Override
	protected double convertValueToSiBase(final double value) {
		return value;
	}

	@Override
	protected double convertValueFromSiBase(final double value) {
		return value;
	}

}
