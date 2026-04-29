/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.h
 *  h0.c
 *  j0.c
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 *  m0.e
 *  m0.f
 */
package B0;

import B0.s;
import B0.t;
import androidx.room.h;
import h0.a;
import j0.c;
import java.util.ArrayList;
import java.util.List;
import m0.e;
import m0.f;

public final class u
implements t {
    private final h a;
    private final a b;

    public u(h h2) {
        this.a = h2;
        this.b = new a(this, h2){
            final u d;
            {
                this.d = u2;
                super(h2);
            }

            @Override
            public String d() {
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
            }

            public void i(f f2, s object) {
                String string = ((s)object).a;
                if (string == null) {
                    f2.H(1);
                } else {
                    f2.w(1, string);
                }
                object = ((s)object).b;
                if (object == null) {
                    f2.H(2);
                    return;
                }
                f2.w(2, (String)object);
            }
        };
    }

    @Override
    public void a(s s2) {
        this.a.b();
        this.a.c();
        try {
            this.b.h(s2);
            this.a.r();
            return;
        }
        finally {
            this.a.g();
        }
    }

    @Override
    public List b(String string) {
        Throwable throwable2;
        h0.c c2;
        block5: {
            ArrayList arrayList;
            c2 = h0.c.i((String)"SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", (int)1);
            if (string == null) {
                c2.H(1);
            } else {
                c2.w(1, string);
            }
            this.a.b();
            string = c.b((h)this.a, (e)c2, (boolean)false, null);
            try {
                arrayList = new ArrayList(string.getCount());
                while (string.moveToNext()) {
                    arrayList.add((Object)string.getString(0));
                }
            }
            catch (Throwable throwable2) {
                break block5;
            }
            string.close();
            c2.A();
            return arrayList;
        }
        string.close();
        c2.A();
        throw throwable2;
    }
}

