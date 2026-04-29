/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.core.os.c
 *  androidx.lifecycle.l$a
 *  androidx.lifecycle.l$b
 *  androidx.lifecycle.o
 *  androidx.lifecycle.p
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 */
package l0;

import H2.j;
import H2.n;
import H2.q;
import I2.E;
import V2.g;
import V2.k;
import android.os.Bundle;
import androidx.lifecycle.l;
import androidx.lifecycle.o;
import androidx.lifecycle.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import k0.f;
import k0.i;
import l0.c;

public final class b {
    private static final a i = new a(null);
    private final i a;
    private final U2.a b;
    private final c c;
    private final Map d;
    private boolean e;
    private Bundle f;
    private boolean g;
    private boolean h;

    public b(i i2, U2.a a2) {
        k.e(i2, "owner");
        k.e(a2, "onAttach");
        this.a = i2;
        this.b = a2;
        this.c = new c();
        this.d = new LinkedHashMap();
        this.h = true;
    }

    public static /* synthetic */ void a(b b2, p p2, l.a a2) {
        l0.b.g(b2, p2, a2);
    }

    private static final void g(b b2, p p2, l.a a2) {
        k.e(p2, "<unused var>");
        k.e(a2, "event");
        if (a2 == l.a.ON_START) {
            b2.h = true;
            return;
        }
        if (a2 == l.a.ON_STOP) {
            b2.h = false;
        }
    }

    public final Bundle c(String string) {
        k.e(string, "key");
        if (this.g) {
            Bundle bundle = this.f;
            if (bundle == null) {
                return null;
            }
            Object object = k0.c.a(bundle);
            object = k0.c.b(object, string) ? k0.c.c(object, string) : null;
            k0.j.e(k0.j.a(bundle), string);
            if (k0.c.f(k0.c.a(bundle))) {
                this.f = null;
            }
            return object;
        }
        throw new IllegalStateException("You can 'consumeRestoredStateForKey' only after the corresponding component has moved to the 'CREATED' state");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final f.b d(String string) {
        c c2;
        k.e(string, "key");
        c c3 = c2 = this.c;
        synchronized (c3) {
            Throwable throwable2;
            block5: {
                String string2;
                try {
                    Iterator iterator = this.d.entrySet().iterator();
                    do {
                        boolean bl = iterator.hasNext();
                        string2 = null;
                        Object var4_8 = null;
                        if (!bl) break;
                        Object object = (Map.Entry)iterator.next();
                        string2 = (String)object.getKey();
                        object = object.getValue();
                        bl = k.a(string2, string);
                        string2 = var4_8;
                        if (!bl) continue;
                        string2 = object;
                    } while (string2 == null);
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                return string2;
            }
            throw throwable2;
        }
    }

    public final boolean e() {
        return this.h;
    }

    public final void f() {
        if (this.a.x().b() == l.b.h) {
            if (!this.e) {
                this.b.a();
                this.a.x().a((o)new l0.a(this));
                this.e = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public final void h(Bundle bundle) {
        if (!this.e) {
            this.f();
        }
        if (!this.a.x().b().e(l.b.j)) {
            if (!this.g) {
                Bundle bundle2;
                Bundle bundle3 = bundle2 = null;
                if (bundle != null) {
                    bundle = k0.c.a(bundle);
                    bundle3 = bundle2;
                    if (k0.c.b(bundle, "androidx.lifecycle.BundlableSavedStateRegistry.key")) {
                        bundle3 = k0.c.c(bundle, "androidx.lifecycle.BundlableSavedStateRegistry.key");
                    }
                }
                this.f = bundle3;
                this.g = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        bundle = new StringBuilder();
        bundle.append("performRestore cannot be called when owner is ");
        bundle.append((Object)this.a.x().b());
        throw new IllegalStateException(bundle.toString().toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void i(Bundle bundle) {
        j[] jArray;
        k.e(bundle, "outBundle");
        Object object2 = E.f();
        if (object2.isEmpty()) {
            jArray = new j[]{};
        } else {
            jArray = new ArrayList(object2.size());
            for (Object object2 : object2.entrySet()) {
                jArray.add((Object)n.a((String)object2.getKey(), object2.getValue()));
            }
            jArray = (j[])jArray.toArray((Object[])new j[0]);
        }
        jArray = androidx.core.os.c.a((j[])((j[])Arrays.copyOf((Object[])jArray, (int)jArray.length)));
        Object object3 = k0.j.a((Bundle)jArray);
        object2 = this.f;
        if (object2 != null) {
            k0.j.b((Bundle)object3, (Bundle)object2);
        }
        Object object4 = object2 = this.c;
        // MONITORENTER : object4
        for (Map.Entry entry : this.d.entrySet()) {
            k0.j.c((Bundle)object3, (String)entry.getKey(), (entry.getValue()).a());
        }
        object3 = q.a;
        // MONITOREXIT : object4
        if (k0.c.f(k0.c.a((Bundle)jArray))) return;
        k0.j.c(k0.j.a(bundle), "androidx.lifecycle.BundlableSavedStateRegistry.key", (Bundle)jArray);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void j(String object, f.b b2) {
        c c2;
        k.e(object, "key");
        k.e(b2, "provider");
        c c3 = c2 = this.c;
        synchronized (c3) {
            Throwable throwable2;
            block4: {
                try {
                    if (!this.d.containsKey(object)) {
                        this.d.put(object, (Object)b2);
                        object = q.a;
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block4;
                }
                object = new IllegalArgumentException("SavedStateProvider with the given key is already registered");
                throw object;
            }
            throw throwable2;
        }
    }

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }
}

