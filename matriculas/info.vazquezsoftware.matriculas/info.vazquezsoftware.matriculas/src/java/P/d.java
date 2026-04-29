/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 *  java.util.ConcurrentModificationException
 */
package p;

import V2.k;
import java.util.ConcurrentModificationException;
import p.b;
import q.a;

public abstract class d {
    public static final void a(b b2, int n2) {
        k.e(b2, "<this>");
        b2.m(new int[n2]);
        b2.l(new Object[n2]);
    }

    public static final int b(b b2, int n2) {
        k.e(b2, "<this>");
        try {
            n2 = a.a(b2.h(), b2.j(), n2);
            return n2;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new ConcurrentModificationException();
        }
    }

    public static final int c(b b2, Object object, int n2) {
        int n3;
        k.e(b2, "<this>");
        int n4 = b2.j();
        if (n4 == 0) {
            return -1;
        }
        int n5 = d.b(b2, n2);
        if (n5 < 0 || k.a(object, b2.f()[n5])) {
            return n5;
        }
        for (n3 = n5 + 1; n3 < n4 && b2.h()[n3] == n2; ++n3) {
            if (!k.a(object, b2.f()[n3])) continue;
            return n3;
        }
        for (n4 = n5 - 1; n4 >= 0 && b2.h()[n4] == n2; --n4) {
            if (!k.a(object, b2.f()[n4])) continue;
            return n4;
        }
        return ~n3;
    }

    public static final int d(b b2) {
        k.e(b2, "<this>");
        return d.c(b2, null, 0);
    }
}

