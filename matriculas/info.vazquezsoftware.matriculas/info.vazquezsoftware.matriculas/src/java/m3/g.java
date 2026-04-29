/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.charset.Charset
 *  java.nio.charset.StandardCharsets
 *  java.util.Collections
 *  java.util.LinkedHashMap
 *  java.util.Locale
 *  java.util.Map
 */
package m3;

import V2.k;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public final class g {
    private final String a;
    private final Map b;

    public g(String string, Map map) {
        k.e(string, "scheme");
        k.e(map, "authParams");
        this.a = string;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object object : map.entrySet()) {
            string = (String)object.getKey();
            object = (String)object.getValue();
            if (string == null) {
                string = null;
            } else {
                Locale locale = Locale.US;
                k.d(locale, "US");
                string = string.toLowerCase(locale);
                k.d(string, "this as java.lang.String).toLowerCase(locale)");
            }
            linkedHashMap.put((Object)string, object);
        }
        string = Collections.unmodifiableMap((Map)linkedHashMap);
        k.d(string, "unmodifiableMap<String?, String>(newAuthParams)");
        this.b = string;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Charset a() {
        String string = (String)this.b.get((Object)"charset");
        if (string != null) {
            try {
                string = Charset.forName((String)string);
                k.d(string, "forName(charset)");
                return string;
            }
            catch (Exception exception) {}
        }
        string = StandardCharsets.ISO_8859_1;
        k.d(string, "ISO_8859_1");
        return string;
    }

    public final String b() {
        return (String)this.b.get((Object)"realm");
    }

    public final String c() {
        return this.a;
    }

    public boolean equals(Object object) {
        if (object instanceof g) {
            object = (g)object;
            if (k.a(((g)object).a, this.a) && k.a(((g)object).b, this.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (899 + this.a.hashCode()) * 31 + this.b.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append(" authParams=");
        stringBuilder.append((Object)this.b);
        return stringBuilder.toString();
    }
}

