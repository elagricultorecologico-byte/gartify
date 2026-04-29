/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.By0
 *  com.google.android.gms.internal.ads.KS
 *  com.google.android.gms.internal.ads.bf0
 *  com.google.android.gms.internal.ads.of0
 *  java.lang.Long
 *  java.lang.Object
 *  org.json.JSONObject
 */
package a1;

import a1.f;
import com.google.android.gms.internal.ads.By0;
import com.google.android.gms.internal.ads.KS;
import com.google.android.gms.internal.ads.bf0;
import com.google.android.gms.internal.ads.of0;
import l2.a;
import org.json.JSONObject;

final class d
implements By0 {
    private final Long a;
    private final KS b;
    private final bf0 c;
    private final of0 d;

    /* synthetic */ d(f f3, Long l3, KS kS, bf0 bf02, of0 of02) {
        this.a = l3;
        this.b = kS;
        this.c = bf02;
        this.d = of02;
    }

    public final /* synthetic */ a e(Object object) {
        return f.d(this.a, this.b, this.c, this.d, (JSONObject)object);
    }
}

