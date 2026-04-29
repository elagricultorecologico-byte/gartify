/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.String
 */
package j3;

import L2.i;
import c3.F;
import h3.l;
import j3.c;
import j3.j;

final class k
extends F {
    public static final k i = new k();

    private k() {
    }

    @Override
    public void J0(i i2, Runnable runnable) {
        c.o.O0(runnable, true, false);
    }

    @Override
    public F L0(int n2, String string) {
        l.a(n2);
        if (n2 >= j.d) {
            return l.b(this, string);
        }
        return super.L0(n2, string);
    }

    @Override
    public String toString() {
        return "Dispatchers.IO";
    }
}

