/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ServiceConnection
 *  android.os.HandlerThread
 *  android.os.Looper
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.Executor
 */
package x1;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.Executor;
import u1.b;
import x1.a0;
import x1.d0;

public abstract class h {
    private static final Object a = new Object();
    private static int b = 9;
    private static d0 c;
    static HandlerThread d;
    private static Executor e;
    private static boolean f;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static h a(Context context) {
        Object object;
        Object object2 = object = a;
        synchronized (object2) {
            Throwable throwable2;
            block5: {
                block4: {
                    d0 d02;
                    Context context2;
                    try {
                        if (c == null) {
                            context2 = context.getApplicationContext();
                            context = f ? h.b().getLooper() : context.getMainLooper();
                        }
                        break block4;
                    }
                    catch (Throwable throwable2) {
                        break block5;
                    }
                    c = d02 = new d0(context2, (Looper)context, e);
                }
                return c;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static HandlerThread b() {
        Object object;
        Object object2 = object = a;
        synchronized (object2) {
            Throwable throwable2;
            block4: {
                HandlerThread handlerThread;
                try {
                    handlerThread = d;
                    if (handlerThread != null) {
                        return handlerThread;
                    }
                }
                catch (Throwable throwable2) {
                    break block4;
                }
                d = handlerThread = new HandlerThread("GoogleApiHandler", b);
                handlerThread.start();
                return d;
            }
            throw throwable2;
        }
    }

    protected abstract b c(a0 var1, ServiceConnection var2, String var3, Executor var4);

    public final void d(String string, String string2, int n2, ServiceConnection serviceConnection, String string3, boolean bl) {
        this.e(new a0(string, string2, 4225, bl), serviceConnection, string3);
    }

    protected abstract void e(a0 var1, ServiceConnection var2, String var3);
}

