/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.BufferedInputStream
 *  java.io.ByteArrayOutputStream
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.System
 *  java.lang.Thread
 *  java.net.SocketTimeoutException
 *  java.nio.ByteBuffer
 */
package E3;

import D3.e;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;

public final class a
extends BufferedInputStream {
    private final boolean g;
    private final int h;
    private long i;
    private long j = 0L;
    private int k;
    private boolean l;

    private a(InputStream inputStream, int n2, int n3) {
        super(inputStream, n2);
        boolean bl = false;
        boolean bl2 = n3 >= 0;
        e.d(bl2);
        this.h = n3;
        this.k = n3;
        bl2 = bl;
        if (n3 != 0) {
            bl2 = true;
        }
        this.g = bl2;
        this.i = System.nanoTime();
    }

    private boolean a() {
        if (this.j == 0L) {
            return false;
        }
        return System.nanoTime() - this.i > this.j;
    }

    public static a j(InputStream inputStream, int n2, int n3) {
        if (inputStream instanceof a) {
            return (a)inputStream;
        }
        return new a(inputStream, n2, n3);
    }

    public ByteBuffer f(int n2) {
        int n3;
        boolean bl = true;
        boolean bl2 = n2 >= 0;
        e.e(bl2, "maxSize must be 0 (unlimited) or larger");
        if (n2 <= 0) {
            bl = false;
        }
        int n4 = n3 = 32768;
        if (bl) {
            n4 = n3;
            if (n2 < 32768) {
                n4 = n2;
            }
        }
        byte[] byArray = new byte[n4];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(n4);
        while (true) {
            block8: {
                block9: {
                    block7: {
                        if ((n3 = this.read(byArray)) == -1) break block7;
                        n4 = n2;
                        if (!bl) break block8;
                        if (n3 < n2) break block9;
                        byteArrayOutputStream.write(byArray, 0, n2);
                    }
                    return ByteBuffer.wrap((byte[])byteArrayOutputStream.toByteArray());
                }
                n4 = n2 - n3;
            }
            byteArrayOutputStream.write(byArray, 0, n3);
            n2 = n4;
        }
    }

    public a i(long l2, long l3) {
        this.i = l2;
        this.j = l3 * 1000000L;
        return this;
    }

    public int read(byte[] byArray, int n2, int n3) {
        if (!(this.l || this.g && this.k <= 0)) {
            if (Thread.interrupted()) {
                this.l = true;
                return -1;
            }
            if (!this.a()) {
                int n4 = n3;
                if (this.g) {
                    int n5 = this.k;
                    n4 = n3;
                    if (n3 > n5) {
                        n4 = n5;
                    }
                }
                try {
                    n2 = super.read(byArray, n2, n4);
                    this.k -= n2;
                    return n2;
                }
                catch (SocketTimeoutException socketTimeoutException) {
                    return 0;
                }
            }
            throw new SocketTimeoutException("Read timeout");
        }
        return -1;
    }

    public void reset() {
        super.reset();
        this.k = this.h - this.markpos;
    }
}

