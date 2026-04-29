/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package G3;

public class d {
    private int a;
    private String b;

    d(int n2, String string) {
        this.a = n2;
        this.b = string;
    }

    d(int n2, String string, Object ... objectArray) {
        this.b = String.format((String)string, (Object[])objectArray);
        this.a = n2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append(": ");
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }
}

