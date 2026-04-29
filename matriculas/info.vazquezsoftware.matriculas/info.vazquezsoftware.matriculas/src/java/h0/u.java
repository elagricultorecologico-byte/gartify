/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  P0.d
 *  android.content.Context
 *  java.io.Closeable
 *  java.lang.AutoCloseable
 *  java.lang.Object
 */
package H0;

import H0.t;
import P0.d;
import android.content.Context;
import java.io.Closeable;

abstract class u
implements Closeable,
AutoCloseable {
    u() {
    }

    abstract d a();

    public void close() {
        this.a().close();
    }

    abstract t f();

    static interface a {
        public u a();

        public a b(Context var1);
    }
}

