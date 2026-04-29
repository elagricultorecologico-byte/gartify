/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$OnSharedPreferenceChangeListener
 *  java.lang.Object
 *  java.lang.String
 */
package e1;

import android.content.Context;
import android.content.SharedPreferences;
import e1.F0;

final class w0
implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final F0 a;
    private final Context b;
    private final String c;

    /* synthetic */ w0(F0 f02, Context context, String string) {
        this.a = f02;
        this.b = context;
        this.c = string;
    }

    public final /* synthetic */ void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String string) {
        this.a.W(this.b, this.c, sharedPreferences, string);
    }
}

