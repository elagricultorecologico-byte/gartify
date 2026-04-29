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

public class b
extends IOException {
    private final int g;
    private final String h;

    public b(String string, int n2, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(". Status=");
        stringBuilder.append(n2);
        stringBuilder.append(", URL=[");
        stringBuilder.append(string2);
        stringBuilder.append("]");
        super(stringBuilder.toString());
        this.g = n2;
        this.h = string2;
    }
}

