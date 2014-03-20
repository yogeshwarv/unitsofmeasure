/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.util;

/**
 * Represents a supplier of minimum value.
 *
 * <p>There is no requirement that a new or distinct result be returned each
 * time the supplier is invoked.
 * 
 * <p>This is a <a href="http://download.java.net/jdk8/docs/api/java/util/function/package-summary.html">functional interface</a>
 * whose functional method is {@link #getMinimum()}.
 * 
 * @author Werner Keil
 * @version 0.2 ($Revision$), $Date$
 * @param <T> the type of values supplied by this supplier
 */
@FunctionalInterface
public interface MinimumSupplier<T> {
	
    /**
     * Gets a minimum value.
     *
     * @return a minimum value
     */
	T getMinimum();
}