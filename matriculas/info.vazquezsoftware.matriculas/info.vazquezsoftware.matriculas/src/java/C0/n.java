/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.WeakHashMap
 *  t0.j
 */
package C0;

import android.content.Context;
import android.os.PowerManager;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import t0.j;

public abstract class n {
    private static final String a = j.f((String)"WakeLocks");
    private static final WeakHashMap b = new WeakHashMap();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a() {
        WeakHashMap weakHashMap;
        HashMap hashMap = new HashMap();
        WeakHashMap weakHashMap2 = weakHashMap = b;
        synchronized (weakHashMap2) {
            hashMap.putAll((Map)weakHashMap);
        }
        weakHashMap = hashMap.keySet().iterator();
        while (weakHashMap.hasNext()) {
            Object object = (PowerManager.WakeLock)weakHashMap.next();
            if (object == null || !object.isHeld()) continue;
            object = String.format((String)"WakeLock held for %s", (Object[])new Object[]{hashMap.get(object)});
            j.c().h(a, (String)object, new Throwable[0]);
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static PowerManager.WakeLock b(Context object, String string) {
        PowerManager powerManager = (PowerManager)object.getApplicationContext().getSystemService("power");
        object = new StringBuilder();
        object.append("WorkManager: ");
        object.append(string);
        object = object.toString();
        powerManager = powerManager.newWakeLock(1, (String)object);
        String string2 = string = b;
        synchronized (string2) {
            string.put((Object)powerManager, object);
            return powerManager;
        }
    }
}

