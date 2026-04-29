/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 */
package u3;

import I2.i;
import I2.o;
import V2.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import u3.c;
import u3.k;
import z3.e;
import z3.l;
import z3.x;

public final class d {
    public static final d a;
    private static final c[] b;
    private static final Map c;

    static {
        d d2;
        a = d2 = new d();
        c c2 = new c(u3.c.j, "");
        Object object = u3.c.g;
        c c3 = new c((e)object, "GET");
        c c4 = new c((e)object, "POST");
        Object object2 = u3.c.h;
        object = new c((e)object2, "/");
        object2 = new c((e)object2, "/index.html");
        Object object3 = u3.c.i;
        c c5 = new c((e)object3, "http");
        object3 = new c((e)object3, "https");
        e e2 = u3.c.f;
        b = new c[]{c2, c3, c4, object, object2, c5, object3, new c(e2, "200"), new c(e2, "204"), new c(e2, "206"), new c(e2, "304"), new c(e2, "400"), new c(e2, "404"), new c(e2, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
        c = d2.d();
    }

    private d() {
    }

    private final Map d() {
        c[] cArray = b;
        LinkedHashMap linkedHashMap = new LinkedHashMap(cArray.length);
        int n2 = cArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            cArray = b;
            if (linkedHashMap.containsKey((Object)cArray[i2].a)) continue;
            linkedHashMap.put((Object)cArray[i2].a, (Object)i2);
        }
        linkedHashMap = Collections.unmodifiableMap((Map)linkedHashMap);
        V2.k.d(linkedHashMap, "unmodifiableMap(result)");
        return linkedHashMap;
    }

    public final e a(e e2) {
        V2.k.e(e2, "name");
        int n2 = e2.u();
        for (int i2 = 0; i2 < n2; ++i2) {
            byte by = e2.g(i2);
            if (65 > by || by > 90) continue;
            throw new IOException(V2.k.j("PROTOCOL_ERROR response malformed: mixed case name: ", e2.x()));
        }
        return e2;
    }

    public final Map b() {
        return c;
    }

    public final c[] c() {
        return b;
    }

    public static final class a {
        private final int a;
        private int b;
        private final List c;
        private final z3.d d;
        public c[] e;
        private int f;
        public int g;
        public int h;

        public a(x cArray, int n2, int n3) {
            V2.k.e(cArray, "source");
            this.a = n2;
            this.b = n3;
            this.c = new ArrayList();
            this.d = l.b((x)cArray);
            cArray = new c[8];
            this.e = cArray;
            this.f = cArray.length - 1;
        }

        public /* synthetic */ a(x x2, int n2, int n3, int n4, g g2) {
            if ((n4 & 4) != 0) {
                n3 = n2;
            }
            this(x2, n2, n3);
        }

        private final void a() {
            int n2 = this.b;
            int n3 = this.h;
            if (n2 < n3) {
                if (n2 == 0) {
                    this.b();
                    return;
                }
                this.d(n3 - n2);
            }
        }

        private final void b() {
            i.n(this.e, null, 0, 0, 6, null);
            this.f = this.e.length - 1;
            this.g = 0;
            this.h = 0;
        }

        private final int c(int n2) {
            return this.f + 1 + n2;
        }

        private final int d(int n2) {
            int n3 = 0;
            int n4 = 0;
            if (n2 > 0) {
                Object object;
                int n5 = n2;
                n2 = n4;
                for (n3 = this.e.length - 1; n3 >= (n4 = this.f) && n5 > 0; --n3) {
                    object = this.e[n3];
                    V2.k.b(object);
                    n4 = object.c;
                    n5 -= n4;
                    this.h -= n4;
                    --this.g;
                    ++n2;
                }
                object = this.e;
                System.arraycopy((Object)object, (int)(n4 + 1), (Object)object, (int)(n4 + 1 + n2), (int)this.g);
                this.f += n2;
                n3 = n2;
            }
            return n3;
        }

        private final e f(int n2) {
            Object object;
            if (this.h(n2)) {
                return u3.d.a.c()[n2].a;
            }
            int n3 = this.c(n2 - a.c().length);
            if (n3 >= 0 && n3 < ((c[])(object = this.e)).length) {
                object = object[n3];
                V2.k.b(object);
                return object.a;
            }
            throw new IOException(V2.k.j("Header index too large ", n2 + 1));
        }

        private final void g(int n2, c c2) {
            c[] cArray;
            int n3;
            this.c.add((Object)c2);
            int n4 = n3 = c2.c;
            if (n2 != -1) {
                cArray = this.e[this.c(n2)];
                V2.k.b(cArray);
                n4 = n3 - cArray.c;
            }
            if (n4 > (n3 = this.b)) {
                this.b();
                return;
            }
            int n5 = this.d(this.h + n4 - n3);
            if (n2 == -1) {
                n2 = this.g;
                cArray = this.e;
                if (n2 + 1 > cArray.length) {
                    c[] cArray2 = new c[cArray.length * 2];
                    System.arraycopy((Object)cArray, (int)0, (Object)cArray2, (int)cArray.length, (int)cArray.length);
                    this.f = this.e.length - 1;
                    this.e = cArray2;
                }
                n2 = this.f;
                this.f = n2 - 1;
                this.e[n2] = c2;
                ++this.g;
            } else {
                n3 = this.c(n2);
                this.e[n2 + (n3 + n5)] = c2;
            }
            this.h += n4;
        }

        private final boolean h(int n2) {
            return n2 >= 0 && n2 <= a.c().length - 1;
        }

        private final int i() {
            return n3.d.d(this.d.G0(), 255);
        }

        private final void l(int n2) {
            Object object;
            if (this.h(n2)) {
                c c2 = a.c()[n2];
                this.c.add((Object)c2);
                return;
            }
            int n3 = this.c(n2 - a.c().length);
            if (n3 >= 0 && n3 < ((c[])(object = this.e)).length) {
                List list = this.c;
                object = object[n3];
                V2.k.b(object);
                list.add(object);
                return;
            }
            throw new IOException(V2.k.j("Header index too large ", n2 + 1));
        }

        private final void n(int n2) {
            this.g(-1, new c(this.f(n2), this.j()));
        }

        private final void o() {
            this.g(-1, new c(a.a(this.j()), this.j()));
        }

        private final void p(int n2) {
            e e2 = this.f(n2);
            e e3 = this.j();
            this.c.add((Object)new c(e2, e3));
        }

        private final void q() {
            e e2 = a.a(this.j());
            e e3 = this.j();
            this.c.add((Object)new c(e2, e3));
        }

        public final List e() {
            List list = o.K((Iterable)this.c);
            this.c.clear();
            return list;
        }

        public final e j() {
            int n2 = this.i();
            boolean bl = (n2 & 0x80) == 128;
            long l2 = this.m(n2, 127);
            if (bl) {
                z3.b b2 = new z3.b();
                k.a.b(this.d, l2, b2);
                return b2.a0();
            }
            return this.d.u(l2);
        }

        public final void k() {
            while (!this.d.O()) {
                int n2 = n3.d.d(this.d.G0(), 255);
                if (n2 != 128) {
                    if ((n2 & 0x80) == 128) {
                        this.l(this.m(n2, 127) - 1);
                        continue;
                    }
                    if (n2 == 64) {
                        this.o();
                        continue;
                    }
                    if ((n2 & 0x40) == 64) {
                        this.n(this.m(n2, 63) - 1);
                        continue;
                    }
                    if ((n2 & 0x20) == 32) {
                        this.b = n2 = this.m(n2, 31);
                        if (n2 >= 0 && n2 <= this.a) {
                            this.a();
                            continue;
                        }
                        throw new IOException(V2.k.j("Invalid dynamic table size update ", this.b));
                    }
                    if (n2 != 16 && n2 != 0) {
                        this.p(this.m(n2, 15) - 1);
                        continue;
                    }
                    this.q();
                    continue;
                }
                throw new IOException("index == 0");
            }
        }

        public final int m(int n2, int n3) {
            int n4;
            if ((n2 &= n3) < n3) {
                return n2;
            }
            n2 = 0;
            while (((n4 = this.i()) & 0x80) != 0) {
                n3 += (n4 & 0x7F) << n2;
                n2 += 7;
            }
            return n3 + (n4 << n2);
        }
    }

    public static final class b {
        public int a;
        private final boolean b;
        private final z3.b c;
        private int d;
        private boolean e;
        public int f;
        public c[] g;
        private int h;
        public int i;
        public int j;

        public b(int n2, boolean bl, z3.b cArray) {
            V2.k.e(cArray, "out");
            this.a = n2;
            this.b = bl;
            this.c = cArray;
            this.d = Integer.MAX_VALUE;
            this.f = n2;
            cArray = new c[8];
            this.g = cArray;
            this.h = cArray.length - 1;
        }

        public /* synthetic */ b(int n2, boolean bl, z3.b b2, int n3, g g2) {
            if ((n3 & 1) != 0) {
                n2 = 4096;
            }
            if ((n3 & 2) != 0) {
                bl = true;
            }
            this(n2, bl, b2);
        }

        private final void a() {
            int n2 = this.f;
            int n3 = this.j;
            if (n2 < n3) {
                if (n2 == 0) {
                    this.b();
                    return;
                }
                this.c(n3 - n2);
            }
        }

        private final void b() {
            I2.i.n(this.g, null, 0, 0, 6, null);
            this.h = this.g.length - 1;
            this.i = 0;
            this.j = 0;
        }

        private final int c(int n2) {
            int n3 = 0;
            int n4 = 0;
            if (n2 > 0) {
                Object[] objectArray;
                int n5 = n2;
                n2 = n4;
                for (n3 = this.g.length - 1; n3 >= (n4 = this.h) && n5 > 0; --n3) {
                    objectArray = this.g[n3];
                    V2.k.b(objectArray);
                    n5 -= objectArray.c;
                    n4 = this.j;
                    objectArray = this.g[n3];
                    V2.k.b(objectArray);
                    this.j = n4 - objectArray.c;
                    --this.i;
                    ++n2;
                }
                objectArray = this.g;
                System.arraycopy((Object)objectArray, (int)(n4 + 1), (Object)objectArray, (int)(n4 + 1 + n2), (int)this.i);
                objectArray = this.g;
                n3 = this.h;
                Arrays.fill((Object[])objectArray, (int)(n3 + 1), (int)(n3 + 1 + n2), null);
                this.h += n2;
                n3 = n2;
            }
            return n3;
        }

        private final void d(c c2) {
            int n2 = c2.c;
            int n3 = this.f;
            if (n2 > n3) {
                this.b();
                return;
            }
            this.c(this.j + n2 - n3);
            n3 = this.i;
            c[] cArray = this.g;
            if (n3 + 1 > cArray.length) {
                c[] cArray2 = new c[cArray.length * 2];
                System.arraycopy((Object)cArray, (int)0, (Object)cArray2, (int)cArray.length, (int)cArray.length);
                this.h = this.g.length - 1;
                this.g = cArray2;
            }
            n3 = this.h;
            this.h = n3 - 1;
            this.g[n3] = c2;
            ++this.i;
            this.j += n2;
        }

        public final void e(int n2) {
            this.a = n2;
            int n3 = this.f;
            if (n3 == (n2 = Math.min((int)n2, (int)16384))) {
                return;
            }
            if (n2 < n3) {
                this.d = Math.min((int)this.d, (int)n2);
            }
            this.e = true;
            this.f = n2;
            this.a();
        }

        public final void f(e e2) {
            k k2;
            V2.k.e(e2, "data");
            if (this.b && (k2 = k.a).d(e2) < e2.u()) {
                z3.b b2 = new z3.b();
                k2.c(e2, b2);
                e2 = b2.a0();
                this.h(e2.u(), 127, 128);
                this.c.L0(e2);
                return;
            }
            this.h(e2.u(), 127, 0);
            this.c.L0(e2);
        }

        /*
         * Unable to fully structure code
         * Could not resolve type clashes
         */
        public final void g(List var1_1) {
            V2.k.e(var1_1, "headerBlock");
            if (this.e) {
                var2_2 = this.d;
                if (var2_2 < this.f) {
                    this.h(var2_2, 31, 32);
                }
                this.e = false;
                this.d = 0x7FFFFFFF;
                this.h(this.f, 31, 32);
            }
            var8_3 = var1_1.size();
            for (var4_4 = 0; var4_4 < var8_3; ++var4_4) {
                block16: {
                    block15: {
                        var12_12 = (c)var1_1.get(var4_4);
                        var11_11 = var12_12.a.w();
                        var10_10 = var12_12.b;
                        var14_14 = u3.d.a;
                        var13_13 /* !! */  = (Integer)var14_14.b().get((Object)var11_11);
                        if (var13_13 /* !! */  == null) break block15;
                        var5_6 = var13_13 /* !! */ ;
                        var3_5 = var5_6 + 1;
                        if (2 > var3_5 || var3_5 >= 8) ** GOTO lbl-1000
                        if (V2.k.a(var14_14.c()[var5_6].b, var10_10)) {
                            var2_2 = var3_5;
                        } else if (V2.k.a(var14_14.c()[var3_5].b, var10_10)) {
                            var2_2 = var3_5;
                            var3_5 = var5_6 + 2;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var2_2 = var3_5;
                            var3_5 = -1;
                        }
                        break block16;
                    }
                    var2_2 = -1;
                    var3_5 = -1;
                }
                var6_7 = var2_2;
                var7_8 = var3_5;
                if (var3_5 == -1) {
                    var5_6 = this.h + 1;
                    var9_9 = this.g.length;
                    while (true) {
                        var6_7 = var2_2;
                        var7_8 = var3_5;
                        if (var5_6 >= var9_9) break;
                        var13_13 /* !! */  = this.g[var5_6];
                        V2.k.b(var13_13 /* !! */ );
                        var6_7 = var2_2;
                        if (V2.k.a(var13_13 /* !! */ .a, var11_11)) {
                            var13_13 /* !! */  = this.g[var5_6];
                            V2.k.b(var13_13 /* !! */ );
                            if (V2.k.a(var13_13 /* !! */ .b, var10_10)) {
                                var3_5 = this.h;
                                var7_8 = u3.d.a.c().length + (var5_6 - var3_5);
                                var6_7 = var2_2;
                                break;
                            }
                            var6_7 = var2_2;
                            if (var2_2 == -1) {
                                var2_2 = this.h;
                                var6_7 = u3.d.a.c().length + (var5_6 - var2_2);
                            }
                        }
                        ++var5_6;
                        var2_2 = var6_7;
                    }
                }
                if (var7_8 != -1) {
                    this.h(var7_8, 127, 128);
                    continue;
                }
                if (var6_7 == -1) {
                    this.c.P0(64);
                    this.f(var11_11);
                    this.f(var10_10);
                    this.d(var12_12);
                    continue;
                }
                if (var11_11.v(u3.c.e) && !V2.k.a(u3.c.j, var11_11)) {
                    this.h(var6_7, 15, 0);
                    this.f(var10_10);
                    continue;
                }
                this.h(var6_7, 63, 64);
                this.f(var10_10);
                this.d(var12_12);
            }
        }

        public final void h(int n2, int n3, int n4) {
            if (n2 < n3) {
                this.c.P0(n2 | n4);
                return;
            }
            this.c.P0(n4 | n3);
            n2 -= n3;
            while (n2 >= 128) {
                this.c.P0(0x80 | n2 & 0x7F);
                n2 >>>= 7;
            }
            this.c.P0(n2);
        }
    }
}

