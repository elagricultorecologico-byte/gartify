/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package k0;

import V2.k;
import android.os.Bundle;
import k0.b;

public final class f {
    private final l0.b a;
    private b.b b;

    public f(l0.b b2) {
        k.e(b2, "impl");
        this.a = b2;
    }

    public final Bundle a(String string) {
        k.e(string, "key");
        return this.a.c(string);
    }

    public final b b(String string) {
        k.e(string, "key");
        return this.a.d(string);
    }

    public final void c(String string, b b2) {
        k.e(string, "key");
        k.e(b2, "provider");
        this.a.j(string, b2);
    }

    public final void d(Class object) {
        k.e(object, "clazz");
        if (this.a.e()) {
            block4: {
                b.b b2;
                b.b b3 = b2 = this.b;
                if (b2 == null) {
                    b3 = new b.b(this);
                }
                this.b = b3;
                try {
                    object.getDeclaredConstructor(null);
                    b3 = this.b;
                    if (b3 == null) break block4;
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    b3 = new StringBuilder();
                    b3.append("Class ");
                    b3.append(object.getSimpleName());
                    b3.append(" must have default constructor in order to be automatically recreated");
                    throw new IllegalArgumentException(b3.toString(), (Throwable)noSuchMethodException);
                }
                object = object.getName();
                k.d(object, "getName(...)");
                b3.b((String)object);
            }
            return;
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
}

