/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Character
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package G3;

import D3.e;
import E3.c;

public class j {
    private String a;
    private int b = 0;

    public j(String string) {
        e.j(string);
        this.a = string;
    }

    private int r() {
        return this.a.length() - this.b;
    }

    public static String s(String object) {
        StringBuilder stringBuilder = c.b();
        object = object.toCharArray();
        int n2 = ((Object)object).length;
        Object object2 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object3 = object[i2];
            if (object3 == 92) {
                if (object2 == 92) {
                    stringBuilder.append((char)object3);
                }
            } else {
                stringBuilder.append((char)object3);
            }
            object2 = object3;
        }
        return c.n(stringBuilder);
    }

    /*
     * Unable to fully structure code
     */
    public String a(char var1_1, char var2_2) {
        var15_3 = 0;
        var4_4 = -1;
        var3_5 = -1;
        var10_6 = 0;
        var9_8 = var6_7 = 0;
        while (!this.j()) {
            block18: {
                var16_16 = this.c();
                var11_12 = var10_6;
                var8_11 = var6_7;
                var12_13 = var9_8;
                var13_14 = var4_4;
                if (var15_3 == 92) ** GOTO lbl63
                if (var16_16 == '\'' && var16_16 != var1_1 && var10_6 == 0) {
                    var7_10 = var9_8 ^ 1;
                    var5_9 = var10_6;
                } else {
                    var5_9 = var10_6;
                    var7_10 = var9_8;
                    if (var16_16 == '\"') {
                        var5_9 = var10_6;
                        var7_10 = var9_8;
                        if (var16_16 != var1_1) {
                            var5_9 = var10_6;
                            var7_10 = var9_8;
                            if (var9_8 == 0) {
                                var5_9 = var10_6 ^ 1;
                                var7_10 = var9_8;
                            }
                        }
                    }
                }
                var11_12 = var15_3;
                var10_6 = var5_9;
                var8_11 = var6_7++;
                var9_8 = var7_10;
                var13_14 = var4_4;
                var14_15 = var3_5;
                if (var7_10 != 0) break block18;
                if (var5_9 != 0) {
                    var11_12 = var15_3;
                    var10_6 = var5_9;
                    var8_11 = var6_7;
                    var9_8 = var7_10;
                    var13_14 = var4_4;
                    var14_15 = var3_5;
                } else {
                    if (var16_16 == var1_1) {
                        var11_12 = var5_9;
                        var8_11 = var6_7;
                        var12_13 = var7_10;
                        var13_14 = var4_4;
                        if (var4_4 == -1) {
                            var13_14 = this.b;
                            var11_12 = var5_9;
                            var8_11 = var6_7;
                            var12_13 = var7_10;
                        }
                    } else {
                        var11_12 = var5_9;
                        var8_11 = var6_7;
                        var12_13 = var7_10;
                        var13_14 = var4_4;
                        if (var16_16 == var2_2) {
                            var8_11 = var6_7 - 1;
                            var13_14 = var4_4;
                            var12_13 = var7_10;
                            var11_12 = var5_9;
                        }
                    }
lbl63:
                    // 5 sources

                    var14_15 = var3_5;
                    if (var8_11 > 0) {
                        var14_15 = var3_5;
                        if (var15_3 != 0) {
                            var14_15 = this.b;
                        }
                    }
                    var3_5 = var16_16;
                    var9_8 = var12_13;
                    var10_6 = var11_12;
                    var11_12 = var3_5;
                }
            }
            var15_3 = var11_12;
            var6_7 = var8_11;
            var4_4 = var13_14;
            var3_5 = var14_15;
            if (var8_11 > 0) continue;
            var3_5 = var14_15;
            var4_4 = var13_14;
            var6_7 = var8_11;
            break;
        }
        var17_17 = var3_5 >= 0 ? this.a.substring(var4_4, var3_5) : "";
        if (var6_7 > 0) {
            var18_18 = new StringBuilder();
            var18_18.append("Did not find balanced marker at '");
            var18_18.append(var17_17);
            var18_18.append("'");
            e.a(var18_18.toString());
        }
        return var17_17;
    }

    public String b(String string) {
        String string2 = this.g(string);
        this.k(string);
        return string2;
    }

    public char c() {
        String string = this.a;
        int n2 = this.b;
        this.b = n2 + 1;
        return string.charAt(n2);
    }

    public void d(String string) {
        if (this.l(string)) {
            int n2 = string.length();
            if (n2 <= this.r()) {
                this.b += n2;
                return;
            }
            throw new IllegalStateException("Queue not long enough to consume sequence");
        }
        throw new IllegalStateException("Queue did not match expected sequence");
    }

    public String e() {
        int n2 = this.b;
        while (!this.j() && (this.p() || this.m('-', '_'))) {
            ++this.b;
        }
        return this.a.substring(n2, this.b);
    }

    public String f() {
        int n2 = this.b;
        while (!this.j() && (this.p() || this.n("*|", "|", "_", "-"))) {
            ++this.b;
        }
        return this.a.substring(n2, this.b);
    }

    public String g(String string) {
        int n2 = this.a.indexOf(string, this.b);
        if (n2 != -1) {
            string = this.a.substring(this.b, n2);
            this.b += string.length();
            return string;
        }
        return this.q();
    }

    public String h(String ... stringArray) {
        int n2 = this.b;
        while (!this.j() && !this.n(stringArray)) {
            ++this.b;
        }
        return this.a.substring(n2, this.b);
    }

    public boolean i() {
        boolean bl = false;
        while (this.o()) {
            ++this.b;
            bl = true;
        }
        return bl;
    }

    public boolean j() {
        return this.r() == 0;
    }

    public boolean k(String string) {
        if (this.l(string)) {
            this.b += string.length();
            return true;
        }
        return false;
    }

    public boolean l(String string) {
        return this.a.regionMatches(true, this.b, string, 0, string.length());
    }

    public boolean m(char ... cArray) {
        if (this.j()) {
            return false;
        }
        for (char c2 : cArray) {
            if (this.a.charAt(this.b) != c2) continue;
            return true;
        }
        return false;
    }

    public boolean n(String ... stringArray) {
        int n2 = stringArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!this.l(stringArray[i2])) continue;
            return true;
        }
        return false;
    }

    public boolean o() {
        return !this.j() && c.j(this.a.charAt(this.b));
    }

    public boolean p() {
        return !this.j() && Character.isLetterOrDigit((char)this.a.charAt(this.b));
    }

    public String q() {
        String string = this.a.substring(this.b);
        this.b = this.a.length();
        return string;
    }

    public String toString() {
        return this.a.substring(this.b);
    }
}

