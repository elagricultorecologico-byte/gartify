/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  java.lang.Object
 *  java.util.Objects
 */
package d1;

import android.view.View;
import d1.B;
import java.util.Objects;

final class n
implements View.OnClickListener {
    final B g;

    n(B b2) {
        Objects.requireNonNull((Object)b2);
        this.g = b2;
    }

    public final void onClick(View object) {
        object = this.g;
        object.B = 2;
        object.g.finish();
    }
}

