/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.WorkDatabase
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  t0.j
 *  t0.s
 *  u0.d
 *  u0.j
 */
package C0;

import B0.q;
import androidx.work.impl.WorkDatabase;
import t0.j;
import t0.s;
import u0.d;

public class m
implements Runnable {
    private static final String j = t0.j.f((String)"StopWorkRunnable");
    private final u0.j g;
    private final String h;
    private final boolean i;

    public m(u0.j j2, String string, boolean bl) {
        this.g = j2;
        this.h = string;
        this.i = bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Throwable throwable2;
        WorkDatabase workDatabase;
        block5: {
            boolean bl;
            block4: {
                q q2;
                block3: {
                    workDatabase = this.g.o();
                    d d2 = this.g.m();
                    q2 = workDatabase.B();
                    workDatabase.c();
                    try {
                        bl = d2.h(this.h);
                        if (!this.i) break block3;
                        bl = this.g.m().n(this.h);
                        break block4;
                    }
                    catch (Throwable throwable2) {
                        break block5;
                    }
                }
                if (!bl && q2.h(this.h) == s.h) {
                    q2.m(s.g, this.h);
                }
                bl = this.g.m().o(this.h);
            }
            t0.j.c().a(j, String.format((String)"StopWorkRunnable for %s; Processor.stopWork = %s", (Object[])new Object[]{this.h, bl}), new Throwable[0]);
            workDatabase.r();
            workDatabase.g();
            return;
        }
        workDatabase.g();
        throw throwable2;
    }
}

