/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Date
 *  java.util.concurrent.TimeUnit
 */
package p3;

import V2.g;
import V2.k;
import b3.h;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import m3.A;
import m3.s;
import m3.y;
import n3.d;
import s3.c;

public final class b {
    public static final a c = new a(null);
    private final y a;
    private final A b;

    public b(y y2, A a2) {
        this.a = y2;
        this.b = a2;
    }

    public final A a() {
        return this.b;
    }

    public final y b() {
        return this.a;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        /*
         * Unable to fully structure code
         */
        public final boolean a(A var1_1, y var2_2) {
            block6: {
                k.e(var1_1, "response");
                k.e(var2_2, "request");
                var3_3 = var1_1.p();
                if (var3_3 == 200 || var3_3 == 410 || var3_3 == 414 || var3_3 == 501 || var3_3 == 203 || var3_3 == 204) break block6;
                if (var3_3 == 307) ** GOTO lbl-1000
                if (var3_3 == 308 || var3_3 == 404 || var3_3 == 405) break block6;
                switch (var3_3) {
                    default: {
                        return false;
                    }
                    case 302: lbl-1000:
                    // 2 sources

                    {
                        if (A.L(var1_1, "Expires", null, 2, null) != null || var1_1.f().d() != -1 || var1_1.f().c() || var1_1.f().b()) break;
                        return false;
                    }
                    case 300: 
                    case 301: 
                }
            }
            return var1_1.f().i() == false && var2_2.b().i() == false;
        }
    }

    public static final class b {
        private final long a;
        private final y b;
        private final A c;
        private Date d;
        private String e;
        private Date f;
        private String g;
        private Date h;
        private long i;
        private long j;
        private String k;
        private int l;

        public b(long l2, y object, A object2) {
            V2.k.e(object, "request");
            this.a = l2;
            this.b = object;
            this.c = object2;
            this.l = -1;
            if (object2 != null) {
                this.i = ((A)object2).k0();
                this.j = ((A)object2).c0();
                object = ((A)object2).M();
                int n2 = ((s)object).size();
                for (int i2 = 0; i2 < n2; ++i2) {
                    object2 = ((s)object).f(i2);
                    String string = ((s)object).i(i2);
                    if (b3.h.u((String)object2, "Date", true)) {
                        this.d = s3.c.a(string);
                        this.e = string;
                        continue;
                    }
                    if (b3.h.u((String)object2, "Expires", true)) {
                        this.h = s3.c.a(string);
                        continue;
                    }
                    if (b3.h.u((String)object2, "Last-Modified", true)) {
                        this.f = s3.c.a(string);
                        this.g = string;
                        continue;
                    }
                    if (b3.h.u((String)object2, "ETag", true)) {
                        this.k = string;
                        continue;
                    }
                    if (!b3.h.u((String)object2, "Age", true)) continue;
                    this.l = n3.d.V(string, -1);
                }
            }
        }

        private final long a() {
            Date date = this.d;
            long l2 = 0L;
            if (date != null) {
                l2 = Math.max((long)0L, (long)(this.j - date.getTime()));
            }
            int n2 = this.l;
            long l3 = l2;
            if (n2 != -1) {
                l3 = Math.max((long)l2, (long)TimeUnit.SECONDS.toMillis((long)n2));
            }
            l2 = this.j;
            return l3 + (l2 - this.i) + (this.a - l2);
        }

        /*
         * Enabled aggressive block sorting
         */
        private final b c() {
            long l2;
            if (this.c == null) {
                return new b(this.b, null);
            }
            if (this.b.f() && this.c.F() == null) {
                return new b(this.b, null);
            }
            if (!c.a(this.c, this.b)) {
                return new b(this.b, null);
            }
            Object object = this.b.b();
            if (((m3.d)object).h()) return new b(this.b, null);
            if (this.e(this.b)) {
                return new b(this.b, null);
            }
            Object object2 = this.c.f();
            long l3 = this.a();
            long l4 = l2 = this.d();
            if (((m3.d)object).d() != -1) {
                l4 = Math.min((long)l2, (long)TimeUnit.SECONDS.toMillis((long)((m3.d)object).d()));
            }
            int n2 = ((m3.d)object).f();
            long l5 = 0L;
            long l6 = n2 != -1 ? TimeUnit.SECONDS.toMillis((long)((m3.d)object).f()) : 0L;
            l2 = l5;
            if (!((m3.d)object2).g()) {
                l2 = l5;
                if (((m3.d)object).e() != -1) {
                    l2 = TimeUnit.SECONDS.toMillis((long)((m3.d)object).e());
                }
            }
            if (!((m3.d)object2).h() && (l6 += l3) < l2 + l4) {
                object = this.c.Z();
                if (l6 >= l4) {
                    ((A.a)object).a("Warning", "110 HttpURLConnection \"Response is stale\"");
                }
                if (l3 <= 86400000L) return new b(null, ((A.a)object).c());
                if (!this.f()) return new b(null, ((A.a)object).c());
                ((A.a)object).a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                return new b(null, ((A.a)object).c());
            }
            object = this.k;
            if (object != null) {
                object2 = "If-None-Match";
            } else {
                if (this.f != null) {
                    object = this.g;
                } else {
                    if (this.d == null) return new b(this.b, null);
                    object = this.e;
                }
                object2 = "If-Modified-Since";
            }
            s.a a2 = this.b.e().h();
            V2.k.b(object);
            a2.c((String)object2, (String)object);
            return new b(this.b.h().e(a2.d()).b(), this.c);
        }

        private final long d() {
            Object object = this.c;
            V2.k.b(object);
            object = ((A)object).f();
            if (((m3.d)object).d() != -1) {
                return TimeUnit.SECONDS.toMillis((long)((m3.d)object).d());
            }
            Date date = this.h;
            Date date2 = null;
            object = null;
            if (date != null) {
                date2 = this.d;
                if (date2 != null) {
                    object = date2.getTime();
                }
                long l2 = object == null ? this.j : object.longValue();
                l2 = date.getTime() - l2;
                if (l2 > 0L) {
                    return l2;
                }
                return 0L;
            }
            if (this.f != null && this.c.i0().i().m() == null) {
                object = this.d;
                object = object == null ? date2 : Long.valueOf((long)object.getTime());
                long l3 = object == null ? this.i : object.longValue();
                object = this.f;
                V2.k.b(object);
                if ((l3 -= object.getTime()) > 0L) {
                    return l3 / (long)10;
                }
            }
            return 0L;
        }

        private final boolean e(y y2) {
            return y2.d("If-Modified-Since") != null || y2.d("If-None-Match") != null;
            {
            }
        }

        private final boolean f() {
            A a2 = this.c;
            V2.k.b(a2);
            return a2.f().d() == -1 && this.h == null;
        }

        public final b b() {
            b b2;
            b b3 = b2 = this.c();
            if (b2.b() != null) {
                b3 = b2;
                if (this.b.b().k()) {
                    b3 = new b(null, null);
                }
            }
            return b3;
        }
    }
}

