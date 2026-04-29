/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  com.google.android.gms.internal.ads.bf
 *  com.google.android.gms.internal.ads.cf
 *  java.lang.Object
 */
package b1;

import android.os.Parcel;
import b1.e1;
import com.google.android.gms.internal.ads.bf;
import com.google.android.gms.internal.ads.cf;

public abstract class d1
extends bf
implements e1 {
    public d1() {
        super("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    protected final boolean K5(int n3, Parcel parcel, Parcel parcel2, int n4) {
        if (n3 != 1) {
            if (n3 != 2) {
                if (n3 != 3) {
                    if (n3 != 4) {
                        if (n3 != 5) {
                            return false;
                        }
                        boolean bl = cf.a((Parcel)parcel);
                        cf.h((Parcel)parcel);
                        this.c2(bl);
                    } else {
                        this.g();
                    }
                } else {
                    this.f();
                }
            } else {
                this.e();
            }
        } else {
            this.c();
        }
        parcel2.writeNoException();
        return true;
    }
}

