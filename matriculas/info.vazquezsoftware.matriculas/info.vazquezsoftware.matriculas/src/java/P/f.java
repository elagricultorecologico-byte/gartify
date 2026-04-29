/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Cloneable
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 */
package p;

import I2.i;
import V2.k;
import java.util.Arrays;
import p.g;
import q.a;

public class f
implements Cloneable {
    public boolean g;
    public long[] h;
    public Object[] i;
    public int j;

    public f() {
        this(0, 1, null);
    }

    public f(int n2) {
        if (n2 == 0) {
            this.h = a.b;
            this.i = a.c;
            return;
        }
        n2 = a.f(n2);
        this.h = new long[n2];
        this.i = new Object[n2];
    }

    public /* synthetic */ f(int n2, int n3, V2.g g2) {
        if ((n3 & 1) != 0) {
            n2 = 10;
        }
        this(n2);
    }

    public void a(long l2, Object object) {
        int n2;
        Object object2;
        int n3;
        long[] lArray;
        int n4 = this.j;
        if (n4 != 0 && l2 <= this.h[n4 - 1]) {
            this.i(l2, object);
            return;
        }
        if (this.g && n4 >= (lArray = this.h).length) {
            Object[] objectArray = this.i;
            n3 = 0;
            for (int i2 = 0; i2 < n4; ++i2) {
                object2 = objectArray[i2];
                n2 = n3;
                if (object2 != p.g.a()) {
                    if (i2 != n3) {
                        lArray[n3] = lArray[i2];
                        objectArray[n3] = object2;
                        objectArray[i2] = null;
                    }
                    n2 = n3 + 1;
                }
                n3 = n2;
            }
            this.g = false;
            this.j = n3;
        }
        if ((n3 = this.j) >= this.h.length) {
            n2 = a.f(n3 + 1);
            object2 = Arrays.copyOf((long[])this.h, (int)n2);
            k.d(object2, "copyOf(this, newSize)");
            this.h = object2;
            object2 = Arrays.copyOf((Object[])this.i, (int)n2);
            k.d(object2, "copyOf(this, newSize)");
            this.i = object2;
        }
        this.h[n3] = l2;
        this.i[n3] = object;
        this.j = n3 + 1;
    }

    public void b() {
        int n2 = this.j;
        Object[] objectArray = this.i;
        for (int i2 = 0; i2 < n2; ++i2) {
            objectArray[i2] = null;
        }
        this.j = 0;
        this.g = false;
    }

    public f c() {
        Object object = super.clone();
        k.c(object, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        object = (f)object;
        ((f)object).h = (long[])this.h.clone();
        ((f)object).i = (Object[])this.i.clone();
        return object;
    }

    public Object d(long l2) {
        int n2 = a.b(this.h, this.j, l2);
        if (n2 >= 0 && this.i[n2] != p.g.a()) {
            return this.i[n2];
        }
        return null;
    }

    public Object e(long l2, Object object) {
        int n2 = a.b(this.h, this.j, l2);
        if (n2 >= 0 && this.i[n2] != p.g.a()) {
            return this.i[n2];
        }
        return object;
    }

    public int g(long l2) {
        if (this.g) {
            int n2 = this.j;
            long[] lArray = this.h;
            Object[] objectArray = this.i;
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object = objectArray[i2];
                int n4 = n3;
                if (object != p.g.a()) {
                    if (i2 != n3) {
                        lArray[n3] = lArray[i2];
                        objectArray[n3] = object;
                        objectArray[i2] = null;
                    }
                    n4 = n3 + 1;
                }
                n3 = n4;
            }
            this.g = false;
            this.j = n3;
        }
        return a.b(this.h, this.j, l2);
    }

    public long h(int n2) {
        int n3;
        if (n2 >= 0 && n2 < (n3 = this.j)) {
            if (this.g) {
                long[] lArray = this.h;
                Object[] objectArray = this.i;
                int n4 = 0;
                for (int i2 = 0; i2 < n3; ++i2) {
                    Object object = objectArray[i2];
                    int n5 = n4;
                    if (object != p.g.a()) {
                        if (i2 != n4) {
                            lArray[n4] = lArray[i2];
                            objectArray[n4] = object;
                            objectArray[i2] = null;
                        }
                        n5 = n4 + 1;
                    }
                    n4 = n5;
                }
                this.g = false;
                this.j = n4;
            }
            return this.h[n2];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected index to be within 0..size()-1, but was ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString().toString());
    }

    public void i(long l2, Object object) {
        Object object2;
        int n2;
        int n3 = a.b(this.h, this.j, l2);
        if (n3 >= 0) {
            this.i[n3] = object;
            return;
        }
        int n4 = ~n3;
        if (n4 < this.j && this.i[n4] == p.g.a()) {
            this.h[n4] = l2;
            this.i[n4] = object;
            return;
        }
        n3 = n4;
        if (this.g) {
            int n5 = this.j;
            long[] lArray = this.h;
            n3 = n4;
            if (n5 >= lArray.length) {
                Object[] objectArray = this.i;
                n2 = 0;
                for (n3 = 0; n3 < n5; ++n3) {
                    object2 = objectArray[n3];
                    n4 = n2;
                    if (object2 != p.g.a()) {
                        if (n3 != n2) {
                            lArray[n2] = lArray[n3];
                            objectArray[n2] = object2;
                            objectArray[n3] = null;
                        }
                        n4 = n2 + 1;
                    }
                    n2 = n4;
                }
                this.g = false;
                this.j = n2;
                n3 = ~a.b(this.h, n2, l2);
            }
        }
        if ((n4 = this.j) >= this.h.length) {
            n4 = a.f(n4 + 1);
            object2 = Arrays.copyOf((long[])this.h, (int)n4);
            k.d(object2, "copyOf(this, newSize)");
            this.h = object2;
            object2 = Arrays.copyOf((Object[])this.i, (int)n4);
            k.d(object2, "copyOf(this, newSize)");
            this.i = object2;
        }
        if ((n2 = this.j) - n3 != 0) {
            object2 = this.h;
            n4 = n3 + 1;
            I2.i.f(object2, object2, n4, n3, n2);
            object2 = this.i;
            I2.i.g(object2, object2, n4, n3, this.j);
        }
        this.h[n3] = l2;
        this.i[n3] = object;
        ++this.j;
    }

    public void k(long l2) {
        int n2 = a.b(this.h, this.j, l2);
        if (n2 >= 0 && this.i[n2] != p.g.a()) {
            this.i[n2] = p.g.a();
            this.g = true;
        }
    }

    public void l(int n2) {
        if (this.i[n2] != p.g.a()) {
            this.i[n2] = p.g.a();
            this.g = true;
        }
    }

    public int m() {
        if (this.g) {
            int n2 = this.j;
            long[] lArray = this.h;
            Object[] objectArray = this.i;
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object = objectArray[i2];
                int n4 = n3;
                if (object != p.g.a()) {
                    if (i2 != n3) {
                        lArray[n3] = lArray[i2];
                        objectArray[n3] = object;
                        objectArray[i2] = null;
                    }
                    n4 = n3 + 1;
                }
                n3 = n4;
            }
            this.g = false;
            this.j = n3;
        }
        return this.j;
    }

    public Object n(int n2) {
        int n3;
        if (n2 >= 0 && n2 < (n3 = this.j)) {
            if (this.g) {
                long[] lArray = this.h;
                Object[] objectArray = this.i;
                int n4 = 0;
                for (int i2 = 0; i2 < n3; ++i2) {
                    Object object = objectArray[i2];
                    int n5 = n4;
                    if (object != p.g.a()) {
                        if (i2 != n4) {
                            lArray[n4] = lArray[i2];
                            objectArray[n4] = object;
                            objectArray[i2] = null;
                        }
                        n5 = n4 + 1;
                    }
                    n4 = n5;
                }
                this.g = false;
                this.j = n4;
            }
            return this.i[n2];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected index to be within 0..size()-1, but was ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString().toString());
    }

    public String toString() {
        Object object;
        if (this.m() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.j * 28);
        stringBuilder.append('{');
        int n2 = this.j;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (i2 > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(this.h(i2));
            stringBuilder.append('=');
            object = this.n(i2);
            if (object != stringBuilder) {
                stringBuilder.append(object);
                continue;
            }
            stringBuilder.append("(this Map)");
        }
        stringBuilder.append('}');
        object = stringBuilder.toString();
        k.d(object, "StringBuilder(capacity).\u2026builderAction).toString()");
        return object;
    }
}

