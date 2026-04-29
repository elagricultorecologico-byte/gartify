/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.concurrent.futures.c
 *  androidx.concurrent.futures.c$a
 *  androidx.concurrent.futures.c$c
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.concurrent.CancellationException
 */
package b0;

import U2.l;
import V2.k;
import androidx.concurrent.futures.c;
import b0.a;
import c3.P;
import java.util.concurrent.CancellationException;

public abstract class b {
    public static /* synthetic */ Object a(P p3, Object object, c.a a3) {
        return b.d(p3, object, a3);
    }

    public static final l2.a b(P object, Object object2) {
        k.e(object, "<this>");
        object = c.a((c.c)new a((P)object, object2));
        k.d(object, "getFuture { completer ->\u2026        }\n    }\n    tag\n}");
        return object;
    }

    public static /* synthetic */ l2.a c(P p3, Object object, int n3, Object object2) {
        if ((n3 & 1) != 0) {
            object = "Deferred.asListenableFuture";
        }
        return b.b(p3, object);
    }

    private static final Object d(P p3, Object object, c.a a3) {
        k.e(p3, "$this_asListenableFuture");
        k.e(a3, "completer");
        p3.M(new l(a3, p3){
            final c.a h;
            final P i;
            {
                this.h = a3;
                this.i = p3;
                super(1);
            }

            public final void b(Throwable throwable) {
                if (throwable != null) {
                    if (throwable instanceof CancellationException) {
                        this.h.d();
                        return;
                    }
                    this.h.f(throwable);
                    return;
                }
                this.h.c(this.i.p());
            }
        });
        return object;
    }
}

