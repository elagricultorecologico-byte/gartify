/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 */
package h1;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;

public abstract class c {
    private final String a;
    private final Bundle b;
    private final Bundle c;
    private final Context d;
    private final boolean e;
    private final int f;
    private final int g;
    private final String h;
    private final String i;

    public c(Context context, String string, Bundle bundle, Bundle bundle2, boolean bl, Location location, int n2, int n3, String string2, String string3) {
        this.a = string;
        this.b = bundle;
        this.c = bundle2;
        this.d = context;
        this.e = bl;
        this.f = n2;
        this.g = n3;
        this.h = string2;
        this.i = string3;
    }
}

