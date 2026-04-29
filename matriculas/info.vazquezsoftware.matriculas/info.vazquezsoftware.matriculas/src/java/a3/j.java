/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package a3;

import I2.o;
import U2.l;
import V2.k;
import a3.b;
import a3.c;
import a3.d;
import a3.i;
import b3.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class j
extends i {
    public static Iterable c(d d3) {
        k.e(d3, "<this>");
        return new Iterable(d3){
            final d g;
            {
                this.g = d3;
            }

            public Iterator iterator() {
                return this.g.iterator();
            }
        };
    }

    public static d d(d d3, int n3) {
        k.e(d3, "<this>");
        if (n3 >= 0) {
            if (n3 == 0) {
                return d3;
            }
            if (d3 instanceof c) {
                return ((c)d3).a(n3);
            }
            return new b(d3, n3);
        }
        d3 = new StringBuilder();
        d3.append("Requested element count ");
        d3.append(n3);
        d3.append(" is less than zero.");
        throw new IllegalArgumentException(d3.toString().toString());
    }

    public static final Appendable e(d object, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n3, CharSequence charSequence4, l l3) {
        int n4;
        k.e(object, "<this>");
        k.e(appendable, "buffer");
        k.e(charSequence, "separator");
        k.e(charSequence2, "prefix");
        k.e(charSequence3, "postfix");
        k.e(charSequence4, "truncated");
        appendable.append(charSequence2);
        charSequence2 = object.iterator();
        int n5 = 0;
        while (true) {
            n4 = n5++;
            if (!charSequence2.hasNext()) break;
            object = charSequence2.next();
            if (n5 > 1) {
                appendable.append(charSequence);
            }
            if (n3 >= 0) {
                n4 = n5;
                if (n5 > n3) break;
            }
            h.a(appendable, object, l3);
        }
        if (n3 >= 0 && n4 > n3) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String f(d d3, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n3, CharSequence charSequence4, l l3) {
        k.e(d3, "<this>");
        k.e(charSequence, "separator");
        k.e(charSequence2, "prefix");
        k.e(charSequence3, "postfix");
        k.e(charSequence4, "truncated");
        return ((StringBuilder)j.e(d3, (Appendable)new StringBuilder(), charSequence, charSequence2, charSequence3, n3, charSequence4, l3)).toString();
    }

    public static /* synthetic */ String g(d d3, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n3, CharSequence charSequence4, l l3, int n4, Object object) {
        if ((n4 & 1) != 0) {
            charSequence = ", ";
        }
        if ((n4 & 2) != 0) {
            charSequence2 = "";
        }
        if ((n4 & 4) != 0) {
            charSequence3 = "";
        }
        if ((n4 & 8) != 0) {
            n3 = -1;
        }
        if ((n4 & 0x10) != 0) {
            charSequence4 = "...";
        }
        if ((n4 & 0x20) != 0) {
            l3 = null;
        }
        return j.f(d3, charSequence, charSequence2, charSequence3, n3, charSequence4, l3);
    }

    public static List h(d object) {
        k.e(object, "<this>");
        Iterator iterator = object.iterator();
        if (!iterator.hasNext()) {
            return o.g();
        }
        object = iterator.next();
        if (!iterator.hasNext()) {
            return o.b(object);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(object);
        while (iterator.hasNext()) {
            arrayList.add(iterator.next());
        }
        return arrayList;
    }
}

