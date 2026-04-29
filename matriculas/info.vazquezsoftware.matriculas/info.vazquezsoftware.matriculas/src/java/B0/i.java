/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  androidx.room.h
 *  h0.c
 *  j0.b
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

import B0.g;
import B0.h;
import android.database.Cursor;
import h0.a;
import h0.d;
import j0.b;
import j0.c;
import java.util.ArrayList;
import java.util.List;
import m0.e;
import m0.f;

public final class i
implements h {
    private final androidx.room.h a;
    private final a b;
    private final d c;

    public i(androidx.room.h h2) {
        this.a = h2;
        this.b = new a(this, h2){
            final i d;
            {
                this.d = i2;
                super(h2);
            }

            @Override
            public String d() {
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
            }

            public void i(f f2, g g2) {
                String string = g2.a;
                if (string == null) {
                    f2.H(1);
                } else {
                    f2.w(1, string);
                }
                f2.e0(2, (long)g2.b);
            }
        };
        this.c = new d(this, h2){
            final i d;
            {
                this.d = i2;
                super(h2);
            }

            @Override
            public String d() {
                return "DELETE FROM SystemIdInfo where work_spec_id=?";
            }
        };
    }

    @Override
    public List a() {
        Throwable throwable2;
        Cursor cursor;
        h0.c c2;
        block3: {
            ArrayList arrayList;
            c2 = h0.c.i((String)"SELECT DISTINCT work_spec_id FROM SystemIdInfo", (int)0);
            this.a.b();
            cursor = j0.c.b((androidx.room.h)this.a, (e)c2, (boolean)false, null);
            try {
                arrayList = new ArrayList(cursor.getCount());
                while (cursor.moveToNext()) {
                    arrayList.add((Object)cursor.getString(0));
                }
            }
            catch (Throwable throwable2) {
                break block3;
            }
            cursor.close();
            c2.A();
            return arrayList;
        }
        cursor.close();
        c2.A();
        throw throwable2;
    }

    @Override
    public g b(String object) {
        Throwable throwable2;
        androidx.room.h h2;
        h0.c c2;
        block5: {
            block4: {
                c2 = h0.c.i((String)"SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", (int)1);
                if (object == null) {
                    c2.H(1);
                } else {
                    c2.w(1, (String)object);
                }
                this.a.b();
                h2 = this.a;
                object = null;
                h2 = j0.c.b((androidx.room.h)h2, (e)c2, (boolean)false, null);
                try {
                    int n2 = j0.b.b((Cursor)h2, (String)"work_spec_id");
                    int n3 = j0.b.b((Cursor)h2, (String)"system_id");
                    if (!h2.moveToFirst()) break block4;
                    object = new g(h2.getString(n2), h2.getInt(n3));
                }
                catch (Throwable throwable2) {
                    break block5;
                }
            }
            h2.close();
            c2.A();
            return object;
        }
        h2.close();
        c2.A();
        throw throwable2;
    }

    @Override
    public void c(g g2) {
        this.a.b();
        this.a.c();
        try {
            this.b.h(g2);
            this.a.r();
            return;
        }
        finally {
            this.a.g();
        }
    }

    @Override
    public void d(String string) {
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
}

