/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.util.List
 *  javax.net.ssl.SSLSocket
 */
package w3;

import V2.g;
import b3.d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import v3.c;
import v3.k;
import w3.l;
import w3.m;

public class h
implements m {
    public static final a f;
    private static final l.a g;
    private final Class a;
    private final Method b;
    private final Method c;
    private final Method d;
    private final Method e;

    static {
        a a2;
        f = a2 = new a(null);
        g = a2.c("com.google.android.gms.org.conscrypt");
    }

    public h(Class clazz) {
        V2.k.e(clazz, "sslSocketClass");
        this.a = clazz;
        Method method = clazz.getDeclaredMethod("setUseSessionTickets", new Class[]{Boolean.TYPE});
        V2.k.d(method, "sslSocketClass.getDeclar\u2026:class.javaPrimitiveType)");
        this.b = method;
        this.c = clazz.getMethod("setHostname", new Class[]{String.class});
        this.d = clazz.getMethod("getAlpnSelectedProtocol", null);
        this.e = clazz.getMethod("setAlpnProtocols", new Class[]{byte[].class});
    }

    @Override
    public boolean a(SSLSocket sSLSocket) {
        V2.k.e(sSLSocket, "sslSocket");
        return this.a.isInstance((Object)sSLSocket);
    }

    @Override
    public boolean b() {
        return v3.c.f.b();
    }

    @Override
    public String c(SSLSocket object) {
        IllegalAccessException illegalAccessException2;
        block8: {
            block6: {
                V2.k.e(object, "sslSocket");
                if (!this.a((SSLSocket)object)) {
                    return null;
                }
                object = (byte[])this.d.invoke(object, null);
                if (object != null) break block6;
                return null;
            }
            try {
                object = new String((byte[])object, b3.d.b);
                return object;
            }
            catch (InvocationTargetException invocationTargetException) {
            }
            catch (IllegalAccessException illegalAccessException2) {
                break block8;
            }
            object = invocationTargetException.getCause();
            if (object instanceof NullPointerException && V2.k.a(((NullPointerException)((Object)object)).getMessage(), "ssl == null")) {
                return null;
            }
            throw new AssertionError((Object)invocationTargetException);
        }
        throw new AssertionError((Object)illegalAccessException2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void d(SSLSocket sSLSocket, String string, List list) {
        V2.k.e(sSLSocket, "sslSocket");
        V2.k.e(list, "protocols");
        if (!this.a(sSLSocket)) return;
        try {
            this.b.invoke((Object)sSLSocket, new Object[]{Boolean.TRUE});
            if (string != null) {
                this.c.invoke((Object)sSLSocket, new Object[]{string});
            }
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new AssertionError((Object)invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new AssertionError((Object)illegalAccessException);
        }
        this.e.invoke((Object)sSLSocket, new Object[]{k.a.c(list)});
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        private final h b(Class clazz) {
            Class clazz2 = clazz;
            while (clazz2 != null && !V2.k.a(clazz2.getSimpleName(), "OpenSSLSocketImpl")) {
                if ((clazz2 = clazz2.getSuperclass()) == null) {
                    throw new AssertionError((Object)V2.k.j("No OpenSSLSocketImpl superclass of socket of type ", clazz));
                }
            }
            V2.k.b(clazz2);
            return new h(clazz2);
        }

        public final l.a c(String string) {
            V2.k.e(string, "packageName");
            return new l.a(string){
                final String a;
                {
                    this.a = string;
                }

                @Override
                public boolean a(SSLSocket object) {
                    V2.k.e(object, "sslSocket");
                    object = object.getClass().getName();
                    V2.k.d(object, "sslSocket.javaClass.name");
                    return b3.h.E((String)object, V2.k.j(this.a, "."), false, 2, null);
                }

                @Override
                public m b(SSLSocket sSLSocket) {
                    V2.k.e(sSLSocket, "sslSocket");
                    return f.b(sSLSocket.getClass());
                }
            };
        }

        public final l.a d() {
            return g;
        }
    }
}

