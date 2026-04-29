/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.os.Handler$Callback
 *  android.os.Message
 *  android.util.Log
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Objects
 */
package x1;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;
import java.util.Objects;
import x1.a0;
import x1.b0;
import x1.d0;
import x1.n;

final class c0
implements Handler.Callback {
    final d0 g;

    /* synthetic */ c0(d0 d02, byte[] byArray) {
        Objects.requireNonNull((Object)d02);
        this.g = d02;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean handleMessage(Message object) {
        HashMap hashMap;
        int n2 = object.what;
        if (n2 != 0) {
            HashMap hashMap2;
            if (n2 != 1) {
                return false;
            }
            Object object2 = this.g;
            HashMap hashMap3 = hashMap2 = ((d0)object2).f();
            synchronized (hashMap3) {
                Throwable throwable2;
                block11: {
                    block9: {
                        b0 b02;
                        a0 a02;
                        block10: {
                            try {
                                a02 = (a0)object.obj;
                                b02 = (b0)((d0)object2).f().get((Object)a02);
                                if (b02 == null || b02.e() != 3) break block9;
                                object = String.valueOf((Object)a02);
                                n2 = object.length();
                                object2 = new StringBuilder(n2 + 47);
                                object2.append("Timeout waiting for ServiceConnection callback ");
                                object2.append((String)object);
                                object2 = object2.toString();
                                object = new Exception();
                                Log.e((String)"GmsClientSupervisor", (String)object2, (Throwable)object);
                                object2 = b02.i();
                                object = object2;
                                if (object2 != null) break block10;
                                object = a02.c();
                            }
                            catch (Throwable throwable2) {
                                break block11;
                            }
                        }
                        object2 = object;
                        if (object == null) {
                            object = a02.b();
                            n.i(object);
                            object2 = new ComponentName((String)object, "unknown");
                        }
                        b02.onServiceDisconnected((ComponentName)object2);
                    }
                    return true;
                }
                throw throwable2;
            }
        }
        d0 d02 = this.g;
        HashMap hashMap4 = hashMap = d02.f();
        synchronized (hashMap4) {
            Throwable throwable3;
            block14: {
                block12: {
                    block13: {
                        try {
                            object = (a0)object.obj;
                            b0 b03 = (b0)d02.f().get(object);
                            if (b03 == null || !b03.g()) break block12;
                            if (!b03.d()) break block13;
                            b03.a("GmsClientSupervisor");
                        }
                        catch (Throwable throwable3) {
                            break block14;
                        }
                    }
                    d02.f().remove(object);
                }
                return true;
            }
            throw throwable3;
        }
    }
}

