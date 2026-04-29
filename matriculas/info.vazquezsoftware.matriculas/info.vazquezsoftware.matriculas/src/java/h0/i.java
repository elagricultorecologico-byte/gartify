/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Map
 */
package H0;

import H0.b;
import H0.h;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class i {
    public static a a() {
        return new b.b().f((Map)new HashMap());
    }

    public final String b(String string) {
        String string2;
        string = string2 = (String)this.c().get((Object)string);
        if (string2 == null) {
            string = "";
        }
        return string;
    }

    protected abstract Map c();

    public abstract Integer d();

    public abstract h e();

    public abstract long f();

    public final int g(String string) {
        string = (String)this.c().get((Object)string);
        if (string == null) {
            return 0;
        }
        return Integer.valueOf((String)string);
    }

    public final long h(String string) {
        string = (String)this.c().get((Object)string);
        if (string == null) {
            return 0L;
        }
        return Long.valueOf((String)string);
    }

    public final Map i() {
        return Collections.unmodifiableMap((Map)this.c());
    }

    public abstract String j();

    public abstract long k();

    public a l() {
        return new b.b().j(this.j()).g(this.d()).h(this.e()).i(this.f()).k(this.k()).f((Map)new HashMap(this.c()));
    }

    public static abstract class a {
        public final a a(String string, int n2) {
            this.e().put((Object)string, (Object)String.valueOf((int)n2));
            return this;
        }

        public final a b(String string, long l2) {
            this.e().put((Object)string, (Object)String.valueOf((long)l2));
            return this;
        }

        public final a c(String string, String string2) {
            this.e().put((Object)string, (Object)string2);
            return this;
        }

        public abstract i d();

        protected abstract Map e();

        protected abstract a f(Map var1);

        public abstract a g(Integer var1);

        public abstract a h(h var1);

        public abstract a i(long var1);

        public abstract a j(String var1);

        public abstract a k(long var1);
    }
}

