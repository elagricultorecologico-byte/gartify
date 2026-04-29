/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.ssl.SSLSockets
 *  java.lang.Object
 *  javax.net.ssl.SSLSocket
 */
package w3;

import android.net.ssl.SSLSockets;
import javax.net.ssl.SSLSocket;

public abstract class b {
    public static /* bridge */ /* synthetic */ boolean a(SSLSocket sSLSocket) {
        return SSLSockets.isSupportedSocket((SSLSocket)sSLSocket);
    }
}

