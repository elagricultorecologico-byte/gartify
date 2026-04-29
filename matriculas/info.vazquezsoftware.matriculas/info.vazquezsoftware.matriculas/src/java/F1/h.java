/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.JsonWriter
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.Map
 */
package f1;

import android.util.JsonWriter;
import f1.l;
import f1.m;
import java.util.Map;

final class h
implements l {
    private final int a;
    private final Map b;

    /* synthetic */ h(int n2, Map map) {
        this.a = n2;
        this.b = map;
    }

    @Override
    public final /* synthetic */ void a(JsonWriter jsonWriter) {
        m.l(this.a, this.b, jsonWriter);
    }
}

