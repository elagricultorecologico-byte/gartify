/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.Iterator
 */
package a3;

import V2.k;
import a3.a;
import a3.d;
import a3.g;
import java.util.Iterator;

abstract class h
extends g {
    public static d a(Iterator iterator) {
        k.e(iterator, "<this>");
        return h.b(new d(iterator){
            final Iterator a;
            {
                this.a = iterator;
            }

            @Override
            public Iterator iterator() {
                return this.a;
            }
        });
    }

    public static final d b(d d3) {
        k.e(d3, "<this>");
        if (d3 instanceof a) {
            return d3;
        }
        return new a(d3);
    }
}

