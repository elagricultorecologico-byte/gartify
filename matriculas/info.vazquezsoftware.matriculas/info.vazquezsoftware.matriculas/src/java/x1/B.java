/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Status
 *  java.lang.Object
 */
package x1;

import com.google.android.gms.common.api.Status;
import v1.g;

public abstract class b {
    public static v1.b a(Status status) {
        if (status.f()) {
            return new g(status);
        }
        return new v1.b(status);
    }
}

