/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteProgram
 *  java.lang.AutoCloseable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package n0;

import android.database.sqlite.SQLiteProgram;

class d
implements m0.d,
AutoCloseable {
    private final SQLiteProgram g;

    d(SQLiteProgram sQLiteProgram) {
        this.g = sQLiteProgram;
    }

    @Override
    public void H(int n2) {
        this.g.bindNull(n2);
    }

    @Override
    public void K(int n2, double d3) {
        this.g.bindDouble(n2, d3);
    }

    public void close() {
        this.g.close();
    }

    @Override
    public void e0(int n2, long l2) {
        this.g.bindLong(n2, l2);
    }

    @Override
    public void p0(int n2, byte[] byArray) {
        this.g.bindBlob(n2, byArray);
    }

    @Override
    public void w(int n2, String string) {
        this.g.bindString(n2, string);
    }
}

