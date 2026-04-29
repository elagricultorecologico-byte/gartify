/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package t0;

import t0.h;

public abstract class i {
    public static i c() {
        return new i(){

            @Override
            public h a(String string) {
                return null;
            }
        };
    }

    public abstract h a(String var1);

    public final h b(String string) {
        h h3 = this.a(string);
        if (h3 == null) {
            return h.a(string);
        }
        return h3;
    }
}

