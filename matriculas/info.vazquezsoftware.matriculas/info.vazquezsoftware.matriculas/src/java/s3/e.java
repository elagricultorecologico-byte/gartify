/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package s3;

import b3.h;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import m3.A;
import m3.l;
import m3.m;
import m3.s;
import m3.t;
import n3.d;
import v3.k;
import z3.b;
import z3.e;

public abstract class e {
    private static final z3.e a;
    private static final z3.e b;

    static {
        e.a a2 = z3.e.j;
        a = a2.c("\"\\");
        b = a2.c("\t ,=");
    }

    public static final List a(s s2, String string) {
        V2.k.e(s2, "<this>");
        V2.k.e(string, "headerName");
        ArrayList arrayList = new ArrayList();
        int n2 = s2.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!h.u(string, s2.f(i2), true)) continue;
            b b2 = new b().U0(s2.i(i2));
            try {
                e.c(b2, (List)arrayList);
                continue;
            }
            catch (EOFException eOFException) {
                k.a.g().j("Unable to parse challenge", 5, eOFException);
            }
        }
        return arrayList;
    }

    public static final boolean b(A a2) {
        V2.k.e(a2, "<this>");
        if (V2.k.a(a2.i0().g(), "HEAD")) {
            return false;
        }
        int n2 = a2.p();
        if ((n2 < 100 || n2 >= 200) && n2 != 204 && n2 != 304) {
            return true;
        }
        return d.v(a2) != -1L || h.u("chunked", A.L(a2, "Transfer-Encoding", null, 2, null), true);
        {
        }
    }

    /*
     * Exception decompiling
     */
    private static final void c(b var0, List var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[UNCONDITIONALDOLOOP]], but top level block is 2[UNCONDITIONALDOLOOP]
         *     at fc.r.Q0(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:193)
         *     at fc.n.E0(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:114)
         *     at dc.f.b(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:523)
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

    private static final String d(b b2) {
        if (b2.G0() == 34) {
            b b3 = new b();
            while (true) {
                long l2;
                if ((l2 = b2.P(a)) == -1L) {
                    return null;
                }
                if (b2.L(l2) == 34) {
                    b3.q(b2, l2);
                    b2.G0();
                    return b3.l0();
                }
                if (b2.A0() == l2 + 1L) {
                    return null;
                }
                b3.q(b2, l2);
                b2.G0();
                b3.q(b2, 1L);
            }
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    private static final String e(b b2) {
        long l2;
        long l3 = l2 = b2.P(b);
        if (l2 == -1L) {
            l3 = b2.A0();
        }
        if (l3 != 0L) {
            return b2.n0(l3);
        }
        return null;
    }

    public static final void f(m m2, t t2, s s2) {
        V2.k.e(m2, "<this>");
        V2.k.e(t2, "url");
        V2.k.e(s2, "headers");
        if (m2 == m.b || (s2 = l.j.e(t2, s2)).isEmpty()) {
            return;
        }
        m2.b(t2, (List)s2);
    }

    private static final boolean g(b b2) {
        boolean bl = false;
        while (!b2.O()) {
            byte by = b2.L(0L);
            if (by == 44) {
                b2.G0();
                bl = true;
                continue;
            }
            if (by != 32 && by != 9) break;
            b2.G0();
        }
        return bl;
    }

    private static final boolean h(b b2, byte by) {
        return !b2.O() && b2.L(0L) == by;
    }
}

