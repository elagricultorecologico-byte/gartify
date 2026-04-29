/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteProgram
 *  android.database.sqlite.SQLiteStatement
 *  java.lang.Object
 *  java.lang.Override
 */
package n0;

import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteStatement;
import m0.f;
import n0.d;

class e
extends d
implements f {
    private final SQLiteStatement h;

    e(SQLiteStatement sQLiteStatement) {
        super((SQLiteProgram)sQLiteStatement);
        this.h = sQLiteStatement;
    }

    @Override
    public int B() {
        return this.h.executeUpdateDelete();
    }

    @Override
    public long z0() {
        return this.h.executeInsert();
    }
}

