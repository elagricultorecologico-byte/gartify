/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Map
 *  java.util.Set
 */
package e1;

import a1.t;
import android.content.SharedPreferences;
import e1.a0;
import java.util.Map;
import java.util.Set;

final class b0
implements a0 {
    private final Map a;

    /* synthetic */ b0(Map map) {
        this.a = map;
    }

    @Override
    public final /* synthetic */ void a(SharedPreferences sharedPreferences, String string, String string2) {
        sharedPreferences = this.a;
        if (sharedPreferences.containsKey((Object)string) && ((Set)sharedPreferences.get((Object)string)).contains((Object)string2)) {
            t.l().r().a(false);
        }
    }
}

