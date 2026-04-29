/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.net.Uri
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package e1;

import a1.t;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import e1.F0;
import e1.x;
import java.util.Objects;

final class w
implements DialogInterface.OnClickListener {
    final Context g;

    w(x x2, Context context) {
        this.g = context;
        Objects.requireNonNull((Object)x2);
    }

    public final void onClick(DialogInterface dialogInterface, int n2) {
        t.g();
        F0.z(this.g, Uri.parse((String)"https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}

