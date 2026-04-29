/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package b3;

import I2.o;
import b3.b;
import b3.i;
import b3.j;
import b3.k;
import b3.s;
import b3.u;
import b3.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class l
extends i {
    public static /* synthetic */ String b(String string) {
        return l.e(string);
    }

    public static /* synthetic */ String c(String string, String string2) {
        return l.f(string, string2);
    }

    private static final U2.l d(String string) {
        if (string.length() == 0) {
            return new j();
        }
        return new k(string);
    }

    private static final String e(String string) {
        V2.k.e(string, "line");
        return string;
    }

    private static final String f(String string, String string2) {
        V2.k.e(string2, "line");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    private static final int g(String string) {
        int n3;
        block3: {
            int n4 = string.length();
            for (n3 = 0; n3 < n4; ++n3) {
                if (b.c(string.charAt(n3))) {
                    continue;
                }
                break block3;
            }
            n3 = -1;
        }
        if (n3 == -1) {
            return string.length();
        }
        return n3;
    }

    public static final String h(String object5, String string) {
        int n3;
        Object object22;
        V2.k.e(object5, "<this>");
        V2.k.e(string, "newIndent");
        List list = u.Z((CharSequence)object5);
        Object object3 = new ArrayList();
        for (Object object22 : list) {
            if (u.U((String)object22)) continue;
            object3.add(object22);
        }
        Object object4 = new ArrayList(o.o((Iterable)object3, 10));
        int n4 = object3.size();
        int n5 = 0;
        for (n3 = 0; n3 < n4; ++n3) {
            object22 = object3.get(n3);
            object4.add((Object)l.g((String)object22));
        }
        object3 = (Integer)o.F((Iterable)object4);
        n3 = object3 != null ? object3.intValue() : 0;
        n4 = object5.length();
        int n6 = string.length();
        int n7 = list.size();
        object3 = l.d(string);
        int n8 = o.h(list);
        object22 = new ArrayList();
        for (Object object5 : list) {
            if (n5 < 0) {
                o.n();
            }
            string = (String)object5;
            if ((n5 == 0 || n5 == n8) && u.U(string)) {
                object5 = null;
            } else {
                object4 = w.u0(string, n3);
                object5 = string;
                if (object4 != null && (object5 = (String)object3.j(object4)) == null) {
                    object5 = string;
                }
            }
            if (object5 != null) {
                object22.add(object5);
            }
            ++n5;
        }
        return ((StringBuilder)o.A((Iterable)object22, (Appendable)new StringBuilder(n4 + n6 * n7), "\n", null, null, 0, null, null, 124, null)).toString();
    }

    public static final String i(String object, String string, String string2) {
        V2.k.e(object, "<this>");
        V2.k.e(string, "newIndent");
        V2.k.e(string2, "marginPrefix");
        if (!u.U(string2)) {
            Object object2 = u.Z((CharSequence)object);
            int n3 = object.length();
            int n4 = string.length();
            int n5 = object2.size();
            U2.l l3 = l.d(string);
            int n6 = o.h(object2);
            ArrayList arrayList = new ArrayList();
            Iterator iterator = object2.iterator();
            int n7 = 0;
            while (iterator.hasNext()) {
                object = iterator.next();
                if (n7 < 0) {
                    o.n();
                }
                object2 = (String)object;
                string = null;
                if ((n7 == 0 || n7 == n6) && u.U((CharSequence)object2)) {
                    object = null;
                } else {
                    int n8;
                    int n9;
                    block10: {
                        n9 = object2.length();
                        for (n8 = 0; n8 < n9; ++n8) {
                            if (b.c(object2.charAt(n8))) {
                                continue;
                            }
                            break block10;
                        }
                        n8 = -1;
                    }
                    if (n8 != -1 && s.D((String)object2, string2, n8, false, 4, null)) {
                        n9 = string2.length();
                        V2.k.c(object2, "null cannot be cast to non-null type java.lang.String");
                        string = object2.substring(n9 + n8);
                        V2.k.d(string, "substring(...)");
                    }
                    object = object2;
                    if (string != null && (object = (String)l3.j(string)) == null) {
                        object = object2;
                    }
                }
                if (object != null) {
                    arrayList.add(object);
                }
                ++n7;
            }
            return ((StringBuilder)o.A((Iterable)arrayList, (Appendable)new StringBuilder(n3 + n4 * n5), "\n", null, null, 0, null, null, 124, null)).toString();
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.");
    }

    public static String j(String string) {
        V2.k.e(string, "<this>");
        return l.h(string, "");
    }

    public static final String k(String string, String string2) {
        V2.k.e(string, "<this>");
        V2.k.e(string2, "marginPrefix");
        return l.i(string, "", string2);
    }

    public static /* synthetic */ String l(String string, String string2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            string2 = "|";
        }
        return l.k(string, string2);
    }
}

