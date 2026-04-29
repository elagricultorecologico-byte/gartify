/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  B3.a
 *  android.os.Build$VERSION
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.Set
 */
package s0;

import android.os.Build;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import s0.t;

public abstract class a
implements s0.h {
    private static final Set c = new HashSet();
    private final String a;
    private final String b;

    a(String string, String string2) {
        this.a = string;
        this.b = string2;
        c.add((Object)this);
    }

    public static Set e() {
        return Collections.unmodifiableSet((Set)c);
    }

    public abstract boolean a();

    @Override
    public boolean b() {
        return this.a() || this.d();
        {
        }
    }

    @Override
    public String c() {
        return this.a;
    }

    public boolean d() {
        return B3.a.b((Collection)s0.a$a.a, (String)this.b);
    }

    private static abstract class a {
        static final Set a = new HashSet((Collection)Arrays.asList((Object[])t.c().a()));
    }

    public static class b
    extends a {
        b(String string, String string2) {
            super(string, string2);
        }

        @Override
        public final boolean a() {
            return true;
        }
    }

    public static class c
    extends a {
        c(String string, String string2) {
            super(string, string2);
        }

        @Override
        public final boolean a() {
            return Build.VERSION.SDK_INT >= 24;
        }
    }

    public static class d
    extends a {
        d(String string, String string2) {
            super(string, string2);
        }

        @Override
        public final boolean a() {
            return false;
        }
    }

    public static class e
    extends a {
        e(String string, String string2) {
            super(string, string2);
        }

        @Override
        public final boolean a() {
            return Build.VERSION.SDK_INT >= 26;
        }
    }

    public static class f
    extends a {
        f(String string, String string2) {
            super(string, string2);
        }

        @Override
        public final boolean a() {
            return Build.VERSION.SDK_INT >= 27;
        }
    }

    public static class g
    extends a {
        g(String string, String string2) {
            super(string, string2);
        }

        @Override
        public final boolean a() {
            return Build.VERSION.SDK_INT >= 28;
        }
    }

    public static class h
    extends a {
        h(String string, String string2) {
            super(string, string2);
        }

        @Override
        public final boolean a() {
            return Build.VERSION.SDK_INT >= 29;
        }
    }

    public static abstract class i
    extends a {
        i(String string, String string2) {
            super(string, string2);
        }

        @Override
        public final boolean a() {
            return Build.VERSION.SDK_INT >= 33;
        }
    }
}

