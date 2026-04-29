/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  java.lang.Object
 *  java.lang.String
 */
package H0;

import F0.d;
import H0.d;
import android.util.Base64;

public abstract class o {
    public static a a() {
        return new d.b().d(d.g);
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract d d();

    public boolean e() {
        return this.c() != null;
    }

    public o f(d d2) {
        return o.a().b(this.b()).d(d2).c(this.c()).a();
    }

    public final String toString() {
        String string = this.b();
        d d2 = this.d();
        String string2 = this.c() == null ? "" : Base64.encodeToString((byte[])this.c(), (int)2);
        return String.format((String)"TransportContext(%s, %s, %s)", (Object[])new Object[]{string, d2, string2});
    }

    public static abstract class a {
        public abstract o a();

        public abstract a b(String var1);

        public abstract a c(byte[] var1);

        public abstract a d(d var1);
    }
}

