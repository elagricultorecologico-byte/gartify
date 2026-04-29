/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Comparator
 */
package b1;

import T0.t;
import java.util.Comparator;

final class f2
implements Comparator {
    static final f2 g = new f2();

    private /* synthetic */ f2() {
    }

    public final /* synthetic */ int compare(Object object, Object object2) {
        object2 = (String)object2;
        String string = (String)object;
        object = t.f;
        return object.indexOf((Object)string) - object.indexOf(object2);
    }
}

