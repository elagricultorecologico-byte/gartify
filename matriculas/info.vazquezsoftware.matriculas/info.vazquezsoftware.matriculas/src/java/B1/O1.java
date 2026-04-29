/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Objects
 */
package b1;

import Z0.a;
import b1.t1;
import java.util.Objects;

final class o1
implements a {
    o1(t1 t12) {
        Objects.requireNonNull((Object)t12);
    }

    @Override
    public final int a() {
        return 0;
    }

    @Override
    public final String getDescription() {
        return "Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.";
    }
}

