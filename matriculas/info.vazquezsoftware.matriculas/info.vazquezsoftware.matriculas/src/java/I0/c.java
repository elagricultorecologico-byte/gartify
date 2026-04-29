/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  R0.a
 *  android.content.Context
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package I0;

import I0.h;
import R0.a;
import android.content.Context;

final class c
extends h {
    private final Context a;
    private final a b;
    private final a c;
    private final String d;

    c(Context context, a a2, a a3, String string) {
        if (context != null) {
            this.a = context;
            if (a2 != null) {
                this.b = a2;
                if (a3 != null) {
                    this.c = a3;
                    if (string != null) {
                        this.d = string;
                        return;
                    }
                    throw new NullPointerException("Null backendName");
                }
                throw new NullPointerException("Null monotonicClock");
            }
            throw new NullPointerException("Null wallClock");
        }
        throw new NullPointerException("Null applicationContext");
    }

    @Override
    public Context b() {
        return this.a;
    }

    @Override
    public String c() {
        return this.d;
    }

    @Override
    public a d() {
        return this.c;
    }

    @Override
    public a e() {
        return this.b;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        return object instanceof h && this.a.equals((Object)((h)(object = (h)object)).b()) && this.b.equals((Object)((h)object).e()) && this.c.equals((Object)((h)object).d()) && this.d.equals((Object)((h)object).c());
    }

    public int hashCode() {
        return (((this.a.hashCode() ^ 0xF4243) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode()) * 1000003 ^ this.d.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CreationContext{applicationContext=");
        stringBuilder.append((Object)this.a);
        stringBuilder.append(", wallClock=");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(", monotonicClock=");
        stringBuilder.append((Object)this.c);
        stringBuilder.append(", backendName=");
        stringBuilder.append(this.d);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

