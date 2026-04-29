/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.Integer
 *  java.lang.NoSuchMethodException
 *  java.lang.NullPointerException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.lang.reflect.InvocationHandler
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.lang.reflect.Proxy
 *  java.util.Arrays
 *  java.util.List
 *  javax.net.ssl.SSLSocket
 */
package v3;

import V2.g;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import v3.k;

public final class f
extends k {
    public static final b i = new b(null);
    private final Method d;
    private final Method e;
    private final Method f;
    private final Class g;
    private final Class h;

    public f(Method method, Method method2, Method method3, Class clazz, Class clazz2) {
        V2.k.e(method, "putMethod");
        V2.k.e(method2, "getMethod");
        V2.k.e(method3, "removeMethod");
        V2.k.e(clazz, "clientProviderClass");
        V2.k.e(clazz2, "serverProviderClass");
        this.d = method;
        this.e = method2;
        this.f = method3;
        this.g = clazz;
        this.h = clazz2;
    }

    @Override
    public void b(SSLSocket sSLSocket) {
        IllegalAccessException illegalAccessException2;
        block3: {
            V2.k.e(sSLSocket, "sslSocket");
            try {
                this.f.invoke(null, new Object[]{sSLSocket});
                return;
            }
            catch (InvocationTargetException invocationTargetException) {
            }
            catch (IllegalAccessException illegalAccessException2) {
                break block3;
            }
            throw new AssertionError("failed to remove ALPN", (Throwable)invocationTargetException);
        }
        throw new AssertionError("failed to remove ALPN", (Throwable)illegalAccessException2);
    }

    @Override
    public void e(SSLSocket sSLSocket, String object, List list) {
        InvocationTargetException invocationTargetException2;
        block3: {
            V2.k.e(sSLSocket, "sslSocket");
            V2.k.e(list, "protocols");
            list = k.a.b(list);
            try {
                ClassLoader classLoader = k.class.getClassLoader();
                Class clazz = this.g;
                object = this.h;
                a a2 = new a(list);
                object = Proxy.newProxyInstance((ClassLoader)classLoader, (Class[])new Class[]{clazz, object}, (InvocationHandler)a2);
                this.d.invoke(null, new Object[]{sSLSocket, object});
                return;
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (InvocationTargetException invocationTargetException2) {
                break block3;
            }
            throw new AssertionError("failed to set ALPN", (Throwable)illegalAccessException);
        }
        throw new AssertionError("failed to set ALPN", (Throwable)invocationTargetException2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public String g(SSLSocket object) {
        V2.k.e(object, "sslSocket");
        try {
            object = Proxy.getInvocationHandler((Object)this.e.invoke(null, new Object[]{object}));
            if (object == null) {
                object = new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
                throw object;
            }
            if (!((a)(object = (a)object)).b() && ((a)object).a() == null) {
                k.k(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            }
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new AssertionError("failed to get ALPN selected protocol", (Throwable)illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new AssertionError("failed to get ALPN selected protocol", (Throwable)invocationTargetException);
        }
        if (!((a)object).b()) return ((a)object).a();
        return null;
    }

    private static final class a
    implements InvocationHandler {
        private final List a;
        private boolean b;
        private String c;

        public a(List list) {
            V2.k.e(list, "protocols");
            this.a = list;
        }

        public final String a() {
            return this.c;
        }

        public final boolean b() {
            return this.b;
        }

        public Object invoke(Object object, Method object2, Object[] object3) {
            V2.k.e(object, "proxy");
            V2.k.e(object2, "method");
            object = object3;
            if (object3 == null) {
                object = new Object[]{};
            }
            object3 = object2.getName();
            Object object4 = object2.getReturnType();
            if (V2.k.a(object3, "supports") && V2.k.a(Boolean.TYPE, object4)) {
                return Boolean.TRUE;
            }
            if (V2.k.a(object3, "unsupported") && V2.k.a(Void.TYPE, object4)) {
                this.b = true;
                return null;
            }
            if (V2.k.a(object3, "protocols") && ((Object[])object).length == 0) {
                return this.a;
            }
            if ((V2.k.a(object3, "selectProtocol") || V2.k.a(object3, "select")) && V2.k.a(String.class, object4) && ((Object[])object).length == 1 && (object4 = object[0]) instanceof List) {
                if (object4 != null) {
                    block12: {
                        object = (List)object4;
                        int n2 = object.size();
                        if (n2 >= 0) {
                            int n3 = 0;
                            while ((object2 = object.get(n3)) != null) {
                                if (this.a.contains(object2 = (String)object2)) {
                                    this.c = object2;
                                    return object2;
                                }
                                if (n3 != n2) {
                                    ++n3;
                                    continue;
                                }
                                break block12;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    }
                    object = (String)this.a.get(0);
                    this.c = object;
                    return object;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
            }
            if ((V2.k.a(object3, "protocolSelected") || V2.k.a(object3, "selected")) && ((Object[])object).length == 1) {
                if ((object = object[0]) != null) {
                    this.c = (String)object;
                    return null;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            return object2.invoke((Object)this, Arrays.copyOf((Object[])object, (int)((Object[])object).length));
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g g2) {
            this();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public final k a() {
            Object object = System.getProperty((String)"java.specification.version", (String)"unknown");
            try {
                V2.k.d(object, "jvmVersion");
                int n2 = Integer.parseInt((String)object);
                if (n2 >= 9) {
                    return null;
                }
            }
            catch (NumberFormatException numberFormatException) {}
            try {
                Class clazz = Class.forName((String)"org.eclipse.jetty.alpn.ALPN", (boolean)true, null);
                Class clazz2 = Class.forName((String)V2.k.j("org.eclipse.jetty.alpn.ALPN", "$Provider"), (boolean)true, null);
                object = Class.forName((String)V2.k.j("org.eclipse.jetty.alpn.ALPN", "$ClientProvider"), (boolean)true, null);
                Class clazz3 = Class.forName((String)V2.k.j("org.eclipse.jetty.alpn.ALPN", "$ServerProvider"), (boolean)true, null);
                Method method = clazz.getMethod("put", new Class[]{SSLSocket.class, clazz2});
                clazz2 = clazz.getMethod("get", new Class[]{SSLSocket.class});
                clazz = clazz.getMethod("remove", new Class[]{SSLSocket.class});
                V2.k.d(method, "putMethod");
                V2.k.d(clazz2, "getMethod");
                V2.k.d(clazz, "removeMethod");
                V2.k.d(object, "clientProviderClass");
                V2.k.d(clazz3, "serverProviderClass");
                return new f(method, (Method)clazz2, (Method)clazz, (Class)object, clazz3);
            }
            catch (ClassNotFoundException | NoSuchMethodException throwable) {
                return null;
            }
        }
    }
}

