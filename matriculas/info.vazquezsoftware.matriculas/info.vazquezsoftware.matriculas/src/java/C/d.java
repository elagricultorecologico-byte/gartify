/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  java.lang.Object
 */
package C;

import C.e;
import android.content.Context;
import android.net.Uri;
import android.os.Build;

public abstract class d {
    public static e.a a(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT < 24) {
            return new e.b(context, uri);
        }
        return new e.c(context, uri);
    }
}

