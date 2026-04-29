/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.material.sidesheet.SideSheetBehavior
 *  java.lang.Object
 *  java.lang.Override
 */
package e2;

import E.B;
import android.view.View;
import com.google.android.material.sidesheet.SideSheetBehavior;

public final class a
implements B {
    public final SideSheetBehavior a;
    public final int b;

    public /* synthetic */ a(SideSheetBehavior sideSheetBehavior, int n2) {
        this.a = sideSheetBehavior;
        this.b = n2;
    }

    @Override
    public final boolean a(View view, B.a a2) {
        return SideSheetBehavior.I((SideSheetBehavior)this.a, (int)this.b, (View)view, (B.a)a2);
    }
}

