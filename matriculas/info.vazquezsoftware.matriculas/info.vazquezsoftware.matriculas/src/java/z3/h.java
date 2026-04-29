/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.concurrent.TimeUnit
 */
package z3;

import V2.k;
import java.util.concurrent.TimeUnit;
import z3.y;

public class h
extends y {
    private y f;

    public h(y y2) {
        k.e(y2, "delegate");
        this.f = y2;
    }

    @Override
    public y a() {
        return this.f.a();
    }

    @Override
    public y b() {
        return this.f.b();
    }

    @Override
    public long c() {
        return this.f.c();
    }

    @Override
    public y d(long l2) {
        return this.f.d(l2);
    }

    @Override
    public boolean e() {
        return this.f.e();
    }

    @Override
    public void f() {
        this.f.f();
    }

    @Override
    public y g(long l2, TimeUnit timeUnit) {
        k.e(timeUnit, "unit");
        return this.f.g(l2, timeUnit);
    }

    public final y i() {
        return this.f;
    }

    public final h j(y y2) {
        k.e(y2, "delegate");
        this.f = y2;
        return this;
    }
}

