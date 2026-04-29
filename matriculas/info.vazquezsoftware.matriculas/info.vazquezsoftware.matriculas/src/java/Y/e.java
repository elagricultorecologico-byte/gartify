/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.AutoCloseable
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.LinkedHashMap
 *  java.util.LinkedHashSet
 *  java.util.Map
 *  java.util.Set
 */
package Y;

import C.f;
import H2.q;
import V2.k;
import Y.d;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class e {
    private final d a = new d();
    private final Map b = new LinkedHashMap();
    private final Set c = new LinkedHashSet();
    private volatile boolean d;

    private final void f(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                f.a(autoCloseable);
                return;
            }
            catch (Exception exception) {
                throw new RuntimeException((Throwable)exception);
            }
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void d(String string, AutoCloseable autoCloseable) {
        d d3;
        void var2_2;
        k.e(string, "key");
        k.e(var2_2, "closeable");
        if (this.d) {
            this.f((AutoCloseable)var2_2);
            return;
        }
        d d4 = d3 = this.a;
        synchronized (d4) {
            string = (AutoCloseable)this.b.put((Object)string, (Object)var2_2);
        }
        this.f((AutoCloseable)string);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void e() {
        d d3;
        if (this.d) {
            return;
        }
        this.d = true;
        d d4 = d3 = this.a;
        synchronized (d4) {
            Throwable throwable2;
            block7: {
                Object object;
                try {
                    object = this.b.values().iterator();
                    while (object.hasNext()) {
                        this.f((AutoCloseable)object.next());
                    }
                }
                catch (Throwable throwable2) {
                    break block7;
                }
                object = this.c.iterator();
                while (true) {
                    if (!object.hasNext()) {
                        this.c.clear();
                        object = q.a;
                        return;
                    }
                    this.f((AutoCloseable)object.next());
                }
            }
            throw throwable2;
        }
    }

    public final AutoCloseable g(String string) {
        d d3;
        k.e(string, "key");
        d d4 = d3 = this.a;
        synchronized (d4) {
            string = (AutoCloseable)this.b.get((Object)string);
            return string;
        }
    }
}

