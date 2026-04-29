/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Set
 */
package H0;

import F0.b;
import F0.e;
import F0.f;
import F0.g;
import H0.o;
import H0.r;
import H0.s;
import java.util.Set;

final class p
implements g {
    private final Set a;
    private final o b;
    private final s c;

    p(Set set, o o2, s s2) {
        this.a = set;
        this.b = o2;
        this.c = s2;
    }

    @Override
    public f a(String string, Class clazz, b b2, e e2) {
        if (this.a.contains((Object)b2)) {
            return new r(this.b, string, b2, e2, this.c);
        }
        throw new IllegalArgumentException(String.format((String)"%s is not supported byt this factory. Supported encodings are: %s.", (Object[])new Object[]{b2, this.a}));
    }
}

