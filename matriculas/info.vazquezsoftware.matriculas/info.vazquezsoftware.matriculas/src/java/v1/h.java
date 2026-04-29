/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 */
package v1;

import u1.d;

public final class h
extends UnsupportedOperationException {
    private final d g;

    public h(d d2) {
        this.g = d2;
    }

    public String getMessage() {
        return "Missing ".concat(String.valueOf((Object)this.g));
    }
}

