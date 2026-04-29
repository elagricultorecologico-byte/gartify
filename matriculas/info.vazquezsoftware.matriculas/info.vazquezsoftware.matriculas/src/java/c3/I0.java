/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  c3.s0
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.util.concurrent.CancellationException
 *  java.util.concurrent.Executor
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.RejectedExecutionException
 *  java.util.concurrent.ScheduledThreadPoolExecutor
 */
package c3;

import L2.i;
import c3.S;
import c3.W;
import c3.c;
import c3.f0;
import c3.h0;
import c3.s0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public final class i0
extends h0
implements S {
    private final Executor j;

    public i0(Executor executor) {
        this.j = executor;
        if (this.O0() instanceof ScheduledThreadPoolExecutor) {
            ((ScheduledThreadPoolExecutor)this.O0()).setRemoveOnCancelPolicy(true);
        }
    }

    private final void N0(i i3, RejectedExecutionException rejectedExecutionException) {
        s0.c((i)i3, (CancellationException)f0.a("The task was rejected", rejectedExecutionException));
    }

    @Override
    public void J0(i i3, Runnable runnable) {
        try {
            Executor executor = this.O0();
            c.a();
            executor.execute(runnable);
            return;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            c.a();
            this.N0(i3, rejectedExecutionException);
            W.b().J0(i3, runnable);
            return;
        }
    }

    public Executor O0() {
        return this.j;
    }

    public void close() {
        Object object = this.O0();
        object = object instanceof ExecutorService ? (ExecutorService)object : null;
        if (object != null) {
            object.shutdown();
        }
    }

    public boolean equals(Object object) {
        return object instanceof i0 && ((i0)object).O0() == this.O0();
    }

    public int hashCode() {
        return System.identityHashCode((Object)this.O0());
    }

    @Override
    public String toString() {
        return this.O0().toString();
    }
}

