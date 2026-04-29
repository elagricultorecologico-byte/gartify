/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package e3;

import V2.g;
import V2.k;

public abstract class h {
    public static final b a = new b(null);
    private static final c b = new c();

    public static Object b(Object object) {
        return object;
    }

    public static final Throwable c(Object object) {
        if ((object = object instanceof a ? (a)object : null) != null) {
            return ((a)object).a;
        }
        return null;
    }

    public static final Object d(Object object) {
        if (!(object instanceof c)) {
            return object;
        }
        return null;
    }

    public static final boolean e(Object object) {
        return object instanceof a;
    }

    public static final boolean f(Object object) {
        return object instanceof c ^ true;
    }

    public static final class a
    extends c {
        public final Throwable a;

        public a(Throwable throwable) {
            this.a = throwable;
        }

        public boolean equals(Object object) {
            return object instanceof a && k.a(this.a, ((a)object).a);
        }

        public int hashCode() {
            Throwable throwable = this.a;
            if (throwable != null) {
                return throwable.hashCode();
            }
            return 0;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Closed(");
            stringBuilder.append((Object)this.a);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g g2) {
            this();
        }

        public final Object a(Throwable throwable) {
            return h.b(new a(throwable));
        }

        public final Object b() {
            return h.b(b);
        }

        public final Object c(Object object) {
            return h.b(object);
        }
    }

    public static class c {
        public String toString() {
            return "Failed";
        }
    }
}

