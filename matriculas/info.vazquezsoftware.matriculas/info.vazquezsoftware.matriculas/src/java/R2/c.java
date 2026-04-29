/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.BufferedReader
 *  java.io.IOException
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.charset.Charset
 *  java.util.Calendar
 */
package r2;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Calendar;
import r2.b;

public class c {
    private Context a;

    public c(Context context) {
        this.a = context;
    }

    private static String a(String string) {
        char[] cArray = new char[6];
        int n2 = string.length();
        int n3 = 0;
        if (n2 == 5) {
            cArray[0] = 32;
            cArray[1] = string.charAt(4);
            cArray[2] = string.charAt(0);
            cArray[3] = string.charAt(1);
            cArray[4] = string.charAt(2);
            cArray[5] = string.charAt(3);
        } else {
            cArray[0] = string.charAt(4);
            cArray[1] = string.charAt(5);
            cArray[2] = string.charAt(0);
            cArray[3] = string.charAt(1);
            cArray[4] = string.charAt(2);
            cArray[5] = string.charAt(3);
        }
        string = new StringBuilder();
        while (n3 < 6) {
            string.append(cArray[n3]);
            ++n3;
        }
        return string.toString();
    }

    private String b(String string) {
        return string.replace((CharSequence)"GE", (CharSequence)"GI").replace((CharSequence)"PM", (CharSequence)"IB").replace((CharSequence)"OR", (CharSequence)"OU");
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private b f(String object) {
        object = this.b((String)object);
        BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader(this.a.getResources().openRawResource(2131820547), Charset.forName((String)"UTF-8")));
        object = this.n((String)object);
        try {
            boolean bl;
            String[] stringArray;
            Object object2;
            block7: {
                bufferedReader.readLine();
                while ((object2 = bufferedReader.readLine()) != null) {
                    stringArray = object2.split(",");
                    object2 = object;
                    if (!this.g(object.charAt(1))) {
                        object2 = new StringBuilder();
                        object2.append(" ");
                        object2.append((String)object);
                        object2 = object2.toString();
                    }
                    bl = false;
                    object = object2;
                    if (stringArray[0].charAt(0) != object2.charAt(0)) continue;
                    object = object2;
                    if (stringArray[0].charAt(1) != object2.charAt(1)) {
                        continue;
                    }
                    break block7;
                }
                return null;
            }
            object = c.a(object2.substring(2));
            int n2 = 1970;
            for (int i2 = 1; i2 < stringArray.length && !bl; ++n2, ++i2) {
                if (object.compareTo(stringArray[i2]) > 0) continue;
                bl = true;
            }
            if (!bl) return null;
            return new b(n2, 6);
        }
        catch (IOException iOException) {
            return null;
        }
    }

    private boolean g(char c3) {
        return c3 >= 'A' && c3 <= 'Z';
    }

    private boolean h(String string) {
        if (string.length() != 7) {
            return false;
        }
        return this.r(string.substring(0, 4)) && this.q(string.substring(4));
    }

    private boolean i(char c3) {
        return c3 >= '0' && c3 <= '9';
    }

    private boolean j(String string) {
        int n2;
        string = this.n(string);
        String[] stringArray = new String[]{"VI", "AB", "A", "AL", "AV", "BA", "IB", "B", "BU", "CC", "CA", "CS", "CE", "CR", "CO", "C", "CU", "GI", "GR", "GU", "SS", "H", "HU", "J", "LE", "L", "LO", "LU", "M", "MA", "ML", "MU", "NA", "OU", "O", "P", "GC", "PO", "SA", "TF", "S", "SG", "SE", "SO", "T", "TE", "TO", "V", "VA", "BI", "ZA", "Z", "PM", "GE", "OR"};
        if (this.g(string.charAt(0)) && this.g(string.charAt(1))) {
            for (n2 = 0; n2 < 55; ++n2) {
                if (stringArray[n2].length() != 2 || string.charAt(0) != stringArray[n2].charAt(0) || string.charAt(1) != stringArray[n2].charAt(1)) continue;
                return true;
            }
        }
        if (this.g(string.charAt(0)) && this.i(string.charAt(1))) {
            for (n2 = 0; n2 < 55; ++n2) {
                if (stringArray[n2].length() != 1 || string.charAt(0) != stringArray[n2].charAt(0)) continue;
                return true;
            }
        }
        return false;
    }

