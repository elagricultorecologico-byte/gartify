/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.LinkedHashSet
 *  java.util.Set
 */
package r3;

import V2.k;
import java.util.LinkedHashSet;
import java.util.Set;
import m3.C;

public final class h {
    private final Set a = new LinkedHashSet();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(C c2) {
        h h2 = this;
        synchronized (h2) {
            k.e(c2, "route");
            this.a.remove((Object)c2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void b(C c2) {
        h h2 = this;
        synchronized (h2) {
            k.e(c2, "failedRoute");
            this.a.add((Object)c2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean c(C c2) {
        h h2 = this;
        synchronized (h2) {
            k.e(c2, "route");
            return this.a.contains((Object)c2);
        }
    }
}

