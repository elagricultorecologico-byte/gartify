/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.logging.Logger
 */
package q3;

import V2.k;
import V2.v;
import java.util.Arrays;
import java.util.logging.Logger;
import q3.a;
import q3.d;
import q3.e;

public abstract class b {
    public static final /* synthetic */ void a(a a2, d d2, String string) {
        b.c(a2, d2, string);
    }

    public static final String b(long l2) {
        Object object;
        if (l2 <= -999500000L) {
            object = new StringBuilder();
            object.append((l2 - (long)500000000) / (long)1000000000);
            object.append(" s ");
            object = object.toString();
        } else if (l2 <= -999500L) {
            object = new StringBuilder();
            object.append((l2 - (long)500000) / (long)1000000);
            object.append(" ms");
            object = object.toString();
        } else if (l2 <= 0L) {
            object = new StringBuilder();
            object.append((l2 - (long)500) / (long)1000);
            object.append(" \u00b5s");
            object = object.toString();
        } else if (l2 < 999500L) {
            object = new StringBuilder();
            object.append((l2 + (long)500) / (long)1000);
            object.append(" \u00b5s");
            object = object.toString();
        } else if (l2 < 999500000L) {
            object = new StringBuilder();
            object.append((l2 + (long)500000) / (long)1000000);
            object.append(" ms");
            object = object.toString();
        } else {
            object = new StringBuilder();
            object.append((l2 + (long)500000000) / (long)1000000000);
            object.append(" s ");
            object = object.toString();
        }
        v v2 = v.a;
        object = String.format((String)"%6s", (Object[])Arrays.copyOf((Object[])new Object[]{object}, (int)1));
        k.d(object, "format(format, *args)");
        return object;
    }

    private static final void c(a a2, d object, String string) {
        Logger logger = e.h.a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((d)object).f());
        stringBuilder.append(' ');
        object = v.a;
        object = String.format((String)"%-22s", (Object[])Arrays.copyOf((Object[])new Object[]{string}, (int)1));
        k.d(object, "format(format, *args)");
        stringBuilder.append((String)object);
        stringBuilder.append(": ");
        stringBuilder.append(a2.b());
        logger.fine(stringBuilder.toString());
    }
}

