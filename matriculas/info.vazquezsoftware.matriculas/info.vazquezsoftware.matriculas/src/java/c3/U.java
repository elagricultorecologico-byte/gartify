/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 */
package c3;

import H2.k;
import c3.p0;
import c3.s;
import c3.t;

public abstract class u {
    public static final s a(p0 p02) {
        return new t(p02);
    }

    public static /* synthetic */ s b(p0 p02, int n2, Object object) {
        if ((n2 & 1) != 0) {
            p02 = null;
        }
        return u.a(p02);
    }

    public static final boolean c(s s2, Object object) {
        Throwable throwable = k.b(object);
        if (throwable == null) {
            return s2.P(object);
        }
        return s2.L(throwable);
    }
}

