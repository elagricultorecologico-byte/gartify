/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.provider.Settings$Global
 *  com.google.android.gms.internal.ads.Fu
 *  com.google.android.gms.internal.ads.Iu
 *  com.google.android.gms.internal.ads.Wj
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.Executor
 */
package e1;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.internal.ads.Fu;
import com.google.android.gms.internal.ads.Iu;
import com.google.android.gms.internal.ads.Wj;
import e1.d0;
import e1.o0;
import f1.m;
import f1.p;
import java.util.concurrent.Executor;
import l2.a;

public abstract class n0 {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void a(Context object) {
        int n2 = m.g;
        if (!((Boolean)Wj.a.e()).booleanValue()) return;
        try {
            n2 = Settings.Global.getInt((ContentResolver)object.getContentResolver(), (String)"development_settings_enabled", (int)0);
        }
        catch (Exception exception) {
            p.g("Fail to determine debug setting.", exception);
            return;
        }
        if (n2 == 0 || m.i()) return;
        object = new d0((Context)object).b();
        n2 = o0.b;
        p.e("Updating ad debug logging enablement.");
        Iu.a((a)object, (String)"AdDebugLogUpdater.updateEnablement", (Executor)Fu.h);
    }
}

