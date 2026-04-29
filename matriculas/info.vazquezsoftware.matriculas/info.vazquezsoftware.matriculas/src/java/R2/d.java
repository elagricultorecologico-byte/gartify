/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.widget.EditText
 *  java.lang.Object
 */
package r2;

import android.content.DialogInterface;
import android.widget.EditText;
import info.vazquezsoftware.matriculas.InformacionActivity;

public final class d
implements DialogInterface.OnClickListener {
    public final InformacionActivity g;
    public final EditText h;
    public final int i;

    public /* synthetic */ d(InformacionActivity informacionActivity, EditText editText, int n2) {
        this.g = informacionActivity;
        this.h = editText;
        this.i = n2;
    }

    public final void onClick(DialogInterface dialogInterface, int n2) {
        InformacionActivity.s0(this.g, this.h, this.i, dialogInterface, n2);
    }
}

