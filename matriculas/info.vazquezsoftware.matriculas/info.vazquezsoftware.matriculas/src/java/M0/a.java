/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package m0;

import m0.d;
import m0.e;

public final class a
implements e {
    private final String g;
    private final Object[] h;

    public a(String string) {
        this(string, null);
    }

    public a(String string, Object[] objectArray) {
        this.g = string;
        this.h = objectArray;
    }

    private static void b(d d3, int n2, Object object) {
        if (object == null) {
            d3.H(n2);
            return;
        }
        if (object instanceof byte[]) {
            d3.p0(n2, (byte[])object);
            return;
        }
        if (object instanceof Float) {
            d3.K(n2, ((Float)object).floatValue());
            return;
        }
        if (object instanceof Double) {
            d3.K(n2, (Double)object);
            return;
        }
        if (object instanceof Long) {
            d3.e0(n2, (Long)object);
            return;
        }
        if (object instanceof Integer) {
            d3.e0(n2, ((Integer)object).intValue());
            return;
        }
        if (object instanceof Short) {
            d3.e0(n2, ((Short)object).shortValue());
            return;
        }
        if (object instanceof Byte) {
            d3.e0(n2, ((Byte)object).byteValue());
            return;
        }
        if (object instanceof String) {
            d3.w(n2, (String)object);
            return;
        }
        if (object instanceof Boolean) {
            long l2 = (Boolean)object != false ? 1L : 0L;
            d3.e0(n2, l2);
            return;
        }
        d3 = new StringBuilder();
        d3.append("Cannot bind ");
        d3.append(object);
        d3.append(" at index ");
        d3.append(n2);
        d3.append(" Supported types: null, byte[], float, double, long, int, short, byte, string");
        throw new IllegalArgumentException(d3.toString());
    }

    public static void c(d d3, Object[] objectArray) {
        if (objectArray != null) {
            int n2 = objectArray.length;
            int n3 = 0;
            while (n3 < n2) {
                Object object = objectArray[n3];
                a.b(d3, ++n3, object);
            }
        }
    }

    @Override
    public String a() {
        return this.g;
    }

    @Override
    public void f(d d3) {
        a.c(d3, this.h);
    }
}

