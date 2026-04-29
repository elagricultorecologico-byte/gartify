/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Process
 *  java.lang.Exception
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.Callable
 *  java.util.concurrent.ExecutionException
 *  java.util.concurrent.Executor
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.LinkedBlockingDeque
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.TimeoutException
 */
package C;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

abstract class l {
    static ThreadPoolExecutor a(String object, int n2, int n3) {
        object = new a((String)object, n2);
        object = new ThreadPoolExecutor(0, 1, (long)n3, TimeUnit.MILLISECONDS, (BlockingQueue)new LinkedBlockingDeque(), (ThreadFactory)object);
        object.allowCoreThreadTimeOut(true);
        return object;
    }

    static void b(Executor executor, Callable callable, D.a a2) {
        executor.execute((Runnable)new b(C.b.a(), callable, a2));
    }

    static Object c(ExecutorService object, Callable callable, int n2) {
        object = object.submit(callable);
        long l2 = n2;
        try {
            object = object.get(l2, TimeUnit.MILLISECONDS);
            return object;
        }
        catch (TimeoutException timeoutException) {
            throw new InterruptedException("timeout");
        }
        catch (InterruptedException interruptedException) {
            throw interruptedException;
        }
        catch (ExecutionException executionException) {
            throw new RuntimeException((Throwable)executionException);
        }
    }

    private static class C.l$a
    implements ThreadFactory {
        private String a;
        private int b;

        C.l$a(String string, int n2) {
            this.a = string;
            this.b = n2;
        }

        public Thread newThread(Runnable runnable) {
            return new a(runnable, this.a, this.b);
        }

        private static class a
        extends Thread {
            private final int g;

            a(Runnable runnable, String string, int n2) {
                super(runnable, string);
                this.g = n2;
            }

            public void run() {
                Process.setThreadPriority((int)this.g);
                super.run();
            }
        }
    }

    private static class b
    implements Runnable {
        private Callable g;
        private D.a h;
        private Handler i;

        b(Handler handler, Callable callable, D.a a2) {
            this.g = callable;
            this.h = a2;
            this.i = handler;
        }

        public void run() {
            Object object;
            try {
                object = this.g.call();
            }
            catch (Exception exception) {
                object = null;
            }
            D.a a2 = this.h;
            this.i.post(new Runnable(this, a2, object){
                final D.a g;
                final Object h;
                final b i;
                {
                    this.i = b2;
                    this.g = a2;
                    this.h = object;
                }

                public void run() {
                    this.g.a(this.h);
                }
            });
        }
    }
}

