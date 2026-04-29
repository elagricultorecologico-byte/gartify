/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.UnsupportedOperationException
 *  java.lang.Void
 *  java.util.ListIterator
 *  java.util.NoSuchElementException
 */
package I2;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public final class z
implements ListIterator {
    public static final z g = new z();

    private z() {
    }

    public Void b() {
        throw new NoSuchElementException();
    }

    public Void c() {
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        return false;
    }

    public boolean hasPrevious() {
        return false;
    }

    public int nextIndex() {
        return 0;
    }

    public int previousIndex() {
        return -1;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

