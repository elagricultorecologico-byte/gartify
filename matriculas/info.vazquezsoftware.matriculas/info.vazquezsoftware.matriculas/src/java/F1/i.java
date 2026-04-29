/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.JsonWriter
 *  com.google.android.gms.common.util.c
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package f1;

import android.util.JsonWriter;
import com.google.android.gms.common.util.c;
import f1.g;
import f1.l;
import f1.m;

final class i
implements l {
    private final byte[] a;

    /* synthetic */ i(byte[] byArray) {
        this.a = byArray;
    }

    @Override
    public final /* synthetic */ void a(JsonWriter jsonWriter) {
        int n2 = m.g;
        jsonWriter.name("params").beginObject();
        Object object = this.a;
        n2 = ((byte[])object).length;
        object = c.a((byte[])object);
        if (n2 < 10000) {
            jsonWriter.name("body").value((String)object);
        } else if ((object = (Object)g.r((String)object)) != null) {
            jsonWriter.name("bodydigest").value((String)object);
        }
        jsonWriter.name("bodylength").value((long)n2);
        jsonWriter.endObject();
    }
}

