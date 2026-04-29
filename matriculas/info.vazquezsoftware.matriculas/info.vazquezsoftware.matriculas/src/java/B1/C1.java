/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  com.google.android.gms.internal.ads.af
 *  com.google.android.gms.internal.ads.cf
 *  java.lang.Object
 *  java.lang.Override
 */
package b1;

import android.os.IBinder;
import android.os.Parcel;
import b1.e1;
import com.google.android.gms.internal.ads.af;
import com.google.android.gms.internal.ads.cf;

public final class c1
extends af
implements e1 {
    c1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    @Override
    public final void c() {
        this.c0(1, this.a());
    }

    @Override
    public final void c2(boolean bl) {
        Parcel parcel = this.a();
        int n3 = cf.b;
        parcel.writeInt(bl ? 1 : 0);
        this.c0(5, parcel);
    }

    @Override
    public final void e() {
        this.c0(2, this.a());
    }

    @Override
    public final void f() {
        this.c0(3, this.a());
    }

    @Override
    public final void g() {
        this.c0(4, this.a());
    }
}

