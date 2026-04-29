/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package x2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import r2.r;
import x2.a;
import x2.b;
import x2.d;

public abstract class c {
    public static /* synthetic */ void a(String string, a a2) {
        try {
            String string2 = r.b("\u00c3\u00df\u00df\u00db\u00d8\u0091\u0084\u0084\u00dc\u00dc\u00dc\u0085\u00cf\u00c2\u00d8\u00df\u00d9\u00c2\u0086\u00ca\u00de\u00df\u00c4\u0085\u00ce\u00d8");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(string);
            a2.b(c.b(C3.c.a(stringBuilder.toString()).b(15000).get().C0("title").k()));
            return;
        }
        catch (Exception exception) {
            a2.a(exception.getMessage());
            return;
        }
    }

    public static d b(String string) {
        Object object = Pattern.compile((String)"para (.*?)(?= \\(\\d+KW)");
        Pattern pattern = Pattern.compile((String)"(\\d+)CH");
        Object object2 = Pattern.compile((String)"\\((\\d{2}/\\d{4} - (\\d{2}/\\d{4}|\\.\\.\\.))\\)");
        object = object.matcher((CharSequence)string);
        Matcher matcher = pattern.matcher((CharSequence)string);
        pattern = object2.matcher((CharSequence)string);
        boolean bl = object.find();
        object2 = "";
        object = bl ? object.group(1).trim().replaceAll("\\(.*?\\)", "").trim() : "";
        if (matcher.find()) {
            string = new StringBuilder();
            string.append(matcher.group(1).trim());
            string.append("cv");
            object2 = string.toString();
            string = "";
        } else {
            string = "";
        }
        while (pattern.find()) {
            string = pattern.group(1).trim();
        }
        return new d((String)object, (String)object2, string);
    }

    public static void c(String string, a a2) {
        new Thread((Runnable)new b(string, a2)).start();
    }
}

