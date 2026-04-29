/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.job.JobInfo
 *  android.app.job.JobInfo$Builder
 *  android.app.job.JobInfo$TriggerContentUri
 *  android.content.ComponentName
 *  android.content.Context
 *  android.net.NetworkRequest$Builder
 *  android.os.Build$VERSION
 *  android.os.PersistableBundle
 *  androidx.core.os.a
 *  androidx.work.impl.background.systemjob.SystemJobService
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 */
package w0;

import B0.p;
import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.impl.background.systemjob.SystemJobService;
import t0.c;
import w0.b;
import w0.c;
import w0.d;
import w0.e;
import w0.f;
import w0.g;
import w0.h;
import w0.i;
import w0.j;

class k {
    private static final String b = t0.j.f("SystemJobInfoConverter");
    private final ComponentName a;

    k(Context context) {
        this.a = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }

    private static JobInfo.TriggerContentUri b(c.a a2) {
        int n2 = a2.b();
        i.a();
        return h.a(a2.a(), n2);
    }

    static int c(t0.k k2) {
        int n2 = w0.k$a.a[k2.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    if (n2 != 4) {
                        if (n2 == 5 && Build.VERSION.SDK_INT >= 26) {
                            return 4;
                        }
                    } else if (Build.VERSION.SDK_INT >= 24) {
                        return 3;
                    }
                    t0.j.c().a(b, String.format((String)"API version too low. Cannot convert network type value %s", (Object[])new Object[]{k2}), new Throwable[0]);
                    return 1;
                }
                return 2;
            }
            return 1;
        }
        return 0;
    }

    static void d(JobInfo.Builder builder, t0.k k2) {
        if (Build.VERSION.SDK_INT >= 30 && k2 == t0.k.l) {
            j.a(builder, new NetworkRequest.Builder().addCapability(25).build());
            return;
        }
        builder.setRequiredNetworkType(k.c(k2));
    }

    JobInfo a(p p2, int n2) {
        t0.b b2 = p2.j;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", p2.a);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", p2.d());
        JobInfo.Builder builder = new JobInfo.Builder(n2, this.a).setRequiresCharging(b2.g()).setRequiresDeviceIdle(b2.h()).setExtras(persistableBundle);
        k.d(builder, b2.b());
        boolean bl = b2.h();
        int n3 = 0;
        if (!bl) {
            n2 = p2.l == t0.a.h ? 0 : 1;
            builder.setBackoffCriteria(p2.m, n2);
        }
        long l2 = Math.max((long)(p2.a() - System.currentTimeMillis()), (long)0L);
        n2 = Build.VERSION.SDK_INT;
        if (n2 <= 28) {
            builder.setMinimumLatency(l2);
        } else if (l2 > 0L) {
            builder.setMinimumLatency(l2);
        } else if (!p2.q) {
            w0.a.a(builder, true);
        }
        if (n2 >= 24 && b2.e()) {
            persistableBundle = b2.a().b().iterator();
            while (persistableBundle.hasNext()) {
                w0.b.a(builder, k.b((c.a)persistableBundle.next()));
            }
            c.a(builder, b2.c());
            d.a(builder, b2.d());
        }
        builder.setPersisted(false);
        if (Build.VERSION.SDK_INT >= 26) {
            e.a(builder, b2.f());
            f.a(builder, b2.i());
        }
        n2 = n3;
        if (p2.k > 0) {
            n2 = 1;
        }
        if (androidx.core.os.a.b() && p2.q && n2 == 0) {
            g.a(builder, true);
        }
        return builder.build();
    }
}

