/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.job.JobParameters
 *  android.net.Uri
 *  java.lang.Object
 */
package w0;

import android.app.job.JobParameters;
import android.net.Uri;

public abstract class m {
    public static /* bridge */ /* synthetic */ Uri[] a(JobParameters jobParameters) {
        return jobParameters.getTriggeredContentUris();
    }
}

