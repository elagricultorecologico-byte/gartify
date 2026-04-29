/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.h
 *  androidx.work.b
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  m0.f
 */
package B0;

import B0.m;
import B0.n;
import androidx.room.h;
import androidx.work.b;
import h0.a;
import h0.d;
import m0.f;

public final class o
implements n {
    private final h a;
    private final a b;
    private final d c;
    private final d d;

    public o(h h2) {
        this.a = h2;
        this.b = new a(this, h2){
            final o d;
            {
                this.d = o2;
                super(h2);
            }

            @Override
            public String d() {
                return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
            }

            public void i(f f2, m object) {
                String string = ((m)object).a;
                if (string == null) {
                    f2.H(1);
                } else {
                    f2.w(1, string);
                }
                object = androidx.work.b.k((b)((m)object).b);
                if (object == null) {
                    f2.H(2);
                    return;
                }
                f2.p0(2, (byte[])object);
            }
        };
        this.c = new d(this, h2){
            final o d;
            {
                this.d = o2;
                super(h2);
            }

            @Override
            public String d() {
                return "DELETE from WorkProgress where work_spec_id=?";
            }
        };
        this.d = new d(this, h2){
            final o d;
            {
                this.d = o2;
                super(h2);
            }

            @Override
            public String d() {
                return "DELETE FROM WorkProgress";
            }
        };
    }

    @Override
    public void a(String string) {
        this.a.b();
        f f2 = this.c.a();
        if (string == null) {
            f2.H(1);
        } else {
            f2.w(1, string);
        }
        this.a.c();
        try {
            f2.B();
            this.a.r();
            return;
        }
        finally {
            this.a.g();
            this.c.f(f2);
        }
    }

    @Override
    public void b(m m2) {
        this.a.b();
        this.a.c();
        try {
            this.b.h(m2);
            this.a.r();
            return;
        }
        finally {
            this.a.g();
        }
    }

    @Override
    public void c() {
        this.a.b();
        f f2 = this.d.a();
        this.a.c();
        try {
            f2.B();
            this.a.r();
            return;
        }
        finally {
            this.a.g();
            this.d.f(f2);
        }
    }
}

