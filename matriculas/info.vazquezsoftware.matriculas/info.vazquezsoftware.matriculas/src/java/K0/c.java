/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Map
 */
package k0;

import I2.E;
import V2.k;
import android.os.Bundle;
import java.util.List;
import java.util.Map;
import k0.d;

public abstract class c {
    public static Bundle a(Bundle bundle) {
        k.e(bundle, "source");
        return bundle;
    }

    public static final boolean b(Bundle bundle, String string) {
        k.e(string, "key");
        return bundle.containsKey(string);
    }

    public static final Bundle c(Bundle bundle, String string) {
        k.e(string, "key");
        bundle = bundle.getBundle(string);
        if (bundle != null) {
            return bundle;
        }
        d.a(string);
        throw new H2.d();
    }

    public static final Bundle d(Bundle bundle, String string) {
        k.e(string, "key");
        return bundle.getBundle(string);
    }

    public static final List e(Bundle bundle, String string) {
        k.e(string, "key");
        return bundle.getStringArrayList(string);
    }

    public static final boolean f(Bundle bundle) {
        return bundle.isEmpty();
    }

    public static final Map g(Bundle bundle) {
        Map map = E.b(bundle.size());
        for (String string : bundle.keySet()) {
            k.b(string);
            map.put((Object)string, bundle.get(string));
        }
        return E.a(map);
    }
}

