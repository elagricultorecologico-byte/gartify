/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  java.lang.Object
 */
package i2;

import android.os.IBinder;
import android.os.IInterface;
import i2.b;
import i2.d;
import i2.f;

public abstract class e
extends b
implements f {
    public static f Z(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.play.core.inappreview.protocol.IInAppReviewService");
        if (iInterface instanceof f) {
            return (f)iInterface;
        }
        return new d(iBinder);
    }
}

