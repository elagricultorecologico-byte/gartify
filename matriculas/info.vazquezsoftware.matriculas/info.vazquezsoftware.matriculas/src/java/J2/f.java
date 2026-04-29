/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  V2.k
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Collection
 *  java.util.Iterator
 */
package J2;

import I2.d;
import J2.c;
import V2.k;
import java.util.Collection;
import java.util.Iterator;

public final class f
extends d
implements Collection {
    private final c g;

    public f(c c2) {
        k.e((Object)c2, (String)"backing");
        this.g = c2;
    }

    public boolean add(Object object) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        k.e((Object)collection, (String)"elements");
        throw new UnsupportedOperationException();
    }

    @Override
    public int c() {
        return this.g.size();
    }

    public void clear() {
        this.g.clear();
    }

    public boolean contains(Object object) {
        return this.g.containsValue(object);
    }

    public boolean isEmpty() {
        return this.g.isEmpty();
    }

    public Iterator iterator() {
        return this.g.N();
    }

    public boolean remove(Object object) {
        return this.g.L(object);
    }

    public boolean removeAll(Collection collection) {
        k.e((Object)collection, (String)"elements");
        this.g.k();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        k.e((Object)collection, (String)"elements");
        this.g.k();
        return super.retainAll(collection);
    }
}

