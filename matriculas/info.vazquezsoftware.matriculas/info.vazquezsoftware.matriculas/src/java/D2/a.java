/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 *  java.lang.Float
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

public final class a
implements d {
    private final float a;

    public a(float f2) {
        this.a = f2;
    }

    @Override
    public float a(RectF rectF) {
        return this.a;
    }

    public float b() {
        return this.a;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof a)) {
            return false;
        }
        object = (a)object;
        return this.a == ((a)object).a;
    }

    public int hashCode() {
        return Arrays.hashCode((Object[])new Object[]{Float.valueOf((float)this.a)});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b());
        stringBuilder.append("px");
        return stringBuilder.toString();
    }
}

