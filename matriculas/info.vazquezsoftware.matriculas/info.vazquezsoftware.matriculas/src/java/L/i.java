/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  V2.k
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package L;

import L.m;
import V2.k;

final class i
extends m {
    private final Throwable a;

    public i(Throwable throwable) {
        k.e((Object)throwable, (String)"readException");
        super(null);
        this.a = throwable;
    }

    public final Throwable a() {
        return this.a;
    }
}

