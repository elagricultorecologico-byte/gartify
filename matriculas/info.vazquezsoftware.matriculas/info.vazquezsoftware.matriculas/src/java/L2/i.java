/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  V2.k
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package L2;

import L2.d;
import L2.f;
import L2.h;
import L2.j;
import U2.p;
import V2.k;

public interface i {
    public Object I(Object var1, p var2);

    public i c0(c var1);

    public b i(c var1);

    public i s0(i var1);

    public static final abstract class a {
        public static /* synthetic */ i a(i i2, b b2) {
            return a.c(i2, b2);
        }

        public static i b(i i2, i i3) {
            k.e((Object)i3, (String)"context");
            if (i3 == j.g) {
                return i2;
            }
            return (i)i3.I(i2, new h());
        }

        private static i c(i i2, b b2) {
            k.e((Object)i2, (String)"acc");
            k.e((Object)b2, (String)"element");
            i i3 = i2.c0(b2.getKey());
            j j2 = j.g;
            if (i3 == j2) {
                return b2;
            }
            f.b b3 = f.a;
            i2 = (f)i3.i(b3);
            if (i2 == null) {
                return new d(i3, b2);
            }
            if ((i3 = i3.c0(b3)) == j2) {
                return new d(b2, (b)i2);
            }
            return new d(new d(i3, b2), (b)i2);
        }
    }

    public static interface b
    extends i {
        public c getKey();

        @Override
        public b i(c var1);

        public static final abstract class a {
            public static Object a(b b2, Object object, p p2) {
                k.e((Object)p2, (String)"operation");
                return p2.h(object, b2);
            }

            public static b b(b b2, c c2) {
                k.e((Object)c2, (String)"key");
                if (k.a((Object)b2.getKey(), (Object)c2)) {
                    k.c((Object)b2, (String)"null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                    return b2;
                }
                return null;
            }

            public static i c(b b2, c c2) {
                k.e((Object)c2, (String)"key");
                i i2 = b2;
                if (k.a((Object)b2.getKey(), (Object)c2)) {
                    i2 = j.g;
                }
                return i2;
            }

            public static i d(b b2, i i2) {
                k.e((Object)i2, (String)"context");
                return L2.i$a.b(b2, i2);
            }
        }
    }

    public static interface c {
    }
}

