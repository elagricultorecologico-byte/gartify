/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.List
 */
package m3;

import I2.o;
import V2.k;
import java.util.List;
import m3.t;

public interface m {
    public static final a a = m3.m$a.a;
    public static final m b = new a.a();

    public List a(t var1);

    public void b(t var1, List var2);

    public static final class m3.m$a {
        static final m3.m$a a = new m3.m$a();

        private m3.m$a() {
        }

        private static final class a
        implements m {
            @Override
            public List a(t t2) {
                k.e(t2, "url");
                return o.g();
            }

            @Override
            public void b(t t2, List list) {
                k.e(t2, "url");
                k.e(list, "cookies");
            }
        }
    }
}

