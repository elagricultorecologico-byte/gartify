/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.annotation.Annotation
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Map
 */
package m2;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private final String a;
    private final Map b;

    private c(String string, Map map) {
        this.a = string;
        this.b = map;
    }

    public static b a(String string) {
        return new b(string);
    }

    public static c d(String string) {
        return new c(string, Collections.EMPTY_MAP);
    }

    public String b() {
        return this.a;
    }

    public Annotation c(Class clazz) {
        return (Annotation)this.b.get((Object)clazz);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof c)) {
            return false;
        }
        object = (c)object;
        return this.a.equals((Object)((c)object).a) && this.b.equals((Object)((c)object).b);
    }

    public int hashCode() {
        return this.a.hashCode() * 31 + this.b.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FieldDescriptor{name=");
        stringBuilder.append(this.a);
        stringBuilder.append(", properties=");
        stringBuilder.append((Object)this.b.values());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static final class b {
        private final String a;
        private Map b = null;

        b(String string) {
            this.a = string;
        }

        public c a() {
            String string = this.a;
            Map map = this.b == null ? Collections.EMPTY_MAP : Collections.unmodifiableMap((Map)new HashMap(this.b));
            return new c(string, map);
        }

        public b b(Annotation annotation) {
            if (this.b == null) {
                this.b = new HashMap();
            }
            this.b.put((Object)annotation.annotationType(), (Object)annotation);
            return this;
        }
    }
}

