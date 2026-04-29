/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.MatrixCursor
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package j0;

import android.database.Cursor;
import android.database.MatrixCursor;

public abstract class b {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Cursor a(Cursor var0) {
        block12: {
            block11: {
                block10: {
                    block6: {
                        block7: {
                            block8: {
                                block9: {
                                    try {
                                        var4_1 = new MatrixCursor(var0.getColumnNames(), var0.getCount());
lbl3:
                                        // 2 sources

                                        while (var0.moveToNext()) {
                                            var3_4 = new Object[var0.getColumnCount()];
                                            var1_2 = 0;
lbl6:
                                            // 2 sources

                                            while (var1_2 < var0.getColumnCount()) {
                                                var2_3 = var0.getType(var1_2);
                                                if (var2_3 == 0) break block6;
                                                if (var2_3 == 1) break block7;
                                                if (var2_3 == 2) break block8;
                                                if (var2_3 == 3) break block9;
                                                if (var2_3 != 4) {
                                                    var3_4 = new IllegalStateException();
                                                    throw var3_4;
                                                }
                                                var3_4[var1_2] = (IllegalStateException)var0.getBlob(var1_2);
                                                break block10;
                                            }
                                            ** GOTO lbl-1000
                                        }
                                        break block11;
                                    }
                                    catch (Throwable var3_5) {
                                        break block12;
                                    }
                                }
                                var3_4[var1_2] = var0.getString(var1_2);
                                break block10;
                            }
                            var3_4[var1_2] = var0.getDouble(var1_2);
                            break block10;
                        }
                        var3_4[var1_2] = var0.getLong(var1_2);
                        break block10;
                    }
                    var3_4[var1_2] = null;
                }
                ++var1_2;
                ** GOTO lbl6
lbl-1000:
                // 1 sources

                {
                    var4_1.addRow((Object[])var3_4);
                    ** GOTO lbl3
                }
            }
            var0.close();
            return var4_1;
        }
        var0.close();
        throw var3_5;
    }

    public static int b(Cursor cursor, String string) {
        int n2 = cursor.getColumnIndex(string);
        if (n2 >= 0) {
            return n2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("`");
        stringBuilder.append(string);
        stringBuilder.append("`");
        return cursor.getColumnIndexOrThrow(stringBuilder.toString());
    }
}

