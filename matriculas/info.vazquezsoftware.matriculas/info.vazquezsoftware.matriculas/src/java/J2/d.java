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
 *  java.util.Map$Entry
 */
package J2;

import J2.a;
import J2.c;
import V2.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class d
extends a {
    private final c g;

    public d(c c2) {
        k.e((Object)c2, (String)"backing");
        this.g = c2;
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

    public boolean containsAll(Collection collection) {
        k.e((Object)collection, (String)"elements");
        return this.g.m(collection);
    }

    @Override
    public boolean h(Map.Entry entry) {
        k.e((Object)entry, (String)"element");
        return this.g.n(entry);
    }

    @Override
    public boolean i(Map.Entry entry) {
        k.e((Object)entry, (String)"element");
        return this.g.H(entry);
    }

    public boolean isEmpty() {
        return this.g.isEmpty();
    }

    public Iterator iterator() {
        return this.g.r();
    }

    public boolean j(Map.Entry entry) {
        k.e((Object)entry, (String)"element");
        throw new UnsupportedOperationException();
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

