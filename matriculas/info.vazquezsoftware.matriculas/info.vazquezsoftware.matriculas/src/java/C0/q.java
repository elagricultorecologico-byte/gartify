/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.b
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.utils.futures.c
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.UUID
 *  l2.a
 *  t0.j
 *  t0.s
 */
package C0;

import B0.m;
import D0.a;
import android.content.Context;
import androidx.work.b;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.futures.c;
import java.util.UUID;
import t0.j;
import t0.o;
import t0.s;

public class q
implements o {
    static final String c = j.f((String)"WorkProgressUpdater");
    final WorkDatabase a;
    final a b;

    public q(WorkDatabase workDatabase, a a2) {
        this.a = workDatabase;
        this.b = a2;
    }

    @Override
    public l2.a a(Context context, UUID uUID, b b2) {
        context = androidx.work.impl.utils.futures.c.u();
        this.b.b(new Runnable(this, uUID, b2, (c)context){
            final UUID g;
            final b h;
            final c i;
            final q j;
            {
                this.j = q2;
                this.g = uUID;
                this.h = b2;
                this.i = c2;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void run() {
                Throwable throwable2;
                Object object;
                block8: {
                    object = this.g.toString();
                    Object object2 = j.c();
                    Object object3 = c;
                    object2.a((String)object3, String.format((String)"Updating progress for %s (%s)", (Object[])new Object[]{this.g, this.h}), new Throwable[0]);
                    this.j.a.c();
                    try {
                        object2 = this.j.a.B().j((String)object);
                        if (object2 == null) break block8;
                        if (object2.b == s.h) {
                            object3 = new m((String)object, this.h);
                            this.j.a.A().b((m)object3);
                        } else {
                            j.c().h((String)object3, String.format((String)"Ignoring setProgressAsync(...). WorkSpec (%s) is not in a RUNNING state.", (Object[])new Object[]{object}), new Throwable[0]);
                        }
                        this.i.q(null);
                        this.j.a.r();
                    }
                    catch (Throwable throwable2) {}
                    this.j.a.g();
                    return;
                }
                object = new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                throw object;
                try {
                    j.c().b(c, "Error updating Worker progress", new Throwable[]{throwable2});
                    this.i.r(throwable2);
                    return;
                }
                finally {
                    this.j.a.g();
                }
            }
        });
        return context;
    }
}

