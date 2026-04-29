/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  V2.k
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 */
package N2;

import H2.k;
import H2.l;
import M2.b;
import N2.e;
import N2.g;
import N2.h;
import java.io.Serializable;

public abstract class a
implements L2.e,
e,
Serializable {
    private final L2.e g;

    public a(L2.e e2) {
        this.g = e2;
    }

    @Override
    public e b() {
        L2.e e2 = this.g;
        if (e2 instanceof e) {
            return (e)((Object)e2);
        }
        return null;
    }

    @Override
    public final void e(Object object) {
        L2.e e2 = this;
        do {
            h.b(e2);
            a a2 = e2;
            e2 = a2.g;
            V2.k.b((Object)e2);
            try {
                object = a2.o(object);
                if (object == b.e()) {
                    return;
                }
                object = k.a(object);
            }
            catch (Throwable throwable) {
                k.a a3 = k.g;
                object = k.a(l.a(throwable));
            }
            a2.p();
        } while (e2 instanceof a);
        e2.e(object);
    }

    public L2.e i(Object object, L2.e e2) {
        V2.k.e((Object)e2, (String)"completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public final L2.e m() {
        return this.g;
    }

    public StackTraceElement n() {
        return N2.g.d(this);
    }

    protected abstract Object o(Object var1);

    protected void p() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Continuation at ");
        Object object = this.n();
        if (object == null) {
            object = this.getClass().getName();
        }
        stringBuilder.append(object);
        return stringBuilder.toString();
    }
}

