/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  com.google.android.gms.internal.ads.bf
 *  com.google.android.gms.internal.ads.cf
 *  java.lang.Object
 *  java.lang.String
 */
package b1;

import C1.a;
import android.os.Parcel;
import b1.T0;
import com.google.android.gms.internal.ads.bf;
import com.google.android.gms.internal.ads.cf;

public abstract class S0
extends bf
implements T0 {
    public S0() {
        super("com.google.android.gms.ads.internal.client.IOutOfContextTester");
    }

    protected final boolean K5(int n3, Parcel parcel, Parcel parcel2, int n4) {
        if (n3 == 1) {
            String string = parcel.readString();
            a a3 = a.a.Z(parcel.readStrongBinder());
            a a4 = a.a.Z(parcel.readStrongBinder());
            cf.h((Parcel)parcel);
            this.b2(string, a3, a4);
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}

