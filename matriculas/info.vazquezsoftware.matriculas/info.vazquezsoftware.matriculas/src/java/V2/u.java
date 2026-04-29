/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package V2;

import V2.e;
import V2.h;
import V2.i;
import V2.l;
import V2.m;
import V2.n;
import Z2.b;
import Z2.c;
import Z2.d;

public class u {
    public d a(i i3) {
        return i3;
    }

    public b b(Class clazz) {
        return new e(clazz);
    }

    public c c(Class clazz, String string) {
        return new m(clazz, string);
    }

    public Z2.e d(n n3) {
        return n3;
    }

    public String e(h object) {
        String string = object.getClass().getGenericInterfaces()[0].toString();
        object = string;
        if (string.startsWith("kotlin.jvm.functions.")) {
            object = string.substring(21);
        }
        return object;
    }

    public String f(l l3) {
        return this.e(l3);
    }
}

