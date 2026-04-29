/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package q3;

import V2.g;
import V2.k;
import q3.d;

public abstract class a {
    private final String a;
    private final boolean b;
    private d c;
    private long d;

    public a(String string, boolean bl) {
        k.e(string, "name");
        this.a = string;
        this.b = bl;
        this.d = -1L;
    }

    public /* synthetic */ a(String string, boolean bl, int n2, g g2) {
        if ((n2 & 2) != 0) {
            bl = true;
        }
        this(string, bl);
    }

    public final boolean a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public final long c() {
        return this.d;
    }

    public final d d() {
        return this.c;
    }

    public final void e(d d2) {
        k.e(d2, "queue");
        d d3 = this.c;
        if (d3 == d2) {
            return;
        }
        if (d3 == null) {
            this.c = d2;
            return;
        }
        throw new IllegalStateException("task is in multiple queues");
    }

    public abstract long f();

    public final void g(long l2) {
        this.d = l2;
    }

    public String toString() {
        return this.a;
    }
}

