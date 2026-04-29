/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 *  java.util.Map$Entry
 *  java.util.WeakHashMap
 */
package m;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class b
implements Iterable {
    c g;
    private c h;
    private final WeakHashMap i = new WeakHashMap();
    private int j = 0;

    public Map.Entry c() {
        return this.g;
    }

    public Iterator descendingIterator() {
        b b2 = new b(this.h, this.g);
        this.i.put((Object)b2, (Object)Boolean.FALSE);
        return b2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof b)) {
            return false;
        }
        b b2 = (b)object;
        if (this.size() != b2.size()) {
            return false;
        }
        object = this.iterator();
        b2 = b2.iterator();
        while (object.hasNext() && b2.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            Object object2 = b2.next();
            if ((entry != null || object2 == null) && (entry == null || entry.equals(object2))) continue;
            return false;
        }
        return !object.hasNext() && !b2.hasNext();
    }

    protected c f(Object object) {
        c c3 = this.g;
        while (c3 != null && !c3.g.equals(object)) {
            c3 = c3.i;
        }
        return c3;
    }

    public d h() {
        d d3 = new d(this);
        this.i.put((Object)d3, (Object)Boolean.FALSE);
        return d3;
    }

    public int hashCode() {
        Iterator iterator = this.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            n2 += ((Map.Entry)iterator.next()).hashCode();
        }
        return n2;
    }

    public Map.Entry i() {
        return this.h;
    }

    public Iterator iterator() {
        a a2 = new a(this.g, this.h);
        this.i.put((Object)a2, (Object)Boolean.FALSE);
        return a2;
    }

    c j(Object object, Object object2) {
        object2 = new c(object, object2);
        ++this.j;
        object = this.h;
        if (object == null) {
            this.g = object2;
            this.h = object2;
            return object2;
        }
        ((c)object).i = object2;
        ((c)object2).j = object;
        this.h = object2;
        return object2;
    }

    public Object k(Object object, Object object2) {
        c c3 = this.f(object);
        if (c3 != null) {
            return c3.h;
        }
        this.j(object, object2);
        return null;
    }

    public Object l(Object object) {
        c c3;
        Object object2;
        if ((object = this.f(object)) == null) {
            return null;
        }
        --this.j;
        if (!this.i.isEmpty()) {
            object2 = this.i.keySet().iterator();
            while (object2.hasNext()) {
                ((f)object2.next()).b((c)object);
            }
        }
        if ((c3 = ((c)object).j) != null) {
            c3.i = ((c)object).i;
        } else {
            this.g = ((c)object).i;
        }
        object2 = ((c)object).i;
        if (object2 != null) {
            object2.j = c3;
        } else {
            this.h = c3;
        }
        ((c)object).i = null;
        ((c)object).j = null;
        return ((c)object).h;
    }

    public int size() {
        return this.j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            stringBuilder.append(((Map.Entry)iterator.next()).toString());
            if (!iterator.hasNext()) continue;
            stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    static class a
    extends e {
        a(c c3, c c4) {
            super(c3, c4);
        }

        @Override
        c c(c c3) {
            return c3.j;
        }

        @Override
        c d(c c3) {
            return c3.i;
        }
    }

    private static class b
    extends e {
        b(c c3, c c4) {
            super(c3, c4);
        }

        @Override
        c c(c c3) {
            return c3.i;
        }

        @Override
        c d(c c3) {
            return c3.j;
        }
    }

    static class c
    implements Map.Entry {
        final Object g;
        final Object h;
        c i;
        c j;

        c(Object object, Object object2) {
            this.g = object;
            this.h = object2;
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof c)) {
                return false;
            }
            object = (c)object;
            return this.g.equals(((c)object).g) && this.h.equals(((c)object).h);
        }

        public Object getKey() {
            return this.g;
        }

        public Object getValue() {
            return this.h;
        }

        public int hashCode() {
            return this.g.hashCode() ^ this.h.hashCode();
        }

        public Object setValue(Object object) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.g);
            stringBuilder.append("=");
            stringBuilder.append(this.h);
            return stringBuilder.toString();
        }
    }

    public class d
    extends f
    implements Iterator {
        private c g;
        private boolean h;
        final b i;

        d(b b2) {
            this.i = b2;
            this.h = true;
        }

        @Override
        void b(c c3) {
            c c4 = this.g;
            if (c3 == c4) {
                this.g = c3 = c4.j;
                boolean bl = c3 == null;
                this.h = bl;
            }
        }

        public Map.Entry c() {
            if (this.h) {
                this.h = false;
                this.g = this.i.g;
            } else {
                c c3 = this.g;
                c3 = c3 != null ? c3.i : null;
                this.g = c3;
            }
            return this.g;
        }

        public boolean hasNext() {
            if (this.h) {
                return this.i.g != null;
            }
            c c3 = this.g;
            return c3 != null && c3.i != null;
        }
    }

    private static abstract class e
    extends f
    implements Iterator {
        c g;
        c h;

        e(c c3, c c4) {
            this.g = c4;
            this.h = c3;
        }

        private c f() {
            c c3 = this.h;
            c c4 = this.g;
            if (c3 != c4 && c4 != null) {
                return this.d(c3);
            }
            return null;
        }

        @Override
        public void b(c c3) {
            c c4;
            if (this.g == c3 && c3 == this.h) {
                this.h = null;
                this.g = null;
            }
            if ((c4 = this.g) == c3) {
                this.g = this.c(c4);
            }
            if (this.h == c3) {
                this.h = this.f();
            }
        }

        abstract c c(c var1);

        abstract c d(c var1);

        public Map.Entry e() {
            c c3 = this.h;
            this.h = this.f();
            return c3;
        }

        public boolean hasNext() {
            return this.h != null;
        }
    }

    public static abstract class f {
        abstract void b(c var1);
    }
}

