/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.En
 *  com.google.android.gms.internal.ads.Fn
 *  com.google.android.gms.internal.ads.wn
 *  f1.p
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  x1.n
 */
package b1;

import T0.t;
import Z0.a;
import Z0.b;
import Z0.c;
import android.content.Context;
import android.os.RemoteException;
import b1.P1;
import b1.m1;
import b1.n1;
import b1.q1;
import b1.s;
import b1.x;
import b1.x1;
import b1.y0;
import com.google.android.gms.internal.ads.En;
import com.google.android.gms.internal.ads.Fn;
import com.google.android.gms.internal.ads.wn;
import f1.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import n1.a;
import x1.n;

public final class t1 {
    public static final Set l = new HashSet((Collection)Arrays.asList((Object[])new T0.c[]{T0.c.m, T0.c.i, T0.c.j}));
    private static t1 m;
    private n1 a;
    private x1 b;
    private m1 c;
    private final Object d = new Object();
    private final Object e = new Object();
    private final ArrayList f;
    private boolean g = false;
    private boolean h = false;
    private final Object i = new Object();
    private y0 j;
    private t k = new t.a().a();

    private t1() {
        this.f = new ArrayList();
    }

    private static b a(List object) {
        HashMap hashMap = new HashMap();
        for (wn wn2 : object) {
            String string = wn2.g;
            object = wn2.h ? a.a.h : a.a.g;
            hashMap.put((Object)string, (Object)new En((a.a)((Object)object), wn2.j, wn2.i));
        }
        return new Fn((Map)hashMap);
    }

    private final void b(t t2) {
        y0 y02 = this.j;
        if (y02 == null) {
            return;
        }
        try {
            P1 p12 = new P1(t2);
            y02.R3(p12);
            return;
        }
        catch (RemoteException remoteException) {
            p.d((String)"Unable to set request configuration parcel.", (Throwable)remoteException);
            return;
        }
    }

    private final void c(Context context) {
        if (this.j == null) {
            this.j = (y0)new s(x.b(), context).d(context, false);
        }
    }

    private final void d(String object) {
        object = this.j;
        if (object == null) {
            return;
        }
        try {
            object.c();
            this.j.e1(null, C1.b.h1(null));
            return;
        }
        catch (RemoteException remoteException) {
            p.g((String)"MobileAdsSettingManager initialization failed", (Throwable)remoteException);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static t1 e() {
        Class<t1> clazz = t1.class;
        synchronized (t1.class) {
            try {
                t1 t12;
                if (m != null) return m;
                m = t12 = new t1();
                return m;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    static /* synthetic */ b m(List list) {
        return t1.a(list);
    }

    /*
     * Exception decompiling
     */
    public final void f(Context var1_1, String var2_4, c var3_5) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [2 : 37->48)] java.lang.Throwable
         *     at fc.i.L0(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:227)
         *     at dc.f.b(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:196)
         *     at dc.f.c(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:7)
         *     at dc.f.a(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:157)
         *     at md.e.l(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:7)
         *     at kd.k.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:7)
         *     at kd.f.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:179)
         *     at og.h.r0(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:235)
         *     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.decompileWithCFR(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:784)
         *     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.doWork(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:141)
         *     at com.thesourceofcode.jadec.decompilers.BaseDecompiler.withAttempt(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:3)
         *     at z6.a.run(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:31)
         *     at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1154)
         *     at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:652)
         *     at java.lang.Thread.run(Thread.java:1564)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void g() {
        Object object;
        Object object2;
        Object object3 = object2 = this.d;
        synchronized (object3) {
            this.h = false;
            this.g = false;
            this.f.clear();
        }
        Object object4 = object = this.i;
        synchronized (object4) {
            Throwable throwable2;
            block13: {
                try {
                    try {
                        object2 = this.j;
                        if (object2 != null) {
                            object2.C();
                        }
                    }
                    catch (RemoteException remoteException) {
                        p.d((String)"Unable to stop the SDK.", (Throwable)remoteException);
                    }
                }
                catch (Throwable throwable2) {
                    break block13;
                }
                this.j = null;
                object2 = this.a;
                if (object2 != null) {
                    ((a)object2).a();
                    this.a = null;
                }
                if ((object2 = this.b) != null) {
                    ((a)object2).a();
                    this.b = null;
                }
                if ((object2 = this.c) != null) {
                    ((a)object2).a();
                    this.c = null;
                }
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final b h() {
        Object object;
        Object object2 = object = this.i;
        synchronized (object2) {
            Throwable throwable2;
            block6: {
                y0 y02;
                try {
                    boolean bl = this.j != null;
                    n.l((boolean)bl, (Object)"MobileAds.initialize() must be called prior to getting initialization status.");
                    y02 = this.j;
                    if (y02 == null) {
                        return new q1(this);
                    }
                }
                catch (Throwable throwable2) {
                    break block6;
                }
                try {
                    return t1.a(y02.m());
                }
                catch (RemoteException remoteException) {
                    p.c((String)"Unable to get Initialization status.");
                    return new q1(this);
                }
            }
            throw throwable2;
        }
    }

    public final t i() {
        return this.k;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void j(String string) {
        Object object;
        Object object2 = object = this.i;
        synchronized (object2) {
            Throwable throwable2;
            block6: {
                y0 y02;
                try {
                    boolean bl = this.j != null;
                    n.l((boolean)bl, (Object)"MobileAds.initialize() must be called prior to setting the plugin.");
                    y02 = this.j;
                    if (y02 == null) {
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block6;
                }
                try {
                    y02.d0(string);
                }
                catch (RemoteException remoteException) {
                    p.d((String)"Unable to set plugin.", (Throwable)remoteException);
                }
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final /* synthetic */ void k(String string) {
        Object object;
        Object object2 = object = this.i;
        synchronized (object2) {
            this.d(null);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final /* synthetic */ void l(String object) {
        Object object2 = object = this.i;
        synchronized (object2) {
            this.d(null);
            return;
        }
    }

    final /* synthetic */ Object n() {
        return this.d;
    }

    final /* synthetic */ ArrayList o() {
        return this.f;
    }

    final /* synthetic */ void p(boolean bl) {
        this.g = false;
    }

    final /* synthetic */ void q(boolean bl) {
        this.h = true;
    }
}

