/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.Ry0
 *  com.google.android.gms.internal.ads.vr
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Objects
 */
package l1;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.Ry0;
import com.google.android.gms.internal.ads.vr;
import e1.o0;
import f1.p;
import java.util.Objects;
import l1.r;

final class c
implements Ry0 {
    final vr a;
    final boolean b;
    final r c;

    c(r r2, vr vr2, boolean bl) {
        this.a = vr2;
        this.b = bl;
        Objects.requireNonNull((Object)((Object)r2));
        this.c = r2;
    }

    public final void a(Throwable throwable) {
        try {
            vr vr2 = this.a;
            String string = throwable.getMessage();
            int n2 = String.valueOf((Object)string).length();
            throwable = new StringBuilder(n2 + 16);
            throwable.append("Internal error: ");
            throwable.append(string);
            vr2.u(throwable.toString());
            return;
        }
        catch (RemoteException remoteException) {
            int n3 = o0.b;
            p.d("", remoteException);
            return;
        }
    }
}

