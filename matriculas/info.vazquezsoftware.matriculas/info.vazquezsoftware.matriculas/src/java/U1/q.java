/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.os.Bundle
 *  androidx.fragment.app.e
 *  androidx.fragment.app.n
 *  java.lang.Object
 *  java.lang.String
 */
package u1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.e;
import androidx.fragment.app.n;

public class q
extends e {
    private Dialog A0;
    private Dialog y0;
    private DialogInterface.OnCancelListener z0;

    public static q R1(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        q q2 = new q();
        dialog = (Dialog)x1.n.j(dialog, "Cannot display null dialog");
        dialog.setOnCancelListener(null);
        dialog.setOnDismissListener(null);
        q2.y0 = dialog;
        if (onCancelListener != null) {
            q2.z0 = onCancelListener;
        }
        return q2;
    }

    public Dialog J1(Bundle bundle) {
        Dialog dialog = this.y0;
        bundle = dialog;
        if (dialog == null) {
            this.O1(false);
            if (this.A0 == null) {
                this.A0 = new AlertDialog.Builder((Context)x1.n.i(this.s())).create();
            }
            bundle = this.A0;
        }
        return bundle;
    }

    public void Q1(n n2, String string) {
        super.Q1(n2, string);
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.z0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}

