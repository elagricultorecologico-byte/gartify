/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 */
package u0;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import t0.j;

public abstract class h {
    private static final String a = j.f("WrkDbPathHelper");
    private static final String[] b = new String[]{"-journal", "-shm", "-wal"};

    public static File a(Context context) {
        return h.c(context, "androidx.work.workdb");
    }

    public static File b(Context context) {
        return context.getDatabasePath("androidx.work.workdb");
    }

    private static File c(Context context, String string) {
        return new File(context.getNoBackupFilesDir(), string);
    }

    public static String d() {
        return "androidx.work.workdb";
    }

    public static void e(Context object) {
        if (h.b(object).exists()) {
            j.c().a(a, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
            Map map = h.f(object);
            for (File file : map.keySet()) {
                object = (File)map.get((Object)file);
                if (!file.exists() || object == null) continue;
                if (object.exists()) {
                    String string = String.format((String)"Over-writing contents of %s", (Object[])new Object[]{object});
                    j.c().h(a, string, new Throwable[0]);
                }
                object = file.renameTo((File)object) ? String.format((String)"Migrated %s to %s", (Object[])new Object[]{file, object}) : String.format((String)"Renaming %s to %s failed", (Object[])new Object[]{file, object});
                j.c().a(a, (String)object, new Throwable[0]);
            }
        }
    }

    public static Map f(Context object2) {
        HashMap hashMap = new HashMap();
        File file = h.b((Context)object2);
        File file2 = h.a((Context)object2);
        hashMap.put((Object)file, (Object)file2);
        for (String string : b) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(file.getPath());
            stringBuilder.append(string);
            File file3 = new File(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(file2.getPath());
            stringBuilder.append(string);
            hashMap.put((Object)file3, (Object)new File(stringBuilder.toString()));
        }
        return hashMap;
    }
}

