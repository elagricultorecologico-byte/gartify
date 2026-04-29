/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Arrays
 *  java.util.Map$Entry
 */
package F3;

import C3.d;
import D3.e;
import E3.c;
import F3.b;
import F3.f;
import F3.i;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class a
implements Map.Entry,
Cloneable {
    private static final String[] j = new String[]{"allowfullscreen", "async", "autofocus", "checked", "compact", "declare", "default", "defer", "disabled", "formnovalidate", "hidden", "inert", "ismap", "itemscope", "multiple", "muted", "nohref", "noresize", "noshade", "novalidate", "nowrap", "open", "readonly", "required", "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch"};
    private String g;
    private String h;
    b i;

    public a(String string, String string2, b b2) {
        e.j(string);
        string = string.trim();
        e.h(string);
        this.g = string;
        this.h = string2;
        this.i = b2;
    }

    protected static void g(String string, String string2, Appendable appendable, f.a a2) {
        appendable.append((CharSequence)string);
        if (!a.k(string, string2, a2)) {
            appendable.append((CharSequence)"=\"");
            F3.i.e(appendable, b.o(string2), a2, true, false, false);
            appendable.append('\"');
        }
    }

    protected static boolean h(String string) {
        return Arrays.binarySearch((Object[])j, (Object)string) >= 0;
    }

    protected static boolean k(String string, String string2, f.a a2) {
        return a2.o() == f.a.a.g && (string2 == null || (string2.isEmpty() || string2.equalsIgnoreCase(string)) && a.h(string));
    }

    public a a() {
        try {
            a a2 = (a)super.clone();
            return a2;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException((Throwable)cloneNotSupportedException);
        }
    }

    public String b() {
        return this.g;
    }

    public String c() {
        return b.o(this.h);
    }

    public String d() {
        StringBuilder stringBuilder = c.b();
        try {
            f f2 = new f("");
            this.e((Appendable)stringBuilder, f2.R0());
        }
        catch (IOException iOException) {
            throw new d(iOException);
        }
        return c.n(stringBuilder);
    }

    protected void e(Appendable appendable, f.a a2) {
        a.g(this.g, this.h, appendable, a2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            Object object2 = (a)object;
            object = this.g;
            if (object != null ? !object.equals((Object)((a)object2).g) : ((a)object2).g != null) {
                return false;
            }
            object = this.h;
            object2 = ((a)object2).h;
            if (object != null) {
                return object.equals(object2);
            }
            if (object2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String string = this.g;
        int n2 = 0;
        int n3 = string != null ? string.hashCode() : 0;
        string = this.h;
        if (string != null) {
            n2 = string.hashCode();
        }
        return n3 * 31 + n2;
    }

    public String i(String string) {
        Object object = this.h;
        Object object2 = this.i;
        if (object2 != null) {
            object2 = ((b)object2).s(this.g);
            int n2 = this.i.y(this.g);
            object = object2;
            if (n2 != -1) {
                this.i.i[n2] = string;
                object = object2;
            }
        }
        this.h = string;
        return b.o((String)object);
    }

    public String toString() {
        return this.d();
    }
}

