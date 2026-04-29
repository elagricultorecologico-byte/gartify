/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.app.c
 *  java.lang.Object
 */
package q2;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.c;
import q2.h;

public final class f
implements View.OnClickListener {
    public final Activity g;
    public final c h;

    public /* synthetic */ f(Activity activity, c c3) {
        this.g = activity;
        this.h = c3;
    }

    public final void onClick(View view) {
        q2.h.c(this.g, this.h, view);
    }
}

