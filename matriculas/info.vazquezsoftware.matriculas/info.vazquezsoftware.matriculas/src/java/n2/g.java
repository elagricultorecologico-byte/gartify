/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  V2.k
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Field
 */
package N2;

import N2.a;
import N2.f;
import N2.i;
import V2.k;
import java.lang.reflect.Field;

public abstract class g {
    private static final void a(int n2, int n3) {
        if (n3 <= n2) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Debug metadata version mismatch. Expected: ");
        stringBuilder.append(n2);
        stringBuilder.append(", got ");
        stringBuilder.append(n3);
        stringBuilder.append(". Please update the Kotlin standard library.");
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    private static final f b(a a2) {
        return (f)a2.getClass().getAnnotation(f.class);
    }

    private static final int c(a object) {
        int n2;
        block4: {
            block3: {
                try {
                    Field field = object.getClass().getDeclaredField("label");
                    field.setAccessible(true);
                    object = field.get(object);
                    object = object instanceof Integer ? (Integer)object : null;
                    if (object == null) break block3;
                }
                catch (Exception exception) {
                    return -1;
                }
                n2 = object.intValue();
                break block4;
            }
            n2 = 0;
        }
        return n2 - 1;
    }

    public static final StackTraceElement d(a object) {
        k.e((Object)object, (String)"<this>");
        f f2 = g.b((a)object);
        if (f2 == null) {
            return null;
        }
        g.a(1, f2.v());
        int n2 = g.c((a)object);
        n2 = n2 < 0 ? -1 : f2.l()[n2];
        String string = i.a.b((a)object);
        if (string == null) {
            object = f2.c();
        } else {
            object = new StringBuilder();
            object.append(string);
            object.append('/');
            object.append(f2.c());
            object = object.toString();
        }
        return new StackTraceElement((String)object, f2.m(), f2.f(), n2);
    }
}

