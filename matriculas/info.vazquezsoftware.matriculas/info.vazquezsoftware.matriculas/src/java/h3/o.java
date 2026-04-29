/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package h3;

import L2.i;
import V2.k;
import c3.I0;

final class O {
    public final i a;
    private final Object[] b;
    private final I0[] c;
    private int d;

    public O(i i2, int n2) {
        this.a = i2;
        this.b = new Object[n2];
        this.c = new I0[n2];
    }

    public final void a(I0 i02, Object i0Array) {
        Object[] objectArray = this.b;
        int n2 = this.d;
        objectArray[n2] = i0Array;
        i0Array = this.c;
        this.d = n2 + 1;
        k.c(i02, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        i0Array[n2] = i02;
    }

    public final void b(i i2) {
        int n2 = this.c.length - 1;
        if (n2 >= 0) {
            while (true) {
                int n3 = n2 - 1;
                I0 i02 = this.c[n2];
                k.b(i02);
                i02.l0(i2, this.b[n2]);
                if (n3 < 0) break;
                n2 = n3;
            }
        }
    }
}

