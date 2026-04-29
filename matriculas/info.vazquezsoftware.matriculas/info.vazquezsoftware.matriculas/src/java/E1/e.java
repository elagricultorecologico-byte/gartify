/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  java.lang.Object
 */
package e1;

import android.content.DialogInterface;
import e1.u;

final class e
implements DialogInterface.OnClickListener {
    private final u g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;

    /* synthetic */ e(u u2, int n2, int n3, int n4, int n5, int n6) {
        this.g = u2;
        this.h = n2;
        this.i = n3;
        this.j = n4;
        this.k = n5;
        this.l = n6;
    }

    public final /* synthetic */ void onClick(DialogInterface dialogInterface, int n2) {
        this.g.h(this.h, this.i, this.j, this.k, this.l, dialogInterface, n2);
    }
}

