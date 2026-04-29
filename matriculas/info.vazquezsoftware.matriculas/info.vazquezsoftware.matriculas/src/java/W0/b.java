/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.job.JobInfo$Builder
 *  android.app.job.JobInfo$TriggerContentUri
 *  java.lang.Object
 */
package w0;

import android.app.job.JobInfo;

public abstract class b {
    public static /* bridge */ /* synthetic */ JobInfo.Builder a(JobInfo.Builder builder, JobInfo.TriggerContentUri triggerContentUri) {
        return builder.addTriggerContentUri(triggerContentUri);
    }
}

