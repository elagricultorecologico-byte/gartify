/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.FS
 *  com.google.android.gms.internal.ads.uL
 *  java.lang.Object
 *  java.lang.String
 */
package l1;

import com.google.android.gms.internal.ads.FS;
import com.google.android.gms.internal.ads.uL;
import l1.F;
import l1.c0;

public final class d0
implements uL {
    private final FS g;
    private final c0 h;
    private final String i;

    public d0(FS fS, c0 c02, String string) {
        this.g = fS;
        this.h = c02;
        this.i = string;
    }

    public final void a(F f2) {
        if (f2 == null) {
            return;
        }
        c0 c02 = this.h;
        String string = this.i;
        FS fS = this.g;
        c02.a(string, f2.b, fS);
    }

    public final void x(String string) {
    }
}

