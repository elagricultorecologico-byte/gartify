/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package c3;

import U2.q;
import V2.g;
import c3.h;
import c3.k;

final class w {
    public final Object a;
    public final h b;
    public final q c;
    public final Object d;
    public final Throwable e;

    public w(Object object, h h2, q q2, Object object2, Throwable throwable) {
        this.a = object;
        this.b = h2;
        this.c = q2;
        this.d = object2;
        this.e = throwable;
    }

    public /* synthetic */ w(Object object, h h2, q q2, Object object2, Throwable throwable, int n2, g g2) {
        if ((n2 & 2) != 0) {
            h2 = null;
        }
        if ((n2 & 4) != 0) {
            q2 = null;
        }
        if ((n2 & 8) != 0) {
            object2 = null;
        }
        if ((n2 & 0x10) != 0) {
            throwable = null;
        }
        this(object, h2, q2, object2, throwable);
    }

    public static /* synthetic */ w b(w w2, Object object, h h2, q q2, Object object2, Throwable throwable, int n2, Object object3) {
        if ((n2 & 1) != 0) {
            object = w2.a;
        }
        if ((n2 & 2) != 0) {
            h2 = w2.b;
        }
        if ((n2 & 4) != 0) {
            q2 = w2.c;
        }
        if ((n2 & 8) != 0) {
            object2 = w2.d;
        }
        if ((n2 & 0x10) != 0) {
            throwable = w2.e;
        }
        return w2.a(object, h2, q2, object2, throwable);
    }

    public final w a(Object object, h h2, q q2, Object object2, Throwable throwable) {
        return new w(object, h2, q2, object2, throwable);
    }

    public final boolean c() {
        return this.e != null;
    }

    public final void d(k k2, Throwable throwable) {
        Object object = this.b;
        if (object != null) {
            k2.o((h)object, throwable);
        }
        if ((object = this.c) != null) {
            k2.p((q)object, throwable, this.a);
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof w)) {
            return false;
        }
        object = (w)object;
        if (!V2.k.a(this.a, ((w)object).a)) {
            return false;
        }
        if (!V2.k.a(this.b, ((w)object).b)) {
            return false;
        }
        if (!V2.k.a(this.c, ((w)object).c)) {
            return false;
        }
        if (!V2.k.a(this.d, ((w)object).d)) {
            return false;
        }
        return V2.k.a(this.e, ((w)object).e);
    }

    public int hashCode() {
        Object object = this.a;
        int n2 = 0;
        int n3 = object == null ? 0 : object.hashCode();
        object = this.b;
        int n4 = object == null ? 0 : object.hashCode();
        object = this.c;
        int n5 = object == null ? 0 : object.hashCode();
        object = this.d;
        int n6 = object == null ? 0 : object.hashCode();
        object = this.e;
        if (object != null) {
            n2 = object.hashCode();
        }
        return (((n3 * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CompletedContinuation(result=");
        stringBuilder.append(this.a);
        stringBuilder.append(", cancelHandler=");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(", onCancellation=");
        stringBuilder.append((Object)this.c);
        stringBuilder.append(", idempotentResume=");
        stringBuilder.append(this.d);
        stringBuilder.append(", cancelCause=");
        stringBuilder.append((Object)this.e);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

