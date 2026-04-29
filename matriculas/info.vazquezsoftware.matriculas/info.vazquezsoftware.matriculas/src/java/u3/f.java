/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.AutoCloseable
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.net.Socket
 *  java.util.LinkedHashMap
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.TimeUnit
 */
package u3;

import H2.q;
import V2.g;
import V2.k;
import V2.r;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import m3.s;
import q3.e;
import u3.h;
import u3.i;
import u3.j;
import u3.l;
import u3.m;

public final class f
implements Closeable,
AutoCloseable {
    public static final b I = new b(null);
    private static final m J;
    private long A;
    private long B;
    private long C;
    private long D;
    private final Socket E;
    private final j F;
    private final d G;
    private final Set H;
    private final boolean g;
    private final c h;
    private final Map i;
    private final String j;
    private int k;
    private int l;
    private boolean m;
    private final e n;
    private final q3.d o;
    private final q3.d p;
    private final q3.d q;
    private final l r;
    private long s;
    private long t;
    private long u;
    private long v;
    private long w;
    private long x;
    private final m y;
    private m z;

    static {
        m m2 = new m();
        m2.h(7, 65535);
        m2.h(5, 16384);
        J = m2;
    }

    public f(a a2) {
        q3.d d2;
        String string;
        boolean bl;
        V2.k.e(a2, "builder");
        this.g = bl = a2.b();
        this.h = a2.d();
        this.i = new LinkedHashMap();
        this.j = string = a2.c();
        int n2 = a2.b() ? 3 : 2;
        this.l = n2;
        Object object = a2.j();
        this.n = object;
        this.o = d2 = ((e)object).i();
        this.p = ((e)object).i();
        this.q = ((e)object).i();
        this.r = a2.f();
        object = new m();
        if (a2.b()) {
            ((m)object).h(7, 0x1000000);
        }
        this.y = object;
        this.z = object = J;
        this.D = ((m)object).c();
        this.E = a2.h();
        this.F = new j(a2.g(), bl);
        this.G = new d(this, new h(a2.i(), bl));
        this.H = new LinkedHashSet();
        if (a2.e() != 0) {
            long l2 = TimeUnit.MILLISECONDS.toNanos((long)a2.e());
            d2.i(new q3.a(V2.k.j(string, " ping"), this, l2){
                final String e;
                final f f;
                final long g;
                {
                    this.e = string;
                    this.f = f2;
                    this.g = l2;
                    super(string, false, 2, null);
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 * Converted monitor instructions to comments
                 * Lifted jumps to return sites
                 */
                @Override
                public long f() {
                    boolean bl;
                    f f2;
                    f f3 = f2 = this.f;
                    // MONITORENTER : f3
                    if (this.f.t < this.f.s) {
                        bl = true;
                    } else {
                        long l2 = this.f.s;
                        this.f.s = l2 + 1L;
                        bl = false;
                    }
                    // MONITOREXIT : f3
                    if (bl) {
                        this.f.l0(null);
                        return -1L;
                    }
                    this.f.l1(false, 1, 0);
                    return this.g;
                }
            }, l2);
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final i T0(int var1_1, List var2_2, boolean var3_10) {
        var5_11 = 1;
        var7_12 = var3_10 ^ true;
        var11_14 = var8_13 = this.F;
        synchronized (var11_14) {
            block25: {
                try {
                    var12_15 = this;
                    synchronized (var12_15) {
                    }
                }
                catch (Throwable var2_9) {
                    break block25;
                }
                {
                    var4_16 = this.J0();
                    if (var4_16 > 0x3FFFFFFF) {
                    }
                    ** GOTO lbl-1000
                    {
                        block28: {
                            block29: {
                                block27: {
                                    block26: {
                                        catch (Throwable var2_8) {
                                            break block28;
                                        }
                                        try {
                                            this.f1(u3.b.p);
                                        }
                                        catch (Throwable var2_3) {
                                            break block28;
                                        }
lbl-1000:
                                        // 2 sources

                                        {
                                            if (this.m) ** GOTO lbl-1000
                                            var6_17 = this.J0();
                                            this.d1(this.J0() + 2);
                                        }
                                        {
                                            var9_18 = new i(var6_17, this, var7_12, false, null);
                                            var4_16 = var5_11;
                                            if (var3_10) {
                                                var4_16 = var5_11;
                                                if (this.Q0() < this.P0()) {
                                                    var4_16 = var9_18.r() >= var9_18.q() ? var5_11 : 0;
                                                }
                                            }
                                            if (var9_18.u()) {
                                                this.O0().put((Object)var6_17, (Object)var9_18);
                                            }
                                            var10_19 = H2.q.a;
                                            // MONITOREXIT @DISABLED, blocks:[4, 6, 8, 9] lbl35 : w: MONITOREXIT : var12_15
                                            if (var1_1 != 0) break block26;
                                        }
                                        try {
                                            this.R0().F(var7_12, var6_17, var2_2 /* !! */ );
                                            break block27;
                                        }
                                        catch (Throwable var2_6) {
                                            break block25;
                                        }
                                    }
                                    if (this.n0()) break block29;
                                    this.R0().M(var1_1, var6_17, var2_2 /* !! */ );
                                }
                                // MONITOREXIT @DISABLED, blocks:[6, 8] lbl44 : w: MONITOREXIT : var11_14
                                if (var4_16 != 0) {
                                    this.F.flush();
                                }
                                return var9_18;
                            }
                            var2_2 /* !! */  = new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                            throw var2_2 /* !! */ ;
lbl-1000:
                            // 1 sources

                            {
                                var2_2 /* !! */  = new u3.a();
                                throw var2_2 /* !! */ ;
                            }
                        }
                        throw var2_5;
                    }
                }
            }
            throw var2_7;
        }
    }

    public static final /* synthetic */ void Y(f f2, long l2) {
        f2.w = l2;
    }

    public static final /* synthetic */ void Z(f f2, long l2) {
        f2.v = l2;
    }

    public static final /* synthetic */ void b0(f f2, long l2) {
        f2.t = l2;
    }

    public static final /* synthetic */ long f(f f2) {
        return f2.w;
    }

    public static /* synthetic */ void h1(f f2, boolean bl, e e2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl = true;
        }
        if ((n2 & 2) != 0) {
            e2 = e.i;
        }
        f2.g1(bl, e2);
    }

    private final void l0(IOException iOException) {
        u3.b b2 = u3.b.j;
        this.k0(b2, b2, iOException);
    }

    public static final /* synthetic */ long p(f f2) {
        return f2.v;
    }

    public final int A0() {
        return this.k;
    }

    public final c I0() {
        return this.h;
    }

    public final int J0() {
        return this.l;
    }

    public final m K0() {
        return this.y;
    }

    public final m L0() {
        return this.z;
    }

    public final Socket M0() {
        return this.E;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final i N0(int n2) {
        f f2 = this;
        synchronized (f2) {
            return (i)this.i.get((Object)n2);
        }
    }

    public final Map O0() {
        return this.i;
    }

    public final long P0() {
        return this.D;
    }

    public final long Q0() {
        return this.C;
    }

    public final j R0() {
        return this.F;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean S0(long l2) {
        f f2 = this;
        synchronized (f2) {
            Throwable throwable2;
            block6: {
                long l3;
                block5: {
                    try {
                        boolean bl = this.m;
                        if (!bl) break block5;
                    }
                    catch (Throwable throwable2) {}
                    return false;
                }
                if (this.v >= this.u || l2 < (l3 = this.x)) break block6;
                return false;
            }
            return true;
            throw throwable2;
        }
    }

    public final i U0(List list, boolean bl) {
        V2.k.e(list, "requestHeaders");
        return this.T0(0, list, bl);
    }

    public final void V0(int n2, z3.d object, int n3, boolean bl) {
        V2.k.e(object, "source");
        z3.b b2 = new z3.b();
        long l2 = n3;
        object.u0(l2);
        object.j0(b2, l2);
        object = this.p;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.j);
        stringBuilder.append('[');
        stringBuilder.append(n2);
        stringBuilder.append("] onData");
        ((q3.d)object).i(new q3.a(stringBuilder.toString(), true, this, n2, b2, n3, bl){
            final String e;
            final boolean f;
            final f g;
            final int h;
            final z3.b i;
            final int j;
            final boolean k;
            {
                this.e = string;
                this.f = bl;
                this.g = f2;
                this.h = n2;
                this.i = b2;
                this.j = n3;
                this.k = bl2;
                super(string, bl);
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public long f() {
                try {
                    f f2;
                    boolean bl = this.g.r.d(this.h, this.i, this.j, this.k);
                    if (bl) {
                        this.g.R0().P(this.h, u3.b.q);
                    }
                    if (!bl) {
                        if (!this.k) return -1L;
                    }
                    f f3 = f2 = this.g;
                    synchronized (f3) {
                    }
                }
                catch (IOException iOException) {
                    return -1L;
                }
                {
                    this.g.H.remove((Object)this.h);
                    return -1L;
                }
            }
        }, 0L);
    }

    public final void W0(int n2, List list, boolean bl) {
        V2.k.e(list, "requestHeaders");
        q3.d d2 = this.p;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.j);
        stringBuilder.append('[');
        stringBuilder.append(n2);
        stringBuilder.append("] onHeaders");
        d2.i(new q3.a(stringBuilder.toString(), true, this, n2, list, bl){
            final String e;
            final boolean f;
            final f g;
            final int h;
            final List i;
            final boolean j;
            {
                this.e = string;
                this.f = bl;
                this.g = f2;
                this.h = n2;
                this.i = list;
                this.j = bl2;
                super(string, bl);
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public long f() {
                var1_1 = f.I(this.g).b(this.h, this.i, this.j);
                if (!var1_1) ** GOTO lbl5
                try {
                    this.g.R0().P(this.h, u3.b.q);
lbl5:
                    // 2 sources

                    if (!var1_1) {
                        if (this.j == false) return -1L;
                    }
                    var4_4 = var2_2 = this.g;
                    synchronized (var4_4) {
                    }
                }
                catch (IOException var2_3) {
                    return -1L;
                }
                {
                    f.i(this.g).remove((Object)this.h);
                    return -1L;
                }
            }
        }, 0L);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void X0(int n2, List list) {
        V2.k.e(list, "requestHeaders");
        f f2 = this;
        synchronized (f2) {
            boolean bl = this.H.contains((Object)n2);
            if (!bl) {
                this.H.add((Object)n2);
                // MONITOREXIT @DISABLED, blocks:[3, 5] lbl8 : w: MONITOREXIT : var6_4
                q3.d d2 = this.p;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.j);
                stringBuilder.append('[');
                stringBuilder.append(n2);
                stringBuilder.append("] onRequest");
                d2.i(new q3.a(stringBuilder.toString(), true, this, n2, list){
                    final String e;
                    final boolean f;
                    final f g;
                    final int h;
                    final List i;
                    {
                        this.e = string;
                        this.f = bl;
                        this.g = f2;
                        this.h = n2;
                        this.i = list;
                        super(string, bl);
                    }

                    /*
                     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     */
                    @Override
                    public long f() {
                        if (!this.g.r.a(this.h, this.i)) return -1L;
                        try {
                            f f2;
                            this.g.R0().P(this.h, u3.b.q);
                            f f3 = f2 = this.g;
                            synchronized (f3) {
                            }
                        }
                        catch (IOException iOException) {
                            return -1L;
                        }
                        {
                            this.g.H.remove((Object)this.h);
                            return -1L;
                        }
                    }
                }, 0L);
                return;
            }
            try {
                this.n1(n2, u3.b.j);
                return;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public final void Y0(int n2, u3.b b2) {
        V2.k.e((Object)b2, "errorCode");
        q3.d d2 = this.p;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.j);
        stringBuilder.append('[');
        stringBuilder.append(n2);
        stringBuilder.append("] onReset");
        d2.i(new q3.a(stringBuilder.toString(), true, this, n2, b2){
            final String e;
            final boolean f;
            final f g;
            final int h;
            final u3.b i;
            {
                this.e = string;
                this.f = bl;
                this.g = f2;
                this.h = n2;
                this.i = b2;
                super(string, bl);
            }

            @Override
            public long f() {
                f f2;
                this.g.r.c(this.h, this.i);
                f f3 = f2 = this.g;
                synchronized (f3) {
                    this.g.H.remove((Object)this.h);
                    q q2 = H2.q.a;
                    return -1L;
                }
            }
        }, 0L);
    }

    public final boolean Z0(int n2) {
        return n2 != 0 && (n2 & 1) == 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final i a1(int n2) {
        f f2 = this;
        synchronized (f2) {
            i i2 = (i)this.i.remove((Object)n2);
            this.notifyAll();
            return i2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void b1() {
        f f2 = this;
        synchronized (f2) {
            long l3 = this.v;
            long l2 = this.u;
            if (l3 < l2) {
                return;
            }
            this.u = l2 + 1L;
            this.x = System.nanoTime() + (long)1000000000;
            q q2 = H2.q.a;
        }
        this.o.i(new q3.a(V2.k.j(this.j, " ping"), true, this){
            final String e;
            final boolean f;
            final f g;
            {
                this.e = string;
                this.f = bl;
                this.g = f2;
                super(string, bl);
            }

            @Override
            public long f() {
                this.g.l1(false, 2, 0);
                return -1L;
            }
        }, 0L);
    }

    public final void c1(int n2) {
        this.k = n2;
    }

    public void close() {
        this.k0(u3.b.i, u3.b.q, null);
    }

    public final void d1(int n2) {
        this.l = n2;
    }

    public final void e1(m m2) {
        V2.k.e(m2, "<set-?>");
        this.z = m2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void f1(u3.b b2) {
        j j2;
        V2.k.e((Object)b2, "statusCode");
        j j3 = j2 = this.F;
        synchronized (j3) {
            Throwable throwable2;
            block8: {
                r r2;
                try {
                    r2 = new r();
                    f f2 = this;
                    synchronized (f2) {
                        boolean bl = this.m;
                        if (!bl) break block7;
                    }
                }
                catch (Throwable throwable2) {
                    break block8;
                }
                {
                    block7: {
                        return;
                    }
                    this.m = true;
                    r2.g = this.A0();
                    q q2 = H2.q.a;
                }
                this.R0().A(r2.g, b2, n3.d.a);
                return;
            }
            throw throwable2;
        }
    }

    public final void flush() {
        this.F.flush();
    }

    public final void g1(boolean bl, e e2) {
        V2.k.e(e2, "taskRunner");
        if (bl) {
            this.F.f();
            this.F.X(this.y);
            int n2 = this.y.c();
            if (n2 != 65535) {
                this.F.Y(0, n2 - 65535);
            }
        }
        e2.i().i(new q3.c(this.j, true, this.G), 0L);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void i1(long l2) {
        f f2 = this;
        synchronized (f2) {
            Throwable throwable2;
            block5: {
                block4: {
                    try {
                        this.A = l2 = this.A + l2;
                        if ((l2 -= this.B) < (long)(this.y.c() / 2)) break block4;
                        this.o1(0, l2);
                        this.B += l2;
                    }
                    catch (Throwable throwable2) {
                        break block5;
                    }
                }
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Exception decompiling
     */
    public final void j1(int var1_1, boolean var2_2, z3.b var3_3, long var4_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [3 : 74->120)] java.lang.Throwable
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
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void k0(u3.b object, u3.b b2, IOException iOException) {
        int n2;
        block16: {
            block15: {
                V2.k.e(object, "connectionCode");
                V2.k.e((Object)b2, "streamCode");
                if (n3.d.h && Thread.holdsLock((Object)this)) {
                    object = new StringBuilder();
                    object.append("Thread ");
                    object.append((Object)Thread.currentThread().getName());
                    object.append(" MUST NOT hold lock on ");
                    object.append((Object)this);
                    throw new AssertionError((Object)object.toString());
                }
                try {
                    this.f1((u3.b)((Object)object));
                }
                catch (IOException iOException2) {}
                f f2 = this;
                // MONITORENTER : f2
                boolean bl = this.O0().isEmpty();
                n2 = 0;
                if (bl) break block15;
                object = this.O0().values().toArray((Object[])new i[0]);
                if (object == null) {
                    object = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    throw object;
                }
                this.O0().clear();
                break block16;
            }
            object = null;
        }
        Object object2 = H2.q.a;
        // MONITOREXIT : f2
        object = (i[])object;
        if (object != null) {
            int n3 = ((Object[])object).length;
            while (n2 < n3) {
                object2 = object[n2];
                try {
                    ((i)object2).d(b2, iOException);
                }
                catch (IOException iOException3) {}
                ++n2;
            }
        }
        try {
            this.R0().close();
        }
        catch (IOException iOException4) {}
        try {
            this.M0().close();
        }
        catch (IOException iOException5) {}
        this.o.o();
        this.p.o();
        this.q.o();
    }

    public final void k1(int n2, boolean bl, List list) {
        V2.k.e(list, "alternating");
        this.F.F(bl, n2, list);
    }

    public final void l1(boolean bl, int n2, int n3) {
        try {
            this.F.L(bl, n2, n3);
            return;
        }
        catch (IOException iOException) {
            this.l0(iOException);
            return;
        }
    }

    public final void m1(int n2, u3.b b2) {
        V2.k.e((Object)b2, "statusCode");
        this.F.P(n2, b2);
    }

    public final boolean n0() {
        return this.g;
    }

    public final void n1(int n2, u3.b b2) {
        V2.k.e((Object)b2, "errorCode");
        q3.d d2 = this.o;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.j);
        stringBuilder.append('[');
        stringBuilder.append(n2);
        stringBuilder.append("] writeSynReset");
        d2.i(new q3.a(stringBuilder.toString(), true, this, n2, b2){
            final String e;
            final boolean f;
            final f g;
            final int h;
            final u3.b i;
            {
                this.e = string;
                this.f = bl;
                this.g = f2;
                this.h = n2;
                this.i = b2;
                super(string, bl);
            }

            @Override
            public long f() {
                try {
                    this.g.m1(this.h, this.i);
                }
                catch (IOException iOException) {
                    this.g.l0(iOException);
                }
                return -1L;
            }
        }, 0L);
    }

    public final void o1(int n2, long l2) {
        q3.d d2 = this.o;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.j);
        stringBuilder.append('[');
        stringBuilder.append(n2);
        stringBuilder.append("] windowUpdate");
        d2.i(new q3.a(stringBuilder.toString(), true, this, n2, l2){
            final String e;
            final boolean f;
            final f g;
            final int h;
            final long i;
            {
                this.e = string;
                this.f = bl;
                this.g = f2;
                this.h = n2;
                this.i = l2;
                super(string, bl);
            }

            @Override
            public long f() {
                try {
                    this.g.R0().Y(this.h, this.i);
                }
                catch (IOException iOException) {
                    this.g.l0(iOException);
                }
                return -1L;
            }
        }, 0L);
    }

    public final String s0() {
        return this.j;
    }

    public static final class a {
        private boolean a;
        private final e b;
        public Socket c;
        public String d;
        public z3.d e;
        public z3.c f;
        private c g;
        private l h;
        private int i;

        public a(boolean bl, e e2) {
            V2.k.e(e2, "taskRunner");
            this.a = bl;
            this.b = e2;
            this.g = u3.f$c.b;
            this.h = u3.l.b;
        }

        public final f a() {
            return new f(this);
        }

        public final boolean b() {
            return this.a;
        }

        public final String c() {
            String string = this.d;
            if (string != null) {
                return string;
            }
            V2.k.o("connectionName");
            return null;
        }

        public final c d() {
            return this.g;
        }

        public final int e() {
            return this.i;
        }

        public final l f() {
            return this.h;
        }

        public final z3.c g() {
            z3.c c2 = this.f;
            if (c2 != null) {
                return c2;
            }
            V2.k.o("sink");
            return null;
        }

        public final Socket h() {
            Socket socket = this.c;
            if (socket != null) {
                return socket;
            }
            V2.k.o("socket");
            return null;
        }

        public final z3.d i() {
            z3.d d2 = this.e;
            if (d2 != null) {
                return d2;
            }
            V2.k.o("source");
            return null;
        }

        public final e j() {
            return this.b;
        }

        public final a k(c c2) {
            V2.k.e(c2, "listener");
            this.n(c2);
            return this;
        }

        public final a l(int n2) {
            this.o(n2);
            return this;
        }

        public final void m(String string) {
            V2.k.e(string, "<set-?>");
            this.d = string;
        }

        public final void n(c c2) {
            V2.k.e(c2, "<set-?>");
            this.g = c2;
        }

        public final void o(int n2) {
            this.i = n2;
        }

        public final void p(z3.c c2) {
            V2.k.e(c2, "<set-?>");
            this.f = c2;
        }

        public final void q(Socket socket) {
            V2.k.e(socket, "<set-?>");
            this.c = socket;
        }

        public final void r(z3.d d2) {
            V2.k.e(d2, "<set-?>");
            this.e = d2;
        }

        public final a s(Socket object, String string, z3.d d2, z3.c c2) {
            V2.k.e(object, "socket");
            V2.k.e(string, "peerName");
            V2.k.e(d2, "source");
            V2.k.e(c2, "sink");
            this.q((Socket)object);
            if (this.b()) {
                object = new StringBuilder();
                object.append(n3.d.i);
                object.append(' ');
                object.append(string);
                object = object.toString();
            } else {
                object = V2.k.j("MockWebServer ", string);
            }
            this.m((String)object);
            this.r(d2);
            this.p(c2);
            return this;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g g2) {
            this();
        }

        public final m a() {
            return J;
        }
    }

    public static abstract class c {
        public static final b a = new b(null);
        public static final c b = new c(){

            @Override
            public void b(i i2) {
                V2.k.e(i2, "stream");
                i2.d(u3.b.p, null);
            }
        };

        public void a(f f2, m m2) {
            V2.k.e(f2, "connection");
            V2.k.e(m2, "settings");
        }

        public abstract void b(i var1);

        public static final class b {
            private b() {
            }

            public /* synthetic */ b(g g2) {
                this();
            }
        }
    }

    public final class d
    implements h.c,
    U2.a {
        private final h g;
        final f h;

        public d(f f2, h h2) {
            V2.k.e(f2, "this$0");
            V2.k.e(h2, "reader");
            this.h = f2;
            this.g = h2;
        }

        @Override
        public void b(int n2, u3.b b2) {
            V2.k.e((Object)b2, "errorCode");
            if (this.h.Z0(n2)) {
                this.h.Y0(n2, b2);
                return;
            }
            i i2 = this.h.a1(n2);
            if (i2 == null) {
                return;
            }
            i2.y(b2);
        }

        @Override
        public void c(boolean bl, int n2, z3.d d2, int n3) {
            V2.k.e(d2, "source");
            if (this.h.Z0(n2)) {
                this.h.V0(n2, d2, n3, bl);
                return;
            }
            Object object = this.h.N0(n2);
            if (object == null) {
                this.h.n1(n2, u3.b.j);
                object = this.h;
                long l2 = n3;
                ((f)object).i1(l2);
                d2.x(l2);
                return;
            }
            ((i)object).w(d2, n3);
            if (bl) {
                ((i)object).x(n3.d.b, true);
            }
        }

        @Override
        public void e() {
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void f(boolean var1_1, int var2_2, int var3_3) {
            if (!var1_1) {
                f.P(this.h).i(new q3.a(V2.k.j(this.h.s0(), " ping"), true, this.h, var2_2, var3_3){
                    final String e;
                    final boolean f;
                    final f g;
                    final int h;
                    final int i;
                    {
                        this.e = string;
                        this.f = bl;
                        this.g = f2;
                        this.h = n2;
                        this.i = n3;
                        super(string, bl);
                    }

                    @Override
                    public long f() {
                        this.g.l1(true, this.h, this.i);
                        return -1L;
                    }
                }, 0L);
                return;
            }
            var6_5 = var4_4 = this.h;
            synchronized (var6_5) {
                if (var2_2 == 1) ** GOTO lbl18
                if (var2_2 == 2) ** GOTO lbl16
                if (var2_2 == 3) ** GOTO lbl-1000
                try {}
                catch (Throwable var5_7) {}
                ** GOTO lbl14
lbl-1000:
                // 1 sources

                {
                    block4: {
                        f.Y(var4_4, f.f(var4_4) + 1L);
                        var4_4.notifyAll();
lbl14:
                        // 2 sources

                        var5_6 = H2.q.a;
                        break block4;
lbl16:
                        // 1 sources

                        f.Z(var4_4, f.p(var4_4) + 1L);
                        break block4;
lbl18:
                        // 1 sources

                        f.b0(var4_4, f.F(var4_4) + 1L);
                    }
                    return;
                }
                throw var5_7;
            }
        }

        @Override
        public void i(int n2, int n3, int n4, boolean bl) {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        @Override
        public void k(boolean bl, int n2, int n3, List object) {
            q3.a a2;
            block7: {
                f f2;
                block10: {
                    block9: {
                        block8: {
                            V2.k.e(object, "headerBlock");
                            if (this.h.Z0(n2)) {
                                this.h.W0(n2, (List)object, bl);
                                return;
                            }
                            f f3 = f2 = this.h;
                            // MONITORENTER : f3
                            a2 = f2.N0(n2);
                            if (a2 != null) break block7;
                            boolean bl2 = f2.m;
                            if (!bl2) break block8;
                            return;
                        }
                        n3 = f2.A0();
                        if (n2 > n3) break block9;
                        // MONITOREXIT : f3
                        return;
                    }
                    n3 = f2.J0();
                    if (n2 % 2 != n3 % 2) break block10;
                    // MONITOREXIT : f3
                    return;
                }
                Object object2 = n3.d.P(object);
                object = new i(n2, f2, false, bl, (s)object2);
                f2.c1(n2);
                f2.O0().put((Object)n2, object);
                object2 = f2.n.i();
                a2 = new StringBuilder();
                a2.append(f2.s0());
                a2.append('[');
                a2.append(n2);
                a2.append("] onStream");
                String string = a2.toString();
                a2 = new q3.a(string, true, f2, (i)object){
                    final String e;
                    final boolean f;
                    final f g;
                    final i h;
                    {
                        this.e = string;
                        this.f = bl;
                        this.g = f2;
                        this.h = i2;
                        super(string, bl);
                    }

                    /*
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     */
                    @Override
                    public long f() {
                        try {
                            this.g.I0().b(this.h);
                            return -1L;
                        }
                        catch (IOException iOException) {
                            v3.k.a.g().j(V2.k.j("Http2Connection.Listener failure for ", this.g.s0()), 4, iOException);
                            try {
                                this.h.d(u3.b.j, iOException);
                                return -1L;
                            }
                            catch (IOException iOException2) {
                                return -1L;
                            }
                        }
                    }
                };
                ((q3.d)object2).i(a2, 0L);
                // MONITOREXIT : f3
                return;
            }
            q q2 = H2.q.a;
            // MONITOREXIT : f3
            ((i)((Object)a2)).x(n3.d.P(object), bl);
        }

        @Override
        public void l(int n2, long l2) {
            if (n2 == 0) {
                f f2;
                f f3 = f2 = this.h;
                synchronized (f3) {
                    f2.D = f2.P0() + l2;
                    f2.notifyAll();
                    q q2 = H2.q.a;
                    return;
                }
            }
            i i2 = this.h.N0(n2);
            if (i2 != null) {
                i i3 = i2;
                synchronized (i3) {
                    i2.a(l2);
                    q q3 = H2.q.a;
                    return;
                }
            }
        }

        @Override
        public void m(boolean bl, m m2) {
            V2.k.e(m2, "settings");
            this.h.o.i(new q3.a(V2.k.j(this.h.s0(), " applyAndAckSettings"), true, this, bl, m2){
                final String e;
                final boolean f;
                final d g;
                final boolean h;
                final m i;
                {
                    this.e = string;
                    this.f = bl;
                    this.g = d2;
                    this.h = bl2;
                    this.i = m2;
                    super(string, bl);
                }

                @Override
                public long f() {
                    this.g.p(this.h, this.i);
                    return -1L;
                }
            }, 0L);
        }

        @Override
        public void n(int n2, int n3, List list) {
            V2.k.e(list, "requestHeaders");
            this.h.X0(n3, list);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        @Override
        public void o(int n2, u3.b object, z3.e object2) {
            block5: {
                V2.k.e(object, "errorCode");
                V2.k.e(object2, "debugData");
                ((z3.e)object2).u();
                Object object3 = object = this.h;
                // MONITORENTER : object3
                object2 = ((f)object).O0().values();
                int n3 = 0;
                Object[] objectArray = object2.toArray((Object[])new i[0]);
                if (objectArray == null) break block5;
                ((f)object).m = true;
                object2 = H2.q.a;
                // MONITOREXIT : object3
                object = (i[])objectArray;
                int n4 = ((Object)object).length;
                while (n3 < n4) {
                    int n5;
                    object2 = object[n3];
                    n3 = n5 = n3 + 1;
                    if (((i)object2).j() <= n2) continue;
                    n3 = n5;
                    if (!((i)object2).t()) continue;
                    ((i)object2).y(u3.b.p);
                    this.h.a1(((i)object2).j());
                    n3 = n5;
                }
                return;
            }
            object2 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            throw object2;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        public final void p(boolean bl, m object) {
            Throwable throwable2;
            block17: {
                int n2;
                long l2;
                Object object2;
                Object object3;
                f f2;
                Object object4;
                V2.s s2;
                block16: {
                    block15: {
                        V2.k.e(object, "settings");
                        s2 = new V2.s();
                        object4 = this.h.R0();
                        f2 = this.h;
                        j j2 = object4;
                        // MONITORENTER : j2
                        f f3 = f2;
                        // MONITORENTER : f3
                        try {
                            object3 = f2.L0();
                            if (!bl) {
                                object2 = new m();
                                ((m)object2).g((m)object3);
                                ((m)object2).g((m)object);
                                object = object2;
                            }
                            s2.g = object;
                            l2 = (long)object.c() - (long)((m)object3).c();
                            n2 = 0;
                            if (l2 == 0L || f2.O0().isEmpty()) break block15;
                            object = f2.O0().values().toArray((Object[])new i[0]);
                            if (object == null) {
                                object = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                throw object;
                            }
                            object = (i[])object;
                            break block16;
                        }
                        catch (Throwable throwable2) {
                            break block17;
                        }
                    }
                    object = null;
                }
                f2.e1((m)s2.g);
                object3 = f2.q;
                object2 = V2.k.j(f2.s0(), " onSettings");
                q3.a a2 = new q3.a((String)object2, true, f2, s2){
                    final String e;
                    final boolean f;
                    final f g;
                    final V2.s h;
                    {
                        this.e = string;
                        this.f = bl;
                        this.g = f2;
                        this.h = s2;
                        super(string, bl);
                    }

                    @Override
                    public long f() {
                        this.g.I0().a(this.g, (m)this.h.g);
                        return -1L;
                    }
                };
                ((q3.d)object3).i(a2, 0L);
                object2 = H2.q.a;
                // MONITOREXIT : f3
                try {
                    f2.R0().a((m)s2.g);
                }
                catch (IOException iOException) {
                    f2.l0(iOException);
                }
                object2 = H2.q.a;
                // MONITOREXIT : j2
                if (object == null) return;
                int n3 = ((Object[])object).length;
                while (n2 < n3) {
                    object2 = object[n2];
                    ++n2;
                    Object object5 = object2;
                    // MONITORENTER : object5
                    ((i)object2).a(l2);
                    object4 = H2.q.a;
                    // MONITOREXIT : object5
                }
                return;
            }
            // MONITOREXIT : f3
            throw throwable2;
        }

        /*
         * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
         * Loose catch block
         * WARNING - void declaration
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void q() {
            void var3_11;
            u3.b b2;
            u3.b b3;
            u3.b b4;
            block10: {
                void var3_10;
                u3.b b5;
                block11: {
                    block9: {
                        b4 = u3.b.k;
                        b3 = null;
                        b2 = null;
                        this.g.i(this);
                        while (this.g.f(false, this)) {
                        }
                        b5 = u3.b.i;
                        b3 = b2;
                        b2 = b5;
                        try {}
                        catch (IOException iOException) {
                            b2 = b5;
                        }
                        finally {
                            break block9;
                        }
                        catch (Throwable throwable) {
                            b2 = b4;
                            break block10;
                        }
                        catch (IOException iOException) {
                            b2 = b4;
                            break block11;
                        }
                    }
                    u3.b b6 = u3.b.q;
                    this.h.k0(b5, b6, null);
                    n3.d.m(this.g);
                    return;
                }
                b3 = var3_10;
                {
                    b5 = u3.b.j;
                }
                this.h.k0(b5, b5, (IOException)var3_10);
                n3.d.m(this.g);
                return;
            }
            this.h.k0(b2, b4, (IOException)((Object)b3));
            n3.d.m(this.g);
            throw var3_11;
        }
    }
}

