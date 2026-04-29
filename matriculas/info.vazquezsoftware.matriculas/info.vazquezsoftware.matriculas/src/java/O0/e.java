/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.job.JobParameters
 *  com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService
 *  java.lang.Object
 *  java.lang.Runnable
 */
package O0;

import android.app.job.JobParameters;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;

public final class e
implements Runnable {
    public final JobInfoSchedulerService g;
    public final JobParameters h;

    public /* synthetic */ e(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.g = jobInfoSchedulerService;
        this.h = jobParameters;
    }

    public final void run() {
        JobInfoSchedulerService.a((JobInfoSchedulerService)this.g, (JobParameters)this.h);
    }
}

