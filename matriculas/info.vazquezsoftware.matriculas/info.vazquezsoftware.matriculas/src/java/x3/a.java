/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.net.Proxy
 *  java.net.ProxySelector
 *  java.net.SocketAddress
 *  java.net.URI
 *  java.util.List
 */
package x3;

import I2.o;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;

public final class a
extends ProxySelector {
    public static final a a = new a();

    private a() {
    }

    public void connectFailed(URI uRI, SocketAddress socketAddress, IOException iOException) {
    }

    public List select(URI uRI) {
        if (uRI != null) {
            return o.b(Proxy.NO_PROXY);
        }
        throw new IllegalArgumentException("uri must not be null");
    }
}

