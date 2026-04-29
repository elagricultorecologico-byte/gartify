/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  java.lang.Object
 *  java.lang.String
 */
package e1;

import android.content.DialogInterface;
import e1.u;

final class o
implements DialogInterface.OnClickListener {
    private final u g;
    private final String h;

    /* synthetic */ o(u u2, String string) {
        this.g = u2;
        this.h = string;
    }

    public final /* synthetic */ void onClick(DialogInterface dialogInterface, int n2) {
        this.g.j(this.h, dialogInterface, n2);
    }
}

