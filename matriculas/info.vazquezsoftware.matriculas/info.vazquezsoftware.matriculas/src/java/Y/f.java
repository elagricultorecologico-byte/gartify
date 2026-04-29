/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Q
 *  androidx.lifecycle.S
 *  androidx.lifecycle.S$c
 *  androidx.lifecycle.S$e
 *  androidx.lifecycle.U
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package Y;

import V2.k;
import X.a;
import Y.d;
import Y.g;
import Y.h;
import Z2.b;
import androidx.lifecycle.Q;
import androidx.lifecycle.S;
import androidx.lifecycle.U;

public final class f {
    private final U a;
    private final S.c b;
    private final a c;
    private final d d;

    public f(U u2, S.c c3, a a3) {
        k.e(u2, "store");
        k.e(c3, "factory");
        k.e(a3, "defaultExtras");
        this.a = u2;
        this.b = c3;
        this.c = a3;
        this.d = new d();
    }

    public static /* synthetic */ Q e(f f3, b b3, String string, int n3, Object object) {
        if ((n3 & 2) != 0) {
            string = h.a.c(b3);
        }
        return f3.d(b3, string);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Q d(b b3, String string) {
        d d3;
        k.e(b3, "modelClass");
        k.e(string, "key");
        d d4 = d3 = this.d;
        synchronized (d4) {
            Throwable throwable2;
            block5: {
                Object object;
                block3: {
                    block4: {
                        try {
                            object = this.a.b(string);
                            if (!b3.b(object)) break block3;
                            if (!(this.b instanceof S.e)) break block4;
                            b3 = (S.e)this.b;
                            k.b(object);
                            b3.d((Q)object);
                        }
                        catch (Throwable throwable2) {
                            break block5;
                        }
                    }
                    k.c(object, "null cannot be cast to non-null type T of androidx.lifecycle.viewmodel.internal.ViewModelProviderImpl.getViewModel");
                    return object;
                }
                object = new X.b(this.c);
                ((X.b)object).c(S.c, string);
                b3 = g.a(this.b, b3, (a)object);
                this.a.d(string, (Q)b3);
                return b3;
            }
            throw throwable2;
        }
    }
}

