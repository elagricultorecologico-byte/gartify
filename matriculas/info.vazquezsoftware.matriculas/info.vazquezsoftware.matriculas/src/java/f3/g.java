/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package F3;

import D3.e;
import E3.c;
import F3.f;
import F3.l;

public class g
extends l {
    public g(String string, String string2, String string3) {
        e.j(string);
        e.j(string2);
        e.j(string3);
        this.c("name", string);
        this.c("publicId", string2);
        this.c("systemId", string3);
        this.Y();
    }

    private boolean W(String string) {
        return c.g(this.d(string)) ^ true;
    }

    private void Y() {
        if (this.W("publicId")) {
            this.c("pubSysKey", "PUBLIC");
            return;
        }
        if (this.W("systemId")) {
            this.c("pubSysKey", "SYSTEM");
        }
    }

    @Override
    void B(Appendable appendable, int n2, f.a a2) {
        if (a2.o() == f.a.a.g && !this.W("publicId") && !this.W("systemId")) {
            appendable.append((CharSequence)"<!doctype");
        } else {
            appendable.append((CharSequence)"<!DOCTYPE");
        }
        if (this.W("name")) {
            appendable.append((CharSequence)" ").append((CharSequence)this.d("name"));
        }
        if (this.W("pubSysKey")) {
            appendable.append((CharSequence)" ").append((CharSequence)this.d("pubSysKey"));
        }
        if (this.W("publicId")) {
            appendable.append((CharSequence)" \"").append((CharSequence)this.d("publicId")).append('\"');
        }
        if (this.W("systemId")) {
            appendable.append((CharSequence)" \"").append((CharSequence)this.d("systemId")).append('\"');
        }
        appendable.append('>');
    }

    @Override
    void C(Appendable appendable, int n2, f.a a2) {
    }

    public void X(String string) {
        if (string != null) {
            this.c("pubSysKey", string);
        }
    }

    @Override
    public String x() {
        return "#doctype";
    }
}

