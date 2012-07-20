package org.bitpipeline.lib.units;

import junit.framework.TestCase;

import org.bitpipeline.lib.units.MeterUnit;
import org.bitpipeline.lib.units.NauticalMileUnit;
import org.bitpipeline.lib.units.Unit;

public class LengthUnitsTest extends TestCase {
	public void testLegthUnitConversion () {
		Unit mUnit = MeterUnit.unit();
		Unit nmiUnit = NauticalMileUnit.unit ();
		
		Double mValue = Double.valueOf(2.0d);
		Double nmiValue = Double.valueOf(1.0d);

		// conversion from meter to meter
		assertEquals(2.0d, mUnit.convertFromSIBase(mValue).doubleValue(), Double.MIN_VALUE);
		assertEquals(2.0d, mUnit.convertToSIBase(mValue).doubleValue(), Double.MIN_VALUE);
		
		// conversion from meter to nautical mile
		assertEquals(2.0d / 1852.0d, nmiUnit.convertFromSIBase(mValue).doubleValue(), Double.MIN_VALUE);
		
		// conversion from nautical mile to meter
		assertEquals(1.0d * 1852.0d, nmiUnit.convertToSIBase(nmiValue).doubleValue(), Double.MIN_VALUE);
	}
}
