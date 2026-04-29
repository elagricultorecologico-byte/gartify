/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  java.lang.Object
 */
package e1;

import android.content.DialogInterface;
import e1.u;

final class n
implements DialogInterface.OnCancelListener {
    private final u g;

    /* synthetic */ n(u u2) {
        this.g = u2;
    }

    public final /* synthetic */ void onCancel(DialogInterface dialogInterface) {
        this.g.b();
    }
}

