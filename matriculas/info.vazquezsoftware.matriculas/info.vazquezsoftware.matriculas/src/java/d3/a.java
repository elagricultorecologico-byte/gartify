/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collection
 */
package D3;

import java.util.ArrayList;
import java.util.Collection;

public abstract class a
extends ArrayList {
    public a(int n2) {
        super(n2);
    }

    public void add(int n2, Object object) {
        this.c();
        super.add(n2, object);
    }

    public boolean add(Object object) {
        this.c();
        return super.add(object);
    }

    public boolean addAll(int n2, Collection collection) {
        this.c();
        return super.addAll(n2, collection);
    }

    public boolean addAll(Collection collection) {
        this.c();
        return super.addAll(collection);
    }

    public abstract void c();

    public void clear() {
        this.c();
        super.clear();
    }

    public Object remove(int n2) {
        this.c();
        return super.remove(n2);
    }

    public boolean remove(Object object) {
        this.c();
        return super.remove(object);
    }

    public boolean removeAll(Collection collection) {
        this.c();
        return super.removeAll(collection);
    }

    protected void removeRange(int n2, int n3) {
        this.c();
        super.removeRange(n2, n3);
    }

    public boolean retainAll(Collection collection) {
        this.c();
        return super.retainAll(collection);
    }

    public Object set(int n2, Object object) {
        this.c();
        return super.set(n2, object);
    }
}

