/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 */
package p2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import m2.d;
import m2.e;
import n2.b;
import p2.f;
import p2.g;

public class h {
    private final Map a;
    private final Map b;
    private final d c;

    h(Map map, Map map2, d d3) {
        this.a = map;
        this.b = map2;
        this.c = d3;
    }

    public static a a() {
        return new a();
    }

    public void b(Object object, OutputStream outputStream) {
        new f(outputStream, this.a, this.b, this.c).p(object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public byte[] c(Object object) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.b(object, (OutputStream)byteArrayOutputStream);
        }
        catch (IOException iOException) {
            return byteArrayOutputStream.toByteArray();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static final class a
    implements b {
        private static final d d = new g();
        private final Map a = new HashMap();
        private final Map b = new HashMap();
        private d c = d;

        public static /* synthetic */ void b(Object object, e e2) {
            e2 = new StringBuilder();
            e2.append("Couldn't find encoder for type ");
            e2.append(object.getClass().getCanonicalName());
            throw new m2.b(e2.toString());
        }

        public h c() {
            return new h((Map)new HashMap(this.a), (Map)new HashMap(this.b), this.c);
        }

        public a d(n2.a a2) {
            a2.a(this);
            return this;
        }

        public a e(Class clazz, d d3) {
            this.a.put((Object)clazz, (Object)d3);
            this.b.remove((Object)clazz);
            return this;
        }
    }
}

