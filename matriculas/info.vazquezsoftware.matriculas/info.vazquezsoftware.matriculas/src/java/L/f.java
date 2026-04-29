/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  V2.k
 *  c3.H0
 *  c3.I
 *  c3.J
 *  c3.W
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package L;

import I2.o;
import L.d;
import L.e;
import L.j;
import L.l;
import L2.i;
import M.b;
import U2.a;
import V2.k;
import c3.H0;
import c3.I;
import c3.J;
import c3.W;
import java.util.List;

public final class f {
    public static final f a = new f();

    private f() {
    }

    public static /* synthetic */ e b(f f2, j j2, b b2, List list, I i2, a a2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            b2 = null;
        }
        if ((n2 & 4) != 0) {
            list = o.g();
        }
        if ((n2 & 8) != 0) {
            i2 = J.a((i)W.b().s0((i)H0.b(null, (int)1, null)));
        }
        return f2.a(j2, b2, list, i2, a2);
    }

    public final e a(j j2, b a2, List list, I i2, a a3) {
        k.e((Object)j2, (String)"serializer");
        k.e((Object)list, (String)"migrations");
        k.e((Object)i2, (String)"scope");
        k.e((Object)a3, (String)"produceFile");
        a2 = new M.a();
        return new l(a3, j2, o.b(d.a.b(list)), a2, i2);
    }
}

