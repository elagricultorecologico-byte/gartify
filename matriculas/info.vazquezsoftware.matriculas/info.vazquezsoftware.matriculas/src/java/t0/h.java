/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.b
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.List
 *  t0.j
 */
package t0;

import androidx.work.b;
import java.util.List;
import t0.j;

public abstract class h {
    private static final String a = j.f((String)"InputMerger");

    public static h a(String string) {
        try {
            h h3 = (h)Class.forName((String)string).newInstance();
            return h3;
        }
        catch (Exception exception) {
            j j3 = j.c();
            String string2 = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Trouble instantiating + ");
            stringBuilder.append(string);
            j3.b(string2, stringBuilder.toString(), new Throwable[]{exception});
            return null;
        }
    }

    public abstract b b(List var1);
}

