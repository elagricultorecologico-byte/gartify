/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.AssertionError
 *  java.lang.Object
 *  java.net.Socket
 */
package z3;

import java.io.InputStream;
import java.net.Socket;
import z3.c;
import z3.d;
import z3.m;
import z3.n;
import z3.v;
import z3.x;

public abstract class l {
    public static final c a(v v2) {
        return n.a(v2);
    }

    public static final d b(x x2) {
        return n.b(x2);
    }

    public static final boolean c(AssertionError assertionError) {
        return m.b(assertionError);
    }

    public static final v d(Socket socket) {
        return m.c(socket);
    }

    public static final x e(InputStream inputStream) {
        return m.d(inputStream);
    }

    public static final x f(Socket socket) {
        return m.e(socket);
    }
}

