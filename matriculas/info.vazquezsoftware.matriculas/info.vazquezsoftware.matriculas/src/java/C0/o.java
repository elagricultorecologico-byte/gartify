/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.core.os.a
 *  androidx.work.ListenableWorker
 *  androidx.work.impl.utils.futures.c
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  l2.a
 *  t0.e
 *  t0.j
 */
package C0;

import B0.p;
import D0.a;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.c;
import t0.e;
import t0.f;
import t0.j;

public class o
implements Runnable {
    static final String m = t0.j.f((String)"WorkForegroundRunnable");
    final c g = c.u();
    final Context h;
    final p i;
    final ListenableWorker j;
    final f k;
    final a l;

    public o(Context context, p p2, ListenableWorker listenableWorker, f f2, a a2) {
        this.h = context;
        this.i = p2;
        this.j = listenableWorker;
        this.k = f2;
        this.l = a2;
    }

    public l2.a a() {
        return this.g;
    }

    public void run() {
        if (this.i.q && !androidx.core.os.a.b()) {
            c c2 = c.u();
            this.l.a().execute(new Runnable(this, c2){
                final c g;
                final o h;
                {
                    this.h = o2;
                    this.g = c2;
                }

                public void run() {
                    this.g.s(this.h.j.getForegroundInfoAsync());
                }
            });
            c2.f(new Runnable(this, c2){
                final c g;
                final o h;
                {
                    this.h = o2;
                    this.g = c2;
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public void run() {
                    Throwable throwable2;
                    block3: {
                        Object object;
                        try {
                            object = (e)this.g.get();
                            if (object != null) {
                                t0.j.c().a(m, String.format((String)"Updating notification for %s", (Object[])new Object[]{this.h.i.c}), new Throwable[0]);
                                this.h.j.setRunInForeground(true);
                                o o2 = this.h;
                                o2.g.s(o2.k.a(o2.h, o2.j.getId(), (e)object));
                                return;
                            }
                        }
                        catch (Throwable throwable2) {
                            break block3;
                        }
                        String string = String.format((String)"Worker was marked important (%s) but did not provide ForegroundInfo", (Object[])new Object[]{this.h.i.c});
                        object = new IllegalStateException(string);
                        throw object;
                    }
                    this.h.g.r(throwable2);
                }
            }, this.l.a());
            return;
        }
        this.g.q(null);
    }
}

