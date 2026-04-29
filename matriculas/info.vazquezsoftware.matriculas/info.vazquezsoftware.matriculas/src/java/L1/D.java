/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Ry0
 *  com.google.android.gms.internal.ads.Yi
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.Objects
 */
package l1;

import T0.c;
import a1.t;
import android.util.Pair;
import b1.A;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Ry0;
import com.google.android.gms.internal.ads.Yi;
import e1.o0;
import f1.p;
import java.util.Objects;
import l1.h0;
import l1.r;

final class d
implements Ry0 {
    final r a;

    d(r r2) {
        Objects.requireNonNull((Object)((Object)r2));
        this.a = r2;
    }

    public final void a(Throwable throwable) {
        t.l().j(throwable, "SignalGeneratorImpl.initializeWebViewForSignalCollection");
        Pair pair = new Pair((Object)"sgf_reason", (Object)throwable.getMessage());
        Pair pair2 = new Pair((Object)"se", (Object)"query_g");
        Pair pair3 = new Pair((Object)"ad_format", (Object)c.h.name());
        Pair pair4 = new Pair((Object)"rtype", (Object)Integer.toString((int)6));
        Pair pair5 = new Pair((Object)"scar", (Object)"true");
        r r2 = this.a;
        Pair pair6 = new Pair((Object)"sgi_rn", (Object)Integer.toString((int)r2.a6().get()));
        h0.e(r2.M5(), null, "sgf", pair, pair2, pair3, pair4, pair5, pair6);
        int n2 = o0.b;
        p.d("Failed to initialize webview for loading SDKCore. ", throwable);
        throwable = Yi.db;
        if (((Boolean)A.c().d((Oi)throwable)).booleanValue() && !r2.Z5().get()) {
            n2 = r2.a6().getAndIncrement();
            throwable = Yi.eb;
            if (n2 < (Integer)A.c().d((Oi)throwable)) {
                r2.z6();
            }
        }
    }
}

