/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.job.JobInfo$TriggerContentUri
 *  android.net.Uri
 *  java.lang.Object
 */
package w0;

import android.app.job.JobInfo;
import android.net.Uri;

public abstract class h {
    public static /* synthetic */ JobInfo.TriggerContentUri a(Uri uri, int n2) {
        return new JobInfo.TriggerContentUri(uri, n2);
    }
}

