/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Cloneable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 */
package p;

import I2.i;
import V2.g;
import java.util.Arrays;
import p.k;
import q.a;

public class j
implements Cloneable {
    public boolean g;
    public int[] h;
    public Object[] i;
    public int j;

    public j() {
        this(0, 1, null);
    }

    public j(int n2) {
        if (n2 == 0) {
            this.h = a.a;
            this.i = a.c;
            return;
        }
        n2 = a.e(n2);
        this.h = new int[n2];
        this.i = new Object[n2];
    }

    public /* synthetic */ j(int n2, int n3, g g2) {
        if ((n3 & 1) != 0) {
            n2 = 10;
        }
        this(n2);
    }

    public void a(int n2, Object object) {
        int n3;
        int n4 = this.j;
        if (n4 != 0 && n2 <= this.h[n4 - 1]) {
            this.i(n2, object);
            return;
        }
        if (this.g && n4 >= this.h.length) {
            k.a(this);
        }
        if ((n3 = this.j) >= this.h.length) {
            n4 = a.e(n3 + 1);
            Object[] objectArray = Arrays.copyOf((int[])this.h, (int)n4);
            V2.k.d(objectArray, "copyOf(this, newSize)");
            this.h = objectArray;
            objectArray = Arrays.copyOf((Object[])this.i, (int)n4);
            V2.k.d(objectArray, "copyOf(this, newSize)");
            this.i = objectArray;
        }
        this.h[n3] = n2;
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

    public j c() {
        Object object = super.clone();
        V2.k.c(object, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        object = (j)object;
        ((j)object).h = (int[])this.h.clone();
        ((j)object).i = (Object[])this.i.clone();
        return object;
    }

    public Object d(int n2) {
        return k.c(this, n2);
    }

    public Object e(int n2, Object object) {
        return k.d(this, n2, object);
    }

    public int g(Object object) {
        if (this.g) {
            k.a(this);
        }
        int n2 = this.j;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.i[i2] != object) continue;
            return i2;
        }
        return -1;
    }

    public int h(int n2) {
        if (this.g) {
            k.a(this);
        }
        return this.h[n2];
    }

    public void i(int n2, Object object) {
        Object[] objectArray;
        int n3 = a.a(this.h, this.j, n2);
        if (n3 >= 0) {
            this.i[n3] = object;
            return;
        }
        int n4 = ~n3;
        if (n4 < this.j && this.i[n4] == k.b()) {
            this.h[n4] = n2;
            this.i[n4] = object;
            return;
        }
        n3 = n4;
        if (this.g) {
            n3 = n4;
            if (this.j >= this.h.length) {
                k.a(this);
                n3 = ~a.a(this.h, this.j, n2);
            }
        }
        if ((n4 = this.j) >= this.h.length) {
            n4 = a.e(n4 + 1);
            objectArray = Arrays.copyOf((int[])this.h, (int)n4);
            V2.k.d(objectArray, "copyOf(this, newSize)");
            this.h = objectArray;
            objectArray = Arrays.copyOf((Object[])this.i, (int)n4);
            V2.k.d(objectArray, "copyOf(this, newSize)");
            this.i = objectArray;
        }
        if ((n4 = this.j) - n3 != 0) {
            objectArray = this.h;
            int n5 = n3 + 1;
            I2.i.e(objectArray, objectArray, n5, n3, n4);
            objectArray = this.i;
            I2.i.g(objectArray, objectArray, n5, n3, this.j);
        }
        this.h[n3] = n2;
        this.i[n3] = object;
        ++this.j;
    }

    public int k() {
        if (this.g) {
            k.a(this);
        }
        return this.j;
    }

    public Object l(int n2) {
        if (this.g) {
            k.a(this);
        }
        return this.i[n2];
    }

    public String toString() {
        Object object;
        if (this.k() <= 0) {
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
            object = this.l(i2);
            if (object != this) {
                stringBuilder.append(object);
                continue;
            }
            stringBuilder.append("(this Map)");
        }
        stringBuilder.append('}');
        object = stringBuilder.toString();
        V2.k.d(object, "buffer.toString()");
        return object;
    }
}

