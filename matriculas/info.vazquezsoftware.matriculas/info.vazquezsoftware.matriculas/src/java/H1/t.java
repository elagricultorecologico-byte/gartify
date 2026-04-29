/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package H1;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class t {
    public static String a(String string, Object ... objectArray) {
        int n2;
        int n3;
        int n4 = objectArray.length;
        StringBuilder stringBuilder = new StringBuilder(string.length() + n4 * 16);
        int n5 = 0;
        for (n4 = 0; n4 < (n3 = objectArray.length) && (n2 = string.indexOf("%s", n5)) != -1; ++n4) {
            stringBuilder.append((CharSequence)string, n5, n2);
            stringBuilder.append(t.b(objectArray[n4]));
            n5 = n2 + 2;
        }
        stringBuilder.append((CharSequence)string, n5, string.length());
        if (n4 < n3) {
            string = " [";
            while (n4 < objectArray.length) {
                stringBuilder.append(string);
                stringBuilder.append(t.b(objectArray[n4]));
                ++n4;
                string = ", ";
            }
            stringBuilder.append(']');
        }
        return stringBuilder.toString();
    }

    private static String b(Object object) {
        if (object == null) {
            return "null";
        }
        try {
            String string = object.toString();
            return string;
        }
        catch (Exception exception) {
            String string = object.getClass().getName();
            String string2 = Integer.toHexString((int)System.identityHashCode((Object)object));
            object = new StringBuilder(string.length() + 1 + String.valueOf((Object)string2).length());
            object.append(string);
            object.append("@");
            object.append(string2);
            object = object.toString();
            Logger.getLogger((String)"com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat((String)object), (Throwable)exception);
            String string3 = exception.getClass().getName();
            string = new StringBuilder(object.length() + 8 + string3.length() + 1);
            string.append("<");
            string.append((String)object);
            string.append(" threw ");
            string.append(string3);
            string.append(">");
            return string.toString();
        }
    }
}

