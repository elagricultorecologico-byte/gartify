/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 */
package c3;

import c3.F;
import c3.W;
import h3.l;

public abstract class z0
extends F {
    @Override
    public F L0(int n2, String string) {
        l.a(n2);
        return l.b(this, string);
    }

    public abstract z0 N0();

    protected final String O0() {
        z0 z02 = W.c();
        if (this == z02) {
            return "Dispatchers.Main";
        }
        try {
            z02 = z02.N0();
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            z02 = null;
        }
        if (this == z02) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}

