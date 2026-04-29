/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  W0.e
 *  W0.k
 *  W0.l
 *  W0.n
 *  android.content.Context
 *  android.os.RemoteException
 *  b1.A
 *  b1.E1
 *  b1.H
 *  b1.N
 *  b1.Q
 *  b1.U1
 *  b1.W1
 *  b1.g2
 *  b1.i1
 *  b1.x
 *  com.google.android.gms.ads.nativead.NativeAd$c
 *  com.google.android.gms.ads.nativead.c
 *  com.google.android.gms.internal.ads.Cl
 *  com.google.android.gms.internal.ads.Ek
 *  com.google.android.gms.internal.ads.Nl
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Ol
 *  com.google.android.gms.internal.ads.Vq
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.Yj
 *  com.google.android.gms.internal.ads.kp
 *  com.google.android.gms.internal.ads.op
 *  f1.c
 *  f1.p
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  x1.n
 */
package T0;

import T0.d;
import T0.g;
import T0.y;
import W0.e;
import W0.k;
import W0.l;
import android.content.Context;
import android.os.RemoteException;
import b1.A;
import b1.E1;
import b1.H;
import b1.N;
import b1.Q;
import b1.U1;
import b1.W1;
import b1.g2;
import b1.i1;
import b1.x;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.internal.ads.Cl;
import com.google.android.gms.internal.ads.Ek;
import com.google.android.gms.internal.ads.Nl;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Ol;
import com.google.android.gms.internal.ads.Vq;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.Yj;
import com.google.android.gms.internal.ads.kp;
import com.google.android.gms.internal.ads.op;
import f1.c;
import f1.p;
import x1.n;

public class f {
    private final g2 a;
    private final Context b;
    private final N c;

    f(Context context, N n2, g2 g22) {
        this.b = context;
        this.c = n2;
        this.a = g22;
    }

    private final void c(i1 i12) {
        Context context = this.b;
        Yi.a((Context)context);
        if (((Boolean)Yj.c.e()).booleanValue()) {
            Oi oi = Yi.Cc;
            if (((Boolean)A.c().d(oi)).booleanValue()) {
                f1.c.b.execute((Runnable)new y(this, i12));
                return;
            }
        }
        try {
            this.c.I0(this.a.a(context, i12));
            return;
        }
        catch (RemoteException remoteException) {
            p.d((String)"Failed to load ad.", (Throwable)remoteException);
            return;
        }
    }

    public void a(g g3) {
        this.c(g3.a);
    }

    final /* synthetic */ void b(i1 i12) {
        try {
            this.c.I0(this.a.a(this.b, i12));
            return;
        }
        catch (RemoteException remoteException) {
            p.d((String)"Failed to load ad.", (Throwable)remoteException);
            return;
        }
    }

    public static class a {
        private final Context a;
        private final Q b;

        public a(Context context, String string) {
            Context context2 = (Context)n.j((Object)context, (Object)"context cannot be null");
            context = x.b().c(context, string, (op)new kp());
            this.a = context2;
            this.b = context;
        }

        public f a() {
            try {
                f f2 = new f(this.a, this.b.c(), g2.a);
                return f2;
            }
            catch (RemoteException remoteException) {
                p.d((String)"Failed to build AdLoader.", (Throwable)remoteException);
                E1 e1 = new E1();
                return new f(this.a, e1.L5(), g2.a);
            }
        }

        public a b(NativeAd.c c2) {
            try {
                Q q2 = this.b;
                Vq vq = new Vq(c2);
                q2.B2((Cl)vq);
                return this;
            }
            catch (RemoteException remoteException) {
                p.g((String)"Failed to add google native ad listener", (Throwable)remoteException);
                return this;
            }
        }

        public a c(d d2) {
            try {
                Q q2 = this.b;
                W1 w1 = new W1(d2);
                q2.n5((H)w1);
                return this;
            }
            catch (RemoteException remoteException) {
                p.g((String)"Failed to set AdListener.", (Throwable)remoteException);
                return this;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public a d(com.google.android.gms.ads.nativead.c c2) {
            RemoteException remoteException2;
            block2: {
                Object object;
                int n2;
                boolean bl;
                boolean bl2;
                Q q2;
                try {
                    q2 = this.b;
                    bl2 = c2.e();
                    bl = c2.d();
                    n2 = c2.a();
                    object = c2.c() != null ? new U1(c2.c()) : null;
                }
                catch (RemoteException remoteException2) {
                    break block2;
                }
                Ek ek = new Ek(4, bl2, -1, bl, n2, object, c2.f(), c2.b(), c2.g(), c2.h(), c2.i() - 1);
                q2.i5(ek);
                return this;
            }
            p.g((String)"Failed to specify native ad options", (Throwable)remoteException2);
            return this;
        }

        public final a e(W0.n n2) {
            try {
                Q q2 = this.b;
                Ol ol = new Ol(n2);
                q2.B2((Cl)ol);
                return this;
            }
            catch (RemoteException remoteException) {
                p.g((String)"Failed to add google native ad listener", (Throwable)remoteException);
                return this;
            }
        }

        public final a f(String string, l l2, k k2) {
            l2 = new Nl(l2, k2);
            try {
                this.b.b1(string, l2.a(), l2.b());
                return this;
            }
            catch (RemoteException remoteException) {
                p.g((String)"Failed to add custom template ad listener", (Throwable)remoteException);
                return this;
            }
        }

        public final a g(e e2) {
            try {
                Q q2 = this.b;
                Ek ek = new Ek(e2);
                q2.i5(ek);
                return this;
            }
            catch (RemoteException remoteException) {
                p.g((String)"Failed to specify native ad options", (Throwable)remoteException);
                return this;
            }
        }
    }
}

