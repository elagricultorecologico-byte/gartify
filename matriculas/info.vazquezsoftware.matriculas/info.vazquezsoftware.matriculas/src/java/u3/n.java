/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 */
package u3;

import V2.k;
import java.io.IOException;
import u3.b;

public final class n
extends IOException {
    public final b g;

    public n(b b2) {
        k.e((Object)b2, "errorCode");
        super(k.j("stream was reset: ", (Object)b2));
        this.g = b2;
    }
}

