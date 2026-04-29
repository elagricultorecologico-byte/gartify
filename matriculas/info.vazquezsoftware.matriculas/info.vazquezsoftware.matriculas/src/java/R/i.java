/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Comparable
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.HashSet
 */
package r;

import java.util.Arrays;
import java.util.HashSet;
import r.b;
import r.d;

public class i
implements Comparable {
    private static int x = 1;
    public boolean g;
    private String h;
    public int i = -1;
    int j = -1;
    public int k = 0;
    public float l;
    public boolean m = false;
    float[] n = new float[9];
    float[] o = new float[9];
    a p;
    b[] q = new b[16];
    int r = 0;
    public int s = 0;
    boolean t = false;
    int u = -1;
    float v = 0.0f;
    HashSet w = null;

    public i(a a2, String string) {
        this.p = a2;
    }

    static void f() {
        ++x;
    }

    public final void d(b b2) {
        int n2;
        int n3;
        for (n3 = 0; n3 < (n2 = this.r); ++n3) {
            if (this.q[n3] != b2) continue;
            return;
        }
        Object[] objectArray = this.q;
        if (n2 >= objectArray.length) {
            this.q = (b[])Arrays.copyOf((Object[])objectArray, (int)(objectArray.length * 2));
        }
        objectArray = this.q;
        n3 = this.r;
        objectArray[n3] = b2;
        this.r = n3 + 1;
    }

    public int e(i i2) {
        return this.i - i2.i;
    }

    public final void g(b bArray) {
        int n2 = this.r;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.q[i2] != bArray) continue;
            while (i2 < n2 - 1) {
                bArray = this.q;
                int n3 = i2 + 1;
                bArray[i2] = bArray[n3];
                i2 = n3;
            }
            --this.r;
            return;
        }
    }

    public void h() {
        this.h = null;
        this.p = a.k;
        this.k = 0;
        this.i = -1;
        this.j = -1;
        this.l = 0.0f;
        this.m = false;
        this.t = false;
        this.u = -1;
        this.v = 0.0f;
        int n2 = this.r;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.q[i2] = null;
        }
        this.r = 0;
        this.s = 0;
        this.g = false;
        Arrays.fill((float[])this.o, (float)0.0f);
    }

    public void i(d d3, float f2) {
        this.l = f2;
        this.m = true;
        this.t = false;
        this.u = -1;
        this.v = 0.0f;
        int n2 = this.r;
        this.j = -1;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.q[i2].A(d3, this, false);
        }
        this.r = 0;
    }

    public void j(a a2, String string) {
        this.p = a2;
    }

    public final void l(d d3, b b2) {
        int n2 = this.r;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.q[i2].B(d3, b2, false);
        }
        this.r = 0;
    }

    public String toString() {
        if (this.h != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(this.h);
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(this.i);
        return stringBuilder.toString();
    }

    public static final class a
    extends Enum {
        public static final /* enum */ a g = new a("UNRESTRICTED", 0);
        public static final /* enum */ a h = new a("CONSTANT", 1);
        public static final /* enum */ a i = new a("SLACK", 2);
        public static final /* enum */ a j = new a("ERROR", 3);
        public static final /* enum */ a k = new a("UNKNOWN", 4);
        private static final a[] l = a.d();

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private a() {
            void var2_-1;
            void var1_-1;
        }

        private static /* synthetic */ a[] d() {
            return new a[]{g, h, i, j, k};
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])l.clone();
        }
    }
}

