/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 */
package d2;

import d2.e;
import d2.n;

public class k
extends e {
    float a = -1.0f;

    @Override
    public void a(n n2, float f2, float f3, float f4) {
        f3 = f4 * f3;
        n2.o(0.0f, f3, 180.0f, 180.0f - f2);
        n2.a(0.0f, 0.0f, f3 *= 2.0f, f3, 180.0f, f2);
    }
}

