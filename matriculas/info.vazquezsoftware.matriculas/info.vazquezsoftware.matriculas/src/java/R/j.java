/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 */
package r;

import java.util.Arrays;
import r.b;
import r.c;
import r.i;

public class j
implements b.a {
    private static float n = 0.001f;
    private final int a;
    private int b = 16;
    private int c = 16;
    int[] d = new int[16];
    int[] e = new int[16];
    int[] f = new int[16];
    float[] g = new float[16];
    int[] h = new int[16];
    int[] i = new int[16];
    int j = 0;
    int k = -1;
    private final b l;
    protected final c m;

    j(b b2, c c3) {
        this.a = -1;
        this.l = b2;
        this.m = c3;
        this.clear();
    }

    private void l(i object, int n2) {
        Object object2;
        int n3 = ((i)object).i % this.c;
        object = this.d;
        Object object3 = object2 = object[n3];
        if (object2 == -1) {
            object[n3] = n2;
        } else {
            while ((object2 = (object = (Object)this.e)[object3]) != -1) {
                object3 = object2;
            }
            object[object3] = n2;
        }
        this.e[n2] = -1;
    }

    private void m(int n2, i i2, float f2) {
        this.f[n2] = i2.i;
        this.g[n2] = f2;
        this.h[n2] = -1;
        this.i[n2] = -1;
        i2.d(this.l);
        ++i2.s;
        ++this.j;
    }

    private int n() {
        for (int i2 = 0; i2 < this.b; ++i2) {
            if (this.f[i2] != -1) continue;
            return i2;
        }
        return -1;
    }

    private void o() {
        int n2 = this.b * 2;
        this.f = Arrays.copyOf((int[])this.f, (int)n2);
        this.g = Arrays.copyOf((float[])this.g, (int)n2);
        this.h = Arrays.copyOf((int[])this.h, (int)n2);
        this.i = Arrays.copyOf((int[])this.i, (int)n2);
        this.e = Arrays.copyOf((int[])this.e, (int)n2);
        for (int i2 = this.b; i2 < n2; ++i2) {
            this.f[i2] = -1;
            this.e[i2] = -1;
        }
        this.b = n2;
    }

    private void q(int n2, i i2, float f2) {
        int n3 = this.n();
        this.m(n3, i2, f2);
        if (n2 != -1) {
            this.h[n3] = n2;
            int[] nArray = this.i;
            nArray[n3] = nArray[n2];
            nArray[n2] = n3;
        } else {
            this.h[n3] = -1;
            if (this.j > 0) {
                this.i[n3] = this.k;
                this.k = n3;
            } else {
                this.i[n3] = -1;
            }
        }
        n2 = this.i[n3];
        if (n2 != -1) {
            this.h[n2] = n3;
        }
        this.l(i2, n3);
    }

    private void r(i object) {
        object = this.d;
        int n2 = ((i)object).i;
        int n3 = n2 % this.c;
        Object object2 = object[n3];
        if (object2 != -1) {
            Object object3 = object2;
            if (this.f[object2] == n2) {
                int[] nArray = this.e;
                object[n3] = nArray[object2];
                nArray[object2] = -1;
                return;
            }
            while ((object2 = (object = (Object)this.e)[object3]) != -1 && this.f[object2] != n2) {
                object3 = object2;
            }
            if (object2 != -1 && this.f[object2] == n2) {
                object[object3] = object[object2];
                object[object2] = -1;
            }
        }
    }

    @Override
    public float a(int n2) {
        int n3 = this.j;
        int n4 = this.k;
        for (int i2 = 0; i2 < n3; ++i2) {
            if (i2 == n2) {
                return this.g[n4];
            }
            if ((n4 = this.i[n4]) == -1) break;
        }
        return 0.0f;
    }

    @Override
    public boolean b(i i2) {
        return this.p(i2) != -1;
    }

    @Override
    public float c(i i2) {
        int n2 = this.p(i2);
        if (n2 != -1) {
            return this.g[n2];
        }
        return 0.0f;
    }

    @Override
    public void clear() {
        int n2;
        int n3 = this.j;
        for (n2 = 0; n2 < n3; ++n2) {
            i i2 = this.h(n2);
            if (i2 == null) continue;
            i2.g(this.l);
        }
        for (n2 = 0; n2 < this.b; ++n2) {
            this.f[n2] = -1;
            this.e[n2] = -1;
        }
        for (n2 = 0; n2 < this.c; ++n2) {
            this.d[n2] = -1;
        }
        this.j = 0;
        this.k = -1;
    }

    @Override
    public void d(i i2, float f2) {
        int n2;
        float f3 = n;
        if (f2 > -f3 && f2 < f3) {
            this.g(i2, true);
            return;
        }
        int n3 = this.j;
        int n4 = 0;
        if (n3 == 0) {
            this.m(0, i2, f2);
            this.l(i2, 0);
            this.k = 0;
            return;
        }
        n3 = this.p(i2);
        if (n3 != -1) {
            this.g[n3] = f2;
            return;
        }
        if (this.j + 1 >= this.b) {
            this.o();
        }
        int n5 = this.j;
        n3 = this.k;
        int n6 = -1;
        while (true) {
            n2 = n6;
            if (n4 >= n5) break;
            n2 = this.f[n3];
            int n7 = i2.i;
            if (n2 == n7) {
                this.g[n3] = f2;
                return;
            }
            if (n2 < n7) {
                n6 = n3;
            }
            if ((n3 = this.i[n3]) == -1) {
                n2 = n6;
                break;
            }
            ++n4;
        }
        this.q(n2, i2, f2);
    }

    @Override
    public float e(b object, boolean bl) {
        float f2 = this.c(((b)object).a);
        this.g(((b)object).a, bl);
        object = (j)((b)object).e;
        int n2 = ((j)object).f();
        int n3 = 0;
        int n4 = 0;
        while (n3 < n2) {
            int n5 = ((j)object).f[n4];
            int n6 = n3;
            if (n5 != -1) {
                float f3 = ((j)object).g[n4];
                this.i(this.m.d[n5], f3 * f2, bl);
                n6 = n3 + 1;
            }
            ++n4;
            n3 = n6;
        }
        return f2;
    }

    @Override
    public int f() {
        return this.j;
    }

    @Override
    public float g(i i2, boolean bl) {
        int n2 = this.p(i2);
        if (n2 == -1) {
            return 0.0f;
        }
        this.r(i2);
        float f2 = this.g[n2];
        if (this.k == n2) {
            this.k = this.i[n2];
        }
        this.f[n2] = -1;
        int[] nArray = this.h;
        int n3 = nArray[n2];
        if (n3 != -1) {
            int[] nArray2 = this.i;
            nArray2[n3] = nArray2[n2];
        }
        if ((n3 = this.i[n2]) != -1) {
            nArray[n3] = nArray[n2];
        }
        --this.j;
        --i2.s;
        if (bl) {
            i2.g(this.l);
        }
        return f2;
    }

    @Override
    public i h(int n2) {
        int n3 = this.j;
        if (n3 == 0) {
            return null;
        }
        int n4 = this.k;
        for (int i2 = 0; i2 < n3; ++i2) {
            if (i2 == n2 && n4 != -1) {
                return this.m.d[this.f[n4]];
            }
            if ((n4 = this.i[n4]) == -1) break;
        }
        return null;
    }

    @Override
    public void i(i i2, float f2, boolean bl) {
        float f3 = n;
        if (!(f2 > -f3) || !(f2 < f3)) {
            int n2 = this.p(i2);
            if (n2 == -1) {
                this.d(i2, f2);
                return;
            }
            float[] fArray = this.g;
            fArray[n2] = f3 = fArray[n2] + f2;
            f2 = n;
            if (f3 > -f2 && f3 < f2) {
                fArray[n2] = 0.0f;
                this.g(i2, bl);
            }
        }
    }

    @Override
    public void j(float f2) {
        int n2 = this.j;
        int n3 = this.k;
        for (int i2 = 0; i2 < n2; ++i2) {
            float[] fArray = this.g;
            fArray[n3] = fArray[n3] / f2;
            if ((n3 = this.i[n3]) == -1) break;
        }
    }

    @Override
    public void k() {
        int n2 = this.j;
        int n3 = this.k;
        for (int i2 = 0; i2 < n2; ++i2) {
            float[] fArray = this.g;
            fArray[n3] = fArray[n3] * -1.0f;
            if ((n3 = this.i[n3]) == -1) break;
        }
    }

    public int p(i i2) {
        if (this.j != 0 && i2 != null) {
            int n2 = i2.i;
            int n3 = this.c;
            int n4 = this.d[n2 % n3];
            if (n4 == -1) {
                return -1;
            }
            n3 = n4;
            if (this.f[n4] == n2) {
                return n4;
            }
            while ((n3 = this.e[n3]) != -1 && this.f[n3] != n2) {
            }
            if (n3 == -1) {
                return -1;
            }
            if (this.f[n3] == n2) {
                return n3;
            }
        }
        return -1;
    }

    public String toString() {
        i i2;
        Object object = new StringBuilder();
        object.append(this.hashCode());
        object.append(" { ");
        object = object.toString();
        int n2 = this.j;
        for (int i3 = 0; i3 < n2; ++i3) {
            i2 = this.h(i3);
            if (i2 == null) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            stringBuilder.append((Object)i2);
            stringBuilder.append(" = ");
            stringBuilder.append(this.a(i3));
            stringBuilder.append(" ");
            object = stringBuilder.toString();
            int n3 = this.p(i2);
            i2 = new StringBuilder();
            i2.append((String)object);
            i2.append("[p: ");
            object = i2.toString();
            if (this.h[n3] != -1) {
                i2 = new StringBuilder();
                i2.append((String)object);
                i2.append(this.m.d[this.f[this.h[n3]]]);
                object = i2.toString();
            } else {
                i2 = new StringBuilder();
                i2.append((String)object);
                i2.append("none");
                object = i2.toString();
            }
            i2 = new StringBuilder();
            i2.append((String)object);
            i2.append(", n: ");
            object = i2.toString();
            if (this.i[n3] != -1) {
                i2 = new StringBuilder();
                i2.append((String)object);
                i2.append(this.m.d[this.f[this.i[n3]]]);
                object = i2.toString();
            } else {
                i2 = new StringBuilder();
                i2.append((String)object);
                i2.append("none");
                object = i2.toString();
            }
            i2 = new StringBuilder();
            i2.append((String)object);
            i2.append("]");
            object = i2.toString();
        }
        i2 = new StringBuilder();
        i2.append((String)object);
        i2.append(" }");
        return i2.toString();
    }
}

