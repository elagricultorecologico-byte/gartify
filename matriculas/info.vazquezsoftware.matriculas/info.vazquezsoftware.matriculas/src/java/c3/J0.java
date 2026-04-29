/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.concurrent.Executor
 *  java.util.concurrent.ExecutorService
 */
package c3;

import c3.h0;
import c3.i0;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public abstract class j0 {
    public static final h0 a(ExecutorService executorService) {
        return new i0((Executor)executorService);
    }
}

