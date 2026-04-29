/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  f1.g
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package b1;

import T0.t;
import android.content.Context;
import android.os.Bundle;
import b1.h1;
import b1.t1;
import b1.x;
import f1.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class i1 {
    private final String a;
    private final List b;
    private final Set c;
    private final Bundle d;
    private final String e;
    private final String f;
    private final int g;
    private final Set h;
    private final Bundle i;
    private final Set j;
    private final boolean k;
    private final String l;
    private final int m;
    private long n = 0L;
    private long o = 0L;

    public i1(h1 h12) {
        this.a = h12.y();
        this.b = h12.z();
        this.c = Collections.unmodifiableSet((Set)h12.s());
        this.d = h12.t();
        Collections.unmodifiableMap((Map)h12.u());
        this.e = h12.A();
        this.f = h12.a();
        this.g = h12.b();
        this.h = Collections.unmodifiableSet((Set)h12.v());
        this.i = h12.w();
        this.j = Collections.unmodifiableSet((Set)h12.x());
        this.k = h12.c();
        this.l = h12.d();
        this.m = h12.e();
        this.o = h12.f();
    }

    public final String a() {
        return this.a;
    }

    public final List b() {
        return new ArrayList((Collection)this.b);
    }

    public final Set c() {
        return this.c;
    }

    public final Bundle d(Class clazz) {
        return this.d.getBundle(clazz.getName());
    }

    public final String e() {
        return this.e;
    }

    public final String f() {
        return this.f;
    }

    public final boolean g(Context object) {
        t t2 = t1.e().i();
        x.a();
        Set set = this.h;
        object = f1.g.f((Context)object);
        return set.contains(object) || t2.e().contains(object);
        {
        }
    }

    public final Bundle h() {
        return this.d;
    }

    public final int i() {
        return this.g;
    }

    public final Bundle j() {
        return this.i;
    }

    public final Set k() {
        return this.j;
    }

    public final boolean l() {
        return this.k;
    }

    public final String m() {
        return this.l;
    }

    public final int n() {
        return this.m;
    }

    public final void o(long l3) {
        this.n = l3;
    }

    public final long p() {
        return this.n;
    }

    public final long q() {
        return this.o;
    }
}

