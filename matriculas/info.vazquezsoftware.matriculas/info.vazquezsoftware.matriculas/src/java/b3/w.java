/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.NoSuchElementException
 */
package b3;

import V2.k;
import Y2.d;
import b3.u;
import b3.v;
import java.util.NoSuchElementException;

abstract class w
extends v {
    public static final String u0(String string, int n3) {
        k.e(string, "<this>");
        if (n3 >= 0) {
            string = string.substring(d.c(n3, string.length()));
            k.d(string, "substring(...)");
            return string;
        }
        string = new StringBuilder();
        string.append("Requested character count ");
        string.append(n3);
        string.append(" is less than zero.");
        throw new IllegalArgumentException(string.toString().toString());
    }

    public static char v0(CharSequence charSequence) {
        k.e(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(u.M(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static String w0(String string, int n3) {
        k.e(string, "<this>");
        if (n3 >= 0) {
            string = string.substring(0, d.c(n3, string.length()));
            k.d(string, "substring(...)");
            return string;
        }
        string = new StringBuilder();
        string.append("Requested character count ");
        string.append(n3);
        string.append(" is less than zero.");
        throw new IllegalArgumentException(string.toString().toString());
    }
}

