/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ThreadLocal
 *  java.net.MalformedURLException
 *  java.net.URL
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Stack
 *  java.util.regex.Pattern
 */
package E3;

import D3.e;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;
import java.util.regex.Pattern;

public abstract class c {
    static final String[] a = new String[]{"", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          ", "           ", "            ", "             ", "              ", "               ", "                ", "                 ", "                  ", "                   ", "                    "};
    private static Pattern b = Pattern.compile((String)"^/((\\.{1,2}/)+)");
    private static final ThreadLocal c = new ThreadLocal(){

        protected Stack a() {
            return new Stack();
        }
    };

    public static void a(StringBuilder stringBuilder, String string, boolean bl) {
        int n2;
        boolean bl2;
        int n3 = string.length();
        boolean bl3 = bl2 = false;
        for (int i2 = 0; i2 < n3; i2 += Character.charCount((int)n2)) {
            boolean bl4;
            boolean bl5;
            block8: {
                block6: {
                    block7: {
                        n2 = string.codePointAt(i2);
                        if (!E3.c.e(n2)) break block6;
                        if (!bl) break block7;
                        bl5 = bl2;
                        bl4 = bl3;
                        if (!bl2) break block8;
                    }
                    if (bl3) {
                        bl5 = bl2;
                        bl4 = bl3;
                    } else {
                        stringBuilder.append(' ');
                        bl4 = true;
                        bl5 = bl2;
                    }
                    break block8;
                }
                bl5 = bl2;
                bl4 = bl3;
                if (!E3.c.h(n2)) {
                    stringBuilder.appendCodePoint(n2);
                    bl4 = false;
                    bl5 = true;
                }
            }
            bl2 = bl5;
            bl3 = bl4;
        }
    }

    public static StringBuilder b() {
        Stack stack = (Stack)c.get();
        if (stack.empty()) {
            return new StringBuilder(8192);
        }
        return (StringBuilder)stack.pop();
    }

    public static boolean c(String string, String ... stringArray) {
        int n2 = stringArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!stringArray[i2].equals((Object)string)) continue;
            return true;
        }
        return false;
    }

    public static boolean d(String string, String[] stringArray) {
        return Arrays.binarySearch((Object[])stringArray, (Object)string) >= 0;
    }

    public static boolean e(int n2) {
        return n2 == 32 || n2 == 9 || n2 == 10 || n2 == 12 || n2 == 13 || n2 == 160;
        {
        }
    }

    public static boolean f(String string) {
        e.j(string);
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (string.charAt(i2) <= '\u007f') continue;
            return false;
        }
        return true;
    }

    public static boolean g(String string) {
        if (string != null && string.length() != 0) {
            int n2 = string.length();
            for (int i2 = 0; i2 < n2; ++i2) {
                if (E3.c.j(string.codePointAt(i2))) continue;
                return false;
            }
        }
        return true;
    }

    public static boolean h(int n2) {
        return n2 == 8203 || n2 == 173;
        {
        }
    }

    public static boolean i(String string) {
        if (string != null && string.length() != 0) {
            int n2 = string.length();
            for (int i2 = 0; i2 < n2; ++i2) {
                if (Character.isDigit((int)string.codePointAt(i2))) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean j(int n2) {
        return n2 == 32 || n2 == 9 || n2 == 10 || n2 == 12 || n2 == 13;
        {
        }
    }

    public static String k(Collection collection, String string) {
        return E3.c.l(collection.iterator(), string);
    }

    public static String l(Iterator iterator, String object) {
        if (!iterator.hasNext()) {
            return "";
        }
        String string = iterator.next().toString();
        if (!iterator.hasNext()) {
            return string;
        }
        object = new b((String)object);
        ((b)object).a(string);
        while (iterator.hasNext()) {
            ((b)object).a(iterator.next());
        }
        return ((b)object).b();
    }

    public static String m(int n2) {
        if (n2 >= 0) {
            Object[] objectArray = a;
            if (n2 < objectArray.length) {
                return objectArray[n2];
            }
            int n3 = Math.min((int)n2, (int)30);
            objectArray = new char[n3];
            for (n2 = 0; n2 < n3; ++n2) {
                objectArray[n2] = (String)32;
            }
            return String.valueOf((char[])objectArray);
        }
        throw new IllegalArgumentException("width must be > 0");
    }

    public static String n(StringBuilder stringBuilder) {
        e.j(stringBuilder);
        String string = stringBuilder.toString();
        if (stringBuilder.length() > 8192) {
            stringBuilder = new StringBuilder(8192);
        } else {
            stringBuilder.delete(0, stringBuilder.length());
        }
        Stack stack = (Stack)c.get();
        stack.push((Object)stringBuilder);
        while (stack.size() > 8) {
            stack.pop();
        }
        return string;
    }

    /*
     * Loose catch block
     */
    public static String o(String string, String string2) {
        URL uRL = new URL(string);
        return E3.c.p(uRL, string2).toExternalForm();
        {
            catch (MalformedURLException malformedURLException) {
                return "";
            }
        }
        catch (MalformedURLException malformedURLException) {
            Object object = new URL(string2);
            object = object.toExternalForm();
            return object;
        }
    }

    public static URL p(URL object, String string) {
        String string2 = string;
        if (string.startsWith("?")) {
            string2 = new StringBuilder();
            string2.append(object.getPath());
            string2.append(string);
            string2 = string2.toString();
        }
        string2 = new URL(object, string2);
        string = b.matcher((CharSequence)string2.getFile()).replaceFirst("/");
        object = string;
        if (string2.getRef() != null) {
            object = new StringBuilder();
            object.append(string);
            object.append("#");
            object.append(string2.getRef());
            object = object.toString();
        }
        return new URL(string2.getProtocol(), string2.getHost(), string2.getPort(), (String)object);
    }

    public static class b {
        StringBuilder a = E3.c.b();
        final String b;
        boolean c = true;

        public b(String string) {
            this.b = string;
        }

        public b a(Object object) {
            e.j(this.a);
            if (!this.c) {
                this.a.append(this.b);
            }
            this.a.append(object);
            this.c = false;
            return this;
        }

        public String b() {
            String string = E3.c.n(this.a);
            this.a = null;
            return string;
        }
    }
}

