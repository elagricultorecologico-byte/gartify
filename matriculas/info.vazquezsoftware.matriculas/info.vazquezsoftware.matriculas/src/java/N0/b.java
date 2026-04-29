/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.DatabaseErrorHandler
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteOpenHelper
 *  java.io.File
 *  java.lang.AutoCloseable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 */
package n0;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import m0.c;

class b
implements c,
AutoCloseable {
    private final Context g;
    private final String h;
    private final c.a i;
    private final boolean j;
    private final Object k;
    private a l;
    private boolean m;

    b(Context context, String string, c.a a2, boolean bl) {
        this.g = context;
        this.h = string;
        this.i = a2;
        this.j = bl;
        this.k = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private a a() {
        Object object;
        Object object2 = object = this.k;
        synchronized (object2) {
            Throwable throwable2;
            block5: {
                block4: {
                    a a2;
                    n0.a[] aArray;
                    block3: {
                        try {
                            a a3;
                            if (this.l != null) return this.l;
                            aArray = new n0.a[1];
                            if (this.h == null || !this.j) break block3;
                            File file = new File(this.g.getNoBackupFilesDir(), this.h);
                            this.l = a3 = new a(this.g, file.getAbsolutePath(), aArray, this.i);
                            break block4;
                        }
                        catch (Throwable throwable2) {
                            break block5;
                        }
                    }
                    this.l = a2 = new a(this.g, this.h, aArray, this.i);
                }
                this.l.setWriteAheadLoggingEnabled(this.m);
                return this.l;
            }
            throw throwable2;
        }
    }

    @Override
    public void close() {
        this.a().close();
    }

    @Override
    public String getDatabaseName() {
        return this.h;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void setWriteAheadLoggingEnabled(boolean bl) {
        Object object;
        Object object2 = object = this.k;
        synchronized (object2) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        a a2 = this.l;
                        if (a2 == null) break block3;
                        a2.setWriteAheadLoggingEnabled(bl);
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                this.m = bl;
                return;
            }
            throw throwable2;
        }
    }

    @Override
    public m0.b y0() {
        return this.a().i();
    }

    static class a
    extends SQLiteOpenHelper
    implements AutoCloseable {
        final n0.a[] g;
        final c.a h;
        private boolean i;

        a(Context context, String string, n0.a[] aArray, c.a a2) {
            super(context, string, null, a2.a, new DatabaseErrorHandler(a2, aArray){
                final c.a a;
                final n0.a[] b;
                {
                    this.a = a2;
                    this.b = aArray;
                }

                public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    this.a.c(a.f(this.b, sQLiteDatabase));
                }
            });
            this.h = a2;
            this.g = aArray;
        }

        static n0.a f(n0.a[] aArray, SQLiteDatabase sQLiteDatabase) {
            n0.a a2 = aArray[0];
            if (a2 == null || !a2.a(sQLiteDatabase)) {
                aArray[0] = new n0.a(sQLiteDatabase);
            }
            return aArray[0];
        }

        n0.a a(SQLiteDatabase sQLiteDatabase) {
            return a.f(this.g, sQLiteDatabase);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void close() {
            a a2 = this;
            synchronized (a2) {
                super.close();
                this.g[0] = null;
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        m0.b i() {
            a a2 = this;
            synchronized (a2) {
                try {
                    this.i = false;
                    Object object = super.getWritableDatabase();
                    if (!this.i) return this.a((SQLiteDatabase)object);
                    this.close();
                    return this.i();
                }
                catch (Throwable throwable) {}
                throw throwable;
            }
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.h.b(this.a(sQLiteDatabase));
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.h.d(this.a(sQLiteDatabase));
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
            this.i = true;
            this.h.e(this.a(sQLiteDatabase), n2, n3);
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.i) {
                this.h.f(this.a(sQLiteDatabase));
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
            this.i = true;
            this.h.g(this.a(sQLiteDatabase), n2, n3);
        }
    }
}

