/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioManager
 *  com.google.android.gms.internal.ads.Yi
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Throwable
 */
package e1;

import a1.t;
import android.content.Context;
import android.media.AudioManager;
import b1.A;
import com.google.android.gms.internal.ads.Yi;

public final class b {
    private static volatile float c = -1.0f;
    private static volatile long d;
    private static final Object e;
    private boolean a = false;
    private float b = 1.0f;

    static {
        e = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static float e(Context context) {
        Object object = Yi.Df;
        if (((Boolean)A.c().d(object)).booleanValue()) {
            long l2 = t.o().b();
            object = Yi.Ef;
            long l3 = ((Integer)A.c().d(object)).intValue();
            if (c != -1.0f && l2 - d < l3) {
                return c;
            }
            Object object2 = object = e;
            synchronized (object2) {
                Throwable throwable2;
                block7: {
                    try {
                        l2 = t.o().b();
                        if (c != -1.0f && l2 - d < l3) {
                            return c;
                        }
                    }
                    catch (Throwable throwable2) {
                        break block7;
                    }
                    if ((context = (AudioManager)context.getSystemService("audio")) == null) {
                        c = 0.0f;
                        d = l2;
                        return 0.0f;
                    }
                    c = e1.b.g((AudioManager)context);
                    d = l2;
                    return c;
                }
                throw throwable2;
            }
        }
        if ((context = (AudioManager)context.getSystemService("audio")) != null) return e1.b.g((AudioManager)context);
        return 0.0f;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final boolean f() {
        b b2 = this;
        synchronized (b2) {
            float f2 = this.b;
            return f2 >= 0.0f;
        }
    }

    private static float g(AudioManager audioManager) {
        int n2 = audioManager.getStreamMaxVolume(3);
        int n3 = audioManager.getStreamVolume(3);
        if (n2 == 0) {
            return 0.0f;
        }
        return (float)n3 / (float)n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(float f2) {
        b b2 = this;
        synchronized (b2) {
            this.b = f2;
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final float b() {
        b b2 = this;
        synchronized (b2) {
            try {
                if (!this.f()) return 1.0f;
                return this.b;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void c(boolean bl) {
        b b2 = this;
        synchronized (b2) {
            this.a = bl;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean d() {
        b b2 = this;
        synchronized (b2) {
            return this.a;
        }
    }
}

