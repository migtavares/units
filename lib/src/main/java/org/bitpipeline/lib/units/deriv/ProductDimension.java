/**
 * Copyright 2012 
 *         J. Miguel P. Tavares <mtavares@bitpipeline.eu>
 *         BitPipeline
 */
package org.bitpipeline.lib.units.deriv;

import java.util.ArrayList;

import org.bitpipeline.lib.units.AbstractDimension;
import org.bitpipeline.lib.units.Dimension;
import org.bitpipeline.lib.units.Unit;


/**
 * 
 * @author mtavares */
class ProductDimension extends AbstractDimension {
	final static String NAME_SEPARATOR = " by ";
	final static String SYMBOL_SEPARATOR = "·";

	static String getDefaultName (Dimension ... dimensions) {
		StringBuilder builder = new StringBuilder ();
		for (Dimension d : dimensions) {
			builder.append (d.getName ());
			builder.append (ProductDimension.NAME_SEPARATOR);
		}
		return builder.substring (0, builder.length () - ProductDimension.NAME_SEPARATOR.length ());
	}

	static String getDefaultSymbol (Dimension ... dimensions) {
		StringBuilder builder = new StringBuilder ();
		for (Dimension d : dimensions) {
			builder.append (d.getName ());
			builder.append (ProductDimension.SYMBOL_SEPARATOR);
		}
		return builder.substring (0, builder.length () - ProductDimension.SYMBOL_SEPARATOR.length ());
	}

	final private Dimension []dimensions;
	final private Unit siUnit;
	final private int cardinality;

	/**
	 * @param divisor
	 * @param dividend */
	ProductDimension (Dimension ... dimensions) {
		this (
				ProductDimension.getDefaultName (dimensions),
				ProductDimension.getDefaultSymbol (dimensions),
				new ProductUnit.ProductUnitDefaultNamingProvider (dimensions),
				dimensions);
	}

	/**
	 * @param divisor
	 * @param dividend */
	ProductDimension (NamingProvider unitNaming, Dimension ... dimensions) {
		this (
				ProductDimension.getDefaultName (dimensions),
				ProductDimension.getDefaultSymbol (dimensions),
				unitNaming,
				dimensions);
	}

	/**
	 * @param divisor
	 * @param divaidend
	 * @param name */
	ProductDimension (final String name, final Dimension ... dimensions) {
		this (
				name,
				ProductDimension.getDefaultSymbol (dimensions),
				new ProductUnit.ProductUnitDefaultNamingProvider (dimensions),
				dimensions);
	}

	/**
	 * @param divisor
	 * @param divaidend
	 * @param name */
	ProductDimension (final String name, NamingProvider unitNaming, final Dimension ... dimensions) {
		this (
				name,
				ProductDimension.getDefaultSymbol (dimensions),
				unitNaming,
				dimensions);
	}

	/**
	 * @param dimName
	 * @param dimSymbol */
	ProductDimension (String name, String symbol, Dimension ... dimensions) {
		this (
				name,
				symbol,
				new ProductUnit.ProductUnitDefaultNamingProvider (dimensions),
				dimensions);
	}

	/**
	 * @param dimName
	 * @param dimSymbol */
	ProductDimension (String dimName, String dimSymbol, NamingProvider unitNaming, Dimension ... dimensions) {
		super (dimName, dimSymbol);
		this.dimensions = dimensions;
		int cardinality = 0;
		ArrayList<Unit> siUnits = new ArrayList<Unit> ();
		for (Dimension d: dimensions) {
			cardinality += d.getCardinality ();
			siUnits.add (d.getSIUnit ());
		}
		Unit[] siUnitsArray = new Unit[siUnits.size ()];
		siUnitsArray = siUnits.toArray (siUnitsArray);
		this.cardinality = cardinality;
		this.siUnit = new ProductUnit (
				unitNaming.getName (),
				unitNaming.getSymbol (),
				this,
				SIUnitConverter.getInstance (), siUnitsArray);
		UnitFactory.addProduct ((ProductUnit) this.siUnit);
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
		return this.cardinality;
	}

	public Dimension[] getDimensions () {
		return this.dimensions;
	}
}
