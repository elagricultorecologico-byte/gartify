/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.ProtocolException
 */
package s3;

import V2.g;
import b3.h;
import java.net.ProtocolException;
import m3.x;

public final class k {
    public static final a d = new a(null);
    public final x a;
    public final int b;
    public final String c;

    public k(x x2, int n2, String string) {
        V2.k.e((Object)x2, "protocol");
        V2.k.e(string, "message");
        this.a = x2;
        this.b = n2;
        this.c = string;
    }

    public String toString() {
        Object object = new StringBuilder();
        if (this.a == x.i) {
            object.append("HTTP/1.0");
        } else {
            object.append("HTTP/1.1");
        }
        object.append(' ');
        object.append(this.b);
        object.append(' ');
        object.append(this.c);
        object = object.toString();
        V2.k.d(object, "StringBuilder().apply(builderAction).toString()");
        return object;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public final k a(String string) {
            x x2;
            int n2;
            int n3;
            V2.k.e(string, "statusLine");
            if (h.E(string, "HTTP/1.", false, 2, null)) {
                n3 = string.length();
                n2 = 9;
                if (n3 < 9 || string.charAt(8) != ' ') throw new ProtocolException(V2.k.j("Unexpected status line: ", string));
                n3 = string.charAt(7) - 48;
                if (n3 != 0) {
                    if (n3 != 1) throw new ProtocolException(V2.k.j("Unexpected status line: ", string));
                    x2 = x.j;
                } else {
                    x2 = x.i;
                }
            } else {
                if (!h.E(string, "ICY ", false, 2, null)) throw new ProtocolException(V2.k.j("Unexpected status line: ", string));
                x2 = x.i;
                n2 = 4;
            }
            int n4 = string.length();
            n3 = n2 + 3;
            if (n4 < n3) throw new ProtocolException(V2.k.j("Unexpected status line: ", string));
            try {
                String string2 = string.substring(n2, n3);
                V2.k.d(string2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                n4 = Integer.parseInt((String)string2);
            }
            catch (NumberFormatException numberFormatException) {
                throw new ProtocolException(V2.k.j("Unexpected status line: ", string));
            }
            if (string.length() > n3) {
                if (string.charAt(n3) != ' ') throw new ProtocolException(V2.k.j("Unexpected status line: ", string));
                string = string.substring(n2 + 4);
                V2.k.d(string, "this as java.lang.String).substring(startIndex)");
                return new k(x2, n4, string);
            } else {
                string = "";
            }
            return new k(x2, n4, string);
        }
    }
}

