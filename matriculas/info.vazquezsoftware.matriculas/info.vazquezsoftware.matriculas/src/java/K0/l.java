/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collection
 */
package k0;

import V2.k;
import java.util.ArrayList;
import java.util.Collection;

abstract class l {
    public static final ArrayList a(Collection collection) {
        k.e(collection, "<this>");
        if (collection instanceof ArrayList) {
            return (ArrayList)collection;
        }
        return new ArrayList(collection);
    }
}

