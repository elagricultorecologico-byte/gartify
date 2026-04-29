/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 */
package j2;

import java.util.HashMap;
import java.util.Map;

public abstract class a {
    private static final Map a;
    private static final Map b;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        HashMap hashMap2 = new HashMap();
        b = hashMap2;
        Integer n2 = -1;
        hashMap.put((Object)n2, (Object)"The Play Store app is either not installed or not the official version.");
        Integer n3 = -2;
        hashMap.put((Object)n3, (Object)"Call first requestReviewFlow to get the ReviewInfo.");
        Integer n4 = -100;
        hashMap.put((Object)n4, (Object)"Retry with an exponential backoff. Consider filing a bug if fails consistently.");
        hashMap2.put((Object)n2, (Object)"PLAY_STORE_NOT_FOUND");
        hashMap2.put((Object)n3, (Object)"INVALID_REQUEST");
        hashMap2.put((Object)n4, (Object)"INTERNAL_ERROR");
    }

    public static String a(int n2) {
        Object object = a;
        Integer n3 = n2;
        if (!object.containsKey((Object)n3)) {
            return "";
        }
        object = (String)object.get((Object)n3);
        String string = (String)b.get((Object)n3);
        n3 = new StringBuilder();
        n3.append((String)object);
        n3.append(" (https://developer.android.com/reference/com/google/android/play/core/review/model/ReviewErrorCode.html#");
        n3.append(string);
        n3.append(")");
        return n3.toString();
    }
}

