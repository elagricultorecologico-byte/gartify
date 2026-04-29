/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.JsonWriter
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Map
 */
package f1;

import android.util.JsonWriter;
import f1.l;
import f1.m;
import java.util.Map;

final class k
implements l {
    private final String a;
    private final String b;
    private final Map c;
    private final byte[] d;

    /* synthetic */ k(String string, String string2, Map map, byte[] byArray) {
        this.a = string;
        this.b = string2;
        this.c = map;
        this.d = byArray;
    }

    @Override
    public final /* synthetic */ void a(JsonWriter jsonWriter) {
        m.k(this.a, this.b, this.c, this.d, jsonWriter);
    }
}

