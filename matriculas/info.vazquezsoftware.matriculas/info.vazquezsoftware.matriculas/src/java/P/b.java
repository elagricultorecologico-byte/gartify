/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.ClassCastException
 *  java.lang.Iterable
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collection
 *  java.util.ConcurrentModificationException
 *  java.util.Iterator
 *  java.util.Set
 */
package p;

import I2.i;
import I2.o;
import V2.g;
import V2.k;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import p.c;
import p.d;
import p.e;

public final class b
implements Collection,
Set {
    private int[] g;
    private Object[] h;
    private int i;

    public b() {
        this(0, 1, null);
    }

    public b(int n2) {
        this.g = q.a.a;
        this.h = q.a.c;
        if (n2 > 0) {
            d.a(this, n2);
        }
    }

    public /* synthetic */ b(int n2, int n3, g g2) {
        if ((n3 & 1) != 0) {
            n2 = 0;
        }
        this(n2);
    }

    public boolean add(Object object) {
        Object[] objectArray;
        int[] nArray;
        int n2;
        int n3;
        int n4 = this.j();
        int n5 = 0;
        if (object == null) {
            n3 = d.d(this);
            n2 = 0;
        } else {
            n2 = object.hashCode();
            n3 = d.c(this, object, n2);
        }
        if (n3 >= 0) {
            return false;
        }
        int n6 = ~n3;
        if (n4 >= this.h().length) {
            n3 = 8;
            if (n4 >= 8) {
                n3 = (n4 >> 1) + n4;
            } else if (n4 < 4) {
                n3 = 4;
            }
            nArray = this.h();
            objectArray = this.f();
            d.a(this, n3);
            if (n4 == this.j()) {
                n3 = n5;
                if (this.h().length == 0) {
                    n3 = 1;
                }
                if (n3 == 0) {
                    I2.i.i(nArray, this.h(), 0, 0, nArray.length, 6, null);
                    I2.i.j(objectArray, this.f(), 0, 0, objectArray.length, 6, null);
                }
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (n6 < n4) {
            objectArray = this.h();
            nArray = this.h();
            n3 = n6 + 1;
            I2.i.e(objectArray, nArray, n3, n6, n4);
            I2.i.g(this.f(), this.f(), n3, n6, n4);
        }
        if (n4 == this.j() && n6 < this.h().length) {
            this.h()[n6] = n2;
            this.f()[n6] = object;
            this.n(this.j() + 1);
            return true;
        }
        throw new ConcurrentModificationException();
    }

    public boolean addAll(Collection collection) {
        k.e(collection, "elements");
        this.c(this.j() + collection.size());
        collection = collection.iterator();
        boolean bl = false;
        while (collection.hasNext()) {
            bl |= this.add(collection.next());
        }
        return bl;
    }

    public final void c(int n2) {
        int n3 = this.j();
        if (this.h().length < n2) {
            int[] nArray = this.h();
            Object[] objectArray = this.f();
            d.a(this, n2);
            if (this.j() > 0) {
                I2.i.i(nArray, this.h(), 0, 0, this.j(), 6, null);
                I2.i.j(objectArray, this.f(), 0, 0, this.j(), 6, null);
            }
        }
        if (this.j() == n3) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    public void clear() {
        if (this.j() != 0) {
            this.m(q.a.a);
            this.l(q.a.c);
            this.n(0);
        }
        if (this.j() == 0) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    public boolean contains(Object object) {
        return this.indexOf(object) >= 0;
    }

    public boolean containsAll(Collection collection) {
        k.e(collection, "elements");
        collection = collection.iterator();
        while (collection.hasNext()) {
            if (this.contains(collection.next())) continue;
            return false;
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Set)) return false;
        if (this.size() != ((Set)object).size()) {
            return false;
        }
        try {
            int n2 = this.j();
            int i2 = 0;
            while (i2 < n2) {
                Object object2 = this.o(i2);
                boolean bl = ((Set)object).contains(object2);
                if (!bl) {
                    return false;
                }
                ++i2;
            }
            return true;
        }
        catch (ClassCastException | NullPointerException throwable) {
            return false;
        }
    }

    public final Object[] f() {
        return this.h;
    }

    public final int[] h() {
        return this.g;
    }

    public int hashCode() {
        int[] nArray = this.h();
        int n2 = this.j();
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            n3 += nArray[i2];
        }
        return n3;
    }

    public int i() {
        return this.i;
    }

    public final int indexOf(Object object) {
        if (object == null) {
            return d.d(this);
        }
        return d.c(this, object, object.hashCode());
    }

    public boolean isEmpty() {
        return this.j() <= 0;
    }

    public Iterator iterator() {
        return new a(this);
    }

    public final int j() {
        return this.i;
    }

    public final Object k(int n2) {
        int n3 = this.j();
        Object object = this.f()[n2];
        if (n3 <= 1) {
            this.clear();
            return object;
        }
        int n4 = n3 - 1;
        int n5 = this.h().length;
        int n6 = 8;
        if (n5 > 8 && this.j() < this.h().length / 3) {
            if (this.j() > 8) {
                n6 = this.j() + (this.j() >> 1);
            }
            int[] nArray = this.h();
            Object[] objectArray = this.f();
            d.a(this, n6);
            if (n2 > 0) {
                I2.i.i(nArray, this.h(), 0, 0, n2, 6, null);
                I2.i.j(objectArray, this.f(), 0, 0, n2, 6, null);
            }
            if (n2 < n4) {
                int[] nArray2 = this.h();
                n6 = n2 + 1;
                I2.i.e(nArray, nArray2, n2, n6, n3);
                I2.i.g(objectArray, this.f(), n2, n6, n3);
            }
        } else {
            if (n2 < n4) {
                int[] nArray = this.h();
                int[] nArray3 = this.h();
                n6 = n2 + 1;
                I2.i.e(nArray, nArray3, n2, n6, n3);
                I2.i.g(this.f(), this.f(), n2, n6, n3);
            }
            this.f()[n4] = null;
        }
        if (n3 == this.j()) {
            this.n(n4);
            return object;
        }
        throw new ConcurrentModificationException();
    }

    public final void l(Object[] objectArray) {
        k.e(objectArray, "<set-?>");
        this.h = objectArray;
    }

    public final void m(int[] nArray) {
        k.e(nArray, "<set-?>");
        this.g = nArray;
    }

    public final void n(int n2) {
        this.i = n2;
    }

    public final Object o(int n2) {
        return this.f()[n2];
    }

    public boolean remove(Object object) {
        int n2 = this.indexOf(object);
        if (n2 >= 0) {
            this.k(n2);
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection collection) {
        k.e(collection, "elements");
        collection = collection.iterator();
        boolean bl = false;
        while (collection.hasNext()) {
            bl |= this.remove(collection.next());
        }
        return bl;
    }

    public boolean retainAll(Collection collection) {
        k.e(collection, "elements");
        boolean bl = false;
        for (int i2 = this.j() - 1; -1 < i2; --i2) {
            if (o.t((Iterable)collection, this.f()[i2])) continue;
            this.k(i2);
            bl = true;
        }
        return bl;
    }

    public final Object[] toArray() {
        return I2.i.l(this.h, 0, this.i);
    }

    public final Object[] toArray(Object[] objectArray) {
        k.e(objectArray, "array");
        objectArray = c.a(objectArray, this.i);
        I2.i.g(this.h, objectArray, 0, 0, this.i);
        k.d(objectArray, "result");
        return objectArray;
    }

    public String toString() {
        Object object;
        if (this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.j() * 14);
        stringBuilder.append('{');
        int n2 = this.j();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (i2 > 0) {
                stringBuilder.append(", ");
            }
            if ((object = this.o(i2)) != this) {
                stringBuilder.append(object);
                continue;
            }
            stringBuilder.append("(this Set)");
        }
        stringBuilder.append('}');
        object = stringBuilder.toString();
        k.d(object, "StringBuilder(capacity).\u2026builderAction).toString()");
        return object;
    }

    private final class a
    extends e {
        final b j;

        public a(b b2) {
            this.j = b2;
            super(b2.j());
        }

        @Override
        protected Object b(int n2) {
            return this.j.o(n2);
        }

        @Override
        protected void c(int n2) {
            this.j.k(n2);
        }
    }
}

