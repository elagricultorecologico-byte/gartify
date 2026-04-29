/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  V2.k
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package L2;

import L2.c;
import L2.i;
import L2.j;
import U2.p;
import V2.k;
import java.io.Serializable;

public final class d
implements i,
Serializable {
    private final i g;
    private final i.b h;

    public d(i i2, i.b b2) {
        k.e((Object)i2, (String)"left");
        k.e((Object)b2, (String)"element");
        this.g = i2;
        this.h = b2;
    }

    public static /* synthetic */ String a(String string, i.b b2) {
        return d.e(string, b2);
    }

    private final boolean b(i.b b2) {
        return k.a((Object)this.i(b2.getKey()), (Object)b2);
    }

    private final boolean c(d i2) {
        do {
            if (this.b(i2.h)) continue;
            return false;
        } while ((i2 = i2.g) instanceof d);
        k.c((Object)i2, (String)"null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
        return this.b((i.b)i2);
    }

    private final int d() {
        int n2 = 2;
        i i2 = this;
        while (true) {
            if (!((i2 = i2.g) instanceof d)) {
                i2 = null;
            }
            if (i2 == null) {
                return n2;
            }
            ++n2;
        }
    }

    private static final String e(String string, i.b b2) {
        k.e((Object)string, (String)"acc");
        k.e((Object)b2, (String)"element");
        if (string.length() == 0) {
            return b2.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(", ");
        stringBuilder.append((Object)b2);
        return stringBuilder.toString();
    }

    @Override
    public Object I(Object object, p p2) {
        k.e((Object)p2, (String)"operation");
        return p2.h(this.g.I(object, p2), this.h);
    }

    @Override
    public i c0(i.c object) {
        k.e((Object)object, (String)"key");
        if (this.h.i((i.c)object) != null) {
            return this.g;
        }
        if ((object = this.g.c0((i.c)object)) == this.g) {
            return this;
        }
        if (object == j.g) {
            return this.h;
        }
        return new d((i)object, this.h);
    }

    public boolean equals(Object object) {
        return this == object || object instanceof d && super.d() == this.d() && super.c(this);
        {
        }
    }

    public int hashCode() {
        return this.g.hashCode() + this.h.hashCode();
    }

    @Override
    public i.b i(i.c c2) {
        k.e((Object)c2, (String)"key");
        i i2 = this;
        do {
            i.b b2;
            if ((b2 = ((d)i2).h.i(c2)) == null) continue;
            return b2;
        } while ((i2 = ((d)i2).g) instanceof d);
        return i2.i(c2);
    }

    @Override
    public i s0(i i2) {
        return i.a.b(this, i2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        stringBuilder.append((String)this.I("", new c()));
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

