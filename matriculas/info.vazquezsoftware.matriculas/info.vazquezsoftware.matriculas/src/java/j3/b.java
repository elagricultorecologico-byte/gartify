/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.concurrent.Executor
 */
package j3;

import L2.i;
import L2.j;
import Y2.d;
import c3.F;
import c3.h0;
import h3.E;
import j3.k;
import java.util.concurrent.Executor;

public final class b
extends h0
implements Executor {
    public static final b j = new b();
    private static final F k = F.M0(j3.k.i, E.g("kotlinx.coroutines.io.parallelism", d.b(64, E.a()), 0, 0, 12, null), null, 2, null);

    private b() {
    }

    @Override
    public void J0(i i2, Runnable runnable) {
        k.J0(i2, runnable);
    }

    @Override
    public F L0(int n2, String string) {
        return j3.k.i.L0(n2, string);
    }

    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    public void execute(Runnable runnable) {
        this.J0(L2.j.g, runnable);
    }

    @Override
    public String toString() {
        return "Dispatchers.IO";
    }
}

