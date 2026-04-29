/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Map
 */
package h1;

import T0.w;
import W0.d;
import android.os.Bundle;
import android.view.View;
import java.util.List;
import java.util.Map;

public abstract class r {
    private String a;
    private List b;
    private String c;
    private d d;
    private String e;
    private String f;
    private Double g;
    private String h;
    private String i;
    private w j;
    private boolean k;
    private View l;
    private View m;
    private Object n;
    private Bundle o = new Bundle();
    private boolean p;
    private boolean q;
    private float r;

    public final void A(boolean bl) {
        this.q = bl;
    }

    public final void B(boolean bl) {
        this.p = bl;
    }

    public final void C(String string) {
        this.i = string;
    }

    public final void D(Double d2) {
        this.g = d2;
    }

    public final void E(String string) {
        this.h = string;
    }

    public abstract void F(View var1, Map var2, Map var3);

    public void G(View view) {
    }

    public final void H(w w2) {
        this.j = w2;
    }

    public final void I(Object object) {
        this.n = object;
    }

    public final w J() {
        return this.j;
    }

    public final View K() {
        return this.m;
    }

    public final Object L() {
        return this.n;
    }

    public void a() {
    }

    public View b() {
        return this.l;
    }

    public final String c() {
        return this.f;
    }

    public final String d() {
        return this.c;
    }

    public final String e() {
        return this.e;
    }

    public float f() {
        return 0.0f;
    }

    public float g() {
        return 0.0f;
    }

    public final Bundle h() {
        return this.o;
    }

    public final String i() {
        return this.a;
    }

    public final d j() {
        return this.d;
    }

    public final List k() {
        return this.b;
    }

    public float l() {
        return this.r;
    }

    public final boolean m() {
        return this.q;
    }

    public final boolean n() {
        return this.p;
    }

    public final String o() {
        return this.i;
    }

    public final Double p() {
        return this.g;
    }

    public final String q() {
        return this.h;
    }

    public void r(View view) {
    }

    public boolean s() {
        return this.k;
    }

    public void t() {
    }

    public final void u(String string) {
        this.f = string;
    }

    public final void v(String string) {
        this.c = string;
    }

    public final void w(String string) {
        this.e = string;
    }

    public final void x(String string) {
        this.a = string;
    }

    public final void y(d d2) {
        this.d = d2;
    }

    public final void z(List list) {
        this.b = list;
    }
}

