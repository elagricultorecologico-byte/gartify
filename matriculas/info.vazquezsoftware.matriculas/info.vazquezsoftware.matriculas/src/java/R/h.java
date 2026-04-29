/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.Comparator
 */
package r;

import java.util.Arrays;
import java.util.Comparator;
import r.b;
import r.c;
import r.d;
import r.i;

public class h
extends r.b {
    private int g = 128;
    private i[] h = new i[128];
    private i[] i = new i[128];
    private int j = 0;
    b k = new b(this, this);
    c l;

    public h(c c3) {
        super(c3);
        this.l = c3;
    }

    private void F(i i2) {
        int n2;
        int n3 = this.j;
        Object[] objectArray = this.h;
        if (n3 + 1 > objectArray.length) {
            objectArray = (i[])Arrays.copyOf((Object[])objectArray, (int)(objectArray.length * 2));
            this.h = objectArray;
            this.i = (i[])Arrays.copyOf((Object[])objectArray, (int)(objectArray.length * 2));
        }
        objectArray = this.h;
        n3 = this.j;
        objectArray[n3] = i2;
        this.j = n2 = n3 + 1;
        if (n2 > 1 && ((i)objectArray[n3]).i > i2.i) {
            int n4;
            n2 = 0;
            for (n3 = 0; n3 < (n4 = this.j); ++n3) {
                this.i[n3] = this.h[n3];
            }
            Arrays.sort((Object[])this.i, (int)0, (int)n4, (Comparator)new Comparator(this){
                final h g;
                {
                    this.g = h3;
                }

                public int a(i i2, i i3) {
                    return i2.i - i3.i;
                }
            });
            for (n3 = n2; n3 < this.j; ++n3) {
                this.h[n3] = this.i[n3];
            }
        }
        i2.g = true;
        i2.d(this);
    }

    private void G(i i2) {
        for (int i3 = 0; i3 < this.j; ++i3) {
            int n2;
            if (this.h[i3] != i2) continue;
            while (i3 < (n2 = this.j) - 1) {
                i[] iArray = this.h;
                n2 = i3 + 1;
                iArray[i3] = iArray[n2];
                i3 = n2;
            }
            this.j = n2 - 1;
            i2.g = false;
            return;
        }
    }

    @Override
    public void B(d object, r.b b2, boolean bl) {
        object = b2.a;
        if (object == null) {
            return;
        }
        b.a a2 = b2.e;
        int n2 = a2.f();
        for (int i2 = 0; i2 < n2; ++i2) {
            i i3 = a2.h(i2);
            float f2 = a2.a(i2);
            this.k.b(i3);
            if (this.k.a((i)object, f2)) {
                this.F(i3);
            }
            this.b += b2.b * f2;
        }
        this.G((i)object);
    }

    @Override
    public void b(i i2) {
        this.k.b(i2);
        this.k.e();
        i2.o[i2.k] = 1.0f;
        this.F(i2);
    }

    @Override
    public i c(d object, boolean[] blArray) {
        int n2 = -1;
        for (int i2 = 0; i2 < this.j; ++i2) {
            int n3;
            block6: {
                block8: {
                    block7: {
                        block5: {
                            object = this.h[i2];
                            if (!blArray[((i)object).i]) break block5;
                            n3 = n2;
                            break block6;
                        }
                        this.k.b((i)object);
                        if (n2 != -1) break block7;
                        n3 = n2;
                        if (!this.k.c()) break block6;
                        break block8;
                    }
                    n3 = n2;
                    if (!this.k.d(this.h[n2])) break block6;
                }
                n3 = i2;
            }
            n2 = n3;
        }
        if (n2 == -1) {
            return null;
        }
        return this.h[n2];
    }

    @Override
    public void clear() {
        this.j = 0;
        this.b = 0.0f;
    }

    @Override
    public boolean isEmpty() {
        return this.j == 0;
    }

    @Override
    public String toString() {
        Object object = new StringBuilder();
        object.append("");
        object.append(" goal -> (");
        object.append(this.b);
        object.append(") : ");
        object = object.toString();
        for (int i2 = 0; i2 < this.j; ++i2) {
            i i3 = this.h[i2];
            this.k.b(i3);
            i3 = new StringBuilder();
            i3.append((String)object);
            i3.append(this.k);
            i3.append(" ");
            object = i3.toString();
        }
        return object;
    }

    class b {
        i a;
        h b;
        final h c;

        b(h h3, h h4) {
            this.c = h3;
            this.b = h4;
        }

        public boolean a(i i2, float f2) {
            int n2;
            boolean bl = this.a.g;
            boolean bl2 = true;
            if (bl) {
                for (n2 = 0; n2 < 9; ++n2) {
                    float f3;
                    float[] fArray = this.a.o;
                    fArray[n2] = f3 = fArray[n2] + i2.o[n2] * f2;
                    if (Math.abs((float)f3) < 1.0E-4f) {
                        this.a.o[n2] = 0.0f;
                        continue;
                    }
                    bl2 = false;
                }
                if (bl2) {
                    this.c.G(this.a);
                }
                return false;
            }
            for (n2 = 0; n2 < 9; ++n2) {
                float f4 = i2.o[n2];
                if (f4 != 0.0f) {
                    float f5;
                    f4 = f5 = f4 * f2;
                    if (Math.abs((float)f5) < 1.0E-4f) {
                        f4 = 0.0f;
                    }
                    this.a.o[n2] = f4;
                    continue;
                }
                this.a.o[n2] = 0.0f;
            }
            return true;
        }

        public void b(i i2) {
            this.a = i2;
        }

        public final boolean c() {
            for (int i2 = 8; i2 >= 0; --i2) {
                float f2 = this.a.o[i2];
                if (f2 > 0.0f) {
                    return false;
                }
                if (!(f2 < 0.0f)) continue;
                return true;
            }
            return false;
        }

        public final boolean d(i i2) {
            for (int i3 = 8; i3 >= 0; --i3) {
                float f2 = this.a.o[i3];
                float f3 = i2.o[i3];
                if (f2 == f3) {
                    continue;
                }
                if (!(f2 < f3)) break;
                return true;
            }
            return false;
        }

        public void e() {
            Arrays.fill((float[])this.a.o, (float)0.0f);
        }

        public String toString() {
            String string;
            i i2 = this.a;
            String string2 = string = "[ ";
            if (i2 != null) {
                int n2 = 0;
                while (true) {
                    string2 = string;
                    if (n2 >= 9) break;
                    string2 = new StringBuilder();
                    string2.append(string);
                    string2.append(this.a.o[n2]);
                    string2.append(" ");
                    string = string2.toString();
                    ++n2;
                }
            }
            string = new StringBuilder();
            string.append(string2);
            string.append("] ");
            string.append((Object)this.a);
            return string.toString();
        }
    }
}

