/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 */
package b3;

import U2.p;
import b3.u;

public final class t
implements p {
    public final char[] g;
    public final boolean h;

    public /* synthetic */ t(char[] cArray, boolean bl) {
        this.g = cArray;
        this.h = bl;
    }

    @Override
    public final Object h(Object object, Object object2) {
        return u.F(this.g, this.h, (CharSequence)object, (Integer)object2);
    }
}

