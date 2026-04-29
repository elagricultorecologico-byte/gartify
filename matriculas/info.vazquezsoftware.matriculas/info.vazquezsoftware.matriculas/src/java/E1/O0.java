/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.ck
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Iterator
 */
package e1;

import android.util.Log;
import com.google.android.gms.internal.ads.ck;
import f1.p;
import java.util.Iterator;

public abstract class o0
extends p {
    public static final int b = 0;

    /*
     * Enabled aggressive block sorting
     */
    public static void k(String string) {
        if (!o0.m()) return;
        if (string == null || string.length() <= 4000) {
            Log.v((String)"Ads", (String)string);
            return;
        } else {
            Iterator iterator = p.a.d((CharSequence)string).iterator();
            boolean bl = true;
            while (iterator.hasNext()) {
                string = (String)iterator.next();
                if (bl) {
                    Log.v((String)"Ads", (String)string);
                } else {
                    Log.v((String)"Ads-cont", (String)string);
                }
                bl = false;
            }
        }
    }

    public static void l(String string, Throwable throwable) {
        if (o0.m()) {
            Log.v((String)"Ads", (String)string, (Throwable)throwable);
        }
    }

    public static boolean m() {
        return p.j(2) && (Boolean)ck.a.e() != false;
    }
}

