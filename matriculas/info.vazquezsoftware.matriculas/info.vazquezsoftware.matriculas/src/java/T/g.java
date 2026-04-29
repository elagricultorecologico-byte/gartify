/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  V2.k
 *  androidx.fragment.app.f
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 */
package T;

import V2.k;
import androidx.fragment.app.f;

public abstract class g
extends RuntimeException {
    private final f g;

    public g(f f2, String string) {
        k.e((Object)f2, (String)"fragment");
        super(string);
        this.g = f2;
    }

    public final f a() {
        return this.g;
    }
}

