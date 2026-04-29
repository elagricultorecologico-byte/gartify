/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 */
package m3;

import H2.j;
import I2.E;
import I2.o;
import V2.k;
import b3.h;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import m3.d;
import m3.s;
import m3.t;
import m3.z;
import s3.f;

public final class y {
    private final t a;
    private final String b;
    private final s c;
    private final z d;
    private final Map e;
    private d f;

    public y(t t2, String string, s s2, z z2, Map map) {
        k.e(t2, "url");
        k.e(string, "method");
        k.e(s2, "headers");
        k.e(map, "tags");
        this.a = t2;
        this.b = string;
        this.c = s2;
        this.d = z2;
        this.e = map;
    }

    public final z a() {
        return this.d;
    }

    public final d b() {
        d d2;
        d d3 = d2 = this.f;
        if (d2 == null) {
            this.f = d3 = m3.d.n.b(this.c);
        }
        return d3;
    }

    public final Map c() {
        return this.e;
    }

    public final String d(String string) {
        k.e(string, "name");
        return this.c.c(string);
    }

    public final s e() {
        return this.c;
    }

    public final boolean f() {
        return this.a.i();
    }

    public final String g() {
        return this.b;
    }

    public final a h() {
        return new a(this);
    }

    public final t i() {
        return this.a;
    }

    public String toString() {
        Object object = new StringBuilder();
        object.append("Request{method=");
        object.append(this.g());
        object.append(", url=");
        object.append((Object)this.i());
        if (this.e().size() != 0) {
            object.append(", headers=[");
            Iterator iterator = this.e().iterator();
            int n2 = 0;
            while (iterator.hasNext()) {
                Object object2 = iterator.next();
                if (n2 < 0) {
                    o.n();
                }
                Object object3 = (j)object2;
                object2 = (String)((j)object3).a();
                object3 = (String)((j)object3).b();
                if (n2 > 0) {
                    object.append(", ");
                }
                object.append((String)object2);
                object.append(':');
                object.append((String)object3);
                ++n2;
            }
            object.append(']');
        }
        if (!this.c().isEmpty()) {
            object.append(", tags=");
            object.append((Object)this.c());
        }
        object.append('}');
        object = object.toString();
        k.d(object, "StringBuilder().apply(builderAction).toString()");
        return object;
    }

    public static class a {
        private t a;
        private String b;
        private s.a c;
        private z d;
        private Map e;

        public a() {
            this.e = new LinkedHashMap();
            this.b = "GET";
            this.c = new s.a();
        }

        public a(y y2) {
            k.e(y2, "request");
            this.e = new LinkedHashMap();
            this.a = y2.i();
            this.b = y2.g();
            this.d = y2.a();
            Object object = y2.c().isEmpty() ? new LinkedHashMap() : E.l(y2.c());
            this.e = object;
            this.c = y2.e().h();
        }

        public a a(String string, String string2) {
            k.e(string, "name");
            k.e(string2, "value");
            this.c().a(string, string2);
            return this;
        }

        public y b() {
            t t2 = this.a;
            if (t2 != null) {
                return new y(t2, this.b, this.c.d(), this.d, n3.d.T(this.e));
            }
            throw new IllegalStateException("url == null");
        }

        public final s.a c() {
            return this.c;
        }

        public a d(String string, String string2) {
            k.e(string, "name");
            k.e(string2, "value");
            this.c().g(string, string2);
            return this;
        }

        public a e(s s2) {
            k.e(s2, "headers");
            this.j(s2.h());
            return this;
        }

        public a f(String string, z z2) {
            block5: {
                block8: {
                    block7: {
                        block6: {
                            k.e(string, "method");
                            if (string.length() <= 0) break block5;
                            if (z2 != null) break block6;
                            if (s3.f.d(string)) {
                                z2 = new StringBuilder();
                                z2.append("method ");
                                z2.append(string);
                                z2.append(" must have a request body.");
                                throw new IllegalArgumentException(z2.toString().toString());
                            }
                            break block7;
                        }
                        if (!s3.f.a(string)) break block8;
                    }
                    this.k(string);
                    this.i(z2);
                    return this;
                }
                z2 = new StringBuilder();
                z2.append("method ");
                z2.append(string);
                z2.append(" must not have a request body.");
                throw new IllegalArgumentException(z2.toString().toString());
            }
            throw new IllegalArgumentException("method.isEmpty() == true");
        }

        public a g(z z2) {
            k.e(z2, "body");
            return this.f("POST", z2);
        }

        public a h(String string) {
            k.e(string, "name");
            this.c().f(string);
            return this;
        }

        public final void i(z z2) {
            this.d = z2;
        }

        public final void j(s.a a2) {
            k.e(a2, "<set-?>");
            this.c = a2;
        }

        public final void k(String string) {
            k.e(string, "<set-?>");
            this.b = string;
        }

        public final void l(t t2) {
            this.a = t2;
        }

        public a m(String string) {
            String string2;
            k.e(string, "url");
            if (h.C(string, "ws:", true)) {
                string = string.substring(3);
                k.d(string, "this as java.lang.String).substring(startIndex)");
                string2 = k.j("http:", string);
            } else {
                string2 = string;
                if (h.C(string, "wss:", true)) {
                    string = string.substring(4);
                    k.d(string, "this as java.lang.String).substring(startIndex)");
                    string2 = k.j("https:", string);
                }
            }
            return this.n(t.k.d(string2));
        }

        public a n(t t2) {
            k.e(t2, "url");
            this.l(t2);
            return this;
        }
    }
}

