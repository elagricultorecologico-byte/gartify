/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
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

import B0.a;
import B0.b;
import android.database.Cursor;
import androidx.room.h;
import java.util.ArrayList;
import java.util.List;
import m0.e;
import m0.f;

public final class c
implements b {
    private final h a;
    private final h0.a b;

    public c(h h2) {
        this.a = h2;
        this.b = new h0.a(this, h2){
            final c d;
            {
                this.d = c2;
                super(h2);
            }

            @Override
            public String d() {
                return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            }

            public void i(f f2, a object) {
                String string = ((a)object).a;
                if (string == null) {
                    f2.H(1);
                } else {
                    f2.w(1, string);
                }
                object = ((a)object).b;
                if (object == null) {
                    f2.H(2);
                    return;
                }
                f2.w(2, (String)object);
            }
        };
    }

    @Override
    public boolean a(String string) {
        Throwable throwable2;
        Cursor cursor;
        h0.c c2;
        block5: {
            boolean bl;
            block4: {
                boolean bl2 = true;
                c2 = h0.c.i((String)"SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", (int)1);
                if (string == null) {
                    c2.H(1);
                } else {
                    c2.w(1, string);
                }
                this.a.b();
                string = this.a;
                bl = false;
                cursor = j0.c.b((h)string, (e)c2, (boolean)false, null);
                try {
                    if (!cursor.moveToFirst()) break block4;
                    int n2 = cursor.getInt(0);
                    bl = n2 != 0 ? bl2 : false;
                }
                catch (Throwable throwable2) {
                    break block5;
                }
            }
            cursor.close();
            c2.A();
            return bl;
        }
        cursor.close();
        c2.A();
        throw throwable2;
    }

    @Override
    public void b(a a2) {
        this.a.b();
        this.a.c();
        try {
            this.b.h(a2);
            this.a.r();
            return;
        }
        finally {
            this.a.g();
        }
    }

    @Override
    public boolean c(String string) {
        Throwable throwable2;
        h0.c c2;
        block5: {
            boolean bl;
            block4: {
                boolean bl2 = true;
                c2 = h0.c.i((String)"SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", (int)1);
                if (string == null) {
                    c2.H(1);
                } else {
                    c2.w(1, string);
                }
                this.a.b();
                string = this.a;
                bl = false;
                string = j0.c.b((h)string, (e)c2, (boolean)false, null);
                try {
                    if (!string.moveToFirst()) break block4;
                    int n2 = string.getInt(0);
                    bl = n2 != 0 ? bl2 : false;
                }
                catch (Throwable throwable2) {
                    break block5;
                }
            }
            string.close();
            c2.A();
            return bl;
        }
        string.close();
        c2.A();
        throw throwable2;
    }

    @Override
    public List d(String string) {
        Throwable throwable2;
        h0.c c2;
        block5: {
            ArrayList arrayList;
            c2 = h0.c.i((String)"SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", (int)1);
            if (string == null) {
                c2.H(1);
            } else {
                c2.w(1, string);
            }
            this.a.b();
            string = j0.c.b((h)this.a, (e)c2, (boolean)false, null);
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

