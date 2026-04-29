/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package H3;

import F3.h;
import F3.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class c
extends ArrayList {
    public c() {
    }

    public c(int n2) {
        super(n2);
    }

    public c(List list) {
        super((Collection)list);
    }

    public c c() {
        c c2 = new c(this.size());
        int n2 = this.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = this.get(i2);
            c2.add(((h)object).e0());
        }
        return c2;
    }

    public String h() {
        StringBuilder stringBuilder = E3.c.b();
        int n2 = this.size();
        int n3 = 0;
        while (n3 < n2) {
            Object object = this.get(n3);
            ++n3;
            object = (h)object;
            if (stringBuilder.length() != 0) {
                stringBuilder.append("\n");
            }
            stringBuilder.append(((m)object).z());
        }
        return E3.c.n(stringBuilder);
    }

    public c i() {
        int n2 = this.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = this.get(i2);
            ((h)object).I();
        }
        return this;
    }

    public String k() {
        StringBuilder stringBuilder = E3.c.b();
        int n2 = this.size();
        int n3 = 0;
        while (n3 < n2) {
            Object object = this.get(n3);
            ++n3;
            object = (h)object;
            if (stringBuilder.length() != 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(((h)object).H0());
        }
        return E3.c.n(stringBuilder);
    }

    public String toString() {
        return this.h();
    }
}

