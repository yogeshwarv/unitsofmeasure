/**
 * Copyright (c) 2013-2014 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.function;

import javax.measure.Measurement;
import javax.measure.Quantity;
import javax.measure.Unit;

/**
 *  A converter of measurements.
 * 
 * <p>
 * There is no requirement that a new or distinct result be returned each time
 * the supplier is invoked.
 * 
 * <p>
 * This is a <a href=
 * "http://download.java.net/jdk8/docs/api/java/util/function/package-summary.html"
 * >functional interface</a> whose functional method is {@link #getValue()}.
 * 
 * @author Werner Keil
 * @version 0.1 ($Revision: 283 $), $Date$
 * @param <Q>
 *            The type of the quantity measured.
 * @param <V>
 *            The value of the quantity measured.
 *            
 * @see <a href="http://en.wikipedia.org/wiki/Conversion_of_units"> Wikipedia:
 *      Conversion of units</a>
 * @see Measurement
 * @see Unit
 * @see Quantity
 */
// equivalent to @FunctionalInterface
public interface MeasurementConverter<Q extends Quantity<Q>, V> {

	/**
	 * Returns a measurement converted into another unit.
	 * 
	 * @param unit
	 * @return the converted result.
	 */
	Measurement<Q, V> to(Unit<Q> unit);
}