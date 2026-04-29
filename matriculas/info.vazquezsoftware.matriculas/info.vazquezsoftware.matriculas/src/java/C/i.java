/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package C;

import D.h;
import android.util.Base64;
import java.util.List;

public final class i {
    private final String a;
    private final String b;
    private final String c;
    private final List d;
    private final int e;
    private final String f;

    public i(String string, String string2, String string3, List list) {
        this.a = (String)h.g(string);
        this.b = (String)h.g(string2);
        this.c = (String)h.g(string3);
        this.d = (List)h.g(list);
        this.e = 0;
        this.f = this.a(string, string2, string3);
    }

    private String a(String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("-");
        stringBuilder.append(string2);
        stringBuilder.append("-");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public List b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    String d() {
        return this.f;
    }

    public String e() {
        return this.a;
    }

    public String f() {
        return this.b;
    }

    public String g() {
        return this.c;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("FontRequest {mProviderAuthority: ");
        stringBuilder2.append(this.a);
        stringBuilder2.append(", mProviderPackage: ");
        stringBuilder2.append(this.b);
        stringBuilder2.append(", mQuery: ");
        stringBuilder2.append(this.c);
        stringBuilder2.append(", mCertificates:");
        stringBuilder.append(stringBuilder2.toString());
        for (int i2 = 0; i2 < this.d.size(); ++i2) {
            stringBuilder.append(" [");
            stringBuilder2 = (List)this.d.get(i2);
            for (int i3 = 0; i3 < stringBuilder2.size(); ++i3) {
                stringBuilder.append(" \"");
                stringBuilder.append(Base64.encodeToString((byte[])((byte[])stringBuilder2.get(i3)), (int)0));
                stringBuilder.append("\"");
            }
            stringBuilder.append(" ]");
        }
        stringBuilder.append("}");
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("mCertificatesArray: ");
        stringBuilder2.append(this.e);
        stringBuilder.append(stringBuilder2.toString());
        return stringBuilder.toString();
    }
}

