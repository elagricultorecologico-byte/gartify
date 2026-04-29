/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.foreground.a
 *  androidx.work.impl.utils.futures.c
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.UUID
 *  l2.a
 *  t0.e
 *  t0.j
 *  t0.s
 */
package C0;

import B0.q;
import D0.a;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.futures.c;
import java.util.UUID;
import t0.e;
import t0.f;
import t0.j;
import t0.s;

public class p
implements f {
    private static final String d = j.f((String)"WMFgUpdater");
    private final a a;
    final A0.a b;
    final q c;

    public p(WorkDatabase workDatabase, A0.a a2, a a3) {
        this.b = a2;
        this.a = a3;
        this.c = workDatabase.B();
    }

    @Override
    public l2.a a(Context context, UUID uUID, e e2) {
        c c2 = androidx.work.impl.utils.futures.c.u();
        this.a.b(new Runnable(this, c2, uUID, e2, context){
            final c g;
            final UUID h;
            final e i;
            final Context j;
            final p k;
            {
                this.k = p2;
                this.g = c2;
                this.h = uUID;
                this.i = e2;
                this.j = context;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void run() {
                Throwable throwable2;
                block4: {
                    block2: {
                        Object object;
                        block3: {
                            try {
                                if (this.g.isCancelled()) break block2;
                                object = this.h.toString();
                                s s2 = this.k.c.h((String)object);
                                if (s2 == null || s2.d()) break block3;
                                this.k.b.c((String)object, this.i);
                                object = androidx.work.impl.foreground.a.b((Context)this.j, (String)object, (e)this.i);
                                this.j.startService((Intent)object);
                                break block2;
                            }
                            catch (Throwable throwable2) {
                                break block4;
                            }
                        }
                        object = new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                        throw object;
                    }
                    this.g.q(null);
                    return;
                }
                this.g.r(throwable2);
            }
        });
        return c2;
    }
}

