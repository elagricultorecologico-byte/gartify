/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.job.JobInfo$Builder
 *  android.net.NetworkRequest
 *  java.lang.Object
 */
package w0;

import android.app.job.JobInfo;
import android.net.NetworkRequest;

public abstract class j {
    public static /* bridge */ /* synthetic */ JobInfo.Builder a(JobInfo.Builder builder, NetworkRequest networkRequest) {
        return builder.setRequiredNetwork(networkRequest);
    }
}

