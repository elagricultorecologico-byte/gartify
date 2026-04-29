/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.List
 */
package x1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import x1.n;

public abstract class m {
    public static boolean a(Object object, Object object2) {
        if (object != object2) {
            return object != null && object.equals(object2);
        }
        return true;
    }

    public static int b(Object ... objectArray) {
        return Arrays.hashCode((Object[])objectArray);
    }

    public static a c(Object object) {
        return new a(object, null);
    }

    public static final class a {
        private final List a;
        private final Object b;

        /* synthetic */ a(Object object, byte[] byArray) {
            n.i(object);
            this.b = object;
            this.a = new ArrayList();
        }

        public a a(String string, Object object) {
            n.i(string);
            int n2 = string.length();
            String string2 = String.valueOf((Object)object);
            object = new StringBuilder(n2 + 1 + string2.length());
            object.append(string);
            object.append("=");
            object.append(string2);
            string = object.toString();
            this.a.add((Object)string);
            return this;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(100);
            stringBuilder.append(this.b.getClass().getSimpleName());
            stringBuilder.append('{');
            List list = this.a;
            int n2 = list.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                stringBuilder.append((String)list.get(i2));
                if (i2 >= n2 - 1) continue;
                stringBuilder.append(", ");
            }
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
}

