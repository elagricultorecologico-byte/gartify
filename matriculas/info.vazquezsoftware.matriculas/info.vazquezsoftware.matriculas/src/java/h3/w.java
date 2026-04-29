/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package h3;

import H2.a;
import L2.i;
import U2.l;
import c3.H;
import h3.P;

public abstract class w {
    public static final void a(l object, Object object2, i i2) {
        if ((object = w.b(object, object2, null)) != null) {
            H.a(i2, (Throwable)object);
        }
    }

    public static final P b(l l2, Object object, P p2) {
        try {
            l2.j(object);
            return p2;
        }
        catch (Throwable throwable) {
            if (p2 != null && p2.getCause() != throwable) {
                a.a((Throwable)p2, throwable);
                return p2;
            }
            p2 = new StringBuilder();
            p2.append("Exception in undelivered element handler for ");
            p2.append(object);
            return new P(p2.toString(), throwable);
        }
    }

    public static /* synthetic */ P c(l l2, Object object, P p2, int n2, Object object2) {
        if ((n2 & 2) != 0) {
            p2 = null;
        }
        return w.b(l2, object, p2);
    }
}

