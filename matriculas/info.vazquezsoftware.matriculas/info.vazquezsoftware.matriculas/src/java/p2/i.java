/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package p2;

import m2.b;
import m2.c;
import m2.g;
import p2.f;

class i
implements g {
    private boolean a = false;
    private boolean b = false;
    private c c;
    private final f d;

    i(f f2) {
        this.d = f2;
    }

    private void a() {
        if (!this.a) {
            this.a = true;
            return;
        }
        throw new b("Cannot encode a second value in the ValueEncoderContext");
    }

    @Override
    public g b(String string) {
        this.a();
        this.d.f(this.c, string, this.b);
        return this;
    }

    @Override
    public g c(boolean bl) {
        this.a();
        this.d.k(this.c, bl, this.b);
        return this;
    }

    void d(c c3, boolean bl) {
        this.a = false;
        this.c = c3;
        this.b = bl;
    }
}

