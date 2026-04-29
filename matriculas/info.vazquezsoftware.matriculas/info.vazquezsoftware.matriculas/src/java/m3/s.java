/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
package m3;

import H2.j;
import H2.n;
import I2.o;
import P2.c;
import V2.g;
import V2.k;
import b3.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import n3.d;

public final class s
implements Iterable {
    public static final b h = new b(null);
    private final String[] g;

    private s(String[] stringArray) {
        this.g = stringArray;
    }

    public /* synthetic */ s(String[] stringArray, g g2) {
        this(stringArray);
    }

    public final String c(String string) {
        k.e(string, "name");
        return s.h.f(this.g, string);
    }

    public boolean equals(Object object) {
        return object instanceof s && Arrays.equals((Object[])this.g, (Object[])((s)object).g);
    }

    public final String f(int n2) {
        return this.g[n2 * 2];
    }

    public final a h() {
        a a2 = new a();
        o.r((Collection)a2.e(), this.g);
        return a2;
    }

    public int hashCode() {
        return Arrays.hashCode((Object[])this.g);
    }

    public final String i(int n2) {
        return this.g[n2 * 2 + 1];
    }

    public Iterator iterator() {
        int n2 = this.size();
        Object[] objectArray = new j[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            objectArray[i2] = n.a(this.f(i2), this.i(i2));
        }
        return V2.b.a(objectArray);
    }

    public final List j(String string) {
        k.e(string, "name");
        int n2 = this.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < n2; ++i2) {
            ArrayList arrayList2 = arrayList;
            if (b3.h.u(string, this.f(i2), true)) {
                arrayList2 = arrayList;
                if (arrayList == null) {
                    arrayList2 = new ArrayList(2);
                }
                arrayList2.add((Object)this.i(i2));
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            string = Collections.unmodifiableList(arrayList);
            k.d(string, "{\n      Collections.unmodifiableList(result)\n    }");
            return string;
        }
        return o.g();
    }

    public final int size() {
        return this.g.length / 2;
    }

    public String toString() {
        String string;
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = this.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            String string2 = this.f(i2);
            string = this.i(i2);
            stringBuilder.append(string2);
            stringBuilder.append(": ");
            if (d.G(string2)) {
                string = "\u2588\u2588";
            }
            stringBuilder.append(string);
            stringBuilder.append("\n");
        }
        string = stringBuilder.toString();
        k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final class a {
        private final List a = new ArrayList(20);

        public final a a(String string, String string2) {
            k.e(string, "name");
            k.e(string2, "value");
            b b2 = h;
            b2.d(string);
            b2.e(string2, string);
            this.c(string, string2);
            return this;
        }

        public final a b(String string) {
            k.e(string, "line");
            int n2 = b3.h.R(string, ':', 1, false, 4, null);
            if (n2 != -1) {
                String string2 = string.substring(0, n2);
                k.d(string2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                string = string.substring(n2 + 1);
                k.d(string, "this as java.lang.String).substring(startIndex)");
                this.c(string2, string);
                return this;
            }
            if (string.charAt(0) == ':') {
                string = string.substring(1);
                k.d(string, "this as java.lang.String).substring(startIndex)");
                this.c("", string);
                return this;
            }
            this.c("", string);
            return this;
        }

        public final a c(String string, String string2) {
            k.e(string, "name");
            k.e(string2, "value");
            this.e().add((Object)string);
            this.e().add((Object)b3.h.t0(string2).toString());
            return this;
        }

        public final s d() {
            Object[] objectArray = this.a.toArray((Object[])new String[0]);
            if (objectArray != null) {
                return new s((String[])objectArray, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        public final List e() {
            return this.a;
        }

        public final a f(String string) {
            k.e(string, "name");
            int n2 = 0;
            while (n2 < this.e().size()) {
                int n3 = n2;
                if (b3.h.u(string, (String)this.e().get(n2), true)) {
                    this.e().remove(n2);
                    this.e().remove(n2);
                    n3 = n2 - 2;
                }
                n2 = n3 + 2;
            }
            return this;
        }

        public final a g(String string, String string2) {
            k.e(string, "name");
            k.e(string2, "value");
            b b2 = h;
            b2.d(string);
            b2.e(string2, string);
            this.f(string);
            this.c(string, string2);
            return this;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g g2) {
            this();
        }

        private final void d(String string) {
            if (string.length() > 0) {
                int n2 = string.length();
                for (int i2 = 0; i2 < n2; ++i2) {
                    char c2 = string.charAt(i2);
                    if ('!' <= c2 && c2 < '\u007f') {
                        continue;
                    }
                    throw new IllegalArgumentException(d.t("Unexpected char %#04x at %d in header name: %s", c2, i2, string).toString());
                }
                return;
            }
            throw new IllegalArgumentException("name is empty");
        }

        private final void e(String string, String string2) {
            int n2 = string.length();
            for (int i2 = 0; i2 < n2; ++i2) {
                char c2 = string.charAt(i2);
                if (c2 == '\t' || ' ' <= c2 && c2 < '\u007f') continue;
                String string3 = d.t("Unexpected char %#04x at %d in %s value", c2, i2, string2);
                string = d.G(string2) ? "" : k.j(": ", string);
                throw new IllegalArgumentException(k.j(string3, string).toString());
            }
        }

        private final String f(String[] stringArray, String string) {
            int n2 = stringArray.length - 2;
            int n3 = c.b(n2, 0, -2);
            if (n3 <= n2) {
                while (true) {
                    if (b3.h.u(string, stringArray[n2], true)) {
                        return stringArray[n2 + 1];
                    }
                    if (n2 == n3) break;
                    n2 -= 2;
                }
            }
            return null;
        }

        public final s g(String ... stringArray) {
            k.e(stringArray, "namesAndValues");
            if (stringArray.length % 2 == 0) {
                String string;
                int n2;
                stringArray = (String[])stringArray.clone();
                int n3 = stringArray.length;
                int n4 = 0;
                for (n2 = 0; n2 < n3; ++n2) {
                    string = stringArray[n2];
                    if (string != null) {
                        stringArray[n2] = b3.h.t0(string).toString();
                        continue;
                    }
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                n3 = c.b(0, stringArray.length - 1, 2);
                if (n3 >= 0) {
                    n2 = n4;
                    while (true) {
                        string = stringArray[n2];
                        String string2 = stringArray[n2 + 1];
                        this.d(string);
                        this.e(string2, string);
                        if (n2 == n3) break;
                        n2 += 2;
                    }
                }
                return new s(stringArray, null);
            }
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
    }
}

