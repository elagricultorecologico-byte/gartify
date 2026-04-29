/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.util.StateSet
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.System
 */
package h;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import h.b;

public abstract class e
extends b {
    private a s;
    private boolean t;

    e(a a2) {
        if (a2 != null) {
            this.h(a2);
        }
    }

    @Override
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        this.onStateChange(this.getState());
    }

    @Override
    void h(b.d d2) {
        super.h(d2);
        if (d2 instanceof a) {
            this.s = (a)d2;
        }
    }

    int[] j(AttributeSet attributeSet) {
        int n2 = attributeSet.getAttributeCount();
        int[] nArray = new int[n2];
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4 = attributeSet.getAttributeNameResource(i2);
            int n5 = n3;
            if (n4 != 0) {
                n5 = n3;
                if (n4 != 0x10100D0) {
                    n5 = n3;
                    if (n4 != 0x1010199) {
                        n5 = attributeSet.getAttributeBooleanValue(i2, false) ? n4 : -n4;
                        nArray[n3] = n5;
                        n5 = n3 + 1;
                    }
                }
            }
            n3 = n5;
        }
        return StateSet.trimStateSet((int[])nArray, (int)n3);
    }

    @Override
    public Drawable mutate() {
        if (!this.t && super.mutate() == this) {
            this.s.r();
            this.t = true;
        }
        return this;
    }

    protected abstract boolean onStateChange(int[] var1);

    static abstract class a
    extends b.d {
        int[][] J;

        a(a a2, e e2, Resources resources) {
            super(a2, e2, resources);
            if (a2 != null) {
                this.J = a2.J;
                return;
            }
            this.J = new int[this.f()][];
        }

        int A(int[] nArray) {
            int[][] nArray2 = this.J;
            int n2 = this.h();
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!StateSet.stateSetMatches((int[])nArray2[i2], (int[])nArray)) continue;
                return i2;
            }
            return -1;
        }

        @Override
        public void o(int n2, int n3) {
            super.o(n2, n3);
            int[][] nArrayArray = new int[n3][];
            System.arraycopy((Object)this.J, (int)0, (Object)nArrayArray, (int)0, (int)n2);
            this.J = nArrayArray;
        }

        @Override
        abstract void r();

        int z(int[] nArray, Drawable drawable) {
            int n2 = this.a(drawable);
            this.J[n2] = nArray;
            return n2;
        }
    }
}

