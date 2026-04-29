/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Looper
 *  java.io.FileDescriptor
 *  java.io.PrintWriter
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 */
package w1;

import H1.p;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import p.a;
import w1.c0;
import w1.g;

final class d0 {
    private final Map a = Collections.synchronizedMap((Map)new a());
    private int b = 0;
    private Bundle c;

    d0() {
    }

    final g a(String string, Class clazz) {
        return (g)clazz.cast(this.a.get((Object)string));
    }

    final void b(String string, g g2) {
        Map map = this.a;
        if (!map.containsKey((Object)string)) {
            map.put((Object)string, (Object)g2);
            if (this.b > 0) {
                new p(Looper.getMainLooper()).post(new c0(this, g2, string));
            }
            return;
        }
        g2 = new StringBuilder(String.valueOf((Object)string).length() + 59);
        g2.append("LifecycleCallback with tag ");
        g2.append(string);
        g2.append(" already added to this fragment.");
        throw new IllegalArgumentException(g2.toString());
    }

    final void c(Bundle bundle) {
        this.b = 1;
        this.c = bundle;
        for (Object object : this.a.entrySet()) {
            g g2 = (g)object.getValue();
            object = bundle != null ? bundle.getBundle((String)object.getKey()) : null;
            g2.f((Bundle)object);
        }
    }

    final void d() {
        this.b = 2;
        Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            ((g)iterator.next()).j();
        }
    }

    final void e() {
        this.b = 3;
        Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            ((g)iterator.next()).h();
        }
    }

    final void f(int n2, int n3, Intent intent) {
        Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            ((g)iterator.next()).e(n2, n3, intent);
        }
    }

    final void g(Bundle bundle) {
        if (bundle != null) {
            for (Map.Entry entry : this.a.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((g)entry.getValue()).i(bundle2);
                bundle.putBundle((String)entry.getKey(), bundle2);
            }
        }
    }

    final void h() {
        this.b = 4;
        Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            ((g)iterator.next()).k();
        }
    }

    final void i() {
        this.b = 5;
        Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            ((g)iterator.next()).g();
        }
    }

    final void j(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            ((g)iterator.next()).a(string, fileDescriptor, printWriter, stringArray);
        }
    }

    final /* synthetic */ int k() {
        return this.b;
    }

    final /* synthetic */ Bundle l() {
        return this.c;
    }
}

