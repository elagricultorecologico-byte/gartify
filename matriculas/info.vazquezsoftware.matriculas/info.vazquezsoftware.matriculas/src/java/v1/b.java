/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Status
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package v1;

import com.google.android.gms.common.api.Status;

public class b
extends Exception {
    protected final Status g;

    public b(Status status) {
        int n2 = status.b();
        String string = status.c() != null ? status.c() : "";
        StringBuilder stringBuilder = new StringBuilder(String.valueOf((int)n2).length() + 2 + String.valueOf((Object)string).length());
        stringBuilder.append(n2);
        stringBuilder.append(": ");
        stringBuilder.append(string);
        super(stringBuilder.toString());
        this.g = status;
    }

    public Status a() {
        return this.g;
    }

    public int b() {
        return this.g.b();
    }
}

