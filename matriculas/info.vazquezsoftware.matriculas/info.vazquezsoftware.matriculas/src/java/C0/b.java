/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  androidx.work.a
 *  androidx.work.b$a
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.background.systemalarm.RescheduleReceiver
 *  androidx.work.impl.workers.ConstraintTrackingWorker
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 *  t0.b
 *  t0.d
 *  t0.j
 *  t0.m
 *  t0.m$b
 *  t0.m$b$a
 *  t0.s
 *  t0.u
 *  u0.c
 *  u0.f
 *  u0.g
 *  u0.j
 */
package C0;

import B0.p;
import B0.s;
import C0.a;
import C0.g;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.b;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import t0.d;
import t0.m;
import t0.u;
import u0.c;
import u0.f;
import u0.j;

public class b
implements Runnable {
    private static final String i = t0.j.f((String)"EnqueueRunnable");
    private final u0.g g;
    private final c h;

    public b(u0.g g2) {
        this.g = g2;
        this.h = new c();
    }

    private static boolean b(u0.g g2) {
        Set set = u0.g.l((u0.g)g2);
        boolean bl = b.c(g2.g(), g2.f(), (String[])set.toArray((Object[])new String[0]), g2.d(), g2.b());
        g2.k();
        return bl;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private static boolean c(j object, List object2, String[] object3, String string, d object4) {
        Object object5;
        void var3_8;
        boolean bl;
        p p2;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        Object object6;
        WorkDatabase workDatabase;
        long l2;
        block33: {
            block35: {
                int n10;
                block36: {
                    block37: {
                        Iterator iterator;
                        block34: {
                            block31: {
                                List list;
                                block32: {
                                    l2 = System.currentTimeMillis();
                                    workDatabase = object.o();
                                    int n11 = 1;
                                    n10 = 1;
                                    n9 = object6 != null && ((void)object6).length > 0 ? 1 : 0;
                                    if (n9 == 0) {
                                        n8 = 1;
                                        n7 = 0;
                                        n6 = 0;
                                    } else {
                                        int n12 = ((void)object6).length;
                                        n5 = 1;
                                        n4 = 0;
                                        n2 = n3 = 0;
                                        while (true) {
                                            n8 = n5;
                                            n7 = n3;
                                            n6 = n2;
                                            if (n4 >= n12) break;
                                            void var21_24 = object6[n4];
                                            p2 = workDatabase.B().j((String)var21_24);
                                            if (p2 == null) {
                                                t0.j.c().b(i, String.format((String)"Prerequisite %s doesn't exist; not enqueuing", (Object[])new Object[]{var21_24}), new Throwable[0]);
                                                return false;
                                            }
                                            p2 = p2.b;
                                            n8 = p2 == t0.s.i ? 1 : 0;
                                            n5 &= n8;
                                            if (p2 == t0.s.j) {
                                                n6 = 1;
                                            } else {
                                                n6 = n2;
                                                if (p2 == t0.s.l) {
                                                    n3 = 1;
                                                    n6 = n2;
                                                }
                                            }
                                            ++n4;
                                            n2 = n6;
                                        }
                                    }
                                    if ((bl = TextUtils.isEmpty((CharSequence)var3_8)) || n9 != 0 || (list = workDatabase.B().f((String)var3_8)).isEmpty()) break block31;
                                    if (object5 == d.i || object5 == d.j) break block32;
                                    if (object5 == d.h) {
                                        object5 = list.iterator();
                                        while (object5.hasNext()) {
                                            p2 = ((p.b)object5.next()).b;
                                            if (p2 != t0.s.g && p2 != t0.s.h) continue;
                                            return false;
                                        }
                                    }
                                    a.c((String)var3_8, (j)object, false).run();
                                    object = workDatabase.B();
                                    object5 = list.iterator();
                                    while (object5.hasNext()) {
                                        object.a(((p.b)object5.next()).a);
                                    }
                                    n3 = 1;
                                    object = object6;
                                    n2 = n11;
                                    break block33;
                                }
                                object = workDatabase.t();
                                p2 = new ArrayList();
                                iterator = list.iterator();
                                n9 = n6;
                                n6 = n10;
                                break block34;
                            }
                            n3 = 1;
                            object = object6;
                            break block35;
                        }
                        while (iterator.hasNext()) {
                            p.b b2 = (p.b)iterator.next();
                            n5 = n8;
                            n3 = n7;
                            n2 = n9;
                            if (!object.c(b2.a)) {
                                t0.s s2 = b2.b;
                                n3 = s2 == t0.s.i ? n6 : 0;
                                if (s2 == t0.s.j) {
                                    n2 = n6;
                                } else {
                                    n2 = n9;
                                    if (s2 == t0.s.l) {
                                        n7 = n6;
                                        n2 = n9;
                                    }
                                }
                                p2.add(b2.a);
                                n5 = n3 & n8;
                                n3 = n7;
                            }
                            n8 = n5;
                            n7 = n3;
                            n9 = n2;
                        }
                        n2 = n6;
                        n10 = n7;
                        n6 = n9;
                        object = p2;
                        if (object5 != d.j) break block36;
                        if (n7 != 0) break block37;
                        n10 = n7;
                        n6 = n9;
                        object = p2;
                        if (n9 == 0) break block36;
                    }
                    object = workDatabase.B();
                    object5 = object.f((String)var3_8).iterator();
                    while (object5.hasNext()) {
                        object.a(((p.b)object5.next()).a);
                    }
                    object = Collections.EMPTY_LIST;
                    n10 = 0;
                    n6 = 0;
                }
                if (((Object)(object = (String[])object.toArray((Object[])object6))).length > 0) {
                    n9 = n2;
                    n7 = n10;
                    n3 = n2;
                } else {
                    n9 = 0;
                    n3 = n2;
                    n7 = n10;
                }
            }
            n2 = 0;
        }
        Iterator iterator = object2.iterator();
        void var1_3;
        while (var1_3.hasNext()) {
            p2 = (u)var1_3.next();
            object6 = p2.c();
            if (n9 != 0 && n8 == 0) {
                ((p)object6).b = n6 != 0 ? t0.s.j : (n7 != 0 ? t0.s.l : t0.s.k);
            } else {
                ((p)object6).n = !((p)object6).d() ? l2 : 0L;
            }
            if (Build.VERSION.SDK_INT <= 25) {
                b.g((p)object6);
            }
            if (((p)object6).b == t0.s.g) {
                n2 = n3;
            }
            workDatabase.B().l((p)object6);
            object5 = object;
            object6 = var1_3;
            if (n9 != 0) {
                n4 = ((Object)object).length;
                n5 = 0;
                while (true) {
                    object5 = object;
                    object6 = var1_3;
                    if (n5 >= n4) break;
                    object6 = object[n5];
                    object6 = new B0.a(p2.a(), (String)object6);
                    workDatabase.t().b((B0.a)object6);
                    ++n5;
                }
            }
            for (String string2 : p2.b()) {
                workDatabase.C().a(new s(string2, p2.a()));
            }
            if (!bl) {
                workDatabase.z().a(new B0.j((String)var3_8, p2.a()));
            }
            object = object5;
            p p3 = object6;
        }
        return n2 != 0;
    }

    private static boolean e(u0.g g2) {
        List list = g2.e();
        boolean bl = false;
        if (list != null) {
            list = list.iterator();
            bl = false;
            while (list.hasNext()) {
                u0.g g3 = (u0.g)list.next();
                if (!g3.j()) {
                    bl |= b.e(g3);
                    continue;
                }
                t0.j.c().h(i, String.format((String)"Already enqueued work ids (%s).", (Object[])new Object[]{TextUtils.join((CharSequence)", ", (Iterable)g3.c())}), new Throwable[0]);
            }
        }
        return b.b(g2) | bl;
    }

    private static void g(p p2) {
        t0.b b2 = p2.j;
        String string = p2.c;
        if (!string.equals((Object)ConstraintTrackingWorker.class.getName()) && (b2.f() || b2.i())) {
            b2 = new b.a();
            b2.c(p2.e).e("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", string);
            p2.c = ConstraintTrackingWorker.class.getName();
            p2.e = b2.a();
        }
    }

    public boolean a() {
        WorkDatabase workDatabase = this.g.g().o();
        workDatabase.c();
        try {
            boolean bl = b.e(this.g);
            workDatabase.r();
            return bl;
        }
        finally {
            workDatabase.g();
        }
    }

    public m d() {
        return this.h;
    }

    public void f() {
        j j2 = this.g.g();
        f.b((androidx.work.a)j2.i(), (WorkDatabase)j2.o(), (List)j2.n());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Throwable throwable2;
        block4: {
            block3: {
                try {
                    if (this.g.h()) {
                        IllegalStateException illegalStateException = new IllegalStateException(String.format((String)"WorkContinuation has cycles (%s)", (Object[])new Object[]{this.g}));
                        throw illegalStateException;
                    }
                    if (!this.a()) break block3;
                    C0.g.a(this.g.g().h(), RescheduleReceiver.class, true);
                    this.f();
                }
                catch (Throwable throwable2) {
                    break block4;
                }
            }
            this.h.a((m.b)m.a);
            return;
        }
        this.h.a((m.b)new m.b.a(throwable2));
    }
}

