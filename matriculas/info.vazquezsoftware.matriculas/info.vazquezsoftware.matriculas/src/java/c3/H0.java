/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.lang.AutoCloseable
 *  java.lang.Object
 */
package c3;

import L2.b;
import L2.i;
import V2.g;
import c3.F;
import c3.g0;
import java.io.Closeable;

public abstract class h0
extends F
implements Closeable,
AutoCloseable {
    public static final a i = new a(null);

    public static final class a
    extends b {
        private a() {
            super(F.h, new g0());
        }

        public /* synthetic */ a(g g3) {
            this();
        }

        public static /* synthetic */ h0 c(i.b b3) {
            return a.d(b3);
        }

        private static final h0 d(i.b b3) {
            if (b3 instanceof h0) {
                return (h0)b3;
            }
            return null;
        }
    }
}

