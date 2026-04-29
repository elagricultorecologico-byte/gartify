/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver$PendingResult
 *  android.content.Context
 *  android.os.Build$VERSION
 *  androidx.work.WorkerParameters$a
 *  androidx.work.a
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.utils.ForceStopRunnable
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Arrays
 *  java.util.List
 *  java.util.UUID
 *  java.util.concurrent.Executor
 *  v0.b
 *  w0.l
 */
package u0;

import C0.a;
import C0.h;
import D0.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.ForceStopRunnable;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import t0.j;
import t0.m;
import t0.p;
import t0.t;
import u0.d;
import u0.e;
import u0.f;
import u0.g;
import u0.i;
import w0.l;

public class j
extends t {
    private static final String j = t0.j.f("WorkManagerImpl");
    private static j k = null;
    private static j l = null;
    private static final Object m = new Object();
    private Context a;
    private androidx.work.a b;
    private WorkDatabase c;
    private D0.a d;
    private List e;
    private d f;
    private h g;
    private boolean h;
    private BroadcastReceiver.PendingResult i;

    public j(Context context, androidx.work.a a2, D0.a a3) {
        this(context, a2, a3, context.getResources().getBoolean(p.a));
    }

    public j(Context context, androidx.work.a a2, D0.a a3, WorkDatabase workDatabase) {
        Context context2 = context.getApplicationContext();
        t0.j.e(new j.a(a2.j()));
        context2 = this.g(context2, a2, a3);
        this.q(context, a2, a3, workDatabase, (List)context2, new d(context, a2, a3, workDatabase, (List)context2));
    }

    public j(Context context, androidx.work.a a2, D0.a a3, boolean bl) {
        this(context, a2, a3, WorkDatabase.s((Context)context.getApplicationContext(), (Executor)a3.c(), (boolean)bl));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void e(Context object, androidx.work.a a2) {
        Object object2;
        Object object3 = object2 = m;
        synchronized (object3) {
            Throwable throwable2;
            block6: {
                Object object4;
                try {
                    object4 = k;
                    if (object4 != null && l != null) {
                        object = new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                        throw object;
                    }
                }
                catch (Throwable throwable2) {
                    break block6;
                }
                if (object4 == null) {
                    Context context = object.getApplicationContext();
                    if (l == null) {
                        object4 = new b(a2.l());
                        object = new j(context, a2, (D0.a)object4);
                        l = object;
                    }
                    k = l;
                }
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static j j() {
        Object object;
        Object object2 = object = m;
        synchronized (object2) {
            try {
                j j2 = k;
                if (j2 == null) return l;
                return j2;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static j k(Context object) {
        Object object2;
        Object object3 = object2 = m;
        synchronized (object3) {
            Throwable throwable2;
            block4: {
                try {
                    j j2 = u0.j.j();
                    if (j2 != null) {
                        return j2;
                    }
                }
                catch (Throwable throwable2) {
                    break block4;
                }
                object.getApplicationContext();
                object = new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                throw object;
            }
            throw throwable2;
        }
    }

    private void q(Context context, androidx.work.a a2, D0.a a3, WorkDatabase workDatabase, List list, d d3) {
        this.a = context = context.getApplicationContext();
        this.b = a2;
        this.d = a3;
        this.c = workDatabase;
        this.e = list;
        this.f = d3;
        this.g = new h(workDatabase);
        this.h = false;
        if (Build.VERSION.SDK_INT >= 24 && u0.i.a(context)) {
            throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
        }
        this.d.b((Runnable)new ForceStopRunnable(context, this));
    }

    @Override
    public m a(String object) {
        object = C0.a.d((String)object, this);
        this.d.b((Runnable)object);
        return ((a)object).e();
    }

    @Override
    public m b(List list) {
        if (!list.isEmpty()) {
            return new g(this, list).a();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    public m f(UUID object) {
        object = C0.a.b((UUID)object, this);
        this.d.b((Runnable)object);
        return ((a)object).e();
    }

    public List g(Context context, androidx.work.a a2, D0.a a3) {
        return Arrays.asList((Object[])new e[]{u0.f.a(context, this), new v0.b(context, a2, a3, this)});
    }

    public Context h() {
        return this.a;
    }

    public androidx.work.a i() {
        return this.b;
    }

    public h l() {
        return this.g;
    }

    public d m() {
        return this.f;
    }

    public List n() {
        return this.e;
    }

    public WorkDatabase o() {
        return this.c;
    }

    public D0.a p() {
        return this.d;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void r() {
        Object object;
        Object object2 = object = m;
        synchronized (object2) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        this.h = true;
                        BroadcastReceiver.PendingResult pendingResult = this.i;
                        if (pendingResult == null) break block3;
                        pendingResult.finish();
                        this.i = null;
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                return;
            }
            throw throwable2;
        }
    }

    public void s() {
        w0.l.a((Context)this.h());
        this.o().B().u();
        u0.f.b(this.i(), this.o(), this.n());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void t(BroadcastReceiver.PendingResult pendingResult) {
        Object object;
        Object object2 = object = m;
        synchronized (object2) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        this.i = pendingResult;
                        if (!this.h) break block3;
                        pendingResult.finish();
                        this.i = null;
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                return;
            }
            throw throwable2;
        }
    }

    public void u(String string) {
        this.v(string, null);
    }

    public void v(String string, WorkerParameters.a a2) {
        this.d.b(new C0.l(this, string, a2));
    }

    public void w(String string) {
        this.d.b(new C0.m(this, string, true));
    }

    public void x(String string) {
        this.d.b(new C0.m(this, string, false));
    }
}

