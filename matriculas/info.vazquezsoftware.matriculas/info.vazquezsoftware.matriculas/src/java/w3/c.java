/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.List
 *  javax.net.ssl.SSLParameters
 *  javax.net.ssl.SSLSocket
 */
package w3;

import android.os.Build;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import v3.g;
import v3.h;
import v3.k;
import w3.b;
import w3.m;

public final class c
implements m {
    public static final a a = new a(null);

    @Override
    public boolean a(SSLSocket sSLSocket) {
        V2.k.e(sSLSocket, "sslSocket");
        return b.a(sSLSocket);
    }

    @Override
    public boolean b() {
        return a.b();
    }

    @Override
    public String c(SSLSocket object) {
        V2.k.e(object, "sslSocket");
        object = h.a(object);
        boolean bl = object == null ? true : V2.k.a(object, "");
        if (bl) {
            object = null;
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void d(SSLSocket object, String string, List objectArray) {
        V2.k.e(object, "sslSocket");
        V2.k.e(objectArray, "protocols");
        try {
            w3.a.a(object, true);
            string = object.getSSLParameters();
            objectArray = k.a.b((List)objectArray).toArray((Object[])new String[0]);
            if (objectArray != null) {
                g.a((SSLParameters)string, (String[])objectArray);
                object.setSSLParameters((SSLParameters)string);
                return;
            }
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new IOException("Android internal error", (Throwable)illegalArgumentException);
        }
        object = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        throw object;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(V2.g g2) {
            this();
        }

        public final m a() {
            if (this.b()) {
                return new c();
            }
            return null;
        }

        public final boolean b() {
            return k.a.h() && Build.VERSION.SDK_INT >= 29;
        }
    }
}

