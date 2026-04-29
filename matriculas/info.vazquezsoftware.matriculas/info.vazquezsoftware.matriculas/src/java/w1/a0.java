/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Parcelable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.util.concurrent.atomic.AtomicReference
 */
package w1;

import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import java.util.concurrent.atomic.AtomicReference;
import u1.b;
import w1.W;
import w1.Y;
import w1.Z;
import w1.g;
import w1.h;

public abstract class a0
extends g
implements DialogInterface.OnCancelListener {
    protected volatile boolean h;
    protected final AtomicReference i = new AtomicReference(null);
    private final Handler j = new G1.h(Looper.getMainLooper());
    protected final u1.g k;

    a0(h h2, u1.g g2) {
        super(h2);
        this.k = g2;
    }

    private final void l(b b2, int n2) {
        this.i.set(null);
        this.m(b2, n2);
    }

    private final void o() {
        this.i.set(null);
        this.n();
    }

    private static final int p(W w2) {
        if (w2 == null) {
            return -1;
        }
        return w2.a();
    }

    static /* bridge */ /* synthetic */ void q(a0 a02, b b2, int n2) {
        a02.l(b2, n2);
    }

    static /* bridge */ /* synthetic */ void r(a0 a02) {
        a02.o();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public final void e(int n2, int n3, Intent intent) {
        W w2 = (W)this.i.get();
        if (n2 != 1) {
            if (n2 == 2) {
                n2 = this.k.g((Context)this.b());
                if (n2 == 0) {
                    this.o();
                    return;
                }
                if (w2 == null || w2.b().b() == 18 && n2 == 18) {
                    return;
                }
            }
        } else {
            if (n3 == -1) {
                this.o();
                return;
            }
            if (n3 == 0) {
                if (w2 == null) return;
                n2 = 13;
                if (intent != null) {
                    n2 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                }
                this.l(new b(n2, null, w2.b().toString()), a0.p(w2));
                return;
            }
        }
        if (w2 == null) return;
        this.l(w2.b(), w2.a());
    }

    @Override
    public final void f(Bundle object) {
        super.f((Bundle)object);
        if (object != null) {
            AtomicReference atomicReference = this.i;
            object = object.getBoolean("resolving_error", false) ? new W(new b(object.getInt("failed_status"), (PendingIntent)object.getParcelable("failed_resolution")), object.getInt("failed_client_id", -1)) : null;
            atomicReference.set(object);
        }
    }

    @Override
    public final void i(Bundle bundle) {
        super.i(bundle);
        W w2 = (W)this.i.get();
        if (w2 == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", w2.a());
        bundle.putInt("failed_status", w2.b().b());
        bundle.putParcelable("failed_resolution", (Parcelable)w2.b().f());
    }

    @Override
    public void j() {
        super.j();
        this.h = true;
    }

    @Override
    public void k() {
        super.k();
        this.h = false;
    }

    protected abstract void m(b var1, int var2);

    protected abstract void n();

    public final void onCancel(DialogInterface dialogInterface) {
        this.l(new b(13, null), a0.p((W)this.i.get()));
    }

    public final void s(b b2, int n2) {
        W w2 = new W(b2, n2);
        do {
            if (!Z.a((AtomicReference)(b2 = this.i), null, w2)) continue;
            this.j.post((Runnable)new Y(this, w2));
            return;
        } while (b2.get() == null);
    }
}

