/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.Throwable
 */
package r3;

import H2.a;
import V2.k;
import java.io.IOException;

public final class i
extends RuntimeException {
    private final IOException g;
    private IOException h;

    public i(IOException iOException) {
        k.e((Object)iOException, "firstConnectException");
        super((Throwable)iOException);
        this.g = iOException;
        this.h = iOException;
    }

    public final void a(IOException iOException) {
        k.e((Object)iOException, "e");
        a.a(this.g, iOException);
        this.h = iOException;
    }

    public final IOException b() {
        return this.g;
    }

    public final IOException c() {
        return this.h;
    }
}

