/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package l3;

import h3.D;
import h3.E;
import l3.k;

public abstract class j {
    private static final int a = E.g("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
    private static final D b = new D("PERMIT");
    private static final D c = new D("TAKEN");
    private static final D d = new D("BROKEN");
    private static final D e = new D("CANCELLED");
    private static final int f = E.g("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);

    public static final /* synthetic */ k a(long l2, k k2) {
        return j.h(l2, k2);
    }

    public static final /* synthetic */ D b() {
        return d;
    }

    public static final /* synthetic */ D c() {
        return e;
    }

    public static final /* synthetic */ int d() {
        return a;
    }

    public static final /* synthetic */ D e() {
        return b;
    }

    public static final /* synthetic */ int f() {
        return f;
    }

    public static final /* synthetic */ D g() {
        return c;
    }

    private static final k h(long l2, k k2) {
        return new k(l2, k2, 0);
    }
}

