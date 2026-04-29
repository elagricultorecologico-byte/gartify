/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 */
package v0;

import B0.p;
import java.util.HashMap;
import java.util.Map;
import t0.j;
import t0.q;
import v0.b;

public class a {
    static final String d = j.f("DelayedWorkTracker");
    final b a;
    private final q b;
    private final Map c;

    public a(b b2, q q2) {
        this.a = b2;
        this.b = q2;
        this.c = new HashMap();
    }

    public void a(p p2) {
        Runnable runnable = (Runnable)this.c.remove((Object)p2.a);
        if (runnable != null) {
            this.b.b(runnable);
        }
        runnable = new Runnable(this, p2){
            final p g;
            final a h;
            {
                this.h = a2;
                this.g = p2;
            }

            public void run() {
                j.c().a(d, String.format((String)"Scheduling work %s", (Object[])new Object[]{this.g.a}), new Throwable[0]);
                this.h.a.f(this.g);
            }
        };
        this.c.put((Object)p2.a, (Object)runnable);
        long l2 = System.currentTimeMillis();
        long l3 = p2.a();
        this.b.a(l3 - l2, runnable);
    }

    public void b(String string) {
        if ((string = (Runnable)this.c.remove((Object)string)) != null) {
            this.b.b((Runnable)string);
        }
    }
}

