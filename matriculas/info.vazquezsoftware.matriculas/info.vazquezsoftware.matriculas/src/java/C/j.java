/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.Typeface
 *  androidx.core.graphics.e
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.concurrent.Callable
 *  java.util.concurrent.Executor
 *  java.util.concurrent.ExecutorService
 *  p.h
 *  p.i
 */
package C;

import C.a;
import C.i;
import C.k;
import C.l;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import p.h;

abstract class j {
    static final h a = new h(16);
    private static final ExecutorService b = l.a("fonts-androidx", 10, 10000);
    static final Object c = new Object();
    static final p.i d = new p.i();

    private static String a(i i2, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i2.d());
        stringBuilder.append("-");
        stringBuilder.append(n2);
        return stringBuilder.toString();
    }

    private static int b(k.a bArray) {
        int n2 = bArray.c();
        int n3 = 1;
        if (n2 != 0) {
            if (bArray.c() != 1) {
                return -3;
            }
            return -2;
        }
        bArray = bArray.b();
        n2 = n3;
        if (bArray != null) {
            if (bArray.length == 0) {
                n2 = n3;
            } else {
                int n4 = bArray.length;
                int n5 = 0;
                n3 = 0;
                while (true) {
                    n2 = n5;
                    if (n3 >= n4) break;
                    n2 = bArray[n3].b();
                    if (n2 != 0) {
                        if (n2 < 0) {
                            return -3;
                        }
                        return n2;
                    }
                    ++n3;
                }
            }
        }
        return n2;
    }

    static e c(String string, Context context, i object, int n2) {
        h h2 = a;
        Typeface typeface = (Typeface)h2.c((Object)string);
        if (typeface != null) {
            return new e(typeface);
        }
        try {
            object = C.e.e(context, (i)object, null);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return new e(-1);
        }
        int n3 = j.b((k.a)object);
        if (n3 != 0) {
            return new e(n3);
        }
        if ((context = androidx.core.graphics.e.b((Context)context, null, (k.b[])((k.a)object).b(), (int)n2)) != null) {
            h2.d((Object)string, (Object)context);
            return new e((Typeface)context);
        }
        return new e(-3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    static Typeface d(Context context, i object, int n2, Executor executor, a object2) {
        String string = j.a((i)object, n2);
        Object object3 = (Typeface)a.c((Object)string);
        if (object3 != null) {
            ((a)object2).b(new e((Typeface)object3));
            return object3;
        }
        object3 = new D.a((a)object2){
            final a a;
            {
                this.a = a2;
            }

            public void b(e e2) {
                e e3 = e2;
                if (e2 == null) {
                    e3 = new e(-3);
                }
                this.a.b(e3);
            }
        };
        Object object4 = object2 = c;
        // MONITORENTER : object4
        p.i i2 = d;
        ArrayList arrayList = (ArrayList)i2.get((Object)string);
        if (arrayList != null) {
            arrayList.add(object3);
            // MONITOREXIT : object4
            return null;
        }
        arrayList = new ArrayList();
        arrayList.add(object3);
        i2.put((Object)string, (Object)arrayList);
        // MONITOREXIT : object4
        object = new Callable(string, context, (i)object, n2){
            final String a;
            final Context b;
            final i c;
            final int d;
            {
                this.a = string;
                this.b = context;
                this.c = i2;
                this.d = n2;
            }

            public e a() {
                try {
                    e e2 = j.c(this.a, this.b, this.c, this.d);
                    return e2;
                }
                catch (Throwable throwable) {
                    return new e(-3);
                }
            }
        };
        context = executor;
        if (executor == null) {
            context = b;
        }
        l.b((Executor)context, (Callable)object, new D.a(string){
            final String a;
            {
                this.a = string;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Converted monitor instructions to comments
             * Lifted jumps to return sites
             */
            public void b(e e2) {
                Object object;
                Object object2 = object = c;
                // MONITORENTER : object2
                p.i i2 = d;
                ArrayList arrayList = (ArrayList)i2.get((Object)this.a);
                if (arrayList == null) {
                    // MONITOREXIT : object2
                    return;
                }
                i2.remove((Object)this.a);
                // MONITOREXIT : object2
                int n2 = 0;
                while (n2 < arrayList.size()) {
                    ((D.a)arrayList.get(n2)).a(e2);
                    ++n2;
                }
            }
        });
        return null;
    }

    static Typeface e(Context object, i i2, a a2, int n2, int n3) {
        String string = j.a(i2, n2);
        Typeface typeface = (Typeface)a.c((Object)string);
        if (typeface != null) {
            a2.b(new e(typeface));
            return typeface;
        }
        if (n3 == -1) {
            object = j.c(string, object, i2, n2);
            a2.b((e)object);
            return object.a;
        }
        object = new Callable(string, (Context)object, i2, n2){
            final String a;
            final Context b;
            final i c;
            final int d;
            {
                this.a = string;
                this.b = context;
                this.c = i2;
                this.d = n2;
            }

            public e a() {
                return j.c(this.a, this.b, this.c, this.d);
            }
        };
        try {
            object = (e)l.c(b, (Callable)object, n3);
            a2.b((e)object);
            object = object.a;
            return object;
        }
        catch (InterruptedException interruptedException) {
            a2.b(new e(-3));
            return null;
        }
    }

    static final class e {
        final Typeface a;
        final int b;

        e(int n2) {
            this.a = null;
            this.b = n2;
        }

        e(Typeface typeface) {
            this.a = typeface;
            this.b = 0;
        }

        boolean a() {
            return this.b == 0;
        }
    }
}

