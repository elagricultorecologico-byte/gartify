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

public class a
implements b.a {
    private static float l = 0.001f;
    int a = 0;
    private final b b;
    protected final c c;
    private int d = 8;
    private i e = null;
    private int[] f = new int[8];
    private int[] g = new int[8];
    private float[] h = new float[8];
    private int i = -1;
    private int j = -1;
    private boolean k = false;

    a(b b2, c c3) {
        this.b = b2;
        this.c = c3;
    }

    @Override
    public float a(int n2) {
        int n3 = this.i;
        for (int i2 = 0; n3 != -1 && i2 < this.a; ++i2) {
            if (i2 == n2) {
                return this.h[n3];
            }
            n3 = this.g[n3];
        }
        return 0.0f;
    }

    @Override
    public boolean b(i i2) {
        int n2 = this.i;
        if (n2 == -1) {
            return false;
        }
        for (int i3 = 0; n2 != -1 && i3 < this.a; ++i3) {
            if (this.f[n2] == i2.i) {
                return true;
            }
            n2 = this.g[n2];
        }
        return false;
    }

    @Override
    public final float c(i i2) {
        int n2 = this.i;
        for (int i3 = 0; n2 != -1 && i3 < this.a; ++i3) {
            if (this.f[n2] == i2.i) {
                return this.h[n2];
            }
            n2 = this.g[n2];
        }
        return 0.0f;
    }

    @Override
    public final void clear() {
        int n2 = this.i;
        for (int i2 = 0; n2 != -1 && i2 < this.a; ++i2) {
            i i3 = this.c.d[this.f[n2]];
            if (i3 != null) {
                i3.g(this.b);
            }
            n2 = this.g[n2];
        }
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.a = 0;
    }

    @Override
    public final void d(i object, float f2) {
        if (f2 == 0.0f) {
            this.g((i)object, true);
            return;
        }
        int n2 = this.i;
        if (n2 == -1) {
            this.i = 0;
            this.h[0] = f2;
            this.f[0] = ((i)object).i;
            this.g[0] = -1;
            ++((i)object).s;
            ((i)object).d(this.b);
            ++this.a;
            if (!this.k) {
                this.j = n2 = this.j + 1;
                object = this.f;
                if (n2 >= ((Object)object).length) {
                    this.k = true;
                    this.j = ((Object)object).length - 1;
                    return;
                }
            }
        } else {
            int[] nArray;
            int n3;
            int n4;
            int n5 = -1;
            for (n4 = 0; n2 != -1 && n4 < this.a; ++n4) {
                n3 = this.f[n2];
                int n6 = ((i)object).i;
                if (n3 == n6) {
                    this.h[n2] = f2;
                    return;
                }
                if (n3 < n6) {
                    n5 = n2;
                }
                n2 = this.g[n2];
            }
            n2 = this.j;
            if (this.k) {
                nArray = this.f;
                if (nArray[n2] != -1) {
                    n2 = nArray.length;
                }
            } else {
                ++n2;
            }
            nArray = this.f;
            n4 = n2;
            if (n2 >= nArray.length) {
                n4 = n2;
                if (this.a < nArray.length) {
                    n3 = 0;
                    while (true) {
                        nArray = this.f;
                        n4 = n2;
                        if (n3 >= nArray.length) break;
                        if (nArray[n3] == -1) {
                            n4 = n3;
                            break;
                        }
                        ++n3;
                    }
                }
            }
            nArray = this.f;
            n2 = n4;
            if (n4 >= nArray.length) {
                n2 = nArray.length;
                this.d = n4 = this.d * 2;
                this.k = false;
                this.j = n2 - 1;
                this.h = Arrays.copyOf((float[])this.h, (int)n4);
                this.f = Arrays.copyOf((int[])this.f, (int)this.d);
                this.g = Arrays.copyOf((int[])this.g, (int)this.d);
            }
            this.f[n2] = ((i)object).i;
            this.h[n2] = f2;
            if (n5 != -1) {
                nArray = this.g;
                nArray[n2] = nArray[n5];
                nArray[n5] = n2;
            } else {
                this.g[n2] = this.i;
                this.i = n2;
            }
            ++((i)object).s;
            ((i)object).d(this.b);
            this.a = n2 = this.a + 1;
            if (!this.k) {
                ++this.j;
            }
            if (n2 >= ((Object)(object = (Object)this.f)).length) {
                this.k = true;
            }
            if (this.j >= ((Object)object).length) {
                this.k = true;
                this.j = ((Object)object).length - 1;
            }
        }
    }

    @Override
    public float e(b object, boolean bl) {
        float f2 = this.c(((b)object).a);
        this.g(((b)object).a, bl);
        object = ((b)object).e;
        int n2 = object.f();
        for (int i2 = 0; i2 < n2; ++i2) {
            i i3 = object.h(i2);
            this.i(i3, object.c(i3) * f2, bl);
        }
        return f2;
    }

    @Override
    public int f() {
        return this.a;
    }

    @Override
    public final float g(i i2, boolean bl) {
        int n2;
        if (this.e == i2) {
            this.e = null;
        }
        if ((n2 = this.i) == -1) {
            return 0.0f;
        }
        int n3 = -1;
        for (int i3 = 0; n2 != -1 && i3 < this.a; ++i3) {
            if (this.f[n2] == i2.i) {
                if (n2 == this.i) {
                    this.i = this.g[n2];
                } else {
                    int[] nArray = this.g;
                    nArray[n3] = nArray[n2];
                }
                if (bl) {
                    i2.g(this.b);
                }
                --i2.s;
                --this.a;
                this.f[n2] = -1;
                if (this.k) {
                    this.j = n2;
                }
                return this.h[n2];
            }
            int n4 = this.g[n2];
            n3 = n2;
            n2 = n4;
        }
        return 0.0f;
    }

    @Override
    public i h(int n2) {
        int n3 = this.i;
        for (int i2 = 0; n3 != -1 && i2 < this.a; ++i2) {
            if (i2 == n2) {
                return this.c.d[this.f[n3]];
            }
            n3 = this.g[n3];
        }
        return null;
    }

    @Override
    public void i(i object, float f2, boolean bl) {
        block27: {
            float f3 = l;
            if (!(f2 > -f3) || !(f2 < f3)) {
                int n2 = this.i;
                if (n2 == -1) {
                    this.i = 0;
                    this.h[0] = f2;
                    this.f[0] = ((i)object).i;
                    this.g[0] = -1;
                    ++((i)object).s;
                    ((i)object).d(this.b);
                    ++this.a;
                    if (!this.k) {
                        this.j = n2 = this.j + 1;
                        object = this.f;
                        if (n2 >= ((Object)object).length) {
                            this.k = true;
                            this.j = ((Object)object).length - 1;
                            return;
                        }
                    }
                } else {
                    int[] nArray;
                    int n3;
                    int n4;
                    int n5 = -1;
                    for (n4 = 0; n2 != -1 && n4 < this.a; ++n4) {
                        n3 = this.f[n2];
                        int n6 = ((i)object).i;
                        if (n3 == n6) {
                            Object[] objectArray = this.h;
                            f3 = objectArray[n2] + f2;
                            float f4 = l;
                            f2 = f3;
                            if (f3 > -f4) {
                                f2 = f3;
                                if (f3 < f4) {
                                    f2 = 0.0f;
                                }
                            }
                            objectArray[n2] = f2;
                            if (f2 == 0.0f) {
                                if (n2 == this.i) {
                                    this.i = this.g[n2];
                                } else {
                                    objectArray = this.g;
                                    objectArray[n5] = objectArray[n2];
                                }
                                if (bl) {
                                    ((i)object).g(this.b);
                                }
                                if (this.k) {
                                    this.j = n2;
                                }
                                --((i)object).s;
                                --this.a;
                                return;
                            }
                            break block27;
                        }
                        if (n3 < n6) {
                            n5 = n2;
                        }
                        n2 = this.g[n2];
                    }
                    n2 = this.j;
                    if (this.k) {
                        nArray = this.f;
                        if (nArray[n2] != -1) {
                            n2 = nArray.length;
                        }
                    } else {
                        ++n2;
                    }
                    nArray = this.f;
                    n4 = n2;
                    if (n2 >= nArray.length) {
                        n4 = n2;
                        if (this.a < nArray.length) {
                            n3 = 0;
                            while (true) {
                                nArray = this.f;
                                n4 = n2;
                                if (n3 >= nArray.length) break;
                                if (nArray[n3] == -1) {
                                    n4 = n3;
                                    break;
                                }
                                ++n3;
                            }
                        }
                    }
                    nArray = this.f;
                    n2 = n4;
                    if (n4 >= nArray.length) {
                        n2 = nArray.length;
                        this.d = n4 = this.d * 2;
                        this.k = false;
                        this.j = n2 - 1;
                        this.h = Arrays.copyOf((float[])this.h, (int)n4);
                        this.f = Arrays.copyOf((int[])this.f, (int)this.d);
                        this.g = Arrays.copyOf((int[])this.g, (int)this.d);
                    }
                    this.f[n2] = ((i)object).i;
                    this.h[n2] = f2;
                    if (n5 != -1) {
                        nArray = this.g;
                        nArray[n2] = nArray[n5];
                        nArray[n5] = n2;
                    } else {
                        this.g[n2] = this.i;
                        this.i = n2;
                    }
                    ++((i)object).s;
                    ((i)object).d(this.b);
                    ++this.a;
                    if (!this.k) {
                        ++this.j;
                    }
                    if ((n2 = this.j) >= ((Object)(object = (Object)this.f)).length) {
                        this.k = true;
                        this.j = ((Object)object).length - 1;
                    }
                }
            }
        }
    }

    @Override
    public void j(float f2) {
        int n2 = this.i;
        for (int i2 = 0; n2 != -1 && i2 < this.a; ++i2) {
            float[] fArray = this.h;
            fArray[n2] = fArray[n2] / f2;
            n2 = this.g[n2];
        }
    }

    @Override
    public void k() {
        int n2 = this.i;
        for (int i2 = 0; n2 != -1 && i2 < this.a; ++i2) {
            float[] fArray = this.h;
            fArray[n2] = fArray[n2] * -1.0f;
            n2 = this.g[n2];
        }
    }

    public String toString() {
        int n2 = this.i;
        String string = "";
        for (int i2 = 0; n2 != -1 && i2 < this.a; ++i2) {
            Object object = new StringBuilder();
            object.append(string);
            object.append(" -> ");
            object = object.toString();
            string = new StringBuilder();
            string.append((String)object);
            string.append(this.h[n2]);
            string.append(" : ");
            string = string.toString();
            object = new StringBuilder();
            object.append(string);
            object.append((Object)this.c.d[this.f[n2]]);
            string = object.toString();
            n2 = this.g[n2];
        }
        return string;
    }
}

