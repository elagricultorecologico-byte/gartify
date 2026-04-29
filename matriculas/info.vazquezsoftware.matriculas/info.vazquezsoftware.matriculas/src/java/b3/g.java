/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.regex.Pattern
 */
package b3;

import V2.k;
import java.io.Serializable;
import java.util.regex.Pattern;

public final class g
implements Serializable {
    public static final a h = new a(null);
    private final Pattern g;

    public g(String string) {
        k.e(string, "pattern");
        string = Pattern.compile((String)string);
        k.d(string, "compile(...)");
        this((Pattern)string);
    }

    public g(Pattern pattern) {
        k.e(pattern, "nativePattern");
        this.g = pattern;
    }

    public final boolean a(CharSequence charSequence) {
        k.e(charSequence, "input");
        return this.g.matcher(charSequence).matches();
    }

    public final String b(CharSequence charSequence, String string) {
        k.e(charSequence, "input");
        k.e(string, "replacement");
        charSequence = this.g.matcher(charSequence).replaceAll(string);
        k.d(charSequence, "replaceAll(...)");
        return charSequence;
    }

    public String toString() {
        String string = this.g.toString();
        k.d(string, "toString(...)");
        return string;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(V2.g g3) {
            this();
        }
    }
}

