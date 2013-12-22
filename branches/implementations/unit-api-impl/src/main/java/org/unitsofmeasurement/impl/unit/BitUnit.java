/**
 *
 */
package org.unitsofmeasurement.impl.unit;

import static org.unitsofmeasurement.impl.unit.QuantityFactory.BYTE_FACTOR;
import static org.unitsofmeasurement.impl.unit.SimpleFormat.*;

import org.unitsofmeasurement.impl.LongNameEnum;
import org.unitsofmeasurement.impl.Multiplier;

import org.unitsofmeasurement.quantity.Information;
import org.unitsofmeasurement.quantity.Quantity;
import org.unitsofmeasurement.unit.Dimension;
import org.unitsofmeasurement.unit.IncommensurableException;
import org.unitsofmeasurement.unit.UnconvertibleException;
import org.unitsofmeasurement.unit.Unit;
import org.unitsofmeasurement.unit.UnitConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * Implements a measure of information. The metric system unit for this quantity is "bit".
 * @author Werner Keil
 * @version 1.5 ($Revision: 18019 $), $Date: 2011-07-23 18:25:49 +0530 (Sat, 23 Jul 2011) $
 */
public enum BitUnit implements Unit<Information>, Multiplier, LongNameEnum<BitUnit> {
    BIT(BIT_NAME, 1.0), // reference Unit
    Byte(BYTE_NAME, BYTE_FACTOR),
	kb(KB_NAME, 1.0e3),
    Mb(MB_NAME, 1.0e6),
    Gb(GB_NAME, 1.0e9),
    Tb(TB_NAME, 1.012),
    Pb(PB_NAME, 1.015),
    Eb(EB_NAME, 1.018),
    KB(KBYTE_NAME, BYTE_FACTOR * 1.0e3),
    MB(MBYTE_NAME, BYTE_FACTOR * 1.0e6),
    GB(GBYTE_NAME, BYTE_FACTOR * 1.0e9),
    TB(TBYTE_NAME, BYTE_FACTOR * 1.0e12),
    PB(PBYTE_NAME, BYTE_FACTOR * 1.0e15),
    EB(EBYTE_NAME, BYTE_FACTOR * 1.0e18);

    private final String description;
    private final double multFactor;

    private BitUnit(String name, double multF) {
        this.description = name;
        this.multFactor = multF;
    }

    @Override
    public String getSymbol() {
        return name();
    }

    @Override
    public String longName() {
        return description;
    }

    @Override
    public double getMultFactor() {
        return multFactor;
    }

    @Override
	public Unit<Information> getSystemUnit() {
		return BIT;
    }

    public static BitUnit getByName(String symbol) {
        if (kb.name().equals(symbol)) {
            return kb;
        } else if (Mb.name().equals(symbol)) {
            return Mb;
        } else if (Gb.name().equals(symbol)) {
            return Gb;
        } else if (Tb.name().equals(symbol)) {
            return Tb;
        }
        return BIT;
    }

    @Override
    public Map<Unit<?>, Integer> getProductUnits() {
        Map<Unit<?>, Integer> prodUnits = new HashMap<Unit<?>, Integer>();
        prodUnits.put(kb, Integer.valueOf(3));
        prodUnits.put(Mb, Integer.valueOf(6));
        prodUnits.put(Gb, Integer.valueOf(9));
        prodUnits.put(Tb, Integer.valueOf(12));
        prodUnits.put(Byte, Integer.valueOf((int)BYTE_FACTOR));
        prodUnits.put(KB, Integer.valueOf(3 * (int)BYTE_FACTOR));
        prodUnits.put(MB, Integer.valueOf(6 * (int)BYTE_FACTOR));
        prodUnits.put(GB, Integer.valueOf(9 * (int)BYTE_FACTOR));
        prodUnits.put(TB, Integer.valueOf(12 * (int)BYTE_FACTOR));
        return prodUnits;
    }

    @Override
    public Unit<Information> add(double offset) {
        return this;
    }

    @Override
    public Unit<?> alternate(String symbol) {
        return this;
    }

    @SuppressWarnings("unchecked")
	@Override
    public <T extends Quantity<T>> Unit<T> asType(Class<T> type)
            throws ClassCastException {
        Unit<T> metricUnit = QuantityFactory.getInstance(type).getMetricUnit();
        if ((metricUnit == null) || metricUnit.isCompatible(this))
         return (Unit<T>) this;
          throw new ClassCastException("The unit: " + this //$NON-NLS-1$
              + " is not of parameterized type " + type); //$NON-NLS-1$
    }

    @Override
    public Unit<Information> divide(double divisor) {
        return this;
    }

    @Override
    public Unit<?> divide(Unit<?> that) {
        return this;
    }

    @Override
    public UnitConverter getConverterTo(Unit<Information> that)
            throws UnconvertibleException {
        // currently unused
        return null;
    }

    @Override
    public UnitConverter getConverterToAny(Unit<?> that)
            throws IncommensurableException, UnconvertibleException {
        // currently unused
        return null;
    }

    @Override
    public Dimension getDimension() {
        return SimpleDimension.INSTANCE;
    }

    @Override
    public Unit<?> inverse() {
        return this;
    }

    @Override
    public boolean isCompatible(Unit<?> that) {
        if (that instanceof BitUnit) return true;
        return false;
    }

    @Override
    public Unit<Information> multiply(double factor) {
        return this;
    }

    @Override
    public Unit<?> multiply(Unit<?> that) {
    	if (!(that instanceof BitUnit)) {
    		throw new UnconvertibleException("Incompatible unit");
    	}
//        return new BitUnit(this.getSymbol(), this.longName(), 
//        		this.getMultFactor() * ((BitUnit)that).getMultFactor());
    	return this;
    }

    @Override
    public Unit<?> pow(int n) {
        return this;
    }

    @Override
    public Unit<?> root(int n) {
        return this;
    }

    @Override
    public Unit<Information> transform(UnitConverter operation) {
        return this;
    }

    @Override
    public LongNameEnum<BitUnit>[] iValues() {
		return BitUnit.values();
	}
}