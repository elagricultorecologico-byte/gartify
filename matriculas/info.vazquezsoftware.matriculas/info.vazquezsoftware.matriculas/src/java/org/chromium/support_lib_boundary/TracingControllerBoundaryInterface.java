/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.concurrent.Executor
 */
package org.chromium.support_lib_boundary;

import java.io.OutputStream;
import java.util.Collection;
import java.util.concurrent.Executor;

public interface TracingControllerBoundaryInterface {
    public boolean isTracing();

    public void start(int var1, Collection<String> var2, int var3);

    public boolean stop(OutputStream var1, Executor var2);
}

