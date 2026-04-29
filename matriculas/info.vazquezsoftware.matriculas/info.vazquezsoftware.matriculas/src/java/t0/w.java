/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  b1.T1
 *  b1.b1
 *  b1.e1
 *  f1.p
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package T0;

import android.os.RemoteException;
import b1.T1;
import b1.b1;
import b1.e1;
import f1.p;

public final class w {
    private final Object a = new Object();
    private b1 b;
    private a c;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(a var1_1) {
        var4_5 = var2_4 = this.a;
        synchronized (var4_5) {
            block6: {
                block7: {
                    try {
                        this.c = var1_1;
                        var3_6 = this.b;
                        if (var3_6 == null) {
                            return;
                        }
                    }
                    catch (Throwable var1_2) {
                        break block6;
                    }
                    if (var1_1 != null) break block7;
                    var1_1 = null;
                    ** GOTO lbl17
                }
                try {
                    var1_1 = new T1(var1_1);
lbl17:
                    // 2 sources

                    var3_6.J3((e1)var1_1);
                }
                catch (RemoteException var1_3) {
                    p.d((String)"Unable to call setVideoLifecycleCallbacks on video controller.", (Throwable)var1_3);
                }
                return;
            }
            throw var1_2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void b(b1 object) {
        Object object2;
        Object object3 = object2 = this.a;
        synchronized (object3) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        this.b = object;
                        object = this.c;
                        if (object == null) break block3;
                        this.a((a)object);
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final b1 c() {
        Object object;
        Object object2 = object = this.a;
        synchronized (object2) {
            return this.b;
        }
    }

    public static abstract class a {
        public abstract void a();

        public void b(boolean bl) {
        }

        public abstract void c();

        public void d() {
        }

        public abstract void e();
    }
}

