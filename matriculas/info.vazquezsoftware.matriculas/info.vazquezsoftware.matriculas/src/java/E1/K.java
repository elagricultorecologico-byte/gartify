/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  java.lang.Object
 *  java.util.concurrent.atomic.AtomicInteger
 */
package e1;

import android.content.DialogInterface;
import java.util.concurrent.atomic.AtomicInteger;

final class k
implements DialogInterface.OnClickListener {
    private final AtomicInteger g;

    /* synthetic */ k(AtomicInteger atomicInteger) {
        this.g = atomicInteger;
    }

    public final /* synthetic */ void onClick(DialogInterface dialogInterface, int n2) {
        this.g.set(n2);
    }
}

