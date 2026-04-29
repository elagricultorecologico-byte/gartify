/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  java.lang.Object
 */
package G1;

import android.os.Build;

public abstract class g {
    public static final int a;

    static {
        int n2 = Build.VERSION.SDK_INT >= 31 ? 0x2000000 : 0;
        a = n2;
    }
}

