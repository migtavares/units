package org.bitpipeline.lib.units;

import junit.framework.TestCase;

import org.bitpipeline.lib.units.HourUnit;
import org.bitpipeline.lib.units.SecondUnit;
import org.bitpipeline.lib.units.Unit;

public class TimeUnitsTest extends TestCase {
	public void testTimeUnitsConvertion () {
		Unit sUnit = SecondUnit.unit();
		Unit hUnit = HourUnit.unit ();
		
		double sValue = 1800.0d;
		double hValue = 2.0d;

		// convert from seconds to seconds
		assertEquals(sValue, sUnit.convertFromSIBase(Double.valueOf(sValue)).doubleValue(), Double.MIN_VALUE);
		assertEquals(sValue, sUnit.convertToSIBase(Double.valueOf(sValue)).doubleValue(), Double.MIN_VALUE);
		// Convert from seconds to hours
		assertEquals(0.5d, hUnit.convertFromSIBase(Double.valueOf(sValue)).doubleValue(), Double.MIN_VALUE);

		// convert from hours to seconds
		assertEquals(7200.0d, hUnit.convertToSIBase(Double.valueOf(hValue)).doubleValue(), Double.MIN_VALUE);

	}
}
