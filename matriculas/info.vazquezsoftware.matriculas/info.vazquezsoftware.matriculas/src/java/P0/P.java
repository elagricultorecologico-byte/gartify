/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package P0;

import K0.c;
import P0.M;
import android.database.sqlite.SQLiteDatabase;

public final class p
implements M.b {
    public final String a;
    public final c.b b;
    public final long c;

    public /* synthetic */ p(String string, c.b b2, long l2) {
        this.a = string;
        this.b = b2;
        this.c = l2;
    }

    @Override
    public final Object apply(Object object) {
        return M.s0(this.a, this.b, this.c, (SQLiteDatabase)object);
    }
}

