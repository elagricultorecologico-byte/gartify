/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Scope
 *  java.lang.Object
 *  v1.a
 *  v1.a$g
 */
package J1;

import J1.b;
import J1.c;
import com.google.android.gms.common.api.Scope;
import v1.a;

public abstract class d {
    public static final a.g a;
    public static final a.g b;
    public static final a.a c;
    static final a.a d;
    public static final Scope e;
    public static final Scope f;
    public static final a g;
    public static final a h;

    static {
        a.g g2;
        a.g g3;
        a = g3 = new a.g();
        b = g2 = new a.g();
        b b2 = new b();
        c = b2;
        c c2 = new c();
        d = c2;
        e = new Scope("profile");
        f = new Scope("email");
        g = new a("SignIn.API", (a.a)b2, g3);
        h = new a("SignIn.INTERNAL_API", (a.a)c2, g2);
    }
}

