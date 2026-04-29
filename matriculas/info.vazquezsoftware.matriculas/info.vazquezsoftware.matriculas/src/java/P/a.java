/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.lang.reflect.Array
 *  java.util.AbstractSet
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.NoSuchElementException
 *  java.util.Set
 */
package p;

import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import p.i;

public class a
extends i
implements Map {
    a j;
    c k;
    e l;

    public a() {
    }

    public a(int n2) {
        super(n2);
    }

    public a(i i2) {
        super(i2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static boolean l(Set set, Object object) {
        if (set == object) {
            return true;
        }
        if (!(object instanceof Set)) return false;
        object = (Set)object;
        try {
            if (set.size() != object.size()) return false;
            boolean bl = set.containsAll((Collection)object);
            if (!bl) return false;
            return true;
        }
        catch (ClassCastException | NullPointerException throwable) {
            return false;
        }
    }

    @Override
    public boolean containsKey(Object object) {
        return super.containsKey(object);
    }

    @Override
    public boolean containsValue(Object object) {
        return super.containsValue(object);
    }

    public Set entrySet() {
        a a2;
        a a3 = a2 = this.j;
        if (a2 == null) {
            this.j = a3 = new a(this);
        }
        return a3;
    }

    @Override
    public Object get(Object object) {
        return super.get(object);
    }

    public boolean k(Collection collection) {
        collection = collection.iterator();
        while (collection.hasNext()) {
            if (this.containsKey(collection.next())) continue;
            return false;
        }
        return true;
    }

    public Set keySet() {
        c c3;
        c c4 = c3 = this.k;
        if (c3 == null) {
            this.k = c4 = new c(this);
        }
        return c4;
    }

    public boolean m(Collection collection) {
        int n2 = this.size();
        collection = collection.iterator();
        while (collection.hasNext()) {
            this.remove(collection.next());
        }
        return n2 != this.size();
    }

    public boolean n(Collection collection) {
        int n2 = this.size();
        for (int i2 = this.size() - 1; i2 >= 0; --i2) {
            if (collection.contains(this.f(i2))) continue;
            this.h(i2);
        }
        return n2 != this.size();
    }

    public void putAll(Map map) {
        this.b(this.size() + map.size());
        for (Map.Entry entry : map.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public Object remove(Object object) {
        return super.remove(object);
    }

    public Collection values() {
        e e2;
        e e3 = e2 = this.l;
        if (e2 == null) {
            this.l = e3 = new e(this);
        }
        return e3;
    }

    final class a
    extends AbstractSet {
        final a g;

        a(a a2) {
            this.g = a2;
        }

        public Iterator iterator() {
            return new d(this.g);
        }

        public int size() {
            return this.g.size();
        }
    }

    final class b
    extends p.e {
        final a j;

        b(a a2) {
            this.j = a2;
            super(a2.size());
        }

        @Override
        protected Object b(int n2) {
            return this.j.f(n2);
        }

        @Override
        protected void c(int n2) {
            this.j.h(n2);
        }
    }

    final class c
    implements Set {
        final a g;

        c(a a2) {
            this.g = a2;
        }

        public boolean add(Object object) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.g.clear();
        }

        public boolean contains(Object object) {
            return this.g.containsKey(object);
        }

        public boolean containsAll(Collection collection) {
            return this.g.k(collection);
        }

        public boolean equals(Object object) {
            return a.l(this, object);
        }

        public int hashCode() {
            int n2 = 0;
            for (int i2 = this.g.size() - 1; i2 >= 0; --i2) {
                Object object = this.g.f(i2);
                int n3 = object == null ? 0 : object.hashCode();
                n2 += n3;
            }
            return n2;
        }

        public boolean isEmpty() {
            return this.g.isEmpty();
        }

        public Iterator iterator() {
            return new b(this.g);
        }

        public boolean remove(Object object) {
            int n2 = this.g.d(object);
            if (n2 >= 0) {
                this.g.h(n2);
                return true;
            }
            return false;
        }

        public boolean removeAll(Collection collection) {
            return this.g.m(collection);
        }

        public boolean retainAll(Collection collection) {
            return this.g.n(collection);
        }

        public int size() {
            return this.g.size();
        }

        public Object[] toArray() {
            int n2 = this.g.size();
            Object[] objectArray = new Object[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                objectArray[i2] = this.g.f(i2);
            }
            return objectArray;
        }

        public Object[] toArray(Object[] objectArray) {
            int n2 = this.size();
            Object[] objectArray2 = objectArray;
            if (objectArray.length < n2) {
                objectArray2 = (Object[])Array.newInstance((Class)objectArray.getClass().getComponentType(), (int)n2);
            }
            for (int i2 = 0; i2 < n2; ++i2) {
                objectArray2[i2] = this.g.f(i2);
            }
            if (objectArray2.length > n2) {
                objectArray2[n2] = null;
            }
            return objectArray2;
        }
    }

    final class d
    implements Iterator,
    Map.Entry {
        int g;
        int h;
        boolean i;
        final a j;

        d(a a2) {
            this.j = a2;
            this.g = a2.size() - 1;
            this.h = -1;
        }

        public Map.Entry b() {
            if (this.hasNext()) {
                ++this.h;
                this.i = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public boolean equals(Object object) {
            if (this.i) {
                if (!(object instanceof Map.Entry)) {
                    return false;
                }
                return q.a.c((object = (Map.Entry)object).getKey(), this.j.f(this.h)) && q.a.c(object.getValue(), this.j.j(this.h));
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public Object getKey() {
            if (this.i) {
                return this.j.f(this.h);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public Object getValue() {
            if (this.i) {
                return this.j.j(this.h);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.h < this.g;
        }

        public int hashCode() {
            if (this.i) {
                Object object = this.j.f(this.h);
                Object object2 = this.j.j(this.h);
                int n2 = 0;
                int n3 = object == null ? 0 : object.hashCode();
                if (object2 != null) {
                    n2 = object2.hashCode();
                }
                return n3 ^ n2;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public void remove() {
            if (this.i) {
                this.j.h(this.h);
                --this.h;
                --this.g;
                this.i = false;
                return;
            }
            throw new IllegalStateException();
        }

        public Object setValue(Object object) {
            if (this.i) {
                return this.j.i(this.h, object);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getKey());
            stringBuilder.append("=");
            stringBuilder.append(this.getValue());
            return stringBuilder.toString();
        }
    }

    final class e
    implements Collection {
        final a g;

        e(a a2) {
            this.g = a2;
        }

        public boolean add(Object object) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.g.clear();
        }

        public boolean contains(Object object) {
            return this.g.a(object) >= 0;
        }

        public boolean containsAll(Collection collection) {
            collection = collection.iterator();
            while (collection.hasNext()) {
                if (this.contains(collection.next())) continue;
                return false;
            }
            return true;
        }

        public boolean isEmpty() {
            return this.g.isEmpty();
        }

        public Iterator iterator() {
            return new f(this.g);
        }

        public boolean remove(Object object) {
            int n2 = this.g.a(object);
            if (n2 >= 0) {
                this.g.h(n2);
                return true;
            }
            return false;
        }

        public boolean removeAll(Collection collection) {
            int n2 = this.g.size();
            int n3 = 0;
            boolean bl = false;
            while (n3 < n2) {
                int n4 = n2;
                int n5 = n3;
                if (collection.contains(this.g.j(n3))) {
                    this.g.h(n3);
                    n5 = n3 - 1;
                    n4 = n2 - 1;
                    bl = true;
                }
                n3 = n5 + 1;
                n2 = n4;
            }
            return bl;
        }

        public boolean retainAll(Collection collection) {
            int n2 = this.g.size();
            int n3 = 0;
            boolean bl = false;
            while (n3 < n2) {
                int n4 = n2;
                int n5 = n3;
                if (!collection.contains(this.g.j(n3))) {
                    this.g.h(n3);
                    n5 = n3 - 1;
                    n4 = n2 - 1;
                    bl = true;
                }
                n3 = n5 + 1;
                n2 = n4;
            }
            return bl;
        }

        public int size() {
            return this.g.size();
        }

        public Object[] toArray() {
            int n2 = this.g.size();
            Object[] objectArray = new Object[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                objectArray[i2] = this.g.j(i2);
            }
            return objectArray;
        }

        public Object[] toArray(Object[] objectArray) {
            int n2 = this.size();
            Object[] objectArray2 = objectArray;
            if (objectArray.length < n2) {
                objectArray2 = (Object[])Array.newInstance((Class)objectArray.getClass().getComponentType(), (int)n2);
            }
            for (int i2 = 0; i2 < n2; ++i2) {
                objectArray2[i2] = this.g.j(i2);
            }
            if (objectArray2.length > n2) {
                objectArray2[n2] = null;
            }
            return objectArray2;
        }
    }

    final class f
    extends p.e {
        final a j;

        f(a a2) {
            this.j = a2;
            super(a2.size());
        }

        @Override
        protected Object b(int n2) {
            return this.j.j(n2);
        }

        @Override
        protected void c(int n2) {
            this.j.h(n2);
        }
    }
}

