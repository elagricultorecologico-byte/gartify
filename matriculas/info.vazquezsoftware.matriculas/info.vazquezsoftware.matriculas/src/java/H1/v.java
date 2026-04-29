/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.NoSuchElementException
 */
package H1;

import H1.m;
import H1.s;
import java.util.NoSuchElementException;

abstract class v
extends m {
    private final int g;
    private int h;

    protected v(int n2, int n3) {
        s.c(n3, n2, "index");
        this.g = n2;
        this.h = n3;
    }

    protected abstract Object b(int var1);

    public final boolean hasNext() {
        return this.h < this.g;
    }

    public final boolean hasPrevious() {
        return this.h > 0;
    }

    public final Object next() {
        if (this.hasNext()) {
            int n2 = this.h;
            this.h = n2 + 1;
            return this.b(n2);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.h;
    }

    public final Object previous() {
        if (this.hasPrevious()) {
            int n2;
            this.h = n2 = this.h - 1;
            return this.b(n2);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.h - 1;
    }
}

