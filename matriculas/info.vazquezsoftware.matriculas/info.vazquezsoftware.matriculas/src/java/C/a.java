/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.util.Iterator
 *  java.util.Set
 *  java.util.concurrent.CopyOnWriteArraySet
 */
package c;

import V2.k;
import android.content.Context;
import c.b;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a {
    private final Set a = new CopyOnWriteArraySet();
    private volatile Context b;

    public final void a(b b3) {
        k.e(b3, "listener");
        Context context = this.b;
        if (context != null) {
            b3.a(context);
        }
        this.a.add((Object)b3);
    }

    public final void b() {
        this.b = null;
    }

    public final void c(Context context) {
        k.e(context, "context");
        this.b = context;
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            ((b)iterator.next()).a(context);
        }
    }
}

