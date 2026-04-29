/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.Typeface
 *  android.os.Build$VERSION
 *  java.lang.Integer
 *  java.lang.Object
 */
package a2;

import A.a;
import a2.h;
import a2.i;
import a2.j;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;

public abstract class k {
    public static Typeface a(Context context, Typeface typeface) {
        return k.b(context.getResources().getConfiguration(), typeface);
    }

    public static Typeface b(Configuration configuration, Typeface typeface) {
        if (Build.VERSION.SDK_INT >= 31 && h.a(configuration) != Integer.MAX_VALUE && h.a(configuration) != 0 && typeface != null) {
            return j.a(typeface, a.b(i.a(typeface) + h.a(configuration), 1, 1000), typeface.isItalic());
        }
        return null;
    }
}

