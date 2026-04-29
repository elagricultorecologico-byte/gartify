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

import android.graphics.RectF;
import d2.d;
import java.util.Arrays;

public final class b
implements d {
    private final d a;
    private final float b;

    public b(float f2, d d2) {
        while (d2 instanceof b) {
            d2 = ((b)d2).a;
            f2 += ((b)d2).b;
        }
        this.a = d2;
        this.b = f2;
    }

    @Override
    public float a(RectF rectF) {
        return Math.max((float)0.0f, (float)(this.a.a(rectF) + this.b));
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof b)) {
            return false;
        }
        object = (b)object;
        return this.a.equals(((b)object).a) && this.b == ((b)object).b;
    }

    public int hashCode() {
        return Arrays.hashCode((Object[])new Object[]{this.a, Float.valueOf((float)this.b)});
    }
}

