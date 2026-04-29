/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.view.View
 *  android.view.View$OnClickListener
 *  java.lang.Object
 */
package r2;

import android.app.Dialog;
import android.view.View;
import info.vazquezsoftware.matriculas.MainActivity;

public final class l
implements View.OnClickListener {
    public final Dialog g;

    public /* synthetic */ l(Dialog dialog) {
        this.g = dialog;
    }

    public final void onClick(View view) {
        MainActivity.o0(this.g, view);
    }
}

