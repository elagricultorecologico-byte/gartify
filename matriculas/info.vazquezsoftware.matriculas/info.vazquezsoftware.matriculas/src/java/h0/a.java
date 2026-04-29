/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  K0.a
 *  K0.b
 *  K0.c
 *  K0.d
 *  K0.e
 *  K0.f
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.annotation.Annotation
 *  m2.c
 *  m2.e
 *  n2.b
 *  p2.a
 */
package H0;

import H0.l;
import java.lang.annotation.Annotation;

public final class a
implements n2.a {
    public static final n2.a a = new a();

    private a() {
    }

    @Override
    public void a(n2.b b2) {
        b2.a(l.class, (m2.d)e.a);
        b2.a(K0.a.class, (m2.d)H0.a$a.a);
        b2.a(K0.f.class, (m2.d)g.a);
        b2.a(K0.d.class, (m2.d)d.a);
        b2.a(K0.c.class, (m2.d)c.a);
        b2.a(K0.b.class, (m2.d)b.a);
        b2.a(K0.e.class, (m2.d)f.a);
    }

    private static final class a
    implements m2.d {
        static final a a = new a();
        private static final m2.c b = m2.c.a((String)"window").b((Annotation)p2.a.b().c(1).a()).a();
        private static final m2.c c = m2.c.a((String)"logSourceMetrics").b((Annotation)p2.a.b().c(2).a()).a();
        private static final m2.c d = m2.c.a((String)"globalMetrics").b((Annotation)p2.a.b().c(3).a()).a();
        private static final m2.c e = m2.c.a((String)"appNamespace").b((Annotation)p2.a.b().c(4).a()).a();

        private a() {
        }

        public void b(K0.a a2, m2.e e2) {
            e2.a(b, (Object)a2.d());
            e2.a(c, (Object)a2.c());
            e2.a(d, (Object)a2.b());
            e2.a(e, (Object)a2.a());
        }
    }

    private static final class b
    implements m2.d {
        static final b a = new b();
        private static final m2.c b = m2.c.a((String)"storageMetrics").b((Annotation)p2.a.b().c(1).a()).a();

        private b() {
        }

        public void b(K0.b b2, m2.e e2) {
            e2.a(b, (Object)b2.a());
        }
    }

    private static final class c
    implements m2.d {
        static final c a = new c();
        private static final m2.c b = m2.c.a((String)"eventsDroppedCount").b((Annotation)p2.a.b().c(1).a()).a();
        private static final m2.c c = m2.c.a((String)"reason").b((Annotation)p2.a.b().c(3).a()).a();

        private c() {
        }

        public void b(K0.c c2, m2.e e2) {
            e2.d(b, c2.a());
            e2.a(c, (Object)c2.b());
        }
    }

    private static final class d
    implements m2.d {
        static final d a = new d();
        private static final m2.c b = m2.c.a((String)"logSource").b((Annotation)p2.a.b().c(1).a()).a();
        private static final m2.c c = m2.c.a((String)"logEventDropped").b((Annotation)p2.a.b().c(2).a()).a();

        private d() {
        }

        public void b(K0.d d2, m2.e e2) {
            e2.a(b, (Object)d2.b());
            e2.a(c, (Object)d2.a());
        }
    }

    private static final class e
    implements m2.d {
        static final e a = new e();
        private static final m2.c b = m2.c.d((String)"clientMetrics");

        private e() {
        }

        public void b(l l2, m2.e e2) {
            throw null;
        }
    }

    private static final class f
    implements m2.d {
        static final f a = new f();
        private static final m2.c b = m2.c.a((String)"currentCacheSizeBytes").b((Annotation)p2.a.b().c(1).a()).a();
        private static final m2.c c = m2.c.a((String)"maxCacheSizeBytes").b((Annotation)p2.a.b().c(2).a()).a();

        private f() {
        }

        public void b(K0.e e2, m2.e e3) {
            e3.d(b, e2.a());
            e3.d(c, e2.b());
        }
    }

    private static final class g
    implements m2.d {
        static final g a = new g();
        private static final m2.c b = m2.c.a((String)"startMs").b((Annotation)p2.a.b().c(1).a()).a();
        private static final m2.c c = m2.c.a((String)"endMs").b((Annotation)p2.a.b().c(2).a()).a();

        private g() {
        }

        public void b(K0.f f2, m2.e e2) {
            e2.d(b, f2.b());
            e2.d(c, f2.a());
        }
    }
}

