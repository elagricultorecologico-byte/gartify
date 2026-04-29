/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Log
 *  androidx.core.app.c
 *  androidx.lifecycle.l
 *  androidx.lifecycle.l$b
 *  androidx.lifecycle.n
 *  androidx.lifecycle.p
 *  d.a
 *  d.c
 *  d.d$a
 *  d.d$b
 *  d.d$c
 *  d.d$d
 *  d.d$e
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Map
 */
package d;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.lifecycle.l;
import androidx.lifecycle.n;
import androidx.lifecycle.p;
import d.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class d {
    private final Map a = new HashMap();
    final Map b = new HashMap();
    private final Map c = new HashMap();
    ArrayList d = new ArrayList();
    final transient Map e = new HashMap();
    final Map f = new HashMap();
    final Bundle g = new Bundle();

    private void a(int n3, String string) {
        this.a.put((Object)n3, (Object)string);
        this.b.put((Object)string, (Object)n3);
    }

    private void d(String string, int n3, Intent intent, d d3) {
        if (d3 != null && d3.a != null && this.d.contains((Object)string)) {
            d3.a.a(d3.b.c(n3, intent));
            this.d.remove((Object)string);
            return;
        }
        this.f.remove((Object)string);
        this.g.putParcelable(string, (Parcelable)new d.a(n3, intent));
    }

    private int e() {
        int n3 = W2.c.g.b(0x7FFF0000);
        while (this.a.containsKey((Object)(n3 += 65536))) {
            n3 = W2.c.g.b(0x7FFF0000);
        }
        return n3;
    }

    private void k(String string) {
        if ((Integer)this.b.get((Object)string) != null) {
            return;
        }
        this.a(this.e(), string);
    }

    public final boolean b(int n3, int n4, Intent intent) {
        String string = (String)this.a.get((Object)n3);
        if (string == null) {
            return false;
        }
        this.d(string, n4, intent, this.e.get((Object)string));
        return true;
    }

    public final boolean c(int n3, Object object) {
        String string = (String)this.a.get((Object)n3);
        if (string == null) {
            return false;
        }
        Object object2 = this.e.get((Object)string);
        if (object2 != null && (object2 = object2.a) != null) {
            if (this.d.remove((Object)string)) {
                object2.a(object);
            }
        } else {
            this.g.remove(string);
            this.f.put((Object)string, object);
        }
        return true;
    }

    public abstract void f(int var1, e.a var2, Object var3, androidx.core.app.c var4);

    public final void g(Bundle object) {
        if (object != null) {
            ArrayList arrayList = object.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList arrayList2 = object.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (arrayList2 != null && arrayList != null) {
                this.d = object.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                this.g.putAll(object.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
                for (int i3 = 0; i3 < arrayList2.size(); ++i3) {
                    object = (String)arrayList2.get(i3);
                    if (this.b.containsKey(object)) {
                        Integer n3 = (Integer)this.b.remove(object);
                        if (!this.g.containsKey((String)object)) {
                            this.a.remove((Object)n3);
                        }
                    }
                    this.a((Integer)arrayList.get(i3), (String)arrayList2.get(i3));
                }
            }
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(this.b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList((Collection)this.b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList((Collection)this.d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle)this.g.clone());
    }

    public final d.c i(String string, p p3, e.a a3, d.b b3) {
        l l3 = p3.x();
        if (!l3.b().e(l.b.j)) {
            this.k(string);
            e e3 = this.c.get((Object)string);
            p3 = e3;
            if (e3 == null) {
                p3 = new /* Unavailable Anonymous Inner Class!! */;
            }
            p3.a((n)new a(this, string, b3, a3));
            this.c.put((Object)string, (Object)p3);
            return new b(this, string, a3);
        }
        string = new StringBuilder();
        string.append("LifecycleOwner ");
        string.append((Object)p3);
        string.append(" is attempting to register while current state is ");
        string.append((Object)l3.b());
        string.append(". LifecycleOwners must call register before they are STARTED.");
        throw new IllegalStateException(string.toString());
    }

    public final d.c j(String string, e.a a3, d.b b3) {
        Object object;
        this.k(string);
        this.e.put((Object)string, (Object)new /* Unavailable Anonymous Inner Class!! */);
        if (this.f.containsKey((Object)string)) {
            object = this.f.get((Object)string);
            this.f.remove((Object)string);
            b3.a(object);
        }
        if ((object = (d.a)this.g.getParcelable(string)) != null) {
            this.g.remove(string);
            b3.a(a3.c(object.b(), object.a()));
        }
        return new c(this, string, a3);
    }

    final void l(String string) {
        Integer n3;
        if (!this.d.contains((Object)string) && (n3 = (Integer)this.b.remove((Object)string)) != null) {
            this.a.remove((Object)n3);
        }
        this.e.remove((Object)string);
        if (this.f.containsKey((Object)string)) {
            n3 = new StringBuilder();
            n3.append("Dropping pending result for request ");
            n3.append(string);
            n3.append(": ");
            n3.append(this.f.get((Object)string));
            Log.w((String)"ActivityResultRegistry", (String)n3.toString());
            this.f.remove((Object)string);
        }
        if (this.g.containsKey(string)) {
            n3 = new StringBuilder();
            n3.append("Dropping pending result for request ");
            n3.append(string);
            n3.append(": ");
            n3.append((Object)this.g.getParcelable(string));
            Log.w((String)"ActivityResultRegistry", (String)n3.toString());
            this.g.remove(string);
        }
        if ((n3 = this.c.get((Object)string)) != null) {
            n3.b();
            this.c.remove((Object)string);
        }
    }
}

