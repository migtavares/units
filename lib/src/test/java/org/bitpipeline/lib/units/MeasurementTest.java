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
package org.bitpipeline.lib.units;

import junit.framework.TestCase;

import org.bitpipeline.lib.units.base.mass.Kilogram;
import org.bitpipeline.lib.units.base.mass.Pound;
import org.junit.Test;

public class MeasurementTest extends TestCase {
	@Test
	public void testFloatMeasurementsUnitConversion () {
		MeasurementF weight = new MeasurementF (10f, Kilogram.unit ());

		assertEquals(10f, weight.getValueSIBase(), Float.MIN_NORMAL);

		weight.convertToUnit(Pound.unit ());

		assertEquals (Pound.unit (), weight.getUnit ());
		assertEquals (10f, weight.getValueSIBase(), Float.MIN_NORMAL);
		assertEquals (22.0462f, weight.getValue (), 0.0001f);
	}


	@Test
	public void testDoubleMeasurementsUnitConversion () {
		MeasurementD weight = new MeasurementD (10d, Kilogram.unit ());

		assertEquals(10d, weight.getValueSIBase(), Double.MIN_NORMAL);

		weight.convertToUnit(Pound.unit ());

		assertEquals (Pound.unit (), weight.getUnit ());
		assertEquals (10d, weight.getValueSIBase(), Double.MIN_NORMAL);
		assertEquals (22.0462d, weight.getValue (), 0.0001d);

		weight.setValue (44.0924d);
		assertEquals (20d, weight.getValueAs (Kilogram.unit ()), 0.0001d);

		weight.setValue (10d, Kilogram.unit ());
		assertEquals (22.0462d, weight.getValue (), 0.0001d);
	}

	class MeasurementFListenerSpy implements MeasurementFListener {
		float value = 0f;
		@Override
		public void measurementChange (MeasurementF measurement, MeasurementChangeType type) {
			this.value = measurement.getValue ();
		}

		public float getValue () {
			return this.value;
		}
	}

	@Test
	public void testMeasurementsListeners () {
		MeasurementF weight = new MeasurementF (10f, Kilogram.unit ());
		assertEquals(10f, weight.getValueSIBase(), Float.MIN_NORMAL);

		MeasurementFListenerSpy listenerA = new MeasurementFListenerSpy ();
		weight.addListener (listenerA);
		assertEquals (10f, listenerA.getValue (), Float.MIN_NORMAL);
		
		MeasurementFListenerSpy listenerB = new MeasurementFListenerSpy ();
		weight.addListener (listenerB);
		assertEquals (10f, listenerB.getValue (), Float.MIN_NORMAL);

		weight.removeListener (listenerA);

		weight.convertToUnit(Pound.unit ());

		assertEquals (10f, listenerA.getValue (), Float.MIN_NORMAL);
		assertEquals (22.0462f, weight.getValue (), 0.0001f);

		weight.setValue (44.0924f);
		assertEquals (44.0924f, weight.getValue (), 0.0001f);

		weight.setValue (10f, Kilogram.unit ());
		assertEquals (22.0462f, weight.getValue (), 0.0001f);
	}

}
