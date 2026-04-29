/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  V2.k
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package L2;

import L2.i;
import U2.p;
import V2.k;
import java.io.Serializable;

public final class j
implements i,
Serializable {
    public static final j g = new j();

    private j() {
    }

    @Override
    public Object I(Object object, p p2) {
        k.e((Object)p2, (String)"operation");
        return object;
    }

    @Override
    public i c0(i.c c2) {
        k.e((Object)c2, (String)"key");
        return this;
    }

    public int hashCode() {
        return 0;
    }

    @Override
    public i.b i(i.c c2) {
        k.e((Object)c2, (String)"key");
        return null;
    }

    @Override
    public i s0(i i2) {
        k.e((Object)i2, (String)"context");
        return i2;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}

