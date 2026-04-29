/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Throwable
 *  java.net.Socket
 *  java.net.SocketTimeoutException
 *  java.util.logging.Level
 */
package z3;

import V2.k;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import z3.a;
import z3.l;
import z3.m;

final class w
extends a {
    private final Socket m;

    public w(Socket socket) {
        k.e(socket, "socket");
        this.m = socket;
    }

    @Override
    protected IOException v(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause((Throwable)iOException);
        }
        return socketTimeoutException;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected void z() {
        Exception exception2;
        block3: {
            try {
                this.m.close();
                return;
            }
            catch (AssertionError assertionError) {
            }
            catch (Exception exception2) {
                break block3;
            }
            if (!l.c(assertionError)) throw assertionError;
            z3.m.a().log(Level.WARNING, k.j("Failed to close timed out socket ", this.m), (Throwable)assertionError);
            return;
        }
        z3.m.a().log(Level.WARNING, k.j("Failed to close timed out socket ", this.m), (Throwable)exception2);
    }
}

