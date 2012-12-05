/**
 * Copyright 2012 
 *         J. Miguel P. Tavares <mtavares@bitpipeline.eu>
 *         BitPipeline
 */
package org.bitpipeline.lib.units.deriv;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.bitpipeline.lib.units.Dimension;
import org.bitpipeline.lib.units.Unit;

/** Factory used to create new derived units.
 * @author mtavares */
public class UnitFactory {
	static final private Map<Unit, Map<Unit, QuotientUnit>> DIVIDEND_AND_DIVISOR_TO_QUOTIENT = new HashMap<Unit, Map<Unit, QuotientUnit>> ();
	static final private Map<Unit[], ProductUnit> PRODUCTS = new HashMap<Unit[], ProductUnit> ();
	static final private Map<Unit, Map<Prefix, PrefixedUnit>> PREFIXED = new HashMap<Unit, Map<Prefix, PrefixedUnit>> (); 

	/** Constructs or retrieves an existing quotient unit.
	 * <p>When a new quotient unit is created the corresponding
	 * dimension and SI unit will be created too.</p>
	 * <p>The dimension is created (if it doesn't exist yet) by using
	 * the provided units dimensions, triggering the creation of the
	 * corresponding SI unit.</p>
	 * <p>If the default values used to create either the dimension or the
	 * SI unit don't reflect the conventions in use then instead of relying
	 * on automatic creating one should create the dimension and SI unit in
	 * separate steps.</p>
	 * @param dividend is the unit that defines the dividend of the quotient
	 * @param divisor is the unit that defined the divisor of the quotient
	 * @param converter is the converter that will be used to transform values
	 * 	of the the new unit into and from the SI unit for the corresponding dimension.
	 * @param name is the name to be used by this unit.
	 * @param symbol is the symbol to be used by this unit. */
	static public Unit getOrCreateQuotient (String name, String symbol, Unit dividend, Unit divisor, UnitConverter converter) {
		QuotientUnit quotientUnit = UnitFactory.findExistingQuotient (dividend, divisor);
		if (quotientUnit == null) {
			Dimension dim = DimensionFactory.getOrCreateQuotient (
					dividend.getDimension (), divisor.getDimension ());
			quotientUnit = UnitFactory.findExistingQuotient (dividend, divisor);
			if (quotientUnit == null) {
				quotientUnit = new QuotientUnit (name, symbol, dim, converter, dividend, divisor);
			}
			UnitFactory.addQuotient (quotientUnit);
		}
		return quotientUnit;
	}

	/** Constructs or retrieves an existing quotient SI unit.
	 * <p>When a new quotient unit is created the corresponding
	 * dimension and SI unit will be created too.</p>
	 * <p>The dimension is created (if it doesn't exist yet) by using
	 * the provided units dimensions, triggering the creation of the
	 * corresponding SI unit.</p>
	 * <p>If the default values used to create either the dimension or the
	 * SI unit don't reflect the conventions in use then instead of relying
	 * on automatic creating one should create the dimension before.</p>
	 * @param dividend is the dimension that defines the dividend of the quotient
	 * @param divisor is the dimension that defined the divisor of the quotient
	 * @param name is the name to be used by this unit.
	 * @param symbol is the symbol to be used. */
	static public Unit getOrCreateSIQuotient (String name, String symbol, Dimension dividend, Dimension divisor) {
		return UnitFactory.getOrCreateQuotient (
				name, symbol,
				dividend.getSIUnit (), divisor.getSIUnit (), SIUnitConverter.getInstance ());
	}

	/** Constructs or retrieves an existing quotient unit using the default name and symbol.
	 * <p>The default name is "<i>dividend name</i> per <i>divisor name</i>".</p>
	 * <p>The default symbol name is "<i>dividend symbol</i>/<i>divisor symbol</i>".</p>
	 * <p>See {@link UnitFactory#getOrCreateQuotient(String, String, Unit, Unit, UnitConverter)}
	 * for information on how the unit dimension and SI unit of that dimension are extrapolated.</p>
	 * @param dividend is the unit that defines the dividend of the quotient
	 * @param divisor is the unit that defined the divisor of the quotient
	 * @param converter is the converter that will be used to transform values
	 * 	of the the new unit into and from the SI unit for the corresponding dimension. */
	static public Unit getOrCreateQuotient (Unit dividend, Unit divisor, UnitConverter converter) {
		return UnitFactory.getOrCreateQuotient (
				QuotientUnit.getDefaultName (dividend, divisor),
				QuotientUnit.getDefaultSymbol (dividend, divisor),
				dividend, divisor, converter);
	}

