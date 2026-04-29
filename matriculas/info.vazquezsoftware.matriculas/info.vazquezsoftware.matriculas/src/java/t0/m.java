/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package t0;

public interface m {
    public static final b.c a = new b.c();
    public static final b.b b = new b.b();

    public static abstract class t0.m$b {
        t0.m$b() {
        }

        public static final class a
        extends t0.m$b {
            private final Throwable a;

            public a(Throwable throwable) {
                this.a = throwable;
            }

            public Throwable a() {
                return this.a;
            }

            public String toString() {
                return String.format((String)"FAILURE (%s)", (Object[])new Object[]{this.a.getMessage()});
            }
        }

        public static final class b
        extends t0.m$b {
            private b() {
            }

            public String toString() {
                return "IN_PROGRESS";
            }
        }

        public static final class c
        extends t0.m$b {
            private c() {
            }

            public String toString() {
                return "SUCCESS";
            }
        }
    }
}

