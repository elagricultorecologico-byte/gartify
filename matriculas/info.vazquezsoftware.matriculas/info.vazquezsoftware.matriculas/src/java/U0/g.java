/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 */
package u0;

import C0.b;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import t0.d;
import t0.m;
import t0.r;
import t0.u;
import u0.j;

public class g
extends r {
    private static final String j = t0.j.f("WorkContinuationImpl");
    private final j a;
    private final String b;
    private final d c;
    private final List d;
    private final List e;
    private final List f;
    private final List g;
    private boolean h;
    private m i;

    public g(j object, String object22, d d3, List list, List list2) {
        this.a = object;
        this.b = object22;
        this.c = d3;
        this.d = list;
        this.g = list2;
        this.e = new ArrayList(list.size());
        this.f = new ArrayList();
        if (list2 != null) {
            for (Object object22 : list2) {
                this.f.addAll((Collection)((g)object22).f);
            }
        }
        for (int i2 = 0; i2 < list.size(); ++i2) {
            object = ((u)list.get(i2)).a();
            this.e.add(object);
            this.f.add(object);
        }
    }

    public g(j j2, List list) {
        this(j2, null, t0.d.h, list, null);
    }

    private static boolean i(g g2, Set set) {
        set.addAll((Collection)g2.c());
        Set set2 = u0.g.l(g2);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            if (!set2.contains((Object)((String)iterator.next()))) continue;
            return true;
        }
        iterator = g2.e();
        if (iterator != null && !iterator.isEmpty()) {
            iterator = iterator.iterator();
            while (iterator.hasNext()) {
                if (!u0.g.i((g)iterator.next(), set)) continue;
                return true;
            }
        }
        set.removeAll((Collection)g2.c());
        return false;
    }

    public static Set l(g g2) {
        HashSet hashSet = new HashSet();
        if ((g2 = g2.e()) != null && !g2.isEmpty()) {
            g2 = g2.iterator();
            while (g2.hasNext()) {
                hashSet.addAll((Collection)((g)g2.next()).c());
            }
        }
        return hashSet;
    }

    public m a() {
        if (!this.h) {
            b b2 = new b(this);
            this.a.p().b(b2);
            this.i = b2.d();
        } else {
            t0.j.c().h(j, String.format((String)"Already enqueued work ids (%s)", (Object[])new Object[]{TextUtils.join((CharSequence)", ", (Iterable)this.e)}), new Throwable[0]);
        }
        return this.i;
    }

    public d b() {
        return this.c;
    }

    public List c() {
        return this.e;
    }

    public String d() {
        return this.b;
    }

    public List e() {
        return this.g;
    }

    public List f() {
        return this.d;
    }

    public j g() {
        return this.a;
    }

    public boolean h() {
        return u0.g.i(this, (Set)new HashSet());
    }

    public boolean j() {
        return this.h;
    }

    public void k() {
        this.h = true;
    }
}

