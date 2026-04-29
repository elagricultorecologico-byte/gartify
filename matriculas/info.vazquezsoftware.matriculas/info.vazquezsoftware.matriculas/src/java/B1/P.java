/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  java.lang.Object
 *  java.lang.Override
 */
package b1;

import android.os.IBinder;
import android.os.IInterface;
import b1.i0;
import f1.r;

final class p
implements r {
    static final p a = new p();

    private /* synthetic */ p() {
    }

    @Override
    public final /* synthetic */ Object e(Object object) {
        if ((object = (IBinder)object) == null) {
            return null;
        }
        IInterface iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloaderCreator");
        if (iInterface instanceof i0) {
            return (i0)iInterface;
        }
        return new i0((IBinder)object);
    }
}

