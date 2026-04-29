/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.JsonWriter
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package f1;

import android.util.JsonWriter;
import f1.l;
import f1.m;

final class j
implements l {
    private final String a;

    /* synthetic */ j(String string) {
        this.a = string;
    }

    @Override
    public final /* synthetic */ void a(JsonWriter jsonWriter) {
        int n2 = m.g;
        jsonWriter.name("params").beginObject();
        String string = this.a;
        if (string != null) {
            jsonWriter.name("error_description").value(string);
        }
        jsonWriter.endObject();
    }
}

