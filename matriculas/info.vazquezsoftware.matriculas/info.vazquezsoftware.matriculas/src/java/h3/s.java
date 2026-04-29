/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.Iterator
 *  java.util.List
 *  java.util.ServiceLoader
 */
package h3;

import a3.e;
import c3.z0;
import h3.E;
import h3.r;
import h3.t;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

public final class s {
    public static final s a;
    public static final z0 b;

    static {
        s s2;
        a = s2 = new s();
        E.f("kotlinx.coroutines.fast.service.loader", true);
        b = s2.a();
    }

    private s() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final z0 a() {
        Throwable throwable2;
        block8: {
            try {
                Object object;
                List list = e.h(e.a(ServiceLoader.load(r.class, (ClassLoader)r.class.getClassLoader()).iterator()));
                Iterator iterator = list.iterator();
                if (!iterator.hasNext()) {
                    object = null;
                } else {
                    object = iterator.next();
                    if (iterator.hasNext()) {
                        int n2 = ((r)object).c();
                        Object object2 = object;
                        do {
                            Object object3 = iterator.next();
                            int n3 = ((r)object3).c();
                            object = object2;
                            int n4 = n2;
                            if (n2 < n3) {
                                object = object3;
                                n4 = n3;
                            }
                            object2 = object;
                            n2 = n4;
                        } while (iterator.hasNext());
                    }
                }
                object = (r)object;
                if (object != null && (object = t.e((r)object, list)) != null) {
                    return object;
                }
            }
            catch (Throwable throwable2) {
                break block8;
            }
            t.b(null, null, 3, null);
            return null;
        }
        t.b(throwable2, null, 2, null);
        return null;
    }
}

