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
import b1.z0;

final class r
implements f1.r {
    static final r a = new r();

    private /* synthetic */ r() {
    }

    @Override
    public final /* synthetic */ Object e(Object object) {
        if ((object = (IBinder)object) == null) {
            return null;
        }
        IInterface iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        if (iInterface instanceof z0) {
            return (z0)iInterface;
        }
        return new z0((IBinder)object);
    }
}

