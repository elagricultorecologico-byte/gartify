/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.util.Iterator
 *  java.util.NoSuchElementException
 */
package p;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class e
implements Iterator {
    private int g;
    private int h;
    private boolean i;

    public e(int n2) {
        this.g = n2;
    }

    protected abstract Object b(int var1);

    protected abstract void c(int var1);

    public boolean hasNext() {
        return this.h < this.g;
    }

    public Object next() {
        if (this.hasNext()) {
            Object object = this.b(this.h);
            ++this.h;
            this.i = true;
            return object;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        if (this.i) {
            int n2;
            this.h = n2 = this.h - 1;
            this.c(n2);
            --this.g;
            this.i = false;
            return;
        }
        throw new IllegalStateException("Call next() before removing an element.");
    }
}

