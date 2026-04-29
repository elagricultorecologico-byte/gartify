/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Objects
 */
package r0;

import java.util.Objects;
import r0.f;

public class e {
    private final f[] a;
    private final String b;
    private final byte[] c;
    private final int d;

    public e(String string, f[] fArray) {
        this.b = string;
        this.c = null;
        this.a = fArray;
        this.d = 0;
    }

    public e(byte[] byArray, f[] fArray) {
        Objects.requireNonNull((Object)byArray);
        this.c = byArray;
        this.b = null;
        this.a = fArray;
        this.d = 1;
    }

    private void a(int n2) {
        if (n2 == this.d) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Wrong data accessor type detected. ");
        stringBuilder.append(this.c(this.d));
        stringBuilder.append(" expected, but got ");
        stringBuilder.append(this.c(n2));
        throw new IllegalStateException(stringBuilder.toString());
    }

    private String c(int n2) {
        if (n2 != 0) {
            if (n2 != 1) {
                return "Unknown";
            }
            return "ArrayBuffer";
        }
        return "String";
    }

    public String b() {
        this.a(0);
        return this.b;
    }
}

