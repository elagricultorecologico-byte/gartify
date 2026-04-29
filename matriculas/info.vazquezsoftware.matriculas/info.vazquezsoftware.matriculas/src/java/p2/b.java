/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.OutputStream
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 */
package p2;

import java.io.OutputStream;

final class b
extends OutputStream {
    private long g = 0L;

    b() {
    }

    long a() {
        return this.g;
    }

    public void write(int n2) {
        ++this.g;
    }

    public void write(byte[] byArray) {
        this.g += (long)byArray.length;
    }

    public void write(byte[] byArray, int n2, int n3) {
        if (n2 >= 0 && n2 <= byArray.length && n3 >= 0 && (n2 += n3) <= byArray.length && n2 >= 0) {
            this.g += (long)n3;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}

