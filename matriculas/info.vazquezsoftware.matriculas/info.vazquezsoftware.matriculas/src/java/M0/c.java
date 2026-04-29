/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteException
 *  android.util.Log
 *  android.util.Pair
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.List
 *  m0.b
 *  m0.c$b
 */
package m0;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.List;
import m0.c;

public interface c
extends Closeable {
    public void close();

    public String getDatabaseName();

    public void setWriteAheadLoggingEnabled(boolean var1);

    public m0.b y0();

    public static abstract class a {
        public final int a;

        public a(int n3) {
            this.a = n3;
        }

        private void a(String string) {
            if (!string.equalsIgnoreCase(":memory:") && string.trim().length() != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("deleting the database file: ");
                stringBuilder.append(string);
                Log.w((String)"SupportSQLite", (String)stringBuilder.toString());
                try {
                    stringBuilder = new File(string);
                    SQLiteDatabase.deleteDatabase((File)stringBuilder);
                    return;
                }
                catch (Exception exception) {
                    Log.w((String)"SupportSQLite", (String)"delete failed: ", (Throwable)exception);
                }
            }
        }

        public void b(m0.b b3) {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void c(m0.b b3) {
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2;
            block13: {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Corruption reported by sqlite on database: ");
                stringBuilder2.append(b3.R());
                Log.e((String)"SupportSQLite", (String)stringBuilder2.toString());
                if (!b3.isOpen()) {
                    this.a(b3.R());
                    return;
                }
                stringBuilder2 = null;
                stringBuilder = null;
                try {
                    try {
                        List list = b3.s();
                        stringBuilder2 = list;
                    }
                    catch (SQLiteException sQLiteException) {}
                    break block13;
                }
                catch (Throwable throwable) {}
                if (stringBuilder != null) {
                    b3 = stringBuilder.iterator();
                    while (b3.hasNext()) {
                        this.a((String)((Pair)b3.next()).second);
                    }
                    throw throwable;
                } else {
                    this.a(b3.R());
                }
                throw throwable;
            }
            stringBuilder = stringBuilder2;
            try {
                b3.close();
            }
            catch (IOException iOException) {}
            if (stringBuilder2 != null) {
                b3 = stringBuilder2.iterator();
                while (b3.hasNext()) {
                    this.a((String)((Pair)b3.next()).second);
                }
                return;
            } else {
                this.a(b3.R());
            }
        }

        public abstract void d(m0.b var1);

        public abstract void e(m0.b var1, int var2, int var3);

        public void f(m0.b b3) {
        }

        public abstract void g(m0.b var1, int var2, int var3);
    }

    public static interface c {
        public c a(b var1);
    }
}

