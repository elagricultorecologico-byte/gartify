/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Status
 *  java.lang.Object
 */
package w1;

import L1.j;
import com.google.android.gms.common.api.Status;
import x1.b;

public abstract class o {
    public static void a(Status status, Object object, j j2) {
        if (status.g()) {
            j2.c(object);
            return;
        }
        j2.b(b.a(status));
    }
}

