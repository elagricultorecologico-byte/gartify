/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Object
 */
package b3;

import U2.l;
import V2.k;

abstract class i {
    public static void a(Appendable appendable, Object object, l l3) {
        k.e(appendable, "<this>");
        if (l3 != null) {
            appendable.append((CharSequence)l3.j(object));
            return;
        }
        boolean bl = object == null ? true : object instanceof CharSequence;
        if (bl) {
            appendable.append((CharSequence)object);
            return;
        }
        if (object instanceof Character) {
            appendable.append(((Character)object).charValue());
            return;
        }
        appendable.append((CharSequence)object.toString());
    }
}

