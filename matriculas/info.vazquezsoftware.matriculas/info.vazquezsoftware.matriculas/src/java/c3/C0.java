/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Thread
 *  java.util.concurrent.locks.LockSupport
 */
package c3;

import c3.a0;
import c3.c;
import java.util.concurrent.locks.LockSupport;

public abstract class c0
extends a0 {
    protected abstract Thread W0();

    protected final void X0() {
        Thread thread = this.W0();
        if (Thread.currentThread() != thread) {
            c.a();
            LockSupport.unpark((Thread)thread);
        }
    }
}

