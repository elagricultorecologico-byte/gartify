/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  V2.k
 *  java.lang.Object
 *  java.lang.String
 */
package L2;

import L2.i;
import U2.l;
import V2.k;

public abstract class b
implements i.c {
    private final l g;
    private final i.c h;

    public b(i.c c2, l object) {
        k.e((Object)c2, (String)"baseKey");
        k.e((Object)object, (String)"safeCast");
        this.g = object;
        object = c2;
        if (c2 instanceof b) {
            object = ((b)c2).h;
        }
        this.h = object;
    }

    public final boolean a(i.c c2) {
        k.e((Object)c2, (String)"key");
        return c2 == this || this.h == c2;
        {
        }
    }

    public final i.b b(i.b b2) {
        k.e((Object)b2, (String)"element");
        return (i.b)this.g.j(b2);
    }
}

