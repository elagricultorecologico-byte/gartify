/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.Proxy$Type
 */
package s3;

import V2.k;
import java.net.Proxy;
import m3.t;
import m3.y;

public final class i {
    public static final i a = new i();

    private i() {
    }

    private final boolean b(y y2, Proxy.Type type) {
        return !y2.f() && type == Proxy.Type.HTTP;
    }

    public final String a(y object, Proxy.Type type) {
        k.e(object, "request");
        k.e(type, "proxyType");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((y)object).g());
        stringBuilder.append(' ');
        i i2 = a;
        if (i2.b((y)object, type)) {
            stringBuilder.append((Object)((y)object).i());
        } else {
            stringBuilder.append(i2.c(((y)object).i()));
        }
        stringBuilder.append(" HTTP/1.1");
        object = stringBuilder.toString();
        k.d(object, "StringBuilder().apply(builderAction).toString()");
        return object;
    }

    public final String c(t t2) {
        k.e(t2, "url");
        String string = t2.d();
        String string2 = t2.f();
        if (string2 != null) {
            t2 = new StringBuilder();
            t2.append(string);
            t2.append('?');
            t2.append(string2);
            return t2.toString();
        }
        return string;
    }
}

