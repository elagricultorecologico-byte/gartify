/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package s3;

import V2.k;

public final class f {
    public static final f a = new f();

    private f() {
    }

    public static final boolean a(String string) {
        k.e(string, "method");
        return !k.a(string, "GET") && !k.a(string, "HEAD");
    }

    public static final boolean d(String string) {
        k.e(string, "method");
        return k.a(string, "POST") || k.a(string, "PUT") || k.a(string, "PATCH") || k.a(string, "PROPPATCH") || k.a(string, "REPORT");
        {
        }
    }

    public final boolean b(String string) {
        k.e(string, "method");
        return k.a(string, "PROPFIND") ^ true;
    }

    public final boolean c(String string) {
        k.e(string, "method");
        return k.a(string, "PROPFIND");
    }
}

