/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$OnSharedPreferenceChangeListener
 *  android.preference.PreferenceManager
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Yi
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Objects
 */
package e1;

import a1.t;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import b1.A;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Yi;
import e1.F0;
import e1.Z;
import e1.a0;
import e1.b0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class c0 {
    private final Map a = new HashMap();
    private final List b = new ArrayList();
    private final Context c;

    c0(Context context) {
        this.c = context;
    }

    public final void a() {
        Oi oi = Yi.Ob;
        if (!((Boolean)A.c().d(oi)).booleanValue()) {
            return;
        }
        t.g();
        oi = Yi.Tb;
        oi = F0.i0((String)A.c().d(oi));
        Iterator iterator = oi.keySet().iterator();
        while (iterator.hasNext()) {
            this.c((String)iterator.next());
        }
        this.b(new b0((Map)oi));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final void b(a0 a02) {
        c0 c02 = this;
        synchronized (c02) {
            this.b.add((Object)a02);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final void c(String string) {
        c0 c02 = this;
        synchronized (c02) {
            Throwable throwable2;
            block5: {
                Map map;
                block4: {
                    try {
                        map = this.a;
                        boolean bl = map.containsKey((Object)string);
                        if (!bl) break block4;
                    }
                    catch (Throwable throwable2) {
                        break block5;
                    }
                    return;
                }
                SharedPreferences sharedPreferences = Objects.equals((Object)string, (Object)"__default__") ? PreferenceManager.getDefaultSharedPreferences((Context)this.c) : this.c.getSharedPreferences(string, 0);
                Z z2 = new Z(this, string);
                map.put((Object)string, (Object)z2);
                sharedPreferences.registerOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener)z2);
                return;
            }
            throw throwable2;
        }
    }

    final /* synthetic */ List d() {
        return this.b;
    }
}

