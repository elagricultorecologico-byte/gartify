/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 */
package j3;

import c3.F;
import h3.l;
import j3.f;
import j3.j;

public final class c
extends f {
    public static final c o = new c();

    private c() {
        super(j.c, j.d, j.e, j.a);
    }

    @Override
    public F L0(int n2, String string) {
        l.a(n2);
        if (n2 >= j.c) {
            return l.b(this, string);
        }
        return super.L0(n2, string);
    }

    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override
    public String toString() {
        return "Dispatchers.Default";
    }
}

