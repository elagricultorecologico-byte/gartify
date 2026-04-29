/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Throwable
 */
package x1;

import x1.p;

public final class o {
    private static o b;
    private static final p c;
    private p a;

    static {
        c = new p(0, false, false, 0, 0);
    }

    private o() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static o b() {
        Class<o> clazz = o.class;
        synchronized (o.class) {
            try {
                o o2;
                if (b != null) return b;
                b = o2 = new o();
                return b;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public p a() {
        return this.a;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void c(p var1_1) {
        var5_3 = this;
        synchronized (var5_3) {
            block5: {
                block4: {
                    if (var1_1 != null) break block4;
                    try {
                        this.a = o.c;
                        return;
                    }
                    catch (Throwable var1_2) {
                        break block5;
                    }
                }
                var4_4 = this.a;
                if (var4_4 == null || (var2_5 = var4_4.g()) < (var3_6 = var1_1.g())) ** GOTO lbl-1000
                return;
lbl-1000:
                // 1 sources

                {
                    this.a = var1_1;
                    return;
                }
            }
            throw var1_2;
        }
    }
}

