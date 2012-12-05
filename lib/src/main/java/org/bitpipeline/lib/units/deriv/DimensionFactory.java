/**
 * Copyright 2012 J. Miguel P. Tavares
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ***************************************************************************/
package org.bitpipeline.lib.units.deriv;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.bitpipeline.lib.units.Dimension;

/** A factory of derived dimensions.
 * @author mtavares */
public class DimensionFactory {
	static final private Map<Dimension, Map<Dimension, QuotientDimension>> DIVIDEND_AND_DIVISOR_TO_QUOTIENT = new HashMap<Dimension, Map<Dimension, QuotientDimension>> ();
	static final private Map<Dimension[], ProductDimension> PRODUCTS = new HashMap<Dimension[], ProductDimension> ();

	/** Create a new dimension that is the quotient of the provided dimensions, with the given name and symbol.
	 * @param name is the name of the quotient dimension created
	 * @param symbol is the symbol of the quotient dimension created
	 * @param dividend is the dividend dimension
	 * @param divisor is the divisor dimension
	 * @return the quotient dimension */
	static public Dimension getOrCreateQuotient (String name, String symbol, NamingProvider siUnitNaming, Dimension dividend, Dimension divisor) {
		QuotientDimension quotient = findExistingQuotient (dividend, divisor);
		if (quotient == null) {
			quotient = new QuotientDimension (name, symbol, siUnitNaming, dividend, divisor);
			DimensionFactory.addQuotient (quotient);
		}
		return quotient;
	}

	/** Create a new dimension that is the quotient of the provided dimensions, with the given name and symbol.
	 * @param name is the name of the quotient dimension created
	 * @param symbol is the symbol of the quotient dimension created
	 * @param dividend is the dividend dimension
	 * @param divisor is the divisor dimension
	 * @return the quotient dimension */
	static public Dimension getOrCreateQuotient (String name, String symbol, Dimension dividend, Dimension divisor) {
		QuotientDimension quotient = findExistingQuotient (dividend, divisor);
		if (quotient == null) {
			quotient = new QuotientDimension (name, symbol, dividend, divisor);
			DimensionFactory.addQuotient (quotient);
		}
		return quotient;
	}

	/** Create a new dimension that is the quotient of the provided dimensions, with the given name and default symbol.
	 * <p>The default name is <i>dividend name per divisor name</i>.</p>
	 * @param name is the name of the quotient dimension created
	 * @param dividend is the dividend dimension
	 * @param divisor is the divisor dimension
	 * @return the quotient dimension */
	static public Dimension getOrCreateQuotient (String name, Dimension dividend, Dimension divisor) {
		return DimensionFactory.getOrCreateQuotient (
				name, QuotientDimension.getDefaultSymbol (dividend, divisor),
				dividend, divisor);
	}

	/** Create a new dimension that is the quotient of the provided dimensions, with the default name and symbol.
	 * <p>The default name is <i>dividend name per divisor name</i>.</p>
	 * <p>The default symbol is <i>dividend symbol/divisor symbol</i>.</p>
	 * <p>See {@link #getOrCreateQuotient(String, String, Dimension, Dimension)}.</p>
	 * @param dividend is the dividend dimension
	 * @param divisor is the divisor dimension
	 * @return the quotient dimension */
	static public Dimension getOrCreateQuotient (Dimension dividend, Dimension divisor) {
		return DimensionFactory.getOrCreateQuotient (
				QuotientDimension.getDefaultName (dividend, divisor),
				QuotientDimension.getDefaultName (dividend, divisor),
				dividend, divisor);
	}

	static private QuotientDimension findExistingQuotient (Dimension dividend, Dimension divisor) {
		Map<Dimension, QuotientDimension> dimensionsWithDividend = DimensionFactory.DIVIDEND_AND_DIVISOR_TO_QUOTIENT.get (dividend);
		if (dimensionsWithDividend == null)
			return null;
		QuotientDimension quotientDimension = dimensionsWithDividend.get (divisor);
		return quotientDimension;
	}

	static private void addQuotient (QuotientDimension quotient) {
		Map<Dimension, QuotientDimension> dimensionsWithDividend = DimensionFactory.DIVIDEND_AND_DIVISOR_TO_QUOTIENT.get (quotient.getDividend ());
		if (dimensionsWithDividend == null) {
			dimensionsWithDividend = new HashMap<Dimension, QuotientDimension> ();
		}
		dimensionsWithDividend.put (quotient.getDivisor (), quotient);
		DimensionFactory.DIVIDEND_AND_DIVISOR_TO_QUOTIENT.put (quotient.getDividend (), dimensionsWithDividend);
	}

