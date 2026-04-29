/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.concurrent.RejectedExecutionException
 *  java.util.logging.Level
 */
package q3;

import H2.q;
import V2.k;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import q3.a;
import q3.b;
import q3.e;

public final class d {
    private final e a;
    private final String b;
    private boolean c;
    private a d;
    private final List e;
    private boolean f;

    public d(e e2, String string) {
        k.e(e2, "taskRunner");
        k.e(string, "name");
        this.a = e2;
        this.b = string;
        this.e = new ArrayList();
    }

    public static /* synthetic */ void j(d d2, a a2, long l2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            l2 = 0L;
        }
        d2.i(a2, l2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a() {
        e e2;
        if (n3.d.h && Thread.holdsLock((Object)this)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            stringBuilder.append((Object)Thread.currentThread().getName());
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append((Object)this);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        e e3 = e2 = this.a;
        synchronized (e3) {
            Throwable throwable2;
            block5: {
                block4: {
                    try {
                        if (!this.b()) break block4;
                        this.h().h(this);
                    }
                    catch (Throwable throwable2) {
                        break block5;
                    }
                }
                q q2 = q.a;
                return;
            }
            throw throwable2;
        }
    }

    public final boolean b() {
        a a2 = this.d;
        if (a2 != null) {
            k.b(a2);
            if (a2.a()) {
                this.f = true;
            }
        }
        int n2 = this.e.size() - 1;
        boolean bl = false;
        if (n2 >= 0) {
            while (true) {
                int n3 = n2 - 1;
                if (((a)this.e.get(n2)).a()) {
                    a2 = (a)this.e.get(n2);
                    if (q3.e.h.a().isLoggable(Level.FINE)) {
                        q3.b.a(a2, this, "canceled");
                    }
                    this.e.remove(n2);
                    bl = true;
                }
                if (n3 < 0) {
                    return bl;
                }
                n2 = n3;
            }
        }
        return false;
    }

    public final a c() {
        return this.d;
    }

    public final boolean d() {
        return this.f;
    }

    public final List e() {
        return this.e;
    }

    public final String f() {
        return this.b;
    }

    public final boolean g() {
        return this.c;
    }

    public final e h() {
        return this.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void i(a object, long l2) {
        e e2;
        k.e(object, "task");
        e e3 = e2 = this.a;
        synchronized (e3) {
            Throwable throwable2;
            block9: {
                block6: {
                    block7: {
                        block8: {
                            try {
                                if (!this.g()) break block6;
                                if (!((a)object).a()) break block7;
                                if (!q3.e.h.a().isLoggable(Level.FINE)) break block8;
                                q3.b.a((a)object, this, "schedule canceled (queue is shutdown)");
                            }
                            catch (Throwable throwable2) {}
                        }
                        return;
                    }
                    if (q3.e.h.a().isLoggable(Level.FINE)) {
                        q3.b.a((a)object, this, "schedule failed (queue is shutdown)");
                    }
                    object = new RejectedExecutionException();
                    throw object;
                    break block9;
                }
                if (this.k((a)object, l2, false)) {
                    this.h().h(this);
                }
                object = q.a;
                return;
            }
            throw throwable2;
        }
    }

    public final boolean k(a a2, long l2, boolean bl) {
        int n2;
        block7: {
            Object object;
            k.e(a2, "task");
            a2.e(this);
            long l3 = this.a.g().a();
            long l4 = l3 + l2;
            n2 = this.e.indexOf((Object)a2);
            if (n2 != -1) {
                if (a2.c() <= l4) {
                    if (q3.e.h.a().isLoggable(Level.FINE)) {
                        q3.b.a(a2, this, "already scheduled");
                    }
                    return false;
                }
                this.e.remove(n2);
            }
            a2.g(l4);
            if (q3.e.h.a().isLoggable(Level.FINE)) {
                object = bl ? k.j("run again after ", q3.b.b(l4 - l3)) : k.j("scheduled after ", q3.b.b(l4 - l3));
                q3.b.a(a2, this, (String)object);
            }
            object = this.e.iterator();
            n2 = 0;
            while (object.hasNext()) {
                if (((a)object.next()).c() - l3 <= l2) {
                    ++n2;
                    continue;
                }
                break block7;
            }
            n2 = -1;
        }
        int n3 = n2;
        if (n2 == -1) {
            n3 = this.e.size();
        }
        this.e.add(n3, (Object)a2);
        return n3 == 0;
    }

    public final void l(a a2) {
        this.d = a2;
    }

    public final void m(boolean bl) {
        this.f = bl;
    }

    public final void n(boolean bl) {
        this.c = bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void o() {
        e e2;
        if (n3.d.h && Thread.holdsLock((Object)this)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            stringBuilder.append((Object)Thread.currentThread().getName());
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append((Object)this);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        e e3 = e2 = this.a;
        synchronized (e3) {
            Throwable throwable2;
            block5: {
                block4: {
                    try {
                        this.n(true);
                        if (!this.b()) break block4;
                        this.h().h(this);
                    }
                    catch (Throwable throwable2) {
                        break block5;
                    }
                }
                q q2 = q.a;
                return;
            }
            throw throwable2;
        }
    }

    public String toString() {
        return this.b;
    }
}

