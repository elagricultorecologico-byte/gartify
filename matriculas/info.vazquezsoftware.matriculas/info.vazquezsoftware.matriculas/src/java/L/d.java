/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.atomic.AtomicInteger
 */
package l;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import l.e;

public class d
extends e {
    private final Object a = new Object();
    private final ExecutorService b = Executors.newFixedThreadPool((int)4, (ThreadFactory)new ThreadFactory(this){
        private final AtomicInteger a;
        final d b;
        {
            this.b = d2;
            this.a = new AtomicInteger(0);
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            runnable = new StringBuilder();
            runnable.append("arch_disk_io_");
            runnable.append(this.a.getAndIncrement());
            thread.setName(runnable.toString());
            return thread;
        }
    });
    private volatile Handler c;

    private static Handler d(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return l.d$b.a(looper);
        }
        try {
            Handler handler = (Handler)Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
            return handler;
        }
        catch (InvocationTargetException invocationTargetException) {
            return new Handler(looper);
        }
        catch (IllegalAccessException | InstantiationException | NoSuchMethodException throwable) {
            return new Handler(looper);
        }
    }

    @Override
    public void a(Runnable runnable) {
        this.b.execute(runnable);
    }

    @Override
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c(Runnable runnable) {
        block6: {
            if (this.c == null) {
                Object object;
                Object object2 = object = this.a;
                synchronized (object2) {
                    Throwable throwable2;
                    block5: {
                        block4: {
                            try {
                                if (this.c != null) break block4;
                                this.c = d.d(Looper.getMainLooper());
                            }
                            catch (Throwable throwable2) {
                                break block5;
                            }
                        }
                        break block6;
                    }
                    throw throwable2;
                }
            }
        }
        this.c.post(runnable);
    }

    private static abstract class b {
        public static Handler a(Looper looper) {
            return Handler.createAsync((Looper)looper);
        }
    }
}

