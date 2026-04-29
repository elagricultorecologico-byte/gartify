/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.SynchronousQueue
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 */
package f1;

import f1.b;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class c {
    public static final ThreadPoolExecutor a = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, (BlockingQueue)new SynchronousQueue(), (ThreadFactory)new b("ClientDefault"));
    public static final ExecutorService b = Executors.newSingleThreadExecutor((ThreadFactory)new b("ClientSingle"));
}

