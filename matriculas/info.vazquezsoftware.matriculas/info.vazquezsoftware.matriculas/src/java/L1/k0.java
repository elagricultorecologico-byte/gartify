/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Ry0
 *  com.google.android.gms.internal.ads.Sj
 *  com.google.android.gms.internal.ads.Vt
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.bf0
 *  com.google.android.gms.internal.ads.du
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Objects
 */
package l1;

import a1.t;
import android.os.RemoteException;
import b1.A;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Ry0;
import com.google.android.gms.internal.ads.Sj;
import com.google.android.gms.internal.ads.Vt;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.bf0;
import com.google.android.gms.internal.ads.du;
import e1.o0;
import f1.p;
import java.util.Objects;
import l1.r;
import l2.a;

final class k0
implements Ry0 {
    final a a;
    final du b;
    final Vt c;
    final bf0 d;
    final r e;

    k0(r r2, a a2, du du2, Vt vt, bf0 bf02) {
        this.a = a2;
        this.b = du2;
        this.c = vt;
        this.d = bf02;
        Objects.requireNonNull((Object)((Object)r2));
        this.e = r2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(Throwable object) {
        String string = object.getMessage();
        Oi oi = Yi.G8;
        if (((Boolean)A.c().d(oi)).booleanValue()) {
            t.l().k(object, "SignalGeneratorImpl.generateSignals");
        } else {
            t.l().j(object, "SignalGeneratorImpl.generateSignals");
        }
        oi = r.A6(this.a, this.b);
        if (((Boolean)Sj.e.e()).booleanValue() && oi != null) {
            bf0 bf02 = this.d;
            bf02.f(object);
            bf02.e(false);
            oi.a(bf02);
            oi.h();
        }
        if ((oi = this.c) == null) {
            return;
        }
        try {
            void var1_5;
            if ("Unknown format is no longer supported.".equals((Object)string)) {
                String string2 = string;
            } else {
                int n2 = String.valueOf((Object)string).length();
                StringBuilder stringBuilder = new StringBuilder(n2 + 16);
                stringBuilder.append("Internal error. ");
                stringBuilder.append(string);
                String string3 = stringBuilder.toString();
            }
            oi.v((String)var1_5);
            return;
        }
        catch (RemoteException remoteException) {
            int n3 = o0.b;
            p.d("", remoteException);
            return;
        }
    }
}

