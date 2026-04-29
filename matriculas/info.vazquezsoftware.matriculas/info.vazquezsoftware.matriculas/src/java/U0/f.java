/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.a
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.background.systemjob.SystemJobService
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.List
 *  w0.l
 */
package u0;

import B0.p;
import C0.g;
import android.content.Context;
import androidx.work.a;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.List;
import u0.e;
import u0.j;
import w0.l;

public abstract class f {
    private static final String a = t0.j.f("Schedulers");

    static e a(Context context, j j2) {
        j2 = new l(context, j2);
        g.a(context, SystemJobService.class, true);
        t0.j.c().a(a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
        return j2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void b(a pArray, WorkDatabase workDatabase, List object) {
        Throwable throwable2;
        block8: {
            Object object2;
            List list;
            p[] pArray2;
            block7: {
                if (object == null) return;
                if (object.size() == 0) {
                    return;
                }
                pArray2 = workDatabase.B();
                workDatabase.c();
                try {
                    list = pArray2.i(pArray.h());
                    pArray = pArray2.s(200);
                    if (list == null || list.size() <= 0) break block7;
                    long l2 = System.currentTimeMillis();
                    object2 = list.iterator();
                    while (object2.hasNext()) {
                        pArray2.d(((p)object2.next()).a, l2);
                    }
                }
                catch (Throwable throwable2) {
                    break block8;
                }
            }
            workDatabase.r();
            workDatabase.g();
            if (list != null && list.size() > 0) {
                pArray2 = (p[])list.toArray((Object[])new p[list.size()]);
                workDatabase = object.iterator();
                while (workDatabase.hasNext()) {
                    object2 = (e)workDatabase.next();
                    if (!object2.e()) continue;
                    object2.f(pArray2);
                }
            }
            if (pArray == null) return;
            if (pArray.size() <= 0) return;
            pArray = (p[])pArray.toArray((Object[])new p[pArray.size()]);
            workDatabase = object.iterator();
            while (workDatabase.hasNext()) {
                object = (e)workDatabase.next();
                if (object.e()) continue;
                object.f(pArray);
            }
            return;
        }
        workDatabase.g();
        throw throwable2;
    }
}

