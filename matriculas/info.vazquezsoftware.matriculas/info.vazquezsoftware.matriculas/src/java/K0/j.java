/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.List
 */
package k0;

import android.os.Bundle;
import java.util.Collection;
import java.util.List;
import k0.k;

public abstract class j {
    public static Bundle a(Bundle bundle) {
        V2.k.e(bundle, "source");
        return bundle;
    }

    public static final void b(Bundle bundle, Bundle bundle2) {
        V2.k.e(bundle2, "from");
        bundle.putAll(bundle2);
    }

    public static final void c(Bundle bundle, String string, Bundle bundle2) {
        V2.k.e(string, "key");
        V2.k.e(bundle2, "value");
        bundle.putBundle(string, bundle2);
    }

    public static final void d(Bundle bundle, String string, List list) {
        V2.k.e(string, "key");
        V2.k.e(list, "value");
        bundle.putStringArrayList(string, k.a((Collection)list));
    }

    public static final void e(Bundle bundle, String string) {
        V2.k.e(string, "key");
        bundle.remove(string);
    }
}

