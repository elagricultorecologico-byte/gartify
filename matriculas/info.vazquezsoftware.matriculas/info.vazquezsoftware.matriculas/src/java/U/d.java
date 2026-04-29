/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashSet
 *  v.i
 *  v.o
 */
package u;

import java.util.ArrayList;
import java.util.HashSet;
import r.c;
import r.i;
import u.e;
import u.h;
import v.o;

public class d {
    private HashSet a = null;
    private int b;
    private boolean c;
    public final e d;
    public final a e;
    public d f;
    public int g = 0;
    int h = Integer.MIN_VALUE;
    i i;

    public d(e e2, a a2) {
        this.d = e2;
        this.e = a2;
    }

    public boolean a(d d3, int n2) {
        return this.b(d3, n2, Integer.MIN_VALUE, false);
    }

    public boolean b(d d3, int n2, int n3, boolean bl) {
        if (d3 == null) {
            this.q();
            return true;
        }
        if (!bl && !this.p(d3)) {
            return false;
        }
        this.f = d3;
        if (d3.a == null) {
            d3.a = new HashSet();
        }
        if ((d3 = this.f.a) != null) {
            d3.add(this);
        }
        this.g = n2;
        this.h = n3;
        return true;
    }

    public void c(int n2, ArrayList arrayList, o o2) {
        HashSet hashSet = this.a;
        if (hashSet != null) {
            hashSet = hashSet.iterator();
            while (hashSet.hasNext()) {
                v.i.a((e)((d)hashSet.next()).d, (int)n2, (ArrayList)arrayList, (o)o2);
            }
        }
    }

    public HashSet d() {
        return this.a;
    }

    public int e() {
        if (!this.c) {
            return 0;
        }
        return this.b;
    }

    public int f() {
        d d3;
        if (this.d.V() == 8) {
            return 0;
        }
        if (this.h != Integer.MIN_VALUE && (d3 = this.f) != null && d3.d.V() == 8) {
            return this.h;
        }
        return this.g;
    }

    public final d g() {
        switch (this.e.ordinal()) {
            default: {
                throw new AssertionError((Object)this.e.name());
            }
            case 4: {
                return this.d.P;
            }
            case 3: {
                return this.d.O;
            }
            case 2: {
                return this.d.R;
            }
            case 1: {
                return this.d.Q;
            }
            case 0: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
        }
        return null;
    }

    public e h() {
        return this.d;
    }

    public i i() {
        return this.i;
    }

    public d j() {
        return this.f;
    }

    public a k() {
        return this.e;
    }

    public boolean l() {
        HashSet hashSet = this.a;
        if (hashSet == null) {
            return false;
        }
        hashSet = hashSet.iterator();
        while (hashSet.hasNext()) {
            if (!((d)hashSet.next()).g().o()) continue;
            return true;
        }
        return false;
    }

    public boolean m() {
        HashSet hashSet = this.a;
        if (hashSet == null) {
            return false;
        }
        return hashSet.size() > 0;
    }

    public boolean n() {
        return this.c;
    }

    public boolean o() {
        return this.f != null;
    }

    public boolean p(d d3) {
        a a2;
        if (d3 == null) {
            return false;
        }
        a a3 = d3.k();
        if (a3 == (a2 = this.e)) {
            return a2 != u.d$a.l || d3.h().Z() && this.h().Z();
        }
        switch (a2.ordinal()) {
            default: {
                throw new AssertionError((Object)this.e.name());
            }
            case 6: {
                return a3 != u.d$a.l && a3 != u.d$a.n && a3 != u.d$a.o;
            }
            case 5: {
                return a3 != u.d$a.h && a3 != u.d$a.j;
                {
                }
            }
            case 2: 
            case 4: {
                boolean bl = a3 == u.d$a.i || a3 == u.d$a.k;
                if (d3.h() instanceof h) {
                    return bl || a3 == u.d$a.o;
                    {
                    }
                }
                return bl;
            }
            case 1: 
            case 3: {
                boolean bl = a3 == u.d$a.h || a3 == u.d$a.j;
                if (d3.h() instanceof h) {
                    return bl || a3 == u.d$a.n;
                    {
                    }
                }
                return bl;
            }
            case 0: 
            case 7: 
            case 8: 
        }
        return false;
    }

    public void q() {
        d d3 = this.f;
        if (d3 != null && (d3 = d3.a) != null) {
            d3.remove(this);
            if (this.f.a.size() == 0) {
                this.f.a = null;
            }
        }
        this.a = null;
        this.f = null;
        this.g = 0;
        this.h = Integer.MIN_VALUE;
        this.c = false;
        this.b = 0;
    }

    public void r() {
        this.c = false;
        this.b = 0;
    }

    public void s(c object) {
        object = this.i;
        if (object == null) {
            this.i = new i(i.a.g, null);
            return;
        }
        ((i)object).h();
    }

    public void t(int n2) {
        this.b = n2;
        this.c = true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.d.t());
        stringBuilder.append(":");
        stringBuilder.append(this.e.toString());
        return stringBuilder.toString();
    }

    public void u(int n2) {
        if (this.o()) {
            this.h = n2;
        }
    }

    public static final class a
    extends Enum {
        public static final /* enum */ a g = new a("NONE", 0);
        public static final /* enum */ a h = new a("LEFT", 1);
        public static final /* enum */ a i = new a("TOP", 2);
        public static final /* enum */ a j = new a("RIGHT", 3);
        public static final /* enum */ a k = new a("BOTTOM", 4);
        public static final /* enum */ a l = new a("BASELINE", 5);
        public static final /* enum */ a m = new a("CENTER", 6);
        public static final /* enum */ a n = new a("CENTER_X", 7);
        public static final /* enum */ a o = new a("CENTER_Y", 8);
        private static final a[] p = u.d$a.d();

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private a() {
            void var2_-1;
            void var1_-1;
        }

        private static /* synthetic */ a[] d() {
            return new a[]{g, h, i, j, k, l, m, n, o};
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])p.clone();
        }
    }
}

