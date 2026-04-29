/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  V2.k
 *  c3.I
 *  c3.J
 *  c3.f
 *  c3.p0
 *  e3.f
 *  e3.g
 *  e3.h
 *  e3.h$a
 *  e3.l
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.atomic.AtomicInteger
 */
package L;

import H2.q;
import L2.e;
import L2.i;
import M2.b;
import U2.p;
import c3.I;
import c3.J;
import c3.f;
import c3.p0;
import e3.g;
import e3.h;
import e3.l;
import java.util.concurrent.atomic.AtomicInteger;

public final class k {
    private final I a;
    private final p b;
    private final e3.f c;
    private final AtomicInteger d;

    public k(I i2, U2.l l2, p p2, p p3) {
        V2.k.e((Object)i2, (String)"scope");
        V2.k.e((Object)l2, (String)"onComplete");
        V2.k.e((Object)p2, (String)"onUndeliveredElement");
        V2.k.e((Object)p3, (String)"consumeMessage");
        this.a = i2;
        this.b = p3;
        this.c = g.b((int)Integer.MAX_VALUE, null, null, (int)6, null);
        this.d = new AtomicInteger(0);
        i2 = (p0)i2.a().i((i.c)p0.e);
        if (i2 == null) {
            return;
        }
        i2.M(new U2.l(l2, this, p2){
            final U2.l h;
            final k i;
            final p j;
            {
                this.h = l2;
                this.i = k2;
                this.j = p2;
                super(1);
            }

            public final void b(Throwable throwable) {
                Object object;
                this.h.j(throwable);
                this.i.c.a(throwable);
                do {
                    if ((object = h.d((Object)this.i.c.c())) == null) {
                        object = null;
                        continue;
                    }
                    this.j.h(object, throwable);
                    object = q.a;
                } while (object != null);
            }
        });
    }

    public static final /* synthetic */ p a(k k2) {
        return k2.b;
    }

    public static final /* synthetic */ AtomicInteger c(k k2) {
        return k2.d;
    }

    public static final /* synthetic */ I d(k k2) {
        return k2.a;
    }

    public final void e(Object object) {
        if ((object = this.c.d(object)) instanceof h.a) {
            Throwable throwable = h.c((Object)object);
            object = throwable;
            if (throwable == null) {
                object = new l("Channel was closed normally");
            }
            throw object;
        }
        if (h.f((Object)object)) {
            if (this.d.getAndIncrement() == 0) {
                f.d((I)this.a, null, null, (p)new p(this, null){
                    Object k;
                    int l;
                    final k m;
                    {
                        this.m = k2;
                        super(2, e2);
                    }

                    @Override
                    public final e i(Object object, e e2) {
                        return new /* invalid duplicate definition of identical inner class */;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Override
                    public final Object o(Object var1_1) {
                        block6: {
                            block3: {
                                block4: {
                                    block5: {
                                        var5_2 = M2.b.e();
                                        var2_3 = this.l;
                                        if (var2_3 == 0) break block3;
                                        if (var2_3 == 1) break block4;
                                        if (var2_3 != 2) break block5;
                                        H2.l.b(var1_1);
                                        ** GOTO lbl31
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                var3_4 = (p)this.k;
                                H2.l.b(var1_1);
                                ** GOTO lbl26
                            }
                            H2.l.b(var1_1);
                            var2_3 = k.c(this.m).get() > 0 ? 1 : 0;
                            if (var2_3 == 0) break block6;
                            do {
                                block7: {
                                    J.c((I)k.d(this.m));
                                    var3_4 = k.a(this.m);
                                    var1_1 = k.b(this.m);
                                    this.k = var3_4;
                                    this.l = 1;
                                    var1_1 = var4_5 = var1_1.b((e)this);
                                    if (var4_5 == var5_2) break block7;
lbl26:
                                    // 2 sources

                                    this.k = null;
                                    this.l = 2;
                                    if (var3_4.h(var1_1, this) != var5_2) continue;
                                }
                                return var5_2;
lbl31:
                                // 2 sources

                            } while (k.c(this.m).decrementAndGet() != 0);
                            return q.a;
                        }
                        throw new IllegalStateException("Check failed.");
                    }

                    public final Object r(I i2, e e2) {
                        return (this.i(i2, e2)).o(q.a);
                    }
                }, (int)3, null);
            }
            return;
        }
        throw new IllegalStateException("Check failed.");
    }
}

