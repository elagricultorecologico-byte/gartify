/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.PowerManager$WakeLock
 *  androidx.core.content.a
 *  androidx.work.WorkerParameters$a
 *  androidx.work.a
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.foreground.a
 *  java.lang.Boolean
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.ExecutionException
 */
package u0;

import C0.n;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import t0.e;
import t0.j;
import u0.b;
import u0.k;

public class d
implements b,
A0.a {
    private static final String r = t0.j.f("Processor");
    private PowerManager.WakeLock g;
    private Context h;
    private androidx.work.a i;
    private D0.a j;
    private WorkDatabase k;
    private Map l;
    private Map m;
    private List n;
    private Set o;
    private final List p;
    private final Object q;

    public d(Context context, androidx.work.a a2, D0.a a3, WorkDatabase workDatabase, List list) {
        this.h = context;
        this.i = a2;
        this.j = a3;
        this.k = workDatabase;
        this.m = new HashMap();
        this.l = new HashMap();
        this.n = list;
        this.o = new HashSet();
        this.p = new ArrayList();
        this.g = null;
        this.q = new Object();
    }

    private static boolean e(String string, k k2) {
        if (k2 != null) {
            k2.d();
            t0.j.c().a(r, String.format((String)"WorkerWrapper interrupted for %s", (Object[])new Object[]{string}), new Throwable[0]);
            return true;
        }
        t0.j.c().a(r, String.format((String)"WorkerWrapper could not be found for %s", (Object[])new Object[]{string}), new Throwable[0]);
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void m() {
        var3_2 = var1_1 = this.q;
        synchronized (var3_2) {
            block8: {
                if (this.l.isEmpty()) {
                    var2_3 = androidx.work.impl.foreground.a.f((Context)this.h);
                }
                ** GOTO lbl21
                {
                    block9: {
                        catch (Throwable var2_5) {
                            break block8;
                        }
                        try {
                            this.h.startService(var2_3);
                            break block9;
                        }
                        catch (Throwable var2_4) {}
                        t0.j.c().b(d.r, "Unable to stop foreground service", new Throwable[]{var2_4});
                    }
                    var2_3 = this.g;
                    if (var2_3 != null) {
                        var2_3.release();
                        this.g = null;
                    }
lbl21:
                    // 4 sources

                    return;
                }
            }
            throw var2_5;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(String string, boolean bl) {
        Object object;
        Object object2 = object = this.q;
        synchronized (object2) {
            try {
                this.m.remove((Object)string);
                t0.j.c().a(r, String.format((String)"%s %s executed; reschedule = %s", (Object[])new Object[]{this.getClass().getSimpleName(), string, bl}), new Throwable[0]);
                Iterator iterator = this.p.iterator();
                while (true) {
                    if (!iterator.hasNext()) {
                        return;
                    }
                    ((b)iterator.next()).a(string, bl);
                }
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
    @Override
    public void b(String string) {
        Object object;
        Object object2 = object = this.q;
        synchronized (object2) {
            this.l.remove((Object)string);
            this.m();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c(String string, e e2) {
        Object object;
        Object object2 = object = this.q;
        synchronized (object2) {
            Throwable throwable2;
            block5: {
                block3: {
                    k k2;
                    block4: {
                        try {
                            PowerManager.WakeLock wakeLock;
                            t0.j.c().d(r, String.format((String)"Moving WorkSpec (%s) to the foreground", (Object[])new Object[]{string}), new Throwable[0]);
                            k2 = (k)this.m.remove((Object)string);
                            if (k2 == null) break block3;
                            if (this.g != null) break block4;
                            this.g = wakeLock = C0.n.b(this.h, "ProcessorForegroundLck");
                            wakeLock.acquire();
                        }
                        catch (Throwable throwable2) {
                            break block5;
                        }
                    }
                    this.l.put((Object)string, (Object)k2);
                    string = androidx.work.impl.foreground.a.e((Context)this.h, (String)string, (e)e2);
                    androidx.core.content.a.k((Context)this.h, (Intent)string);
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
    public void d(b b2) {
        Object object;
        Object object2 = object = this.q;
        synchronized (object2) {
            this.p.add((Object)b2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean f(String string) {
        Object object;
        Object object2 = object = this.q;
        synchronized (object2) {
            return this.o.contains((Object)string);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean g(String string) {
        Object object;
        Object object2 = object = this.q;
        synchronized (object2) {
            try {
                if (this.m.containsKey((Object)string)) return true;
                if (!this.l.containsKey((Object)string)) return false;
                return true;
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
    public boolean h(String string) {
        Object object;
        Object object2 = object = this.q;
        synchronized (object2) {
            return this.l.containsKey((Object)string);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void i(b b2) {
        Object object;
        Object object2 = object = this.q;
        synchronized (object2) {
            this.p.remove((Object)b2);
            return;
        }
    }

    public boolean j(String string) {
        return this.k(string, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public boolean k(String string, WorkerParameters.a object) {
        block9: {
            Object object3;
            Object object4 = object3 = this.q;
            // MONITORENTER : object4
            try {
                boolean bl = this.g(string);
                if (!bl) break block9;
            }
            catch (Throwable throwable) {
                throw string;
            }
            try {
                t0.j.c().a(r, String.format((String)"Work %s is already enqueued for processing", (Object[])new Object[]{string}), new Throwable[0]);
                // MONITOREXIT : object4
                return false;
            }
            catch (Throwable throwable) {
                throw string;
            }
        }
        Context context = this.h;
        androidx.work.a a2 = this.i;
        Object object5 = this.j;
        Object object2 = this.k;
        try {
            k.c c3 = new k.c(context, a2, (D0.a)object5, this, (WorkDatabase)object2, string);
            object2 = c3.c(this.n).b((WorkerParameters.a)object).a();
            object = ((k)object2).b();
            object5 = new a(this, string, (l2.a)object);
            object.f((Runnable)object5, this.j.a());
            this.m.put((Object)string, object2);
            // MONITOREXIT : object4
        }
        catch (Throwable throwable) {
            throw string;
        }
        this.j.c().execute((Runnable)object2);
        t0.j.c().a(r, String.format((String)"%s: processing %s", (Object[])new Object[]{this.getClass().getSimpleName(), string}), new Throwable[0]);
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean l(String string) {
        Object object;
        boolean bl = false;
        Object object2 = object = this.q;
        synchronized (object2) {
            Throwable throwable2;
            block6: {
                k k2;
                block5: {
                    try {
                        t0.j.c().a(r, String.format((String)"Processor cancelling %s", (Object[])new Object[]{string}), new Throwable[0]);
                        this.o.add((Object)string);
                        k k3 = (k)this.l.remove((Object)string);
                        if (k3 != null) {
                            bl = true;
                        }
                        k2 = k3;
                        if (k3 != null) break block5;
                        k2 = (k)this.m.remove((Object)string);
                    }
                    catch (Throwable throwable2) {
                        break block6;
                    }
                }
                boolean bl2 = d.e(string, k2);
                if (bl) {
                    this.m();
                }
                return bl2;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean n(String string) {
        Object object;
        Object object2 = object = this.q;
        synchronized (object2) {
            t0.j.c().a(r, String.format((String)"Processor stopping foreground work %s", (Object[])new Object[]{string}), new Throwable[0]);
            return d.e(string, (k)this.l.remove((Object)string));
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean o(String string) {
        Object object;
        Object object2 = object = this.q;
        synchronized (object2) {
            t0.j.c().a(r, String.format((String)"Processor stopping background work %s", (Object[])new Object[]{string}), new Throwable[0]);
            return d.e(string, (k)this.m.remove((Object)string));
        }
    }

    private static class a
    implements Runnable {
        private b g;
        private String h;
        private l2.a i;

        a(b b2, String string, l2.a a2) {
            this.g = b2;
            this.h = string;
            this.i = a2;
        }

        public void run() {
            boolean bl;
            try {
                bl = (Boolean)this.i.get();
            }
            catch (InterruptedException | ExecutionException throwable) {
                bl = true;
            }
            this.g.a(this.h, bl);
        }
    }
}

