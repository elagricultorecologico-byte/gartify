/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.Override
 */
package d1;

import android.app.Activity;
import android.os.Bundle;
import d1.B;
import e1.o0;

public final class I
extends B {
    public I(Activity activity) {
        super(activity);
    }

    @Override
    public final void I4(Bundle bundle) {
        o0.k("AdOverlayParcel is null or does not contain valid overlay type.");
        this.B = 4;
        this.g.finish();
    }
}

