/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runtime
 *  java.lang.Thread
 *  java.util.concurrent.atomic.AtomicReference
 */
package z3;

import V2.k;
import java.util.concurrent.atomic.AtomicReference;
import w1.Z;
import z3.s;

public final class t {
    public static final t a;
    private static final int b;
    private static final s c;
    private static final int d;
    private static final AtomicReference[] e;

    static {
        int n2;
        a = new t();
        b = 65536;
        c = new s(new byte[0], 0, 0, false, false);
        d = n2 = Integer.highestOneBit((int)(Runtime.getRuntime().availableProcessors() * 2 - 1));
        AtomicReference[] atomicReferenceArray = new AtomicReference[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            atomicReferenceArray[i2] = new AtomicReference();
        }
        e = atomicReferenceArray;
    }

    private t() {
    }

    private final AtomicReference a() {
        int n2 = (int)(Thread.currentThread().getId() & (long)d - 1L);
        return e[n2];
    }

    public static final void b(s s2) {
        k.e(s2, "segment");
        int n2 = s2.f == null && s2.g == null ? 1 : 0;
        if (n2 != 0) {
            AtomicReference atomicReference;
            s s3;
            if (!s2.d && (s3 = (s)(atomicReference = a.a()).get()) != c && (n2 = s3 == null ? 0 : s3.c) < b) {
                s2.f = s3;
                s2.b = 0;
                s2.c = n2 + 8192;
                if (!Z.a(atomicReference, s3, s2)) {
                    s2.f = null;
                }
            }
            return;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public static final s c() {
        s s2;
        AtomicReference atomicReference = a.a();
        s s3 = (s)atomicReference.getAndSet((Object)(s2 = c));
        if (s3 == s2) {
            return new s();
        }
        if (s3 == null) {
            atomicReference.set(null);
            return new s();
        }
        atomicReference.set((Object)s3.f);
        s3.f = null;
        s3.c = 0;
        return s3;
    }
}

