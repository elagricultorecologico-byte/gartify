/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 *  java.lang.Float
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.Arrays
 */
package d2;

import A.a;
import android.graphics.RectF;
import d2.d;
import java.util.Arrays;

public final class c
implements d {
    private final float a;

    public c(float f2) {
        this.a = f2;
    }

    private static float b(RectF rectF) {
        return Math.min((float)(rectF.width() / 2.0f), (float)(rectF.height() / 2.0f));
    }

    @Override
    public float a(RectF rectF) {
        return A.a.a(this.a, 0.0f, c.b(rectF));
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof c)) {
            return false;
        }
        object = (c)object;
        return this.a == ((c)object).a;
    }

    public int hashCode() {
        return Arrays.hashCode((Object[])new Object[]{Float.valueOf((float)this.a)});
    }
}

