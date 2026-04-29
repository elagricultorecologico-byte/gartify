/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  androidx.work.b
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  java.util.Set
 *  java.util.UUID
 */
package t0;

import B0.p;
import android.os.Build;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import t0.b;

public abstract class u {
    private UUID a;
    private p b;
    private Set c;

    protected u(UUID uUID, p p2, Set set) {
        this.a = uUID;
        this.b = p2;
        this.c = set;
    }

    public String a() {
        return this.a.toString();
    }

    public Set b() {
        return this.c;
    }

    public p c() {
        return this.b;
    }

    public static abstract class a {
        boolean a = false;
        UUID b;
        p c;
        Set d = new HashSet();
        Class e;

        a(Class clazz) {
            this.b = UUID.randomUUID();
            this.e = clazz;
            this.c = new p(this.b.toString(), clazz.getName());
            this.a(clazz.getName());
        }

        public final a a(String string) {
            this.d.add((Object)string);
            return this.d();
        }

        public final u b() {
            u u2 = this.c();
            Object object = this.c.j;
            boolean bl = Build.VERSION.SDK_INT >= 24 && ((b)object).e() || ((b)object).f() || ((b)object).g() || ((b)object).h();
            if (this.c.q && bl) {
                throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
            }
            this.b = UUID.randomUUID();
            this.c = object = new p(this.c);
            ((p)object).a = this.b.toString();
            return u2;
        }

        abstract u c();

        abstract a d();

        public final a e(b b2) {
            this.c.j = b2;
            return this.d();
        }

        public final a f(androidx.work.b b2) {
            this.c.e = b2;
            return this.d();
        }
    }
}

