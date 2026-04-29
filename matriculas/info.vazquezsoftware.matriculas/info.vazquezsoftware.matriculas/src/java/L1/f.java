/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.List
 *  java.util.concurrent.Callable
 */
package l1;

import C1.a;
import java.util.List;
import java.util.concurrent.Callable;
import l1.r;

final class f
implements Callable {
    private final r a;
    private final List b;
    private final a c;

    /* synthetic */ f(r r2, List list, a a2) {
        this.a = r2;
        this.b = list;
        this.c = a2;
    }

    public final /* synthetic */ Object call() {
        return this.a.q6(this.b, this.c);
    }
}

