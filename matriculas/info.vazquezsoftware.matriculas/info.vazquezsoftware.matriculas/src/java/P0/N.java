/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 *  java.lang.Object
 *  java.lang.Override
 */
package P0;

import H0.o;
import P0.M;
import android.database.sqlite.SQLiteDatabase;

public final class n
implements M.b {
    public final long a;
    public final o b;

    public /* synthetic */ n(long l2, o o2) {
        this.a = l2;
        this.b = o2;
    }

    @Override
    public final Object apply(Object object) {
        return M.Y(this.a, this.b, (SQLiteDatabase)object);
    }
}

