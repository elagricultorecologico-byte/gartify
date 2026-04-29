/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.String
 */
package h3;

import L2.i;
import c3.F;
import c3.O;
import c3.S;

public final class v
extends F
implements S {
    private final S i;
    private final F j;
    private final String k;

    public v(F f2, String string) {
        S s2 = f2 instanceof S ? (S)((Object)f2) : null;
        S s3 = s2;
        if (s2 == null) {
            s3 = O.a();
        }
        this.i = s3;
        this.j = f2;
        this.k = string;
    }

    @Override
    public void J0(i i2, Runnable runnable) {
        this.j.J0(i2, runnable);
    }

    @Override
    public boolean K0(i i2) {
        return this.j.K0(i2);
    }

    @Override
    public String toString() {
        return this.k;
    }
}

