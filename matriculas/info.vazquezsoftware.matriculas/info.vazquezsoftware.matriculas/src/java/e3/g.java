/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 */
package e3;

import U2.l;
import e3.a;
import e3.d;
import e3.f;
import e3.m;

public abstract class g {
    public static final f a(int n2, a a2, l l2) {
        if (n2 != -2) {
            if (n2 != -1) {
                if (n2 != 0) {
                    if (n2 != Integer.MAX_VALUE) {
                        if (a2 == a.g) {
                            return new d(n2, l2);
                        }
                        return new m(n2, a2, l2);
                    }
                    return new d(Integer.MAX_VALUE, l2);
                }
                if (a2 == a.g) {
                    return new d(0, l2);
                }
                return new m(1, a2, l2);
            }
            if (a2 == a.g) {
                return new m(1, a.h, l2);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (a2 == a.g) {
            return new d(f.a.a(), l2);
        }
        return new m(1, a2, l2);
    }

    public static /* synthetic */ f b(int n2, a a2, l l2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n2 = 0;
        }
        if ((n3 & 2) != 0) {
            a2 = a.g;
        }
        if ((n3 & 4) != 0) {
            l2 = null;
        }
        return g.a(n2, a2, l2);
    }
}

