/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Throwable
 */
package b1;

import T0.d;
import T0.m;

public abstract class y
extends d {
    private final Object g = new Object();
    private d h;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void C() {
        Object object;
        Object object2 = object = this.g;
        synchronized (object2) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        d d3 = this.h;
                        if (d3 == null) break block3;
                        d3.C();
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void d() {
        Object object;
        Object object2 = object = this.g;
        synchronized (object2) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        d d3 = this.h;
                        if (d3 == null) break block3;
                        d3.d();
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void e(m m3) {
        Object object;
        Object object2 = object = this.g;
        synchronized (object2) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        d d3 = this.h;
                        if (d3 == null) break block3;
                        d3.e(m3);
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void f() {
        Object object;
        Object object2 = object = this.g;
        synchronized (object2) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        d d3 = this.h;
                        if (d3 == null) break block3;
                        d3.f();
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void i() {
        Object object;
        Object object2 = object = this.g;
        synchronized (object2) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        d d3 = this.h;
                        if (d3 == null) break block3;
                        d3.i();
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void l() {
        Object object;
        Object object2 = object = this.g;
        synchronized (object2) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        d d3 = this.h;
                        if (d3 == null) break block3;
                        d3.l();
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void o(d d3) {
        Object object;
        Object object2 = object = this.g;
        synchronized (object2) {
            this.h = d3;
            return;
        }
    }
}

