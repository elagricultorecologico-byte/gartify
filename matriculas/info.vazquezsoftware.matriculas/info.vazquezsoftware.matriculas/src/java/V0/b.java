/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  androidx.work.a
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Set
 */
package v0;

import B0.p;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import t0.s;
import u0.e;
import u0.j;
import v0.a;
import x0.c;
import x0.d;

public class b
implements e,
c,
u0.b {
    private static final String o = t0.j.f("GreedyScheduler");
    private final Context g;
    private final j h;
    private final d i;
    private final Set j = new HashSet();
    private a k;
    private boolean l;
    private final Object m;
    Boolean n;

    public b(Context context, androidx.work.a a2, D0.a a3, j j2) {
        this.g = context;
        this.h = j2;
        this.i = new d(context, a3, this);
        this.k = new a(this, a2.k());
        this.m = new Object();
    }

    private void g() {
        androidx.work.a a2 = this.h.i();
        this.n = C0.j.b(this.g, a2);
    }

    private void h() {
        if (!this.l) {
            this.h.m().d(this);
            this.l = true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void i(String string) {
        Object object;
        Object object2 = object = this.m;
        synchronized (object2) {
            Throwable throwable2;
            block5: {
                try {
                    for (p p2 : this.j) {
                        if (!p2.a.equals((Object)string)) continue;
                        t0.j.c().a(o, String.format((String)"Stopping tracking for %s", (Object[])new Object[]{string}), new Throwable[0]);
                        this.j.remove((Object)p2);
                        this.i.d((Iterable)this.j);
                        break;
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                return;
            }
            throw throwable2;
        }
    }

    @Override
    public void a(String string, boolean bl) {
        this.i(string);
    }

    @Override
    public void b(String string) {
        if (this.n == null) {
            this.g();
        }
        if (!this.n.booleanValue()) {
            t0.j.c().d(o, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        this.h();
        t0.j.c().a(o, String.format((String)"Cancelling work ID %s", (Object[])new Object[]{string}), new Throwable[0]);
        a a2 = this.k;
        if (a2 != null) {
            a2.b(string);
        }
        this.h.x(string);
    }

    @Override
    public void c(List object2) {
        for (Object object2 : object2) {
            t0.j.c().a(o, String.format((String)"Constraints not met: Cancelling work ID %s", (Object[])new Object[]{object2}), new Throwable[0]);
            this.h.x((String)object2);
        }
    }

    @Override
    public void d(List list) {
        for (String string : list) {
            t0.j.c().a(o, String.format((String)"Constraints met: Scheduling work ID %s", (Object[])new Object[]{string}), new Throwable[0]);
            this.h.u(string);
        }
    }

    @Override
    public boolean e() {
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void f(p ... object) {
        if (this.n == null) {
            this.g();
        }
        if (!this.n.booleanValue()) {
            t0.j.c().d(o, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        this.h();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        int n2 = ((p[])object).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            p p2 = object[i2];
            long l2 = p2.a();
            long l3 = System.currentTimeMillis();
            if (p2.b != s.g) continue;
            if (l3 < l2) {
                a a2 = this.k;
                if (a2 == null) continue;
                a2.a(p2);
                continue;
            }
            if (p2.b()) {
                int n3 = Build.VERSION.SDK_INT;
                if (p2.j.h()) {
                    t0.j.c().a(o, String.format((String)"Ignoring WorkSpec %s, Requires device idle.", (Object[])new Object[]{p2}), new Throwable[0]);
                    continue;
                }
                if (n3 >= 24 && p2.j.e()) {
                    t0.j.c().a(o, String.format((String)"Ignoring WorkSpec %s, Requires ContentUri triggers.", (Object[])new Object[]{p2}), new Throwable[0]);
                    continue;
                }
                hashSet.add((Object)p2);
                hashSet2.add((Object)p2.a);
                continue;
            }
            t0.j.c().a(o, String.format((String)"Starting work for %s", (Object[])new Object[]{p2.a}), new Throwable[0]);
            this.h.u(p2.a);
        }
        Object object2 = object = this.m;
        synchronized (object) {
            Throwable throwable2;
            block11: {
                block10: {
                    try {
                        if (hashSet.isEmpty()) break block10;
                        t0.j.c().a(o, String.format((String)"Starting tracking for [%s]", (Object[])new Object[]{TextUtils.join((CharSequence)",", (Iterable)hashSet2)}), new Throwable[0]);
                        this.j.addAll((Collection)hashSet);
                        this.i.d((Iterable)this.j);
                    }
                    catch (Throwable throwable2) {
                        break block11;
                    }
                }
                // ** MonitorExit[var13_12 /* !! */ ] (shouldn't be in output)
                return;
            }
            // ** MonitorExit[var13_12 /* !! */ ] (shouldn't be in output)
            throw throwable2;
        }
    }
}

