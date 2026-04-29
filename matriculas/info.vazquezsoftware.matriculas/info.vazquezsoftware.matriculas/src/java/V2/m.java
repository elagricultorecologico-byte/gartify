/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package V2;

import V2.d;
import V2.k;

public final class m
implements d {
    private final Class a;
    private final String b;

    public m(Class clazz, String string) {
        k.e(clazz, "jClass");
        k.e(string, "moduleName");
        this.a = clazz;
        this.b = string;
    }

    @Override
    public Class d() {
        return this.a;
    }

    public boolean equals(Object object) {
        return object instanceof m && k.a(this.d(), ((m)object).d());
    }

    public int hashCode() {
        return this.d().hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Object)this.d());
        stringBuilder.append(" (Kotlin reflection is not available)");
        return stringBuilder.toString();
    }
}

