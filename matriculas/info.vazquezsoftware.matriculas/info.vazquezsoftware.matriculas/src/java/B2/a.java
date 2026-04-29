/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Color
 *  android.os.Build$VERSION
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 */
package b2;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

public abstract class a {
    private static final int[] a = new int[]{16842919};
    private static final int[] b = new int[]{16842908};
    private static final int[] c = new int[]{0x10100A1, 16842919};
    private static final int[] d = new int[]{0x10100A1};
    private static final int[] e = new int[]{16842910, 16842919};
    static final String f = a.class.getSimpleName();

    public static ColorStateList a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (Build.VERSION.SDK_INT <= 27 && Color.alpha((int)colorStateList.getDefaultColor()) == 0 && Color.alpha((int)colorStateList.getColorForState(e, 0)) != 0) {
                Log.w((String)f, (String)"Use a non-transparent color for the default color as it will be used to finish ripple animations.");
            }
            return colorStateList;
        }
        return ColorStateList.valueOf((int)0);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean b(int[] nArray) {
        boolean bl;
        int n3 = nArray.length;
        boolean bl2 = bl = false;
        for (int i3 = 0; i3 < n3; ++i3) {
            boolean bl3;
            block4: {
                block5: {
                    int n4;
                    block3: {
                        n4 = nArray[i3];
                        if (n4 != 16842910) break block3;
                        bl3 = true;
                        break block4;
                    }
                    if (n4 == 16842908 || n4 == 16842919) break block5;
                    bl3 = bl;
                    if (n4 != 16843623) break block4;
                }
                bl2 = true;
                bl3 = bl;
            }
            bl = bl3;
        }
        return bl && bl2;
    }
}

