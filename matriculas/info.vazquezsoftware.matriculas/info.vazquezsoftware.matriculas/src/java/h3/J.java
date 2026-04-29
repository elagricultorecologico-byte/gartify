/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package H3;

import F3.h;

abstract class j
extends H3.d {
    H3.d a;

    j() {
    }

    static class a
    extends j {
        public a(H3.d d2) {
            this.a = d2;
        }

        @Override
        public boolean a(h object, h h2) {
            object = h2.j0();
            int n2 = object.size();
            int n3 = 0;
            while (n3 < n2) {
                Object object2 = object.get(n3);
                int n4 = n3 + 1;
                object2 = (h)object2;
                n3 = n4;
                if (object2 == h2) continue;
                n3 = n4;
                if (!this.a.a(h2, (h)object2)) continue;
                return true;
            }
            return false;
        }

        public String toString() {
            return String.format((String)":has(%s)", (Object[])new Object[]{this.a});
        }
    }

    static class b
    extends j {
        public b(H3.d d2) {
            this.a = d2;
        }

        @Override
        public boolean a(h h2, h h3) {
            if (h2 == h3) {
                return false;
            }
            return (h3 = h3.v0()) != null && this.a.a(h2, h3);
        }

        public String toString() {
            return String.format((String)"%s > ", (Object[])new Object[]{this.a});
        }
    }

    static class c
    extends j {
        public c(H3.d d2) {
            this.a = d2;
        }

        @Override
        public boolean a(h h2, h h3) {
            if (h2 == h3) {
                return false;
            }
            return (h3 = h3.z0()) != null && this.a.a(h2, h3);
        }

        public String toString() {
            return String.format((String)"%s + ", (Object[])new Object[]{this.a});
        }
    }

    static class d
    extends j {
        public d(H3.d d2) {
            this.a = d2;
        }

        @Override
        public boolean a(h h2, h h3) {
            return this.a.a(h2, h3) ^ true;
        }

        public String toString() {
            return String.format((String)":not(%s)", (Object[])new Object[]{this.a});
        }
    }

    static class e
    extends j {
        public e(H3.d d2) {
            this.a = d2;
        }

        @Override
        public boolean a(h h2, h h3) {
            if (h2 == h3) {
                return false;
            }
            for (h3 = h3.v0(); h3 != null; h3 = h3.v0()) {
                if (this.a.a(h2, h3)) {
                    return true;
                }
                if (h3 == h2) break;
            }
            return false;
        }

        public String toString() {
            return String.format((String)"%s ", (Object[])new Object[]{this.a});
        }
    }

    static class f
    extends j {
        public f(H3.d d2) {
            this.a = d2;
        }

        @Override
        public boolean a(h h2, h h3) {
            if (h2 == h3) {
                return false;
            }
            for (h3 = h3.z0(); h3 != null; h3 = h3.z0()) {
                if (!this.a.a(h2, h3)) continue;
                return true;
            }
            return false;
        }

        public String toString() {
            return String.format((String)"%s ~ ", (Object[])new Object[]{this.a});
        }
    }

    static class g
    extends H3.d {
        g() {
        }

        @Override
        public boolean a(h h2, h h3) {
            return h2 == h3;
        }
    }
}

