package org.bitpipeline.lib.units;


public interface MeasurementChangeListener<T extends Number> {
	void measurementChange (Measurement<T> measurement);
}
