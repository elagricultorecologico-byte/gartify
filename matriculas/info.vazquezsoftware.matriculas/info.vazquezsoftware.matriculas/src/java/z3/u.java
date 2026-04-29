/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.security.MessageDigest
 */
package z3;

import A3.c;
import I2.i;
import V2.k;
import java.security.MessageDigest;
import z3.C;
import z3.b;
import z3.e;
import z3.s;

public final class u
extends e {
    private final transient byte[][] l;
    private final transient int[] m;

    public u(byte[][] byArray, int[] nArray) {
        V2.k.e(byArray, "segments");
        V2.k.e(nArray, "directory");
        super(e.k.h());
        this.l = byArray;
        this.m = nArray;
    }

    private final e C() {
        return new e(this.B());
    }

    public final byte[][] A() {
        return this.l;
    }

    public byte[] B() {
        byte[] byArray = new byte[this.u()];
        int n2 = this.A().length;
        int n3 = 0;
        int n4 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n5 = this.z()[n2 + i2];
            int n6 = this.z()[i2];
            byte[] byArray2 = this.A()[i2];
            n3 = n6 - n3;
            i.d(byArray2, byArray, n4, n5, n5 + n3);
            n4 += n3;
            n3 = n6;
        }
        return byArray;
    }

    @Override
    public String d() {
        return this.C().d();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        return object instanceof e && ((e)(object = (e)object)).u() == this.u() && this.p(0, (e)object, 0, this.u());
    }

    @Override
    public e f(String object) {
        V2.k.e(object, "algorithm");
        object = MessageDigest.getInstance((String)object);
        int n2 = this.A().length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4 = this.z()[n2 + i2];
            int n5 = this.z()[i2];
            object.update(this.A()[i2], n4, n5 - n3);
            n3 = n5;
        }
        object = object.digest();
        V2.k.d(object, "digestBytes");
        return new e((byte[])object);
    }

    @Override
    public int hashCode() {
        int n2 = this.i();
        if (n2 != 0) {
            return n2;
        }
        int n3 = this.A().length;
        int n4 = 1;
        int n5 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n6 = this.z()[n3 + i2];
            int n7 = this.z()[i2];
            byte[] byArray = this.A()[i2];
            for (n2 = n6; n2 < n7 - n5 + n6; ++n2) {
                n4 = n4 * 31 + byArray[n2];
            }
            n5 = n7;
        }
        this.r(n4);
        return n4;
    }

    @Override
    public int j() {
        return this.z()[this.A().length - 1];
    }

    @Override
    public String m() {
        return this.C().m();
    }

    @Override
    public byte[] n() {
        return this.B();
    }

    @Override
    public byte o(int n2) {
        C.b(this.z()[this.A().length - 1], n2, 1L);
        int n3 = c.b(this, n2);
        int n4 = n3 == 0 ? 0 : this.z()[n3 - 1];
        int n5 = this.z()[this.A().length + n3];
        return this.A()[n3][n2 - n4 + n5];
    }

    @Override
    public boolean p(int n2, e e2, int n3, int n4) {
        V2.k.e(e2, "other");
        if (n2 >= 0 && n2 <= this.u() - n4) {
            int n5 = n4 + n2;
            n4 = c.b(this, n2);
            while (n2 < n5) {
                int n6 = n4 == 0 ? 0 : this.z()[n4 - 1];
                int n7 = this.z()[n4];
                int n8 = this.z()[this.A().length + n4];
                n7 = Math.min((int)n5, (int)(n7 - n6 + n6)) - n2;
                if (!e2.q(n3, this.A()[n4], n8 + (n2 - n6), n7)) {
                    return false;
                }
                n3 += n7;
                n2 += n7;
                ++n4;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean q(int n2, byte[] byArray, int n3, int n4) {
        V2.k.e(byArray, "other");
        if (n2 >= 0 && n2 <= this.u() - n4 && n3 >= 0 && n3 <= byArray.length - n4) {
            int n5 = n4 + n2;
            n4 = c.b(this, n2);
            while (n2 < n5) {
                int n6 = n4 == 0 ? 0 : this.z()[n4 - 1];
                int n7 = this.z()[n4];
                int n8 = this.z()[this.A().length + n4];
                n7 = Math.min((int)n5, (int)(n7 - n6 + n6)) - n2;
                if (!C.a(this.A()[n4], n8 + (n2 - n6), byArray, n3, n7)) {
                    return false;
                }
                n3 += n7;
                n2 += n7;
                ++n4;
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.C().toString();
    }

    @Override
    public e w() {
        return this.C().w();
    }

    @Override
    public void y(b b2, int n2, int n3) {
        V2.k.e(b2, "buffer");
        int n4 = n2 + n3;
        int n5 = c.b(this, n2);
        while (n2 < n4) {
            int n6 = n5 == 0 ? 0 : this.z()[n5 - 1];
            int n7 = this.z()[n5];
            int n8 = this.z()[this.A().length + n5];
            n7 = Math.min((int)n4, (int)(n7 - n6 + n6)) - n2;
            n6 = n8 + (n2 - n6);
            s s2 = new s(this.A()[n5], n6, n6 + n7, true, false);
            s s3 = b2.g;
            if (s3 == null) {
                s2.g = s2;
                s2.f = s2;
                b2.g = s2;
            } else {
                V2.k.b(s3);
                s3 = s3.g;
                V2.k.b(s3);
                s3.c(s2);
            }
            n2 += n7;
            ++n5;
        }
        b2.s0(b2.A0() + (long)n3);
    }

    public final int[] z() {
        return this.m;
    }
}

