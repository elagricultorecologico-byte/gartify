/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.du0
 *  java.lang.Object
 *  java.util.List
 *  org.json.JSONObject
 */
package l1;

import com.google.android.gms.internal.ads.du0;
import java.util.List;
import l1.r;
import org.json.JSONObject;

final class n
implements du0 {
    static final n a = new n();

    private /* synthetic */ n() {
    }

    public final /* synthetic */ Object apply(Object object) {
        object = (JSONObject)object;
        List list = r.M;
        return object.optString("nas");
    }
}

