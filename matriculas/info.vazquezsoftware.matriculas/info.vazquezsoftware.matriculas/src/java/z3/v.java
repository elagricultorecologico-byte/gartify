/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.Flushable
 *  java.lang.Object
 */
package z3;

import java.io.Closeable;
import java.io.Flushable;
import z3.b;
import z3.y;

public interface v
extends Closeable,
Flushable {
    public void close();

    public void flush();

    public y h();

    public void q(b var1, long var2);
}

