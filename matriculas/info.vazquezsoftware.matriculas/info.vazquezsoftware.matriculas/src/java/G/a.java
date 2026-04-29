/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  androidx.appcompat.widget.X
 *  androidx.core.content.a
 *  java.lang.Object
 */
package g;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.X;

public abstract class a {
    public static ColorStateList a(Context context, int n2) {
        return androidx.core.content.a.c((Context)context, (int)n2);
    }

    public static Drawable b(Context context, int n2) {
        return X.h().j(context, n2);
    }
}

