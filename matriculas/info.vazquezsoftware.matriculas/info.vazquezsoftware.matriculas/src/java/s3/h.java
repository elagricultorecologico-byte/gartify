/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package s3;

import V2.k;
import m3.B;
import m3.v;
import z3.d;

public final class h
extends B {
    private final String h;
    private final long i;
    private final d j;

    public h(String string, long l2, d d2) {
        k.e(d2, "source");
        this.h = string;
        this.i = l2;
        this.j = d2;
    }

    @Override
    public long i() {
        return this.i;
    }

    @Override
    public v j() {
        String string = this.h;
        if (string == null) {
            return null;
        }
        return v.e.b(string);
    }

    @Override
    public d p() {
        return this.j;
    }
}

