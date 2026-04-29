/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.ListenableWorker
 *  androidx.work.ListenableWorker$a
 *  androidx.work.ListenableWorker$a$a
 *  androidx.work.ListenableWorker$a$b
 *  androidx.work.ListenableWorker$a$c
 *  androidx.work.WorkerParameters
 *  androidx.work.WorkerParameters$a
 *  androidx.work.a
 *  androidx.work.b
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.background.systemalarm.RescheduleReceiver
 *  androidx.work.impl.utils.futures.c
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.UUID
 *  java.util.concurrent.CancellationException
 *  java.util.concurrent.ExecutionException
 *  java.util.concurrent.Executor
 */
package u0;

import B0.t;
import C0.g;
import C0.o;
import C0.p;
import C0.q;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.a;
import androidx.work.b;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import t0.h;
import t0.j;
import t0.s;
import u0.e;
import u0.f;

public class k
implements Runnable {
    static final String z = t0.j.f("WorkerWrapper");
    Context g;
    private String h;
    private List i;
    private WorkerParameters.a j;
    B0.p k;
    ListenableWorker l;
    D0.a m;
    ListenableWorker.a n = ListenableWorker.a.a();
    private a o;
    private A0.a p;
    private WorkDatabase q;
    private B0.q r;
    private B0.b s;
    private t t;
    private List u;
    private String v;
    androidx.work.impl.utils.futures.c w = androidx.work.impl.utils.futures.c.u();
    l2.a x = null;
    private volatile boolean y;

    k(c c3) {
        this.g = c3.a;
        this.m = c3.d;
        this.p = c3.c;
        this.h = c3.g;
        this.i = c3.h;
        this.j = c3.i;
        this.l = c3.b;
        this.o = c3.e;
        c3 = c3.f;
        this.q = c3;
        this.r = c3.B();
        this.s = this.q.t();
        this.t = this.q.C();
    }

    private String a(List object) {
        StringBuilder stringBuilder = new StringBuilder("Work [ id=");
        stringBuilder.append(this.h);
        stringBuilder.append(", tags={ ");
        Iterator iterator = object.iterator();
        boolean bl = true;
        while (iterator.hasNext()) {
            object = (String)iterator.next();
            if (bl) {
                bl = false;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append((String)object);
        }
        stringBuilder.append(" } ]");
        return stringBuilder.toString();
    }

    private void c(ListenableWorker.a a2) {
        if (a2 instanceof ListenableWorker.a.c) {
            t0.j.c().d(z, String.format((String)"Worker result SUCCESS for %s", (Object[])new Object[]{this.v}), new Throwable[0]);
            if (this.k.d()) {
                this.h();
                return;
            }
            this.m();
            return;
        }
        if (a2 instanceof ListenableWorker.a.b) {
            t0.j.c().d(z, String.format((String)"Worker result RETRY for %s", (Object[])new Object[]{this.v}), new Throwable[0]);
            this.g();
            return;
        }
        t0.j.c().d(z, String.format((String)"Worker result FAILURE for %s", (Object[])new Object[]{this.v}), new Throwable[0]);
        if (this.k.d()) {
            this.h();
            return;
        }
        this.l();
    }

    private void e(String string) {
        LinkedList linkedList = new LinkedList();
        linkedList.add((Object)string);
        while (!linkedList.isEmpty()) {
            string = (String)linkedList.remove();
            if (this.r.h(string) != t0.s.l) {
                this.r.m(t0.s.j, string);
            }
            linkedList.addAll((Collection)this.s.d(string));
        }
    }

    private void g() {
        this.q.c();
        try {
            this.r.m(t0.s.g, this.h);
            this.r.q(this.h, System.currentTimeMillis());
            this.r.d(this.h, -1L);
            this.q.r();
            return;
        }
        finally {
            this.q.g();
            this.i(true);
        }
    }

    private void h() {
        this.q.c();
        try {
            this.r.q(this.h, System.currentTimeMillis());
            this.r.m(t0.s.g, this.h);
            this.r.k(this.h);
            this.r.d(this.h, -1L);
            this.q.r();
            return;
        }
        finally {
            this.q.g();
            this.i(false);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void i(boolean bl) {
        Throwable throwable2;
        block5: {
            ListenableWorker listenableWorker;
            block4: {
                this.q.c();
                try {
                    if (this.q.B().c()) break block4;
                    C0.g.a(this.g, RescheduleReceiver.class, false);
                }
                catch (Throwable throwable2) {
                    break block5;
                }
            }
            if (bl) {
                this.r.m(t0.s.g, this.h);
                this.r.d(this.h, -1L);
            }
            if (this.k != null && (listenableWorker = this.l) != null && listenableWorker.isRunInForeground()) {
                this.p.b(this.h);
            }
            this.q.r();
            this.q.g();
            this.w.q((Object)bl);
            return;
        }
        this.q.g();
        throw throwable2;
    }

    private void j() {
        s s2 = this.r.h(this.h);
        if (s2 == t0.s.h) {
            t0.j.c().a(z, String.format((String)"Status for %s is RUNNING;not doing any work and rescheduling for later execution", (Object[])new Object[]{this.h}), new Throwable[0]);
            this.i(true);
            return;
        }
        t0.j.c().a(z, String.format((String)"Status for %s is %s; not doing any work", (Object[])new Object[]{this.h, s2}), new Throwable[0]);
        this.i(false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void k() {
        Throwable throwable2;
        block17: {
            Object object;
            Object object2;
            block16: {
                block15: {
                    block14: {
                        if (this.n()) {
                            return;
                        }
                        this.q.c();
                        try {
                            object2 = this.r.j(this.h);
                            this.k = object2;
                            if (object2 != null) break block14;
                            t0.j.c().b(z, String.format((String)"Didn't find WorkSpec for id %s", (Object[])new Object[]{this.h}), new Throwable[0]);
                            this.i(false);
                            this.q.r();
                        }
                        catch (Throwable throwable2) {}
                        this.q.g();
                        return;
                    }
                    if (((B0.p)object2).b == t0.s.g) break block15;
                    this.j();
                    this.q.r();
                    t0.j.c().a(z, String.format((String)"%s is not in ENQUEUED state. Nothing more to do.", (Object[])new Object[]{this.k.c}), new Throwable[0]);
                    this.q.g();
                    return;
                }
                if (!((B0.p)object2).d() && !this.k.c()) break block16;
                long l2 = System.currentTimeMillis();
                object2 = this.k;
                if (((B0.p)object2).n == 0L || l2 >= ((B0.p)object2).a()) break block16;
                t0.j.c().a(z, String.format((String)"Delaying execution for %s because it is being executed before schedule.", (Object[])new Object[]{this.k.c}), new Throwable[0]);
                this.i(true);
                this.q.r();
                this.q.g();
                return;
            }
            this.q.r();
            break block17;
            this.q.g();
            if (this.k.d()) {
                object2 = this.k.e;
            } else {
                object2 = this.o.f().b(this.k.d);
                if (object2 == null) {
                    t0.j.c().b(z, String.format((String)"Could not create Input Merger %s", (Object[])new Object[]{this.k.d}), new Throwable[0]);
                    this.l();
                    return;
                }
                object = new ArrayList();
                object.add((Object)this.k.e);
                object.addAll((Collection)this.r.o(this.h));
                object2 = ((h)object2).b((List)object);
            }
            object = new WorkerParameters(UUID.fromString((String)this.h), (b)object2, (Collection)this.u, this.j, this.k.k, this.o.e(), this.m, this.o.m(), (t0.o)new q(this.q, this.m), (t0.f)new p(this.q, this.p, this.m));
            if (this.l == null) {
                this.l = this.o.m().b(this.g, this.k.c, (WorkerParameters)object);
            }
            if ((object2 = this.l) == null) {
                t0.j.c().b(z, String.format((String)"Could not create Worker %s", (Object[])new Object[]{this.k.c}), new Throwable[0]);
                this.l();
                return;
            }
            if (object2.isUsed()) {
                t0.j.c().b(z, String.format((String)"Received an already-used Worker %s; WorkerFactory should return new instances", (Object[])new Object[]{this.k.c}), new Throwable[0]);
                this.l();
                return;
            }
            this.l.setUsed();
            if (!this.o()) {
                this.j();
                return;
            }
            if (this.n()) {
                return;
            }
            object2 = androidx.work.impl.utils.futures.c.u();
            object = new o(this.g, this.k, this.l, object.b(), this.m);
            this.m.a().execute((Runnable)object);
            object = ((o)object).a();
            object.f(new Runnable(this, (l2.a)object, (androidx.work.impl.utils.futures.c)object2){
                final l2.a g;
                final androidx.work.impl.utils.futures.c h;
                final k i;
                {
                    this.i = k2;
                    this.g = a2;
                    this.h = c3;
                }

                public void run() {
                    try {
                        this.g.get();
                        t0.j.c().a(z, String.format((String)"Starting work for %s", (Object[])new Object[]{this.i.k.c}), new Throwable[0]);
                        k k2 = this.i;
                        k2.x = k2.l.startWork();
                        this.h.s(this.i.x);
                        return;
                    }
                    catch (Throwable throwable) {
                        this.h.r(throwable);
                        return;
                    }
                }
            }, this.m.a());
            object2.f(new Runnable(this, (androidx.work.impl.utils.futures.c)object2, this.v){
                final androidx.work.impl.utils.futures.c g;
                final String h;
                final k i;
                {
                    this.i = k2;
                    this.g = c3;
                    this.h = string;
                }

                /*
                 * Loose catch block
                 * WARNING - void declaration
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public void run() {
                    block10: {
                        void var1_6;
                        block9: {
                            Throwable throwable222;
                            block8: {
                                try {
                                    ListenableWorker.a a2 = (ListenableWorker.a)this.g.get();
                                    if (a2 == null) {
                                        t0.j.c().b(z, String.format((String)"%s returned a null result. Treating it as a failure.", (Object[])new Object[]{this.i.k.c}), new Throwable[0]);
                                        break block8;
                                    }
                                    t0.j.c().a(z, String.format((String)"%s returned a %s result.", (Object[])new Object[]{this.i.k.c, a2}), new Throwable[0]);
                                    this.i.n = a2;
                                }
                                catch (Throwable throwable222) {}
                            }
                            this.i.f();
                            return;
                            this.i.f();
                            throw throwable222;
                            catch (ExecutionException executionException) {
                                break block9;
                            }
                            catch (InterruptedException interruptedException) {}
                        }
                        t0.j.c().b(z, String.format((String)"%s failed because it threw an exception/error", (Object[])new Object[]{this.h}), new Throwable[]{var1_6});
                        break block10;
                        catch (CancellationException cancellationException) {}
                        t0.j.c().d(z, String.format((String)"%s was cancelled", (Object[])new Object[]{this.h}), cancellationException);
                    }
                    this.i.f();
                }
            }, (Executor)this.m.c());
            return;
        }
        this.q.g();
        throw throwable2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void m() {
        Throwable throwable2;
        block3: {
            this.q.c();
            try {
                this.r.m(t0.s.i, this.h);
                b b2 = ((ListenableWorker.a.c)this.n).e();
                this.r.t(this.h, b2);
                long l2 = System.currentTimeMillis();
                for (String string : this.s.d(this.h)) {
                    if (this.r.h(string) != t0.s.k || !this.s.a(string)) continue;
                    t0.j.c().d(z, String.format((String)"Setting status to enqueued for %s", (Object[])new Object[]{string}), new Throwable[0]);
                    this.r.m(t0.s.g, string);
                    this.r.q(string, l2);
                }
            }
            catch (Throwable throwable2) {
                break block3;
            }
            this.q.r();
            this.q.g();
            this.i(false);
            return;
        }
        this.q.g();
        this.i(false);
        throw throwable2;
    }

    private boolean n() {
        if (this.y) {
            t0.j.c().a(z, String.format((String)"Work interrupted for %s", (Object[])new Object[]{this.v}), new Throwable[0]);
            s s2 = this.r.h(this.h);
            if (s2 == null) {
                this.i(false);
            } else {
                this.i(s2.d() ^ true);
            }
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean o() {
        Throwable throwable2;
        block4: {
            boolean bl;
            block3: {
                block2: {
                    this.q.c();
                    try {
                        if (this.r.h(this.h) != t0.s.g) break block2;
                        this.r.m(t0.s.h, this.h);
                        this.r.p(this.h);
                        bl = true;
                        break block3;
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                bl = false;
            }
            this.q.r();
            this.q.g();
            return bl;
        }
        this.q.g();
        throw throwable2;
    }

    public l2.a b() {
        return this.w;
    }

    public void d() {
        boolean bl;
        this.y = true;
        this.n();
        Object object = this.x;
        if (object != null) {
            bl = object.isDone();
            this.x.cancel(true);
        } else {
            bl = false;
        }
        object = this.l;
        if (object != null && !bl) {
            object.stop();
            return;
        }
        object = String.format((String)"WorkSpec %s is already done. Not interrupting.", (Object[])new Object[]{this.k});
        t0.j.c().a(z, (String)object, new Throwable[0]);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void f() {
        Object object;
        block11: {
            if (!this.n()) {
                Throwable throwable2;
                block10: {
                    block9: {
                        block8: {
                            this.q.c();
                            try {
                                object = this.r.h(this.h);
                                this.q.A().a(this.h);
                                if (object != null) break block8;
                                this.i(false);
                                break block9;
                            }
                            catch (Throwable throwable2) {
                                break block10;
                            }
                        }
                        if (object == t0.s.h) {
                            this.c(this.n);
                        } else if (!((s)((Object)object)).d()) {
                            this.g();
                        }
                    }
                    this.q.r();
                    this.q.g();
                    break block11;
                }
                this.q.g();
                throw throwable2;
            }
        }
        if ((object = this.i) != null) {
            object = object.iterator();
            while (object.hasNext()) {
                ((e)object.next()).b(this.h);
            }
            f.b(this.o, this.q, this.i);
        }
    }

    void l() {
        this.q.c();
        try {
            this.e(this.h);
            b b2 = ((ListenableWorker.a.a)this.n).e();
            this.r.t(this.h, b2);
            this.q.r();
            return;
        }
        finally {
            this.q.g();
            this.i(false);
        }
    }

    public void run() {
        List list;
        this.u = list = this.t.b(this.h);
        this.v = this.a(list);
        this.k();
    }

    public static class c {
        Context a;
        ListenableWorker b;
        A0.a c;
        D0.a d;
        a e;
        WorkDatabase f;
        String g;
        List h;
        WorkerParameters.a i = new WorkerParameters.a();

        public c(Context context, a a2, D0.a a3, A0.a a4, WorkDatabase workDatabase, String string) {
            this.a = context.getApplicationContext();
            this.d = a3;
            this.c = a4;
            this.e = a2;
            this.f = workDatabase;
            this.g = string;
        }

        public k a() {
            return new k(this);
        }

        public c b(WorkerParameters.a a2) {
            if (a2 != null) {
                this.i = a2;
            }
            return this;
        }

        public c c(List list) {
            this.h = list;
            return this;
        }
    }
}

