/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 *  java.lang.Float
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 */
package d2;

import android.graphics.RectF;
import d2.d;
import java.util.Arrays;

public final class j
implements d {
    private final float a;

    public j(float f2) {
        this.a = f2;
    }

    private static float b(RectF rectF) {
        return Math.min((float)rectF.width(), (float)rectF.height());
    }

    @Override
    public float a(RectF rectF) {
        return this.a * j.b(rectF);
    }

    public float c() {
        return this.a;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof j)) {
            return false;
        }
        object = (j)object;
        return this.a == ((j)object).a;
    }

    public int hashCode() {
        return Arrays.hashCode((Object[])new Object[]{Float.valueOf((float)this.a)});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((int)(this.c() * 100.0f));
        stringBuilder.append("%");
        return stringBuilder.toString();
    }
}

