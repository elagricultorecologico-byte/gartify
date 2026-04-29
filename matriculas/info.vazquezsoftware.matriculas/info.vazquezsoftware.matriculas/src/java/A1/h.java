/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.nj0
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.Objects
 */
package a1;

import a1.k;
import com.google.android.gms.internal.ads.nj0;
import java.util.Objects;

final class h
implements nj0 {
    final k a;

    h(k k3) {
        Objects.requireNonNull((Object)k3);
        this.a = k3;
    }

    public final void a(int n3, long l3, String string) {
        long l4 = System.currentTimeMillis();
        this.a.o().f(n3, l4 - l3, string);
    }

    public final void b(int n3, long l3) {
        long l4 = System.currentTimeMillis();
        this.a.o().b(n3, l4 - l3);
    }
}

