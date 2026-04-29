/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.Objects
 */
package b1;

import T0.m;
import b1.l1;
import b1.y;
import java.util.Objects;

final class j1
extends y {
    final l1 i;

    j1(l1 l12) {
        Objects.requireNonNull((Object)l12);
        this.i = l12;
    }

    @Override
    public final void e(m m3) {
        l1 l12 = this.i;
        l12.d().b(l12.C());
        super.e(m3);
    }

    @Override
    public final void i() {
        l1 l12 = this.i;
        l12.d().b(l12.C());
        super.i();
    }
}

