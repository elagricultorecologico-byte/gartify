/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Reader
 *  java.io.StringReader
 *  java.lang.Object
 *  java.lang.String
 */
package G3;

import G3.b;
import G3.e;
import G3.f;
import G3.m;
import G3.n;
import java.io.Reader;
import java.io.StringReader;

public class g {
    private m a;
    private e b;
    private f c;

    public g(m m2) {
        this.a = m2;
        this.c = m2.b();
        this.b = e.h();
    }

    public static g b() {
        return new g(new b());
    }

    public static g g() {
        return new g(new n());
    }

    public e a() {
        return this.b;
    }

    public F3.f c(Reader reader, String string) {
        return this.a.e(reader, string, this);
    }

    public F3.f d(String string, String string2) {
        return this.a.e((Reader)new StringReader(string), string2, this);
    }

    public f e() {
        return this.c;
    }

    public g f(f f2) {
        this.c = f2;
        return this;
    }
}

