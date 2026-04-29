/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  V2.g
 *  V2.k
 *  V2.q
 *  V2.s
 *  androidx.appcompat.app.E
 *  c3.I
 *  c3.f
 *  c3.s
 *  c3.u
 *  f3.d
 *  f3.j
 *  f3.m
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.AutoCloseable
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Set
 *  l3.a
 *  l3.g
 */
package L;

import H2.f;
import L.g;
import L.h;
import N2.d;
import V2.q;
import V2.s;
import androidx.appcompat.app.E;
import c3.I;
import c3.u;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class l
implements L.e {
    public static final a k = new a(null);
    private static final Set l = new LinkedHashSet();
    private static final Object m = new Object();
    private final U2.a a;
    private final L.j b;
    private final L.a c;
    private final I d;
    private final f3.b e;
    private final String f;
    private final H2.e g;
    private final f3.j h;
    private List i;
    private final L.k j;

    public l(U2.a a2, L.j j2, List list, L.a a3, I i2) {
        V2.k.e((Object)a2, (String)"produceFile");
        V2.k.e((Object)j2, (String)"serializer");
        V2.k.e((Object)list, (String)"initTasksList");
        V2.k.e((Object)a3, (String)"corruptionHandler");
        V2.k.e((Object)i2, (String)"scope");
        this.a = a2;
        this.b = j2;
        this.c = a3;
        this.d = i2;
        this.e = f3.d.e((U2.p)new U2.p(this, null){
            int k;
            private Object l;
            final l m;
            {
                this.m = l2;
                super(2, e2);
            }

            @Override
            public final L2.e i(Object object, L2.e e2) {
                e2 = new /* invalid duplicate definition of identical inner class */;
                e2.l = object;
                return e2;
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Override
            public final Object o(Object object) {
                Object object2 = M2.b.e();
                int n2 = this.k;
                if (n2 != 0) {
                    if (n2 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    H2.l.b(object);
                    return H2.q.a;
                } else {
                    H2.l.b(object);
                    object = (f3.c)this.l;
                    Object object3 = (L.m)this.m.h.getValue();
                    if (!(object3 instanceof L.b)) {
                        this.m.j.e(new b.a((L.m)object3));
                    }
                    object3 = new f3.b(f3.d.a((f3.b)this.m.h, (U2.p)new U2.p((L.m)object3, null){
                        int k;
                        Object l;
                        final L.m m;
                        {
                            this.m = m2;
                            super(2, e2);
                        }

                        @Override
                        public final L2.e i(Object object, L2.e e2) {
                            e2 = new /* invalid duplicate definition of identical inner class */;
                            e2.l = object;
                            return e2;
                        }

                        @Override
                        public final Object o(Object object) {
                            M2.b.e();
                            if (this.k == 0) {
                                boolean bl;
                                H2.l.b(object);
                                object = (L.m)this.l;
                                L.m m2 = this.m;
                                boolean bl2 = m2 instanceof L.b;
                                boolean bl3 = bl = false;
                                if (!bl2) {
                                    if (m2 instanceof g) {
                                        bl3 = bl;
                                    } else {
                                        bl3 = bl;
                                        if (object == m2) {
                                            bl3 = true;
                                        }
                                    }
                                }
                                return N2.b.a(bl3);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        public final Object r(L.m m2, L2.e e2) {
                            return (this.i(m2, e2)).o(H2.q.a);
                        }
                    })){
                        final f3.b g;
                        {
                            this.g = b2;
                        }

                        @Override
                        public Object a(f3.c object, L2.e e2) {
                            if ((object = this.g.a(new f3.c((f3.c)object){
                                final f3.c g;
                                {
                                    this.g = c2;
                                }

                                /*
                                 * Unable to fully structure code
                                 */
                                @Override
                                public Object f(Object var1_1, L2.e var2_2) {
                                    block8: {
                                        block9: {
                                            block10: {
                                                block7: {
                                                    block5: {
                                                        block6: {
                                                            if (!(var2_2 instanceof a)) ** GOTO lbl-1000
                                                            var4_3 = var2_2;
                                                            var3_4 = var4_3.k;
                                                            if ((var3_4 & -2147483648) != 0) {
                                                                var4_3.k = var3_4 + -2147483648;
                                                                var2_2 = var4_3;
                                                            } else lbl-1000:
                                                            // 2 sources

                                                            {
                                                                var2_2 = new d(this, (L2.e)var2_2){
                                                                    Object j;
                                                                    int k;
                                                                    final a l;
                                                                    {
                                                                        this.l = a2;
                                                                        super(e2);
                                                                    }

                                                                    @Override
                                                                    public final Object o(Object object) {
                                                                        this.j = object;
                                                                        this.k |= Integer.MIN_VALUE;
                                                                        return this.l.f(null, this);
                                                                    }
                                                                };
                                                            }
                                                            var5_5 = var2_2.j;
                                                            var4_3 = M2.b.e();
                                                            var3_4 = var2_2.k;
                                                            if (var3_4 == 0) break block5;
                                                            if (var3_4 != 1) break block6;
                                                            H2.l.b(var5_5);
                                                            break block7;
                                                        }
                                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                    }
                                                    H2.l.b(var5_5);
                                                    var5_5 = this.g;
                                                    var1_1 = (L.m)var1_1;
                                                    if (var1_1 instanceof L.i) break block8;
                                                    if (var1_1 instanceof g) break block9;
                                                    if (var1_1 instanceof L.b) {
                                                        var1_1 = ((L.b)var1_1).b();
                                                        var2_2.k = 1;
                                                        if (var5_5.f(var1_1, (L2.e)var2_2) == var4_3) {
                                                            return var4_3;
                                                        } else {
                                                            ** GOTO lbl30
                                                        }
                                                    }
                                                    break block10;
                                                }
                                                return H2.q.a;
                                            }
                                            if (var1_1 instanceof L.n) {
                                                throw new IllegalStateException("This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542");
                                            }
                                            throw new H2.i();
                                        }
                                        throw ((g)var1_1).a();
                                    }
                                    throw ((L.i)var1_1).a();
                                }
                            }, e2)) == M2.b.e()) {
                                return object;
                            }
                            return H2.q.a;
                        }
                    };
                    this.k = 1;
                    if (f3.d.b((f3.c)object, (f3.b)object3, (L2.e)this) != object2) return H2.q.a;
                    return object2;
                }
            }

            public final Object r(f3.c c2, L2.e e2) {
                return (this.i(c2, e2)).o(H2.q.a);
            }
        });
        this.f = ".tmp";
        this.g = H2.f.a(new U2.a(this){
            final l h;
            {
                this.h = l2;
                super(0);
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public final File b() {
                Object object;
                Object object2 = (File)this.h.a.a();
                String string = object2.getAbsolutePath();
                a a2 = k;
                Object object3 = object = a2.b();
                synchronized (object3) {
                    Throwable throwable2;
                    block4: {
                        try {
                            if (!a2.a().contains((Object)string)) {
                                a2 = a2.a();
                                V2.k.d((Object)string, (String)"it");
                                a2.add(string);
                                return object2;
                            }
                        }
                        catch (Throwable throwable2) {
                            break block4;
                        }
                        string = new StringBuilder();
                        string.append("There are multiple DataStores active for the same file: ");
                        string.append(object2);
                        string.append(". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).");
                        object2 = string.toString();
                        string = new IllegalStateException(object2.toString());
                        throw string;
                    }
                    throw throwable2;
                }
            }
        });
        this.h = f3.m.a((Object)L.n.a);
        this.i = I2.o.K((Iterable)list);
        this.j = new L.k(i2, new U2.l(this){
            final l h;
            {
                this.h = l2;
                super(1);
            }

            public final void b(Throwable object) {
                if (object != null) {
                    this.h.h.setValue((Object)new g((Throwable)object));
                }
                Object object2 = k;
                object = ((a)object2).b();
                l l2 = this.h;
                Object object3 = object;
                synchronized (object3) {
                    ((a)object2).a().remove((Object)l2.q().getAbsolutePath());
                    object2 = H2.q.a;
                    return;
                }
            }
        }, L.l$e.h, new U2.p(this, null){
            int k;
            Object l;
            final l m;
            {
                this.m = l2;
                super(2, e2);
            }

            @Override
            public final L2.e i(Object object, L2.e e2) {
                e2 = new /* invalid duplicate definition of identical inner class */;
                e2.l = object;
                return e2;
            }

            @Override
            public final Object o(Object object) {
                block5: {
                    Object object2;
                    block7: {
                        b b2;
                        block6: {
                            block4: {
                                object2 = M2.b.e();
                                int n2 = this.k;
                                if (n2 == 0) break block4;
                                if (n2 != 1 && n2 != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                H2.l.b(object);
                                break block5;
                            }
                            H2.l.b(object);
                            b2 = (b)this.l;
                            if (!(b2 instanceof b.a)) break block6;
                            object = this.m;
                            b2 = (b.a)b2;
                            this.k = 1;
                            if (((l)object).r((b.a)b2, this) != object2) break block5;
                            break block7;
                        }
                        if (!(b2 instanceof b.b)) break block5;
                        object = this.m;
                        b2 = (b.b)b2;
                        this.k = 2;
                        if (((l)object).s((b.b)b2, this) != object2) break block5;
                    }
                    return object2;
                }
                return H2.q.a;
            }

            public final Object r(b b2, L2.e e2) {
                return (this.i(b2, e2)).o(H2.q.a);
            }
        });
    }

    private final void p(File file) {
        block3: {
            block2: {
                File file2 = file.getCanonicalFile().getParentFile();
                if (file2 == null) break block2;
                file2.mkdirs();
                if (!file2.isDirectory()) break block3;
            }
            return;
        }
        throw new IOException(V2.k.j((String)"Unable to create parent directories of ", (Object)file));
    }

    private final File q() {
        return (File)this.g.getValue();
    }

    private final Object r(b.a object, L2.e e2) {
        block10: {
            block8: {
                L.m m2;
                block9: {
                    m2 = (L.m)this.h.getValue();
                    if (m2 instanceof L.b) break block8;
                    if (!(m2 instanceof L.i)) break block9;
                    if (m2 == ((b.a)object).a()) {
                        object = this.v(e2);
                        if (object == M2.b.e()) {
                            return object;
                        }
                        return H2.q.a;
                    }
                    break block8;
                }
                if (V2.k.a((Object)m2, (Object)L.n.a)) {
                    object = this.v(e2);
                    if (object == M2.b.e()) {
                        return object;
                    }
                    return H2.q.a;
                }
                if (m2 instanceof g) break block10;
            }
            return H2.q.a;
        }
        throw new IllegalStateException("Can't read in final state.");
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Object s(b.b var1_1, L2.e var2_2) {
        block20: {
            block17: {
                block19: {
                    block16: {
                        block18: {
                            block21: {
                                block22: {
                                    block24: {
                                        block23: {
                                            if (!(var2_2 instanceof i)) ** GOTO lbl-1000
                                            var6_5 = var2_2;
                                            var3_6 = var6_5.o;
                                            if ((var3_6 & -2147483648) != 0) {
                                                var6_5.o = var3_6 + -2147483648;
                                            } else lbl-1000:
                                            // 2 sources

                                            {
                                                var6_5 = new d(this, (L2.e)var2_2){
                                                    Object j;
                                                    Object k;
                                                    Object l;
                                                    Object m;
                                                    final l n;
                                                    int o;
                                                    {
                                                        this.n = l2;
                                                        super(e2);
                                                    }

                                                    @Override
                                                    public final Object o(Object object) {
                                                        this.m = object;
                                                        this.o |= Integer.MIN_VALUE;
                                                        return this.n.s(null, this);
                                                    }
                                                };
                                            }
                                            var5_7 = var6_5.m;
                                            var9_8 = M2.b.e();
                                            var3_6 = var6_5.o;
                                            var4_9 = true;
                                            if (var3_6 == 0) break block21;
                                            if (var3_6 == 1) break block22;
                                            if (var3_6 == 2) break block23;
                                            if (var3_6 != 3) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            var2_2 = (c3.s)var6_5.j;
                                            break block24;
                                        }
                                        var2_2 = (c3.s)var6_5.l;
                                        var8_10 = (l)var6_5.k;
                                        var7_11 = (b.b)var6_5.j;
                                        var1_1 = var2_2;
                                        H2.l.b(var5_7);
                                        var1_1 = var8_10;
                                        ** GOTO lbl88
                                    }
lbl28:
                                    // 2 sources

                                    while (true) {
                                        var1_1 = var2_2;
                                        try {
                                            H2.l.b(var5_7);
                                            break block16;
                                        }
                                        catch (Throwable var2_3) {
                                            break block17;
                                        }
                                        break;
                                    }
                                }
                                var2_2 = (c3.s)var6_5.j;
                                ** while (true)
                            }
                            H2.l.b(var5_7);
                            var5_7 = var2_2 = var1_1.a();
                            try {
                                var7_11 = H2.k.g;
                                var5_7 = var2_2;
                                var7_11 = (L.m)this.h.getValue();
                                var5_7 = var2_2;
                                if (!(var7_11 instanceof L.b)) break block18;
                                var5_7 = var2_2;
                                var7_11 = var1_1.d();
                                var5_7 = var2_2;
                                var1_1 = var1_1.b();
                                var5_7 = var2_2;
                                var6_5.j = var2_2;
                                var5_7 = var2_2;
                                var6_5.o = 1;
                                var5_7 = var2_2;
                                var1_1 = var6_5 = this.y((U2.p)var7_11, (L2.i)var1_1, (L2.e)var6_5);
                                if (var6_5 == var9_8) {
                                    return var9_8;
                                }
                            }
                            catch (Throwable var2_4) {
                                var1_1 = var5_7;
                                break block17;
                            }
                            while (true) {
                                var5_7 = var1_1;
                                break block16;
                                break;
                            }
                        }
                        var5_7 = var2_2;
                        {
                            if (!(var7_11 instanceof L.i)) {
                                var5_7 = var2_2;
                                var4_9 = var7_11 instanceof L.n;
                            }
                            if (!var4_9) ** GOTO lbl113
                            var5_7 = var2_2;
                            if (var7_11 != var1_1.c()) break block19;
                            var5_7 = var2_2;
                            var6_5.j = var1_1;
                            var5_7 = var2_2;
                            var6_5.k = this;
                            var5_7 = var2_2;
                            var6_5.l = var2_2;
                            var5_7 = var2_2;
                            var6_5.o = 2;
                            var5_7 = var2_2;
                            if (this.u((L2.e)var6_5) == var9_8) {
                                return var9_8;
                            }
                            var5_7 = this;
                            var7_11 = var1_1;
                            var1_1 = var5_7;
lbl88:
                            // 2 sources

                            var5_7 = var2_2;
                            var8_10 = var7_11.d();
                            var5_7 = var2_2;
                            var7_11 = var7_11.b();
                            var5_7 = var2_2;
                            var6_5.j = var2_2;
                            var5_7 = var2_2;
                            var6_5.k = null;
                            var5_7 = var2_2;
                            var6_5.l = null;
                            var5_7 = var2_2;
                            var6_5.o = 3;
                            var5_7 = var2_2;
                            var1_1 = var6_5 = super.y((U2.p)var8_10, (L2.i)var7_11, (L2.e)var6_5);
                            if (var6_5 != var9_8) ** continue;
                        }
                        return var9_8;
                    }
                    var1_1 = var2_2;
                    {
                        var5_7 = H2.k.a(var5_7);
                        var1_1 = var2_2;
                        var2_2 = var5_7;
                        break block20;
                    }
                }
                var5_7 = var2_2;
                {
                    throw ((L.i)var7_11).a();
lbl113:
                    // 1 sources

                    var5_7 = var2_2;
                    if (var7_11 instanceof g) {
                        var5_7 = var2_2;
                        throw ((g)var7_11).a();
                    }
                    var5_7 = var2_2;
                    var5_7 = var2_2;
                    var1_1 = new H2.i();
                    var5_7 = var2_2;
                    throw var1_1;
                }
            }
            var5_7 = H2.k.g;
            var2_2 = H2.k.a(H2.l.a((Throwable)var2_2));
        }
        u.c((c3.s)var1_1, (Object)var2_2);
        return H2.q.a;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final Object t(L2.e var1_1) {
        block19: {
            block16: {
                block11: {
                    block20: {
                        block17: {
                            block18: {
                                block12: {
                                    block13: {
                                        block14: {
                                            block15: {
                                                if (!(var1_1 instanceof j)) ** GOTO lbl-1000
                                                var7_2 = var1_1;
                                                var2_3 = var7_2.r;
                                                if ((var2_3 & -2147483648) != 0) {
                                                    var7_2.r = var2_3 + -2147483648;
                                                } else lbl-1000:
                                                // 2 sources

                                                {
                                                    var7_2 = new d(this, (L2.e)var1_1){
                                                        Object j;
                                                        Object k;
                                                        Object l;
                                                        Object m;
                                                        Object n;
                                                        Object o;
                                                        Object p;
                                                        final l q;
                                                        int r;
                                                        {
                                                            this.q = l2;
                                                            super(e2);
                                                        }

                                                        @Override
                                                        public final Object o(Object object) {
                                                            this.p = object;
                                                            this.r |= Integer.MIN_VALUE;
                                                            return this.q.t(this);
                                                        }
                                                    };
                                                }
                                                var6_4 = var7_2.p;
                                                var11_5 = M2.b.e();
                                                var2_3 = var7_2.r;
                                                var3_6 = 0;
                                                if (var2_3 == 0) break block12;
                                                if (var2_3 == 1) break block13;
                                                if (var2_3 == 2) break block14;
                                                if (var2_3 != 3) break block15;
                                                var1_1 = (l3.a)var7_2.m;
                                                var8_7 = (q)var7_2.l;
                                                var4_9 /* !! */  = (s)var7_2.k;
                                                var5_11 = (l)var7_2.j;
                                                H2.l.b(var6_4);
                                                var6_4 = var8_7;
                                                break block16;
                                            }
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        var8_8 /* !! */  = (Iterator)var7_2.o;
                                        var9_12 = var7_2.n;
                                        var10_13 = (q)var7_2.m;
                                        var5_11 = (s)var7_2.l;
                                        var4_9 /* !! */  = (l3.a)var7_2.k;
                                        var1_1 = (l)var7_2.j;
                                        H2.l.b(var6_4);
                                        var6_4 = var10_13;
                                        break block17;
                                    }
                                    var8_8 /* !! */  = (s)var7_2.m;
                                    var4_9 /* !! */  = (s)var7_2.l;
                                    var1_1 = (l3.a)var7_2.k;
                                    var5_11 = (l)var7_2.j;
                                    H2.l.b(var6_4);
                                    break block18;
                                }
                                H2.l.b(var6_4);
                                var2_3 = !V2.k.a((Object)this.h.getValue(), (Object)L.n.a) && !(this.h.getValue() instanceof L.i) ? 0 : 1;
                                if (var2_3 == 0) break block19;
                                var1_1 = l3.g.b((boolean)false, (int)1, null);
                                var8_8 /* !! */  = new s();
                                var7_2.j = this;
                                var7_2.k = var1_1;
                                var7_2.l = var8_8 /* !! */ ;
                                var7_2.m = var8_8 /* !! */ ;
                                var7_2.r = 1;
                                var6_4 = this.x(var7_2);
                                if (var6_4 == var11_5) break block11;
                                var5_11 = this;
                                var4_9 /* !! */  = var8_8 /* !! */ ;
                            }
                            var8_8 /* !! */ .g = var6_4;
                            var6_4 = new q();
                            var9_12 = new h((l3.a)var1_1, (q)var6_4, var4_9 /* !! */ , var5_11){
                                final l3.a a;
                                final q b;
                                final s c;
                                final l d;
                                {
                                    this.a = a2;
                                    this.b = q2;
                                    this.c = s2;
                                    this.d = l2;
                                }

                                /*
                                 * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
                                 * Unable to fully structure code
                                 * Enabled aggressive block sorting
                                 * Enabled unnecessary exception pruning
                                 * Enabled aggressive exception aggregation
                                 */
                                @Override
                                public Object a(U2.p var1_1, L2.e var2_2) {
                                    block16: {
                                        block19: {
                                            block18: {
                                                block22: {
                                                    block20: {
                                                        block21: {
                                                            block17: {
                                                                if (!(var2_2 instanceof a)) ** GOTO lbl-1000
                                                                var6_5 = var2_2;
                                                                var3_6 = var6_5.q;
                                                                if ((var3_6 & -2147483648) != 0) {
                                                                    var6_5.q = var3_6 + -2147483648;
                                                                } else lbl-1000:
                                                                // 2 sources

                                                                {
                                                                    var6_5 = new d(this, (L2.e)var2_2){
                                                                        Object j;
                                                                        Object k;
                                                                        Object l;
                                                                        Object m;
                                                                        Object n;
                                                                        Object o;
                                                                        final k p;
                                                                        int q;
                                                                        {
                                                                            this.p = k2;
                                                                            super(e2);
                                                                        }

                                                                        @Override
                                                                        public final Object o(Object object) {
                                                                            this.o = object;
                                                                            this.q |= Integer.MIN_VALUE;
                                                                            return this.p.a(null, this);
                                                                        }
                                                                    };
                                                                }
                                                                var5_7 = var6_5.o;
                                                                var9_8 = M2.b.e();
                                                                var3_6 = var6_5.q;
                                                                if (var3_6 == 0) break block20;
                                                                if (var3_6 == 1) break block21;
                                                                if (var3_6 != 2) {
                                                                    if (var3_6 != 3) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                    var7_9 = var6_5.l;
                                                                    var4_11 /* !! */  = (s)var6_5.k;
                                                                    var1_1 = var2_2 = (l3.a)var6_5.j;
                                                                    try {
                                                                        H2.l.b(var5_7);
                                                                        var5_7 = var7_9;
                                                                        break block16;
                                                                    }
                                                                    catch (Throwable var2_3) {
                                                                        break block17;
                                                                    }
                                                                }
                                                                var7_10 = (l)var6_5.l;
                                                                var2_2 = (s)var6_5.k;
                                                                var1_1 = (l3.a)var6_5.j;
                                                                var4_11 /* !! */  = var1_1;
                                                                try {
                                                                    H2.l.b(var5_7);
                                                                    break block18;
                                                                }
                                                                catch (Throwable var2_4) {
                                                                    var1_1 = var4_11 /* !! */ ;
                                                                    ** GOTO lbl32
                                                                }
                                                            }
lbl32:
                                                            // 3 sources

                                                            while (true) {
                                                                var1_1.a(null);
                                                                throw var2_2;
                                                            }
                                                        }
                                                        var1_1 = (l)var6_5.n;
                                                        var4_11 /* !! */  = (s)var6_5.m;
                                                        var7_10 = (q)var6_5.l;
                                                        var2_2 = (l3.a)var6_5.k;
                                                        var8_13 = (U2.p)var6_5.j;
                                                        H2.l.b(var5_7);
                                                        var5_7 = var8_13;
                                                        break block22;
                                                    }
                                                    H2.l.b(var5_7);
                                                    var2_2 = this.a;
                                                    var7_10 = this.b;
                                                    var4_11 /* !! */  = this.c;
                                                    var8_14 = this.d;
                                                    var6_5.j = var1_1;
                                                    var6_5.k = var2_2;
                                                    var6_5.l = var7_10;
                                                    var6_5.m = var4_11 /* !! */ ;
                                                    var6_5.n = var8_14;
                                                    var6_5.q = 1;
                                                    if (var2_2.b(null, (L2.e)var6_5) == var9_8) {
                                                        return var9_8;
                                                    }
                                                    var5_7 = var1_1;
                                                    var1_1 = var8_14;
                                                }
                                                try {
                                                    if (!var7_10.g) {
                                                        var7_10 = var4_11 /* !! */ .g;
                                                        var6_5.j = var2_2;
                                                        var6_5.k = var4_11 /* !! */ ;
                                                        var6_5.l = var1_1;
                                                        var6_5.m = null;
                                                        var6_5.n = null;
                                                        var6_5.q = 2;
                                                        if ((var5_7 = var5_7.h(var7_10, var6_5)) == var9_8) {
                                                            return var9_8;
                                                        }
                                                        var7_10 = var1_1;
                                                        var1_1 = var2_2;
                                                        var2_2 = var4_11 /* !! */ ;
                                                    }
                                                    ** GOTO lbl-1000
                                                }
                                                catch (Throwable var4_12) {
                                                    var1_1 = var2_2;
                                                    var2_2 = var4_12;
                                                    ** continue;
                                                }
                                            }
                                            var4_11 /* !! */  = var1_1;
                                            {
                                                if (V2.k.a((Object)var5_7, (Object)var2_2.g)) ** GOTO lbl105
                                                var4_11 /* !! */  = var1_1;
                                                var6_5.j = var1_1;
                                                var4_11 /* !! */  = var1_1;
                                                var6_5.k = var2_2;
                                                var4_11 /* !! */  = var1_1;
                                                var6_5.l = var5_7;
                                                var4_11 /* !! */  = var1_1;
                                                var6_5.q = 3;
                                                var4_11 /* !! */  = var1_1;
                                                if ((var6_5 = var7_10.z(var5_7, (L2.e)var6_5)) != var9_8) break block19;
                                            }
                                            return var9_8;
                                        }
                                        var4_11 /* !! */  = var2_2;
                                        var2_2 = var1_1;
                                    }
                                    var1_1 = var2_2;
                                    {
                                        block23: {
                                            var4_11 /* !! */ .g = var5_7;
                                            break block23;
lbl105:
                                            // 1 sources

                                            var4_11 /* !! */  = var2_2;
                                            var2_2 = var1_1;
                                        }
                                        var1_1 = var2_2;
                                        var4_11 /* !! */  = var4_11 /* !! */ .g;
                                    }
                                    var2_2.a(null);
                                    return var4_11 /* !! */ ;
lbl-1000:
                                    // 1 sources

                                    {
                                        var1_1 = new IllegalStateException("InitializerApi.updateData should not be called after initialization is complete.");
                                        throw var1_1;
                                    }
                                }
                            };
                            var8_8 /* !! */  = var5_11.i;
                            if (var8_8 /* !! */  == null) break block20;
                            var8_8 /* !! */  = var8_8 /* !! */ .iterator();
                            var10_13 = var5_11;
                            var5_11 = var4_9 /* !! */ ;
                            var4_9 /* !! */  = var1_1;
                            var1_1 = var10_13;
                        }
                        while (var8_8 /* !! */ .hasNext()) {
                            var10_13 = (U2.p)var8_8 /* !! */ .next();
                            var7_2.j = var1_1;
                            var7_2.k = var4_9 /* !! */ ;
                            var7_2.l = var5_11;
                            var7_2.m = var6_4;
                            var7_2.n = var9_12;
                            var7_2.o = var8_8 /* !! */ ;
                            var7_2.r = 2;
                            if (var10_13.h(var9_12, var7_2) != var11_5) continue;
                            break block11;
                        }
                        var8_8 /* !! */  = var1_1;
                        var1_1 = var4_9 /* !! */ ;
                        var4_9 /* !! */  = var5_11;
                        var5_11 = var8_8 /* !! */ ;
                    }
                    var5_11.i = null;
                    var7_2.j = var5_11;
                    var7_2.k = var4_9 /* !! */ ;
                    var7_2.l = var6_4;
                    var7_2.m = var1_1;
                    var7_2.n = null;
                    var7_2.o = null;
                    var7_2.r = 3;
                    if (var1_1.b(null, (L2.e)var7_2) != var11_5) break block16;
                }
                return var11_5;
            }
            var6_4.g = true;
            var6_4 = H2.q.a;
            var1_1 = var5_11.h;
            var4_9 /* !! */  = var4_9 /* !! */ .g;
            var2_3 = var3_6;
            if (var4_9 /* !! */  != null) {
                var2_3 = var4_9 /* !! */ .hashCode();
            }
            var1_1.setValue((Object)new L.b(var4_9 /* !! */ , var2_3));
            return H2.q.a;
            finally {
                var1_1.a(null);
            }
        }
        throw new IllegalStateException("Check failed.");
    }

    /*
     * Unable to fully structure code
     */
    private final Object u(L2.e var1_1) {
        block9: {
            block8: {
                if (!(var1_1 instanceof l)) ** GOTO lbl-1000
                var3_2 = var1_1;
                var2_6 = var3_2.m;
                if ((var2_6 & -2147483648) != 0) {
                    var3_2.m = var2_6 + -2147483648;
                    var1_1 = var3_2;
                } else lbl-1000:
                // 2 sources

                {
                    var1_1 = new d(this, (L2.e)var1_1){
                        Object j;
                        Object k;
                        final l l;
                        int m;
                        {
                            this.l = l2;
                            super(e2);
                        }

                        @Override
                        public final Object o(Object object) {
                            this.k = object;
                            this.m |= Integer.MIN_VALUE;
                            return this.l.u(this);
                        }
                    };
                }
                var4_7 = var1_1.k;
                var3_2 = M2.b.e();
                var2_6 = var1_1.m;
                if (var2_6 != 0) {
                    if (var2_6 == 1) {
                        var1_1 = (l)var1_1.j;
                        try {
                            H2.l.b(var4_7);
                            break block8;
                        }
                        catch (Throwable var3_3) {
                            break block9;
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                H2.l.b(var4_7);
                try {
                    var1_1.j = this;
                    var1_1.m = 1;
                    var1_1 = this.t((L2.e)var1_1);
                    if (var1_1 != var3_2) break block8;
                    return var3_2;
                }
                catch (Throwable var3_4) {
                    var1_1 = this;
                }
            }
            return H2.q.a;
        }
        var1_1.h.setValue((Object)new L.i((Throwable)var3_5));
        throw var3_5;
    }

    /*
     * Unable to fully structure code
     */
    private final Object v(L2.e var1_1) {
        block9: {
            block10: {
                if (!(var1_1 instanceof m)) ** GOTO lbl-1000
                var3_3 = var1_1;
                var2_5 = var3_3.m;
                if ((var2_5 & -2147483648) != 0) {
                    var3_3.m = var2_5 + -2147483648;
                    var1_1 = var3_3;
                } else lbl-1000:
                // 2 sources

                {
                    var1_1 = new d(this, (L2.e)var1_1){
                        Object j;
                        Object k;
                        final l l;
                        int m;
                        {
                            this.l = l2;
                            super(e2);
                        }

                        @Override
                        public final Object o(Object object) {
                            this.k = object;
                            this.m |= Integer.MIN_VALUE;
                            return this.l.v(this);
                        }
                    };
                }
                var5_6 = var1_1.k;
                var3_3 = M2.b.e();
                var2_5 = var1_1.m;
                if (var2_5 != 0) {
                    if (var2_5 == 1) {
                        var4_7 = (l)var1_1.j;
                        try {
                            H2.l.b(var5_6);
                            break block9;
                        }
                        catch (Throwable var1_2) {
                            var3_3 = var1_2;
                            break block10;
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                H2.l.b(var5_6);
                try {
                    var1_1.j = this;
                    var1_1.m = 1;
                    var1_1 = this.t((L2.e)var1_1);
                    if (var1_1 == var3_3) {
                        return var3_3;
                    }
                    break block9;
                }
                catch (Throwable var3_4) {
                    var4_7 = var1_1 = this;
                }
            }
            var4_7.h.setValue((Object)new L.i((Throwable)var3_3));
        }
        return H2.q.a;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Object w(L2.e var1_1) {
        block17: {
            block16: {
                block18: {
                    if (!(var1_1 instanceof n)) ** GOTO lbl-1000
                    var3_2 = var1_1;
                    var2_6 = var3_2.o;
                    if ((var2_6 & -2147483648) != 0) {
                        var3_2.o = var2_6 + -2147483648;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var3_2 = new d(this, (L2.e)var1_1){
                            Object j;
                            Object k;
                            Object l;
                            Object m;
                            final l n;
                            int o;
                            {
                                this.n = l2;
                                super(e2);
                            }

                            @Override
                            public final Object o(Object object) {
                                this.m = object;
                                this.o |= Integer.MIN_VALUE;
                                return this.n.w(this);
                            }
                        };
                    }
                    var6_7 = var3_2.m;
                    var4_9 = M2.b.e();
                    var2_6 = var3_2.o;
                    if (var2_6 == 0) break block18;
                    if (var2_6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    var5_10 = (Throwable)var3_2.l;
                    var4_9 = (Closeable)var3_2.k;
                    var1_1 = (l)var3_2.j;
                    try {
                        H2.l.b(var6_7);
                        var3_2 = var6_7;
                        ** GOTO lbl-1000
                    }
                    catch (Throwable var5_11) {
                        var3_2 = var1_1;
                        break block16;
                    }
                }
                H2.l.b(var6_7);
                try {
                    var1_1 = new FileInputStream(this.q());
                }
                catch (FileNotFoundException var3_4) {
                    var1_1 = this;
                    break block17;
                }
                try {
                    var5_10 = this.b;
                    var3_2.j = this;
                    var3_2.k = var1_1;
                    var3_2.l = null;
                    var3_2.o = 1;
                    var3_2 = var5_10.a((InputStream)var1_1, (L2.e)var3_2);
                    if (var3_2 == var4_9) {
                        return var4_9;
                    }
                    var6_7 = this;
                    var5_10 = null;
                    var4_9 = var1_1;
                    var1_1 = var6_7;
                }
                catch (Throwable var5_12) {
                    var3_2 = this;
                    var4_9 = var1_1;
                    break block16;
                }
lbl-1000:
                // 2 sources

                {
                    S2.a.a((Closeable)var4_9, (Throwable)var5_10);
                    return var3_2;
                }
            }
            try {
                throw var5_13;
            }
            catch (Throwable var6_8) {
                var1_1 = var3_2;
                {
                    S2.a.a((Closeable)var4_9, (Throwable)var5_13);
                    var1_1 = var3_2;
                    throw var6_8;
                }
            }
        }
        if (!super.q().exists()) {
            return var1_1.b.b();
        }
        throw var3_5;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Object x(L2.e var1_1) {
        if (!(var1_1 instanceof o)) ** GOTO lbl-1000
        var3_3 = var1_1;
        var2_4 = var3_3.n;
        if ((var2_4 & -2147483648) != 0) {
            var3_3.n = var2_4 + -2147483648;
            var1_1 = var3_3;
        } else lbl-1000:
        // 2 sources

        {
            var1_1 = new d(this, (L2.e)var1_1){
                Object j;
                Object k;
                Object l;
                final l m;
                int n;
                {
                    this.m = l2;
                    super(e2);
                }

                @Override
                public final Object o(Object object) {
                    this.l = object;
                    this.n |= Integer.MIN_VALUE;
                    return this.m.x(this);
                }
            };
        }
        var3_3 = var1_1.l;
        var4_5 = M2.b.e();
        var2_4 = var1_1.n;
        if (var2_4 == 0) {
            H2.l.b(var3_3);
            var1_1.j = this;
            var1_1.n = 1;
            var1_1 = this.w((L2.e)var1_1);
            if (var1_1 != var4_5) return var1_1;
            return var4_5;
        }
        if (var2_4 == 1) {
            var1_1 = (l)var1_1.j;
            H2.l.b(var3_3);
            return var3_3;
        }
        if (var2_4 != 2) {
            if (var2_4 != 3) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            var4_5 = var1_1.k;
            E.a((Object)var1_1.j);
            try {
                H2.l.b(var3_3);
                return var4_5;
            }
            catch (IOException var1_2) {}
        } else {
            E.a((Object)var1_1.k);
            var5_6 = (l)var1_1.j;
            H2.l.b(var3_3);
            {
                var1_1.j = null;
                var1_1.k = var3_3;
                var1_1.n = 3;
                var1_1 = var5_6.z(var3_3, (L2.e)var1_1);
                if (var1_1 != var4_5) return var3_3;
                return var4_5;
            }
        }
        H2.a.a(null, var1_2);
        throw null;
    }

    /*
     * Unable to fully structure code
     */
    private final Object y(U2.p var1_1, L2.i var2_2, L2.e var3_3) {
        block9: {
            block11: {
                block10: {
                    block6: {
                        block7: {
                            block8: {
                                if (!(var3_3 instanceof p)) ** GOTO lbl-1000
                                var5_4 = var3_3;
                                var4_5 = var5_4.o;
                                if ((var4_5 & -2147483648) != 0) {
                                    var5_4.o = var4_5 + -2147483648;
                                    var3_3 = var5_4;
                                } else lbl-1000:
                                // 2 sources

                                {
                                    var3_3 = new d(this, var3_3){
                                        Object j;
                                        Object k;
                                        Object l;
                                        Object m;
                                        final l n;
                                        int o;
                                        {
                                            this.n = l2;
                                            super(e2);
                                        }

                                        @Override
                                        public final Object o(Object object) {
                                            this.m = object;
                                            this.o |= Integer.MIN_VALUE;
                                            return this.n.y(null, null, this);
                                        }
                                    };
                                }
                                var7_6 = var3_3.m;
                                var8_7 = M2.b.e();
                                var4_5 = var3_3.o;
                                if (var4_5 == 0) break block6;
                                if (var4_5 == 1) break block7;
                                if (var4_5 != 2) break block8;
                                var2_2 = var3_3.k;
                                var1_1 = (l)var3_3.j;
                                H2.l.b(var7_6);
                                break block9;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        var5_4 = var3_3.l;
                        var6_8 = (L.b)var3_3.k;
                        var1_1 = (l)var3_3.j;
                        H2.l.b(var7_6);
                        var2_2 = var7_6;
                        break block10;
                    }
                    H2.l.b(var7_6);
                    var5_4 = (L.b)this.h.getValue();
                    var5_4.a();
                    var7_6 = var5_4.b();
                    var1_1 = new U2.p((U2.p)var1_1, var7_6, null){
                        int k;
                        final U2.p l;
                        final Object m;
                        {
                            this.l = p2;
                            this.m = object;
                            super(2, e2);
                        }

                        @Override
                        public final L2.e i(Object object, L2.e e2) {
                            return new /* invalid duplicate definition of identical inner class */;
                        }

                        @Override
                        public final Object o(Object object) {
                            Object object2 = M2.b.e();
                            int n2 = this.k;
                            if (n2 != 0) {
                                if (n2 == 1) {
                                    H2.l.b(object);
                                    return object;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            H2.l.b(object);
                            U2.p p2 = this.l;
                            object = this.m;
                            this.k = 1;
                            object = p2.h(object, this);
                            if (object == object2) {
                                return object2;
                            }
                            return object;
                        }

                        public final Object r(I i2, L2.e e2) {
                            return (this.i(i2, e2)).o(H2.q.a);
                        }
                    };
                    var3_3.j = this;
                    var3_3.k = var5_4;
                    var3_3.l = var7_6;
                    var3_3.o = 1;
                    var2_2 = c3.f.e((L2.i)var2_2, (U2.p)var1_1, (L2.e)var3_3);
                    if (var2_2 == var8_7) break block11;
                    var1_1 = this;
                    var6_8 = var5_4;
                    var5_4 = var7_6;
                }
                var6_8.a();
                if (V2.k.a((Object)var5_4, (Object)var2_2)) {
                    return var5_4;
                }
                var3_3.j = var1_1;
                var3_3.k = var2_2;
                var3_3.l = null;
                var3_3.o = 2;
                if (var1_1.z(var2_2, var3_3) != var8_7) break block9;
            }
            return var8_7;
        }
        var1_1 = var1_1.h;
        var4_5 = var2_2 != null ? var2_2.hashCode() : 0;
        var1_1.setValue((Object)new L.b(var2_2, var4_5));
        return var2_2;
    }

    @Override
    public Object a(U2.p object, L2.e e2) {
        c3.s s2 = u.b(null, (int)1, null);
        object = new b.b((U2.p)object, s2, (L.m)this.h.getValue(), e2.getContext());
        this.j.e(object);
        return s2.k0(e2);
    }

    @Override
    public f3.b getData() {
        return this.e;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object z(Object var1_1, L2.e var2_5) {
        block21: {
            block20: {
                block19: {
                    if (!(var2_5 instanceof r)) ** GOTO lbl-1000
                    var6_6 /* !! */  = var2_5;
                    var3_8 = var6_6 /* !! */ .q;
                    if ((var3_8 & -2147483648) != 0) {
                        var6_6 /* !! */ .q = var3_8 + -2147483648;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var6_6 /* !! */  = new d(this, (L2.e)var2_5){
                            Object j;
                            Object k;
                            Object l;
                            Object m;
                            Object n;
                            Object o;
                            final l p;
                            int q;
                            {
                                this.p = l2;
                                super(e2);
                            }

                            @Override
                            public final Object o(Object object) {
                                this.o = object;
                                this.q |= Integer.MIN_VALUE;
                                return this.p.z(null, this);
                            }
                        };
                    }
                    var11_9 = var6_6 /* !! */ .o;
                    var7_10 = M2.b.e();
                    var3_8 = var6_6 /* !! */ .q;
                    if (var3_8 != 0) {
                        if (var3_8 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        var10_13 = (FileOutputStream)var6_6 /* !! */ .n;
                        var8_14 /* !! */  = (Throwable)var6_6 /* !! */ .m;
                        var9_15 = (Closeable)var6_6 /* !! */ .l;
                        var1_1 = (File)var6_6 /* !! */ .k;
                        var7_10 = (l)var6_6 /* !! */ .j;
                        var5_16 /* !! */  = var9_15;
                        var2_5 = var1_1;
                        try {
                            H2.l.b(var11_9);
                            var6_6 /* !! */  = var9_15;
                            var9_15 = var10_13;
                            break block19;
                        }
                        catch (Throwable var7_11) {
                            var6_6 /* !! */  = var5_16 /* !! */ ;
                            var1_1 = var2_5;
                            var5_16 /* !! */  = var7_11;
                            break block20;
                        }
                    }
                    H2.l.b(var11_9);
                    this.p(this.q());
                    var5_16 /* !! */  = new File(V2.k.j((String)this.q().getAbsolutePath(), (Object)this.f));
                    try {
                        var2_5 = new FileOutputStream(var5_16 /* !! */ );
                    }
                    catch (IOException var1_3) {
                        var2_5 = var5_16 /* !! */ ;
                        break block21;
                    }
                    try {
                        var9_15 = this.b;
                        var8_14 /* !! */  = new c((FileOutputStream)var2_5);
                        var6_6 /* !! */ .j = this;
                        var6_6 /* !! */ .k = var5_16 /* !! */ ;
                        var6_6 /* !! */ .l = var2_5;
                        var6_6 /* !! */ .m = null;
                        var6_6 /* !! */ .n = var2_5;
                        var6_6 /* !! */ .q = 1;
                        var1_1 = var9_15.c(var1_1, (OutputStream)var8_14 /* !! */ , (L2.e)var6_6 /* !! */ );
                        if (var1_1 == var7_10) {
                            return var7_10;
                        }
                        var7_10 = this;
                        var1_1 = var5_16 /* !! */ ;
                        var9_15 = var2_5;
                        var8_14 /* !! */  = null;
                        var6_6 /* !! */  = var2_5;
                    }
                    catch (Throwable var6_7) {
                        var1_1 = var5_16 /* !! */ ;
                        var5_16 /* !! */  = var6_7;
                        var6_6 /* !! */  = var2_5;
                        break block20;
                    }
                }
                var5_16 /* !! */  = var6_6 /* !! */ ;
                var2_5 = var1_1;
                {
                    var9_15.getFD().sync();
                    var5_16 /* !! */  = var6_6 /* !! */ ;
                    var2_5 = var1_1;
                    var9_15 = H2.q.a;
                    var2_5 = var1_1;
                }
                {
                    S2.a.a((Closeable)var6_6 /* !! */ , var8_14 /* !! */ );
                    var2_5 = var1_1;
                    var4_17 = var1_1.renameTo(super.q());
                    if (var4_17) {
                        return H2.q.a;
                    }
                    var2_5 = var1_1;
                    var2_5 = var1_1;
                    var2_5 = var1_1;
                    var5_16 /* !! */  = new StringBuilder();
                    var2_5 = var1_1;
                    var5_16 /* !! */ .append("Unable to rename ");
                    var2_5 = var1_1;
                    var5_16 /* !! */ .append(var1_1);
                    var2_5 = var1_1;
                    var5_16 /* !! */ .append(".This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file.");
                    var2_5 = var1_1;
                    var6_6 /* !! */  = new IOException(var5_16 /* !! */ .toString());
                    var2_5 = var1_1;
                    throw var6_6 /* !! */ ;
                }
            }
            try {
                throw var5_16 /* !! */ ;
            }
            catch (Throwable var7_12) {
                var2_5 = var1_1;
                {
                    S2.a.a((Closeable)var6_6 /* !! */ , (Throwable)var5_16 /* !! */ );
                    var2_5 = var1_1;
                    throw var7_12;
                }
            }
        }
        if (var2_5.exists()) {
            var2_5.delete();
        }
        throw var1_4;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(V2.g g2) {
            this();
        }

        public final Set a() {
            return l;
        }

        public final Object b() {
            return m;
        }
    }

    private static abstract class L.l$b {
        private L.l$b() {
        }

        public /* synthetic */ L.l$b(V2.g g2) {
            this();
        }

        public static final class a
        extends L.l$b {
            private final L.m a;

            public a(L.m m2) {
                super(null);
                this.a = m2;
            }

            public L.m a() {
                return this.a;
            }
        }

        public static final class b
        extends L.l$b {
            private final U2.p a;
            private final c3.s b;
            private final L.m c;
            private final L2.i d;

            public b(U2.p p2, c3.s s2, L.m m2, L2.i i2) {
                V2.k.e((Object)p2, (String)"transform");
                V2.k.e((Object)s2, (String)"ack");
                V2.k.e((Object)i2, (String)"callerContext");
                super(null);
                this.a = p2;
                this.b = s2;
                this.c = m2;
                this.d = i2;
            }

            public final c3.s a() {
                return this.b;
            }

            public final L2.i b() {
                return this.d;
            }

            public L.m c() {
                return this.c;
            }

            public final U2.p d() {
                return this.a;
            }
        }
    }

    private static final class c
    extends OutputStream
    implements AutoCloseable {
        private final FileOutputStream g;

        public c(FileOutputStream fileOutputStream) {
            V2.k.e((Object)fileOutputStream, (String)"fileOutputStream");
            this.g = fileOutputStream;
        }

        public void close() {
        }

        public void flush() {
            this.g.flush();
        }

        public void write(int n2) {
            this.g.write(n2);
        }

        public void write(byte[] byArray) {
            V2.k.e((Object)byArray, (String)"b");
            this.g.write(byArray);
        }

        public void write(byte[] byArray, int n2, int n3) {
            V2.k.e((Object)byArray, (String)"bytes");
            this.g.write(byArray, n2, n3);
        }
    }
}

