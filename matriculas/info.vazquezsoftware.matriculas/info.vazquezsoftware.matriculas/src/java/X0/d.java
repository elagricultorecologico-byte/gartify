/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 */
package x0;

import D0.a;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import t0.j;
import x0.c;
import y0.b;
import y0.c;
import y0.e;
import y0.f;
import y0.g;
import y0.h;

public class d
implements c.a {
    private static final String d = j.f("WorkConstraintsTracker");
    private final c a;
    private final y0.c[] b;
    private final Object c;

    public d(Context context, a a2, c c2) {
        context = context.getApplicationContext();
        this.a = c2;
        this.b = new y0.c[]{new y0.a(context, a2), new b(context, a2), new h(context, a2), new y0.d(context, a2), new g(context, a2), new f(context, a2), new e(context, a2)};
        this.c = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(List object) {
        Object object2;
        Object object3 = object2 = this.c;
        synchronized (object3) {
            Throwable throwable2;
            block5: {
                ArrayList arrayList;
                try {
                    arrayList = new ArrayList();
                    object = object.iterator();
                    while (object.hasNext()) {
                        String string = (String)object.next();
                        if (!this.c(string)) continue;
                        j.c().a(d, String.format((String)"Constraints met for %s", (Object[])new Object[]{string}), new Throwable[0]);
                        arrayList.add((Object)string);
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                object = this.a;
                if (object != null) {
                    object.d((List)arrayList);
                }
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void b(List list) {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        c c2 = this.a;
                        if (c2 == null) break block3;
                        c2.c(list);
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                return;
            }
            throw throwable2;
        }
    }

    /*
     * WARNING - combined exceptions agressively - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean c(String string) {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            try {
                for (y0.c c2 : this.b) {
                    if (!c2.d(string)) continue;
                    j.c().a(d, String.format((String)"Work %s constrained by %s", (Object[])new Object[]{string, c2.getClass().getSimpleName()}), new Throwable[0]);
                    return false;
                }
                return true;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(Iterable cArray) {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            Throwable throwable2;
            block9: {
                int n2;
                int n3;
                y0.c[] cArray2;
                try {
                    cArray2 = this.b;
                    n3 = cArray2.length;
                    int n4 = 0;
                    for (n2 = 0; n2 < n3; ++n2) {
                        cArray2[n2].g(null);
                    }
                }
                catch (Throwable throwable2) {
                    break block9;
                }
                {
                    cArray2 = this.b;
                    n3 = cArray2.length;
                    for (n2 = 0; n2 < n3; ++n2) {
                        cArray2[n2].e((Iterable)cArray);
                    }
                }
                {
                    cArray = this.b;
                    n3 = cArray.length;
                    for (n2 = n4; n2 < n3; ++n2) {
                        cArray[n2].g(this);
                    }
                }
                return;
            }
            throw throwable2;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void e() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            Throwable throwable2;
            block5: {
                try {
                    y0.c[] cArray = this.b;
                    int n2 = cArray.length;
                    for (int i2 = 0; i2 < n2; ++i2) {
                        cArray[i2].f();
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                return;
            }
            throw throwable2;
        }
    }
}

