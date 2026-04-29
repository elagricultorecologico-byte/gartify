/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.MR0
 *  com.google.android.gms.internal.ads.UR0
 *  java.lang.Object
 *  java.lang.String
 */
package l1;

import com.google.android.gms.internal.ads.MR0;
import com.google.android.gms.internal.ads.UR0;
import l1.v;

public final class x
implements MR0 {
    private final v a;

    private x(v v2) {
        this.a = v2;
    }

    public static x a(v v2) {
        return new x(v2);
    }

    public final /* synthetic */ Object b() {
        String string = this.a.b();
        UR0.b((Object)string);
        return string;
    }
}

