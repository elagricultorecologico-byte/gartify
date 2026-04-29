/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  com.google.android.gms.internal.ads.MR0
 *  com.google.android.gms.internal.ads.VR0
 *  java.lang.Object
 *  java.lang.String
 */
package m1;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.internal.ads.MR0;
import com.google.android.gms.internal.ads.VR0;
import m1.a;

public final class b
implements MR0 {
    private final VR0 a;
    private final VR0 b;
    private final VR0 c;
    private final VR0 d;
    private final VR0 e;

    private b(VR0 vR0, VR0 vR02, VR0 vR03, VR0 vR04, VR0 vR05) {
        this.a = vR0;
        this.b = vR02;
        this.c = vR03;
        this.d = vR04;
        this.e = vR05;
    }

    public static b a(VR0 vR0, VR0 vR02, VR0 vR03, VR0 vR04, VR0 vR05) {
        return new b(vR0, vR02, vR03, vR04, vR05);
    }

    public static a d(Context context, f1.a a2, PackageInfo packageInfo, String string, k1.a a3) {
        return new a(context, a2, packageInfo, string, a3);
    }

    public a c() {
        return m1.b.d((Context)this.a.b(), (f1.a)this.b.b(), (PackageInfo)this.c.b(), (String)this.d.b(), (k1.a)this.e.b());
    }
}

