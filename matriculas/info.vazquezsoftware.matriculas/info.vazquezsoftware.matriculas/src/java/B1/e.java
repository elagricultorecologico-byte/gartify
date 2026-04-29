/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  java.lang.Object
 *  java.lang.Override
 */
package b1;

import android.os.IBinder;
import b1.U0;
import f1.r;

final class e
implements r {
    static final e a = new e();

    private /* synthetic */ e() {
    }

    @Override
    public final /* synthetic */ Object e(Object object) {
        IBinder iBinder = (IBinder)object;
        if (iBinder == null) {
            return null;
        }
        object = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOutOfContextTesterCreator");
        if (object instanceof U0) {
            return (U0)((Object)object);
        }
        return new U0(iBinder);
    }
}

