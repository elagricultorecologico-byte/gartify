/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.app.Dialog
 *  android.app.DialogFragment
 *  android.app.FragmentManager
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 *  x1.n
 */
package u1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import x1.n;

public class c
extends DialogFragment {
    private Dialog g;
    private DialogInterface.OnCancelListener h;
    private Dialog i;

    public static c a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        c c3 = new c();
        dialog = (Dialog)n.j((Object)dialog, (Object)"Cannot display null dialog");
        dialog.setOnCancelListener(null);
        dialog.setOnDismissListener(null);
        c3.g = dialog;
        if (onCancelListener != null) {
            c3.h = onCancelListener;
        }
        return c3;
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.h;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.g;
        bundle = dialog;
        if (dialog == null) {
            this.setShowsDialog(false);
            if (this.i == null) {
                this.i = new AlertDialog.Builder((Context)n.i((Object)this.getActivity())).create();
            }
            bundle = this.i;
        }
        return bundle;
    }

    public void show(FragmentManager fragmentManager, String string) {
        super.show(fragmentManager, string);
    }
}

