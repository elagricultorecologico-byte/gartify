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
import b1.S;
import f1.r;

final class n
implements r {
    static final n a = new n();

    private /* synthetic */ n() {
    }

    @Override
    public final /* synthetic */ Object e(Object object) {
        IBinder iBinder = (IBinder)object;
        if (iBinder == null) {
            return null;
        }
        object = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        if (object instanceof S) {
            return (S)((Object)object);
        }
        return new S(iBinder);
    }
}

