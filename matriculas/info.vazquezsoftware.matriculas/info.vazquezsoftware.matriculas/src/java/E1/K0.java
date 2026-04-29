/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Build$VERSION
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Yi
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.WeakHashMap
 */
package e1;

import E0.k;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import b1.A;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Yi;
import e1.j0;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;

public final class k0 {
    private final BroadcastReceiver a;
    private final Map b = new WeakHashMap();
    private boolean c = false;
    private boolean d;
    private Context e;

    public k0() {
        this.a = new j0(this);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void e(Context context, Intent intent) {
        k0 k02 = this;
        synchronized (k02) {
            Throwable throwable2;
            block6: {
                ArrayList arrayList;
                try {
                    arrayList = new ArrayList();
                    for (Map.Entry entry : this.b.entrySet()) {
                        if (!((IntentFilter)entry.getValue()).hasAction(intent.getAction())) continue;
                        arrayList.add((Object)((BroadcastReceiver)entry.getKey()));
                    }
                }
                catch (Throwable throwable2) {
                    break block6;
                }
                int n2 = arrayList.size();
                for (int i2 = 0; i2 < n2; ++i2) {
                    ((BroadcastReceiver)arrayList.get(i2)).onReceive(context, intent);
                }
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(Context context) {
        k0 k02 = this;
        synchronized (k02) {
            Throwable throwable2;
            block8: {
                Context context2;
                block7: {
                    try {
                        boolean bl = this.c;
                        if (!bl) break block7;
                    }
                    catch (Throwable throwable2) {
                        break block8;
                    }
                    return;
                }
                this.e = context2 = context.getApplicationContext();
                if (context2 == null) {
                    this.e = context;
                }
                Yi.a((Context)this.e);
                context = Yi.J4;
                this.d = (Boolean)A.c().d((Oi)context);
                context = new IntentFilter();
                context.addAction("android.intent.action.SCREEN_ON");
                context.addAction("android.intent.action.SCREEN_OFF");
                context.addAction("android.intent.action.USER_PRESENT");
                context2 = Yi.tc;
                if (((Boolean)A.c().d((Oi)context2)).booleanValue() && Build.VERSION.SDK_INT >= 33) {
                    k.a(this.e, this.a, (IntentFilter)context, 4);
                } else {
                    this.e.registerReceiver(this.a, (IntentFilter)context);
                }
                this.c = true;
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void b(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        k0 k02 = this;
        synchronized (k02) {
            Throwable throwable2;
            block5: {
                try {
                    if (this.d) {
                        this.b.put((Object)broadcastReceiver, (Object)intentFilter);
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                Yi.a((Context)context);
                Oi oi = Yi.tc;
                if (((Boolean)A.c().d(oi)).booleanValue() && Build.VERSION.SDK_INT >= 33) {
                    k.a(context, broadcastReceiver, intentFilter, 4);
                    return;
                }
                context.registerReceiver(broadcastReceiver, intentFilter);
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void c(Context context, BroadcastReceiver broadcastReceiver) {
        k0 k02 = this;
        synchronized (k02) {
            Throwable throwable2;
            block4: {
                try {
                    if (this.d) {
                        this.b.remove((Object)broadcastReceiver);
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block4;
                }
                context.unregisterReceiver(broadcastReceiver);
                return;
            }
            throw throwable2;
        }
    }

    final /* synthetic */ void d(Context context, Intent intent) {
        this.e(context, intent);
    }
}

