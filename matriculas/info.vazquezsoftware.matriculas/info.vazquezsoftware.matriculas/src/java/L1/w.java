/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.MR0
 *  com.google.android.gms.internal.ads.Tg
 *  com.google.android.gms.internal.ads.UR0
 *  java.lang.Object
 */
package l1;

import com.google.android.gms.internal.ads.MR0;
import com.google.android.gms.internal.ads.Tg;
import com.google.android.gms.internal.ads.UR0;
import l1.v;

public final class w
implements MR0 {
    private final v a;

    private w(v v2) {
        this.a = v2;
    }

    public static w a(v v2) {
        return new w(v2);
    }

    public final /* synthetic */ Object b() {
        Tg tg = this.a.c();
        UR0.b((Object)tg);
        return tg;
    }
}

