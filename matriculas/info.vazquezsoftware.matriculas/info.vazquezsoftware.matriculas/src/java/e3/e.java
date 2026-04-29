/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 */
package e3;

import U2.q;
import Z2.d;
import c3.i;
import e3.j;
import h3.D;
import h3.E;

public abstract class e {
    private static final j a = new j(-1L, null, null, 0);
    public static final int b = E.g("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);
    private static final int c = E.g("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);
    public static final D d = new D("BUFFERED");
    private static final D e = new D("SHOULD_BUFFER");
    private static final D f = new D("S_RESUMING_BY_RCV");
    private static final D g = new D("RESUMING_BY_EB");
    private static final D h = new D("POISONED");
    private static final D i = new D("DONE_RCV");
    private static final D j = new D("INTERRUPTED_SEND");
    private static final D k = new D("INTERRUPTED_RCV");
    private static final D l = new D("CHANNEL_CLOSED");
    private static final D m = new D("SUSPEND");
    private static final D n = new D("SUSPEND_NO_WAITER");
    private static final D o = new D("FAILED");
    private static final D p = new D("NO_RECEIVE_RESULT");
    private static final D q = new D("CLOSE_HANDLER_CLOSED");
    private static final D r = new D("CLOSE_HANDLER_INVOKED");
    private static final D s = new D("NO_CLOSE_CAUSE");

    private static final boolean A(i i2, Object object, q q2) {
        if ((object = i2.k(object, null, q2)) != null) {
            i2.l(object);
            return true;
        }
        return false;
    }

    static /* synthetic */ boolean B(i i2, Object object, q q2, int n2, Object object2) {
        if ((n2 & 2) != 0) {
            q2 = null;
        }
        return e3.e.A(i2, object, q2);
    }

    public static final /* synthetic */ long a(long l2, boolean bl) {
        return e3.e.u(l2, bl);
    }

    public static final /* synthetic */ long b(long l2, int n2) {
        return e3.e.v(l2, n2);
    }

    public static final /* synthetic */ D d() {
        return q;
    }

    public static final /* synthetic */ D e() {
        return r;
    }

    public static final /* synthetic */ D f() {
        return i;
    }

    public static final /* synthetic */ int g() {
        return c;
    }

    public static final /* synthetic */ D h() {
        return o;
    }

    public static final /* synthetic */ D i() {
        return k;
    }

    public static final /* synthetic */ D j() {
        return j;
    }

    public static final /* synthetic */ D k() {
        return e;
    }

    public static final /* synthetic */ D l() {
        return s;
    }

    public static final /* synthetic */ j m() {
        return a;
    }

    public static final /* synthetic */ D n() {
        return h;
    }

    public static final /* synthetic */ D o() {
        return g;
    }

    public static final /* synthetic */ D p() {
        return f;
    }

    public static final /* synthetic */ D q() {
        return m;
    }

    public static final /* synthetic */ D r() {
        return n;
    }

    public static final /* synthetic */ long s(int n2) {
        return e3.e.z(n2);
    }

    public static final /* synthetic */ boolean t(i i2, Object object, q q2) {
        return e3.e.A(i2, object, q2);
    }

    private static final long u(long l2, boolean bl) {
        long l3 = bl ? 0x4000000000000000L : 0L;
        return l3 + l2;
    }

    private static final long v(long l2, int n2) {
        return ((long)n2 << 60) + l2;
    }

    private static final j w(long l2, j j2) {
        return new j(l2, j2, j2.y(), 0);
    }

    public static final d x() {
        return e3.e$a.p;
    }

    public static final D y() {
        return l;
    }

    private static final long z(int n2) {
        if (n2 != 0) {
            if (n2 != Integer.MAX_VALUE) {
                return n2;
            }
            return Long.MAX_VALUE;
        }
        return 0L;
    }
}

