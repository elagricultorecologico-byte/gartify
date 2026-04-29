/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package C3;

import java.io.IOException;

public class f
extends IOException {
    private final String g;
    private final String h;

    public f(String string, String string2, String string3) {
        super(string);
        this.g = string2;
        this.h = string3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append(". Mimetype=");
        stringBuilder.append(this.g);
        stringBuilder.append(", URL=");
        stringBuilder.append(this.h);
        return stringBuilder.toString();
    }
}