    private String n(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        string = string.toUpperCase();
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (!this.g(string.charAt(i2)) && !this.i(string.charAt(i2))) continue;
            stringBuilder.append(string.charAt(i2));
        }
        return stringBuilder.toString();
    }

    private String o(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string.substring(4));
        stringBuilder.append(string.substring(0, 4));
        return stringBuilder.toString();
    }

    private boolean q(String string) {
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (this.g(string.charAt(i2))) continue;
            return false;
        }
        return true;
    }

    private boolean r(String string) {
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (this.i(string.charAt(i2))) continue;
            return false;
        }
        return true;
    }

    public b c(String string) {
        if (this.h(string)) {
            return this.d(string);
        }
        if (this.l(string)) {
            return this.f(string);
        }
        if (this.k(string)) {
            return this.e(string);
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public b d(String object) {
        object = this.o((String)object);
        BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader(this.a.getResources().openRawResource(2131820548), Charset.forName((String)"UTF-8")));
        boolean bl = false;
        int n2 = 1998;
        int n3 = 0;
        while (true) {
            String[] stringArray = bufferedReader.readLine();
            if (stringArray == null || bl) break;
            stringArray = stringArray.split(",");
            int n4 = 1;
            while (true) {
                int n5;
                boolean bl2;
                block10: {
                    if (n4 >= stringArray.length || bl) break;
                    bl2 = bl;
                    n5 = n3;
                    if (stringArray[n4].length() != 7) break block10;
                    bl2 = bl;
                    n5 = n3;
                    if (object.compareTo(this.o(stringArray[n4])) > 0) break block10;
                    bl2 = true;
                    n5 = n4;
                }
                ++n4;
                bl = bl2;
                n3 = n5;
            }
            ++n2;
        }
        if (!bl) return null;
        try {
            return new b(n2, n3);
        }
        catch (IOException iOException) {
            return null;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public b e(String object) {
        object = this.b((String)object);
        BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader(this.a.getResources().openRawResource(2131820546), Charset.forName((String)"UTF-8")));
        object = this.n((String)object);
        try {
            boolean bl;
            String[] stringArray;
            Object object2;
            String[] stringArray2;
            block7: {
                stringArray2 = bufferedReader.readLine().split(",");
                while ((object2 = bufferedReader.readLine()) != null) {
                    stringArray = object2.split(",");
                    object2 = object;
                    if (!this.g(object.charAt(1))) {
                        object2 = new StringBuilder();
                        object2.append(" ");
                        object2.append((String)object);
                        object2 = object2.toString();
                    }
                    bl = false;
                    object = object2;
                    if (stringArray[0].charAt(0) != object2.charAt(0)) continue;
                    object = object2;
                    if (stringArray[0].charAt(1) != object2.charAt(1)) {
                        continue;
                    }
                    break block7;
                }
                return null;
            }
            int n2 = Integer.parseInt((String)object2.substring(2));
            int n3 = 0;
            for (int i2 = 1; i2 < stringArray.length && !bl; ++n3, ++i2) {
                if (n2 > Integer.parseInt((String)stringArray[i2])) continue;
                bl = true;
            }
            if (!bl) return null;
            return new b(Integer.parseInt((String)stringArray2[n3]), 6);
        }
        catch (IOException | NumberFormatException throwable) {
            return null;
        }
    }

    public boolean k(String string) {
        return this.j(string) && this.i(string.charAt(string.length() - 1));
    }

    public boolean l(String string) {
        if (string.length() < 6) {
            return false;
        }
        return this.j(string) && this.g(string.charAt(string.length() - 1));
    }

    public b m(b b2) {
        int n2 = b2.a();
        int n3 = b2.b();
        b2 = Calendar.getInstance();
        n3 = b2.get(1) * 12 + b2.get(2) - (n2 * 12 + n3);
        int n4 = n3 / 12;
        n3 = n2 = n3 % 12;
        if (n2 < 0) {
            n3 = 0;
        }
        return new b(n4, n3);
    }

    public String p(int n2) {
        if (n2 < 1) {
            return "";
        }
        return this.a.getResources().getStringArray(2130903041)[n2 - 1];
    }
}

