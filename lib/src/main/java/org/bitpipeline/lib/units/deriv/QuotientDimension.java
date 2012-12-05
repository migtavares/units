/**
 * Copyright 2012 
 *         J. Miguel P. Tavares <mtavares@bitpipeline.eu>
 *         BitPipeline
 */
package org.bitpipeline.lib.units.deriv;

import org.bitpipeline.lib.units.AbstractDimension;
import org.bitpipeline.lib.units.Dimension;
import org.bitpipeline.lib.units.Unit;


/**
 * 
 * @author mtavares */
class QuotientDimension extends AbstractDimension {
	final static String NAME_PATTERN = "%s per %s";
	final static String SYMBOL_PATTERN = "%s/%s";

	static String getDefaultName (Dimension dividend, Dimension divisor) {
		return String.format (QuotientDimension.NAME_PATTERN, dividend.getName (), divisor.getName ());
	}

	static String getDefaultSymbol (Dimension dividend, Dimension divisor) {
		return String.format (QuotientDimension.SYMBOL_PATTERN, dividend.getSymbol (), divisor.getSymbol ());
	}

	final private Dimension dividend;
	final private Dimension divisor;
	final private Unit siUnit;

	/**
	 * @param divisor
	 * @param dividend */
	QuotientDimension (Dimension dividend, Dimension divisor) {
		this (
				QuotientDimension.getDefaultName (dividend, divisor),
				QuotientDimension.getDefaultSymbol (dividend, divisor),
				dividend, divisor);
	}

	/**
	 * @param divisor
	 * @param divaidend
	 * @param name */
	QuotientDimension (String name, Dimension dividend, Dimension divisor) {
		this (
				name,
				QuotientDimension.getDefaultSymbol (dividend, divisor),
				dividend, divisor);
	}

	/**
	 * @param divisor
	 * @param divaidend
	 * @param name
	 * @param symbol */
	QuotientDimension (String name, String symbol, Dimension dividend, Dimension divisor) {
		super (name, symbol);
		this.divisor = divisor;
		this.dividend = dividend;
		this.siUnit = new QuotientUnit (this, SIUnitConverter.getInstance (), dividend.getSIUnit (), divisor.getSIUnit ());
		UnitFactory.addQuotient ((QuotientUnit) this.siUnit);
	}

	/**
	 * @param divisor
	 * @param divaidend
	 * @param name
	 * @param symbol */
	QuotientDimension (String name, String symbol, NamingProvider siUnitNaming, Dimension dividend, Dimension divisor) {
		super (name, symbol);
		this.divisor = divisor;
		this.dividend = dividend;
		this.siUnit = new QuotientUnit (
				siUnitNaming.getName (), siUnitNaming.getSymbol (),
				this, SIUnitConverter.getInstance (),
				dividend.getSIUnit (), divisor.getSIUnit ());
		UnitFactory.addQuotient ((QuotientUnit) this.siUnit);
	}

	/* (non-Javadoc)
	 * @see org.bitpipeline.lib.units.Dimension#getSIUnit() */
	@Override
	public Unit getSIUnit () {
		return this.siUnit;
	}

	/* (non-Javadoc)
	 * @see org.bitpipeline.lib.units.Dimension#getCardinality() */
	@Override
	public int getCardinality () {
		// TODO investigate what is the cardinality of a quocient dimension
		return this.dividend.getCardinality ();
	}

	Dimension getDividend () {
		return this.dividend;
	}
	
	Dimension getDivisor () {
		return this.divisor;
	}
}
