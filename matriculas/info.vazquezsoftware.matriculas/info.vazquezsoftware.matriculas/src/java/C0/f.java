/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.impl.WorkDatabase
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  m0.b
 */
package C0;

import B0.d;
import android.content.Context;
import androidx.work.impl.WorkDatabase;
import m0.b;

public class f {
    private final WorkDatabase a;

    public f(WorkDatabase workDatabase) {
        this.a = workDatabase;
    }

    public static void a(Context context, b b2) {
        if (!(context = context.getSharedPreferences("androidx.work.util.id", 0)).contains("next_job_scheduler_id") && !context.contains("next_job_scheduler_id")) {
            return;
        }
        int n2 = context.getInt("next_job_scheduler_id", 0);
        int n3 = context.getInt("next_alarm_manager_id", 0);
        b2.m();
        try {
            b2.m0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", n2});
            b2.m0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", n3});
            context.edit().clear().apply();
            b2.h0();
            return;
        }
        finally {
            b2.l();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int c(String string) {
        Throwable throwable2;
        block3: {
            int n2;
            int n3;
            this.a.c();
            try {
                Long l2 = this.a.x().b(string);
                n3 = 0;
                n2 = l2 != null ? l2.intValue() : 0;
            }
            catch (Throwable throwable2) {
                break block3;
            }
            if (n2 != Integer.MAX_VALUE) {
                n3 = n2 + 1;
            }
            this.e(string, n3);
            this.a.r();
            this.a.g();
            return n2;
        }
        this.a.g();
        throw throwable2;
    }

    private void e(String string, int n2) {
        this.a.x().a(new d(string, n2));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int b() {
        Class<f> clazz = f.class;
        synchronized (f.class) {
            return this.c("next_alarm_manager_id");
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int d(int n2, int n3) {
        Class<f> clazz = f.class;
        synchronized (f.class) {
            int n4 = this.c("next_job_scheduler_id");
            if (n4 >= n2) {
                if (n4 <= n3) return n4;
            }
            this.e("next_job_scheduler_id", n2 + 1);
            // ** MonitorExit[var5_3] (shouldn't be in output)
            return n2;
        }
    }
}

