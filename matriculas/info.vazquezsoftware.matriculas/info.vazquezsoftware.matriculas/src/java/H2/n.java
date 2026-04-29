/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Map
 */
package h2;

import i2.i;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public abstract class n {
    private static final Map a;

    static {
        new HashSet((Collection)Arrays.asList((Object[])new String[]{"native", "unity"}));
        a = new HashMap();
        new i("PlayCoreVersion");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Map a() {
        Class<n> clazz = n.class;
        synchronized (n.class) {
            Map map = a;
            map.put((Object)"java", (Object)20002);
            // ** MonitorExit[var1] (shouldn't be in output)
            return map;
        }
    }
}

