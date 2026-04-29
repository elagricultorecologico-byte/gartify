/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.Locale
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package m3;

import P2.c;
import V2.g;
import V2.k;
import b3.h;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class v {
    public static final a e = new a(null);
    private static final Pattern f = Pattern.compile((String)"([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern g = Pattern.compile((String)";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    private final String a;
    private final String b;
    private final String c;
    private final String[] d;

    private v(String string, String string2, String string3, String[] stringArray) {
        this.a = string;
        this.b = string2;
        this.c = string3;
        this.d = stringArray;
    }

    public /* synthetic */ v(String string, String string2, String string3, String[] stringArray, g g2) {
        this(string, string2, string3, stringArray);
    }

    public static /* synthetic */ Charset d(v v2, Charset charset, int n2, Object object) {
        if ((n2 & 1) != 0) {
            charset = null;
        }
        return v2.c(charset);
    }

    public static final v f(String string) {
        return e.b(string);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Charset c(Charset object) {
        void var1_3;
        String string = this.e("charset");
        if (string == null) {
            return var1_3;
        }
        try {
            String string2 = string = Charset.forName((String)string);
            return var1_3;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return var1_3;
        }
    }

    public final String e(String string) {
        k.e(string, "name");
        int n2 = this.d.length;
        int n3 = 0;
        n2 = P2.c.b(0, n2 - 1, 2);
        if (n2 >= 0) {
            while (true) {
                if (h.u(this.d[n3], string, true)) {
                    return this.d[n3 + 1];
                }
                if (n3 == n2) break;
                n3 += 2;
            }
        }
        return null;
    }

    public boolean equals(Object object) {
        return object instanceof v && k.a(((v)object).a, this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final v a(String string) {
            k.e(string, "<this>");
            Object object = f.matcher((CharSequence)string);
            if (object.lookingAt()) {
                String string2 = object.group(1);
                k.d(string2, "typeSubtype.group(1)");
                Object object2 = Locale.US;
                k.d(object2, "US");
                string2 = string2.toLowerCase(object2);
                k.d(string2, "this as java.lang.String).toLowerCase(locale)");
                String string3 = object.group(2);
                k.d(string3, "typeSubtype.group(2)");
                k.d(object2, "US");
                string3 = string3.toLowerCase(object2);
                k.d(string3, "this as java.lang.String).toLowerCase(locale)");
                ArrayList arrayList = new ArrayList();
                Matcher matcher = g.matcher((CharSequence)string);
                int n2 = object.end();
                while (n2 < string.length()) {
                    matcher.region(n2, string.length());
                    if (matcher.lookingAt()) {
                        String string4 = matcher.group(1);
                        if (string4 == null) {
                            n2 = matcher.end();
                            continue;
                        }
                        object2 = matcher.group(2);
                        if (object2 == null) {
                            object = matcher.group(3);
                        } else {
                            object = object2;
                            if (h.E((String)object2, "'", false, 2, null)) {
                                object = object2;
                                if (h.t((String)object2, "'", false, 2, null)) {
                                    object = object2;
                                    if (object2.length() > 2) {
                                        object = object2.substring(1, object2.length() - 1);
                                        k.d(object, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                    }
                                }
                            }
                        }
                        arrayList.add((Object)string4);
                        arrayList.add(object);
                        n2 = matcher.end();
                        continue;
                    }
                    object2 = new StringBuilder();
                    object2.append("Parameter is not formatted correctly: \"");
                    object = string.substring(n2);
                    k.d(object, "this as java.lang.String).substring(startIndex)");
                    object2.append((String)object);
                    object2.append("\" for: \"");
                    object2.append(string);
                    object2.append('\"');
                    throw new IllegalArgumentException(object2.toString().toString());
                }
                object = arrayList.toArray((Object[])new String[0]);
                if (object != null) {
                    return new v(string, string2, string3, (String[])object, null);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            object = new StringBuilder();
            object.append("No subtype found for: \"");
            object.append(string);
            object.append('\"');
            throw new IllegalArgumentException(object.toString().toString());
        }

        public final v b(String object) {
            k.e(object, "<this>");
            try {
                object = this.a((String)object);
                return object;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                return null;
            }
        }
    }
}

