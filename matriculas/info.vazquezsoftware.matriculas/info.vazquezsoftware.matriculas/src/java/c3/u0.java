/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package c3;

import V2.k;
import c3.A0;
import c3.M;
import c3.X;
import c3.l0;
import c3.v0;
import h3.o;

public abstract class u0
extends o
implements X,
l0 {
    public v0 d;

    @Override
    public void a() {
        this.v().r0(this);
    }

    @Override
    public boolean f() {
        return true;
    }

    @Override
    public A0 g() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(M.a(this));
        stringBuilder.append('@');
        stringBuilder.append(M.b(this));
        stringBuilder.append("[job@");
        stringBuilder.append(M.b(this.v()));
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public final v0 v() {
        v0 v02 = this.d;
        if (v02 != null) {
            return v02;
        }
        k.o("job");
        return null;
    }

    public abstract boolean w();

    public abstract void x(Throwable var1);

    public final void y(v0 v02) {
        this.d = v02;
    }
}

