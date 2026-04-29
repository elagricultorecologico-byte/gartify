/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package w;

import android.view.View;

public abstract class a {
    public static String a(View object) {
        try {
            object = object.getContext().getResources().getResourceEntryName(object.getId());
            return object;
        }
        catch (Exception exception) {
            return "UNKNOWN";
        }
    }
}

