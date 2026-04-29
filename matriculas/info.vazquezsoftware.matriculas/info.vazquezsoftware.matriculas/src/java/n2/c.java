/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package N2;

import L2.e;
import L2.i;

public final class c
implements e {
    public static final c g = new c();

    private c() {
    }

    @Override
    public void e(Object object) {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override
    public i getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    public String toString() {
        return "This continuation is already complete";
    }
}

