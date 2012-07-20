package org.bitpipeline.lib.units;

import junit.framework.TestCase;

import org.bitpipeline.lib.units.KnotsUnit;
import org.bitpipeline.lib.units.MpSUnit;
import org.bitpipeline.lib.units.Unit;

public class VelocityUnitsTest extends TestCase {
	public void testVelocityUnitConvertion () {
		Unit mpsUnit = MpSUnit.unit ();
		Unit knotsUnit = KnotsUnit.unit ();
		
		double value = 5.0d;
		
		// Test the SI base unit
		assertEquals(value, mpsUnit.convertFromSIBase(Double.valueOf(value)).doubleValue(), Double.MIN_VALUE);
		assertEquals(value, mpsUnit.convertToSIBase(Double.valueOf(value)).doubleValue(), Double.MIN_VALUE);
		
		// test the knots conversion
		assertEquals(value,
				knotsUnit.convertToSIBase(
						knotsUnit.convertFromSIBase(Double.valueOf(value))).doubleValue(), Double.MIN_VALUE);
		assertEquals(value*0.51444444, knotsUnit.convertToSIBase(Double.valueOf(value)).doubleValue(), 0.0000001);
		
	}
}
