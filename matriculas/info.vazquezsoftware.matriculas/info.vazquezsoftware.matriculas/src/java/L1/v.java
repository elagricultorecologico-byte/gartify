/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.Tg
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  java.util.Locale
 *  java.util.Set
 */
package l1;

import com.google.android.gms.internal.ads.Tg;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import l1.u;

public final class v {
    private final String a;

    /* synthetic */ v(u u2, byte[] byArray) {
        this.a = u2.b();
    }

    public final Set a() {
        HashSet hashSet = new HashSet();
        hashSet.add((Object)this.a.toLowerCase(Locale.ROOT));
        return hashSet;
    }

    public final String b() {
        return this.a.toLowerCase(Locale.ROOT);
    }

    public final Tg c() {
        int n2;
        block10: {
            String string = this.a;
            switch (string.hashCode()) {
                default: {
                    break;
                }
                case 1951953708: {
                    if (!string.equals((Object)"BANNER")) break;
                    n2 = 0;
                    break block10;
                }
                case 543046670: {
                    if (!string.equals((Object)"REWARDED")) break;
                    n2 = 3;
                    break block10;
                }
                case -1372958932: {
                    if (!string.equals((Object)"INTERSTITIAL")) break;
                    n2 = 1;
                    break block10;
                }
                case -1999289321: {
                    if (!string.equals((Object)"NATIVE")) break;
                    n2 = 2;
                    break block10;
                }
            }
            n2 = -1;
        }
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        return Tg.h;
                    }
                    return Tg.o;
                }
                return Tg.n;
            }
            return Tg.k;
        }
        return Tg.i;
    }
}