	static private void sortDimensionsByName (Dimension ... dimensions) {
		Arrays.sort (dimensions, new Comparator<Dimension> () {
			@Override
			public int compare (Dimension d1, Dimension d2) {
				return d1.getName ().compareTo (d2.getName ());
			}});
	}

	/** Create (or reuse a existing dimension) with the provided dimensions using the provided name and symbol.
	 * @param name is the name for this dimension.
	 * @param symbol is the symbol to be used for this dimension.
	 * @param unitNaming is the {@link NamingProvider} used when creating this dimension SI unit.
	 * @param dimensions are the dimensions factors that compose this new dimension
	 * @return a Dimension that is the result of the product of the passed dimensions. */
	static public Dimension getOrCreateProduct (String name, String symbol, NamingProvider unitNaming, Dimension ... dimensions) {
		ProductDimension product = findExistingProduct (dimensions);
		if (product == null) {
			product = new ProductDimension (name, symbol, unitNaming, dimensions);
			addProduct (product);
		}
		return product;
	}

	/** Create (or reuse a existing dimension) with the provided dimensions using the default symbol and the provided name.
	 * <p>The SI unit created for this dimension will have the default name and symbol.</p>
	 * <p>See {@link #getOrCreateProduct(String, String, NamingProvider, Dimension...)}.</p>
	 * @param name is the name for this dimension.
	 * @param dimensions are the dimensions factors that compose this new dimension
	 * @return a Dimension that is the result of the product of the passed dimensions. */
	static public Dimension getOrCreateProduct (String name, String symbol, Dimension ... dimensions) {
		return DimensionFactory.getOrCreateProduct (
				name, symbol,
				new ProductUnit.ProductUnitDefaultNamingProvider (dimensions), dimensions);
	}

	/** Create (or reuse a existing dimension) with the provided dimensions using the default symbol and the provided name.
	 * <p>See {@link #getOrCreateProduct(String, String, NamingProvider, Dimension...)}.</p>
	 * @param name is the name for this dimension.
	 * @param unitNaming is the {@link NamingProvider} used when creating this dimension SI unit.
	 * @param dimensions are the dimensions factors that compose this new dimension
	 * @return a Dimension that is the result of the product of the passed dimensions. */
	static public Dimension getOrCreateProduct (String name, NamingProvider unitNaming, Dimension ... dimensions) {
		return DimensionFactory.getOrCreateProduct (
				name, ProductDimension.getDefaultSymbol (dimensions),
				unitNaming,
				dimensions);
	}

	/** Create (or reuse a existing dimension) with the provided dimensions using the default name and symbol.
	 * <p>See {@link #getOrCreateProduct(String, String, NamingProvider, Dimension...)}.</p>
	 * @param unitNaming is the {@link NamingProvider} used when creating this dimension SI unit.
	 * @param dimensions are the dimensions factors that compose this new dimension
	 * @return a Dimension that is the result of the product of the passed dimensions. */
	static public Dimension getOrCreateProduct (NamingProvider unitNaming, Dimension ... dimensions) {
		return DimensionFactory.getOrCreateProduct (
				ProductDimension.getDefaultName (dimensions), ProductDimension.getDefaultSymbol (dimensions),
				unitNaming,
				dimensions);
	}

	static private ProductDimension findExistingProduct (Dimension ... dimensions) {
		sortDimensionsByName (dimensions);
		for (Dimension[] products : DimensionFactory.PRODUCTS.keySet ()) {
			if (Arrays.equals (products, dimensions)) {
				return DimensionFactory.PRODUCTS.get (products);
			}
		}
		return null;
	}

	static private void addProduct (ProductDimension product) {
		Dimension[] dimensions = product.getDimensions ();
		sortDimensionsByName (dimensions);
		DimensionFactory.PRODUCTS.put (dimensions, product);
	}

	/* Debug methods */

	static void reset () {
		DimensionFactory.DIVIDEND_AND_DIVISOR_TO_QUOTIENT.clear ();
		DimensionFactory.PRODUCTS.clear ();
	}

	static void printProductDimensions () {
		for (Dimension[] dimensions : DimensionFactory.PRODUCTS.keySet ()) {
			StringBuilder builder = new StringBuilder ();
			builder.append (DimensionFactory.PRODUCTS.get (dimensions).getName ());
			builder.append (": ");
			for (Dimension d : dimensions) {
				builder.append (d.getName ());
				builder.append (", ");
			}
			System.out.println (builder.substring (0, builder.length ()-2));
		}
	}
}
