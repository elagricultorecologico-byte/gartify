/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Objects
 */
package e1;

import a1.t;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import e1.F0;
import e1.w;
import e1.y;
import java.util.Objects;

final class x
implements Runnable {
    final Context g;
    final String h;
    final boolean i;
    final boolean j;

    x(y y2, Context context, String string, boolean bl, boolean bl2) {
        this.g = context;
        this.h = string;
        this.i = bl;
        this.j = bl2;
        Objects.requireNonNull((Object)y2);
    }

    public final void run() {
        t.g();
        Context context = this.g;
        AlertDialog.Builder builder = F0.n(context);
        builder.setMessage((CharSequence)this.h);
        if (this.i) {
            builder.setTitle((CharSequence)"Error");
        } else {
            builder.setTitle((CharSequence)"Info");
        }
        if (this.j) {
            builder.setNeutralButton((CharSequence)"Dismiss", null);
        } else {
            builder.setPositiveButton((CharSequence)"Learn More", (DialogInterface.OnClickListener)new w(this, context));
            builder.setNegativeButton((CharSequence)"Dismiss", null);
        }
        builder.create().show();
    }
}

