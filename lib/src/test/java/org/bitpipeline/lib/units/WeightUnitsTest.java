package org.bitpipeline.lib.units;

import junit.framework.TestCase;

import org.bitpipeline.lib.units.KGramUnit;
import org.bitpipeline.lib.units.Measurement;
import org.bitpipeline.lib.units.PoundUnit;

public class WeightUnitsTest extends TestCase {

	public WeightUnitsTest() {
		KGramUnit.unit ();
		PoundUnit.unit ();
	}
	
	public void testWeightUnits () {
		double value = 10.0d;
		Measurement<Double> weight = new Measurement<Double>(Double.valueOf (value), KGramUnit.unit ());
		
		Double measValue = weight.getValueSIBase();
		assertEquals(value, measValue.doubleValue(), Double.MIN_VALUE);

		weight.convertToUnit(PoundUnit.unit ());
		measValue = weight.getValueSIBase();
		assertEquals(value, measValue.doubleValue(), Double.MIN_VALUE);
	}

}
