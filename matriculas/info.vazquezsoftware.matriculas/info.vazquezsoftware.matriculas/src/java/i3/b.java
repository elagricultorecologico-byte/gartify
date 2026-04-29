/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 */
package i3;

import H2.k;
import H2.l;
import L2.e;
import L2.i;
import N2.a;
import N2.h;
import U2.p;
import V2.w;
import c3.v0;
import c3.w0;
import c3.x;
import h3.K;
import h3.z;

public abstract class b {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final void a(p object, Object object2, e e2) {
        Throwable throwable3;
        Throwable throwable22;
        Object object3;
        i i2;
        block7: {
            e2 = h.a(e2);
            try {
                i2 = e2.getContext();
                object3 = K.i(i2, null);
            }
            catch (Throwable throwable22) {}
            try {
                h.b(e2);
                object = !(object instanceof a) ? M2.b.d((p)object, object2, e2) : ((p)w.a(object, 2)).h(object2, e2);
            }
            catch (Throwable throwable3) {
                break block7;
            }
            K.f(i2, object3);
            if (object != M2.b.e()) {
                e2.e(k.a(object));
            }
            return;
        }
        K.f(i2, object3);
        throw throwable3;
        object2 = k.g;
        e2.e(k.a(l.a(throwable22)));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final Object b(z object, Object object2, p p2) {
        block6: {
            Throwable throwable2;
            block5: {
                block4: {
                    try {
                        if (p2 instanceof a) break block4;
                        object2 = M2.b.d(p2, object2, (e)object);
                    }
                    catch (Throwable throwable2) {
                        break block5;
                    }
                }
                object2 = ((p)w.a(p2, 2)).h(object2, object);
                break block6;
            }
            object2 = new x(throwable2, false, 2, null);
        }
        if (object2 == M2.b.e()) {
            return M2.b.e();
        }
        if ((object = ((v0)object).d0(object2)) == w0.b) {
            return M2.b.e();
        }
        if (object instanceof x) throw ((x)object).a;
        return w0.h(object);
    }
}

