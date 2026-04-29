/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Array
 *  x1.m
 */
package f1;

import android.os.Bundle;
import java.lang.reflect.Array;
import x1.m;

public abstract class q {
    public static boolean a(Bundle bundle, Bundle bundle2) {
        Object object3;
        Object object2;
        block10: {
            object2 = bundle;
            object3 = bundle2;
            if (bundle != null) {
                object2 = bundle;
                object3 = bundle2;
                if (bundle2 != null) {
                    if (bundle.size() != bundle2.size()) {
                        return false;
                    }
                    for (Object object3 : bundle.keySet()) {
                        if (!bundle2.containsKey((String)object3)) {
                            return false;
                        }
                        object2 = bundle.get((String)object3);
                        object3 = bundle2.get((String)object3);
                        if (object2 != null && object3 != null) {
                            if (object2 instanceof Bundle) {
                                if (object3 instanceof Bundle && q.a(object2, object3)) continue;
                                return false;
                            }
                            if (object2.getClass().isArray()) {
                                int n2 = Array.getLength((Object)object2);
                                if (object3.getClass().isArray() && n2 == Array.getLength((Object)object3)) {
                                    for (int i2 = 0; i2 < n2; ++i2) {
                                        if (m.a((Object)Array.get((Object)object2, (int)i2), (Object)Array.get((Object)object3, (int)i2))) continue;
                                        return false;
                                    }
                                    continue;
                                }
                                return false;
                            }
                            if (object2.equals(object3)) continue;
                            return false;
                        }
                        object3 = bundle = object3;
                        break block10;
                    }
                    return true;
                }
            }
        }
        return object2 == null && object3 == null;
    }
}

