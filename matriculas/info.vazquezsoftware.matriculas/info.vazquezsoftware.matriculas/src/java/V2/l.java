/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  V2.k
 *  V2.t
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package V2;

import V2.h;
import V2.k;
import V2.t;
import java.io.Serializable;

public abstract class l
implements h,
Serializable {
    private final int g;

    public l(int n2) {
        this.g = n2;
    }

    @Override
    public int d() {
        return this.g;
    }

    public String toString() {
        String string = t.f((l)this);
        k.d((Object)string, (String)"renderLambdaToString(...)");
        return string;
    }
}

