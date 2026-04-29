/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package s3;

import I2.o;
import V2.k;
import java.util.List;
import m3.A;
import m3.B;
import m3.m;
import m3.u;
import m3.v;
import m3.y;
import m3.z;
import n3.d;
import s3.e;
import s3.h;
import z3.i;
import z3.l;
import z3.x;

public final class a
implements u {
    private final m a;

    public a(m m2) {
        k.e(m2, "cookieJar");
        this.a = m2;
    }

    private final String b(List object) {
        StringBuilder stringBuilder = new StringBuilder();
        object = object.iterator();
        int n2 = 0;
        while (object.hasNext()) {
            Object object2 = object.next();
            if (n2 < 0) {
                o.n();
            }
            object2 = (m3.l)object2;
            if (n2 > 0) {
                stringBuilder.append("; ");
            }
            stringBuilder.append(((m3.l)object2).i());
            stringBuilder.append('=');
            stringBuilder.append(((m3.l)object2).n());
            ++n2;
        }
        object = stringBuilder.toString();
        k.d(object, "StringBuilder().apply(builderAction).toString()");
        return object;
    }

    @Override
    public A a(u.a object) {
        k.e(object, "chain");
        Object object2 = object.b();
        Object object3 = ((y)object2).h();
        Object object4 = ((y)object2).a();
        if (object4 != null) {
            long l2;
            v v2 = ((z)object4).b();
            if (v2 != null) {
                ((y.a)object3).d("Content-Type", v2.toString());
            }
            if ((l2 = ((z)object4).a()) != -1L) {
                ((y.a)object3).d("Content-Length", String.valueOf((long)l2));
                ((y.a)object3).h("Transfer-Encoding");
            } else {
                ((y.a)object3).d("Transfer-Encoding", "chunked");
                ((y.a)object3).h("Content-Length");
            }
        }
        object4 = ((y)object2).d("Host");
        boolean bl = false;
        if (object4 == null) {
            ((y.a)object3).d("Host", d.R(((y)object2).i(), false, 1, null));
        }
        if (((y)object2).d("Connection") == null) {
            ((y.a)object3).d("Connection", "Keep-Alive");
        }
        boolean bl2 = bl;
        if (((y)object2).d("Accept-Encoding") == null) {
            bl2 = bl;
            if (((y)object2).d("Range") == null) {
                ((y.a)object3).d("Accept-Encoding", "gzip");
                bl2 = true;
            }
        }
        if (!(object4 = this.a.a(((y)object2).i())).isEmpty()) {
            ((y.a)object3).d("Cookie", this.b((List)object4));
        }
        if (((y)object2).d("User-Agent") == null) {
            ((y.a)object3).d("User-Agent", "okhttp/4.10.0");
        }
        object = object.a(((y.a)object3).b());
        e.f(this.a, ((y)object2).i(), ((A)object).M());
        object2 = ((A)object).Z().s((y)object2);
        if (bl2 && b3.h.u("gzip", A.L((A)object, "Content-Encoding", null, 2, null), true) && e.b((A)object) && (object3 = ((A)object).a()) != null) {
            object3 = new i(((B)object3).p());
            ((A.a)object2).l(((A)object).M().h().f("Content-Encoding").f("Content-Length").d());
            ((A.a)object2).b(new h(A.L((A)object, "Content-Type", null, 2, null), -1L, l.b((x)object3)));
        }
        return ((A.a)object2).c();
    }
}