	/** Constructs or retrieves an existing SI quotient unit using the default name and symbol.
	 * <p>The default name is "<i>dividend SI unit name</i> per <i>divisor SI unit name</i>".</p>
	 * <p>The default symbol name is "<i>dividend SI unit symbol</i>/<i>divisor SI unit symbol</i>".</p>
	 * <p>See {@link UnitFactory#getOrCreateQuotient(String, String, Unit, Unit, UnitConverter)}
	 * for information on how the unit dimension and SI unit of that dimension are extrapolated.</p>
	 * @param dividend is the unit that defines the dividend of the quotient
	 * @param divisor is the unit that defined the divisor of the quotient */
	static public Unit getOrCreateSIQuotient (Dimension dividend, Dimension divisor) {
		Unit dividendUnit = dividend.getSIUnit ();
		Unit divisorUnit = divisor.getSIUnit ();
		return UnitFactory.getOrCreateSIQuotient (
				QuotientUnit.getDefaultName (dividendUnit, divisorUnit),
				QuotientUnit.getDefaultSymbol (dividendUnit, divisorUnit),
				dividend, divisor);
	}

	static private QuotientUnit findExistingQuotient (Unit dividend, Unit divisor) {
		Map<Unit, QuotientUnit> unitsWithDividend = UnitFactory.DIVIDEND_AND_DIVISOR_TO_QUOTIENT.get (dividend);
		if (unitsWithDividend == null)
			return null;
		QuotientUnit quocientUnit = unitsWithDividend.get (divisor);
		return quocientUnit;
	}

	static void addQuotient (QuotientUnit quotient) {
		Map<Unit, QuotientUnit> unitsWithDividend = UnitFactory.DIVIDEND_AND_DIVISOR_TO_QUOTIENT.get (quotient.getDividend ());
		if (unitsWithDividend == null) {
			unitsWithDividend = new HashMap<Unit, QuotientUnit> ();
		}
		unitsWithDividend.put (quotient.getDivisor (), quotient);
		UnitFactory.DIVIDEND_AND_DIVISOR_TO_QUOTIENT.put (quotient.getDividend (), unitsWithDividend);
	}

	/** Constructs or retrieves an existing product unit.
	 * <p>When a new product unit is created the corresponding
	 * dimension and SI unit will be created too (if they don't already exist).</p>
	 * <p>The dimension is created (if it doesn't exist yet) by using
	 * the provided units dimensions, triggering the creation of the
	 * corresponding SI unit. See
	 * {@link DimensionFactory#getOrCreateProduct(String, String, NamingProvider, Dimension...)}
	 * for details on how the SI unit is created.</p>
	 * <p>If the default values used to create either the dimension or the
	 * SI unit don't reflect the conventions in use then instead of relying
	 * on automatic creating one should create the dimension before.</p>
	 * @param name is the name to be used by this unit.
	 * @param symbol is the symbol to be used.
	 * @param converter is the {@link UnitConverter} used to convert values from this unit to the corresponding SI unit.
	 * @param units are the factor units that compose the product of this unit. */
	static public Unit getOrCreateProduct (String name, String symbol, UnitConverter converter, Unit ... units) {
		ProductUnit productUnit = findExistingProduct (units);
		if (productUnit == null) {
			Dimension[] subDimensions = new Dimension[units.length];
			for (int i = 0; i < units.length; i++) {
				subDimensions[i] = units[i].getDimension ();
			}
			Dimension dim = DimensionFactory.getOrCreateProduct (
					new ProductUnit.ProductUnitDefaultNamingProvider (subDimensions),
					subDimensions);
			productUnit = new ProductUnit (dim, converter, units);
		} 
		return productUnit;
	}

