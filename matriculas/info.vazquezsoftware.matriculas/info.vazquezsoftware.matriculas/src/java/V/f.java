/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package v;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import v.d;
import v.g;
import v.p;

public class f
implements d {
    public d a = null;
    public boolean b = false;
    public boolean c = false;
    p d;
    a e = v.f$a.g;
    int f;
    public int g;
    int h = 1;
    g i = null;
    public boolean j = false;
    List k = new ArrayList();
    List l = new ArrayList();

    public f(p p2) {
        this.d = p2;
    }

    @Override
    public void a(d d2) {
        block8: {
            block9: {
                block10: {
                    f f2;
                    d2 = this.l.iterator();
                    while (d2.hasNext()) {
                        if (((f)d2.next()).j) continue;
                        break block8;
                    }
                    this.c = true;
                    d2 = this.a;
                    if (d2 != null) {
                        d2.a(this);
                    }
                    if (this.b) {
                        this.d.a(this);
                        return;
                    }
                    Iterator iterator = this.l.iterator();
                    d2 = null;
                    int n2 = 0;
                    while (iterator.hasNext()) {
                        f2 = (f)iterator.next();
                        if (f2 instanceof g) continue;
                        ++n2;
                        d2 = f2;
                    }
                    if (d2 == null || n2 != true || !((f)d2).j) break block9;
                    f2 = this.i;
                    if (f2 == null) break block10;
                    if (!f2.j) break block8;
                    this.f = this.h * f2.g;
                }
                this.d(((f)d2).g + this.f);
            }
            if ((d2 = this.a) != null) {
                d2.a(this);
            }
        }
    }

    public void b(d d2) {
        this.k.add((Object)d2);
        if (this.j) {
            d2.a(d2);
        }
    }

    public void c() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.g = 0;
        this.c = false;
        this.b = false;
    }

    public void d(int n2) {
        if (!this.j) {
            this.j = true;
            this.g = n2;
            for (d d2 : this.k) {
                d2.a(d2);
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.d.b.t());
        stringBuilder.append(":");
        stringBuilder.append((Object)this.e);
        stringBuilder.append("(");
        String string = this.j ? Integer.valueOf((int)this.g) : "unresolved";
        stringBuilder.append((Object)string);
        stringBuilder.append(") <t=");
        stringBuilder.append(this.l.size());
        stringBuilder.append(":d=");
        stringBuilder.append(this.k.size());
        stringBuilder.append(">");
        return stringBuilder.toString();
    }

    static final class a
    extends Enum {
        public static final /* enum */ a g = new a("UNKNOWN", 0);
        public static final /* enum */ a h = new a("HORIZONTAL_DIMENSION", 1);
        public static final /* enum */ a i = new a("VERTICAL_DIMENSION", 2);
        public static final /* enum */ a j = new a("LEFT", 3);
        public static final /* enum */ a k = new a("RIGHT", 4);
        public static final /* enum */ a l = new a("TOP", 5);
        public static final /* enum */ a m = new a("BOTTOM", 6);
        public static final /* enum */ a n = new a("BASELINE", 7);
        private static final a[] o = v.f$a.d();

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private a() {
            void var2_-1;
            void var1_-1;
        }

        private static /* synthetic */ a[] d() {
            return new a[]{g, h, i, j, k, l, m, n};
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])o.clone();
        }
    }
}

