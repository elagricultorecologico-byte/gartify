/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Reader
 *  java.io.StringReader
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Locale
 */
package G3;

import C3.e;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Locale;

public final class a {
    private char[] a;
    private Reader b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g = -1;
    private String[] h = new String[512];
    private boolean i;

    public a(Reader reader) {
        this(reader, 32768);
    }

    public a(Reader reader, int n2) {
        D3.e.j(reader);
        D3.e.d(reader.markSupported());
        this.b = reader;
        this.a = new char[Math.min((int)n2, (int)32768)];
        this.b();
    }

    public a(String string) {
        this((Reader)new StringReader(string), string.length());
    }

    static boolean J(char[] cArray, int n2, int n3, String string) {
        if (n3 == string.length()) {
            int n4 = 0;
            while (n3 != 0) {
                if (cArray[n2] != string.charAt(n4)) {
                    return false;
                }
                ++n2;
                --n3;
                ++n4;
            }
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b() {
        boolean bl;
        long l2;
        long l3;
        Object object;
        int n2;
        if (this.i) return;
        int n3 = this.e;
        if (n3 < this.d) {
            return;
        }
        int n4 = this.g;
        if (n4 != -1) {
            n2 = n3 - n4;
            n3 = n4;
        } else {
            n2 = 0;
        }
        try {
            object = this.b;
            l3 = n3;
            l2 = object.skip(l3);
            this.b.mark(32768);
            n4 = 0;
        }
        catch (IOException iOException) {
            throw new e(iOException);
        }
        while (true) {
            bl = true;
            if (n4 > 1024) break;
            Reader reader = this.b;
            object = this.a;
            int n5 = reader.read((char[])object, n4, ((Reader)object).length - n4);
            if (n5 == -1) {
                this.i = true;
            }
            if (n5 <= 0) break;
            n4 += n5;
        }
        this.b.reset();
        if (n4 <= 0) return;
        if (l2 != l3) {
            bl = false;
        }
        D3.e.d(bl);
        this.c = n4;
        this.f += n3;
        this.e = n2;
        if (this.g != -1) {
            this.g = 0;
        }
        this.d = Math.min((int)n4, (int)24576);
    }

    private static String c(char[] object, String[] stringArray, int n2, int n3) {
        if (n3 > 12) {
            return new String(object, n2, n3);
        }
        if (n3 < 1) {
            return "";
        }
        int n4 = n3 * 31;
        int n5 = 0;
        int n6 = n2;
        while (n5 < n3) {
            n4 = n4 * 31 + object[n6];
            ++n5;
            ++n6;
        }
        n6 = n4 & 0x1FF;
        String string = stringArray[n6];
        if (string == null) {
            object = new String(object, n2, n3);
            stringArray[n6] = object;
            return object;
        }
        if (G3.a.J(object, n2, n3, string)) {
            return string;
        }
        object = new String(object, n2, n3);
        stringArray[n6] = object;
        return object;
    }

    private boolean v() {
        return this.e >= this.c;
    }

    boolean A(String string) {
        this.b();
        int n2 = string.length();
        if (n2 > this.c - this.e) {
            return false;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            if (string.charAt(i2) == this.a[this.e + i2]) continue;
            return false;
        }
        return true;
    }

    boolean B(char ... cArray) {
        if (this.u()) {
            return false;
        }
        this.b();
        char c2 = this.a[this.e];
        int n2 = cArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (cArray[i2] != c2) continue;
            return true;
        }
        return false;
    }

    boolean C(char[] cArray) {
        this.b();
        return !this.u() && Arrays.binarySearch((char[])cArray, (char)this.a[this.e]) >= 0;
    }

    boolean D() {
        if (this.u()) {
            return false;
        }
        char c2 = this.a[this.e];
        return c2 >= '0' && c2 <= '9';
    }

    boolean E(String string) {
        this.b();
        int n2 = string.length();
        if (n2 > this.c - this.e) {
            return false;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            if (Character.toUpperCase((char)string.charAt(i2)) == Character.toUpperCase((char)this.a[this.e + i2])) continue;
            return false;
        }
        return true;
    }

    boolean F() {
        if (this.u()) {
            return false;
        }
        char c2 = this.a[this.e];
        return c2 >= 'A' && c2 <= 'Z' || c2 >= 'a' && c2 <= 'z' || Character.isLetter((char)c2);
    }

    int G(char c2) {
        this.b();
        for (int i2 = this.e; i2 < this.c; ++i2) {
            if (c2 != this.a[i2]) continue;
            return i2 - this.e;
        }
        return -1;
    }

    int H(CharSequence charSequence) {
        this.b();
        char c2 = charSequence.charAt(0);
        int n2 = this.e;
        while (n2 < this.c) {
            int n3 = this.a[n2];
            int n4 = 1;
            int n5 = n2;
            if (c2 != n3) {
                do {
                    n5 = ++n2;
                    if (n2 >= this.c) break;
                    n5 = n2;
                } while (c2 != this.a[n2]);
            }
            n2 = n5 + 1;
            int n6 = charSequence.length() + n2 - 1;
            n3 = this.c;
            if (n5 >= n3 || n6 > n3) continue;
            n3 = n2;
            while (n3 < n6 && charSequence.charAt(n4) == this.a[n3]) {
                ++n3;
                ++n4;
            }
            if (n3 != n6) continue;
            return n5 - this.e;
        }
        return -1;
    }

    public int I() {
        return this.f + this.e;
    }

    void K() {
        int n2 = this.g;
        if (n2 != -1) {
            this.e = n2;
            this.M();
            return;
        }
        throw new e(new IOException("Mark invalid"));
    }

    void L() {
        int n2 = this.e;
        if (n2 >= 1) {
            this.e = n2 - 1;
            return;
        }
        throw new e(new IOException("WTF: No buffer left to unconsume."));
    }

    void M() {
        this.g = -1;
    }

    public void a() {
        ++this.e;
    }

    public void d() {
        Reader reader = this.b;
        if (reader != null) {
            try {
                reader.close();
                return;
            }
            catch (IOException iOException) {
                this.b = null;
                this.a = null;
                this.h = null;
            }
            finally {
                this.b = null;
                this.a = null;
                this.h = null;
            }
        }
    }

    char e() {
        this.b();
        char c2 = this.v() ? (char)'\uffff' : this.a[this.e];
        ++this.e;
        return c2;
    }

    String f(boolean bl) {
        char c2;
        int n2;
        int n3 = this.e;
        int n4 = this.c;
        char[] cArray = this.a;
        for (n2 = n3; n2 < n4 && (c2 = cArray[n2]) != '\u0000'; ++n2) {
            if (c2 != '\"') {
                if (c2 == '&') break;
                if (c2 != '\'') continue;
                if (bl) break;
            }
            if (!bl) break;
        }
        this.e = n2;
        if (n2 > n3) {
            return G3.a.c(this.a, this.h, n3, n2 - n3);
        }
        return "";
    }

    String g() {
        char c2;
        int n2;
        int n3 = this.e;
        int n4 = this.c;
        char[] cArray = this.a;
        for (n2 = n3; n2 < n4 && (c2 = cArray[n2]) != '\u0000' && c2 != '&' && c2 != '<'; ++n2) {
        }
        this.e = n2;
        if (n2 > n3) {
            return G3.a.c(this.a, this.h, n3, n2 - n3);
        }
        return "";
    }

    String h() {
        char c2;
        int n2;
        this.b();
        int n3 = this.e;
        while ((n2 = this.e) < this.c && (c2 = this.a[n2]) >= '0' && c2 <= '9') {
            this.e = n2 + 1;
        }
        return G3.a.c(this.a, this.h, n3, n2 - n3);
    }

    String i() {
        char c2;
        int n2;
        this.b();
        int n3 = this.e;
        while ((n2 = this.e) < this.c && ((c2 = this.a[n2]) >= '0' && c2 <= '9' || c2 >= 'A' && c2 <= 'F' || c2 >= 'a' && c2 <= 'f')) {
            this.e = n2 + 1;
        }
        return G3.a.c(this.a, this.h, n3, n2 - n3);
    }

    String j() {
        char c2;
        int n2;
        this.b();
        int n3 = this.e;
        while ((n2 = ++this.e) < this.c && ((c2 = this.a[n2]) >= 'A' && c2 <= 'Z' || c2 >= 'a' && c2 <= 'z' || Character.isLetter((char)c2))) {
        }
        return G3.a.c(this.a, this.h, n3, this.e - n3);
    }

    String k() {
        int n2;
        char[] cArray;
        char c2;
        int n3;
        this.b();
        int n4 = this.e;
        while ((n3 = ++this.e) < this.c && ((c2 = this.a[n3]) >= 'A' && c2 <= 'Z' || c2 >= 'a' && c2 <= 'z' || Character.isLetter((char)c2))) {
        }
        while (!this.v() && (n3 = (cArray = this.a)[n2 = this.e]) >= 48 && n3 <= 57) {
            this.e = n2 + 1;
        }
        return G3.a.c(this.a, this.h, n4, this.e - n4);
    }

    String l() {
        char c2;
        int n2;
        int n3 = this.e;
        int n4 = this.c;
        char[] cArray = this.a;
        for (n2 = n3; n2 < n4 && (c2 = cArray[n2]) != '\u0000' && c2 != '<'; ++n2) {
        }
        this.e = n2;
        if (n2 > n3) {
            return G3.a.c(this.a, this.h, n3, n2 - n3);
        }
        return "";
    }

    String m() {
        char c2;
        int n2;
        this.b();
        int n3 = this.e;
        int n4 = this.c;
        char[] cArray = this.a;
        for (n2 = n3; n2 < n4 && (c2 = cArray[n2]) != '\u0000' && c2 != ' ' && c2 != '/' && c2 != '<' && c2 != '>' && c2 != '\t' && c2 != '\n' && c2 != '\f' && c2 != '\r'; ++n2) {
        }
        this.e = n2;
        if (n2 > n3) {
            return G3.a.c(this.a, this.h, n3, n2 - n3);
        }
        return "";
    }

    public String n(char c2) {
        int n2 = this.G(c2);
        if (n2 != -1) {
            String string = G3.a.c(this.a, this.h, this.e, n2);
            this.e += n2;
            return string;
        }
        return this.r();
    }

    String o(String object) {
        int n2 = this.H((CharSequence)object);
        if (n2 != -1) {
            object = G3.a.c(this.a, this.h, this.e, n2);
            this.e += n2;
            return object;
        }
        if (this.c - this.e < object.length()) {
            return this.r();
        }
        int n3 = this.c - object.length() + 1;
        char[] cArray = this.a;
        object = this.h;
        n2 = this.e;
        object = G3.a.c(cArray, object, n2, n3 - n2);
        this.e = n3;
        return object;
    }

    public String p(char ... cArray) {
        int n2;
        this.b();
        int n3 = this.e;
        int n4 = this.c;
        char[] cArray2 = this.a;
        int n5 = cArray.length;
        block0: for (n2 = n3; n2 < n4; ++n2) {
            for (int i2 = 0; i2 < n5; ++i2) {
                if (cArray2[n2] == cArray[i2]) break block0;
            }
        }
        this.e = n2;
        if (n2 > n3) {
            return G3.a.c(this.a, this.h, n3, n2 - n3);
        }
        return "";
    }

    String q(char ... cArray) {
        int n2;
        this.b();
        int n3 = this.e;
        int n4 = this.c;
        char[] cArray2 = this.a;
        for (n2 = n3; n2 < n4 && Arrays.binarySearch((char[])cArray, (char)cArray2[n2]) < 0; ++n2) {
        }
        this.e = n2;
        if (n2 > n3) {
            return G3.a.c(this.a, this.h, n3, n2 - n3);
        }
        return "";
    }

    String r() {
        this.b();
        char[] cArray = this.a;
        Object object = this.h;
        int n2 = this.e;
        object = G3.a.c(cArray, object, n2, this.c - n2);
        this.e = this.c;
        return object;
    }

    boolean s(String string) {
        Locale locale = Locale.ENGLISH;
        String string2 = string.toLowerCase(locale);
        string = string.toUpperCase(locale);
        return this.H(string2) > -1 || this.H(string) > -1;
        {
        }
    }

    public char t() {
        this.b();
        if (this.v()) {
            return '\uffff';
        }
        return this.a[this.e];
    }

    public String toString() {
        int n2 = this.c;
        int n3 = this.e;
        if (n2 - n3 < 0) {
            return "";
        }
        return new String(this.a, n3, n2 - n3);
    }

    public boolean u() {
        this.b();
        return this.e >= this.c;
    }

    void w() {
        if (this.c - this.e < 1024) {
            this.d = 0;
        }
        this.b();
        this.g = this.e;
    }

    boolean x(String string) {
        this.b();
        if (this.A(string)) {
            this.e += string.length();
            return true;
        }
        return false;
    }

    boolean y(String string) {
        if (this.E(string)) {
            this.e += string.length();
            return true;
        }
        return false;
    }

    boolean z(char c2) {
        return !this.u() && this.a[this.e] == c2;
    }
}

