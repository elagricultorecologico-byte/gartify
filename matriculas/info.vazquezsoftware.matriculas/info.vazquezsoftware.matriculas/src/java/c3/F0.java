/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.CancellationException
 */
package c3;

import java.util.concurrent.CancellationException;

public abstract class f0 {
    public static final CancellationException a(String string, Throwable throwable) {
        string = new CancellationException(string);
        string.initCause(throwable);
        return string;
    }
}

