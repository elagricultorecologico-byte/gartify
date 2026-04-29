/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  java.util.Set
 */
package s0;

import java.util.HashSet;
import java.util.Set;

public abstract class o {
    private static final Set c = new HashSet();
    private final String a;
    private final String b;

    o(String string, String string2) {
        this.a = string;
        this.b = string2;
        c.add((Object)this);
    }

    public static class a
    extends o {
        a(String string, String string2) {
            super(string, string2);
        }
    }

    public static class b
    extends o {
        b(String string, String string2) {
            super(string, string2);
        }
    }
}

