/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.lifecycle.o
 *  java.lang.Object
 */
package k0;

import H2.q;
import V2.k;
import android.os.Bundle;
import androidx.lifecycle.o;
import k0.b;
import k0.f;
import k0.g;
import k0.i;

public final class h {
    public static final a c = new a(null);
    private final l0.b a;
    private final f b;

    private h(l0.b b2) {
        this.a = b2;
        this.b = new f(b2);
    }

    public /* synthetic */ h(l0.b b2, V2.g g2) {
        this(b2);
    }

    public static final h a(i i2) {
        return c.b(i2);
    }

    public final f b() {
        return this.b;
    }

    public final void c() {
        this.a.f();
    }

    public final void d(Bundle bundle) {
        this.a.h(bundle);
    }

    public final void e(Bundle bundle) {
        k.e(bundle, "outBundle");
        this.a.i(bundle);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(V2.g g2) {
            this();
        }

        public static /* synthetic */ q a(i i2) {
            return k0.h$a.c(i2);
        }

        private static final q c(i i2) {
            i2.x().a((o)new b(i2));
            return q.a;
        }

        public final h b(i i2) {
            k.e(i2, "owner");
            return new h(new l0.b(i2, new g(i2)), null);
        }
    }
}

