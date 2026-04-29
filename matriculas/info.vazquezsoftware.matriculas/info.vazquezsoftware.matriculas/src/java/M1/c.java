/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  com.google.android.gms.internal.ads.Tj
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.Map$Entry
 */
package m1;

import android.net.Uri;
import com.google.android.gms.internal.ads.Tj;
import java.util.Map;

public class c {
    private final String a = (String)Tj.a.e();

    public String a(Map map) {
        Uri.Builder builder = Uri.parse((String)this.a).buildUpon();
        for (Map.Entry entry : map.entrySet()) {
            builder.appendQueryParameter((String)entry.getKey(), (String)entry.getValue());
        }
        return builder.build().toString();
    }
}