	/** Constructs or retrieves an existing SI product unit.
	 * <p>The dimension is created (if it doesn't exist yet) by using
	 * the provided units dimensions, triggering the creation of the
	 * corresponding SI unit. See
	 * {@link DimensionFactory#getOrCreateProduct(String, String, NamingProvider, Dimension...)}
	 * for details on how the SI unit is created.</p>
	 * <p>If the default values used to create either the dimension or the
	 * SI unit don't reflect the conventions in use then instead of relying
	 * on automatic creating one should create the dimension before.</p>
	 * @param name is the name to be used by this unit.
	 * @param symbol is the symbol to be used.
	 * @param units are the factor units that compose the product of this unit. */
	static public Unit getOrCreateSIProduct (String name, String symbol, Unit ... units) {
		return UnitFactory.getOrCreateProduct (name, symbol, SIUnitConverter.getInstance (), units);
	}

	static private void sortUnitsByName (Unit ... units) {
		Arrays.sort (units, new Comparator<Unit> () {
			@Override
			public int compare (Unit u1, Unit u2) {
				return u1.getName ().compareTo (u2.getName ());
			}
		});
	}

	static private ProductUnit findExistingProduct (Unit ... units) {
		sortUnitsByName (units);
		for (Unit[] products : UnitFactory.PRODUCTS.keySet ()) {
			if (Arrays.equals (products, units))
				return UnitFactory.PRODUCTS.get (products);
		}
		return null;
	}

	static void addProduct (ProductUnit product) {
		Unit[] componentunits = product.getComponentunits ();
		sortUnitsByName (componentunits);
		UnitFactory.PRODUCTS.put (componentunits, product);
	}

	/** Creates or retrieves an existing prefixed unit using the provided prefix and unit.
	 * @param prefix is the prefix to use 
	 * @param baseUnit is the base unit to use*/
	static public Unit getOrCreatePrefixedUnit (Prefix prefix, Unit baseUnit) {
		return UnitFactory.getOrCreatePrefixedUnit (prefix, baseUnit,
				PrefixedUnit.defaultName (prefix, baseUnit),
				PrefixedUnit.defaultSymbol (prefix, baseUnit));
	}

	/** Creates or retrieves an existing a prefixed unit using the provided prefix and base unit using the provided name and symbol for the unit.
	 * @param prefix is the prefix to use 
	 * @param baseUnit is the base unit to use
	 * @param name the name to use with this prefixed unit
	 * @param symbol the symbol to use for this prefixed unit */
	static public Unit getOrCreatePrefixedUnit (Prefix prefix, Unit baseUnit, String name, String symbol) {
		PrefixedUnit prefixedUnit = (PrefixedUnit) UnitFactory.findExistingPrefixed (prefix, baseUnit);
		if (prefixedUnit == null) {
			prefixedUnit = new PrefixedUnit (prefix, baseUnit, name, symbol);
			UnitFactory.addPrefixed (prefixedUnit);
		}
		return prefixedUnit;
	}

	static private Unit findExistingPrefixed (Prefix prefix, Unit baseUnit) {
		if (UnitFactory.PREFIXED.containsKey (baseUnit)) {
			Map<Prefix, PrefixedUnit> prefixes = UnitFactory.PREFIXED.get (baseUnit);
			return prefixes.get (prefix);
		}
		return null;
	}

	static private void addPrefixed (PrefixedUnit unit) {
		Map<Prefix, PrefixedUnit> basicUnitPrefixes;

		if (UnitFactory.PREFIXED.containsKey (unit.getBaseUnit ())) {
			basicUnitPrefixes = UnitFactory.PREFIXED.get (unit.getBaseUnit ());
		} else {
			basicUnitPrefixes = new HashMap<Prefix, PrefixedUnit> ();
			UnitFactory.PREFIXED.put (unit.getBaseUnit (), basicUnitPrefixes);
		}
		basicUnitPrefixes.put (unit.getPrefix (), unit);
	}

	static void reset () {
		UnitFactory.DIVIDEND_AND_DIVISOR_TO_QUOTIENT.clear ();
		UnitFactory.PRODUCTS.clear ();
		UnitFactory.PREFIXED.clear ();
	}
}
