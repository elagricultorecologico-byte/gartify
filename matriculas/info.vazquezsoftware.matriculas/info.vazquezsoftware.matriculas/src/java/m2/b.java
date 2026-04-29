/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
package m2;

public final class b
extends RuntimeException {
    public b(String string) {
        super(string);
    }

    public b(String string, Exception exception) {
        super(string, (Throwable)exception);
    }
}

