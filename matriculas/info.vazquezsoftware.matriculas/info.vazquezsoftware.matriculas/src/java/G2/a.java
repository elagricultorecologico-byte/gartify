/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  androidx.appcompat.view.d
 *  java.lang.Object
 */
package g2;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.view.d;

public abstract class a {
    private static final int[] a = new int[]{0x1010000, f.a.M};
    private static final int[] b = new int[]{M1.a.s};

    private static int a(Context context, AttributeSet attributeSet) {
        context = context.obtainStyledAttributes(attributeSet, a);
        int n2 = context.getResourceId(0, 0);
        int n3 = context.getResourceId(1, 0);
        context.recycle();
        if (n2 != 0) {
            return n2;
        }
        return n3;
    }

    private static int[] b(Context context, AttributeSet attributeSet, int[] nArray, int n2, int n3) {
        int[] nArray2 = new int[nArray.length];
        if (nArray.length > 0) {
            context = context.obtainStyledAttributes(attributeSet, nArray, n2, n3);
            for (n2 = 0; n2 < nArray.length; ++n2) {
                nArray2[n2] = context.getResourceId(n2, 0);
            }
            context.recycle();
        }
        return nArray2;
    }

    private static int c(Context context, AttributeSet attributeSet, int n2, int n3) {
        return g2.a.b(context, attributeSet, b, n2, n3)[0];
    }

    public static Context d(Context context, AttributeSet attributeSet, int n2, int n3) {
        return g2.a.e(context, attributeSet, n2, n3, new int[0]);
    }

    public static Context e(Context context, AttributeSet attributeSet, int n2, int n3, int[] nArray) {
        int n4 = g2.a.c(context, attributeSet, n2, n3);
        boolean bl = context instanceof d;
        int n5 = 0;
        int n6 = bl && ((d)context).c() == n4 ? 1 : 0;
        if (n4 != 0 && n6 == 0) {
            d d2 = new d(context, n4);
            nArray = g2.a.b(context, attributeSet, nArray, n2, n3);
            n3 = nArray.length;
            for (n2 = n5; n2 < n3; ++n2) {
                n6 = nArray[n2];
                if (n6 == 0) continue;
                d2.getTheme().applyStyle(n6, true);
            }
            n2 = g2.a.a(context, attributeSet);
            if (n2 != 0) {
                d2.getTheme().applyStyle(n2, true);
            }
            return d2;
        }
        return context;
    }
}

