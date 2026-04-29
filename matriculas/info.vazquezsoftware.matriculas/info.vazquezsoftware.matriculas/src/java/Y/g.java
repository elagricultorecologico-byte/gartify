/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Q
 *  androidx.lifecycle.S$c
 *  java.lang.AbstractMethodError
 *  java.lang.Object
 */
package Y;

import T2.a;
import V2.k;
import Z2.b;
import androidx.lifecycle.Q;
import androidx.lifecycle.S;

public abstract class g {
    public static final Q a(S.c object, b b3, X.a a3) {
        k.e(object, "factory");
        k.e(b3, "modelClass");
        k.e(a3, "extras");
        try {
            Q q2 = object.b(b3, a3);
            return q2;
        }
        catch (AbstractMethodError abstractMethodError) {
            try {
                a3 = object.c(a.a(b3), a3);
                object = a3;
            }
            catch (AbstractMethodError abstractMethodError2) {
                object = object.a(a.a(b3));
            }
            return object;
        }
    }
}

