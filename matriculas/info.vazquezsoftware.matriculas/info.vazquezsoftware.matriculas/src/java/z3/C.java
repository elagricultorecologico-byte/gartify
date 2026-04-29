/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.nio.channels.WritableByteChannel
 */
package z3;

import java.nio.channels.WritableByteChannel;
import z3.b;
import z3.e;
import z3.v;

public interface c
extends v,
WritableByteChannel {
    public c E(int var1);

    public c Q(int var1);

    public c U(e var1);

    public c W(byte[] var1);

    @Override
    public void flush();

    public b g();

    public c k(byte[] var1, int var2, int var3);

    public c r(long var1);

    public c w0(String var1);

    public c y(int var1);
}

