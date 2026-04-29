/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.List
 */
package u3;

import V2.k;
import java.util.List;
import u3.b;
import z3.d;

public interface l {
    public static final a a = u3.l$a.a;
    public static final l b = new a.a();

    public boolean a(int var1, List var2);

    public boolean b(int var1, List var2, boolean var3);

    public void c(int var1, b var2);

    public boolean d(int var1, d var2, int var3, boolean var4);

    public static final class u3.l$a {
        static final u3.l$a a = new u3.l$a();

        private u3.l$a() {
        }

        private static final class a
        implements l {
            @Override
            public boolean a(int n2, List list) {
                k.e(list, "requestHeaders");
                return true;
            }

            @Override
            public boolean b(int n2, List list, boolean bl) {
                k.e(list, "responseHeaders");
                return true;
            }

            @Override
            public void c(int n2, b b2) {
                k.e((Object)b2, "errorCode");
            }

            @Override
            public boolean d(int n2, d d2, int n3, boolean bl) {
                k.e(d2, "source");
                d2.x(n3);
                return true;
            }
        }
    }
}

