/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.Throwable
 */
package C3;

import java.io.IOException;

public class e
extends RuntimeException {
    public e(IOException iOException) {
        super((Throwable)iOException);
    }

    public IOException a() {
        return (IOException)this.getCause();
    }
}

