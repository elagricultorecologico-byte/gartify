/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package u3;

import V2.k;
import b3.h;
import n3.d;

public final class e {
    public static final e a;
    public static final z3.e b;
    private static final String[] c;
    private static final String[] d;
    private static final String[] e;

    static {
        int n2;
        String[] stringArray;
        int n3;
        a = new e();
        b = z3.e.j.c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        c = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        d = new String[64];
        String[] stringArray2 = new String[256];
        Object object = 0;
        for (n3 = 0; n3 < 256; ++n3) {
            stringArray = Integer.toBinaryString((int)n3);
            k.d(stringArray, "toBinaryString(it)");
            stringArray2[n3] = h.z(n3.d.t("%8s", new Object[]{stringArray}), ' ', '0', false, 4, null);
        }
        e = stringArray2;
        stringArray2 = d;
        stringArray2[0] = "";
        stringArray2[1] = "END_STREAM";
        stringArray = (String[])new int[1];
        stringArray[0] = true;
        stringArray2[8] = "PADDED";
        n3 = (int)stringArray[0];
        stringArray2[n3 | 8] = k.j(stringArray2[n3], "|PADDED");
        stringArray2[4] = "END_HEADERS";
        stringArray2[32] = "PRIORITY";
        stringArray2[36] = "END_HEADERS|PRIORITY";
        for (n3 = 0; n3 < 3; ++n3) {
            n2 = (new int[]{4, 32, 36})[n3];
            String string = stringArray[0];
            stringArray2 = d;
            int n4 = string | n2;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((Object)stringArray2[string]);
            stringBuilder.append('|');
            stringBuilder.append((Object)stringArray2[n2]);
            stringArray2[n4] = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append((Object)stringArray2[string]);
            stringBuilder.append('|');
            stringBuilder.append((Object)stringArray2[n2]);
            stringBuilder.append("|PADDED");
            stringArray2[n4 | 8] = stringBuilder.toString();
        }
        n2 = d.length;
        for (n3 = object; n3 < n2; ++n3) {
            stringArray = d;
            if (stringArray[n3] != null) continue;
            stringArray[n3] = e[n3];
        }
    }

    private e() {
    }

    public final String a(int n2, int n3) {
        if (n3 == 0) {
            return "";
        }
        if (n2 != 2 && n2 != 3) {
            if (n2 != 4 && n2 != 6) {
                if (n2 != 7 && n2 != 8) {
                    Object object = d;
                    if (n3 < ((String[])object).length) {
                        object = object[n3];
                        k.b(object);
                    } else {
                        object = e[n3];
                    }
                    if (n2 == 5 && (n3 & 4) != 0) {
                        return h.A((String)object, "HEADERS", "PUSH_PROMISE", false, 4, null);
                    }
                    if (n2 == 0 && (n3 & 0x20) != 0) {
                        return h.A((String)object, "PRIORITY", "COMPRESSED", false, 4, null);
                    }
                    return object;
                }
            } else {
                if (n3 == 1) {
                    return "ACK";
                }
                return e[n3];
            }
        }
        return e[n3];
    }

    public final String b(int n2) {
        String[] stringArray = c;
        if (n2 < stringArray.length) {
            return stringArray[n2];
        }
        return n3.d.t("0x%02x", n2);
    }

    public final String c(boolean bl, int n2, int n3, int n4, int n5) {
        String string = this.b(n4);
        String string2 = this.a(n4, n5);
        String string3 = bl ? "<<" : ">>";
        return n3.d.t("%s 0x%08x %5d %-13s %s", string3, n2, n3, string, string2);
    }
}

