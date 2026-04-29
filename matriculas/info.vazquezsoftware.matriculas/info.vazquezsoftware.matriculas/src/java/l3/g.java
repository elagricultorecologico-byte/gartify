/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package l3;

import h3.D;
import l3.a;
import l3.f;

public abstract class g {
    private static final D a = new D("NO_OWNER");
    private static final D b = new D("ALREADY_LOCKED_BY_OWNER");

    public static final a a(boolean bl) {
        return new f(bl);
    }

    public static /* synthetic */ a b(boolean bl, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl = false;
        }
        return g.a(bl);
    }

    public static final /* synthetic */ D c() {
        return a;
    }
}

