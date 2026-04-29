/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package G3;

import F3.b;

public class f {
    public static final f c = new f(false, false);
    public static final f d = new f(true, true);
    private final boolean a;
    private final boolean b;

    public f(boolean bl, boolean bl2) {
        this.a = bl;
        this.b = bl2;
    }

    public String a(String string) {
        String string2;
        string = string2 = string.trim();
        if (!this.b) {
            string = E3.b.a(string2);
        }
        return string;
    }

    b b(b b2) {
        if (b2 != null && !this.b) {
            b2.D();
        }
        return b2;
    }

    public String c(String string) {
        String string2;
        string = string2 = string.trim();
        if (!this.a) {
            string = E3.b.a(string2);
        }
        return string;
    }

    public boolean d() {
        return this.b;
    }

    public boolean e() {
        return this.a;
    }
}

