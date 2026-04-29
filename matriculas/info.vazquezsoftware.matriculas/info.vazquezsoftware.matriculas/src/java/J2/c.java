/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  V2.g
 *  V2.k
 *  Y2.d
 *  java.io.Serializable
 *  java.lang.ClassCastException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.ConcurrentModificationException
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.NoSuchElementException
 *  java.util.Set
 */
package J2;

import V2.g;
import V2.k;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class c
implements Map,
Serializable {
    public static final a t = new a(null);
    private static final c u;
    private Object[] g;
    private Object[] h;
    private int[] i;
    private int[] j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private J2.e p;
    private J2.f q;
    private J2.d r;
    private boolean s;

    static {
        c c2 = new c(0);
        c2.s = true;
        u = c2;
    }

    public c(int n2) {
        this(J2.b.a(n2), null, new int[n2], new int[c.t.c(n2)], 2, 0);
    }

    private c(Object[] objectArray, Object[] objectArray2, int[] nArray, int[] nArray2, int n2, int n3) {
        this.g = objectArray;
        this.h = objectArray2;
        this.i = nArray;
        this.j = nArray2;
        this.k = n2;
        this.l = n3;
        this.m = c.t.d(this.w());
    }

    private final int A(Object object) {
        int n2 = object != null ? object.hashCode() : 0;
        return n2 * -1640531527 >>> this.m;
    }

    private final boolean C(Collection collection) {
        boolean bl = collection.isEmpty();
        boolean bl2 = false;
        if (bl) {
            return false;
        }
        this.q(collection.size());
        collection = collection.iterator();
        while (collection.hasNext()) {
            if (!this.D((Map.Entry)collection.next())) continue;
            bl2 = true;
        }
        return bl2;
    }

    private final boolean D(Map.Entry entry) {
        int n2 = this.h(entry.getKey());
        Object[] objectArray = this.i();
        if (n2 >= 0) {
            objectArray[n2] = entry.getValue();
            return true;
        }
        n2 = -n2 - 1;
        Object object = objectArray[n2];
        if (!V2.k.a((Object)entry.getValue(), (Object)object)) {
            objectArray[n2] = entry.getValue();
            return true;
        }
        return false;
    }

    private final boolean E(int n2) {
        int n3 = this.A(this.g[n2]);
        int n4 = this.k;
        while (true) {
            int[] nArray;
            if ((nArray = this.j)[n3] == 0) {
                nArray[n3] = n2 + 1;
                this.i[n2] = n3;
                return true;
            }
            if (--n4 < 0) {
                return false;
            }
            if (n3 == 0) {
                n3 = this.w() - 1;
                continue;
            }
            --n3;
        }
    }

    private final void F() {
        ++this.n;
    }

    private final void G(int n2) {
        this.F();
        int n3 = this.l;
        int n4 = this.size();
        int n5 = 0;
        if (n3 > n4) {
            this.l(false);
        }
        this.j = new int[n2];
        this.m = c.t.d(n2);
        for (n2 = n5; n2 < this.l; ++n2) {
            if (this.E(n2)) {
                continue;
            }
            throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
        }
    }

    private final void I(int n2) {
        J2.b.c(this.g, n2);
        Object[] objectArray = this.h;
        if (objectArray != null) {
            J2.b.c(objectArray, n2);
        }
        this.J(this.i[n2]);
        this.i[n2] = -1;
        this.o = this.size() - 1;
        this.F();
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void J(int n2) {
        int n3;
        int n4 = Y2.d.c((int)(this.k * 2), (int)(this.w() / 2));
        int n5 = 0;
        int n6 = n2;
        do {
            int n7;
            block8: {
                block7: {
                    int n8;
                    block6: {
                        n2 = n2 == 0 ? this.w() - 1 : --n2;
                        n3 = n5 + 1;
                        if (n3 > this.k) {
                            this.j[n6] = 0;
                            return;
                        }
                        int[] nArray = this.j;
                        n8 = nArray[n2];
                        if (n8 == 0) {
                            nArray[n6] = 0;
                            return;
                        }
                        if (n8 >= 0) break block6;
                        nArray[n6] = -1;
                        break block7;
                    }
                    Object[] objectArray = this.g;
                    int n9 = n8 - 1;
                    n7 = n6;
                    n5 = n3;
                    if ((this.A(objectArray[n9]) - n2 & this.w() - 1) < n3) break block8;
                    this.j[n6] = n8;
                    this.i[n9] = n6;
                }
                n7 = n2;
                n5 = 0;
            }
            n3 = n4 - 1;
            n6 = n7;
            n4 = n3;
        } while (n3 >= 0);
        this.j[n7] = -1;
    }

    private final boolean M(int n2) {
        int n3 = this.u();
        int n4 = this.l;
        return (n3 -= n4) < n2 && n3 + (n4 -= this.size()) >= n2 && n4 >= this.u() / 4;
    }

    private final Object[] i() {
        Object[] objectArray = this.h;
        if (objectArray != null) {
            return objectArray;
        }
        objectArray = J2.b.a(this.u());
        this.h = objectArray;
        return objectArray;
    }

    private final void l(boolean bl) {
        int n2;
        Object[] objectArray = this.h;
        int n3 = 0;
        for (int i2 = 0; i2 < (n2 = this.l); ++i2) {
            int[] nArray = this.i;
            int n4 = nArray[i2];
            n2 = n3;
            if (n4 >= 0) {
                Object[] objectArray2 = this.g;
                objectArray2[n3] = objectArray2[i2];
                if (objectArray != null) {
                    objectArray[n3] = objectArray[i2];
                }
                if (bl) {
                    nArray[n3] = n4;
                    this.j[n4] = n3 + 1;
                }
                n2 = n3 + 1;
            }
            n3 = n2;
        }
        J2.b.d(this.g, n3, n2);
        if (objectArray != null) {
            J2.b.d(objectArray, n3, this.l);
        }
        this.l = n3;
    }

    private final boolean o(Map map) {
        return this.size() == map.size() && this.m((Collection)map.entrySet());
    }

    private final void p(int n2) {
        if (n2 >= 0) {
            if (n2 > this.u()) {
                n2 = I2.c.g.e(this.u(), n2);
                this.g = J2.b.b(this.g, n2);
                Object object = this.h;
                object = object != null ? J2.b.b(object, n2) : null;
                this.h = object;
                object = Arrays.copyOf((int[])this.i, (int)n2);
                V2.k.d((Object)object, (String)"copyOf(...)");
                this.i = (int[])object;
                n2 = c.t.c(n2);
                if (n2 > this.w()) {
                    this.G(n2);
                }
            }
            return;
        }
        throw new OutOfMemoryError();
    }

    private final void q(int n2) {
        if (this.M(n2)) {
            this.l(true);
            return;
        }
        this.p(this.l + n2);
    }

    private final int s(Object object) {
        int n2 = this.A(object);
        int n3 = this.k;
        int n4;
        while ((n4 = this.j[n2]) != 0) {
            Object[] objectArray;
            if (n4 > 0 && V2.k.a((Object)(objectArray = this.g)[--n4], (Object)object)) {
                return n4;
            }
            if (--n3 < 0) {
                return -1;
            }
            if (n2 == 0) {
                n2 = this.w() - 1;
                continue;
            }
            --n2;
        }
        return -1;
    }

    private final int t(Object object) {
        int n2;
        int n3 = this.l;
        while ((n2 = n3 - 1) >= 0) {
            n3 = n2;
            if (this.i[n2] < 0) continue;
            Object[] objectArray = this.h;
            V2.k.b((Object)objectArray);
            n3 = n2;
            if (!V2.k.a((Object)objectArray[n2], (Object)object)) continue;
            return n2;
        }
        return -1;
    }

    private final int w() {
        return this.j.length;
    }

    public final e B() {
        return new e(this);
    }

    public final boolean H(Map.Entry entry) {
        V2.k.e((Object)entry, (String)"entry");
        this.k();
        int n2 = this.s(entry.getKey());
        if (n2 < 0) {
            return false;
        }
        Object[] objectArray = this.h;
        V2.k.b((Object)objectArray);
        if (!V2.k.a((Object)objectArray[n2], (Object)entry.getValue())) {
            return false;
        }
        this.I(n2);
        return true;
    }

    public final boolean K(Object object) {
        this.k();
        int n2 = this.s(object);
        if (n2 < 0) {
            return false;
        }
        this.I(n2);
        return true;
    }

    public final boolean L(Object object) {
        this.k();
        int n2 = this.t(object);
        if (n2 < 0) {
            return false;
        }
        this.I(n2);
        return true;
    }

    public final f N() {
        return new f(this);
    }

    public void clear() {
        Object[] objectArray;
        this.k();
        int n2 = this.l - 1;
        if (n2 >= 0) {
            int n3 = 0;
            while (true) {
                int n4;
                if ((n4 = (objectArray = this.i)[n3]) >= 0) {
                    this.j[n4] = 0;
                    objectArray[n3] = -1;
                }
                if (n3 == n2) break;
                ++n3;
            }
        }
        J2.b.d(this.g, 0, this.l);
        objectArray = this.h;
        if (objectArray != null) {
            J2.b.d(objectArray, 0, this.l);
        }
        this.o = 0;
        this.l = 0;
        this.F();
    }

    public boolean containsKey(Object object) {
        return this.s(object) >= 0;
    }

    public boolean containsValue(Object object) {
        return this.t(object) >= 0;
    }

    public boolean equals(Object object) {
        return object == this || object instanceof Map && this.o((Map)object);
        {
        }
    }

    public Object get(Object objectArray) {
        int n2 = this.s(objectArray);
        if (n2 < 0) {
            return null;
        }
        objectArray = this.h;
        V2.k.b((Object)objectArray);
        return objectArray[n2];
    }

    public final int h(Object object) {
        this.k();
        block0: while (true) {
            int n2 = this.A(object);
            int n3 = Y2.d.c((int)(this.k * 2), (int)(this.w() / 2));
            int n4 = 0;
            while (true) {
                int n5;
                if ((n5 = this.j[n2]) <= 0) {
                    if (this.l >= this.u()) {
                        this.q(1);
                        continue block0;
                    }
                    n3 = this.l;
                    this.l = n5 = n3 + 1;
                    this.g[n3] = object;
                    this.i[n3] = n2;
                    this.j[n2] = n5;
                    this.o = this.size() + 1;
                    this.F();
                    if (n4 > this.k) {
                        this.k = n4;
                    }
                    return n3;
                }
                if (V2.k.a((Object)this.g[n5 - 1], (Object)object)) {
                    return -n5;
                }
                if (++n4 > n3) {
                    this.G(this.w() * 2);
                    continue block0;
                }
                if (n2 == 0) {
                    n2 = this.w() - 1;
                    continue;
                }
                --n2;
            }
            break;
        }
    }

    public int hashCode() {
        b b2 = this.r();
        int n2 = 0;
        while (b2.hasNext()) {
            n2 += b2.k();
        }
        return n2;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public final Map j() {
        this.k();
        this.s = true;
        if (this.size() > 0) {
            return this;
        }
        c c2 = u;
        V2.k.c((Object)c2, (String)"null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return c2;
    }

    public final void k() {
        if (!this.s) {
            return;
        }
        throw new UnsupportedOperationException();
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean m(Collection object) {
        V2.k.e((Object)object, (String)"m");
        for (Object object2 : object) {
            if (object2 != null) {
                boolean bl = this.n((Map.Entry)object2);
                if (bl) continue;
            }
            return false;
        }
        return true;
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public final boolean n(Map.Entry entry) {
        V2.k.e((Object)entry, (String)"entry");
        int n2 = this.s(entry.getKey());
        if (n2 < 0) {
            return false;
        }
        Object[] objectArray = this.h;
        V2.k.b((Object)objectArray);
        return V2.k.a((Object)objectArray[n2], (Object)entry.getValue());
    }

    public Object put(Object object, Object object2) {
        this.k();
        int n2 = this.h(object);
        Object[] objectArray = this.i();
        if (n2 < 0) {
            n2 = -n2 - 1;
            object = objectArray[n2];
            objectArray[n2] = object2;
            return object;
        }
        objectArray[n2] = object2;
        return null;
    }

    public void putAll(Map map) {
        V2.k.e((Object)map, (String)"from");
        this.k();
        this.C((Collection)map.entrySet());
    }

    public final b r() {
        return new b(this);
    }

    public Object remove(Object object) {
        this.k();
        int n2 = this.s(object);
        if (n2 < 0) {
            return null;
        }
        object = this.h;
        V2.k.b((Object)object);
        object = object[n2];
        this.I(n2);
        return object;
    }

    public String toString() {
        Object object = new StringBuilder(this.size() * 3 + 2);
        object.append("{");
        b b2 = this.r();
        int n2 = 0;
        while (b2.hasNext()) {
            if (n2 > 0) {
                object.append(", ");
            }
            b2.j((StringBuilder)object);
            ++n2;
        }
        object.append("}");
        object = object.toString();
        V2.k.d((Object)object, (String)"toString(...)");
        return object;
    }

    public final int u() {
        return this.g.length;
    }

    public Set v() {
        J2.d d2;
        J2.d d3 = d2 = this.r;
        if (d2 == null) {
            this.r = d3 = new J2.d(this);
        }
        return d3;
    }

    public Set x() {
        J2.e e2;
        J2.e e3 = e2 = this.p;
        if (e2 == null) {
            this.p = e3 = new J2.e(this);
        }
        return e3;
    }

    public int y() {
        return this.o;
    }

    public Collection z() {
        J2.f f2;
        J2.f f3 = f2 = this.q;
        if (f2 == null) {
            this.q = f3 = new J2.f(this);
        }
        return f3;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        private final int c(int n2) {
            return Integer.highestOneBit((int)(Y2.d.b((int)n2, (int)1) * 3));
        }

        private final int d(int n2) {
            return Integer.numberOfLeadingZeros((int)n2) + 1;
        }
    }

    public static final class b
    extends d
    implements Iterator {
        public b(c c2) {
            V2.k.e((Object)c2, (String)"map");
            super(c2);
        }

        public c i() {
            this.b();
            if (this.c() < this.e().l) {
                int n2 = this.c();
                this.g(n2 + 1);
                this.h(n2);
                c c2 = new c(this.e(), this.d());
                this.f();
                return c2;
            }
            throw new NoSuchElementException();
        }

        public final void j(StringBuilder stringBuilder) {
            V2.k.e((Object)stringBuilder, (String)"sb");
            if (this.c() < this.e().l) {
                int n2 = this.c();
                this.g(n2 + 1);
                this.h(n2);
                Object object = this.e().g[this.d()];
                if (object == this.e()) {
                    stringBuilder.append("(this Map)");
                } else {
                    stringBuilder.append(object);
                }
                stringBuilder.append('=');
                object = this.e().h;
                V2.k.b((Object)object);
                object = object[this.d()];
                if (object == this.e()) {
                    stringBuilder.append("(this Map)");
                } else {
                    stringBuilder.append(object);
                }
                this.f();
                return;
            }
            throw new NoSuchElementException();
        }

        public final int k() {
            if (this.c() < this.e().l) {
                int n2 = this.c();
                this.g(n2 + 1);
                this.h(n2);
                Object object = this.e().g[this.d()];
                int n3 = 0;
                n2 = object != null ? object.hashCode() : 0;
                object = this.e().h;
                V2.k.b((Object)object);
                object = object[this.d()];
                if (object != null) {
                    n3 = object.hashCode();
                }
                this.f();
                return n2 ^ n3;
            }
            throw new NoSuchElementException();
        }
    }

    public static final class c
    implements Map.Entry {
        private final c g;
        private final int h;
        private final int i;

        public c(c c2, int n2) {
            V2.k.e((Object)c2, (String)"map");
            this.g = c2;
            this.h = n2;
            this.i = c2.n;
        }

        private final void a() {
            if (this.g.n == this.i) {
                return;
            }
            throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
        }

        public boolean equals(Object object) {
            return object instanceof Map.Entry && V2.k.a((Object)(object = (Map.Entry)object).getKey(), (Object)this.getKey()) && V2.k.a((Object)object.getValue(), (Object)this.getValue());
        }

        public Object getKey() {
            this.a();
            return this.g.g[this.h];
        }

        public Object getValue() {
            this.a();
            Object[] objectArray = this.g.h;
            V2.k.b((Object)objectArray);
            return objectArray[this.h];
        }

        public int hashCode() {
            Object object = this.getKey();
            int n2 = 0;
            int n3 = object != null ? object.hashCode() : 0;
            object = this.getValue();
            if (object != null) {
                n2 = object.hashCode();
            }
            return n3 ^ n2;
        }

        public Object setValue(Object object) {
            this.a();
            this.g.k();
            Object[] objectArray = this.g.i();
            int n2 = this.h;
            Object object2 = objectArray[n2];
            objectArray[n2] = object;
            return object2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getKey());
            stringBuilder.append('=');
            stringBuilder.append(this.getValue());
            return stringBuilder.toString();
        }
    }

    public static abstract class d {
        private final c g;
        private int h;
        private int i;
        private int j;

        public d(c c2) {
            V2.k.e((Object)c2, (String)"map");
            this.g = c2;
            this.i = -1;
            this.j = c2.n;
            this.f();
        }

        public final void b() {
            if (this.g.n == this.j) {
                return;
            }
            throw new ConcurrentModificationException();
        }

        public final int c() {
            return this.h;
        }

        public final int d() {
            return this.i;
        }

        public final c e() {
            return this.g;
        }

        public final void f() {
            int n2;
            int[] nArray;
            while (this.h < this.g.l && (nArray = this.g.i)[n2 = this.h] < 0) {
                this.h = n2 + 1;
            }
        }

        public final void g(int n2) {
            this.h = n2;
        }

        public final void h(int n2) {
            this.i = n2;
        }

        public final boolean hasNext() {
            return this.h < this.g.l;
        }

        public final void remove() {
            this.b();
            if (this.i != -1) {
                this.g.k();
                this.g.I(this.i);
                this.i = -1;
                this.j = this.g.n;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
    }

    public static final class e
    extends d
    implements Iterator {
        public e(c c2) {
            V2.k.e((Object)c2, (String)"map");
            super(c2);
        }

        public Object next() {
            this.b();
            if (this.c() < this.e().l) {
                int n2 = this.c();
                this.g(n2 + 1);
                this.h(n2);
                Object object = this.e().g[this.d()];
                this.f();
                return object;
            }
            throw new NoSuchElementException();
        }
    }

    public static final class f
    extends d
    implements Iterator {
        public f(c c2) {
            V2.k.e((Object)c2, (String)"map");
            super(c2);
        }

        public Object next() {
            this.b();
            if (this.c() < this.e().l) {
                int n2 = this.c();
                this.g(n2 + 1);
                this.h(n2);
                Object object = this.e().h;
                V2.k.b((Object)object);
                object = object[this.d()];
                this.f();
                return object;
            }
            throw new NoSuchElementException();
        }
    }
}

