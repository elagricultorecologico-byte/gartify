/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.ArrayList
 *  java.util.Arrays
 *  v.i
 *  v.o
 */
package u;

import java.util.ArrayList;
import java.util.Arrays;
import u.e;
import u.f;
import u.i;
import v.o;

public abstract class j
extends e
implements i {
    public e[] L0 = new e[4];
    public int M0 = 0;

    @Override
    public void a(e e2) {
        if (e2 != this && e2 != null) {
            int n2 = this.M0;
            Object[] objectArray = this.L0;
            if (n2 + 1 > objectArray.length) {
                this.L0 = (e[])Arrays.copyOf((Object[])objectArray, (int)(objectArray.length * 2));
            }
            objectArray = this.L0;
            n2 = this.M0;
            objectArray[n2] = e2;
            this.M0 = n2 + 1;
        }
    }

    @Override
    public void b(f f2) {
    }

    @Override
    public void c() {
        this.M0 = 0;
        Arrays.fill((Object[])this.L0, null);
    }

    public void s1(ArrayList arrayList, int n2, o o2) {
        int n3 = 0;
        int n4 = 0;
        while (true) {
            if (n4 >= this.M0) break;
            o2.a(this.L0[n4]);
            ++n4;
        }
        for (int i2 = n3; i2 < this.M0; ++i2) {
            v.i.a((e)this.L0[i2], (int)n2, (ArrayList)arrayList, (o)o2);
        }
    }

    public int t1(int n2) {
        for (int i2 = 0; i2 < this.M0; ++i2) {
            int n3;
            e e2 = this.L0[i2];
            if (n2 == 0 && (n3 = e2.I0) != -1) {
                return n3;
            }
            if (n2 != 1 || (n3 = e2.J0) == -1) continue;
            return n3;
        }
        return -1;
    }
}

