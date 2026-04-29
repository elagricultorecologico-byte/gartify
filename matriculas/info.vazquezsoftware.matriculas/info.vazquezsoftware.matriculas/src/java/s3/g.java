/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.StringBuilder
 *  java.util.List
 */
package s3;

import V2.k;
import java.util.List;
import m3.A;
import m3.u;
import m3.y;
import r3.c;
import r3.e;

public final class g
implements u.a {
    private final e a;
    private final List b;
    private final int c;
    private final c d;
    private final y e;
    private final int f;
    private final int g;
    private final int h;
    private int i;

    public g(e e2, List list, int n2, c c2, y y2, int n3, int n4, int n5) {
        k.e(e2, "call");
        k.e(list, "interceptors");
        k.e(y2, "request");
        this.a = e2;
        this.b = list;
        this.c = n2;
        this.d = c2;
        this.e = y2;
        this.f = n3;
        this.g = n4;
        this.h = n5;
    }

    public static /* synthetic */ g d(g g2, int n2, c c2, y y2, int n3, int n4, int n5, int n6, Object object) {
        if ((n6 & 1) != 0) {
            n2 = g2.c;
        }
        if ((n6 & 2) != 0) {
            c2 = g2.d;
        }
        if ((n6 & 4) != 0) {
            y2 = g2.e;
        }
        if ((n6 & 8) != 0) {
            n3 = g2.f;
        }
        if ((n6 & 0x10) != 0) {
            n4 = g2.g;
        }
        if ((n6 & 0x20) != 0) {
            n5 = g2.h;
        }
        return g2.c(n2, c2, y2, n3, n4, n5);
    }

    @Override
    public A a(y object) {
        k.e(object, "request");
        if (this.c < this.b.size()) {
            ++this.i;
            Object object2 = this.d;
            if (object2 != null) {
                if (((c)object2).j().g(((y)object).i())) {
                    if (this.i != 1) {
                        object = new StringBuilder();
                        object.append("network interceptor ");
                        object.append(this.b.get(this.c - 1));
                        object.append(" must call proceed() exactly once");
                        throw new IllegalStateException(object.toString().toString());
                    }
                } else {
                    object = new StringBuilder();
                    object.append("network interceptor ");
                    object.append(this.b.get(this.c - 1));
                    object.append(" must retain the same host and port");
                    throw new IllegalStateException(object.toString().toString());
                }
            }
            g g2 = s3.g.d(this, this.c + 1, null, (y)object, 0, 0, 0, 58, null);
            object = (u)this.b.get(this.c);
            object2 = object.a(g2);
            if (object2 != null) {
                if (this.d != null && this.c + 1 < this.b.size() && g2.i != 1) {
                    object2 = new StringBuilder();
                    object2.append("network interceptor ");
                    object2.append(object);
                    object2.append(" must call proceed() exactly once");
                    throw new IllegalStateException(object2.toString().toString());
                }
                if (((A)object2).a() != null) {
                    return object2;
                }
                object2 = new StringBuilder();
                object2.append("interceptor ");
                object2.append(object);
                object2.append(" returned a response with no body");
                throw new IllegalStateException(object2.toString().toString());
            }
            object2 = new StringBuilder();
            object2.append("interceptor ");
            object2.append(object);
            object2.append(" returned null");
            throw new NullPointerException(object2.toString());
        }
        throw new IllegalStateException("Check failed.");
    }

    @Override
    public y b() {
        return this.e;
    }

    public final g c(int n2, c c2, y y2, int n3, int n4, int n5) {
        k.e(y2, "request");
        return new g(this.a, this.b, n2, c2, y2, n3, n4, n5);
    }

    @Override
    public m3.e call() {
        return this.a;
    }

    public final e e() {
        return this.a;
    }

    public final int f() {
        return this.f;
    }

    public final c g() {
        return this.d;
    }

    public final int h() {
        return this.g;
    }

    public final y i() {
        return this.e;
    }

    public final int j() {
        return this.h;
    }

    public int k() {
        return this.g;
    }
}

