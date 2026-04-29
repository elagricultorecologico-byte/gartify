/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.AssertionError
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.net.Socket
 *  java.util.logging.Logger
 */
package z3;

import b3.h;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import z3.k;
import z3.p;
import z3.v;
import z3.w;
import z3.x;
import z3.y;

abstract class m {
    private static final Logger a = Logger.getLogger((String)"okio.Okio");

    public static final /* synthetic */ Logger a() {
        return a;
    }

    public static final boolean b(AssertionError object) {
        boolean bl;
        V2.k.e(object, "<this>");
        return object.getCause() != null && (bl = (object = object.getMessage()) == null ? false : h.J((CharSequence)object, "getsockname failed", false, 2, null));
    }

    public static final v c(Socket socket) {
        V2.k.e(socket, "<this>");
        w w2 = new w(socket);
        socket = socket.getOutputStream();
        V2.k.d(socket, "getOutputStream()");
        return w2.x(new p((OutputStream)socket, w2));
    }

    public static final x d(InputStream inputStream) {
        V2.k.e(inputStream, "<this>");
        return new k(inputStream, new y());
    }

    public static final x e(Socket socket) {
        V2.k.e(socket, "<this>");
        w w2 = new w(socket);
        socket = socket.getInputStream();
        V2.k.d(socket, "getInputStream()");
        return w2.y(new k((InputStream)socket, w2));
    }
}

