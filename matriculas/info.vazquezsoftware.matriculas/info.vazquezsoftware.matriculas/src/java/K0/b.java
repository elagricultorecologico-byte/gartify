/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.core.os.c
 *  androidx.lifecycle.l$a
 *  androidx.lifecycle.n
 *  androidx.lifecycle.o
 *  androidx.lifecycle.p
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Iterable
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.LinkedHashSet
 *  java.util.Map
 *  java.util.Set
 */
package k0;

import H2.n;
import I2.E;
import I2.o;
import V2.g;
import V2.k;
import android.os.Bundle;
import androidx.lifecycle.l;
import androidx.lifecycle.p;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import k0.c;
import k0.f;
import k0.i;
import k0.j;

public final class b
implements androidx.lifecycle.n {
    public static final a h = new a(null);
    private final i g;

    public b(i i2) {
        k.e(i2, "owner");
        this.g = i2;
    }

    private final void b(String string) {
        Constructor constructor;
        Object object;
        try {
            object = Class.forName((String)string, (boolean)false, (ClassLoader)b.class.getClassLoader()).asSubclass(f.a.class);
            k.b(object);
        }
        catch (ClassNotFoundException classNotFoundException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Class ");
            stringBuilder.append(string);
            stringBuilder.append(" wasn't found");
            throw new RuntimeException(stringBuilder.toString(), (Throwable)classNotFoundException);
        }
        try {
            constructor = object.getDeclaredConstructor(null);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            string = new StringBuilder();
            string.append("Class ");
            string.append(object.getSimpleName());
            string.append(" must have default constructor in order to be automatically recreated");
            throw new IllegalStateException(string.toString(), (Throwable)noSuchMethodException);
        }
        constructor.setAccessible(true);
        try {
            object = constructor.newInstance(null);
            k.b(object);
            object = object;
        }
        catch (Exception exception) {
            constructor = new StringBuilder();
            constructor.append("Failed to instantiate ");
            constructor.append(string);
            throw new RuntimeException(constructor.toString(), (Throwable)exception);
        }
        object.a(this.g);
    }

    public void j(p p2, l.a a2) {
        k.e(p2, "source");
        k.e(a2, "event");
        if (a2 == l.a.ON_CREATE) {
            p2.x().c((androidx.lifecycle.o)this);
            p2 = this.g.d().a("androidx.savedstate.Restarter");
            if (p2 != null) {
                if ((p2 = c.e(c.a((Bundle)p2), "classes_to_restore")) != null) {
                    p2 = p2.iterator();
                    while (p2.hasNext()) {
                        this.b((String)p2.next());
                    }
                }
            } else {
                return;
            }
            throw new IllegalStateException("SavedState with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        throw new AssertionError((Object)"Next event must be ON_CREATE");
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }

    public static final class b
    implements f.b {
        private final Set a;

        public b(f f2) {
            k.e(f2, "registry");
            this.a = new LinkedHashSet();
            f2.c("androidx.savedstate.Restarter", this);
        }

        @Override
        public Bundle a() {
            H2.j[] jArray;
            Map map2 = E.f();
            if (map2.isEmpty()) {
                jArray = new H2.j[]{};
            } else {
                jArray = new ArrayList(map2.size());
                for (Map map2 : map2.entrySet()) {
                    jArray.add((Object)n.a((String)map2.getKey(), map2.getValue()));
                }
                jArray = (H2.j[])jArray.toArray((Object[])new H2.j[0]);
            }
            jArray = androidx.core.os.c.a((H2.j[])((H2.j[])Arrays.copyOf((Object[])jArray, (int)jArray.length)));
            j.d(j.a((Bundle)jArray), "classes_to_restore", o.K((Iterable)this.a));
            return jArray;
        }

        public final void b(String string) {
            k.e(string, "className");
            this.a.add((Object)string);
        }
    }
}

