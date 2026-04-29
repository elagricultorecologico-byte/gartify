/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteCursor
 *  android.database.sqlite.SQLiteCursorDriver
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteProgram
 *  android.database.sqlite.SQLiteQuery
 *  android.os.CancellationSignal
 *  java.lang.AutoCloseable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.List
 */
package n0;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteQuery;
import android.os.CancellationSignal;
import java.util.List;
import m0.b;
import m0.f;
import n0.d;
import n0.e;

class a
implements b,
AutoCloseable {
    private static final String[] h = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    private static final String[] i = new String[0];
    private final SQLiteDatabase g;

    a(SQLiteDatabase sQLiteDatabase) {
        this.g = sQLiteDatabase;
    }

    @Override
    public Cursor B0(m0.e e2, CancellationSignal cancellationSignal) {
        return this.g.rawQueryWithFactory(new SQLiteDatabase.CursorFactory(this, e2){
            final m0.e a;
            final a b;
            {
                this.b = a2;
                this.a = e2;
            }

            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String string, SQLiteQuery sQLiteQuery) {
                this.a.f(new d((SQLiteProgram)sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, string, sQLiteQuery);
            }
        }, e2.a(), i, null, cancellationSignal);
    }

    @Override
    public f C(String string) {
        return new e(this.g.compileStatement(string));
    }

    @Override
    public Cursor C0(String string) {
        return this.N(new m0.a(string));
    }

    @Override
    public Cursor N(m0.e e2) {
        return this.g.rawQueryWithFactory(new SQLiteDatabase.CursorFactory(this, e2){
            final m0.e a;
            final a b;
            {
                this.b = a2;
                this.a = e2;
            }

            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String string, SQLiteQuery sQLiteQuery) {
                this.a.f(new d((SQLiteProgram)sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, string, sQLiteQuery);
            }
        }, e2.a(), i, null);
    }

    @Override
    public String R() {
        return this.g.getPath();
    }

    @Override
    public boolean T() {
        return this.g.inTransaction();
    }

    boolean a(SQLiteDatabase sQLiteDatabase) {
        return this.g == sQLiteDatabase;
    }

    public void close() {
        this.g.close();
    }

    @Override
    public void h0() {
        this.g.setTransactionSuccessful();
    }

    @Override
    public boolean isOpen() {
        return this.g.isOpen();
    }

    @Override
    public void l() {
        this.g.endTransaction();
    }

    @Override
    public void m() {
        this.g.beginTransaction();
    }

    @Override
    public void m0(String string, Object[] objectArray) {
        this.g.execSQL(string, objectArray);
    }

    @Override
    public List s() {
        return this.g.getAttachedDbs();
    }

    @Override
    public void v(String string) {
        this.g.execSQL(string);
    }
}

