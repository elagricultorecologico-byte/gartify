/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.material.sidesheet.SideSheetBehavior
 *  java.lang.Object
 *  java.lang.Runnable
 */
package e2;

import com.google.android.material.sidesheet.SideSheetBehavior;

public final class b
implements Runnable {
    public final SideSheetBehavior g;
    public final int h;

    public /* synthetic */ b(SideSheetBehavior sideSheetBehavior, int n2) {
        this.g = sideSheetBehavior;
        this.h = n2;
    }

    public final void run() {
        SideSheetBehavior.J((SideSheetBehavior)this.g, (int)this.h);
    }
}

