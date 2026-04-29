/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  V2.k
 *  androidx.activity.r
 *  java.lang.Object
 *  java.lang.String
 */
package L2;

import L2.e;
import L2.i;
import L2.j;
import V2.k;
import androidx.activity.r;

public interface f
extends i.b {
    public static final b a = b.g;

    public void a0(e var1);

    public e i0(e var1);

    public static final abstract class a {
        public static i.b a(f b2, i.c c2) {
            k.e((Object)c2, (String)"key");
            if (c2 instanceof L2.b) {
                if (((L2.b)(c2 = (L2.b)c2)).a(b2.getKey()) && r.a((Object)(b2 = ((L2.b)c2).b(b2)))) {
                    return b2;
                }
                return null;
            }
            if (a == c2) {
                k.c((Object)b2, (String)"null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return b2;
            }
            return null;
        }

        public static i b(f i2, i.c object) {
            k.e((Object)object, (String)"key");
            if (object instanceof L2.b) {
                L2.b b2 = (L2.b)object;
                object = i2;
                if (b2.a(i2.getKey())) {
                    object = i2;
                    if (b2.b((i.b)i2) != null) {
                        object = j.g;
                    }
                }
                return object;
            }
            if (a == object) {
                i2 = j.g;
            }
            return i2;
        }
    }

    public static final class b
    implements i.c {
        static final b g = new b();

        private b() {
        }
    }
}

