/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  androidx.room.h
 *  h0.c
 *  j0.c
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  m0.e
 *  m0.f
 */
package B0;

import B0.d;
import B0.e;
import android.database.Cursor;
import androidx.room.h;
import h0.a;
import j0.c;

public final class f
implements e {
    private final h a;
    private final a b;

    public f(h h2) {
        this.a = h2;
        this.b = new a(this, h2){
            final f d;
            {
                this.d = f2;
                super(h2);
            }

            @Override
            public String d() {
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            }

            public void i(m0.f f2, d d2) {
                String string = d2.a;
                if (string == null) {
                    f2.H(1);
                } else {
                    f2.w(1, string);
                }
                d2 = d2.b;
                if (d2 == null) {
                    f2.H(2);
                    return;
                }
                f2.e0(2, d2.longValue());
            }
        };
    }

    @Override
    public void a(d d2) {
        this.a.b();
        this.a.c();
        try {
            this.b.h(d2);
            this.a.r();
            return;
        }
        finally {
            this.a.g();
        }
    }

    @Override
    public Long b(String string) {
        Throwable throwable2;
        Cursor cursor;
        h0.c c2;
        block7: {
            block5: {
                block6: {
                    c2 = h0.c.i((String)"SELECT long_value FROM Preference where `key`=?", (int)1);
                    if (string == null) {
                        c2.H(1);
                    } else {
                        c2.w(1, string);
                    }
                    this.a.b();
                    string = this.a;
                    Object var2_4 = null;
                    cursor = c.b((h)string, (m0.e)c2, (boolean)false, null);
                    string = var2_4;
                    try {
                        if (!cursor.moveToFirst()) break block5;
                        if (!cursor.isNull(0)) break block6;
                        string = var2_4;
                    }
                    catch (Throwable throwable2) {
                        break block7;
                    }
                }
                string = Long.valueOf((long)cursor.getLong(0));
            }
            cursor.close();
            c2.A();
            return string;
        }
        cursor.close();
        c2.A();
        throw throwable2;
    }
}

