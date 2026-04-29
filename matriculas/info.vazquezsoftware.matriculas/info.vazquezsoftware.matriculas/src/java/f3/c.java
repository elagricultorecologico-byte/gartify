/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package F3;

import C3.e;
import F3.f;
import F3.p;
import java.io.IOException;

public class c
extends p {
    public c(String string) {
        super(string);
    }

    @Override
    void B(Appendable appendable, int n2, f.a a2) {
        appendable.append((CharSequence)"<![CDATA[").append((CharSequence)this.X());
    }

    @Override
    void C(Appendable appendable, int n2, f.a a2) {
        try {
            appendable.append((CharSequence)"]]>");
            return;
        }
        catch (IOException iOException) {
            throw new e(iOException);
        }
    }

    public c a0() {
        return (c)super.W();
    }

    @Override
    public String x() {
        return "#cdata";
    }
}

