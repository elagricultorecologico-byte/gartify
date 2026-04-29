/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Set
 */
package z0;

import D0.a;
import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import t0.j;

public abstract class d {
    private static final String f = j.f("ConstraintTracker");
    protected final a a;
    protected final Context b;
    private final Object c = new Object();
    private final Set d = new LinkedHashSet();
    Object e;

    d(Context context, a a2) {
        this.b = context.getApplicationContext();
        this.a = a2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(x0.a a2) {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            Throwable throwable2;
            block5: {
                block3: {
                    block4: {
                        try {
                            if (!this.d.add((Object)a2)) break block3;
                            if (this.d.size() != 1) break block4;
                            this.e = this.b();
                            j.c().a(f, String.format((String)"%s: initial state = %s", (Object[])new Object[]{this.getClass().getSimpleName(), this.e}), new Throwable[0]);
                            this.e();
                        }
                        catch (Throwable throwable2) {
                            break block5;
                        }
                    }
                    a2.a(this.e);
                }
                return;
            }
            throw throwable2;
        }
    }

    public abstract Object b();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(x0.a a2) {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        if (!this.d.remove((Object)a2) || !this.d.isEmpty()) break block3;
                        this.f();
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(Object object) {
        Object object2;
        Object object3 = object2 = this.c;
        synchronized (object3) {
            Throwable throwable2;
            block8: {
                block6: {
                    Runnable runnable;
                    block7: {
                        try {
                            runnable = this.e;
                            if (runnable == object) break block6;
                            if (runnable == null) break block7;
                        }
                        catch (Throwable throwable2) {
                            break block8;
                        }
                        if (runnable.equals(object)) break block6;
                    }
                    this.e = object;
                    ArrayList arrayList = new ArrayList((Collection)this.d);
                    object = this.a.a();
                    runnable = new Runnable(this, (List)arrayList){
                        final List g;
                        final d h;
                        {
                            this.h = d2;
                            this.g = list;
                        }

                        public void run() {
                            Iterator iterator = this.g.iterator();
                            while (iterator.hasNext()) {
                                ((x0.a)iterator.next()).a(this.h.e);
                            }
                        }
                    };
                    object.execute(runnable);
                    return;
                }
                return;
            }
            throw throwable2;
        }
    }

    public abstract void e();

    public abstract void f();
}

