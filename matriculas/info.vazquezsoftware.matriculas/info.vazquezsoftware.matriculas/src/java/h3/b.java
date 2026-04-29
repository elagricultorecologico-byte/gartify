/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 */
package H3;

import E3.c;
import F3.h;
import H3.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

abstract class b
extends d {
    final ArrayList a = new ArrayList();
    int b = 0;

    b() {
    }

    b(Collection collection) {
        this();
        this.a.addAll(collection);
        this.d();
    }

    void b(d d2) {
        this.a.set(this.b - 1, (Object)d2);
    }

    d c() {
        int n2 = this.b;
        if (n2 > 0) {
            return (d)this.a.get(n2 - 1);
        }
        return null;
    }

    void d() {
        this.b = this.a.size();
    }

    static final class a
    extends b {
        a(Collection collection) {
            super(collection);
        }

        a(d ... dArray) {
            this((Collection)Arrays.asList((Object[])dArray));
        }

        @Override
        public boolean a(h h2, h h3) {
            for (int i2 = this.b - 1; i2 >= 0; --i2) {
                if (((d)this.a.get(i2)).a(h2, h3)) continue;
                return false;
            }
            return true;
        }

        public String toString() {
            return c.k((Collection)this.a, "");
        }
    }

    static final class b
    extends b {
        b() {
        }

        b(Collection collection) {
            if (this.b > 1) {
                this.a.add((Object)new a(collection));
            } else {
                this.a.addAll(collection);
            }
            this.d();
        }

        b(d ... dArray) {
            this((Collection)Arrays.asList((Object[])dArray));
        }

        @Override
        public boolean a(h h2, h h3) {
            for (int i2 = 0; i2 < this.b; ++i2) {
                if (!((d)this.a.get(i2)).a(h2, h3)) continue;
                return true;
            }
            return false;
        }

        public void e(d d2) {
            this.a.add((Object)d2);
            this.d();
        }

        public String toString() {
            return c.k((Collection)this.a, ", ");
        }
    }
}

