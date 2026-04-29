/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 */
package G3;

import G3.a;
import G3.d;
import G3.e;
import G3.i;
import G3.l;
import java.util.Arrays;

final class k {
    private static final char[] r;
    static final int[] s;
    private final a a;
    private final e b;
    private l c = G3.l.g;
    private i d;
    private boolean e = false;
    private String f = null;
    private StringBuilder g = new StringBuilder(1024);
    StringBuilder h = new StringBuilder(1024);
    i.i i;
    i.h j = new i.h();
    i.g k = new i.g();
    i.c l = new i.c();
    i.e m = new i.e();
    i.d n = new i.d();
    private String o;
    private final int[] p = new int[1];
    private final int[] q = new int[2];

    static {
        char[] cArray;
        char[] cArray2 = cArray = new char[7];
        cArray[0] = 9;
        cArray2[1] = 10;
        cArray2[2] = 13;
        cArray2[3] = 12;
        cArray2[4] = 32;
        cArray2[5] = 60;
        cArray2[6] = 38;
        r = cArray;
        s = new int[]{8364, 129, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143, 144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 157, 382, 376};
        Arrays.sort((char[])cArray);
    }

    k(a a2, e e2) {
        this.a = a2;
        this.b = e2;
    }

    private void c(String string) {
        if (this.b.c()) {
            this.b.add(new d(this.a.I(), "Invalid character reference: %s", string));
        }
    }

    void a(l l2) {
        this.a.a();
        this.c = l2;
    }

    String b() {
        return this.o;
    }

    int[] d(Character object, boolean bl) {
        int n2;
        if (this.a.u()) {
            return null;
        }
        if (object != null && object.charValue() == this.a.t()) {
            return null;
        }
        if (this.a.C(r)) {
            return null;
        }
        Object object2 = this.p;
        this.a.w();
        if (this.a.x("#")) {
            bl = this.a.y("X");
            object = this.a;
            object = bl ? object.i() : object.h();
            if (object.length() == 0) {
                this.c("numeric reference with no numerals");
                this.a.K();
                return null;
            }
            this.a.M();
            if (!this.a.x(";")) {
                this.c("missing semicolon");
            }
            int n3 = bl ? 16 : 10;
            try {
                n3 = Integer.valueOf((String)object, (int)n3);
            }
            catch (NumberFormatException numberFormatException) {
                n3 = -1;
            }
            if (n3 != -1 && (n3 < 55296 || n3 > 57343) && n3 <= 0x10FFFF) {
                Object object3 = n3;
                if (n3 >= 128) {
                    object = s;
                    object3 = n3;
                    if (n3 < ((Character)object).length + 128) {
                        this.c("character is not a valid unicode code point");
                        object3 = object[n3 - 128];
                    }
                }
                object2[0] = object3;
            } else {
                this.c("character outside of valid range");
                object2[0] = 65533;
            }
            return object2;
        }
        object = this.a.k();
        boolean bl2 = this.a.z(';');
        if (!(F3.i.f((String)object) || F3.i.g((String)object) && bl2)) {
            this.a.K();
            if (bl2) {
                this.c("invalid named reference");
            }
            return null;
        }
        if (bl && (this.a.F() || this.a.D() || this.a.B('=', '-', '_'))) {
            this.a.K();
            return null;
        }
        this.a.M();
        if (!this.a.x(";")) {
            this.c("missing semicolon");
        }
        if ((n2 = F3.i.d((String)object, this.q)) == 1) {
            object2[0] = this.q[0];
            return object2;
        }
        if (n2 == 2) {
            return this.q;
        }
        object2 = new StringBuilder();
        object2.append("Unexpected characters returned for ");
        object2.append((String)object);
        D3.e.a(object2.toString());
        return this.q;
    }

    void e() {
        this.n.m();
        this.n.d = true;
    }

    void f() {
        this.n.m();
    }

    void g() {
        this.m.m();
    }

    i.i h(boolean bl) {
        i.i i2 = bl ? this.j.F() : this.k.F();
        this.i = i2;
        return i2;
    }

    void i() {
        G3.i.n(this.h);
    }

    void j(char c2) {
        if (this.f == null) {
            this.f = String.valueOf((char)c2);
            return;
        }
        if (this.g.length() == 0) {
            this.g.append(this.f);
        }
        this.g.append(c2);
    }

    void k(i i2) {
        D3.e.b(this.e);
        this.d = i2;
        this.e = true;
        i.j j2 = i2.a;
        if (j2 == i.j.h) {
            this.o = ((i.h)i2).b;
            return;
        }
        if (j2 == i.j.i && ((i.g)i2).z()) {
            this.t("Attributes incorrectly present on end tag");
        }
    }

    void l(String string) {
        if (this.f == null) {
            this.f = string;
            return;
        }
        if (this.g.length() == 0) {
            this.g.append(this.f);
        }
        this.g.append(string);
    }

    void m(StringBuilder stringBuilder) {
        if (this.f == null) {
            this.f = stringBuilder.toString();
            return;
        }
        if (this.g.length() == 0) {
            this.g.append(this.f);
        }
        this.g.append((CharSequence)stringBuilder);
    }

    void n(int[] nArray) {
        this.l(new String(nArray, 0, nArray.length));
    }

    void o() {
        this.k(this.n);
    }

    void p() {
        this.k(this.m);
    }

    void q() {
        this.i.x();
        this.k(this.i);
    }

    void r(l l2) {
        if (this.b.c()) {
            this.b.add(new d(this.a.I(), "Unexpectedly reached end of file (EOF) in input state [%s]", new Object[]{l2}));
        }
    }

    void s(l l2) {
        if (this.b.c()) {
            this.b.add(new d(this.a.I(), "Unexpected character '%s' in input state [%s]", new Object[]{Character.valueOf((char)this.a.t()), l2}));
        }
    }

    void t(String string) {
        if (this.b.c()) {
            this.b.add(new d(this.a.I(), string));
        }
    }

    boolean u() {
        return this.o != null && this.i.C().equalsIgnoreCase(this.o);
    }

    i v() {
        while (!this.e) {
            this.c.m(this, this.a);
        }
        Object object = this.g;
        if (object.length() != 0) {
            String string = object.toString();
            object.delete(0, object.length());
            this.f = null;
            return this.l.p(string);
        }
        object = this.f;
        if (object != null) {
            object = this.l.p((String)object);
            this.f = null;
            return object;
        }
        this.e = false;
        return this.d;
    }

    void w(l l2) {
        this.c = l2;
    }
}

