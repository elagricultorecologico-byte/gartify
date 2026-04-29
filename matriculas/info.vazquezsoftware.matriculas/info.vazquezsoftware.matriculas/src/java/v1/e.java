/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  L1.i
 *  L1.j
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  androidx.appcompat.app.E
 *  com.google.android.gms.common.api.GoogleApiActivity
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Collections
 *  v1.a
 *  v1.a$d
 *  v1.d
 *  v1.e$a
 *  v1.f
 *  v1.f$a
 *  v1.f$b
 *  w1.E
 *  w1.O
 *  w1.b
 *  w1.e
 *  w1.j
 *  w1.m
 *  w1.n
 *  w1.r
 *  w1.z
 *  x1.d
 *  x1.d$a
 *  x1.n
 */
package v1;

import L1.i;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiActivity;
import java.util.Collection;
import java.util.Collections;
import v1.a;
import v1.d;
import v1.e;
import v1.f;
import w1.E;
import w1.O;
import w1.b;
import w1.j;
import w1.m;
import w1.n;
import w1.r;
import w1.z;
import x1.c;
import x1.d;

public abstract class e {
    private final Context a;
    private final String b;
    private final v1.a c;
    private final a.d d;
    private final b e;
    private final Looper f;
    private final int g;
    private final f h;
    private final m i;
    protected final w1.e j;

    private e(Context object, Activity activity, v1.a a2, a.d d2, a a3) {
        Context context;
        x1.n.j((Object)object, (Object)"Null context is not permitted.");
        x1.n.j((Object)a2, (Object)"Api must not be null.");
        x1.n.j((Object)a3, (Object)"Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.a = context = (Context)x1.n.j((Object)object.getApplicationContext(), (Object)"The provided context did not have an application context.");
        object = Build.VERSION.SDK_INT >= 30 ? v1.d.a((Context)object) : this.f((Context)object);
        this.b = object;
        this.c = a2;
        this.d = d2;
        this.f = a3.b;
        object = w1.b.a((v1.a)a2, (a.d)d2, (String)object);
        this.e = object;
        this.h = new E(this);
        a2 = w1.e.t((Context)context);
        this.j = a2;
        this.g = a2.k();
        this.i = a3.a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            r.u((Activity)activity, (w1.e)a2, (b)object);
        }
        a2.D(this);
    }

    public e(Context context, v1.a a2, a.d d2, a a3) {
        this(context, null, a2, d2, a3);
    }

    private final i l(int n2, n n3) {
        L1.j j2 = new L1.j();
        m m2 = this.i;
        this.j.z(this, n2, n3, j2, m2);
        return j2.a();
    }

    protected d.a c() {
        d.a a2 = new d.a();
        a2.d(null);
        a2.c((Collection)Collections.EMPTY_SET);
        a2.e(this.a.getClass().getName());
        a2.b(this.a.getPackageName());
        return a2;
    }

    public i d(n n2) {
        return this.l(2, n2);
    }

    public i e(n n2) {
        return this.l(0, n2);
    }

    protected String f(Context context) {
        return null;
    }

    public final b g() {
        return this.e;
    }

    protected String h() {
        return this.b;
    }

    public final int i() {
        return this.g;
    }

    public final a.f j(Looper object, z object2) {
        x1.d d2 = this.c().a();
        a.a a2 = (a.a)x1.n.i((Object)this.c.a());
        a.d d3 = this.d;
        object2 = a2.a(this.a, (Looper)object, d2, d3, (f.a)object2, (f.b)object2);
        object = this.h();
        if (object != null && object2 instanceof c) {
            ((c)object2).P((String)object);
        }
        if (object != null && object2 instanceof j) {
            androidx.appcompat.app.E.a((Object)object2);
            throw null;
        }
        return object2;
    }

    public final O k(Context context, Handler handler) {
        return new O(context, handler, this.c().a());
    }
}

