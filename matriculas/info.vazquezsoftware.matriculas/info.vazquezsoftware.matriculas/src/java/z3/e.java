/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Comparable
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.charset.Charset
 *  java.security.MessageDigest
 *  java.util.Arrays
 */
package z3;

import I2.i;
import V2.g;
import V2.k;
import b3.h;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import z3.A;
import z3.B;
import z3.C;
import z3.b;

public class e
implements Serializable,
Comparable {
    public static final a j = new a(null);
    public static final e k = new e(new byte[0]);
    private final byte[] g;
    private transient int h;
    private transient String i;

    public e(byte[] byArray) {
        V2.k.e(byArray, "data");
        this.g = byArray;
    }

    public String d() {
        return A.b(this.h(), null, 1, null);
    }

    public int e(e e2) {
        V2.k.e(e2, "other");
        int n2 = this.u();
        int n3 = e2.u();
        int n4 = Math.min((int)n2, (int)n3);
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5;
            int n6 = this.g(i2) & 0xFF;
            if (n6 == (n5 = e2.g(i2) & 0xFF)) {
                continue;
            }
            if (n6 < n5) {
                return -1;
            }
            return 1;
        }
        if (n2 == n3) {
            return 0;
        }
        if (n2 < n3) {
            return -1;
        }
        return 1;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        return object instanceof e && ((e)(object = (e)object)).u() == this.h().length && ((e)object).q(0, this.h(), 0, this.h().length);
    }

    public e f(String object) {
        V2.k.e(object, "algorithm");
        object = MessageDigest.getInstance((String)object);
        object.update(this.h(), 0, this.u());
        object = object.digest();
        V2.k.d(object, "digestBytes");
        return new e((byte[])object);
    }

    public final byte g(int n2) {
        return this.o(n2);
    }

    public final byte[] h() {
        return this.g;
    }

    public int hashCode() {
        int n2 = this.i();
        if (n2 != 0) {
            return n2;
        }
        n2 = Arrays.hashCode((byte[])this.h());
        this.r(n2);
        return n2;
    }

    public final int i() {
        return this.h;
    }

    public int j() {
        return this.h().length;
    }

    public final String l() {
        return this.i;
    }

    public String m() {
        char[] cArray = new char[this.h().length * 2];
        byte[] byArray = this.h();
        int n2 = byArray.length;
        int n3 = 0;
        int n4 = 0;
        while (true) {
            int n5 = n4;
            if (n3 >= n2) break;
            byte by = byArray[n3];
            ++n3;
            cArray[n5] = A3.b.f()[by >> 4 & 0xF];
            n4 = n5 + 2;
            cArray[n5 + 1] = A3.b.f()[by & 0xF];
        }
        return b3.h.q(cArray);
    }

    public byte[] n() {
        return this.h();
    }

    public byte o(int n2) {
        return this.h()[n2];
    }

    public boolean p(int n2, e e2, int n3, int n4) {
        V2.k.e(e2, "other");
        return e2.q(n3, this.h(), n2, n4);
    }

    public boolean q(int n2, byte[] byArray, int n3, int n4) {
        V2.k.e(byArray, "other");
        return n2 >= 0 && n2 <= this.h().length - n4 && n3 >= 0 && n3 <= byArray.length - n4 && C.a(this.h(), n2, byArray, n3, n4);
    }

    public final void r(int n2) {
        this.h = n2;
    }

    public final void s(String string) {
        this.i = string;
    }

    public final e t() {
        return this.f("SHA-256");
    }

    public String toString() {
        if (this.h().length == 0) {
            return "[size=0]";
        }
        int n2 = A3.b.a(this.h(), 64);
        if (n2 == -1) {
            if (this.h().length <= 64) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("[hex=");
                stringBuilder.append(this.m());
                stringBuilder.append(']');
                return stringBuilder.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[size=");
            stringBuilder.append(this.h().length);
            stringBuilder.append(" hex=");
            int n3 = C.c(this, 64);
            n2 = this.h().length;
            int n4 = 1;
            n2 = n3 <= n2 ? 1 : 0;
            if (n2 != 0) {
                n2 = n3 >= 0 ? n4 : 0;
                if (n2 != 0) {
                    e e2 = n3 == this.h().length ? this : new e(I2.i.k(this.h(), 0, n3));
                    stringBuilder.append(e2.m());
                    stringBuilder.append("\u2026]");
                    return stringBuilder.toString();
                }
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("endIndex > length(");
            stringBuilder2.append(this.h().length);
            stringBuilder2.append(')');
            throw new IllegalArgumentException(stringBuilder2.toString().toString());
        }
        String string = this.x();
        if (string != null) {
            String string2 = string.substring(0, n2);
            V2.k.d(string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            string2 = b3.h.A(b3.h.A(b3.h.A(string2, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
            if (n2 < string.length()) {
                string = new StringBuilder();
                string.append("[size=");
                string.append(this.h().length);
                string.append(" text=");
                string.append(string2);
                string.append("\u2026]");
                return string.toString();
            }
            string = new StringBuilder();
            string.append("[text=");
            string.append(string2);
            string.append(']');
            return string.toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final int u() {
        return this.j();
    }

    public final boolean v(e e2) {
        V2.k.e(e2, "prefix");
        return this.p(0, e2, 0, e2.u());
    }

    public e w() {
        for (int i2 = 0; i2 < this.h().length; ++i2) {
            byte by;
            byte by2;
            byte by3 = this.h()[i2];
            if (by3 < (by2 = (byte)65) || by3 > (by = (byte)90)) continue;
            byte[] byArray = this.h();
            byArray = Arrays.copyOf((byte[])byArray, (int)byArray.length);
            V2.k.d(byArray, "java.util.Arrays.copyOf(this, size)");
            int n2 = i2 + 1;
            byArray[i2] = (byte)(by3 + 32);
            for (i2 = n2; i2 < byArray.length; ++i2) {
                n2 = byArray[i2];
                if (n2 < by2 || n2 > by) continue;
                byArray[i2] = (byte)(n2 + 32);
            }
            return new e(byArray);
        }
        return this;
    }

    public String x() {
        String string;
        String string2 = string = this.l();
        if (string == null) {
            string2 = B.b(this.n());
            this.s(string2);
        }
        return string2;
    }

    public void y(b b2, int n2, int n3) {
        V2.k.e(b2, "buffer");
        A3.b.d(this, b2, n2, n3);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public static /* synthetic */ e e(a a2, byte[] byArray, int n2, int n3, int n4, Object object) {
            if ((n4 & 1) != 0) {
                n2 = 0;
            }
            if ((n4 & 2) != 0) {
                n3 = byArray.length;
            }
            return a2.d(byArray, n2, n3);
        }

        public final e a(String string) {
            V2.k.e(string, "<this>");
            int n2 = string.length();
            int n3 = 0;
            n2 = n2 % 2 == 0 ? 1 : 0;
            if (n2 != 0) {
                n2 = string.length() / 2;
                byte[] byArray = new byte[n2];
                int n4 = n2 - 1;
                if (n4 >= 0) {
                    n2 = n3;
                    while (true) {
                        n3 = n2 + 1;
                        int n5 = n2 * 2;
                        byArray[n2] = (byte)((A3.b.b(string.charAt(n5)) << 4) + A3.b.b(string.charAt(n5 + 1)));
                        if (n3 > n4) break;
                        n2 = n3;
                    }
                }
                return new e(byArray);
            }
            throw new IllegalArgumentException(V2.k.j("Unexpected hex string: ", string).toString());
        }

        public final e b(String object, Charset charset) {
            V2.k.e(object, "<this>");
            V2.k.e(charset, "charset");
            object = object.getBytes(charset);
            V2.k.d(object, "(this as java.lang.String).getBytes(charset)");
            return new e((byte[])object);
        }

        public final e c(String string) {
            V2.k.e(string, "<this>");
            e e2 = new e(B.a(string));
            e2.s(string);
            return e2;
        }

        public final e d(byte[] byArray, int n2, int n3) {
            V2.k.e(byArray, "<this>");
            C.b(byArray.length, n2, n3);
            return new e(I2.i.k(byArray, n2, n3 + n2));
        }
    }
}

