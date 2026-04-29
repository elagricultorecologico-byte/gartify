/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  java.lang.Object
 */
package e1;

import android.view.View;

public abstract class c {
    public static boolean a(View view) {
        for (view = view.getParent(); view != null; view = view.getParent()) {
            if (!view.getClass().getName().startsWith("androidx.compose.ui")) continue;
            return true;
        }
        return false;
    }
}

