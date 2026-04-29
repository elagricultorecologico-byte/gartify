/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package h2;

import android.app.PendingIntent;
import h2.b;

final class e
extends b {
    private final PendingIntent g;
    private final boolean h;

    e(PendingIntent pendingIntent, boolean bl) {
        if (pendingIntent != null) {
            this.g = pendingIntent;
            this.h = bl;
            return;
        }
        throw new NullPointerException("Null pendingIntent");
    }

    @Override
    final PendingIntent a() {
        return this.g;
    }

    @Override
    final boolean b() {
        return this.h;
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        return object instanceof b && this.g.equals((Object)((b)(object = (b)object)).a()) && this.h == ((b)object).b();
    }

    public final int hashCode() {
        int n2 = this.g.hashCode();
        int n3 = true != this.h ? 1237 : 1231;
        return (n2 ^ 0xF4243) * 1000003 ^ n3;
    }

    public final String toString() {
        String string = this.g.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ReviewInfo{pendingIntent=");
        stringBuilder.append(string);
        stringBuilder.append(", isNoOp=");
        stringBuilder.append(this.h);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

