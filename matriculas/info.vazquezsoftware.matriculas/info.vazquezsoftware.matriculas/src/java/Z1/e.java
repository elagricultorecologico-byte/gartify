/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Looper
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package z1;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import u1.d;
import w1.k;
import x1.g;
import x1.t;
import z1.a;

public final class e
extends g {
    private final t I;

    public e(Context context, Looper looper, x1.d d2, t t2, w1.d d3, k k2) {
        super(context, looper, 270, d2, d3, k2);
        this.I = t2;
    }

    @Override
    protected final Bundle A() {
        return this.I.b();
    }

    @Override
    protected final String E() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override
    protected final String F() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override
    protected final boolean I() {
        return true;
    }

    @Override
    public final int g() {
        return 203400000;
    }

    @Override
    protected final /* synthetic */ IInterface s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        if (iInterface instanceof a) {
            return (a)iInterface;
        }
        return new a(iBinder);
    }

    @Override
    public final d[] v() {
        return G1.d.b;
    }
}

