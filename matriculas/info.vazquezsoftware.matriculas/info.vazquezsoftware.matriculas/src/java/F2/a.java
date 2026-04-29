/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  androidx.appcompat.widget.D
 *  java.lang.Object
 */
package f2;

import M1.j;
import a2.b;
import a2.c;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.D;

public class a
extends D {
    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public a(Context context, AttributeSet attributeSet, int n2) {
        super(g2.a.d(context, attributeSet, n2, 0), attributeSet, n2);
        this.D(attributeSet, n2, 0);
    }

    private void A(Resources.Theme theme, int n2) {
        theme = theme.obtainStyledAttributes(n2, j.c3);
        n2 = a.E(this.getContext(), (TypedArray)theme, j.f3, j.h3);
        theme.recycle();
        if (n2 >= 0) {
            this.setLineHeight(n2);
        }
    }

    private static boolean B(Context context) {
        return b.b(context, M1.a.Q, true);
    }

    private static int C(Resources.Theme theme, AttributeSet attributeSet, int n2, int n3) {
        theme = theme.obtainStyledAttributes(attributeSet, j.i3, n2, n3);
        n2 = theme.getResourceId(j.j3, -1);
        theme.recycle();
        return n2;
    }

    private void D(AttributeSet attributeSet, int n2, int n3) {
        Resources.Theme theme;
        Context context = this.getContext();
        if (a.B(context) && !a.F(context, theme = context.getTheme(), attributeSet, n2, n3) && (n2 = a.C(theme, attributeSet, n2, n3)) != -1) {
            this.A(theme, n2);
        }
    }

    private static int E(Context context, TypedArray typedArray, int ... nArray) {
        int n2 = -1;
        for (int i2 = 0; i2 < nArray.length && n2 < 0; ++i2) {
            n2 = c.c(context, typedArray, nArray[i2], -1);
        }
        return n2;
    }

    private static boolean F(Context context, Resources.Theme theme, AttributeSet attributeSet, int n2, int n3) {
        theme = theme.obtainStyledAttributes(attributeSet, j.i3, n2, n3);
        n2 = a.E(context, (TypedArray)theme, j.k3, j.l3);
        theme.recycle();
        return n2 != -1;
    }

    public void setTextAppearance(Context context, int n2) {
        super.setTextAppearance(context, n2);
        if (a.B(context)) {
            this.A(context.getTheme(), n2);
        }
    }
}

