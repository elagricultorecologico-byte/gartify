/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package G0;

import G0.g;
import G0.k;
import G0.p;
import java.util.List;

public abstract class m {
    public static a a() {
        return new g.b();
    }

    public abstract k b();

    public abstract List c();

    public abstract Integer d();

    public abstract String e();

    public abstract p f();

    public abstract long g();

    public abstract long h();

    public static abstract class a {
        public abstract m a();

        public abstract a b(k var1);

        public abstract a c(List var1);

        abstract a d(Integer var1);

        abstract a e(String var1);

        public abstract a f(p var1);

        public abstract a g(long var1);

        public abstract a h(long var1);

        public a i(int n2) {
            return this.d(n2);
        }

        public a j(String string) {
            return this.e(string);
        }
    }
}

