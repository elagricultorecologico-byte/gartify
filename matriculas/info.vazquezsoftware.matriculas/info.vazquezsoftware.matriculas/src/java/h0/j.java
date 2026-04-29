/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.concurrent.Executor
 *  java.util.concurrent.Executors
 */
package H0;

import H0.m;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

abstract class j {
    static Executor a() {
        return new m((Executor)Executors.newSingleThreadExecutor());
    }
}

