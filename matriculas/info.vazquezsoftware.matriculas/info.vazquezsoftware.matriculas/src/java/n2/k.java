/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  V2.k
 *  V2.t
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package N2;

import L2.e;
import N2.d;
import V2.h;
import V2.t;

public abstract class k
extends d
implements h {
    private final int j;

    public k(int n2, e e2) {
        super(e2);
        this.j = n2;
    }

    @Override
    public int d() {
        return this.j;
    }

    @Override
    public String toString() {
        if (this.m() == null) {
            String string = t.e((h)this);
            V2.k.d((Object)string, (String)"renderLambdaToString(...)");
            return string;
        }
        return super.toString();
    }
}

