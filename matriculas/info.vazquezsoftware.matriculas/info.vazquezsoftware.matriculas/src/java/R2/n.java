/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package r2;

import android.content.Context;

public class n {
    private Context a;

    public n(Context context) {
        this.a = context;
    }

    private boolean a(char c3) {
        return c3 >= 'A' && c3 <= 'Z';
    }

    private boolean b(String string) {
        if (string.length() != 7) {
            return false;
        }
        return this.n(string.substring(0, 4)) && this.m(string.substring(4));
    }

    private boolean c(char c3) {
        return c3 >= '0' && c3 <= '9';
    }

    private boolean d(String string) {
        int n2;
        string = this.l(string);
        String[] stringArray = new String[]{"VI", "AB", "A", "AL", "AV", "BA", "IB", "B", "BU", "CC", "CA", "CS", "CE", "CR", "CO", "C", "CU", "GI", "GR", "GU", "SS", "H", "HU", "J", "LE", "L", "LO", "LU", "M", "MA", "ML", "MU", "NA", "OU", "O", "P", "GC", "PO", "PM", "SA", "TF", "S", "SG", "SE", "SO", "T", "TE", "TO", "V", "VA", "BI", "ZA", "Z"};
        if (this.a(string.charAt(0)) && this.a(string.charAt(1))) {
            for (n2 = 0; n2 < 53; ++n2) {
                if (stringArray[n2].length() != 2 || string.charAt(0) != stringArray[n2].charAt(0) || string.charAt(1) != stringArray[n2].charAt(1)) continue;
                return true;
            }
        }
        if (this.a(string.charAt(0)) && this.c(string.charAt(1))) {
            for (n2 = 0; n2 < 53; ++n2) {
                if (stringArray[n2].length() != 1 || string.charAt(0) != stringArray[n2].charAt(0)) continue;
                return true;
            }
        }
        return false;
    }

    private boolean e(String string) {
        return this.d(string) && this.c(string.charAt(string.length() - 1));
    }

    private boolean g(char c3) {
        return c3 == 'A' || c3 == 'E' || c3 == 'I' || c3 == 'O' || c3 == 'U';
    }

    private boolean m(String string) {
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (this.a(string.charAt(i2)) && !this.g(string.charAt(i2))) {
                continue;
            }
            return false;
        }
        return true;
    }

    private boolean n(String string) {
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (this.c(string.charAt(i2))) continue;
            return false;
        }
        return true;
    }

    public boolean f(String string) {
        if (string.length() < 6) {
            return false;
        }
        return this.d(string) && this.a(string.charAt(string.length() - 1));
    }

    public String h(String string) {
        if (this.b(string)) {
            return this.i(string);
        }
        if (this.d(string)) {
            if (this.e(string)) {
                return this.j(string);
            }
            if (this.f(string)) {
                return this.k(string);
            }
        }
        return null;
    }

    public String i(String string) {
        string = this.l(string);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  ");
        stringBuilder.append(string.substring(0, 4));
        stringBuilder.append(" ");
        stringBuilder.append(string.substring(4));
        return stringBuilder.toString();
    }

    public String j(String string) {
        if (this.a((string = this.l(string)).charAt(1))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string.substring(0, 2));
            stringBuilder.append(" ");
            stringBuilder.append(string.substring(2));
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string.substring(0, 1));
        stringBuilder.append(" ");
        stringBuilder.append(string.substring(1));
        return stringBuilder.toString();
    }

    public String k(String string) {
        String string2 = this.l(string);
        if (this.a(string2.charAt(1))) {
            string = new StringBuilder();
            string.append(string2.substring(0, 2));
            string.append(" ");
            string.append(string2.substring(2, 6));
            string.append(" ");
            string = string.toString();
        } else {
            string = new StringBuilder();
            string.append(string2.substring(0, 1));
            string.append(" ");
            string.append(string2.substring(1, 5));
            string.append(" ");
            string = string.toString();
        }
        if (this.a(string2.charAt(string2.length() - 2))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(string2.charAt(string2.length() - 2));
            stringBuilder.append("");
            stringBuilder.append(string2.charAt(string2.length() - 1));
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(string2.charAt(string2.length() - 1));
        return stringBuilder.toString();
    }

    public String l(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        string = string.toUpperCase();
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (!this.a(string.charAt(i2)) && !this.c(string.charAt(i2))) continue;
            stringBuilder.append(string.charAt(i2));
        }
        return stringBuilder.toString();
    }

    public int o(String string) {
        if (this.b(string = this.l(string))) {
            return 0;
        }
        if (this.f(string)) {
            return 1;
        }
        if (this.e(string)) {
            return 2;
        }
        return -1;
    }
}

