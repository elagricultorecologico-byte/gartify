/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 */
package d2;

import d2.e;
import d2.n;

public class f
extends e {
    float a = -1.0f;

    @Override
    public void a(n n2, float f2, float f3, float f4) {
        f3 = f4 * f3;
        n2.o(0.0f, f3, 180.0f, 180.0f - f2);
        double d2 = Math.sin((double)Math.toRadians((double)f2));
        double d3 = f3;
        n2.m((float)(d2 * d3), (float)(Math.sin((double)Math.toRadians((double)(90.0f - f2))) * d3));
    }
}

