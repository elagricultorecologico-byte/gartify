/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
package F3;

import C3.d;
import D3.e;
import E3.c;
import F3.a;
import F3.f;
import F3.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class b
implements Iterable,
Cloneable {
    private int g = 0;
    String[] h = new String[3];
    String[] i = new String[3];

    static String A(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('/');
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    private boolean C(String string) {
        return string != null && string.length() > 1 && string.charAt(0) == '/';
    }

    private void I(int n2) {
        boolean bl = n2 >= this.g;
        e.b(bl);
        int n3 = this.g - n2 - 1;
        if (n3 > 0) {
            String[] stringArray = this.h;
            int n4 = n2 + 1;
            System.arraycopy((Object)stringArray, (int)n4, (Object)stringArray, (int)n2, (int)n3);
            stringArray = this.i;
            System.arraycopy((Object)stringArray, (int)n4, (Object)stringArray, (int)n2, (int)n3);
        }
        this.g = n2 = this.g - 1;
        this.h[n2] = null;
        this.i[n2] = null;
    }

    private void n(int n2) {
        boolean bl = n2 >= this.g;
        e.d(bl);
        Object[] objectArray = this.h;
        int n3 = objectArray.length;
        if (n3 >= n2) {
            return;
        }
        int n4 = 3;
        if (n3 >= 3) {
            n4 = this.g * 2;
        }
        if (n2 <= n4) {
            n2 = n4;
        }
        this.h = (String[])Arrays.copyOf((Object[])objectArray, (int)n2);
        this.i = (String[])Arrays.copyOf((Object[])this.i, (int)n2);
    }

    static String o(String string) {
        String string2 = string;
        if (string == null) {
            string2 = "";
        }
        return string2;
    }

    private int z(String string) {
        e.j(string);
        for (int i2 = 0; i2 < this.g; ++i2) {
            if (!string.equalsIgnoreCase(this.h[i2])) continue;
            return i2;
        }
        return -1;
    }

    public void D() {
        for (int i2 = 0; i2 < this.g; ++i2) {
            String[] stringArray = this.h;
            stringArray[i2] = E3.b.a(stringArray[i2]);
        }
    }

    public b E(a a2) {
        e.j(a2);
        this.F(a2.b(), a2.c());
        a2.i = this;
        return this;
    }

    public b F(String string, String string2) {
        e.j(string);
        int n2 = this.y(string);
        if (n2 != -1) {
            this.i[n2] = string2;
            return this;
        }
        this.k(string, string2);
        return this;
    }

    void H(String string, String string2) {
        int n2 = this.z(string);
        if (n2 != -1) {
            this.i[n2] = string2;
            if (!this.h[n2].equals((Object)string)) {
                this.h[n2] = string;
            }
            return;
        }
        this.k(string, string2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            object = (b)object;
            if (this.g != ((b)object).g) {
                return false;
            }
            if (!Arrays.equals((Object[])this.h, (Object[])((b)object).h)) {
                return false;
            }
            return Arrays.equals((Object[])this.i, (Object[])((b)object).i);
        }
        return false;
    }

    public int hashCode() {
        return (this.g * 31 + Arrays.hashCode((Object[])this.h)) * 31 + Arrays.hashCode((Object[])this.i);
    }

    public boolean isEmpty() {
        return this.g == 0;
    }

    public Iterator iterator() {
        return new Iterator(this){
            int g;
            final b h;
            {
                this.h = b2;
                this.g = 0;
            }

            public a b() {
                b b2 = this.h;
                Object object = b2.h;
                int n2 = this.g++;
                object = new a(object[n2], b2.i[n2], b2);
                return object;
            }

            public boolean hasNext() {
                b b2;
                while (this.g < this.h.g && (b2 = this.h).C(b2.h[this.g])) {
                    ++this.g;
                }
                return this.g < this.h.g;
            }

            public void remove() {
                int n2;
                b b2 = this.h;
                this.g = n2 = this.g - 1;
                b2.I(n2);
            }
        };
    }

    public b k(String string, String string2) {
        this.n(this.g + 1);
        String[] stringArray = this.h;
        int n2 = this.g;
        stringArray[n2] = string;
        this.i[n2] = string2;
        this.g = n2 + 1;
        return this;
    }

    public void l(b b2) {
        if (b2.size() != 0) {
            this.n(this.g + b2.g);
            b2 = b2.iterator();
            while (b2.hasNext()) {
                this.E((a)b2.next());
            }
        }
    }

    public List m() {
        ArrayList arrayList = new ArrayList(this.g);
        for (int i2 = 0; i2 < this.g; ++i2) {
            if (this.C(this.h[i2])) continue;
            arrayList.add((Object)new a(this.h[i2], this.i[i2], this));
        }
        return Collections.unmodifiableList((List)arrayList);
    }

    public b q() {
        b b2;
        try {
            b2 = (b)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException((Throwable)cloneNotSupportedException);
        }
        b2.g = this.g;
        this.h = (String[])Arrays.copyOf((Object[])this.h, (int)this.g);
        this.i = (String[])Arrays.copyOf((Object[])this.i, (int)this.g);
        return b2;
    }

    public int r(G3.f stringArray) {
        boolean bl = this.isEmpty();
        int n2 = 0;
        if (bl) {
            return 0;
        }
        bl = stringArray.d();
        int n3 = 0;
        while (n2 < this.h.length) {
            String string;
            int n4;
            int n5 = n4 = n2 + 1;
            while (n5 < (stringArray = this.h).length && (string = stringArray[n5]) != null) {
                int n6;
                int n7;
                block7: {
                    block6: {
                        if (bl && stringArray[n2].equals((Object)string)) break block6;
                        n7 = n3;
                        n6 = n5;
                        if (bl) break block7;
                        stringArray = this.h;
                        n7 = n3;
                        n6 = n5;
                        if (!stringArray[n2].equalsIgnoreCase(stringArray[n5])) break block7;
                    }
                    n7 = n3 + 1;
                    this.I(n5);
                    n6 = n5 - 1;
                }
                n5 = n6 + 1;
                n3 = n7;
            }
            n2 = n4;
        }
        return n3;
    }

    public String s(String string) {
        int n2 = this.y(string);
        if (n2 == -1) {
            return "";
        }
        return b.o(this.i[n2]);
    }

    public int size() {
        int n2 = 0;
        for (int i2 = 0; i2 < this.g; ++i2) {
            int n3 = n2;
            if (!this.C(this.h[i2])) {
                n3 = n2 + 1;
            }
            n2 = n3;
        }
        return n2;
    }

    public String t(String string) {
        int n2 = this.z(string);
        if (n2 == -1) {
            return "";
        }
        return b.o(this.i[n2]);
    }

    public String toString() {
        return this.w();
    }

    public boolean u(String string) {
        return this.y(string) != -1;
    }

    public boolean v(String string) {
        return this.z(string) != -1;
    }

    public String w() {
        StringBuilder stringBuilder = c.b();
        try {
            f f2 = new f("");
            this.x((Appendable)stringBuilder, f2.R0());
        }
        catch (IOException iOException) {
            throw new d(iOException);
        }
        return c.n(stringBuilder);
    }

    final void x(Appendable appendable, f.a a2) {
        int n2 = this.g;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.C(this.h[i2])) continue;
            String string = this.h[i2];
            String string2 = this.i[i2];
            appendable.append(' ').append((CharSequence)string);
            if (a.k(string, string2, a2)) continue;
            appendable.append((CharSequence)"=\"");
            string = string2;
            if (string2 == null) {
                string = "";
            }
            F3.i.e(appendable, string, a2, true, false, false);
            appendable.append('\"');
        }
    }

    int y(String string) {
        e.j(string);
        for (int i2 = 0; i2 < this.g; ++i2) {
            if (!string.equals((Object)this.h[i2])) continue;
            return i2;
        }
        return -1;
    }
}

