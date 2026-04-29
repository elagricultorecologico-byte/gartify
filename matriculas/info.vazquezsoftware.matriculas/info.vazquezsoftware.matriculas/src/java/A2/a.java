/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  java.lang.Object
 *  java.lang.Override
 */
package a2;

import a2.g;
import android.graphics.Typeface;

public final class a
extends g {
    private final Typeface a;
    private final a b;
    private boolean c;

    public a(a a3, Typeface typeface) {
        this.a = typeface;
        this.b = a3;
    }

    private void d(Typeface typeface) {
        if (!this.c) {
            this.b.a(typeface);
        }
    }

    @Override
    public void a(int n3) {
        this.d(this.a);
    }

    @Override
    public void b(Typeface typeface, boolean bl) {
        this.d(typeface);
    }

    public void c() {
        this.c = true;
    }

    public static interface a {
        public void a(Typeface var1);
    }
}

