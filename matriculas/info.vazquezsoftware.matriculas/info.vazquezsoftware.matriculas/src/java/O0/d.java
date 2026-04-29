/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.job.JobInfo
 *  android.app.job.JobInfo$Builder
 *  android.app.job.JobScheduler
 *  android.content.ComponentName
 *  android.content.Context
 *  android.os.PersistableBundle
 *  android.util.Base64
 *  com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 *  java.util.zip.Adler32
 */
package O0;

import H0.o;
import O0.f;
import O0.x;
import S0.a;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

public class d
implements x {
    private final Context a;
    private final P0.d b;
    private final f c;

    public d(Context context, P0.d d2, f f2) {
        this.a = context;
        this.b = d2;
        this.c = f2;
    }

    private boolean d(JobScheduler jobScheduler, int n2, int n3) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int n4 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() != n2) continue;
            if (n4 < n3) break;
            return true;
        }
        return false;
    }

    @Override
    public void a(o o2, int n2, boolean bl) {
        ComponentName componentName = new ComponentName(this.a, JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler)this.a.getSystemService("jobscheduler");
        int n3 = this.c(o2);
        if (!bl && this.d(jobScheduler, n3, n2)) {
            L0.a.b("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", o2);
            return;
        }
        long l2 = this.b.t(o2);
        componentName = this.c.c(new JobInfo.Builder(n3, componentName), o2.d(), l2, n2);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", n2);
        persistableBundle.putString("backendName", o2.b());
        persistableBundle.putInt("priority", S0.a.a(o2.d()));
        if (o2.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString((byte[])o2.c(), (int)0));
        }
        componentName.setExtras(persistableBundle);
        L0.a.c("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", o2, n3, this.c.g(o2.d(), l2, n2), l2, n2);
        jobScheduler.schedule(componentName.build());
    }

    @Override
    public void b(o o2, int n2) {
        this.a(o2, n2, false);
    }

    int c(o o2) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.a.getPackageName().getBytes(Charset.forName((String)"UTF-8")));
        adler32.update(o2.b().getBytes(Charset.forName((String)"UTF-8")));
        adler32.update(ByteBuffer.allocate((int)4).putInt(S0.a.a(o2.d())).array());
        if (o2.c() != null) {
            adler32.update(o2.c());
        }
        return (int)adler32.getValue();
    }
}

