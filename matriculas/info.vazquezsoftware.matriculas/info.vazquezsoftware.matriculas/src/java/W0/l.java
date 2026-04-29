/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.job.JobInfo
 *  android.app.job.JobScheduler
 *  android.content.ComponentName
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.PersistableBundle
 *  android.text.TextUtils
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.background.systemjob.SystemJobService
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Locale
 */
package w0;

import B0.g;
import B0.p;
import C0.f;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import t0.n;
import t0.s;
import u0.e;
import u0.j;
import w0.k;

public class l
implements e {
    private static final String k = t0.j.f("SystemJobScheduler");
    private final Context g;
    private final JobScheduler h;
    private final j i;
    private final k j;

    public l(Context context, j j2) {
        this(context, j2, (JobScheduler)context.getSystemService("jobscheduler"), new k(context));
    }

    public l(Context context, j j2, JobScheduler jobScheduler, k k2) {
        this.g = context;
        this.i = j2;
        this.h = jobScheduler;
        this.j = k2;
    }

    public static void a(Context context) {
        JobScheduler jobScheduler = (JobScheduler)context.getSystemService("jobscheduler");
        if (jobScheduler != null && (context = l.g(context, jobScheduler)) != null && !context.isEmpty()) {
            context = context.iterator();
            while (context.hasNext()) {
                l.c(jobScheduler, ((JobInfo)context.next()).getId());
            }
        }
    }

    private static void c(JobScheduler jobScheduler, int n2) {
        try {
            jobScheduler.cancel(n2);
            return;
        }
        catch (Throwable throwable) {
            t0.j.c().b(k, String.format((Locale)Locale.getDefault(), (String)"Exception while trying to cancel job (%d)", (Object[])new Object[]{n2}), throwable);
            return;
        }
    }

    private static List d(Context context, JobScheduler jobScheduler2, String string) {
        if ((jobScheduler2 = l.g(context, jobScheduler2)) == null) {
            return null;
        }
        context = new ArrayList(2);
        for (JobScheduler jobScheduler2 : jobScheduler2) {
            if (!string.equals((Object)l.h((JobInfo)jobScheduler2))) continue;
            context.add((Object)jobScheduler2.getId());
        }
        return context;
    }

    private static List g(Context context, JobScheduler jobScheduler2) {
        try {
            jobScheduler2 = jobScheduler2.getAllPendingJobs();
        }
        catch (Throwable throwable) {
            t0.j.c().b(k, "getAllPendingJobs() is not reliable on this device.", throwable);
            jobScheduler2 = null;
        }
        if (jobScheduler2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(jobScheduler2.size());
        context = new ComponentName(context, SystemJobService.class);
        for (JobScheduler jobScheduler2 : jobScheduler2) {
            if (!context.equals((Object)jobScheduler2.getService())) continue;
            arrayList.add((Object)jobScheduler2);
        }
        return arrayList;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String h(JobInfo object) {
        PersistableBundle persistableBundle = object.getExtras();
        if (persistableBundle == null) return null;
        try {
            if (!persistableBundle.containsKey("EXTRA_WORK_SPEC_ID")) return null;
            return persistableBundle.getString("EXTRA_WORK_SPEC_ID");
        }
        catch (NullPointerException nullPointerException) {
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean i(Context context, j j2) {
        Throwable throwable2;
        block9: {
            boolean bl;
            Object object;
            block8: {
                JobScheduler jobScheduler = (JobScheduler)context.getSystemService("jobscheduler");
                Object object2 = l.g(context, jobScheduler);
                context = j2.o().y().a();
                boolean bl2 = false;
                int n2 = object2 != null ? object2.size() : 0;
                object = new HashSet(n2);
                if (object2 != null && !object2.isEmpty()) {
                    for (JobInfo jobInfo : object2) {
                        object2 = l.h(jobInfo);
                        if (!TextUtils.isEmpty((CharSequence)object2)) {
                            object.add(object2);
                            continue;
                        }
                        l.c(jobScheduler, jobInfo.getId());
                    }
                }
                jobScheduler = context.iterator();
                do {
                    bl = bl2;
                    if (!jobScheduler.hasNext()) break block8;
                } while (object.contains((Object)((String)jobScheduler.next())));
                t0.j.c().a(k, "Reconciling jobs", new Throwable[0]);
                bl = true;
            }
            if (!bl) {
                return bl;
            }
            j2 = j2.o();
            j2.c();
            try {
                object = j2.B();
                context = context.iterator();
                while (context.hasNext()) {
                    object.d((String)context.next(), -1L);
                }
            }
            catch (Throwable throwable2) {
                break block9;
            }
            j2.r();
            j2.g();
            return bl;
        }
        j2.g();
        throw throwable2;
    }

    @Override
    public void b(String string) {
        List list = l.d(this.g, this.h, string);
        if (list != null && !list.isEmpty()) {
            list = list.iterator();
            while (list.hasNext()) {
                int n2 = (Integer)list.next();
                l.c(this.h, n2);
            }
            this.i.o().y().d(string);
        }
    }

    @Override
    public boolean e() {
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void f(p ... pArray) {
        Throwable throwable2;
        WorkDatabase workDatabase = this.i.o();
        f f2 = new f(workDatabase);
        int n2 = pArray.length;
        int n3 = 0;
        while (true) {
            block9: {
                Object object;
                p p2;
                block10: {
                    if (n3 >= n2) {
                        return;
                    }
                    p2 = pArray[n3];
                    workDatabase.c();
                    try {
                        Object object2;
                        Object object3;
                        object = workDatabase.B().j(p2.a);
                        if (object == null) {
                            object3 = t0.j.c();
                            object = k;
                            object2 = new StringBuilder();
                            object2.append("Skipping scheduling ");
                            object2.append(p2.a);
                            object2.append(" because it's no longer in the DB");
                            ((t0.j)object3).h((String)object, object2.toString(), new Throwable[0]);
                            workDatabase.r();
                            break block9;
                        }
                        if (((p)object).b == s.g) break block10;
                        object2 = t0.j.c();
                        object3 = k;
                        object = new StringBuilder();
                        object.append("Skipping scheduling ");
                        object.append(p2.a);
                        object.append(" because it is no longer enqueued");
                        ((t0.j)object2).h((String)object3, object.toString(), new Throwable[0]);
                        workDatabase.r();
                        break block9;
                    }
                    catch (Throwable throwable2) {
                        break;
                    }
                }
                object = workDatabase.y().b(p2.a);
                int n4 = object != null ? ((g)object).b : f2.d(this.i.i().i(), this.i.i().g());
                if (object == null) {
                    object = new g(p2.a, n4);
                    this.i.o().y().c((g)object);
                }
                this.j(p2, n4);
                if (Build.VERSION.SDK_INT == 23 && (object = l.d(this.g, this.h, p2.a)) != null) {
                    if ((n4 = object.indexOf((Object)n4)) >= 0) {
                        object.remove(n4);
                    }
                    n4 = !object.isEmpty() ? ((Integer)object.get(0)).intValue() : f2.d(this.i.i().i(), this.i.i().g());
                    this.j(p2, n4);
                }
                workDatabase.r();
            }
            workDatabase.g();
            ++n3;
        }
        workDatabase.g();
        throw throwable2;
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void j(p var1_1, int var2_3) {
        var5_4 = this.j.a(var1_1, var2_3);
        var4_5 = t0.j.c();
        var3_6 = l.k;
        var4_5.a(var3_6, String.format((String)"Scheduling work ID %s Job ID %s", (Object[])new Object[]{var1_1.a, var2_3}), new Throwable[0]);
        try {
            if (this.h.schedule(var5_4) != 0) return;
            t0.j.c().h(var3_6, String.format((String)"Unable to schedule work ID %s", (Object[])new Object[]{var1_1.a}), new Throwable[0]);
            if (!var1_1.q || var1_1.r != n.g) return;
            var1_1.q = false;
            var4_5 = String.format((String)"Scheduling a non-expedited job (work ID %s)", (Object[])new Object[]{var1_1.a});
            t0.j.c().a(var3_6, (String)var4_5, new Throwable[0]);
            this.j(var1_1, var2_3);
            return;
        }
        catch (IllegalStateException var1_2) {}
        ** finally { 
lbl16:
        // 1 sources

        t0.j.c().b(l.k, String.format((String)"Unable to schedule %s", (Object[])new Object[]{var1_1}), new Throwable[]{var3_7});
    }
}

