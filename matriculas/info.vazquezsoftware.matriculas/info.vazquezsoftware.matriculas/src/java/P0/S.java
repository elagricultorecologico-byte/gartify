/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Map
 */
package P0;

import K0.a;
import P0.M;
import android.database.sqlite.SQLiteDatabase;
import java.util.Map;

public final class s
implements M.b {
    public final M a;
    public final String b;
    public final Map c;
    public final a.a d;

    public /* synthetic */ s(M m2, String string, Map map, a.a a2) {
        this.a = m2;
        this.b = string;
        this.c = map;
        this.d = a2;
    }

    @Override
    public final Object apply(Object object) {
        return M.L0(this.a, this.b, this.c, this.d, (SQLiteDatabase)object);
    }
}

