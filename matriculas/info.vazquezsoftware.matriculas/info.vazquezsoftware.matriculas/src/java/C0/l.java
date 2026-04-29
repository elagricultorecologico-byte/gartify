/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.WorkerParameters$a
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  u0.j
 */
package C0;

import androidx.work.WorkerParameters;
import u0.j;

public class l
implements Runnable {
    private j g;
    private String h;
    private WorkerParameters.a i;

    public l(j j2, String string, WorkerParameters.a a2) {
        this.g = j2;
        this.h = string;
        this.i = a2;
    }

    public void run() {
        this.g.m().k(this.h, this.i);
    }
}

