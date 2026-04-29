/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package w3;

import V2.g;
import V2.k;
import w3.h;
import w3.m;

public final class n
extends h {
    public static final a j = new a(null);
    private final Class h;
    private final Class i;

    public n(Class clazz, Class clazz2, Class clazz3) {
        k.e(clazz, "sslSocketClass");
        k.e(clazz2, "sslSocketFactoryClass");
        k.e(clazz3, "paramClass");
        super(clazz);
        this.h = clazz2;
        this.i = clazz3;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public static /* synthetic */ m b(a a2, String string, int n2, Object object) {
            if ((n2 & 1) != 0) {
                string = "com.android.org.conscrypt";
            }
            return a2.a(string);
        }

        public final m a(String object) {
            k.e(object, "packageName");
            try {
                Class clazz = Class.forName((String)k.j((String)object, ".OpenSSLSocketImpl"));
                Class clazz2 = Class.forName((String)k.j((String)object, ".OpenSSLSocketFactoryImpl"));
                object = Class.forName((String)k.j((String)object, ".SSLParametersImpl"));
                k.d(object, "paramsClass");
                object = new n(clazz, clazz2, (Class)object);
                return object;
            }
            catch (Exception exception) {
                v3.k.a.g().j("unable to load android socket classes", 5, exception);
                return null;
            }
        }
    }
}

