/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.impl.WorkDatabase
 *  java.lang.Long
 *  java.lang.Object
 *  m0.b
 */
package C0;

import B0.d;
import android.content.Context;
import androidx.work.impl.WorkDatabase;
import m0.b;

public class h {
    private final WorkDatabase a;

    public h(WorkDatabase workDatabase) {
        this.a = workDatabase;
    }

    public static void b(Context context, b b2) {
        if (!(context = context.getSharedPreferences("androidx.work.util.preferences", 0)).contains("reschedule_needed") && !context.contains("last_cancel_all_time_ms")) {
            return;
        }
        long l2 = 0L;
        long l3 = context.getLong("last_cancel_all_time_ms", 0L);
        if (context.getBoolean("reschedule_needed", false)) {
            l2 = 1L;
        }
        b2.m();
        try {
            b2.m0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", l3});
            b2.m0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", l2});
            context.edit().clear().apply();
            b2.h0();
            return;
        }
        finally {
            b2.l();
        }
    }

    public boolean a() {
        Long l2 = this.a.x().b("reschedule_needed");
        return l2 != null && l2 == 1L;
    }

    public void c(boolean bl) {
        d d2 = new d("reschedule_needed", bl);
        this.a.x().a(d2);
    }
}

