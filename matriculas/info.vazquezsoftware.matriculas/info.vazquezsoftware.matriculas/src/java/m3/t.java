/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.MalformedURLException
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.net.URL
 *  java.nio.charset.Charset
 *  java.nio.charset.StandardCharsets
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package m3;

import I2.o;
import V2.k;
import Y2.d;
import b3.g;
import b3.h;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class t {
    public static final b k = new b(null);
    private static final char[] l = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final int e;
    private final List f;
    private final List g;
    private final String h;
    private final String i;
    private final boolean j;

    public t(String string, String string2, String string3, String string4, int n2, List list, List list2, String string5, String string6) {
        V2.k.e(string, "scheme");
        V2.k.e(string2, "username");
        V2.k.e(string3, "password");
        V2.k.e(string4, "host");
        V2.k.e(list, "pathSegments");
        V2.k.e(string6, "url");
        this.a = string;
        this.b = string2;
        this.c = string3;
        this.d = string4;
        this.e = n2;
        this.f = list;
        this.g = list2;
        this.h = string5;
        this.i = string6;
        this.j = V2.k.a(string, "https");
    }

    public final String b() {
        if (this.h == null) {
            return null;
        }
        int n2 = b3.h.R(this.i, '#', 0, false, 6, null);
        String string = this.i.substring(n2 + 1);
        V2.k.d(string, "this as java.lang.String).substring(startIndex)");
        return string;
    }

    public final String c() {
        if (this.c.length() == 0) {
            return "";
        }
        int n2 = b3.h.R(this.i, ':', this.a.length() + 3, false, 4, null);
        int n3 = b3.h.R(this.i, '@', 0, false, 6, null);
        String string = this.i.substring(n2 + 1, n3);
        V2.k.d(string, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return string;
    }

    public final String d() {
        int n2 = b3.h.R(this.i, '/', this.a.length() + 3, false, 4, null);
        String string = this.i;
        int n3 = n3.d.q(string, "?#", n2, string.length());
        string = this.i.substring(n2, n3);
        V2.k.d(string, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return string;
    }

    public final List e() {
        int n2 = b3.h.R(this.i, '/', this.a.length() + 3, false, 4, null);
        String string = this.i;
        int n3 = n3.d.q(string, "?#", n2, string.length());
        ArrayList arrayList = new ArrayList();
        while (n2 < n3) {
            int n4 = n2 + 1;
            n2 = n3.d.p(this.i, '/', n4, n3);
            string = this.i.substring(n4, n2);
            V2.k.d(string, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            arrayList.add((Object)string);
        }
        return arrayList;
    }

    public boolean equals(Object object) {
        return object instanceof t && V2.k.a(((t)object).i, this.i);
    }

    public final String f() {
        if (this.g == null) {
            return null;
        }
        int n2 = b3.h.R(this.i, '?', 0, false, 6, null) + 1;
        String string = this.i;
        int n3 = n3.d.p(string, '#', n2, string.length());
        string = this.i.substring(n2, n3);
        V2.k.d(string, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return string;
    }

    public final String g() {
        if (this.b.length() == 0) {
            return "";
        }
        int n2 = this.a.length() + 3;
        String string = this.i;
        int n3 = n3.d.q(string, ":@", n2, string.length());
        string = this.i.substring(n2, n3);
        V2.k.d(string, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return string;
    }

    public final String h() {
        return this.d;
    }

    public int hashCode() {
        return this.i.hashCode();
    }

    public final boolean i() {
        return this.j;
    }

    public final a j() {
        a a2 = new a();
        a2.C(this.a);
        a2.z(this.g());
        a2.x(this.c());
        a2.A(this.d);
        int n2 = this.e != k.c(this.a) ? this.e : -1;
        a2.B(n2);
        a2.f().clear();
        a2.f().addAll((Collection)this.e());
        a2.c(this.f());
        a2.w(this.b());
        return a2;
    }

    public final a k(String object) {
        V2.k.e(object, "link");
        try {
            a a2 = new a();
            object = a2.o(this, (String)object);
            return object;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return null;
        }
    }

    public final int l() {
        return this.e;
    }

    public final String m() {
        if (this.g == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        k.j(this.g, stringBuilder);
        return stringBuilder.toString();
    }

    public final String n() {
        a a2 = this.k("/...");
        V2.k.b(a2);
        return a2.D("").p("").a().toString();
    }

    public final t o(String object) {
        V2.k.e(object, "link");
        object = this.k((String)object);
        if (object == null) {
            return null;
        }
        return ((a)object).a();
    }

    public final String p() {
        return this.a;
    }

    public final URI q() {
        String string = this.j().t().toString();
        try {
            URI uRI = new URI(string);
            return uRI;
        }
        catch (URISyntaxException uRISyntaxException) {
            try {
                g g2 = new g("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");
                string = URI.create((String)g2.b(string, ""));
            }
            catch (Exception exception) {
                throw new RuntimeException((Throwable)uRISyntaxException);
            }
            V2.k.d(string, "{\n      // Unlikely edge\u2026Unexpected!\n      }\n    }");
            return string;
        }
    }

    public final URL r() {
        try {
            URL uRL = new URL(this.i);
            return uRL;
        }
        catch (MalformedURLException malformedURLException) {
            throw new RuntimeException((Throwable)malformedURLException);
        }
    }

    public String toString() {
        return this.i;
    }

    public static final class m3.t$a {
        public static final a i = new a(null);
        private String a;
        private String b = "";
        private String c = "";
        private String d;
        private int e = -1;
        private final List f;
        private List g;
        private String h;

        public m3.t$a() {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add((Object)"");
        }

        private final int b() {
            int n2 = this.e;
            if (n2 != -1) {
                return n2;
            }
            b b2 = k;
            String string = this.a;
            V2.k.b(string);
            return b2.c(string);
        }

        private final boolean m(String string) {
            return V2.k.a(string, ".") || b3.h.u(string, "%2e", true);
            {
            }
        }

        private final boolean n(String string) {
            return V2.k.a(string, "..") || b3.h.u(string, "%2e.", true) || b3.h.u(string, ".%2e", true) || b3.h.u(string, "%2e%2e", true);
            {
            }
        }

        private final void q() {
            List list = this.f;
            if (((String)list.remove(list.size() - 1)).length() == 0 && !this.f.isEmpty()) {
                list = this.f;
                list.set(list.size() - 1, (Object)"");
                return;
            }
            this.f.add((Object)"");
        }

        private final void s(String string, int n2, int n3, boolean bl, boolean bl2) {
            if (!this.m(string = m3.t$b.b(k, string, n2, n3, " \"<>^`{}|/\\?#", bl2, false, false, false, null, 240, null))) {
                if (this.n(string)) {
                    this.q();
                    return;
                }
                List list = this.f;
                if (((CharSequence)list.get(list.size() - 1)).length() == 0) {
                    list = this.f;
                    list.set(list.size() - 1, (Object)string);
                } else {
                    this.f.add((Object)string);
                }
                if (bl) {
                    this.f.add((Object)"");
                }
            }
        }

        private final void u(String string, int n2, int n3) {
            if (n2 != n3) {
                int n4 = string.charAt(n2);
                if (n4 != 47 && n4 != 92) {
                    List list = this.f;
                    list.set(list.size() - 1, (Object)"");
                } else {
                    this.f.clear();
                    this.f.add((Object)"");
                    ++n2;
                }
                while (n2 < n3) {
                    n4 = n3.d.q(string, "/\\", n2, n3);
                    boolean bl = n4 < n3;
                    this.s(string, n2, n4, bl, true);
                    if (bl) {
                        n2 = n4 + 1;
                        continue;
                    }
                    n2 = n4;
                }
            }
        }

        public final void A(String string) {
            this.d = string;
        }

        public final void B(int n2) {
            this.e = n2;
        }

        public final void C(String string) {
            this.a = string;
        }

        public final m3.t$a D(String string) {
            V2.k.e(string, "username");
            this.z(m3.t$b.b(k, string, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null));
            return this;
        }

        public final t a() {
            String string = this.a;
            if (string != null) {
                Object object = k;
                String string2 = m3.t$b.g((b)object, this.b, 0, 0, false, 7, null);
                String string3 = m3.t$b.g((b)object, this.c, 0, 0, false, 7, null);
                String string4 = this.d;
                if (string4 != null) {
                    String string5;
                    int n2 = this.b();
                    object = this.f;
                    ArrayList arrayList = new ArrayList(o.o((Iterable)object, 10));
                    Object object2 = object.iterator();
                    while (object2.hasNext()) {
                        object = (String)object2.next();
                        arrayList.add((Object)m3.t$b.g(k, (String)object, 0, 0, false, 7, null));
                    }
                    object = this.g;
                    object2 = null;
                    if (object == null) {
                        object = null;
                    } else {
                        string5 = new ArrayList(o.o((Iterable)object, 10));
                        Iterator iterator = object.iterator();
                        while (iterator.hasNext()) {
                            object = (String)iterator.next();
                            object = object == null ? null : m3.t$b.g(k, (String)object, 0, 0, true, 3, null);
                            string5.add(object);
                        }
                        object = string5;
                    }
                    string5 = this.h;
                    if (string5 != null) {
                        object2 = m3.t$b.g(k, string5, 0, 0, false, 7, null);
                    }
                    return new t(string, string2, string3, string4, n2, (List)arrayList, (List)object, (String)object2, this.toString());
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public final m3.t$a c(String object) {
            b b2;
            Object var2_2 = null;
            object = object == null ? var2_2 : ((object = m3.t$b.b(b2 = k, (String)object, 0, 0, " \"'<>#", true, false, true, false, null, 211, null)) == null ? var2_2 : b2.i((String)object));
            this.y((List)object);
            return this;
        }

        public final String d() {
            return this.h;
        }

        public final String e() {
            return this.c;
        }

        public final List f() {
            return this.f;
        }

        public final List g() {
            return this.g;
        }

        public final String h() {
            return this.b;
        }

        public final String i() {
            return this.d;
        }

        public final int j() {
            return this.e;
        }

        public final String k() {
            return this.a;
        }

        public final m3.t$a l(String string) {
            V2.k.e(string, "host");
            String string2 = n3.a.e(m3.t$b.g(k, string, 0, 0, false, 7, null));
            if (string2 != null) {
                this.A(string2);
                return this;
            }
            throw new IllegalArgumentException(V2.k.j("unexpected host: ", string));
        }

        public final m3.t$a o(t object, String string) {
            block20: {
                int n2;
                int n3;
                block23: {
                    int n4;
                    int n5;
                    block22: {
                        int n6;
                        int n7;
                        Object object2;
                        block21: {
                            block18: {
                                block16: {
                                    block19: {
                                        block17: {
                                            V2.k.e(string, "input");
                                            n5 = n3.d.A(string, 0, 0, 3, null);
                                            n3 = n3.d.C(string, n5, 0, 2, null);
                                            object2 = i;
                                            n7 = ((a)object2).g(string, n5, n3);
                                            n4 = 1;
                                            if (n7 == -1) break block16;
                                            if (!b3.h.B(string, "https:", n5, true)) break block17;
                                            this.a = "https";
                                            n5 += 6;
                                            break block18;
                                        }
                                        if (!b3.h.B(string, "http:", n5, true)) break block19;
                                        this.a = "http";
                                        n5 += 5;
                                        break block18;
                                    }
                                    object = new StringBuilder();
                                    object.append("Expected URL scheme 'http' or 'https' but was '");
                                    string = string.substring(0, n7);
                                    V2.k.d(string, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                    object.append(string);
                                    object.append('\'');
                                    throw new IllegalArgumentException(object.toString());
                                }
                                if (object == null) break block20;
                                this.a = ((t)object).p();
                            }
                            n7 = ((a)object2).h(string, n5, n3);
                            if (n7 >= 2 || object == null || !V2.k.a(((t)object).p(), this.a)) break block21;
                            this.b = ((t)object).g();
                            this.c = ((t)object).c();
                            this.d = ((t)object).h();
                            this.e = ((t)object).l();
                            this.f.clear();
                            this.f.addAll((Collection)((t)object).e());
                            if (n5 == n3 || string.charAt(n5) == '#') {
                                this.c(((t)object).f());
                            }
                            n4 = n5;
                            n5 = n3;
                            break block22;
                        }
                        n2 = n5 + n7;
                        n7 = 0;
                        int n8 = 0;
                        n5 = n4;
                        while ((n6 = (n4 = n3.d.q(string, "@/\\?#", n2, n3)) != n3 ? (int)string.charAt(n4) : -1) != -1 && n6 != 35 && n6 != 47 && n6 != 92 && n6 != 63) {
                            if (n6 != 64) continue;
                            if (n7 == 0) {
                                n6 = n3.d.p(string, ':', n2, n4);
                                b b2 = k;
                                object = object2 = m3.t$b.b(b2, string, n2, n6, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                if (n8 != 0) {
                                    object = new StringBuilder();
                                    object.append(this.b);
                                    object.append("%40");
                                    object.append((String)object2);
                                    object = object.toString();
                                }
                                this.b = object;
                                if (n6 != n4) {
                                    this.c = m3.t$b.b(b2, string, n6 + 1, n4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                    n7 = n5;
                                }
                                n2 = n4;
                                n8 = n5;
                            } else {
                                object = new StringBuilder();
                                object.append(this.c);
                                object.append("%40");
                                object2 = m3.t$b.b(k, string, n2, n4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                n2 = n4;
                                object.append((String)object2);
                                this.c = object.toString();
                            }
                            n2 = n4 + 1;
                        }
                        n5 = n3;
                        object = i;
                        n3 = ((a)object).f(string, n2, n4);
                        n8 = n3 + 1;
                        if (n8 < n4) {
                            this.d = n3.a.e(m3.t$b.g(k, string, n2, n3, false, 4, null));
                            this.e = n7 = ((a)object).e(string, n8, n4);
                            if (n7 == -1) {
                                object = new StringBuilder();
                                object.append("Invalid URL port: \"");
                                string = string.substring(n8, n4);
                                V2.k.d(string, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                object.append(string);
                                object.append('\"');
                                throw new IllegalArgumentException(object.toString().toString());
                            }
                        } else {
                            object = k;
                            this.d = n3.a.e(m3.t$b.g((b)object, string, n2, n3, false, 4, null));
                            object2 = this.a;
                            V2.k.b(object2);
                            this.e = ((b)object).c((String)object2);
                        }
                        if (this.d == null) break block23;
                    }
                    n3 = n3.d.q(string, "?#", n4, n5);
                    this.u(string, n4, n3);
                    if (n3 < n5 && string.charAt(n3) == '?') {
                        n4 = n3.d.p(string, '#', n3, n5);
                        object = k;
                        this.g = ((b)object).i(m3.t$b.b((b)object, string, n3 + 1, n4, " \"'<>#", true, false, true, false, null, 208, null));
                    } else {
                        n4 = n3;
                    }
                    if (n4 < n5 && string.charAt(n4) == '#') {
                        this.h = m3.t$b.b(k, string, n4 + 1, n5, "", true, false, false, true, null, 176, null);
                    }
                    return this;
                }
                object = new StringBuilder();
                object.append("Invalid URL host: \"");
                string = string.substring(n2, n3);
                V2.k.d(string, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                object.append(string);
                object.append('\"');
                throw new IllegalArgumentException(object.toString().toString());
            }
            object = string.length() > 6 ? V2.k.j(b3.h.w0(string, 6), "...") : string;
            throw new IllegalArgumentException(V2.k.j("Expected URL scheme 'http' or 'https' but no scheme was found for ", object));
        }

        public final m3.t$a p(String string) {
            V2.k.e(string, "password");
            this.x(m3.t$b.b(k, string, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null));
            return this;
        }

        public final m3.t$a r(int n2) {
            if (1 <= n2 && n2 < 65536) {
                this.B(n2);
                return this;
            }
            throw new IllegalArgumentException(V2.k.j("unexpected port: ", n2).toString());
        }

        public final m3.t$a t() {
            int n2;
            String string = this.i();
            Object var5_2 = null;
            string = string == null ? null : new g("[\"<>^`{|}]").b(string, "");
            this.A(string);
            int n3 = this.f().size();
            int n4 = 0;
            for (n2 = 0; n2 < n3; ++n2) {
                this.f().set(n2, (Object)m3.t$b.b(k, (String)this.f().get(n2), 0, 0, "[]", true, true, false, false, null, 227, null));
            }
            List list = this.g();
            if (list != null) {
                n3 = list.size();
                for (n2 = n4; n2 < n3; ++n2) {
                    string = (String)list.get(n2);
                    string = string == null ? null : m3.t$b.b(k, string, 0, 0, "\\^`{|}", true, true, true, false, null, 195, null);
                    list.set(n2, (Object)string);
                }
            }
            string = (string = this.d()) == null ? var5_2 : m3.t$b.b(k, string, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, 163, null);
            this.w(string);
            return this;
        }

        public String toString() {
            Object object;
            Object object2;
            Object object3;
            block12: {
                int n2;
                block13: {
                    object3 = new StringBuilder();
                    if (this.k() != null) {
                        object3.append(this.k());
                        object3.append("://");
                    } else {
                        object3.append("//");
                    }
                    if (this.h().length() > 0 || this.e().length() > 0) {
                        object3.append(this.h());
                        if (this.e().length() > 0) {
                            object3.append(':');
                            object3.append(this.e());
                        }
                        object3.append('@');
                    }
                    if (this.i() != null) {
                        object2 = this.i();
                        V2.k.b(object2);
                        if (b3.h.I((CharSequence)object2, ':', false, 2, null)) {
                            object3.append('[');
                            object3.append(this.i());
                            object3.append(']');
                        } else {
                            object3.append(this.i());
                        }
                    }
                    if (this.j() == -1 && this.k() == null) break block12;
                    n2 = this.b();
                    if (this.k() == null) break block13;
                    object2 = k;
                    object = this.k();
                    V2.k.b(object);
                    if (n2 == ((b)object2).c((String)object)) break block12;
                }
                object3.append(':');
                object3.append(n2);
            }
            object = k;
            ((b)object).h(this.f(), (StringBuilder)object3);
            if (this.g() != null) {
                object3.append('?');
                object2 = this.g();
                V2.k.b(object2);
                ((b)object).j((List)object2, (StringBuilder)object3);
            }
            if (this.d() != null) {
                object3.append('#');
                object3.append(this.d());
            }
            object3 = object3.toString();
            V2.k.d(object3, "StringBuilder().apply(builderAction).toString()");
            return object3;
        }

        public final m3.t$a v(String string) {
            V2.k.e(string, "scheme");
            if (b3.h.u(string, "http", true)) {
                this.C("http");
                return this;
            }
            if (b3.h.u(string, "https", true)) {
                this.C("https");
                return this;
            }
            throw new IllegalArgumentException(V2.k.j("unexpected scheme: ", string));
        }

        public final void w(String string) {
            this.h = string;
        }

        public final void x(String string) {
            V2.k.e(string, "<set-?>");
            this.c = string;
        }

        public final void y(List list) {
            this.g = list;
        }

        public final void z(String string) {
            V2.k.e(string, "<set-?>");
            this.b = string;
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(V2.g g2) {
                this();
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            private final int e(String string, int n2, int n3) {
                block3: {
                    try {
                        n2 = Integer.parseInt((String)m3.t$b.b(k, string, n2, n3, "", false, false, false, false, null, 248, null));
                        if (1 > n2 || n2 >= 65536) break block3;
                        return n2;
                    }
                    catch (NumberFormatException numberFormatException) {
                        return -1;
                    }
                }
                return -1;
            }

            /*
             * Exception decompiling
             */
            private final int f(String var1_1, int var2_2, int var3_3) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[DOLOOP]], but top level block is 3[SIMPLE_IF_TAKEN]
                 *     at fc.r.Q0(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:193)
                 *     at fc.n.E0(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:114)
                 *     at dc.f.b(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:523)
                 *     at dc.f.c(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:7)
                 *     at dc.f.a(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:157)
                 *     at md.e.l(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:7)
                 *     at kd.k.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:7)
                 *     at kd.f.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:179)
                 *     at kd.f.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:55)
                 *     at kd.f.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:55)
                 *     at og.h.r0(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:235)
                 *     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.decompileWithCFR(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:784)
                 *     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.doWork(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:141)
                 *     at com.thesourceofcode.jadec.decompilers.BaseDecompiler.withAttempt(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:3)
                 *     at z6.a.run(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:31)
                 *     at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1154)
                 *     at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:652)
                 *     at java.lang.Thread.run(Thread.java:1564)
                 */
                throw new IllegalStateException("Decompilation failed");
            }

            private final int g(String string, int n2, int n3) {
                if (n3 - n2 < 2) {
                    return -1;
                }
                char c2 = string.charAt(n2);
                if (V2.k.f(c2, 97) >= 0 && V2.k.f(c2, 122) <= 0 || V2.k.f(c2, 65) >= 0 && V2.k.f(c2, 90) <= 0) {
                    ++n2;
                    while (n2 < n3) {
                        c2 = string.charAt(n2);
                        if ('a' <= c2 && c2 < '{' || 'A' <= c2 && c2 < '[' || '0' <= c2 && c2 < ':' || c2 == '+' || c2 == '-' || c2 == '.') {
                            ++n2;
                            continue;
                        }
                        if (c2 != ':') break;
                        return n2;
                    }
                }
                return -1;
            }

            private final int h(String string, int n2, int n3) {
                char c2;
                int n4 = 0;
                while (n2 < n3 && ((c2 = string.charAt(n2)) == '\\' || c2 == '/')) {
                    ++n4;
                    ++n2;
                }
                return n4;
            }
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(V2.g g2) {
            this();
        }

        public static /* synthetic */ String b(b b2, String string, int n2, int n3, String string2, boolean bl, boolean bl2, boolean bl3, boolean bl4, Charset charset, int n4, Object object) {
            if ((n4 & 1) != 0) {
                n2 = 0;
            }
            if ((n4 & 2) != 0) {
                n3 = string.length();
            }
            if ((n4 & 8) != 0) {
                bl = false;
            }
            if ((n4 & 0x10) != 0) {
                bl2 = false;
            }
            if ((n4 & 0x20) != 0) {
                bl3 = false;
            }
            if ((n4 & 0x40) != 0) {
                bl4 = false;
            }
            if ((n4 & 0x80) != 0) {
                charset = null;
            }
            return b2.a(string, n2, n3, string2, bl, bl2, bl3, bl4, charset);
        }

        private final boolean e(String string, int n2, int n3) {
            int n4 = n2 + 2;
            return n4 < n3 && string.charAt(n2) == '%' && n3.d.H(string.charAt(n2 + 1)) != -1 && n3.d.H(string.charAt(n4)) != -1;
        }

        public static /* synthetic */ String g(b b2, String string, int n2, int n3, boolean bl, int n4, Object object) {
            if ((n4 & 1) != 0) {
                n2 = 0;
            }
            if ((n4 & 2) != 0) {
                n3 = string.length();
            }
            if ((n4 & 4) != 0) {
                bl = false;
            }
            return b2.f(string, n2, n3, bl);
        }

        /*
         * Enabled aggressive block sorting
         */
        private final void k(z3.b b2, String string, int n2, int n3, String string2, boolean bl, boolean bl2, boolean bl3, boolean bl4, Charset charset) {
            Object object = null;
            while (n2 < n3) {
                int n4 = string.codePointAt(n2);
                if (!bl || n4 != 9 && n4 != 10 && n4 != 12 && n4 != 13) {
                    Object object2;
                    if (n4 == 43 && bl3) {
                        object2 = bl ? "+" : "%2B";
                        b2.U0((String)object2);
                    } else if (!(n4 < 32 || n4 == 127 || n4 >= 128 && !bl4 || b3.h.I(string2, (char)n4, false, 2, null) || n4 == 37 && (!bl || bl2 && !this.e(string, n2, n3)))) {
                        b2.W0(n4);
                    } else {
                        object2 = object;
                        if (object == null) {
                            object2 = new z3.b();
                        }
                        if (charset != null && !V2.k.a(charset, StandardCharsets.UTF_8)) {
                            ((z3.b)object2).T0(string, n2, Character.charCount((int)n4) + n2, charset);
                        } else {
                            ((z3.b)object2).W0(n4);
                        }
                        while (true) {
                            object = object2;
                            if (((z3.b)object2).O()) break;
                            byte by = ((z3.b)object2).G0();
                            b2.P0(37);
                            b2.P0(l[(by & 0xFF) >> 4 & 0xF]);
                            b2.P0(l[by & 0xF]);
                        }
                    }
                }
                n2 += Character.charCount((int)n4);
            }
            return;
        }

        private final void l(z3.b b2, String string, int n2, int n3, boolean bl) {
            while (n2 < n3) {
                int n4;
                int n5 = string.codePointAt(n2);
                if (n5 == 37 && (n4 = n2 + 2) < n3) {
                    int n6 = n3.d.H(string.charAt(n2 + 1));
                    int n7 = n3.d.H(string.charAt(n4));
                    if (n6 != -1 && n7 != -1) {
                        b2.P0((n6 << 4) + n7);
                        n2 = Character.charCount((int)n5) + n4;
                        continue;
                    }
                } else if (n5 == 43 && bl) {
                    b2.P0(32);
                    ++n2;
                    continue;
                }
                b2.W0(n5);
                n2 += Character.charCount((int)n5);
            }
        }

        public final String a(String string, int n2, int n3, String string2, boolean bl, boolean bl2, boolean bl3, boolean bl4, Charset charset) {
            int n4;
            V2.k.e(string, "<this>");
            V2.k.e(string2, "encodeSet");
            for (int i2 = n2; i2 < n3; i2 += Character.charCount((int)n4)) {
                n4 = string.codePointAt(i2);
                if (!(n4 < 32 || n4 == 127 || n4 >= 128 && !bl4 || b3.h.I(string2, (char)n4, false, 2, null) || n4 == 37 && (!bl || bl2 && !this.e(string, i2, n3)) || n4 == 43 && bl3)) {
                    continue;
                }
                z3.b b2 = new z3.b();
                b2.V0(string, n2, i2);
                this.k(b2, string, i2, n3, string2, bl, bl2, bl3, bl4, charset);
                return b2.l0();
            }
            string = string.substring(n2, n3);
            V2.k.d(string, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return string;
        }

        public final int c(String string) {
            V2.k.e(string, "scheme");
            if (V2.k.a(string, "http")) {
                return 80;
            }
            if (V2.k.a(string, "https")) {
                return 443;
            }
            return -1;
        }

        public final t d(String string) {
            V2.k.e(string, "<this>");
            return new a().o(null, string).a();
        }

        public final String f(String string, int n2, int n3, boolean bl) {
            V2.k.e(string, "<this>");
            for (int i2 = n2; i2 < n3; ++i2) {
                char c2 = string.charAt(i2);
                if (!(c2 == '%' || c2 == '+' && bl)) {
                    continue;
                }
                z3.b b2 = new z3.b();
                b2.V0(string, n2, i2);
                this.l(b2, string, i2, n3, bl);
                return b2.l0();
            }
            string = string.substring(n2, n3);
            V2.k.d(string, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return string;
        }

        public final void h(List list, StringBuilder stringBuilder) {
            V2.k.e(list, "<this>");
            V2.k.e(stringBuilder, "out");
            int n2 = list.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                stringBuilder.append('/');
                stringBuilder.append((String)list.get(i2));
            }
        }

        public final List i(String string) {
            V2.k.e(string, "<this>");
            ArrayList arrayList = new ArrayList();
            int n2 = 0;
            while (n2 <= string.length()) {
                String string2;
                int n3;
                int n4 = n3 = b3.h.R(string, '&', n2, false, 4, null);
                if (n3 == -1) {
                    n4 = string.length();
                }
                if ((n3 = b3.h.R(string, '=', n2, false, 4, null)) != -1 && n3 <= n4) {
                    string2 = string.substring(n2, n3);
                    V2.k.d(string2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    arrayList.add((Object)string2);
                    string2 = string.substring(n3 + 1, n4);
                    V2.k.d(string2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    arrayList.add((Object)string2);
                } else {
                    string2 = string.substring(n2, n4);
                    V2.k.d(string2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    arrayList.add((Object)string2);
                    arrayList.add(null);
                }
                n2 = n4 + 1;
            }
            return arrayList;
        }

        public final void j(List list, StringBuilder stringBuilder) {
            block8: {
                int n2;
                int n3;
                int n4;
                Object object;
                block7: {
                    int n5;
                    block6: {
                        V2.k.e(list, "<this>");
                        V2.k.e(stringBuilder, "out");
                        object = Y2.d.g(Y2.d.h(0, list.size()), 2);
                        n5 = ((Y2.a)object).c();
                        n4 = ((Y2.a)object).f();
                        n3 = ((Y2.a)object).h();
                        if (n3 <= 0) break block6;
                        n2 = n5;
                        if (n5 <= n4) break block7;
                    }
                    if (n3 >= 0 || n4 > n5) break block8;
                    n2 = n5;
                }
                while (true) {
                    String string = (String)list.get(n2);
                    object = (String)list.get(n2 + 1);
                    if (n2 > 0) {
                        stringBuilder.append('&');
                    }
                    stringBuilder.append(string);
                    if (object != null) {
                        stringBuilder.append('=');
                        stringBuilder.append((String)object);
                    }
                    if (n2 == n4) break;
                    n2 += n3;
                }
            }
        }
    }
}

