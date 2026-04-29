/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.privacysandbox.ads.adservices.topics.b
 *  androidx.privacysandbox.ads.adservices.topics.f
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 */
package d0;

import H2.l;
import H2.q;
import L2.e;
import U2.p;
import V2.g;
import V2.k;
import android.content.Context;
import c3.I;
import c3.J;
import c3.W;
import c3.f;

public abstract class a {
    public static final b a = new b(null);

    public static final a a(Context context) {
        return a.a(context);
    }

    public abstract l2.a b(androidx.privacysandbox.ads.adservices.topics.b var1);

    private static final class a
    extends a {
        private final androidx.privacysandbox.ads.adservices.topics.f b;

        public a(androidx.privacysandbox.ads.adservices.topics.f f2) {
            k.e(f2, "mTopicsManager");
            this.b = f2;
        }

        @Override
        public l2.a b(androidx.privacysandbox.ads.adservices.topics.b b2) {
            k.e(b2, "request");
            return b0.b.c(f.b(J.a(W.c()), null, null, new p(this, b2, null){
                int k;
                final a l;
                final androidx.privacysandbox.ads.adservices.topics.b m;
                {
                    this.l = a2;
                    this.m = b2;
                    super(2, e2);
                }

                @Override
                public final e i(Object object, e e2) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                @Override
                public final Object o(Object object) {
                    Object object2 = M2.b.e();
                    int n2 = this.k;
                    if (n2 != 0) {
                        if (n2 == 1) {
                            l.b(object);
                            return object;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    l.b(object);
                    androidx.privacysandbox.ads.adservices.topics.f f2 = this.l.b;
                    object = this.m;
                    this.k = 1;
                    object = f2.a((androidx.privacysandbox.ads.adservices.topics.b)object, (e)this);
                    if (object == object2) {
                        return object2;
                    }
                    return object;
                }

                public final Object r(I i2, e e2) {
                    return (this.i(i2, e2)).o(q.a);
                }
            }, 3, null), null, 1, null);
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g g2) {
            this();
        }

        public final a a(Context context) {
            k.e(context, "context");
            context = androidx.privacysandbox.ads.adservices.topics.f.a.a(context);
            if (context != null) {
                return new a((androidx.privacysandbox.ads.adservices.topics.f)context);
            }
            return null;
        }
    }
}

