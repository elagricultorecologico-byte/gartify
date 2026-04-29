/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentProviderClient
 *  android.content.res.TypedArray
 *  android.drm.DrmManagerClient
 *  android.media.MediaDrm
 *  android.media.MediaMetadataRetriever
 *  java.lang.AutoCloseable
 *  java.lang.Object
 *  java.util.concurrent.ExecutorService
 */
package C;

import C.g;
import C.h;
import android.content.ContentProviderClient;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import java.util.concurrent.ExecutorService;

public abstract class f {
    public static /* synthetic */ void a(Object object) {
        if (object instanceof AutoCloseable) {
            ((AutoCloseable)object).close();
            return;
        }
        if (object instanceof ExecutorService) {
            g.a((ExecutorService)object);
            return;
        }
        if (object instanceof TypedArray) {
            ((TypedArray)object).recycle();
            return;
        }
        if (object instanceof MediaMetadataRetriever) {
            ((MediaMetadataRetriever)object).release();
            return;
        }
        if (object instanceof MediaDrm) {
            ((MediaDrm)object).release();
            return;
        }
        if (object instanceof DrmManagerClient) {
            ((DrmManagerClient)object).release();
            return;
        }
        if (object instanceof ContentProviderClient) {
            ((ContentProviderClient)object).release();
            return;
        }
        h.a(object);
    }
}

