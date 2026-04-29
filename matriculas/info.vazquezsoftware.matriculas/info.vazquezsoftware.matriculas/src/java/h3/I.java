/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package H3;

import D3.e;
import H3.c;
import H3.d;
import H3.h;

public abstract class i {
    public static c a(d d2, F3.h h2) {
        e.j(d2);
        e.j(h2);
        return H3.a.a(d2, h2);
    }

    public static c b(String string, F3.h h2) {
        e.h(string);
        return i.a(h.t(string), h2);
    }

    public static F3.h c(String string, F3.h h2) {
        e.h(string);
        return H3.a.b(h.t(string), h2);
    }

    public static class a
    extends IllegalStateException {
        public a(String string, Object ... objectArray) {
            super(String.format((String)string, (Object[])objectArray));
        }
    }
}

