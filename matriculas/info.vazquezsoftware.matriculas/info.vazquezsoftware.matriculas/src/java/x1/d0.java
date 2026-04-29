/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ServiceConnection
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.concurrent.Executor
 */
package x1;

import A1.a;
import H1.p;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
import java.util.concurrent.Executor;
import u1.b;
import x1.a0;
import x1.b0;
import x1.c0;
import x1.h;
import x1.n;

final class d0
extends h {
    private final HashMap g = new HashMap();
    private final Context h;
    private volatile Handler i;
    private final c0 j;
    private final a k;
    private final long l;
    private final long m;
    private volatile Executor n;

    d0(Context context, Looper looper, Executor executor) {
        c0 c02;
        this.j = c02 = new c0(this, null);
        this.h = context.getApplicationContext();
        this.i = new p(looper, c02);
        this.k = a.b();
        this.l = 5000L;
        this.m = 300000L;
        this.n = executor;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected final b c(a0 object, ServiceConnection object2, String object3, Executor object4) {
        HashMap hashMap;
        x1.n.j(object2, "ServiceConnection must not be null");
        HashMap hashMap2 = hashMap = this.g;
        synchronized (hashMap2) {
            Throwable throwable2;
            block6: {
                block8: {
                    b0 b02;
                    block10: {
                        block9: {
                            Executor executor;
                            block7: {
                                block5: {
                                    try {
                                        b02 = (b0)hashMap.get(object);
                                        executor = object4;
                                        if (object4 != null) break block5;
                                        executor = this.n;
                                    }
                                    catch (Throwable throwable2) {
                                        break block6;
                                    }
                                }
                                if (b02 != null) break block7;
                                object4 = new b0(this, (a0)object);
                                ((b0)object4).b((ServiceConnection)object2, (ServiceConnection)object2, (String)object3);
                                object3 = ((b0)object4).j((String)object3, executor);
                                hashMap.put(object, object4);
                                object2 = object4;
                                object = object3;
                                break block8;
                            }
                            this.i.removeMessages(0, object);
                            if (b02.f((ServiceConnection)object2)) {
                                object = object.toString();
                                int n2 = object.length();
                                object3 = new StringBuilder(n2 + 81);
                                object3.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                                object3.append((String)object);
                                object2 = new IllegalStateException(object3.toString());
                                throw object2;
                            }
                            b02.b((ServiceConnection)object2, (ServiceConnection)object2, (String)object3);
                            int n3 = b02.e();
                            if (n3 == 1) break block9;
                            if (n3 != 2) break block10;
                            object = b02.j((String)object3, executor);
                            object2 = b02;
                            break block8;
                        }
                        object2.onServiceConnected(b02.i(), b02.h());
                    }
                    object = null;
                    object2 = b02;
                }
                if (((b0)object2).d()) {
                    return b.l;
                }
                object2 = object;
                if (object != null) return object2;
                return new b(-1);
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
    protected final void e(a0 object, ServiceConnection object2, String string) {
        HashMap hashMap;
        x1.n.j(object2, "ServiceConnection must not be null");
        HashMap hashMap2 = hashMap = this.g;
        synchronized (hashMap2) {
            Throwable throwable2;
            block6: {
                block5: {
                    try {
                        b0 b02 = (b0)hashMap.get(object);
                        if (b02 == null) {
                            string = object.toString();
                            int n2 = string.length();
                            object = new StringBuilder(n2 + 50);
                            object.append("Nonexistent connection status for service config: ");
                            object.append(string);
                            object2 = new IllegalStateException(object.toString());
                            throw object2;
                        }
                        if (!b02.f((ServiceConnection)object2)) {
                            object = object.toString();
                            int n3 = object.length();
                            string = new StringBuilder(n3 + 76);
                            string.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                            string.append((String)object);
                            object2 = new IllegalStateException(string.toString());
                            throw object2;
                        }
                        b02.c((ServiceConnection)object2, string);
                        if (!b02.g()) break block5;
                        object = this.i.obtainMessage(0, object);
                        this.i.sendMessageDelayed((Message)object, this.l);
                    }
                    catch (Throwable throwable2) {
                        break block6;
                    }
                }
                return;
            }
            throw throwable2;
        }
    }

    final /* synthetic */ HashMap f() {
        return this.g;
    }

    final /* synthetic */ Context g() {
        return this.h;
    }

    final /* synthetic */ Handler h() {
        return this.i;
    }

    final /* synthetic */ a i() {
        return this.k;
    }

    final /* synthetic */ long j() {
        return this.m;
    }
}

